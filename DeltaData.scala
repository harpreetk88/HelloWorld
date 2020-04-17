import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object DeltaData extends App {
  Logger.getLogger("org").setLevel(Level.OFF)
  val spark = SparkSession.builder().appName("abc").master("local[*]").getOrCreate()

    val jandf = spark.read.option("header","true")
      .option("inferSchema","true")
      .csv("C:\\Users\\Harpreet\\IdeaProjects\\HelloWorld\\src\\main\\scala\\January")
    //jandf.show()
  jandf.printSchema()
    jandf.createOrReplaceTempView("jandf")

  val febdf = spark.read.option("header","true")
    .option("inferSchema","true")
    .csv("C:\\Users\\Harpreet\\IdeaProjects\\HelloWorld\\src\\main\\scala\\February")
    //febdf.show()
   febdf.printSchema()
  febdf.createOrReplaceTempView("febdf")

  val deltadf = spark.sql("""select * from febdf where id not in(select id from jandf)""")
  deltadf.show()

  val deltadf2 = spark.sql("""select * from jandf where id not in(select id from febdf)""")
    deltadf2.show()

  val deltadf3= spark.sql("select febdf.* from febdf join jandf on febdf.id = jandf.id and febdf.salary != jandf.salary")

  val result = deltadf.union(deltadf2).union(deltadf3)
  println(result.printSchema())
  result.show()

}
