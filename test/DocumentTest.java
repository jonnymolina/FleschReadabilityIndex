import junit.framework.TestCase;

/**
 * Tests the Document class.
 * @author Jonathan Molina
 */
public class DocumentTest extends TestCase
{
    
    /**
     * Constructs the test class.
     * @param testName test name
     */
    public DocumentTest(String testName)
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
     * Test of append method, of class Document.
     */
    public void testAppend() 
    {
        String s1 = "i'm like hey wussup helloo";
        String s2 = "1738";
        String s3 = "";
        String s4 = "\n\t       \n     ";
        String s5 = "YeAH $h3 fine";
        Document doc = new Document();
        
        doc.append(s2);
        assertEquals(0, doc.getNumSentences());
        assertEquals("", doc.toString());
        doc.append(s1);
        doc.append(s3);
        doc.append(s4);
        assertEquals(1, doc.getNumSentences());
        assertEquals(s1, doc.toString());
        doc.append(s5);
        assertEquals(2, doc.getNumSentences());
        assertEquals("i'm like hey wussup helloo\nYeAH h fine", doc.toString());
    }
    /**
     * Test of getNumSentences method, of class Document.
     */
    public void testGetNumSentences() 
    {
        String s1 = "i'm like hey wussup helloo";
        String s2 = "1738";
        String s3 = "";
        String s4 = "\n\t       \n     ";
        String s5 = "YeAH $h3 fine";
        Document doc = new Document();
        
        assertEquals(0, doc.getNumSentences());
        doc.append(s2);
        assertEquals(0, doc.getNumSentences());
        doc.append(s1);
        doc.append(s3);
        doc.append(s4);
        assertEquals(1, doc.getNumSentences());
        doc.append(s5);
        assertEquals(2, doc.getNumSentences());
    }

    /**
     * Test of getNumWords method, of class Document.
     */
    public void testGetNumWords() 
    {
        String s1 = "i'm like hey wussup helloo";
        String s2 = "1738";
        String s3 = "";
        String s4 = "\n\t       \n     ";
        String s5 = "YeAH $h3 fine";
        Document doc = new Document();
        
        assertEquals(0, doc.getNumWords());
        doc.append(s2);
        assertEquals(0, doc.getNumWords());
        doc.append(s1);
        doc.append(s3);
        doc.append(s4);
        assertEquals(5, doc.getNumWords());
        doc.append(s5);
        assertEquals(8, doc.getNumWords());
    }

    /**
     * Test of getNumSyllables method, of class Document.
     */
    public void testGetNumSyllables() 
    {
        String s1 = "i'm like hey wussup helloo";
        String s2 = "1738";
        String s3 = "";
        String s4 = "\n\t       \n     ";
        String s5 = "YeAH $h3 fine";
        Document doc = new Document();
        
        assertEquals(0, doc.getNumSyllables());
        doc.append(s2);
        assertEquals(0, doc.getNumSyllables());
        doc.append(s1);
        doc.append(s3);
        doc.append(s4);
        assertEquals(7, doc.getNumSyllables());
        doc.append(s5);
        assertEquals(10, doc.getNumSyllables());
    }

    /**
     * Test of toString method, of class Document.
     */
    public void testToString() 
    {
        String s1 = "i'm like hey wussup helloo";
        String s2 = "1738";
        String s3 = "";
        String s4 = "\n\t       \n     ";
        String s5 = "YeAH $h3 fine";
        Document doc = new Document();
        
        assertEquals("", doc.toString());
        doc.append(s2);
        assertEquals("", doc.toString());
        doc.append(s1);
        doc.append(s3);
        doc.append(s4);
        assertEquals(s1, doc.toString());
        doc.append(s5);
        assertEquals("i'm like hey wussup helloo\nYeAH h fine", doc.toString());
    }

    /**
     * Test of equals method, of class Document.
     */
    public void testEquals() 
    {
        Document doc1 = new Document();
        Document doc2 = new Document();
        Document doc3 = new Document();
        Document doc4 = null;
        String doc5 = "hi\nhow\nare\nyou";
        
        doc1.append("hi");
        doc1.append("how");
        doc1.append("are");
        doc1.append("you");
        
        doc2.append("hi");
        doc2.append("\n\t");
        doc2.append("how");
        doc2.append("are");
        doc2.append("");
        doc2.append("you");
        
        doc3.append("hi");
        doc3.append("how");
        doc3.append("are");
        doc3.append("yuo");
        
        assertEquals(doc1, doc2);
        assertFalse(doc1.equals(doc3));
        assertFalse(doc1.equals(doc4));
        assertFalse(doc1.equals(doc5));
    }

}
