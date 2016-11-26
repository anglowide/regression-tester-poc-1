

import scala.io.Source
import com.typesafe.config.{ConfigFactory, Config}

/**
  * Created by curtisa on 06/11/16.
  */
class RegressionTester {


  val conf: Config  = ConfigFactory.load()

    // Risk reports
//  val riskReportCurrentSrc = Source.fromURL(conf.getString("riskReportCurrent"))                                        // Web server version
  val riskReportCurrentSrc  = Source.fromURL(getClass.getResource(conf.getString("riskReportCurrent")))               // Local resources version
  val riskReportPreviousSrc = Source.fromURL(getClass.getResource(conf.getString("riskReportPrevious")))
  val riskReportCurrentData = riskReportCurrentSrc.getLines().drop(1).map(createRiskReportItem).toList
  val riskReportPreviousData = riskReportPreviousSrc.getLines().drop(1).map(createRiskReportItem).toList

  // IGM Reports
  val igmReportCurrentSrc = Source.fromURL(getClass.getResource(conf.getString("igmReportCurrent")))
  val igmReportPreviousSrc = Source.fromURL(getClass.getResource(conf.getString("igmReportPrevious")))
  val igmReportCurrentData = igmReportCurrentSrc.getLines().drop(1).map(createIGMReportItem).toList
  val igmReportPreviousData = igmReportPreviousSrc.getLines().drop(1).map(createIGMReportItem).toList

  // Trade Reports
  val tradeReportCurrentSrc = Source.fromURL(getClass.getResource(conf.getString("tradeReportCurrent")))
  val tradeReportPreviousSrc = Source.fromURL(getClass.getResource(conf.getString("tradeReportPrevious")))
  val tradeReportCurrentData = tradeReportCurrentSrc.getLines().drop(1).map(createTradeReportItem).toList
  val tradeReportPreviousData = tradeReportPreviousSrc.getLines().drop(1).map(createTradeReportItem).toList


  def createRiskReportItem(line: String): RiskReport = {
    def linePart = line.split(",")
    RiskReport(
      linePart(0),
      linePart(1),
      linePart(2).toDouble,
      linePart(3).toDouble,
      linePart(4).toDouble
    )
  }

  def createIGMReportItem(line: String): IGMReport = {
    def linePart = line.split(",")
    IGMReport(
      linePart(0),
      linePart(1),
      linePart(2),
      linePart(3),
      linePart(4)
    )
  }

  def createTradeReportItem(line: String): TradeReport = {
    def linePart = line.split(",")
    TradeReport(
      linePart(0),
      linePart(1),
      linePart(2).toDouble
    )
  }

}
