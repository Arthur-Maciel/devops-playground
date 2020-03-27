package gocalculator

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class HistoryStressTest extends Simulation {

  val httpConf = http
    .baseUrl("http://0.0.0.0:8081") 
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .disableFollowRedirect
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Simple Stress Test")
          .exec(http("Testing /calc/history request") 
            .get("/calc/history")
            .check(status.is(200))
          )
    
  setUp(
      scn.inject(constantUsersPerSec(200).during(120 seconds))
  ).protocols(httpConf)  
}