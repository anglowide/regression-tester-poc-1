/**
  * Created by curtisa on 07/11/16.
  */
case class IGMReport (
  fund: String,
  guidelineId: String,
  guidelineName: String,
  status: String,
  comment: String
)

object IGMReport{
  def fund(f: String): String = f
  def guidelineId(f: String): String = f
  def guidelineName(f: String): String = f
  def status(f: String): String = f
  def comment(f: String): String = f
}
