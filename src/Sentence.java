import java.util.ArrayList;
import java.util.List;

/**
 * Represents a String sentence containing words. Punctuation is not included.
 * 
 * @author Jonathan Molina
 */
public class Sentence
{
    private final List<Word> words;
    private final int totalSyllables;
    
    /**
     * Constructs this class using a String of Words that can include punctuation.
     * @pre sentence must contain at least one valid word, i.e. can't be all punctuation
     * or numbers
     * @param sentence the String of Words that may have punctuation
     */
    public Sentence(String sentence)
    {
        this.words = new ArrayList<Word>();
        int syllableCount = 0;
        // delimit sentence with spaces and numbers
        for (String wordStr : sentence.split("[\\s]+"))
        {
            Word word = new Word(wordStr);
            // check for valid word
            if (word.getWord().length() > 0)
            {
                syllableCount += word.getSyllables();
                this.words.add(word);
            }
        }
        this.totalSyllables = syllableCount;
    }
    
    /**
     * Returns the number of total words from the initial String of words used to create
     * this class.
     * @return the number of total words
     */
    public int getNumWords()
    {
        return words.size();
    }
    
    /**
     * Returns the total number of syllables from each word in the sentence.
     * @return the total number of syllables in the sentence
     */
    public int getTotalSyllables()
    {
        return totalSyllables;
    }
    
    /**
     * Returns a String representation of the sentence. It will not be identical to the
     * original given sentence but it will be the words extrapolated from the initial
     * sentence with spaces in between.
     * @return the explained String representation in the method description
     */
    @Override
    public String toString()
    {
        StringBuffer string = new StringBuffer();
        
        // build sentence
        for (int word = 0; word < words.size(); word++)
        {
            // check for start of sentence
            if (word != 0)
            {
                string.append(" ");
            }
            string.append(words.get(word));
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
            if (other instanceof Sentence)
            {
                Sentence otherSen = (Sentence) other;
                
                // check for same word
                if (this.words.equals(otherSen.words))
                {
                    // check for same total syllables
                    if (this.totalSyllables == otherSen.totalSyllables)
                    {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
