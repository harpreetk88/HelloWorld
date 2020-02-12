import org.apache.spark.sql.SparkSession

object joinprac {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("abc").master("local[*]").getOrCreate()
   val data1 = spark.sparkContext.parallelize(List(("harry",10),("harpreet",20),("haseena",30),("harry",10)))

   // data1.collect().foreach(print)*/
    val data2 = spark.sparkContext.parallelize(List(("harry",1000),("preet",2000),("hase",3000)))
    //val result = data1.fullOuterJoin(data2)
   import spark.implicits._
    val res=  data1.toDF("key1","value1")
    val res2 = data2.toDF("key2","value2")
    res2.createOrReplaceTempView("datatable2")
    //res.collect().foreach(println)
    res.createOrReplaceTempView("datatable")
    //res.filter('key1 like "har%").show()
   // res.where('value1>20).show()
    //res.groupBy('key1).count().show()
    //res.orderBy('value1).showw()

  }

}
