package bsma;

import java.util.ArrayList;

/**
 * Write a description of class Memory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
                parent.procreate(leftChild, rightChild);
                leaves.set(n, leftChild);
                leaves.add(n+1, rightChild);
            }
        }
    }
    
    /**
     * 
     * @param parent
     * @param data 
     
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
    */
    
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
        
        int smallestChunkSoFar = largestAvailableChunk();
        int smallest = 0;
        for(int i = 0; i < leaves.size(); i++)
        {
            Node n = leaves.get(i);
            if(n.isEmpty() && n.getSize() < smallestChunkSoFar)
            {
                smallest = i;
            }
        }
        return smallest;
    }
    
    /**
     * adds a file to memory
     */
    public void add(File f) throws SizeException
    {
        if(f.size() > largestAvailableChunk())
        {
            throw new SizeException("SizeException thrown on add");
        }
        else
        {
            int chunkSize = findSmallestUsableChunkSize(f.size());
            int chunk = getChunkOfSize(chunkSize);
            if(leaves.get(chunk).getSize() == chunkSize)
            {
                leaves.get(chunk).addThing(f);
            }
            else
            {
                split(chunk, chunkSize);
                leaves.get(chunk).addThing(f);
            }
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
            memString += "There are currently no files saved in the memory system.";
        } else {
            for (Node leaf : leaves) {
                memString += leaf.toString() + "\n";
            }
            }
        return memString;
    }
}
