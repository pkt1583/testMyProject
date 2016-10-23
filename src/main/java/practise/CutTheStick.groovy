package practise

def scanner=new Scanner(System.in)
def intialStick=new int[scanner.nextInt()]
intialStick.length.times {
    intialStick[it]=scanner.nextInt()
}

int min=Integer.MAX_VALUE
intialStick.each {
    min=Math.min(it,min)
}
def output=new StickCutterImpl().startProcess(Arrays.asList(intialStick),min)

println intialStick.length

output.each {
    if(it!=0)
    println(it)
}

class StickCutterImpl{

    def outputList=[]
    def startProcess(List sticks,int min){
        if(sticks.size()==0){
            return outputList
        }
        def newMin=Integer.MAX_VALUE
        def newStick=[]
        sticks.eachWithIndex { int element, int index ->
            int newElement=element-min
            if(newElement!=0){
                newMin=Math.min(newElement,newMin)
                newStick<<newElement
            }
        }
         outputList.add(newStick.size())
        startProcess(newStick,newMin)
    }
}


