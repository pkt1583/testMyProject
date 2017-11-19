package techgig

import scala.Int

class SweetBuy {
    /*
    * possible ways 1 1,2 1,2,3 2 2,3 3
     */
    private static Integer modulo=1000000007
    public static void main(String[] args) {
        def scanner=new Scanner(System.in)
        int numberOfLines=scanner.nextInt()
        Integer[] inputCases=new Integer[numberOfLines]
        numberOfLines.times {
            inputCases[it-1]=scanner.nextInt()
        }
        startProcess(inputCases)
    }

    static void startProcess(Integer[] integers) {
        LinkedList<Collection<Integer>> returnList=new LinkedList<>()
        integers.eachWithIndex { element,index->
            def tempList=[]
            tempList<<element
            returnList<<tempList
            for(int i=index+1;i<integers.length;i++){
                def newtempList=[]
                newtempList.addAll(returnList.last)
                newtempList<<integers[i]
                returnList<<newtempList
            }
        }
        Integer finalAnswer=0
        println returnList
        returnList.each {
            Integer maxElement=it.last()
            Integer answer=0
            it.each { e->
                 answer=(answer+e*maxElement)%modulo
            }
            finalAnswer=finalAnswer+answer
        }
        println finalAnswer
    }
}
