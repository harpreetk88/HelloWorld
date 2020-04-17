import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object Account_details {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder().appName("Account").master("local[*]").getOrCreate()

    val accdf = spark.read.option("inferSchema","true")
      .csv("C:\\Users\\Harpreet\\IdeaProjects\\HelloWorld\\src\\main\\scala\\AccountDetails.txt")
        .toDF("id","holder_name","type","bankname","amount")

    //accdf.show(5)
    import spark.implicits._
    //accdf.filter('amount>50000).select('id,'bankname,'amount).show()
    //accdf.where('amount > 50000 && 'amount <70000).orderBy('bankname.desc).show()
    //accdf.sort('bankname).show()
    //accdf.drop('amount).show(5)
      accdf.filter('amount>50000).orderBy('bankname.desc).show()

  }

}
