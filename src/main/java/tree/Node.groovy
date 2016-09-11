package tree


class Node implements Comparable<tree.Node>{
    private Node left
    private Node right
    private Node parent
    private Integer value

    Node(val){
        this.value=val
    }


    @Override
    int compareTo(Node o) {
        return o.value <=> this.value
    }

    def addNodeAtCorrectPlace(Node node) {
        if(this.parent<node && (this.parent.left==null || this.parent.right==null)){
            this.parent.addNodeAtCorrectPlace(node)
            return
        }
        if(this.value>node.value){
            addToLeftSide(node)
        }else {
            addToRightSide(node)
        }
    }

    def addToRightSide(Node node) {
        if(this.right==null){
          println " added $node to right of $this"
            this.right=node
        }else {
            this.right.addNodeAtCorrectPlace(node)
        }
    }



    def addToLeftSide(Node node) {
       if(this.left==null){
           println " added $node to left of $this"
           this.left=node
       }else {
           this.left.addNodeAtCorrectPlace(node)
       }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
