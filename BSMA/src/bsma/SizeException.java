package bsma;

/**
 * Exception thrown when a number input is too small or too large.
 */
public class SizeException
    extends Exception
{
    public SizeException(String s)
    {
        super(s);
    }  
}  