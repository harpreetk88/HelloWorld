import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object while_loop {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder().appName("whileloop").master("local[*]").getOrCreate()
    var a = 0;
    do
      {
        println("value of a "+a)
        a = a+1
      }while (a<10)


  }

}
