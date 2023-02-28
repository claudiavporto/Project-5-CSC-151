package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;


public class IndexTest {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    public Index index;

    @Before
    public void setup() throws Exception {
        index = new Index();
    }

    @After
    public void tearDown() throws Exception {
        index = null;
    }

    @Test
    public void makeEntry(){
        index.insert("hello", 1);

        System.out.println(index.toString());
    }

    @Test
    public void testInsertDuplicate(){
        index.insert("hello", 1);
        index.insert("world", 1);

        index.insert("hello", 2);

        System.out.println(index.toString());
    }

    @Test
    public void testInsertFullPagelist(){
        index.insert("hello", 1);
        index.insert("world", 1);
        index.insert("Hello", 1);
        index.insert("World", 1);

        index.insert("hello", 1);
        System.out.println(index);

        assertEquals(4, index.size());
    }

    @Test
    public void testRemove(){
        index.insert("hello", 1);
        index.insert("world", 1);
        index.insert("Hello", 1);
        index.insert("World", 1);

        index.delete("hello");
        System.out.println(index.toString());

        assertEquals(3, index.size());
    }

    @Test
    public void testRemoveEmpty(){
        index.insert("hello", 1);
        index.insert("world", 1);
        index.insert("Hello", 1);
        index.insert("World", 1);

        index.delete("hello");
        System.out.println(index);

        assertEquals(3, index.size());
    }

    @Test
    public void testaddPageNum(){
        index.insert("hello", 1);
        index.insert("world", 1);

        index.insertPageNum("hello", 3);
        index.insertPageNum("hello", 3);
        index.insertPageNum("hello", 4);
        index.insertPageNum("hello", 5);
        index.insertPageNum("hello", 6);
        index.insertPageNum("hello", 7);
        index.insertPageNum("world", 7);


        System.out.println(index);

    }

    @Test
    public void testWordContainsPage(){
        index.insert("hello", 1);
        index.insert("world", 1);

        index.insertPageNum("hello", 3);
        index.insertPageNum("hello", 3);
        index.insertPageNum("hello", 4);

        assertTrue(index.wordContainsPage(3,"hello"));
    }

}
