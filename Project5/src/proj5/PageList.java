package proj5;

/**
 * Represents a PageList
 * -array that stores page numbers associated with a ward
 *
 * PageList class invariants:
 * 1. items in PageList are valued based on their word's ASCII value
 * 2. Pagelist holds one word, and list of pages(integers) that word appears on
 * 3. no duplicate page numbers
 * 4. maximum 4 page numbers stored in list
 */
public class PageList implements Comparable<PageList> {

    private final int MAX_PAGES = 4;
    private final int EMPTY = 0;

    private int[] pageList;
    private String word;
    private int size;


    /**
     * Default constructor
     */
    public PageList(){
        this.pageList = new int[MAX_PAGES];
        this.word = "";
        this.size = EMPTY;
    }


    /**
     * Non-default constructor, associates word with pagelist
     * @param word given word
     */
    public PageList(String word){
        this.pageList = new int[MAX_PAGES];
        this.word = word;
        this.size = EMPTY;
    }


    /**
     * checks if a page number is already in pagelist
     * @param pageNum given page number
     * @return true iff page number is in pagelist
     */
    public boolean contains(int pageNum){
        for(int i = 0; i < size(); i++){
            if(getPageList()[i] == pageNum){
                return true;
            }
        }
        return false;
    }


    /**
     * adds a page number to pagelist
     * @param pageToAdd given page number
     */
    public void add(int pageToAdd){
        if(!isFull() && !contains(pageToAdd)){
            getPageList()[size()] = pageToAdd;
            this.size++;
        }
    }


    /**
     * removes page number from pagelist
     * @param pageToRemove page number to remove
     */
    public void remove(int pageToRemove){
        for(int i = 0; i < size(); i++){
            if(getPageList()[i] == pageToRemove){
                shiftRemove(i);
                this.size--;
            }
        }
    }


    /**
     * removes element at index and shifts elements to the left
     * @param index given index
     */
    private void shiftRemove(int index){
        for(int i = index; i < size(); i++){
            if(i == size() - 1){
                this.pageList[i] = 0;
            }else{
                this.pageList[i] = this.pageList[i+1];
            }
        }
    }


    /**
     * checks to see if pagelist is full
     * @return true iff pagelist is full
     */
    public boolean isFull(){
        return size() == getCapacity();
    }


    /**
     * returns size of pagelist
     * @return size of pagelist
     */
    public int size(){
        return this.size;
    }


    /**
     * returns the word associated with the pagelist
     * @return
     */
    public String getWord(){
        return this.word;
    }


    /**
     * returns the pagelist (array of page numbers)
     * @return the pagelist
     */
    public int[] getPageList(){
        return this.pageList;
    }


    /**
     * returns the string representation of PageList
     * @return string representation of PageList
     */
    public String toString(){
        String toReturn = getWord() + " {";
        for(int i = 0; i < size(); i++){
            toReturn += getPageList()[i];
            if(i != size()-1){
                toReturn += ", ";
            }
        }
        toReturn += "}";

        return toReturn;
    }


    /**
     * Compares the value of pagelist objects.
     * Value is determined by ASCII value of word associated with pagelist.
     * @param other the object to be compared.
     * @return 1 if this is greater, 0 if equal, -1 if other is greater
     */
    public int compareTo(PageList other) {
        return this.getWord().compareTo(other.getWord());
    }


    private int getCapacity(){
        return getPageList().length;
    }
}
