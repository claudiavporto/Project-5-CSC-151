package proj5;

/**
 * Represents an index of words
 *
 * Contains a word and it's pages that it resides on. Words that are
 * two or fewer characters are irrelevant.
 *
 * Index Class Invariants:
 * 1. Words only appear once in the index, with that the Pagelist associated with
 *    the word
 * 2. If word appears more than 4 times in the text, it will be removed from
 *    the index
 * 3. Index is a Binary Search Tree of type PageList
 */
public class Index{

    private BinarySearchTree<PageList> index;


    /**
     * Default constructor
     */
    public Index(){
        this.index = new BinarySearchTree<PageList>();
    }


    /**
     * inserts a word into the index if conditions are met
     * @param wordToAdd given word
     */
    public void insert(String wordToAdd, int pageNum){
        PageList toAdd = new PageList(wordToAdd);
        if(!index().search(toAdd)){
            toAdd.add(pageNum);
            this.index.insert(toAdd);
        }
    }


    /**
     * inserts a page number into the Pagelist associated with the given word
     * @param word given word
     * @param pageNum page number to be added
     */
    public void insertPageNum(String word, int pageNum){
        PageList toAdd = new PageList(word);
        this.index.getData(toAdd).add(pageNum);
    }


    /**
     * Checks to see if a given page is already associated with a word
     * @param pageNum a page number
     * @param word a word
     * @return true if page number is associated, false if not
     */
    public boolean wordContainsPage(int pageNum, String word){
        PageList toFind = new PageList(word);
        PageList data = index().getData(toFind);
        return data.contains(pageNum);
    }


    /**
     * Checks to see if word is already in index
     * @param wordToCheck given word
     * @return true iff word is in index
     */
    public boolean contains(String wordToCheck){
        PageList toCheck = new PageList(wordToCheck);
        return index().search(toCheck);
    }


    /**
     * removes a word from index
     * @param wordToRemove given word to remove
     * @return the removed word
     */
    public void delete(String wordToRemove){
        PageList toRemove = new PageList(wordToRemove);
        PageList data = index().getData(toRemove);
        System.out.println("Deleting '" + data + "' from index.");
        this.index.delete(data);
    }


    /**
     * Checks to see if the pagelist associated with the word is filled
     * @param wordToCheck given word
     * @return true iff pagelist is full
     */
    public boolean pageListFull(String wordToCheck){
        PageList toCheck = new PageList(wordToCheck);
        PageList data = index().getData(toCheck);
        if(data == null){
            return false;
        }
        return data.isFull();
    }


    /**
     * @return the number of pages associated with a word
     */
    public int size(){
        return index().size();
    }


    /**
     * returns the string representation of the index
     * @return string representation of index
     */
    public String toString(){
        String newline = System.lineSeparator();
        String toReturn = "Index: " + newline;
        toReturn += index().printString();
        return toReturn;
    }


    private BinarySearchTree<PageList> index(){
        return this.index;
    }
}
