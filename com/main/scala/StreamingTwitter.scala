import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.twitter._

object StreamingTwitter {
  
   def main(args: Array[String]): Unit = {
      
      System.setProperty("hadoop.home.dir", "C://hadoop//")
      System.setProperty("twitter4j.oauth.consumerKey", "OT8zFJOz6hnlFmo8cR1StiXbS");
	    System.setProperty("twitter4j.oauth.consumerSecret", "noW2AQkcmrdvGxJYCrOMnSEFNb9PFFLvKLQV4g7www7pLOPS1v");
	    System.setProperty("twitter4j.oauth.accessToken", "554122868-ekZlUkgddUAAlaHK1vfwcQip6F5V50Z5RB75qQsV");
	    System.setProperty("twitter4j.oauth.accessTokenSecret", "eODR8jiHLqDI1qhJ99SiOmeuJUG2eVahNfCLM5wpbhzYG");
	    
	    val config = new SparkConf().setAppName("twitter-stream-sentiment").setMaster("local[*]")
	    val sc = new SparkContext(config) 
	    sc.setLogLevel("WARN") 
	    val ssc = new StreamingContext(sc, Seconds(60))  
	    val stream = TwitterUtils.createStream(ssc, None)
	    
	    var statuses = stream.map(rec => rec.getText)
	    
	   //statuses =  statuses.filter(rec => rec.contains("#IPL") || rec.contains("#ipl"))
	    
	    var temp = statuses.flatMap(rec => rec.split(" ")).filter(rec => rec.contains("#")).map(rec => (rec,1)).reduceByKey(_+_)
	    
	   var temp1 =  temp.transform(rec => rec.sortBy(_._2, false, 2))
	    
	    
	    
	    
	    
	      temp1.print(20);
	    
	    
	    
	    
        ssc.start();
        
        ssc.awaitTermination()
     
     //println("karthik")
   }
}