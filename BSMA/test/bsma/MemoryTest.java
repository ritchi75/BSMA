package bsma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.31
 */
public class MemoryTest {

    private static Memory testMemory;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public MemoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SizeException {
        testMemory = new Memory(32);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isPowerOf2 method, of class Memory.
     * @throws bsma.SizeException
     */
    @Test
    public void testIsPowerOf2() throws SizeException {
        System.out.println("\n+++++ isPowerOf2 +++++");

        assert Memory.isPowerOf2(-1) == false;
        assert Memory.isPowerOf2(0) == false;
        assert Memory.isPowerOf2(1) == false;
        assert Memory.isPowerOf2(2) == true;
        assert Memory.isPowerOf2(303) == false;
        assert Memory.isPowerOf2(512) == true;
    }

    /**
     * Test of addData method, of class Memory.
     * @throws bsma.SizeException
     */
    @Test
    public void testAddData() throws SizeException {
        System.out.println("\n+++++ addData +++++");
        // Expect SizeException Throws
        // Data size = -1
        // Throws SizeException
        Memory memory = new Memory(64);
        System.out.println(memory.toString());
        System.out.println("add data process size 4");
        memory.addData(new Data("data", 4));
        System.out.println(memory.toString());
        System.out.println("add data process size 7");
        memory.addData(new Data("data1", 7));
        System.out.println(memory.toString());
        System.out.println("add data2 process size 19");
        memory.addData(new Data("data2", 19));
        System.out.println(memory.toString());
    }

    /**
     * Test of split method, of class Memory
     * @throws bsma.SizeException
     */
    @Test
    public void testSplit() throws SizeException {
        System.out.println("\n+++++ split +++++");

    // Adds Data of size 4 to Memory of size 32
        // The result should split the Memory into 4 Nodes of sizes 
        // 4, 4, 8, and 16
        Memory memory = new Memory(32);
        memory.addData(new Data("data", 4));
        assert (memory.getNode(0).getSize() == 4);
        assert (memory.getNode(1).getSize() == 4);
        assert (memory.getNode(2).getSize() == 8);
        assert (memory.getNode(3).getSize() == 16);
        System.out.println(memory.toString());
    // Adds Data of size 8 to Memory of size 32
        // The result should split the Memory into 3 Nodes of sizes 
        // 8, 8, and 16
        Memory memory1 = new Memory(32);
        memory1.addData(new Data("data", 8));
        assert (memory1.getNode(0).getSize() == 8);
        assert (memory1.getNode(1).getSize() == 8);
        assert (memory1.getNode(2).getSize() == 16);
        // Adds Data of size 3 to Memory of size 64
        // The result should split the Memory into 5 Nodes of sizes 
        // 4, 4, 8, 16 and 32
        Memory memory2 = new Memory(64);
        memory2.addData(new Data("data", 3));
        assert (memory2.getNode(0).getSize() == 4);
        assert (memory2.getNode(1).getSize() == 4);
        assert (memory2.getNode(2).getSize() == 8);
        assert (memory2.getNode(3).getSize() == 16);
        assert (memory2.getNode(4).getSize() == 32);
    }

    /**
     * Test of deleteData method, of class Memory.
     * @throws bsma.SizeException
     */
    @Test
    public void testDeleteData() throws SizeException {
        System.out.println("\n+++++ deleteData +++++");
        Memory memory = new Memory(64);
        memory.addData(new Data("Test", 17));
        System.out.println(memory.toString());
        memory.deleteData(0);
        System.out.println(memory.toString());
    }

    /**
     * Test of getIndex method, of class Memory.
     * @throws bsma.SizeException
     */
    @Test
    public void testGetIndex() throws SizeException {
        System.out.println("\n+++++ getIndex +++++");
        Memory memory = new Memory(64);
        memory.addData(new Data("data", 3));
        memory.addData(new Data("data1", 15));
        memory.addData(new Data("data3", 31));
        System.out.println(memory.toString());

        assert (memory.getNode(0).getData().getSize() == 3);
        assert (memory.getNode(1).getData() == null);
        assert (memory.getNode(3).getData().getName().equals("data1"));
        assert (memory.getNode(4).getData().getSize() == 31);
    }

    /**
     * Test of getTotalWasted method, of class Memory.
     * @throws bsma.SizeException 
     */
    @Test
    public void testGetTotalWasted() throws SizeException {
        System.out.println("\n+++++ getTotalWasted +++++");
        Memory memory = new Memory(64);
        memory.addData(new Data("Test", 17));
        System.out.println(memory.getTotalWasted());
    }

    /**
     * Test of getTotalAvailable method, of class Memory.
     * @throws bsma.SizeException
     */
    @Test
    public void testGetTotalAvailable() throws SizeException {
        System.out.println("\n+++++ getTotalAvailable +++++");
        Memory memory = new Memory(64);
        memory.addData(new Data("Test", 32));
        System.out.println(memory.getTotalAvailable());
    }

    /**
     * Test of getNode method, of class Memory
     * @throws bsma.SizeException
     */
    @Test
    public void testGetNode() throws SizeException {
        System.out.println("\n+++++ getNode +++++");
        Memory memory = new Memory(32);
        assert (memory.getNode(0).getSize() == 32);
    }

    /**
     * Test of clearMemory method, of class Memory.
     * @throws bsma.SizeException
     */
    @Test
    public void testClearMemory() throws SizeException {
        System.out.println("\n+++++ clearMemory +++++");
        Memory memory = new Memory(64);
        memory.addData(new Data("data", 3));
        memory.addData(new Data("data1", 15));
        memory.addData(new Data("data3", 31));
        System.out.println(memory.toString());
        System.out.println("active ClearMemory");
        memory.clearMemory();
        System.out.println(memory.toString());
    }

    /**
     * Test of toString method, of class Memory.
     * @throws bsma.SizeException
     */
    @Test
    public void testToString() throws SizeException {
        System.out.println("\n+++++ toString +++++");
        exception.expect(SizeException.class);
        Memory testMemory = new Memory(64);
        System.out.println(testMemory.toString());
        testMemory = new Memory(62);
        System.out.println(testMemory.toString());
    }
}
