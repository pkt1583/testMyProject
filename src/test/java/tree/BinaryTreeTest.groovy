package tree

import org.junit.Test

/**
 * Created by pankaj on 10/9/16.
 */
class BinaryTreeTest extends GroovyTestCase{

    @Test
    public void testBinaryTree(){
        BinaryTree tree = new BinaryTree(20);
        int[] nums = [15, 200, 1100, -5, 0, 100, 20, 12, 126, 1000, -150]
        for(int i : nums ) {
            tree.addNode( i )
        }
       println "Printing inorder "
        tree.inorderTraversal()
        println()
       /* println "Printing postOrderTraversal "
        tree.postOrderTraversal()
        println "Printing preOrder"
        tree.preOrderTraversal()*/
        println "printing breadthFirst"
        tree.breadthFirst()

        println "Printing the Tree"
     //   tree.printTree()
    }
}
