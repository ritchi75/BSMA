import java.util.ArrayList;

/**
 * Write a description of class Memory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Memory
{
    public static int MEMORY_SIZE;
    public static final int MINIMUM_CHUNK_SIZE = 4;
    
    /**
     * 
     */
    public Memory(int size) throws SizeException 
    {
        if(size < MINIMUM_CHUNK_SIZE)
        {
            throw new SizeException("memory too small");
        }
        else if(!isPowerOf2(size))
        {
            throw new SizeException("memory not a power of 2");
        }
        else
        {
            MEMORY_SIZE = size;
        }
    }
    
    /**
     * returns true if the input number is a power of 2
     */
    public static boolean isPowerOf2(int x)
    {
        if(x < 2)
        {
            return false;
        }
        while(x != 1)
        {
            if(x%2 == 1)
            {
                return false;
            }
            x = x/2;
        }
        return true;
    }
    
    /**
     * 
     */
    public void procreate(Node parent) throws SizeException
    {
        if(parent.getSize()/2 < MINIMUM_CHUNK_SIZE) 
        {
            throw new SizeException("tried to create a chunk smaller than minimum");
        }
        else
        {
            parent.procreate(new Node(parent, parent.getSize()), new Node(parent, parent.getSize()));
        }
    }
    
}


    