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
    private int location;
    private int size;
    
    /**
     * constructor for the data class
     * @param location of the data we are creating that will serve as unique id
     * @param size of the data which will determine what size memory chunk will
     * be needed to save this particular data
     * @throws bsma.SizeException
     */
    public Data(int loca, int size) throws SizeException
    {
        if(size > 0)
        {
            this.location = loca;
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
    public int getLocation()
    {
        return location;
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
        return "Data Name: " + location + " --- File Size: " + size;
    }
}
