import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object for_loop {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.OFF)

    val spark = SparkSession.builder().appName("for").master("local[*]").getOrCreate()
    var a = 0;
    val list = List("ram","shyam","sita")
    val retval = for (a <- list if a=="ram") yield a  // generator operator
    //now printing the returned values using another for loop
    for(a<- retval)
    {
      println("value of list elements are "+retval)

    }
  }

}
