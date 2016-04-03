import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Computes the given document's Flesch readability index.
 * 
 * @author Jonathan Molina
 */
public class FleschCompute
{
    private final Document doc;
    private InputStream inputStream;
    private OutputStream outputStream;
    
    /**
     * Using System.in and System.out for input and output.
     */
    public FleschCompute()
    {
        doc = new Document();
        inputStream = System.in;
        outputStream = System.out;
    }
    
    /**
     * Using specific reader and writers for input and output.
     * @param input the input
     * @param output the output
     */
    public FleschCompute(InputStream input, OutputStream output)
    {
        doc = new Document();
        inputStream = input;
        outputStream = output;
    }
    
    /**
     * Computes the Flesch readability index using the specified input and output
     * sources.
     * @return the Flesch readability index
     */
    public int compute()
    {
        Scanner scanner = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        
        scanner.useDelimiter("[.|!|?|:|;]");
        // delimit sentences from text
        while (scanner.hasNext())
        {
            String sentence = scanner.next();
            doc.append(sentence);
        }
        
        int intResult = 999;
        
        // check for a valid file
        if (doc.getNumSentences() != 0)
        {
            // compute values
            double sentences = doc.getNumSentences();
            double words = doc.getNumWords();
            double syllables = doc.getNumSyllables();

            // use equation
            double result = 
                    206.835 - 84.6 * syllables / words - 1.015 * words / sentences;
            intResult = (int) Math.round(result);

        }
        
        out.print(intResult);
        out.flush();
        out.close();
        
        return intResult;
    }
}
