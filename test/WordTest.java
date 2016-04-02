import junit.framework.TestCase;

/**
 * Tests the Word class.
 * @author Jonathan Molina
 */
public class WordTest extends TestCase
{
    
    /**
     * Class constructor.
     * @param testName test name
     */
    public WordTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Test of getWord method, of class Word.
     */
    public void testGetWord()
    {
        String[] punc = {"!","@","#","$","%","^","7","*","(",")","-","_","+","=","`","~",
                        "{","}","[","]","|","\\",":",";","\"","'","<",">",",",".","?","/"};
        String str = "word";
        
        for (String mark : punc)
        {
            Word word1 = new Word(str);
            assertEquals(str, word1.getWord());
            
            word1 = new Word(mark+str); // appending
            assertEquals(str, word1.getWord());
            
            word1 = new Word(str+mark); // prepending
            assertEquals(str, word1.getWord());
            
            word1 = new Word(mark+str+mark); // sandwiched marks
            assertEquals(str, word1.getWord());
            
            word1 = new Word(str.substring(0, 1)+mark+str.substring(1)); // inserted mark
            assertEquals(str.substring(0, 1)+mark+str.substring(1), word1.getWord());
        }
        
        Word word2 = new Word(str+"\n");
        assertEquals(str, word2.getWord());
        word2 = new Word(str+"\t");
        assertEquals(str, word2.getWord());
        word2 = new Word("\n"+str);
        assertEquals(str, word2.getWord());
        word2 = new Word("\t"+str);
        assertEquals(str, word2.getWord());
        
        word2 = new Word("\n"+str+"\n");
        assertEquals(str, word2.getWord());
        word2 = new Word("\t"+str+"\n");
        assertEquals(str, word2.getWord());
        word2 = new Word("\t"+str+"\t");
        assertEquals(str, word2.getWord());
        word2 = new Word("\t"+str+"\n");
        assertEquals(str, word2.getWord());
        
        word2 = new Word("123word123");
        assertEquals("word", word2.getWord());
        word2 = new Word("__!@#234word");
        assertEquals("word", word2.getWord());
        word2 = new Word("^^?3490what's!$#@%#@$134");
        assertEquals("what's", word2.getWord());
    }

    /**
     * Test of getSyllables method, of class Word.
     */
    public void testGetSyllables() 
    {
        Word word = new Word("word");
        assertEquals(1, word.getSyllables());
        
        word = new Word("hedgehog");
        assertEquals(3, word.getSyllables());
        
        word = new Word("hedge-hog");
        assertEquals(3, word.getSyllables());
        
        word = new Word("wify");
        assertEquals(2, word.getSyllables());
        
        word = new Word("wtff");
        assertEquals(0, word.getSyllables());
        
        word = new Word("cuts");
        assertEquals(1, word.getSyllables());
        
        word = new Word("oldhag");
        assertEquals(2, word.getSyllables());
    }
    
    /**
     * Words of three letters or shorter count as single syllables.
     */
    public void testGetSyllablesThreeLetters()
    {
        Word word = new Word("the");
        assertEquals(1, word.getSyllables());
        
        word = new Word("are");
        assertEquals(1, word.getSyllables());
        
        word = new Word("aei");
        assertEquals(1, word.getSyllables());
        
        word = new Word("wtf");
        assertEquals(1, word.getSyllables());
        
        word = new Word("on");
        assertEquals(1, word.getSyllables());
        
        word = new Word("ly");
        assertEquals(1, word.getSyllables());
        
        word = new Word("tf");
        assertEquals(1, word.getSyllables());
        
        word = new Word("a");
        assertEquals(1, word.getSyllables());
        
        word = new Word("L");
        assertEquals(1, word.getSyllables());
    }
    
    /**
     * Endings -es, -ed and -e (except -le) are ignored.
     */
    public void testGetSyllablesIgnoreEndings()
    {
        Word word = new Word("apples");
        assertEquals(1, word.getSyllables());
        
        word = new Word("les");
        assertEquals(1, word.getSyllables());
        
        word = new Word("lles");
        assertEquals(0, word.getSyllables());
        
        word = new Word("sliced");
        assertEquals(1, word.getSyllables());
        
        word = new Word("ied");
        assertEquals(1, word.getSyllables());
        
        word = new Word("wwed");
        assertEquals(0, word.getSyllables());
        
        word = new Word("late");
        assertEquals(1, word.getSyllables());
        
        word = new Word("are");
        assertEquals(1, word.getSyllables());
        
        word = new Word("cgge");
        assertEquals(0, word.getSyllables());
        
        word = new Word("apple");
        assertEquals(2, word.getSyllables());
    }
    
    /**
     * Consecutive vowels count as one syllable.
     */
    public void testGetSyllablesConsecutiveVowels()
    {
        Word word = new Word("head");
        assertEquals(1, word.getSyllables());
        
        word = new Word("headed");
        assertEquals(1, word.getSyllables());
        
        word = new Word("headle");
        assertEquals(2, word.getSyllables());
        
        word = new Word("bae");
        assertEquals(1, word.getSyllables());
    }

    /**
     * Test of toString method, of class Word.
     */
    public void testToString() 
    {
        Word word = new Word("word");
        
        assertEquals("word", word.getWord());
    }

    /**
     * Test of equals method, of class Word.
     */
    public void testEquals() 
    {
        Word word1 = new Word("word");
        Word word2 = new Word("word");
        Word word3 = new Word("wore");
        Word word4 = null;
        String word5 = "word";
        
        assertTrue(word1.equals(word2));
        assertTrue(word2.equals(word1));
        assertFalse(word1.equals(word3));
        assertFalse(word1.equals(word4));
        assertFalse(word1.equals(word5));
    }

}
