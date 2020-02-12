import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object Joins {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder().appName("joins example").master("local[*]").getOrCreate()
    import spark.implicits._
    val data1  = spark.sparkContext.parallelize(List( ("Spark",10),("Scala",20),("Java",30) ))

    val data2  = spark.sparkContext.parallelize(List( ("Phython","PaltformDep"),("Scala","JVM"),("Spark","Cache") ))

    val df1 = data1.toDF("tech","rating")
    df1.show()
    val df2 = data2.toDF("tech","nature")
    df2.show()

    df1.join(df2,df1.col("tech").equalTo(df2.col("tech")),"left_outer")
      .show()
  }

}
