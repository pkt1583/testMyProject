def scanner = new Scanner(System.in)
def sortedElements = [:] as TreeMap
Integer totalNumberOfInput = scanner.nextInt();
def input = new int[totalNumberOfInput]
def summation=0
totalNumberOfInput.times {
    input[it] = scanner.nextInt()
    summation=summation+input[it]
    sortedElements[input[it]]=sortedElements[input[it]]?sortedElements[input[it]]+1:0
}

//println(summation/totalNumberOfInput)
int middleNumber=totalNumberOfInput/2
sortedElements.eachWithIndex { element,index ->
    println(index)
}
//println(totalNumberOfInput/2)

//println(sortedElements)