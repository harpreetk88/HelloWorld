class compan{
  def hello(){
    println("Inside companion class")
  }
}
object Compan {
  def main(args: Array[String]): Unit = {
    new compan().hello()

  }

}
