 package bsma;

/**
 * The File class represents files that interact with the Memory class
 * by being added or deleted
 * 
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.20
 */
public class File
{
    public String name;
    public int size;
    
    public File(String name, int size)
    {
        this.name = name;
        this.size = size;
    }
    
    /**
     * returns file name
     */
    public String name()
    {
        return name;
    }
    
    /**
     * returns file size
     */
    public int size()
    {
        return size;
    }
    
    /**
     * get a String representation of the File object 
     * @return 
     */
    @Override
    public String toString() {
        return "File Name: " + name + " Size: " + size;
    }
}
