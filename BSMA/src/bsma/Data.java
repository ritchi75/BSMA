 package bsma;

/**
 * The Data Object is added and removed from Memory
 * 
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.27
 */
public class Data
{
    public String name;
    public int size;
    
    public Data(String name, int size)
    {
        this.name = name;
        this.size = size;
    }
    
    /**
     * Returns data name
     */
    public String name()
    {
        return name;
    }
    
    /**
     * Returns data size
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Gets a String representation of the Data object 
     * @return 
     */
    @Override
    public String toString() {
        return "Data Name: " + name + " Size: " + size;
    }
}
