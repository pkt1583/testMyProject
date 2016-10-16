package CodingInterview

/**
 * Created by pankaj on 28/9/16.
 */
def input1 = [:]
def input2 = [:]
def scanner = new Scanner(System.in)
int numberOfChars=0;
def first=scanner.next();
first.each {
    Integer numberOfOccurance = input1.get(it)
    if (numberOfOccurance == null) {
        numberOfOccurance = 0
    }
    input1.put(it, ++numberOfOccurance)
    numberOfChars++
}
def second=scanner.next()
second.each {
    Integer numberOfOccurancce = input2.get(it)
    if (numberOfOccurancce == null) {
        numberOfOccurancce = 0
    }
    input2.put(it, ++numberOfOccurancce)
    numberOfChars++
}

for(String st in "a".."z"){
   if(input2.get(st).equals(input1.get(st))){
       int tobedeleted=input2.get(st)
       numberOfChars=numberOfChars-tobedeleted
       println(numberOfChars)
       println(tobedeleted)
       input1.remove(st)
       input2.remove(st)
   }
}
int count = numberOfChars

println(count)

println(numberNeeded(first,second))
def  numberNeeded(String first, String second) {
    int[] occurrences = new int[26];
    for (int i = 0; i < first.length(); i++) {
        occurrences[first.charAt(i) - 'a']++;
    }
    for (int j = 0; j < second.length(); j++) {
        occurrences[second.charAt(j) - 'a']--;
    }

    int numberNeeded = 0;
    for (int k = 0; k < 26; k++) {
        numberNeeded += Math.abs(occurrences[k]);
    }
    return numberNeeded;
}