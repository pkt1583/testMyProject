package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private int data;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    public void addNode(int num) {
        if (num < this.data) {
            if (this.left != null) {
                this.left.addNode(num);
            } else {
                this.left = new BinaryTree(num);
            }

        } else {
            if (this.right != null) {
                this.right.addNode(num);
            } else {
                this.right = new BinaryTree(num);
            }

        }
    }

    public void inorderTraversal() {
        if (this.left != null) {
            this.left.inorderTraversal();
        }
        System.out.print(this + "  ");
        if (this.right != null) {
            this.right.inorderTraversal();
        }
    }

    public void postOrderTraversal() {
        if (this.left != null) {
            this.left.postOrderTraversal();
        }

        if (this.right != null) {
            this.right.postOrderTraversal();
        }
        System.out.print(this + "  ");

    }

    @Override
    public String toString() {
        return "data=" + data +
                '}';
    }

    public void preOrderTraversal() {
        System.out.print(this + "  ");
        if (this.left != null) {
            this.left.postOrderTraversal();
        }

        if (this.right != null) {
            this.right.postOrderTraversal();
        }

    }

    public void breadthFirst(){
        Queue<BinaryTree> queue=new LinkedList<>();
        queue.add(this);
        startTraversal(queue);

    }

    private void startTraversal(Queue<BinaryTree> queue) {
        BinaryTree currentNode=queue.remove();
        if(currentNode.left!=null){
            queue.add(currentNode.left);
        }if(currentNode.right!=null) {
            queue.add(currentNode.right);
        }
        System.out.print(currentNode+ "  ");
        if(queue.isEmpty()){
            return;
        }
        startTraversal(queue);
    }

}
