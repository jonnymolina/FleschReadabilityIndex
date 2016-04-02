import junit.framework.TestCase;

/**
 *
 * @author Jonathan Molina
 */
public class FleschComputeTest extends TestCase
{
    
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
        super.tearDown();
    }

    /**
     * Test of compute method, of class FleschCompute.
     */
    public void testCompute() {
        System.out.println("compute");
        FleschCompute instance = new FleschCompute();
        int expResult = 0;
        int result = instance.compute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
