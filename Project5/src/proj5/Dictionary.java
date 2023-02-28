package proj5;

/**
 * Represents a Dictionary
 * -contains words that were in index that appeared more than 4 times in the text
 *
 * Dictionary class invariants:
 * 1. cannot contain any duplicate words
 * 2. words need to have been added from index
 * 3. words need to have appeared more than 4 times in text
 * 4. words printed in alphabetical order, capitals first
 */
public class Dictionary {
    private BinarySearchTree<String> dictionary;

    /**
     * default constructor
     */
    public Dictionary(){
        this.dictionary = new BinarySearchTree<String>();
    }


    /**
     * checks to see if a word is already in the dictionary
     * @param toCheck word to check
     * @return true iff word is in dictionary
     */
    public boolean contains(String toCheck){
        return dictionary().search(toCheck);
    }


    /**
     * inserts a word into the dictionary
     * @param wordToAdd given word
     */
    public void insert(String wordToAdd){
        dictionary().insert(wordToAdd);
    }


    /**
     * deletes a word from the dictionary
     * @param wordToAdd given word
     */
    public void delete(String wordToAdd){
        dictionary().delete(wordToAdd);
    }


    /**
     * returns the string representation of the dictionary
     * @return string representation of the dictionary
     */
    public String toString(){
        String newline = System.lineSeparator();
        String toReturn = "Dictionary: " + newline;
        toReturn += dictionary().printString();
        return toReturn;
    }


    private BinarySearchTree<String> dictionary(){
        return this.dictionary;
    }

}
