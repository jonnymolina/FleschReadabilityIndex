import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The class that contains the main and will run the program.
 * 
 * @author Jonathan Molina
 */
public class FleschApp
{
    /**
     * Launches Flesch Readability program using the desired
     * source of user input and output.  The default is to accept user input
     * from System.in and display to System.out.
     *
     * @param args Any non-empty first argument will be interpreted as the name of 
     * a file in the same directory as the program that contains the 
     * user input data.
     * Any non-empty second argument will be interpreted as the name of 
     * a file in the same directory as the program to which the output
     * is to be written.
     * @throws FileNotFoundException if the file isn't found.
     * @throws IOException if an illegal IO operation is attempted.
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        FleschCompute comp = null;
        
        // check for default
        if (args.length == 0)
        {
            comp = new FleschCompute();
        }
        // check if specified an input but not output
        else if (args.length == 1)
        {
            comp = new FleschCompute(new FileInputStream(args[0]), System.out);
        }
        // check if specified both an input and output
        else if (args.length == 2)
        {
            comp = new FleschCompute(
                    new FileInputStream(args[0]), new FileOutputStream(args[1]));
        }
        
        comp.compute();
    }
}