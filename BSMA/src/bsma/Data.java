package bsma;  

/**
 * The Data Object is added and removed from Memory.
 * On creation it's given a name and size, and it fits in chunks of memory
 * with a size the next power of 2 greater than itself.
 * 
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.29
 */
public class Data
{
    private String name;
    private int size;
    
    /**
     * constructor for the data class
     */
    public Data(String name, int size) throws SizeException
    {
        if(size > 0)
        {
            this.name = name;
            this.size = size;
        }
        else
        {
            throw new SizeException("file size must be positive.");
        }
    }
    
    /**
     * @return data name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return data size
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * @return a String representation of the Data object  
     */
    @Override
    public String toString() {
        return "Data Name: " + name + " --- File Size: " + size;
    }
}
