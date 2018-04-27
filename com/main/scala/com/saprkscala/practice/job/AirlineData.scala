package com.saprkscala.practice.job

import com.sparkscala.practice.model.AttendanceEntry
import java.sql.Date
import java.util.Calendar

object AirlineData {
  
  def main(args: Array[String]): Unit = {
  
    println("date")
    
    var simple = new AttendanceEntry(Calendar.getInstance.getTime(),1L,540,"testin","testout")
    
    
    
  }
  
}