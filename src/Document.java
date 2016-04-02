import java.util.List;

/**
 * Represents the entire document to be analyzed. Comprised of Sentences.
 * 
 * @author Jonathan Molina
 */
public class Document
{
    private List<Sentence> sentences;
    private int numWords;
    private int numSyllables;
    
    /**
     * Adds a valid sentence to the document. A valid sentence has at least 1 word.
     * @param sentence the string of words
     */
    public void append(String sentence)
    {
    }
    
    /**
     * Returns all the sentences that have been appended to this document.
     * @return the list of all sentences appended
     */
    public List<Sentence> getSentences()
    {
        return null;
    }
    
    /**
     * Returns the total number of sentences appended.
     * @return total number of sentences
     */
    public int getNumSentences()
    {
        return sentences.size();
    }
    
    /**
     * Returns the total number of words in the entire document.
     * @return total number of words in the document
     */
    public int getNumWords()
    {
        return 0;
    }
    
    /**
     * Returns the total number of syllables in the entire document.
     * @return the total number of syllables in the entire document
     */
    public int getNumSyllables()
    {
        return 0;
    }
    
    /**
     * The String representations of the entire document. The string will have each
     * sentence appended together in insertion order separated by new line characters.
     * @return the String representation of the entire document
     */
    @Override
    public String toString()
    {
        return "";
    }
    
    /**
     * Evaluates whether or not the passed object is equal to this object.
     * @param other the object in question for equality
     * @return true for being equal, false otherwise
     */
    @Override
    public boolean equals(Object other)
    {
        return false;
    }
}