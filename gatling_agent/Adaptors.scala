import io.gatling.core.Predef._
import io.gatling.http.Predef._


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

object HuaWei {

	val auth = exec(http("hw.auth")
		.post("/LoginAuth/")    					//post uri
		.header("Content-Type", "application/json")	//设置body数据格式
													//将json参数用StringBody包起,并作为参数传递给function body()
		.body(StringBody("""{	
	"appid": "500006",
	"channelData": {
			"appId": "10825396",
			"gameAuthSign": "Tvb2jy5h8FrBZXSM1rjsp1nZ9qDGHETKXxzI2wDuV9enHBQTS6hpNCDvjnGa4qlfxq3mdbu4/ug2uNT6kKppu4HRfWcCqiOo8UgYiQyAhBiI2mEeiMotw0QLBHQpRN//idEYO1LgviNHPCpcOutMrhxv+ra/bBlNOclCNYIZTgUEokuLNeMosI5NSqnp6p8mBsAqnCT0cTawaz/hJvy4KfAeON1at9SEc/fxzcsEoGeAO7jYK06wcrH3BYpkRCWf5ryi9aS/B71L0dFau+NhmtNpFI2pH8kI+dOgiRBkMkDgZSt4NRsv76HklE15EWn+oMLaUYNvmiZmDC5XtlO9HA==",
			"playerId": "260086000050576790",
			"ts": "1490250993465"
	},
	"channelId": "HW"
}"""))
		.asJSON
		.check(
			//token过期，code=440, msg="session timeout"
			jsonPath("$.code").ofType[Int].is(440).saveAs("code"),
			jsonPath("$.msg").ofType[String].is("session timeout")
			// jsonPath("$.code").ofType[Int].is(0)
		)
	).pause(1)

}

object FeiLiu {

	// val strJSON = Jackson.parse(getClass.getResourceAsStream("/t_fl.json"), UTF_8)

	val auth = exec(http("fl.auth")			//name for this http action
		.post("/LoginAuth/")    			//post uri
		.header("Content-Type", "application/json")
											//将json参数用StringBody包起,并作为参数传递给function body()
		.body(StringBody("""{
"appid": "500006",
"channelData": {
"sign": "D+5+V32UMXn4Fpios0/WV/3n2jvJrTDs2o01q1NCg0qgz3BX1fvhDMFH1F2pM9wiC0pQaGEnXTw7k64e3mINq5rAYb0IyEr81xB2/3sqGUW8MDCTMl4zBe7cVsbklV1Oavp0/ZAolGxscOuKUVwUG2hQwsn0JhUZnbUSUSHsa9pUQHjygXk4riBMUZ503o+XetCB0EmA1eKjv++JsXFXI7TcfL99egwvuvs+BU2ahwkmjEgCeaAcNnPZrNyYsWqWwUh7Af/gWa3TstCrY8ymrO56HMhXco33zqmNuxMVsR/1XylZJjp0Au/hfREPLyJXOJ3rRPl6YBEGyTmKsmFpZA==",
"userId": "1158818",
"timestamp": "1491531912"
},
"channelId": "FL",
"userId": "1158818"
}"""))
		.asJSON
		.check(
			jsonPath("$.code").ofType[Int].is(0).saveAs("code")
			// jsonPath("$.code").ofType[Int].is(0)
		)
	).pause(1)

}

object SamSung {

	// val strJSON = Jackson.parse(getClass.getResourceAsStream("/t_fl.json"), UTF_8)

	val auth = exec(http("sx.auth")			//name for this http action
		.post("/LoginAuth/")    			//post uri
		.header("Content-Type", "application/json")
											//将json参数用StringBody包起,并作为参数传递给function body()
		.body(StringBody("""{
"appid": "500006",
"channelVer": "3.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.233.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.23.0.2.0.23.0.23.0.23.0.23.0.2",
"channelId": "SX",
"channelData": {
    "iapppayUserid": "26595321",
    "samGlobalID": "fj0qfcuj7d",
    "tokenMsg": "E5YKyJpmv7tYMuRnti20TXYzY",
    "signValue": "UserID=26595321&LoginName=fj0qfcuj7d&t=1495701279&Sign=QpHFQejqGJWqUgi9A/gxkNkn4xBFsjHHxwowadNDGru+jeCDuYk7EO6RdkBREp4LRBXbH9OyKbrG+ngx8n3B6WpdTKXd5w6wpb/RMNG4+8beqFMxroQGsoYtmjgvE8+F0xhrpUk8OUdl7vvg2H6d2N/yjuPGk2YyM+sFJzxdLmI="
}
}"""))
		.asJSON
		.check(
			jsonPath("$.code").ofType[Int].is(0).saveAs("code")
			// jsonPath("$.code").ofType[Int].is(0)
		)
	).pause(1)

}

object YiWan {

	// val strJSON = Jackson.parse(getClass.getResourceAsStream("/t_fl.json"), UTF_8)

	val auth = exec(http("yw.auth")			//name for this http action
		.post("/LoginAuth/")    			//post uri
		.header("Content-Type", "application/json")
											//将json参数用StringBody包起,并作为参数传递给function body()
		.body(StringBody("""{
"appid": "500006",
"certified": false,
"channelData": {
    "openid": "105510880Ewan1000097f04edb042321d2add40688a6c4047f",
    "sign": "e66be40b6a7be07f33cc6fd7de11f3f4",
    "timestamp": 1494326538486,
    "token": "1494326538486"
},
"channelId": "YW",
"channelVer": "2.2.0",
"code": -1
}"""))
		.asJSON
		.check(
			jsonPath("$.code").ofType[Int].is(0).saveAs("code")
			// jsonPath("$.code").ofType[Int].is(0)
		)
	).pause(1)

}