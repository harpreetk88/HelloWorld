object SingletonEx {
  def main(args: Array[String]): Unit = {
    Hello.display()
  }

}

object Hello  // Hello is a singleton object
{
  def display(): Unit =
  {
    println(" Inside Singleton object ")
  }
}
