import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

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
    
    public FleschCompute()
    {
        doc = new Document();
    }
    
    public FleschCompute(Reader reader, Writer writer)
    {
        doc = new Document();
    }
    
    public int compute()
    {
        return 0;
    }
}
