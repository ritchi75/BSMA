 

/**
 * This exception is thrown by the Memory, Node, and Data class if 
 * an invalid memory, memory chunk, or file size is entered.
 */
public class SizeException
    extends Exception
{
    public SizeException(String s)
    {
        super(s);
    }  
}  