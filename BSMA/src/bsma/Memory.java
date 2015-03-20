package bsma;

import java.util.ArrayList;

/**
 * The Memory class represents the amount of memory available in your "system"
 * It has a size and final MINIMUM_CHUNK_SIZE
 *
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.20
 */
public class Memory {

	public static int memory_size;
	public static final int MINIMUM_CHUNK_SIZE = 4;
	private static ArrayList<Node> leaves;

	/**
	 *
	 */
	public Memory(int size) throws SizeException {
		if (size < MINIMUM_CHUNK_SIZE) {
			throw new SizeException("memory too small");
		} else if (!isPowerOf2(size)) {
			throw new SizeException("memory not a power of 2");
		} else {
			memory_size = size;
			leaves = new ArrayList<Node>();
		}
	}

	/**
	 * returns true if the input number is a power of 2
	 */
	public static boolean isPowerOf2(int x) {
		if (x < 2) {
			return false;
		}
		while (x != 1) {
			if (x % 2 == 1) {
				return false;
			}
			x = x / 2;
		}
		return true;
	}

	/**
	 *
	 */
	public void procreate(Node parent) throws SizeException {
		if (parent.getSize() / 2 < MINIMUM_CHUNK_SIZE) {
			throw new SizeException("tried to create a chunk smaller than minimum");
		} else {
			parent.procreate(new Node(parent, parent.getSize()), new Node(parent, parent.getSize()));
		}
	}

	/**
	 * 
	 * @param n
	 * @param size 
	 */
	public void split(int n, int size){
			if(size < MINIMUM_CHUNK_SIZE)
			{
				throw new SizeException("Size exception thrown on split()");
			}
			else //do split stuff
			{
				// TODO why error?
				while(leaves.get(n).getSize() > size)
				{
					Node parent = leaves.get(n);
					Node leftChild = new Node(parent,parent.getSize() / 2);
					Node rightChild = new Node(parent,parent.getSize() / 2);
					parent.procreate(leftChild, rightChild);
					leaves.set(leftChild);
					leaves.add(rightChild);
				}
		}
	}
	
	/**
	 * 
	 * @param parent
	 * @param data 
	 */
	public void delProc(Node parent, String data) {
		if (parent.leftChild = null) {
			
		}
		if (parent.rightChild.file.name == data) {
			if (parent.leftChild.file.name == null && parent.rightChild.leftChild == null && parent.leftChild.leftChild == null) {
				parent.deleteChildren();
			} else {
				parent.rightChild.file.name = null;
			}
		} else if (parent.leftChild.file.name == data) {
			if (parent.rightChild.file.name == null && parent.rightChild.leftChild == null && parent.leftChild.leftChild == null) {
				parent.deleteChildren();
			} else {
				parent.leftChild.data = null;
			}

		} else {
			delProc(parent.leftChild, data);
			delProc(parent.rightChild, data);
		}
	}

}
