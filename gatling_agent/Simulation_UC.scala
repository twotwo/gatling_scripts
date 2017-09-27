import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
// import Adaptors._
/** 
  * @author LiYan
  * bin/gatling.sh -sf /opt/local/ide/git_storage/github/gatling_scripts/gatling_agent -s Simulation_UC -rd " [Duration=100s, Concurrent=100 Fake UC + 100 HW/FL/SX/YW]"
  * 
  * 
  */
class Simulation_UC extends Simulation {

	// object are native Scala singletons
	object FakeUC {
		//lauch local server to response the auth
		val auth = exec(http("uc.auth")
			.post("/LoginAuth/")    					//post uri
			.header("Content-Type", "application/json")	//设置body数据格式
														//将json参数用StringBody包起,并作为参数传递给function body()
			.body(StringBody("""{
		"appid": "000000",
		"channelData": {
			"accessToken": "ssh1game42ce7361830d4eeab5f191c6daea78f2142497"
		},
		"channelId": "UC"
	}"""))
			.asJSON
			.check(
				//0: local server is work; 500: can't access fake server
				jsonPath("$.code").ofType[Int].in(0, 500)
				// jsonPath("$.code").ofType[Int].is(0)
			)
		)

	}

	val httpConf = http
		.baseURL("http://localhost:8000/api")
		// .disableWarmUp
		// .disableCaching

	// Now, we can write the scenario as a composition 
	// val scn_post = scenario("Token auth by Post to Channel Server")
	// 	.exec(FakeUC.auth)
	// 	// .exec(session => {
	// 	// 	// println(session)
	// 	// 	println("code = "+ session.get("code").asOption[Int])
	// 	// 	session
	// 	// })

	var users = 20
	val duration = 100 //1 minute and 40 seconds

	val scn_post = scenario("Token auth by Post to Channel Server")
		.exec(FakeUC.auth)

	val scn_post_repeat = scenario("Token auth by Post to Channel Server")
		.during(duration) {
			exec(FakeUC.auth).pause(5)
		}

	setUp(
		scn_post_repeat.inject(
			constantUsersPerSec(users) during(duration)
			// rampUsers(5*10000) over(5) 
			// splitUsers(50*10000) into( rampUsers(5*10000) over(5) ) separatedBy(10)
			)

		).protocols(httpConf)
}