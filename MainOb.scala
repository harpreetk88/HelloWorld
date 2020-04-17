class parentclass
{
  def display(): Unit ={
    println("this is the method of parent class")
  }
}
class childclass extends parentclass
{
  override def display(){
  println("inside subclass")
}
}
object MainOb {
  def main(args: Array[String]): Unit = {
    val ob = new childclass()
    ob.display()
  }
}
