import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import junit.framework.TestCase;

/**
 * Tests the FleschCompute class.
 * @author Jonathan Molina
 */
public class FleschComputeTest extends TestCase
{
    /**
     * Constructs this test class.
     * @param testName test name
     */
    public FleschComputeTest(String testName)
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
        System.setIn(System.in);
        System.setOut(System.out);
    }

    /**
     * Test of compute method, of class FleschCompute.
     */
    public void testComputeSystemInSystemOut()
    {
        FleschCompute comp;
        ByteArrayOutputStream os;

        String input1 =  "";
        String input2 = "1738";
        String input3 = "\n     \t\n\t              98";
        
        String s1 = "The quick brown fox jumped over the lazy dog.";
        String s2 = "hi!how are you?";
        String s3 = "Im' LiKE 1738 heEy wuS0P H3LLO";        
        String s4 = "#$can't9* \"ain't,\" 234ABC 23abn45 @#$aba34dfs#$% @a@e@i@o@u@";

        os = setSystemInSystemOut(input1);
        comp = new FleschCompute();
        assertEquals(999, comp.compute());
        
        os = setSystemInSystemOut(input2);
        comp = new FleschCompute();
        assertEquals(999, comp.compute());
        
        os = setSystemInSystemOut(input3);
        comp = new FleschCompute();
        assertEquals(999, comp.compute());
        
        os = setSystemInSystemOut(s1);
        comp = new FleschCompute();
        assertEquals(94, comp.compute());
        
        os = setSystemInSystemOut(s2);
        comp = new FleschCompute();
        assertEquals(120, comp.compute());
        
        os = setSystemInSystemOut(s3);
        comp = new FleschCompute();
        assertEquals(117, comp.compute());
        
        os = setSystemInSystemOut(s4);
        comp = new FleschCompute();
        assertEquals(46, comp.compute());
    }
    
    /**
     * Test of compute method, of class FleschCompute.
     */
    public void testComputeReadFromFilesOutputToFile()
        throws FileNotFoundException, IOException
    {
        String file1 = "shakespeare-romeo-48.txt";
        String file1out = "shakespeare-romeo-48.out";
        String file2 = "twain-tom-40.txt";
        String file2out = "twain-tom-40.out";
        String file3 = "anonymous-beowulf-543.txt";
        String file3out = "anonymous-beowulf-543.out";
        String file4 = "plato-republic-762.txt";
        String file4out = "plato-republic-762.out";
        
        FileInputStream reader = new FileInputStream(file1);
        FileOutputStream writer = new FileOutputStream(file1out);
        FleschCompute comp = new FleschCompute(reader, writer);
        assertEquals(88, comp.compute());
        
        reader = new FileInputStream(file2);
        writer = new FileOutputStream(file2out);
        comp = new FleschCompute(reader, writer);
        assertEquals(88, comp.compute());
        
        reader = new FileInputStream(file3);
        writer = new FileOutputStream(file3out);
        comp = new FleschCompute(reader, writer);
        assertEquals(81, comp.compute());
        
        reader = new FileInputStream(file4);
        writer = new FileOutputStream(file4out);
        comp = new FleschCompute(reader, writer);
        assertEquals(73, comp.compute());
    }
    
    private ByteArrayOutputStream setSystemInSystemOut(String input)
    {
        InputStream stream = 
                new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        return os;
    }
}
