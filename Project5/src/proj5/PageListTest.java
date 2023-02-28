package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class PageListTest {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private PageList pageList;

    @Before
    public void setup() throws Exception{
        pageList = new PageList("Test");
    }

    @After
    public void tearDown() throws Exception{
        pageList = null;
    }


    @Test //Tests add;
    public void testAdd(){
        pageList.add(1);
        pageList.add(2);
        pageList.add(3);

        assertEquals(3, pageList.size());
        assertEquals("Test {1, 2, 3}", pageList.toString());
    }

    @Test //Tests add; adds to an empty pagelist
    public void testAddEmpty(){
        pageList.add(1);


        assertEquals(1, pageList.size());
        assertEquals("Test {1}", pageList.toString());
    }

    @Test //Tests add; tries to add a duplicate element. should not add
    public void testAddDuplicate(){
        pageList.add(1);
        pageList.add(2);

        pageList.add(1);

        assertEquals(2, pageList.size());
        assertEquals("Test {1, 2}", pageList.toString());
    }

    @Test //Tests add; tries to add to a full pagelist. should not add
    public void testAddFull(){
        pageList.add(1);
        pageList.add(2);
        pageList.add(3);
        pageList.add(4);

        pageList.add(9);

        assertEquals(4, pageList.size());
        assertEquals("Test {1, 2, 3, 4}", pageList.toString());
    }

    @Test //Tests remove;
    public void testRemove(){
        pageList.add(1);
        pageList.add(2);
        pageList.add(3);
        pageList.add(4);

        pageList.remove(1);
        System.out.println(pageList.toString());

        assertEquals(3, pageList.size());
        assertEquals("Test {2, 3, 4}", pageList.toString());
    }

    @Test //Tests remove; tries to remove an element not in the pagelist
    public void testRemoveNotInPagelist(){
        pageList.add(1);
        pageList.add(2);
        pageList.add(3);
        pageList.add(4);

        pageList.remove(9);

        assertEquals(4, pageList.size());
        assertEquals("Test {1, 2, 3, 4}", pageList.toString());
    }

    @Test //Tests remove; tries to remove on an empty pagelist
    public void testRemoveEmpty(){

        pageList.remove(1);

        assertEquals(0, pageList.size());
        assertEquals("Test {}", pageList.toString());
    }

    @Test //Tests size; tested on an empty pagelist
    public void testSizeEmpty(){
        assertEquals(0, pageList.size());
    }

    @Test //Tests size; tested on pagelist with size 3
    public void testSize(){
        pageList.add(1);
        pageList.add(2);
        pageList.add(3);

        assertEquals(3, pageList.size());
    }

    @Test //Tests contains; pagelist contains element
    public void testContainsTrue(){
        pageList.add(1);
        pageList.add(2);
        pageList.add(3);
        pageList.add(4);

        assertTrue(pageList.contains(2));
    }

    @Test //Tests contains; pagelist does not contain element
    public void testContainsFalse(){
        pageList.add(1);
        pageList.add(2);
        pageList.add(3);
        pageList.add(4);

        assertFalse(pageList.contains(9));
    }

    @Test //Tests contains; pagelist is empty
    public void testContainsEmpty(){

        assertFalse(pageList.contains(9));
    }

    @Test //Tests contains; pagelist is empty
    public void testCompareTo(){
        PageList pl2 = new PageList("further");
        PageList pl3 = new PageList("try");
        System.out.println(pl2.compareTo(pl3));
    }

}
