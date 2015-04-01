package bsma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

/**
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.31
 */
public class NodeTest {

    private static Node testNode;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public NodeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SizeException {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SizeException {
        testNode = new Node(8);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setChildren method, of class Node.
     */
    @Test
    public void testSetChildren() throws SizeException {
        System.out.println("setChildren");
        Node left = new Node(4);
        Node right = new Node(4);
        testNode.setChildren(left, right);

        assert testNode.getLeftChild() == left;
        assert testNode.getRightChild() == right;
    }

    /**
     * Test of deleteChildren method, of class Node.
     */
    @Test
    public void testDeleteChildren() {
        System.out.println("deleteChildren");
        testNode.deleteChildren();
        
        assert testNode.getLeftChild() == null;
        assert testNode.getRightChild() == null;
    }

    /**
     * Test of addData method, of class Node.
     *
     * @throws bsma.SizeException
     */
    @Test
    public void testAddData() throws SizeException {
        System.out.println("addData");
        Data data = new Data("this should work", 5);
        testNode.addData(data);
        
        assert testNode.getData() == data;
    }

    /**
     * Test of deleteData method, of class Node.
     */
    @Test
    public void testDeleteData() {
        System.out.println("deleteData");
        testNode.deleteData();
        testNode.getData();
        
        assert testNode.getData() == null;
    }

    /**
     * Test of getData method, of class Node.
     * @throws bsma.SizeException
     */
    @Test
    public void testGetData() throws SizeException{
        System.out.println("getData");
        Data data1 = new Data("this will work", 7);
        testNode.addData(data1);
        Data data2 = testNode.getData();
        
        assert data1 == data2;
        
        
    }

    /**
     * Test of getLeftChild method, of class Node.
     * @throws bsma.SizeException
     */
    @Test
    public void testGetLeftChild() throws SizeException {
        System.out.println("getLeftChild");
        testNode = new Node(8);
        Node expectedLeft = new Node(4);
        Node right = new Node(4);
        testNode.setChildren(expectedLeft, right);
        Node left = testNode.getLeftChild();
        
        assert left == expectedLeft;
    }

    /**
     * Test of getRightChild method, of class Node.
     * @throws bsma.SizeException
     */
    @Test
    public void testGetRightChild() throws SizeException {
        System.out.println("getLeftChild");
        testNode = new Node(8);
        Node left = new Node(4);
        Node expectedRight = new Node(4);
        testNode.setChildren(left, expectedRight);
        Node right = testNode.getRightChild();
        
        assert right == expectedRight;
    }

    /**
     * Test of getParent method, of class Node.
     * @throws bsma.SizeException
     */
    @Test
    public void testGetParent() throws SizeException {
        System.out.println("getParent");
        testNode = new Node(8);
        Node left = new Node(testNode, 4);
        Node right = new Node(testNode, 4);
        testNode.setChildren(left, right);
        Node expectedParent = testNode;
        Node parent = left.getParent();
        
        assert parent == expectedParent;
    }

    /**
     * Test of getSize method, of class Node.
     * @throws bsma.SizeException
     */
    @Test
    public void testGetSize() throws SizeException {
        System.out.println("getSize");
        testNode = new Node(32);
        int size = testNode.getSize();
        
        assert size == 32;
    }

    /**
     * Test of isEmpty method, of class Node.
     * @throws bsma.SizeException
     */
    @Test
    public void testIsEmpty() throws SizeException {
        System.out.println("isEmpty");
        testNode = new Node(16);
        boolean result1 = testNode.isEmpty();
        
        assert result1 == true;
        
        testNode = new Node(16);
        Data data = new Data("this will work", 9);
        testNode.addData(data);
        boolean result2 = testNode.isEmpty();
        
        assert result2 == false;
        
        
    }

    /**
     * Test of mergeable method, of class Node.
     * @throws bsma.SizeException
     */
    @Test
    public void testMergeable() throws SizeException {
        System.out.println("mergable");
        testNode = new Node(16);
        boolean result = testNode.mergeable();
        
        assert result == true;
    }

    /**
     * Test of getWasted method, of class Node.
     * @throws bsma.SizeException
     */
    @Test
    public void testGetWasted() throws SizeException {
        System.out.println("getWasted");
        testNode = new Node(16);
        Data data = new Data("this will work", 7);
        testNode.addData(data);
        int result = testNode.getWasted();
        
        assert result == 9;
    }

    /**
     * Test of toString method, of class Node.
     * @throws bsma.SizeException
     */
    @Test
    public void testToString() throws SizeException {
        testNode = new Node(8);
        Data data = new Data("this will work", 6);
        testNode.addData(data);
        
        assert testNode.toString().equals("Chunk Size: 8 Data Name: this "
                + "will work --- File Size: 6");
    }
    
    /**
     * Test of the minimum Node size, of class Node
     * 
     * @throws bsma.SizeException
     */
    @Test
    public void testMinimumNodeSize() throws SizeException {
        exception.expect(SizeException.class);
        testNode = new Node(1);
        testNode = new Node(-5);
        // both should fail
    }

}
