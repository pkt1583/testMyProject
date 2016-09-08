package practise

def scanner=new Scanner(new BufferedInputStream(System.in))
int numberOfElementsInArray=scanner.nextInt()
int numberOfRotations=scanner.nextInt()
int numberOfQueries=scanner.nextInt()

MyNode firstNode
MyNode currentOperatingNode;

for (int i = 0; i < numberOfElementsInArray; i++) {
    if(i==0){
        firstNode=new MyNode()
        firstNode.value=scanner.nextInt()
        currentOperatingNode=firstNode
    }else{
        MyNode another=new MyNode()
        another.value=scanner.nextInt()
        another.previousNode=currentOperatingNode
        currentOperatingNode.nextNode=another
        currentOperatingNode=another
    }
}
MyNode lastNode=currentOperatingNode;
if(!(numberOfRotations/numberOfElementsInArray==0)) {

    numberOfRotations.times {
        lastNode.nextNode = firstNode
        firstNode.previousNode = lastNode
        firstNode = lastNode
        lastNode = lastNode.previousNode
        lastNode.nextNode = null
    }
}


MyNode iteratingNode=firstNode

def mapForSearch=[:]
int i=0
while (true){
    if(iteratingNode!=null){
        mapForSearch[i++]=iteratingNode.value+" "
        iteratingNode=iteratingNode.nextNode
    }else {
        break
    }
}

numberOfQueries.times {
    println mapForSearch[scanner.nextInt()]
}



 class MyNode {
    int value;
    MyNode nextNode;
    MyNode previousNode;

     boolean equals(o) {
         if (this.is(o)) return true
         if (getClass() != o.class) return false

         MyNode myNode = (MyNode) o

         if (value != myNode.value) return false

         return true
     }

     int hashCode() {
         return value
     }
 }
