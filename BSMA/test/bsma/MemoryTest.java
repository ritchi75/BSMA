/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author LENOVO
 */
public class MemoryTest {
	
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
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of isPowerOf2 method, of class Memory.
	 */
	@Test
	public void testIsPowerOf2() throws SizeException {
		System.out.println("isPowerOf2 \n");
		int x = 0;
		
		Memory memory1 = new Memory(32);
		Memory memory2 = new Memory(32);
		Memory memory3 = new Memory(32);
		Memory memory4 = new Memory(32);
		Memory memory5 = new Memory(32);
		Memory memory6 = new Memory(32);
		
		memory1.isPowerOf2(-1);
		boolean expResult = false;
		boolean result = Memory.isPowerOf2(x);
		assertEquals(expResult, result);
		
		memory2.isPowerOf2(0);
		expResult = false;
		result = Memory.isPowerOf2(x);
		assertEquals(expResult, result);
		
		memory3.isPowerOf2(1);
		expResult = false;
		result = Memory.isPowerOf2(x);
		assertEquals(expResult, result);
		
		memory4.isPowerOf2(2);
		expResult = false;
		result = Memory.isPowerOf2(x);
		assertEquals(expResult, result);
		
		memory5.isPowerOf2(3);
		expResult = false;
		result = Memory.isPowerOf2(x);
		assertEquals(expResult, result);
		
		memory6.isPowerOf2(4);
		expResult = false;
		result = Memory.isPowerOf2(x);
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of addData method, of class Memory.
	 */
	@Test
	public void testAddData() throws SizeException {
		System.out.println("addData");
		
		// Expect SizeException Throws
		exception.expect(SizeException.class);
		
		// Data size = -1
		// Throws SizeException
		Data data = new Data("Test", -1);
		Memory memory = new Memory(32);
		memory.addData(data);
		
		// Data size = 0
		// Throws SizeException
		Data data1 = new Data("Test1", 0);
		Memory memory1 = new Memory(32);
		memory1.addData(data1);
				
		// Data size = 1
		Data data2 = new Data("Test2", 1);
		Memory memory2 = new Memory(32);
		memory2.addData(data2);
		
		// Data size = 4
		Data data3 = new Data("Test3", 4);
		Memory memory3 = new Memory(32);
		memory3.addData(data3);
		
		// Data size = 32
		Data data4 = new Data("Test4", 32);
		Memory memory4 = new Memory(32);
		memory4.addData(data4);
		
		// Data size = 33
		// Throws SizeException
		Data data5 = new Data("Test5", 33);
		Memory memory5 = new Memory(32);
		memory5.addData(data5);
		
		// Data size = 4
		// Memory size = 30 (Not power of 2 but shouldn't effect method)
		Data data6 = new Data("Test6", 4);
		Memory memory6 = new Memory(30);
		memory6.addData(data6);
	}

	
	/**
	 * Test of split method, of class Memory
	 */
	public void testSplit() throws SizeException{
		System.out.println("addData");
		
		// Expect SizeException Throws
		exception.expect(SizeException.class);
		
		Memory memory = new Memory(32);
		
	}
	
	/**
	 * Test of deleteData method, of class Memory.
	 */
	@Test
	public void testDeleteData() {
		System.out.println("deleteData");
		int index = 0;
		Memory instance = null;
		instance.deleteData(index);
	}

	/**
	 * Test of getIndex method, of class Memory.
	 */
	@Test
	public void testGetIndex() {
		System.out.println("getIndex");
		String name = "";
		Memory instance = null;
		int expResult = 0;
		int result = instance.getIndex(name);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getTotalWasted method, of class Memory.
	 */
	@Test
	public void testGetTotalWasted() {
		System.out.println("getTotalWasted");
		Memory instance = null;
		int expResult = 0;
		int result = instance.getTotalWasted();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getTotalAvailable method, of class Memory.
	 */
	@Test
	public void testGetTotalAvailable() {
		System.out.println("getTotalAvailable");
		Memory instance = null;
		int expResult = 0;
		int result = instance.getTotalAvailable();
		assertEquals(expResult, result);
	}

	/**
	 * Test of clearMemory method, of class Memory.
	 */
	@Test
	public void testClearMemory() {
		System.out.println("clearMemory");
		Memory instance = null;
		instance.clearMemory();
	}

	/**
	 * Test of toString method, of class Memory.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Memory instance = null;
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
	
}
