
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
        else if(!isPowerOf2(size))
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
     * returns true if the input number is a power of 2
     */
    private boolean isPowerOf2(int x)
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
     * creates children for this node
     */
    public void procreate() throws SizeException
    {
        if(size/2 < Memory.MINIMUM_CHUNK_SIZE)
        {
            throw new SizeException("tried to create a chunck less than minumum:  " + Memory.MINIMUM_CHUNK_SIZE);
        }
        else
        {
            leftChild = new Node(this, size/2);
            rightChild = new Node(this, size/2);
        }
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
