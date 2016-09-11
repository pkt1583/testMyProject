package tree

import org.junit.Test

/**
 * Created by pankaj on 10/9/16.
 */
class TreeTest extends GroovyTestCase {
    @Test
    void testConstructTree() {
        def elementsList=[1,3,4,2,7,9,5]
        Tree tt=new Tree()
        tt.constructTree(elementsList)
        tt.rootNode
    }
}
