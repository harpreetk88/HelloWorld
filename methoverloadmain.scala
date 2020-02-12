class MethodOverLoadClass
{
  def avg(x:Int,y:Int)
  {
    var av = (x+y)/2
    println("Average Of 2 numbers = " + av.toFloat)
  }
  def avg(x:Int,y:Int,z:Int)
  {
    var av = (x+y+z)/3
    println("Average Of 3 numbers = " + av.toDouble)
  }
}
object methoverloadmain
{
  def main(args:Array[String])
  {
    var methoverload  = new MethodOverLoadClass();
    methoverload.avg(5,3);
    methoverload.avg(5,3,2);
  }
}  