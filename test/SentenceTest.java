import junit.framework.TestCase;

/**
 * Tests the Sentence class.
 * @author Jonathan Molina
 */
public class SentenceTest extends TestCase
{
    /**
     * Class constructor.
     * @param testName test name
     */
    public SentenceTest(String testName)
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
     * Test of getNumWords method, of class Sentence.
     */
    public void testGetNumWords() 
    {
        String s1 = "The quick brown fox jumped over the lazy dog.";
        String s1p = "The quick brown fox jumped over the lazy dog";
        String s2 = "^^@3490what's!$#@%#@$134 ~<uuuup> -%doo? ha-ha!";
        String s2p = "what's uuuup doo ha-ha";
        String s3 = "Im' LiKE 1738 heEy wuS0P H3LLO";
        String s3p = "Im LiKE heEy wuS0P H3LLO";
        
        assertEquals(9, new Sentence(s1).getNumWords());
        System.out.println(new Sentence(s2).toString());
        assertEquals(4, new Sentence(s2).getNumWords());
        assertEquals(5, new Sentence(s3).getNumWords());
    }

    /**
     * Test of getTotalSyllables method, of class Sentence.
     */
    public void testGetTotalSyllables() 
    {
        String s1 = "The quick brown fox jumped over the lazy dog.";
        String s1p = "The quick brown fox jumped over the lazy dog";
        String s2 = "^^@3490what's!$#@%#@$134 ~<uuuup> -%doo? ha-ha!";
        String s2p = "what's uuuup doo ha-ha";
        String s3 = "Im' LiKE 1738 heEy wuS0P H3LLO";
        String s3p = "Im LiKE heEy wuS0P H3LLO";
        
        assertEquals(11, new Sentence(s1).getTotalSyllables());
        assertEquals(5, new Sentence(s2).getTotalSyllables());
        assertEquals(5, new Sentence(s3).getTotalSyllables());
    }

    /**
     * Test of toString method, of class Sentence.
     */
    public void testToString() 
    {
        String s1 = "The quick brown fox jumped over the lazy dog.";
        String s1p = "The quick brown fox jumped over the lazy dog";
        String s2 = "^^@3490what's!$#@%#@$134 ~<uuuup> -%doo? ha-ha!";
        String s2p = "what's uuuup doo ha-ha";
        String s3 = "Im' LiKE 1738 heEy wuS0P H3LLO";
        String s3p = "Im LiKE heEy wuS0P H3LLO";
        String s4 = "#$can't9* \\\"ain't,\\\" 234ABC 123 23abn45 "
                    + "@#$aba34dfs#$% @a@e@i@o@u@";
        String s4p = "can't ain't ABC abn aba34dfs a@e@i@o@u";
        
        assertEquals(s1p, new Sentence(s1).toString());
        assertEquals(s2p, new Sentence(s2).toString());
        assertEquals(s3p, new Sentence(s3).toString());
        assertEquals(s4p, new Sentence(s4).toString());
    }

    /**
     * Test of equals method, of class Sentence.
     */
    public void testEquals() 
    {
        Sentence sentence1 = new Sentence("hi how are you??");
        Sentence sentence2 = new Sentence("hi how are you??");
        Sentence sentence3 = new Sentence("hi~~ how13 &are you?");
        Sentence sentence4 = new Sentence("hi are how you");
        Sentence sentence5 = null;
        String sentence6 = "hi how are you??";
        
        assertEquals(sentence1, sentence2);
        assertEquals(sentence1, sentence3);
        assertFalse(sentence1.equals(sentence4));
        assertFalse(sentence1.equals(sentence5));
        assertFalse(sentence1.equals(sentence6));
    }

}
