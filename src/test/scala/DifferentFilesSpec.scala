import org.specs2.mutable._

class DifferentFilesSpec extends Specification {

  val regressionTester = new RegressionTester()

  "RegressionTester" should {

    "when checking the previous and current trade files must" in {
      "NOT have the same number of trades" in {
        val tradesInPrevious = regressionTester.tradeReportPreviousData
        val tradesInCurrent = regressionTester.tradeReportCurrentData
        tradesInPrevious must_!= tradesInCurrent
      }
    }

    "when checking the current trade file must" in {
      "have a test trade with an id of TR-006 and a MV of 10,000,000" in {
        val tradesInPrevious = regressionTester.tradeReportPreviousData
        val tradesInCurrent = regressionTester.tradeReportCurrentData
        tradesInPrevious.find( p => p.tradeId == "TR-006") must beEmpty
        tradesInCurrent.find( p => p.tradeId == "TR-006").get.mv must beEqualTo( 1.0E8 )
      }
    }

    "when checking the previous and current IGM files must" in {
      "have the same number of guidelines" in {
        val guidelinesInPrevious = regressionTester.igmReportPreviousData.flatMap( p => p.guidelineId)
        val guidelinesInCurrent = regressionTester.igmReportCurrentData.flatMap( p => p.guidelineId)
        guidelinesInPrevious must beEqualTo( guidelinesInCurrent )

      }

      "show a failure for the Guideline GL-002 because of the test trade that is over 10mio" in {
        val gl002InDEFPrevious = regressionTester.igmReportPreviousData.find(p => (p.guidelineId == "GL-002") & (p.fund == "DEF") ).get
        val gl002InDEFCurrent = regressionTester.igmReportCurrentData.find(p => (p.guidelineId == "GL-002") & (p.fund == "DEF") ).get
        gl002InDEFPrevious.status must beEqualTo("Pass")
        gl002InDEFCurrent.status must beEqualTo("Fail")
      }
    }
  }
}