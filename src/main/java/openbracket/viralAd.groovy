package openbracket

import static java.lang.Math.floor

def scanner=new Scanner(System.in)
int numberOfDays=scanner.nextInt()

int output=new Solution(numberOfDays:numberOfDays).getLikedPeople(5)

println(output)
//println floor(5/2)

class Solution{
    int numberOfDays=0
    int counter=1
    def getLikedPeople(number){
        int total=0
        int numberOfPeople=5
        int numberOfpeopleLikedforThatDay=0
        int sum=0
        for (int i = 0; i < numberOfDays; i++) {
            if(i==0){
                numberOfpeopleLikedforThatDay=getLiked(number)
            }else {
                total=numberOfpeopleLikedforThatDay*3
                numberOfpeopleLikedforThatDay=getLiked(total)
            }
            sum=sum+numberOfpeopleLikedforThatDay
        }
        return sum

    }

    def getLiked(number){
        return floor(number/2)
    }

}
