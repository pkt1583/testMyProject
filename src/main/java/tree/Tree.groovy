package tree

/**
 * Created by pankaj on 10/9/16.
 */
class Tree {

    Node rootNode
    Node currentNode
   /* def constructTree(List elementList){
        if(elementList!=null && elementList.size()!=0) {
            rootNode = new Node(elementList.get(0))
            currentNode=rootNode
            elementList.eachWithIndex { index,eachElement->
                if(index!=1){
                    def newNode=new Node(eachElement)
                    currentNode.addNodeAtCorrectPlace(newNode)
                    currentNode=newNode
                    println "elemennt at index $index is $eachElement"
                }
            }
        }
    }*/

    def TreeNodes=[]
    def constructTree(List elementList){
        if(elementList.size()<3){
            throw new RuntimeException("Tree cannot be constructed with less than three elemnts")
        }else {
            def newElements=elementList.subList(0,2)
            elementList.removeAll(newElemennts)
            TreeNodes<<new MyTree(newElemennts)
        }
    }
}

class MyTree{
    private Node leftNode
    private Node rightNode
    private int value

    MyTree(List elements){
        if(elements.size()==3){
            leftNode=new Node(value:elements.min())
            rightNode=new Node(value:  elements.max())
            this.value=null
        }
    }
}
