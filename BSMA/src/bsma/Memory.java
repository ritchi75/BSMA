package bsma;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Observable;
import java.util.Observer;


/**
 * The Memory class represents our Memory object which can have Data added and
 * removed from it. It uses an ArrayList of Nodes which have two children and a
 * parent, save the root, like that of a BinaryTree. This tree expands and
 * retracts depending on what Data objects are added or removed. Buddy system -
 * If two Nodes containing Data are the same size and are next to each other in
 * the ArrayList, and are then both removed, these two empty Nodes will combine.
 *
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.29
 */
public class Memory extends Observable{

    public static int MEMORY_SIZE;
    public static final int MINIMUM_CHUNK_SIZE = 4;
    private static ArrayList<Node> leaves;
    private Node root;
    private final ArrayList<Observer> observers = new ArrayList<>();

    /**
     *
     * @param size
     * @throws bsma.SizeException
     */
    public Memory(int size) throws SizeException {
        if (size < MINIMUM_CHUNK_SIZE) {
            throw new SizeException("input size too small.\nmust "
                    + "be greater than " + MINIMUM_CHUNK_SIZE);
        } else if (!isPowerOf2(size)) {
            throw new SizeException("memory size must be a power "
                    + "of 2");
        } else {
            MEMORY_SIZE = size;
            leaves = new ArrayList<>();
            root = new Node(size);
            leaves.add(root);
        }
        addObserver((Observer) new BSMAGui());
        setChanged();
        notifyObservers(leaves);
    }

    /**
     * Returns true if number x is a power of 2 Used to check if Memory is a
     * valid size on creation.
     *
     * @param x
     * @return true or false
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
     * Adds a new Data object to Memory
     *
     * @param d Your Data object
     * @throws SizeException
     */
    public void addData(Data d) throws SizeException {
        if (d.getSize() > largestAvailableChunk()) {
            throw new SizeException("no chunks large enough to fit a file "
                    + "of size " + d.getSize());
        } else {
            int chunkSize = findSmallestUsableChunkSize(d.getSize());
            int chunk = getChunkOfSize(chunkSize);
            if (leaves.get(chunk).getSize() == chunkSize) {
                leaves.get(chunk).addData(d);
            } else {
                split(chunk, chunkSize);
                leaves.get(chunk).addData(d);
            }
        }
        setChanged();
        notifyObservers(leaves);
    }

    /**
     * Splits a chunk of memory in two in order to add a new Data object
     *
     * @param n Index
     * @param size chunk size you want
     */
    private void split(int n, int size) throws SizeException {
        if (size < MINIMUM_CHUNK_SIZE) {
            throw new SizeException("cannont create a chunck size less thatn "
                    + MINIMUM_CHUNK_SIZE);
        } else {
            Node parent = leaves.get(n);
            Node leftChild = null;
            Node rightChild = null;
            while (parent.getSize() > size) {
                leftChild = new Node(parent, parent.getSize() / 2, parent.getLocation());
                rightChild = new Node(parent, parent.getSize() / 2, parent.getLocation() + parent.getSize() / 2);
                parent.setChildren(leftChild, rightChild);
                leaves.add(n + 1, rightChild);
                parent = leftChild;
            }
            leaves.set(n, leftChild);
        }
    }

    /**
     * Returns the size of the largest available chunk. If there are no chunks
     * available, returns 0
     */
    private int largestAvailableChunk() {
        int largest = 0;
        for (int i = 0; i < leaves.size(); i++) {
            Node n = leaves.get(i);
            if (n.isEmpty() && n.getSize() > largest) {
                largest = n.getSize();
            }
        }
        return largest;
    }

    /**
     * Returns the size of the smallest chunk that will store a file of the
     * input size.
     *
     * @param dataSize Size of Data you are saving
     * @return
     */
    private int findSmallestUsableChunkSize(int dataSize) {
        if(dataSize <= 4) {
            return 4;
        } else {
            int power = (int)Math.ceil(Math.log10(dataSize)/Math.log10(2));
            return (int) Math.pow(2, power);
        }
    }

