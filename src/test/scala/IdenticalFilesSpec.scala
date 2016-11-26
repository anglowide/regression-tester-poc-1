import org.specs2.mutable._

class IdenticalFilesSpec extends Specification {

  val regressionTester = new RegressionTester()

  "RegressionTester" should {
    "when checking the previous and current Risk files must" in {
      "have the same number of positions" in {
        regressionTester.riskReportPreviousData.size must beEqualTo( regressionTester.riskReportCurrentData.size )
      }

      "have the same funds" in {
        val fundsInPrevious = regressionTester.riskReportPreviousData.flatMap( p => p.fund)
        val fundsInCurrent = regressionTester.riskReportCurrentData.flatMap( p => p.fund)
        fundsInPrevious must beEqualTo( fundsInCurrent )
      }

      "both have the 2 funds 'ABC' and 'DEF' " in {
        val fundsInPrevious = regressionTester.riskReportPreviousData.map( p => p.fund).distinct
        val fundsInCurrent = regressionTester.riskReportCurrentData.map( p => p.fund).distinct
        fundsInPrevious must beEqualTo(List("ABC", "DEF"))
        fundsInCurrent must beEqualTo(List("ABC", "DEF"))
      }

      "both have position 'ABC-3' with a value of 3,300,000" in {
        val abc3Previous: Double = regressionTester.riskReportPreviousData.find(p => p.position == "ABC-3").get.value
        val abc3Current: Double = regressionTester.riskReportCurrentData.find(p => p.position == "ABC-3").get.value

        abc3Previous must beEqualTo( 3300000 )
        abc3Current must beEqualTo( 3300000 )
      }
    }
  }
}