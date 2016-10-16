package practise

import static java.lang.Math.abs

/**
 * Created by pankaj on 5/9/16.
 */

double firstStartPosition
double secondStartPosition
double firstHops
double secondHops
def scanner=new Scanner(System.in)
firstStartPosition=scanner.nextDouble()
firstHops=scanner.nextDouble()
secondStartPosition=scanner.nextDouble()
secondHops=scanner.nextDouble()

if((secondStartPosition>=firstStartPosition) && (secondHops>firstHops)){
    println("NO")
    return
}

double result=(firstStartPosition-secondStartPosition)/(secondHops-firstHops)

if(result.intValue()==result){
    println "YES"
}else {
    println("NO")
}
/*
int commonVal=firstHops*secondHops

int next=2
while (true) {
    if (abs((commonVal - firstStartPosition)) / firstHops == abs((commonVal - secondStartPosition)) / secondHops) {
        //println((commonVal - firstStartPosition) / firstHops)
        println "YES"
        break;
    }else {
        commonVal=commonVal*next
        next++
    }
}*/
