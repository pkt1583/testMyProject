package codeSprint

def scanner = new Scanner(System.in)
def count =scanner.nextInt()
def wordPosition = [:]
def words = []
def word =scanner.next()
word.eachWithIndex { oneWord, index->
    words << oneWord
    def wordPositionKey=wordPosition[oneWord]
    def wordIndex=[]
    if(wordPositionKey!=null){
        wordPositionKey<<index
    }else {
        wordIndex<<index
        wordPosition[oneWord]=wordIndex
    }
}

def wordCount=[] as TreeSet
def countedWords=[] as TreeSet
wordCount<<0
/*if(wordPosition.size()<2){
    println 1
    return
}*/
/*if(wordPosition.size()<=2){
   println wordPosition.size()
    return
}else{*/
    for(int i=0;i<wordPosition.size();i++){
        def stList=getString(i,wordPosition,word)
        countedWords.addAll(stList)
        stList.each {
            wordCount.addAll(countDistinct(it))
        }

    }
//}
//println(countedWords)
println wordCount.last()

def getString(int startIndex,Map wordPosition,String word){
    String oneChar
    String otherChar
    def elementsToLeave=[] as Set
    def elementsCount=[]
    wordPosition.eachWithIndex { Map.Entry<Object, Object> entry, int index ->
        if(index==startIndex){
            oneChar=entry.key
        }
        if(index>startIndex){
            otherChar=entry.key
            elementsToLeave<<oneChar
            elementsToLeave<<otherChar
            elementsCount<< process(elementsToLeave,word,wordPosition).toString()
            elementsToLeave.clear()
        }
    }
    return elementsCount
}


def process(Set elementsToLeave,String word,Map wordPosition) {
   return deleteAndCheckSubStringForAllExcept(elementsToLeave,word,wordPosition)
}
def removeAllStar( passedSb){
    def sb=new StringBuffer()
    passedSb.toString().toCharArray().each {
        if(it!='*'){
            sb<<it
        }
    }
    return sb
}

Object deleteAndCheckSubStringForAllExcept(Set elementsToLeave,String word,Map wordPosition) {
    def newWord=new StringBuilder(word)
    char junkChar='*'
    wordPosition.each { key,value->
        if(!(elementsToLeave.contains(key))){
            value.each {
                newWord.setCharAt(it,junkChar)
            }
        }
    }
    return removeAllStar(newWord)
  //  int distinctCount=countDistinct(unStarredWord.toString())
    //println "After deleting others except $elementsToLeave. The new word is $unStarredWord and distinct occurance is $distinctCount"
}

def countDistinct(String st){
    String current
    int val=0
   char[]  ch=st.toCharArray()
    for(char oneChar:ch){
        if(current==null){
            current=oneChar
            val++
        }else if(oneChar!=current) {
            current=oneChar
            val++
        }else {
            val=0
            return val
        }
    }
    return val
}