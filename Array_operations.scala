import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object Array_operations {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.OFF)

    val spark = SparkSession.builder().appName("array").master("local[*]").getOrCreate()
    val x = Array(1,2,3,4,5)
    println("length of the array is "+x.length)
    for(i<- x)
      {
        print("\n Array elemenots are "+i)
      }
    println("\n2nd element is "+x(1))

    val itr = Iterator(23,34,45,56,67)
    println("iterator elements are ")
    while(itr.hasNext)
      {
        println(itr.next())
      }
    //println("max iterator element is "+itr.max)
  }

}
