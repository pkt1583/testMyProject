package com.hrank.easy

import java.util.Scanner

object GradingStudent {
  def main(args: Array[String]): Unit = {
    val scanner=new Scanner(System.in)
    1 to scanner.nextInt() foreach {_=>
      val grade=scanner.nextInt()
      var number=grade/5
      if(grade%5!=0){
        number=number+1
      }
      if(Math.abs(grade-number)<3 && grade<38){
        println(number)
      }
      println(number*5)
    }
  }
}
