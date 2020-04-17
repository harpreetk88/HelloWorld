import org.apache.log4j.{Level, Logger}

object List_operations {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val list1 = List(23,45,32,48,51)
    println(list1.slice(0,3)) //from 0 to 2nd index position

    println(list1.splitAt(2)) //splits the list into 2 parts i.e 1st part(23,45) and 2nd part(32,45,51)
    println(list1.takeRight(2)) //output 48,51
    println(list1.contains(3))
    println(list1.tail)

    val list2 = List(87,67,34,56)
    println(list1 ++ list2)
    val ziplist = list1.zip(list2)
    println("\nzipped list is "+ziplist) //umnatching values will be dropped
    println("\nfirst elements of the zipped file are "+ziplist(0)._1) //output is 23 and ._2 is 87
    println("\nMapped list is "+ziplist.toMap)
    val list3 = List("spark","java","scala","python")
    println("\nSize of elements are "+list3.filter(x=>x.endsWith("k")))
    println("\nsorted list3 is "+list3.sorted)

  }

}
