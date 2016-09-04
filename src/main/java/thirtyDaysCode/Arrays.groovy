package thirtyDaysCode

/**
 * Created by pankaj on 3/9/16.
 */

def scanner=new Scanner(System.in)
int  numberOfCases=scanner.nextInt()
String convertedValue= Integer.toString(numberOfCases,2)
int maxConsecutiveValue=0
int consecutiveNumberCound=0;
convertedValue.toCharArray().each {
    if(it=='1'){
        consecutiveNumberCound=consecutiveNumberCound+1
        if(consecutiveNumberCound>=maxConsecutiveValue){
            maxConsecutiveValue=consecutiveNumberCound
        }
    }else {
        consecutiveNumberCound=0
    }
}

print(maxConsecutiveValue)