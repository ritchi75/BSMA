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
import org.junit.rules.ExpectedException;
import org.junit.Rule;

/**
 *
 * @author LENOVO
 */
public class DataTest {
	private static Data testData;
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	public DataTest() {
	}
	
	@BeforeClass
	public static void setUpClass() throws SizeException {
	   
	    
	    
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() throws SizeException {
	     testData = new Data("this is a test", 6);
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of getName method, of class Data.
	 */
	@Test
	public void testGetName() {
		assert testData.getName().equals("this is a test");
	}

	/**
	 * Test of getSize method, of class Data.
	 */
	@Test
	public void testGetSize() {
		assert testData.getSize() == 6;
	}

	/**
	 * Test of toString method, of class Data.
	 */
	@Test
	public void testToString() {
		assert testData.toString().equals("Data Name: this is a test --- File Size: 6");
	}
	
	/**
	 * 
	 */
	@Test
	public void testMinimumDataSize() throws SizeException
	{
	    exception.expect(SizeException.class);
	    Data testData = new Data("this should fail", 0);
	    testData = new Data("this should also fail", -7);
	}
	
}
