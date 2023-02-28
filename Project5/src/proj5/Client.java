package proj5;


/**
 * Driver for the index maker project
 * 
 * @author Claudia Porto
 * @version 11/15/2022
 */
public class Client
{
    public static void main(String[] args)
    {
    	makeIndex("src/proj5/uscons.txt");
    }
    
    /**
     * Makes an index out of fileName. Gradescope needs this function.
     * 
     * @param fileName path to text file that you want to index
     */
    public static void makeIndex(String fileName) {
    	ReadFile read = new ReadFile(fileName);
        read.run();
    }
}
