package com.evoke.nlp.poc

import org.apache.spark._

object SparkNlpJob {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C://hadoop//")

    var conf = new SparkConf().setAppName("Attendance Agg Job").setMaster("local[*]")
    var sc = new SparkContext(conf)
    
    var data = sc.textFile("c://hadoop//UHC//")
    var head = data.first()
    //println(data.count())    
    data = data.filter(rec => rec != head)
     //println(data.count())   
    var dataMap = data.map(rec => (rec.split(";")(1) , rec.split(";")(4)))
    
    dataMap.take(100).foreach(println)
    
    
  }

}