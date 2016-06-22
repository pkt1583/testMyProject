package amaft

def scanner=new Scanner(new BufferedReader(new InputStreamReader(System.in)))
def numberOfCases=scanner.nextInt()
numberOfCases.times {
    int inputValues=scanner.nextInt()
    List<Integer> values=[]
    inputValues.times {
        values<<scanner.nextInt()
    }
      println( printMaxArray(values))
}

def printMaxArray(values){
    def    max = 0
   def currentMax = 0
    def minimumValForAllNegative=values.first()
    def nonnegativeMax=0
        values.each{
            if(it>0){
                nonnegativeMax=nonnegativeMax+it
            }
            if(it>minimumValForAllNegative){
                minimumValForAllNegative=it
            }
            currentMax = currentMax + it
            if (currentMax < 0) {
                currentMax = 0
            }
            if (max < currentMax) {
                max = currentMax
            }
        }
    if(nonnegativeMax==0){
        nonnegativeMax=minimumValForAllNegative
    }
    if(max==0 && nonnegativeMax<0){
        max=nonnegativeMax
    }
    return "$max $nonnegativeMax"
}


