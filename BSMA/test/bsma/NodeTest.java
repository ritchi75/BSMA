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
public class NodeTest {
	
	public NodeTest() {
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
	 * Test of setChildren method, of class Node.
	 */
	@Test
	public void testSetChildren() {
		System.out.println("setChildren");
		Node a = null;
		Node b = null;
		Node instance = null;
		instance.setChildren(a, b);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteChildren method, of class Node.
	 */
	@Test
	public void testDeleteChildren() {
		System.out.println("deleteChildren");
		Node instance = null;
		instance.deleteChildren();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addData method, of class Node.
	 */
	@Test
	public void testAddData() {
		System.out.println("addData");
		Data data = null;
		Node instance = null;
		instance.addData(data);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteData method, of class Node.
	 */
	@Test
	public void testDeleteData() {
		System.out.println("deleteData");
		Node instance = null;
		instance.deleteData();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getData method, of class Node.
	 */
	@Test
	public void testGetData() {
		System.out.println("getData");
		Node instance = null;
		Data expResult = null;
		Data result = instance.getData();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLeftChild method, of class Node.
	 */
	@Test
	public void testGetLeftChild() {
		System.out.println("getLeftChild");
		Node instance = null;
		Node expResult = null;
		Node result = instance.getLeftChild();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRightChild method, of class Node.
	 */
	@Test
	public void testGetRightChild() {
		System.out.println("getRightChild");
		Node instance = null;
		Node expResult = null;
		Node result = instance.getRightChild();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getParent method, of class Node.
	 */
	@Test
	public void testGetParent() {
		System.out.println("getParent");
		Node instance = null;
		Node expResult = null;
		Node result = instance.getParent();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getSize method, of class Node.
	 */
	@Test
	public void testGetSize() {
		System.out.println("getSize");
		Node instance = null;
		int expResult = 0;
		int result = instance.getSize();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of isEmpty method, of class Node.
	 */
	@Test
	public void testIsEmpty() {
		System.out.println("isEmpty");
		Node instance = null;
		boolean expResult = false;
		boolean result = instance.isEmpty();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of mergable method, of class Node.
	 */
	@Test
	public void testMergable() {
		System.out.println("mergable");
		Node instance = null;
		boolean expResult = false;
		boolean result = instance.mergable();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getWasted method, of class Node.
	 */
	@Test
	public void testGetWasted() {
		System.out.println("getWasted");
		Node instance = null;
		int expResult = 0;
		int result = instance.getWasted();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class Node.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Node instance = null;
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
