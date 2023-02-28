package proj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ReadFile class
 * -reads a file, makes an index and dictionary from the text file
 */
public class ReadFile {

    private final int MIN_WORD_LENGTH = 2;

    private Scanner myReader;

    /**
     * Initializes the reader with the given file.
     *
     * @param filename
     */
    public ReadFile(String filename) {
        try {
            myReader = new Scanner(new File(filename));
            myReader.useDelimiter("[^a-zA-Z#]+");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Reads file and prints index and dictionary
     */
    public void run() {
        Dictionary dict = new Dictionary();
        Index index = new Index();
        int page = 1;
        while (myReader.hasNext()) {
            String nextExpression = myReader.next();
            if(nextExpression.equals("#")){
                page++;
            }
            if(nextExpression.length() > MIN_WORD_LENGTH && !dict.contains(nextExpression)){
                if(index.contains(nextExpression)){
                    if(!index.wordContainsPage(page, nextExpression)){
                        if(!index.pageListFull(nextExpression)){
                            index.insertPageNum(nextExpression, page);
                        }else{
                            index.delete(nextExpression);
                            dict.insert(nextExpression);
                        }
                    }
                }else{
                    index.insert(nextExpression, page);
                }
            }
        }
        System.out.println(index);
        System.out.println(dict);
    }
}