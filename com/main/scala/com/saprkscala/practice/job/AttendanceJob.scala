package com.saprkscala.practice.job

import org.apache.spark._

object AttendanceJob {
  def main(args: Array[String]): Unit = {
    println("testing")
    var conf = new SparkConf().setAppName("Attendance Agg Job").setMaster("local[*]")
    var sc = new SparkContext(conf)
    
    var list = List(1,2,3,4,5,6)
    
    var data = sc.parallelize(list)
    
    println(data.count())
    
    println(data.collect.toList)
    
  }
}