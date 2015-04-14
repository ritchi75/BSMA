package bsma;

/**
 * The Node class represents objects in our "tree" that function as chunks of
 * our Memory object and can contain Data objects or be empty.
 *
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.29
 */
public class Node {

    private Node parent; // all nodes have a parent except the root 
    private Node leftChild; // all nodes that are not leaves have 2 children
    private Node rightChild; // the left and right child of any node are buddies
    private int size; // size of this particular chunk of memory(power of 2)
    private Data data; // represents the data that is stored in this chunk
    private int location;
    /**
     * Constructor for root of new tree.
     *
     * @param size of the node
     * @throws SizeException
     */
    public Node(int size) throws SizeException {
        if (size < Memory.MINIMUM_CHUNK_SIZE) {
            throw new SizeException("chunk size is to small");
        } else if (!Memory.isPowerOf2(size)) {
            throw new SizeException(size + " is not a power of 2");
        } else {
            this.size = size;
        }
    }

    /**
     * Standard constructor for new Node object
     *
     * @param parent Parent Node
     * @param size Size of Node
     * @param locat
     */
    public Node(Node parent, int size, int locat) {
        this.size = size;
        this.parent = parent;
        this.location = locat;
    }

    /**
     * Creates a left and right child for this Node
     *
     * @param left Left child of this Node
     * @param right Right child of this Node
     */
    public void setChildren(Node left, Node right) {
        leftChild = left;
        rightChild = right;
    }

    /**
     * Deletes both of the Nodes children
     */
    public void deleteChildren() {
        leftChild = null;
        rightChild = null;
    }
    /**
     * 
     * @return location;
     */
    public int getLocation(){
        return location;
    }
    
    /**
     * Adds Data to this Node
     *
     * @param data Data we are storing in this chunk
     */
    public void addData(Data data) {
        this.data = data;
    }

    /**
     * Deletes the Data that was saved to this node
     */
    public void deleteData() {
        data = null;
    }

    /**
     * @return the data held in this node
     */
    public Data getData() {
        return data;
    }

    /**
     * @return left child
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     * @return right child
     */
    public Node getRightChild() {
        return rightChild;
    }

    /**
     * @return parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @return the size of this node
     */
    public int getSize() {
        return size;
    }

    /**
     * @return True if there is nothing saved in this node
     */
    public boolean isEmpty() {
        return data == null;
    }

    /**
     * @return True if this node has no children and is empty
     */
    public boolean mergeable() {
        // children are always generated in twos
        // if the leftChild is null, it has no right child either
        return leftChild == null && data == null;
    }

    /**
     * @return the amount of wasted memory in this particular chunk
     */
    public int getWasted() {
        if (!isEmpty()) {
            return size - getData().getSize();
        } else {
            return 0;
        }
    }

    /**
     * @return a String representation of the current state of the Node
     */
    @Override
    public String toString() {
        String returnString = "Chunk Size: " + size;
        if (data == null) {
            returnString += "  --- empty ---";
        } else {
            returnString += " " + data.toString(); 
        }
        return returnString + " Location: " + location;
    }
}
