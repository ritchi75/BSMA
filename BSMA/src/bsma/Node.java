 
/**
 * The Node class represents objects in our "tree" that function as chunks
 * of our Memory object and can contain Data objects or be empty.
 * 
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.27
 */
public class Node
{
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private int size;
    private Data data;

    /**
     * Constructor for root node
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
     * Standard constructor
     */
    public Node(Node parent, int size)
    {
        this.size = size;
        this.parent = parent;
    }

    /**
     * Creates children for this Node
     */
    public void setChildren(Node a, Node b) 
    {
        leftChild = a;
        rightChild = b;
    }
    
    /**
     * Deletes children
     */
    public void deleteChildren()
    {
        leftChild = null;
        rightChild = null;
    }
    
    /**
     * Adds File to this node
     */
    public void addData(Data data)
    {
        this.data = data;
    }
    
    /**
     * Deletes the File that was saved in this node
     */
    public void deleteData()
    {
        data = null;
    }
    
    /**
     * returns the data held in this node
     */
    public Data getData()
    {
        return data;
    }
    
    /**
     * Returns left child
     */
    public Node getLeftChild()
    {
        return leftChild;
    }
    
    /**
     * Returns right child
     */
    public Node getRightChild()
    {
        return rightChild;
    }
    
    /**
     * Returns parent
     */
    public Node getParent()
    {
        return parent;
    }
    
    /**
     * returns the size of this node
    */
    public int getSize()
    {
    return size;
    }
    
    /**
     * True if there is nothing saved in this node
     */
    public boolean isEmpty()
    {
        if(data == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * True if this node has no children and is empty
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
    
    /**
     * get a String representation of the current state of the Node 
     * @return 
     */
    @Override
    public String toString() {
        String returnString = "Chunk Size: " + size;
        if(data != null) {
            returnString += " " + data.toString();
        }
        return returnString;
    }
}
