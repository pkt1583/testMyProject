package practise

def scanner=new Scanner(System.in)

def elements=[:] as TreeMap
def numberOfInput=scanner.nextInt()
def divisibleBy = scanner.nextInt()
def elementsArray=new Integer[numberOfInput]
numberOfInput.times {
    Integer key=scanner.nextInt()
    elementsArray[it]=key
    List<Integer> indexes=elements.get(key)
    if(indexes==null){
        indexes=new LinkedList<>()
    }
    indexes<<it
    elements.put(key,indexes)
}

def keySet=elements.keySet()

def output=[] as Set

def counter=0
for(int i=0;i<keySet.size();i++){
    Integer iElement=keySet.getAt(i)
    for(int j=i;j<keySet.size();j++){
        Integer jElement=keySet.getAt(j)
        if((iElement+jElement)%divisibleBy==0){
            def iValues=elements.get(iElement)
            def jValus=elements.get(jElement)
            iValues.each { ival->
                jValus.each { jval->
                    if(ival<jval) {
                        if(((elementsArray[ival]+elementsArray[jval])%divisibleBy==0)) {
                            // if(ival<jval) {
                            counter++
                            output << Integer.parseInt("$ival$jval")
                            // }
                        }
                    }
                }
            }
            jValus.each { ival->
                iValues.each { jval->
                    if(ival<jval) {
                        if(((elementsArray[ival]+elementsArray[jval])%divisibleBy==0)) {
                            // if(ival<jval) {
                            counter++
                            output << Integer.parseInt("$ival$jval")
                            // }
                        }
                    }
                }
            }
        }
    }

}

int outputSize=output.size()

print(outputSize)


