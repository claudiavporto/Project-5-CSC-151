package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class ClaudiaPortoBSTTest {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private BinarySearchTree<String> bst;

    @Before
    public void setup() throws Exception{
        bst = new BinarySearchTree<String>();
    }

    @After
    public void tearDown() throws Exception{
        bst = null;
    }

    @Test
    public void testConstructor(){
        assertEquals("", bst.toString());
    }

    @Test
    public void testInsertEmptyBST(){
        bst.insert("A");

        assertEquals("(  A  )", bst.toString());
    }

    @Test
    public void testInsertDepth1BST(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");

        assertEquals("((  A  )  B  (  C  ))", bst.toString());
    }

    @Test
    public void testInsertDepth2BST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        assertEquals("(((  A  )  B  (  C  ))  D  ((  E  )  F  (  G  )))", bst.toString());
    }

    @Test
    public void testInsertDepth3BST(){
        bst.insert("H");
        bst.insert("L");
        bst.insert("D");
        bst.insert("J");
        bst.insert("F");
        bst.insert("N");
        bst.insert("M");
        bst.insert("B");
        bst.insert("E");
        bst.insert("O");
        bst.insert("A");
        bst.insert("G");
        bst.insert("C");
        bst.insert("K");
        bst.insert("I");

        assertEquals("((((  A  )  B  (  C  ))  D  ((  E  )  F  (  G  )))  H  (((  I  )  J  (  K  ))  L  ((  M  )  N  (  O  ))))", bst.toString());
    }

    @Test
    public void testInsertDuplicatesBST(){
        bst.insert("C");
        bst.insert("C");
        bst.insert("C");
        bst.insert("C");


        assertEquals("((((  C  )  C  )  C  )  C  )", bst.toString());
    }

    @Test
    public void testInsertAllGreaterValuesBST(){
        bst.insert("A");
        bst.insert("B");
        bst.insert("C");
        bst.insert("D");
        bst.insert("E");
        bst.insert("F");
        bst.insert("G");

        assertEquals("(  A  (  B  (  C  (  D  (  E  (  F  (  G  )))))))", bst.toString());
    }

    @Test
    public void testInsertAllLesserValuesBST(){
        bst.insert("G");
        bst.insert("F");
        bst.insert("E");
        bst.insert("D");
        bst.insert("C");
        bst.insert("B");
        bst.insert("A");

        assertEquals("(((((((  A  )  B  )  C  )  D  )  E  )  F  )  G  )", bst.toString());
    }

    @Test
    public void testInsertSize2BST(){
        bst.insert("D");
        bst.insert("B");

        assertEquals("((  B  )  D  )", bst.toString());
    }

    @Test
    public void testInsertSize6BST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");

        assertEquals("(((  A  )  B  (  C  ))  D  (  F  (  G  )))", bst.toString());
    }

    @Test
    public void testInsertSize12BST() {
        bst.insert("H");
        bst.insert("L");
        bst.insert("D");
        bst.insert("J");
        bst.insert("F");
        bst.insert("N");
        bst.insert("M");
        bst.insert("B");
        bst.insert("E");
        bst.insert("O");
        bst.insert("A");
        bst.insert("G");

        assertEquals("((((  A  )  B  )  D  ((  E  )  F  (  G  )))  H  ((  J  )  L  ((  M  )  N  (  O  ))))", bst.toString());
    }

    @Test
    public void testInsertLowerCaseBST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("c");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        assertEquals("(((  A  )  B  )  D  ((  E  )  F  ((  G  )  c  )))", bst.toString());
    }

    @Test
    public void testInsertUpperCaseBST(){
        bst.insert("d");
        bst.insert("b");
        bst.insert("f");
        bst.insert("C");
        bst.insert("a");
        bst.insert("g");
        bst.insert("e");

        assertEquals("(((  C  (  a  ))  b  )  d  ((  e  )  f  (  g  )))", bst.toString());
    }

    @Test
    public void testInsertUpperAndLowerCaseBST(){
        bst.insert("d");
        bst.insert("B");
        bst.insert("f");
        bst.insert("C");
        bst.insert("a");
        bst.insert("g");
        bst.insert("E");

        assertEquals("((  B  (  C  ((  E  )  a  )))  d  (  f  (  g  )))", bst.toString());
    }

    @Test
    public void testDeleteGreatestValueDepth1BST(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        bst.delete("C");

        assertEquals("((  A  )  B  )", bst.toString());
    }

    @Test
    public void testDeleteLowestValueDepth1BST(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");

        bst.delete("A");

        assertEquals("(  B  (  C  ))", bst.toString());
    }

    @Test
    public void testDeleteGreatestValueDepth2BST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.delete("G");

        assertEquals("(((  A  )  B  (  C  ))  D  ((  E  )  F  ))", bst.toString());
    }

    @Test
    public void testDeleteLowestValueDepth2BST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.delete("A");

        assertEquals("((  B  (  C  ))  D  ((  E  )  F  (  G  )))", bst.toString());
    }

    @Test
    public void testDeleteGreatestValueDepth3BST(){
        bst.insert("H");
        bst.insert("L");
        bst.insert("D");
        bst.insert("J");
        bst.insert("F");
        bst.insert("N");
        bst.insert("M");
        bst.insert("B");
        bst.insert("E");
        bst.insert("O");
        bst.insert("A");
        bst.insert("G");
        bst.insert("C");
        bst.insert("K");
        bst.insert("I");

        bst.delete("O");

        assertEquals("((((  A  )  B  (  C  ))  D  ((  E  )  F  (  G  )))  H  (((  I  )  J  (  K  ))  L  ((  M  )  N  )))", bst.toString());
    }

    @Test
    public void testDeleteLowestValueDepth3BST(){
        bst.insert("H");
        bst.insert("L");
        bst.insert("D");
        bst.insert("J");
        bst.insert("F");
        bst.insert("N");
        bst.insert("M");
        bst.insert("B");
        bst.insert("E");
        bst.insert("O");
        bst.insert("A");
        bst.insert("G");
        bst.insert("C");
        bst.insert("K");
        bst.insert("I");

        bst.delete("A");

        assertEquals("(((  B  (  C  ))  D  ((  E  )  F  (  G  )))  H  (((  I  )  J  (  K  ))  L  ((  M  )  N  (  O  ))))", bst.toString());
    }

    @Test
    public void testDeleteSubRootDepth2BST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.delete("B");

        assertEquals("(((  A  )  C  )  D  ((  E  )  F  (  G  )))", bst.toString());
    }

    @Test
    public void testDeleteSubRootOnDepth2BST(){
        bst.insert("H");
        bst.insert("L");
        bst.insert("D");
        bst.insert("J");
        bst.insert("F");
        bst.insert("N");
        bst.insert("M");
        bst.insert("B");
        bst.insert("E");
        bst.insert("O");
        bst.insert("A");
        bst.insert("G");
        bst.insert("C");
        bst.insert("K");
        bst.insert("I");

        bst.delete("J");

        assertEquals("((((  A  )  B  (  C  ))  D  ((  E  )  F  (  G  )))  H  (((  I  )  K  )  L  ((  M  )  N  (  O  ))))", bst.toString());
    }

    @Test
    public void testDeleteSubRootOnDepth1BST(){
        bst.insert("H");
        bst.insert("L");
        bst.insert("D");
        bst.insert("J");
        bst.insert("F");
        bst.insert("N");
        bst.insert("M");
        bst.insert("B");
        bst.insert("E");
        bst.insert("O");
        bst.insert("A");
        bst.insert("G");
        bst.insert("C");
        bst.insert("K");
        bst.insert("I");

        bst.delete("L");

        assertEquals("((((  A  )  B  (  C  ))  D  ((  E  )  F  (  G  )))  H  (((  I  )  J  (  K  ))  O  ((  M  )  N  )))", bst.toString());
    }

    @Test
    public void testDeleteEmptyBST(){
        bst.delete("A");

        assertEquals("", bst.toString());
    }

    @Test
    public void testDeleteRootDepth1BST(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");

        bst.delete("B");

        assertEquals("((  A  )  C  )", bst.toString());
    }

    @Test
    public void testDeleteRootDepth2BST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.delete("D");

        assertEquals("(((  A  )  B  (  C  ))  G  ((  E  )  F  ))", bst.toString());
    }

    @Test
    public void testDeleteRootDepth3BST(){
        bst.insert("H");
        bst.insert("L");
        bst.insert("D");
        bst.insert("J");
        bst.insert("F");
        bst.insert("N");
        bst.insert("M");
        bst.insert("B");
        bst.insert("E");
        bst.insert("O");
        bst.insert("A");
        bst.insert("G");
        bst.insert("C");
        bst.insert("K");
        bst.insert("I");

        bst.delete("H");

        assertEquals("((((  A  )  B  (  C  ))  D  ((  E  )  F  (  G  )))  O  (((  I  )  J  (  K  ))  L  ((  M  )  N  )))", bst.toString());
    }

    @Test
    public void testDeleteValueNotInBST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.delete("L");

        assertEquals("(((  A  )  B  (  C  ))  D  ((  E  )  F  (  G  )))", bst.toString());
    }

    @Test
    public void testSearchValueInBST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.search("F");

        assertTrue(bst.search("F"));
    }

    @Test
    public void testSearchValueNotInBST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.search("K");

        assertFalse(bst.search("K"));
    }

    @Test
    public void testSearchRootBST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.search("D");

        assertTrue(bst.search("D"));
    }

    @Test
    public void testSearchGreatestValueInBST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.search("G");

        assertTrue(bst.search("G"));
    }

    @Test
    public void testSearchLowestValueInBST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("E");

        bst.search("A");

        assertTrue(bst.search("A"));
    }

    @Test
    public void testSearchDuplicateValueInBST(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("C");
        bst.insert("A");
        bst.insert("G");
        bst.insert("G");

        bst.search("G");

        assertTrue(bst.search("G"));
    }

    @Test
    public void testSearchValueInEmptyBST(){
        bst.search("F");

        assertFalse(bst.search("F"));
    }

    @Test
    public void testFindReplacement(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        assertEquals("G", bst.findMax());
    }
}
