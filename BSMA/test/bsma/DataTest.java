package bsma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

/**
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version 2015.03.31
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
     * Test of the minimum Data size, of class Data
     * 
     * @throws bsma.SizeException
     */
    @Test
    public void testMinimumDataSize() throws SizeException {
        exception.expect(SizeException.class);
        Data testData = new Data("this should fail", 0);
        testData = new Data("this should also fail", -7);
    }

}
