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

	private Node parent;
	private Node leftChild;
	private Node rightChild;
	private int size;
	private Data data;

	/**
	 * Constructor for root of new tree.
	 *
	 * @param size
	 * @throws SizeException
	 */
	public Node(int size) throws SizeException {
		if (size < Memory.MINIMUM_CHUNK_SIZE) {
			throw new SizeException("size is to small");
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
	 */
	public Node(Node parent, int size) {
		this.size = size;
		this.parent = parent;
	}

	/**
	 * Creates a left and right child for this Node
	 * @param a
	 * @param b
	 */
	public void setChildren(Node a, Node b) {
		leftChild = a;
		rightChild = b;
	}

	/**
	 * Deletes both of the Nodes children
	 */
	public void deleteChildren() {
		leftChild = null;
		rightChild = null;
	}

	/**
	 * Adds Data to this Node
	 * @param data 
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
		if (data == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return True if this node has no children and is empty
	 */
	public boolean mergable() {
		if (leftChild == null && isEmpty()) {
			return true;
		} else {
			return false;
		}
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
		if (this.isEmpty()) {
			returnString = "This chunk is empty!";
		} else {
			returnString += " " + data.toString();
		}
		return returnString;
	}
}
