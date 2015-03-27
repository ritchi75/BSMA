package bsma;

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
    private static ArrayList<Node> node_list;
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
            node_list = new ArrayList<>();
            root = new Node(size);
            node_list.add(root);
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
            while(node_list.get(n).getSize() > size)
            {
                Node parent = node_list.get(n);
                Node leftChild = new Node(parent, parent.getSize() / 2);
                Node rightChild = new Node(parent, parent.getSize() / 2);
                parent.addChildren(leftChild, rightChild);
                node_list.set(n, leftChild);
                node_list.add(n+1, rightChild);
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
    public void delData(Data data){
    	delProc(root,data);
    }
   // take file out from the chunk 
    public void delProc(Node root,Data data) {
      Node parent = root;
        if (parent.getLeftChild() == null) {
            System.out.println("nothing there");
        }else{
        if (parent.getRightChild().getData().getName() == data.name) {
            if (parent.getLeftChild().getData().getName() == null && parent.getRightChild().getLeftChild() == null &&
										parent.getLeftChild().getLeftChild() == null) {
                parent.deleteChildren();
                backtrack(parent);
            
        } else if (parent.getLeftChild().getData().name == data.name) {
            if (parent.getRightChild().getData().name == null && parent.getRightChild().getLeftChild() == null 
										&& parent.getLeftChild().getLeftChild() == null) {
                parent.deleteChildren();
                backtrack(parent);
            }else if(parent.getRightChild().getData().name == data.name){
            	parent.getRightChild().deleteData();
            } 
            else if(parent.getRightChild().getData().name == data.name){
                parent.getLeftChild().deleteData();
            }

        } else {
            delProc(parent.getLeftChild(), data);
            delProc(parent.getRightChild(), data);
        }
    }
				}
		}
    public void backtrack(Node position){
     Node current = position.getParent();
     if(current.getRightChild().getData() == null&& current.getRightChild().getLeftChild() == null
    	&& current.getLeftChild().getData() == null&& current.getLeftChild().getLeftChild() == null	 ){
    	 current.deleteChildren();
    	 backtrack(current);
     }else{
    	 System.out.println("reset done");
     }
    }
    private int largestAvailableChunk()
    {
        int largest = 0;
        for(int i = 0; i < node_list.size(); i++)
        {
            Node n = node_list.get(i);
            if(n.isEmpty() && n.getSize() > largest)
            {
                largest = n.getSize();
            }
        }
        
        return largest;
    }
    
    /**
     * returns the size of the smallest chunk that will store a data
     * of the input size
     */
    private int findSmallestUsableChunkSize(int dataSize)
    {
        int returnValue = 0;
        for(int i = MINIMUM_CHUNK_SIZE; i <= MEMORY_SIZE && returnValue == 0; i = i * 2)
        {
            if(i >= dataSize)
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
        // Get first empty node of chunkSize
        // Or next largest to split
        for(int i = 0; i < node_list.size(); i++)
        {
            Node n = node_list.get(i);
            if(n.getSize() == chunkSize && n.isEmpty())
            {
                return i;
            }
            else if(n.getSize() > chunkSize && n.isEmpty()){
                return i;
            }
        }
        // No possible chunks >= dataSize
        // SizeException will have already been thrown in add()
        return 0;
    }
    
    
    /**
     * Adds data of a user-determined size to memory
     * @param d    Your Data to add
     * @throws SizeException 
     */
    public void add(Data d) throws SizeException
    {
        if(d.size() > largestAvailableChunk())
        {
            throw new SizeException("SizeException thrown on add");
        }
        else
        {
            // chunkSize contains the size of the chunk in memory to be
            // assigned to this data
            int chunkSize = findSmallestUsableChunkSize(d.size());
            // chunk contains the position in which to ADD, or SPLIT
            // and then ADD the data
            int memory_chunk = getChunkOfSize(chunkSize);
            
            // ADD
            if(node_list.get(memory_chunk).getSize() == chunkSize)
            {
                node_list.get(memory_chunk).addData(d);
            }
            // SPLIT and then ADD
            else
            {
                split(memory_chunk, chunkSize);
                node_list.get(memory_chunk).addData(d);
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
        if(node_list.isEmpty()) {
            memString += "There is currently no data saved in the memory system.";
        } else {
            for (Node leaf : node_list) {
                memString += leaf.toString() + "\n";
            }
            }
        return memString;
    }
}
