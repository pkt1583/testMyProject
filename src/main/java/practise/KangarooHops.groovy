package practise

import static java.lang.Math.abs

/**
 * Created by pankaj on 5/9/16.
 */

int firstStartPosition
int secondStartPosition
int firstHops
int secondHops
def scanner=new Scanner(System.in)
firstStartPosition=scanner.nextInt()
firstHops=scanner.nextInt()
secondStartPosition=scanner.nextInt()
secondHops=scanner.nextInt()

if((secondStartPosition>=firstStartPosition) && (secondHops>firstHops)){
    print("NO")
}

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
}