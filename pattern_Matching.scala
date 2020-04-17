import org.apache.log4j.{Level, Logger}

object pattern_Matching {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)

    val days = List("mon","tue","wed")
    println(matchDays("mon"))

    def matchDays(x: String) = x match {
      case "mon" => "it is the first day of the week";
      case "tue" => "it is the second day of the week";
      case "_" => "not found";
    }

    val technologies = List("linux","windows","MacOS","Eclipse","NetBeans","Scala","java","python")
    for(tech <- technologies)
      {
        println(tech)
        tech match {
          case "windows"|"linux"|"MacOS" => println("operating systems")
          case "java"|"python"|"scala" => print("prog languages")
          case "eclipse"|"NetBeans" => print("IDEs")
          case _ => println("not a tech group member")
        }
      }
  }
}
