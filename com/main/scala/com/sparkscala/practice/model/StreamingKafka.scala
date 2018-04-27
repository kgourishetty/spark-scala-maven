package com.sparkscala.practice.model

import org.apache.spark.streaming._
import org.apache.spark.SparkConf



object StreamingKafka {

  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C://hadoop//")
    val conf = new SparkConf().setMaster("local[*]").setAppName("KafkaReceiver")
   // var sc = new SparkContext(conf)

    val ssc = new StreamingContext(conf, Seconds(10))

    //val kafkaStream = KafkaUtils.createStream(ssc, "103.231.78.229:2181,103.231.78.232:2181,103.231.78.236:2181", "spark-streaming-consumer-group", Map("test" -> 5))

    //kafkaStream.print()

    ssc.start()
    ssc.awaitTermination()
   
    
/*
    System.setProperty("hadoop.home.dir", "C://hadoop//")
    val spark = SparkSession
      .builder
      .appName("Spark-Kafka-Integration")
      .master("local")
      .getOrCreate()

    val df = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "103.231.78.229:2181,103.231.78.232:2181,103.231.78.236:2181")
      .option("subscribe", "test")
      .load()

    df.writeStream
      .format("console")
      .option("truncate", "false")
      .start()
      .awaitTermination()*/

  }

}