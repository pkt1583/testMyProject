package CodingInterview

/**
 * Created by pankaj on 27/9/16.
 */
def scanner=new Scanner(System.in)
def numberOfInput=scanner.nextInt()
def number=new int[numberOfInput]
def numberOfRotation=scanner.nextInt()
numberOfRotation=numberOfRotation%numberOfInput
numberOfInput.times {
    number[it]=scanner.nextInt()
}
def newArray=new int[numberOfInput]
//for(int i=0;i<numberOfRotation;i++){
  /*  int firstElement=number[0]
    for(int j=0;j<number.length-1;j++){
        number[j]=number[j+1]
    }
    number[number.length-1]=firstElement*/
    System.arraycopy(number,numberOfRotation,newArray,0,numberOfInput-numberOfRotation)

    System.arraycopy(number,0,newArray,numberOfInput-numberOfRotation,numberOfInput-(numberOfInput-numberOfRotation))
//}

//5 3
newArray.each {
    print(it+" ")
}