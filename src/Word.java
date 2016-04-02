import java.util.Arrays;
import java.util.List;

/**
 * Represents String word with syllables. Each group of continuous non-blank characters
 * with beginning and ending punctuation removed counts as a word.
 * (Note: newline and tab characters should be treated as a blank.)
 * 
 * @author Jonathan Molina
 */
public class Word
{
    private final String word;
    private final int syllables;
    private final List<Character> vowels;
    
    /**
     * Stores the given word without beginning and ending punctuation.
     * @param theWord the word
     */
    public Word(String theWord)
    {
        Character[] vowelList = {'a', 'e', 'i', 'o', 'u', 'y', 
                                 'A', 'E', 'I', 'O', 'U', 'Y'};
        this.vowels = Arrays.asList(vowelList);
        this.word = trim(theWord);
        this.syllables = countSyllables(word);
    }
    
    private String trim(String theWord)
    {
        String newWord = theWord.replaceFirst("^[^a-zA-Z]+", "");
        return newWord.replaceAll("[^a-zA-Z]+$", "");
    }
    
    /**
     * Retrieves the represented word for this class. The returned word is free of
     * leading and trailing punctuation or numbers.
     * @return the represented word
     */
    public String getWord()
    {
        return word;
    }
    
    private int countSyllables(String theWord)
    {
        int total = 0;
        
        // < 3 letters = 1 syllable
        if (theWord.length() <= 3)
        {
            total = 1;
        }
        else
        {
            boolean consecutive = false;
            char[] letters = theWord.toCharArray();
            // apply other rules when counting syllables
            for (int ndx = 0; ndx < letters.length; ndx++)
            {
                // Check for -es, -ed, -e endings (except -le)
                if (checkForSpecialEnding(ndx, letters))
                {
                    ndx++;
                    consecutive = false;
                }
                // increment for vowel
                else if (vowels.contains(letters[ndx]))
                {
                    // check if consecutive vowel
                    if (!consecutive)
                    {
                        total++;
                    }
                    consecutive = true;
                }
                else
                {
                    consecutive = false;
                }
            }
        }
        return total;
    }
    
    private boolean checkForSpecialEnding(int ndx, char[] letters)
    {
        // Check for -es, -ed
        return (ndx+1 == letters.length - 1
                    && compareChar(letters[ndx], 'e')
                    && (compareChar(letters[ndx+1], 's') 
                        || compareChar(letters[ndx+1], 'd')))
                // check for -e (not -le)
                || (compareChar(letters[ndx], 'e')
                        && ndx+1 == letters.length
                        && !compareChar(letters[ndx-1], 'l'));
    }
    
    private boolean compareChar(char first, char second)
    {
        String one = Character.toString(first).toUpperCase();
        String two = Character.toString(second).toUpperCase();
        
        return one.equals(two);
    }
    
    /**
     * Return the number of syllables in the represented word.
     * @return the number of syllables
     */
    public int getSyllables()
    {
        return syllables;
    }
    
    /**
     * Returns the represented word.
     * @return the represented word
     */
    @Override
    public String toString()
    {
        return word;
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
            if (other instanceof Word)
            {
                Word otherWord = (Word) other;
                
                // check for same word
                if (this.word.equals(otherWord.word))
                {
                    result = true;
                }
            }
        }
        return result;
    }
}
