package openbracket


new FraudSolution().startProcess()

class FraudSolution{
    def startProcess(){
        def scanner=new Scanner(System.in)
        int n=scanner.nextInt()
        int d=scanner.nextInt()

        def elements=new int[n]
        n.times {
            elements[it]=scanner.nextInt()
        }

        def sortedElement
        def notification=0
        def median=0;
        for(int i=0;i+d<n;i++){
            sortedElement=Arrays.copyOfRange(elements,i,i+d)
            Arrays.sort(sortedElement)
         //   Collections.sort(sortedElement)
            def numberItems=sortedElement.size()
            def midNumber = (int)(numberItems/2)
            median=numberItems %2 != 0 ? sortedElement[midNumber] : (sortedElement[midNumber] + sortedElement[midNumber-1])/2
           // sortedElement.clear()
            if(elements[i+d]>=2*median){
                notification++
            }
        }

        println notification
    }
}


