
import bsma.File;
import bsma.Memory;


/**
 * The Node class represents our "chunks" of memory that can hold files.
 * The root node is the user-determined size of Memory.memory_size. It's
 * children are Memory.memory_size / 2 and so on.
 * 
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.20
 */
public class Node {

	private Node parent;
	private Node leftChild;
	private Node rightChild;
	private int size;
	private File file;

	/**
	 * constructor for level 0 node (ROOT)
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
	 * standard constructor
	 */
	public Node(Node parent, int size) {
		this.size = size;
		this.parent = parent;
	}

	/**
	 * creates children for this node
	 */
	public void procreate(Node a, Node b) {
		leftChild = a;
		rightChild = b;
	}

	/**
	 * destroys children
	 */
	public void deleteChildren() {
		leftChild = null;
		rightChild = null;
	}

	/**
	 * returns left child
	 */
	public Node getLeftChild() {
		return leftChild;
	}

	/**
	 * returns right child
	 */
	public Node getRightChild() {
		return rightChild;
	}

	/**
	 * returns parent
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * returns the size of this chunk
	 */
	public int getSize() {
		return size;
	}

	/**
	 * true if there is nothing saved in this node
	 */
	public boolean isEmpty() {
		if (file == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * true if this node has no children and is empty
	 */
	public boolean mergable() {
		if (leftChild == null && isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
