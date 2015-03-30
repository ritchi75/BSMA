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
	public void testIsPowerOf2() {
		System.out.println("isPowerOf2");
		int x = 0;
		boolean expResult = false;
		boolean result = Memory.isPowerOf2(x);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addData method, of class Memory.
	 */
	@Test
	public void testAddData() throws Exception {
		System.out.println("addData");
		Data d = null;
		Memory instance = null;
		instance.addData(d);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
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
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
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
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
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
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
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
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of clearMemory method, of class Memory.
	 */
	@Test
	public void testClearMemory() {
		System.out.println("clearMemory");
		Memory instance = null;
		instance.clearMemory();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
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
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
