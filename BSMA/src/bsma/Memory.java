 

import java.util.ArrayList;

/**
 * The Memory class represents our Memory object which can have Data
 * added and removed from it. It uses an ArrayList of Nodes which have two
 * children and a parent, save the root, like that of a BinaryTree.
 * This tree expands and retracts depending on what Data objects are added or
 * removed.
 * Buddy system - If two Nodes containing Data are the same size and are next
 * to each other in the ArrayList, and are then both removed, these two empty
 * Nodes will combine. 
 * 
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.27
 */
public class Memory
{
   public static int MEMORY_SIZE;
    public static final int MINIMUM_CHUNK_SIZE = 4;
    private static ArrayList<Node> leaves;
    private Node root;
    
    /**
     * 
     */
    public Memory(int size) throws SizeException 
    {
        if(size < MINIMUM_CHUNK_SIZE)
        {
            throw new SizeException("memory too small");
        }
        else if(!isPowerOf2(size))
        {
            throw new SizeException("memoy not a power of 2");
        }
        else
        {
            MEMORY_SIZE = size;
            leaves = new ArrayList<Node>();
            root = new Node(size);
            leaves.add(root);
        }
    }
    
    /**
     * returns true if the input number is a power of 2
     */
    public static boolean isPowerOf2(int x)
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
     * adds a file to memory
     */
    public void addData(Data d) throws SizeException
    {
        if(d.size() > largestAvailableChunk())
        {
            throw new SizeException("SizeException thrown on add");
        }
        else
        {
            int chunkSize = findSmallestUsableChunkSize(d.size());
            int chunk = getChunkOfSize(chunkSize);
            if(leaves.get(chunk).getSize() == chunkSize)
            {
                leaves.get(chunk).addData(d);
            }
            else
            {
                split(chunk, chunkSize);
                leaves.get(chunk).addData(d);
            }
        }
    }
    
    /**
     * 
     * @param n
     * @param size 
     */
    private void split(int n, int size) throws SizeException
    {
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
                Node leftChild = new Node(parent, parent.getSize() / 2);
                Node rightChild = new Node(parent, parent.getSize() / 2);
                parent.setChildren(leftChild, rightChild);
                leaves.set(n, leftChild);
                leaves.add(n+1, rightChild);
            }
        }
    }
    
    /**
     * returns the size of the largest avalible chunk. if there
     * are no chunks avalible, returns 0
     */
    private int largestAvailableChunk()
    {
        int largest = 0;
        for(int i = 0; i < leaves.size(); i++)
        {
            Node n = leaves.get(i);
            if(n.isEmpty() && n.getSize() > largest)
            {
                largest = n.getSize();
            }
        }
        
        return largest;
    }
    
    /**
     * returns the size of the smallest chunk that will store a file
     * of the input size
     */
    private int findSmallestUsableChunkSize(int fileSize)
    {
        int returnValue = 0;
        for(int i = MINIMUM_CHUNK_SIZE; i <= MEMORY_SIZE && returnValue == 0; i = i * 2)
        {
            if(i >= fileSize)
            {
                returnValue = i;
            }
        }
        return returnValue;
    }
    
    /**
     * returns the index location of the first avalible chunck
     * of size "chunk Size."  if there is no chunk of that size
     * avalible, the smallest chunck avilble will be returned instead
     */
    private int getChunkOfSize(int chunkSize)
    {
        for(int i = 0; i < leaves.size(); i++)
        {
            Node n = leaves.get(i);
            if(n.getSize() == chunkSize && n.isEmpty())
            {
                return i;
            }
        }
        
        int smallestChunkSoFar = (largestAvailableChunk() + 1);
        int smallest = -1;
        for(int i = 0; i < leaves.size(); i++)
        {
            Node n = leaves.get(i);
            if(n.isEmpty() && n.getSize() < smallestChunkSoFar && n.getSize() > chunkSize)
            {
                smallest = i;
                smallestChunkSoFar = n.getSize();
            }
        }
        return smallest;
    }
    
    /**
     * deletes data from a spacific memory chunk
     */
    public void deleteData(int index) throws NullPointerException
    {
        Node node = leaves.get(index);
        if(node.isEmpty())
        {
            throw new NullPointerException("momory position " + index + " is empty");
        }
        else
        {
            node.deleteData();
            try
            {
                merge(index);
            }
            catch (NullPointerException n)
            {
                /*nothing happens.  if a null pointer if caught, we have reached the root*/
            }
        }
    }
    
    /**
     * returns the index position of a peice of data specifiec by name
     */
    public int getIndex(String name) throws NullPointerException
    {
        for(int i = 0; i < leaves.size(); i++)
        {
            try
            {
                if(leaves.get(i).getData().name().equals(name))
                {
                    return i;
                }
            }
            catch (NullPointerException n)
            {
                continue;
            }
        }
        throw new NullPointerException("file name does not exist");
    }
    
    /**
     * starts at a specified memory and runs up the tree structure merging node
     */
    private void merge(int index)
    {
        int leftChild = -1;
        Node parent = leaves.get(index).getParent();
        while(parent.getLeftChild().mergable() && parent.getRightChild().mergable())
        {
            if(parent.getLeftChild().equals(leaves.get(index)))
            {
                leftChild = index;
            }
            else
            {
                leftChild = (index - 1);
                index--;
            }
            leaves.set(leftChild, parent);
            leaves.remove(leftChild +1 );
            parent.deleteChildren();
            parent = parent.getParent();
        }
    }
    
    /**
     * returns a String representation of Memory in its current state
     * @return 
     */
    @Override
    public String toString() {
        String memString = "The current size of the memory system is " + MEMORY_SIZE + "\n";
        if(leaves.isEmpty()) {
            memString += "There is currently no data saved in the memory system.";
        } else {
            for (int i = 0; i < leaves.size(); i++) {
                memString += i + ":  " + leaves.get(i).toString() + "\n";
            }
            }
        return memString;
    }
}
