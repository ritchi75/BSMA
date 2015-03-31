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

/**
 *
 * @author LENOVO
 */
public class MemoryTest {
	
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
	public void testAddData() throws Exception {
		System.out.println("addData");
		
		// Data size = -1
		Data data = new Data("Test", -1);
		Memory memory = new Memory(32);
		memory.addData(data);
		
		// Data size = 0
		Data data1 = new Data("Test", 0);
		Memory memory1 = new Memory(32);
		memory1.addData(data1);
		
		// Data size = 1
		Data data2 = new Data("Test", 1);
		Memory memory2 = new Memory(32);
		memory1.addData(data2);
		
		// Data size = 4
		Data data3 = new Data("Test", 4);
		Memory memory3 = new Memory(32);
		memory1.addData(data3);
		
		// Data size = 
		Data data4 = new Data("Test", 0);
		Memory memory4 = new Memory(32);
		memory1.addData(data4);
		
		// 
		Data data5 = new Data("Test", 0);
		Memory memory5 = new Memory(32);
		memory1.addData(data5);
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
