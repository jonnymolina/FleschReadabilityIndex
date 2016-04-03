import java.util.ArrayList;
import java.util.List;

/**
 * Represents the entire document to be analyzed. Comprised of Sentences.
 * 
 * @author Jonathan Molina
 */
public class Document
{
    private List<Sentence> sentences = new ArrayList<Sentence>();
    private int numWords;
    private int numSyllables;
    
    /**
     * Adds a valid sentence to the document. A valid sentence has at least 1 word.
     * @param sentence the string of words
     */
    public void append(String sentence)
    {
        Sentence added = new Sentence(sentence);
        // check for valid sentence
        if (added.getNumWords() > 0)
        {
            sentences.add(added);
            numWords += added.getNumWords();
            numSyllables += added.getTotalSyllables();
        }
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
        return numWords;
    }
    
    /**
     * Returns the total number of syllables in the entire document.
     * @return the total number of syllables in the entire document
     */
    public int getNumSyllables()
    {
        return numSyllables;
    }
    
    /**
     * The String representations of the entire document. The string will have each
     * sentence appended together in insertion order separated by new line characters.
     * @return the String representation of the entire document
     */
    @Override
    public String toString()
    {
        StringBuffer string = new StringBuffer();
        // build sentence
        for (int sentence = 0; sentence < sentences.size(); sentence++)
        {
            // check for start of sentence
            if (sentence != 0)
            {
                string.append("\n");
            }
            string.append(sentences.get(sentence));
        }
        return string.toString();
    }
    
    /**
     * Evaluates whether or not the passed object is equal to this object.
     * @param other the object in question for equality
     * @return true for being equal, false otherwise
     */
    @Override
    public boolean equals(Object other)
    {
        boolean result = false;
        
        // check for null
        if (other != null)
        {
            // check instance type
            if (other instanceof Document)
            {
                Document doc = (Document) other;
                
                // check equal sentences
                if (this.sentences.equals(doc.sentences)
                        && this.numSyllables == doc.numSyllables
                        && this.numWords == doc.numWords)
                {
                    result = true;
                }
            }
        }
        return result;
    }
}