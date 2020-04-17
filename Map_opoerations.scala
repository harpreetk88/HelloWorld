import org.apache.log4j.{Level, Logger}

object Map_opoerations {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val map1 = Map("hadoop"->"bigdata","spark"->"in_memory","IoT"->"AI")
    //println("keys are "+map1.keys)
    //println("values are "+map1.values)
    //println(map1.mapValues(x=>x.length)) //output Map(hadoop -> 7, spark -> 9, IoT -> 2)
    //println(map1.get("hadoop")) //works with keys only o/p Some(bigdata)

    val a = (10,20,30)
    a.productIterator.foreach(i => println("value is "+i))
    val b = Array(Array(1,2),Array(3,4)).flatten
    b.foreach(println)


  }

}