    /**
     * Returns the index location of the first available chunk of size
     * chunkSize. If there is no chunk of that size available, the smallest
     * chuck available will be returned instead.
     *
     * @param chunkSize Size of chunk desired
     * @return
     */
    private int getChunkOfSize(int chunkSize) {
        int smallestChunkSoFar = (largestAvailableChunk() + 1);
        int smallest = -1;
        for (int i = 0; i < leaves.size(); i++) {
            Node n = leaves.get(i);
            if (n.isEmpty() && n.getSize() < smallestChunkSoFar && n.getSize() >= chunkSize) {
                smallest = i;
                smallestChunkSoFar = n.getSize();
            }
        }
        return smallest;
    }

    /**
     * Deletes Data from desired Memory Node
     *
     * @param index Node you'd like to delete Data from
     * @throws NullPointerException
     */
    public void deleteData(int index) throws NullPointerException {
        Node node = leaves.get(index);
        if (node.isEmpty()) {
            throw new NullPointerException("memory position " + index + " is empty");
        } else {
            node.deleteData();
            try {
                merge(index);
            } catch (NullPointerException n) {
                /* nothing happens. If a null pointer if caught,
                 we have reached the root */
            }
        }
        setChanged();
        notifyObservers(leaves);
    }

    /**
     * Returns the index position of Data specified by name. This is used to
     * delete said Data from Memory.
     *
     * @param location
     * @return
     * @throws NullPointerException
     */
    public int getIndex(int location) throws NullPointerException {
        for (int i = 0; i < leaves.size(); i++) {
            try {
                if (leaves.get(i).getLocation() == location) {
                    return i;
                }
            } catch (NullPointerException n) {
            }
        }
        throw new NullPointerException("not a valid memory location");
    }

    /**
     * Starts at a specified Memory location and backtracks up the tree
     * structure merging nodes where possible.
     *
     * @param index
     */
    private void merge(int index) {
        Node parent = leaves.get(index).getParent();
        while (parent.getLeftChild().mergeable() && parent.getRightChild().mergeable()) {

            if (!(parent.getLeftChild().equals(leaves.get(index)))) {
                index--;
            }
            leaves.set(index, parent);
            leaves.remove(index + 1);
            parent.deleteChildren();
            parent = parent.getParent();
        }
    }

    /**
     * @return the total amount of wasted memory in the system
     */
    public int getTotalWasted() {
        int wasted = 0;
        for (Node leaf : leaves) {
            wasted += leaf.getWasted();
        }
        return wasted;
    }

    /**
     * @return the total amount of available memory that can be used to save
     * Data
     */
    public int getTotalAvailable() {
        int available = 0;
        for (Node leaf : leaves) {
            if (leaf.isEmpty()) {
                available += leaf.getSize();
            }
        }
        return available;
    }
    /**
     * support method check if the data is empty or not.
     * @param index
     * @return 
     */
    public boolean isNull(int index){
        if(leaves.get(index).isEmpty()){
            return false;
        }else{
            return true;
        }
        
    }
    /**
     * Wipe memory clean for fresh start without rerunning.
     */
    public void clearMemory() {
        leaves.clear();
        root.deleteChildren();
        root.deleteData();
        leaves.add(root);
    }

		/**
		 * Get a Node from the ArrayList
		 * @param index where you want to get Node
		 * @return The Node in that index
		 */
		public Node getNode(int index){
			return leaves.get(index);
		}
		
    /**
     * returns a String representation of Memory in its current state
     *
     * @return
     */
    @Override
    public String toString() {
        String memString = "The current size of the memory system is " + MEMORY_SIZE + "\n";
        if (leaves.isEmpty()) {
            memString += "There is currently no data saved in the memory system.";
        } else {
            for (int i = 0; i < leaves.size(); i++) {
                memString += i + ":  " + leaves.get(i).toString() + "\n";
            }
        }
        return memString;
    }
}
