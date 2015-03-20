
/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
{
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private int size;
    private Thing memoryThing;

    /**
     * constructor for level 0 node
     */
    public Node(int size) throws SizeException
    {
        if(size < Memory.MINIMUM_CHUNK_SIZE) 
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
     * standard constructor
     */
    public Node(Node parent, int size)
    {
        this.size = size;
        this.parent = parent;
    }

    /**
     * creates children for this node
     */
    public void procreate(Node a, Node b) 
    {
        leftChild = a;
		rightChild = b;
    }
    
    /**
     * destroys children
     */
    public void abortion()
    {
        leftChild = null;
        rightChild = null;
    }
    
    /**
     * adds something to this node
     */
    public void addThing(Thing thing)
    {
        memoryThing = thing;
    }
    
    /**
     * deletes the thing that was saved in this noed
     */
    public void deleteThing()
    {
        memoryThing = null;
    }
    
    /**
     * returns left child
     */
    public Node getLeftChild()
    {
        return leftChild;
    }
    
    /**
     * returns right child
     */
    public Node getRightChild()
    {
        return rightChild;
    }
    
    /**
     * returns parent
     */
    public Node getParent()
    {
        return parent;
    }
    
	/**
	 * returns the size of this chunk
	 */
	public int getSize()
	{
		return size;
	}
    /**
     * true if there is nothing saved in this node
     */
    public boolean isEmpty()
    {
        if(memoryThing == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * true if this node has no children and is empty
     */
    public boolean mergable()
    {
        if(leftChild == null && isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
