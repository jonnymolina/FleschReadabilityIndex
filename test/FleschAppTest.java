import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import junit.framework.TestCase;

/**
 * Tests the FleschApp class.
 * @author Jonathan Molina
 */
public class FleschAppTest extends TestCase
{
    /**
     * Constructor for this test class.
     * @param testName test name
     */
    public FleschAppTest(String testName)
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
     * Test of main method, of class FleschApp.
     */
    public void testMain() throws Exception
    {
        String input1 =  "";

        InputStream stream = 
                new ByteArrayInputStream(input1.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        
        String[] args1 = {};
        FleschApp.main(args1);
        assertEquals("999", os.toString());
        
        stream = new ByteArrayInputStream(input1.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);
        os = new ByteArrayOutputStream();
        ps = new PrintStream(os);
        System.setOut(ps);
        
        String[] args2 = {"shakespeare-romeo-48.txt"};
        FleschApp.main(args2);
        assertEquals("88", os.toString());
        
        System.setIn(System.in);
        System.setOut(System.out);
        
        String[] args3 = {"shakespeare-romeo-48.txt", "shakespeare-romeo-48.out"};
        FleschApp.main(args3);
        Scanner scanner = new Scanner(new File("shakespeare-romeo-48.out"));
        assertEquals("88", scanner.next());
    }

}
