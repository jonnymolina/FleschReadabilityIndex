import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(new File("test3.txt"));
        scanner.useDelimiter("[.|!|?|:|;]");
        
//        for (int i = 0; scanner.hasNext(); i++)
//        {
//            System.out.print(i + ": ");
//            System.out.println(scanner.next());
//        }
//        
        //String str = "?^()hel<>lo!\n ^wh$at% up 13.42 -@dude- 1738    yo-o!@#$!";
        //String str = "^^?3490what's!$#@%#@$134 ~<uuuup> -%doo? ha-ha!";
        String str = "#$can't9* \\\"ain't,\\\" 234ABC 123 23abn45 @#$aba34dfs#$% @a@e@i@o@u@";
        //System.out.println("result:" + str.replaceAll("(\\w+)\\p{Punct}(\\s|$)", ""));
        //System.out.println("result:" + str.replaceAll("([a-z]+)[?:!.,;]*", "$1"));
//        String[] array = str.split("[^a-zA-Z]+");
        String[] array = str.split("[\\s]+");//\\d+.*
        //String[] array = str.split("[\\s\\d+(\\.\\d+)]+");
        String regex = "[^a-zA-z]";
        System.out.println("array size: " + array.length);
        for (String string : array)
        {
            System.out.println(string + " -- result: " + string.matches(regex));
            String word2 = string.replaceFirst("^[^a-zA-Z]+", "");
            String word3 = word2.replaceAll("[^a-zA-Z]+$", "");
            System.out.println("\tword2: "+ word3 + ", size: " + word3.length());
        }
        
        String newWord = "--hel^lo--".replaceFirst("^[^a-zA-Z]+", "");
        System.out.println("res: " + newWord);
        System.out.println("newword: " +newWord.replaceAll("[^a-zA-Z]+$", ""));
           
    }
     
    
        
    
    public static String removePunctuation(String word){
         
        StringBuilder sb = new StringBuilder("");
         
        for(int i=0; i<word.length();i++){
             
            if(Character.isLetterOrDigit(word.charAt(i))){
                sb.append(word.charAt(i));
            }
        }
         
        return sb.toString();
    }
}
//^()hel<>lo!
// ^wh$at% up -@lol-     wh-y