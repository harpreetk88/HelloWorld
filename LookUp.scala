import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object LookUp {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)

    val spark = SparkSession.builder().appName("Finding valid year").master("local[*]").getOrCreate()
    //println("enter the file path")
    val df1 = spark.read.option("header","true").option("inferSchema","true").option("delimiter",",")
      .csv(args(0))
    // df1.show()
    df1.createOrReplaceTempView("tempname")
    spark.sql("select split(transaction_date, '-')[2] from tempname").show()
    val df2 = spark.read.option("delimiter",",").option("header","true").option("inferSchema","true")
      .csv("C:\\Users\\Harpreet\\IdeaProjects\\HelloWorld\\src\\main\\scala\\lookupFile")

    df2.createOrReplaceTempView("tempname1")
    // df2.show()
    import spark.implicits._
    val addCol = df1.withColumn("year", $"transaction_date".substr(7,4))
    // addCol.show()
    addCol.createOrReplaceTempView("addCol")
    // spark.sql("select * from tempname where split(transaction_date, '-')[2] in (select valid_year from tempname1)").show()
    // val addcol = df1.map( x => x.split("-")))

    spark.sql("select * from tempname1 b  left join addCol a on a.year=b.valid_year").show()
    // df2.show()


  }
}
