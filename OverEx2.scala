class parent
{
  def sum(x:Int,y:Int): Unit =
  {
    var result = x+y
    println("In parent sum is "+result)
  }
}
class child extends parent
{
  override def sum(p:Int,q:Int): Unit =
  {
    var result = p+q
    println("in child class sum is "+result.toFloat)
  }
}
object OverEx2 {
  def main(args: Array[String]): Unit = {
    val ob = new child()
    ob.sum(10,20)
  }
}
