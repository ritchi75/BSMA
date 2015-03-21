
/**
 * Write a description of class Chunk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chunk
{
    private int size;
    private File file;

    /**
     * Constructor for objects of class Chunk
     */
    public Chunk(int size) throws SizeException
    {
        if(size < MemoryArrayBased.MINIMUM_CHUNK_SIZE) 
        {
            throw new SizeException("size is to small");
        }
        else if(!Memory.isPowerOf2(size))
        {
            throw new SizeException(size + " is not a power of 2");
        }
        else
        this.size = size;
    }

    /**
     * returns the size of the chunk
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * adds a file to this chunk
     */
    public void addFile(File f)
    {
        file = f;
    }
    
    /**
     * removes the file stored at this chunk
     */
    public void removeFile()
    {
        file = null;
    }
    
    /**
     * teturns true if this chunk has no file stored in it
     */
    public boolean isEmpty()
    {
        if(file == null)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
