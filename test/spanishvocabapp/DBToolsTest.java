/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests various DB functions
 * @author Ben
 */
public class DBToolsTest {
    
    public DBToolsTest() {
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
     * Test of checkAndCreateTable method, of class DBTools.
     */
    @Test
    public void testCheckAndCreateTable() {
        System.out.println("checkAndCreateTable");
        DBTools instance = new DBTools();
        boolean expResult = false;
        boolean result = instance.checkAndCreateTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateTableFromText method, of class DBTools.
     */
    @Test
    public void testPopulateTableFromText() {
        System.out.println("populateTableFromText");
        DBTools instance = new DBTools();
        instance.populateTableFromText();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToDB method, of class DBTools.
     */
    @Test
    public void testAddToDB() {
        System.out.println("addToDB");
        int index = 0;
        int leitner = 0;
        int nextTest = 0;
        String span = "";
        String grammar = "";
        String eng = "";
        String gender = "";
        DBTools instance = new DBTools();
        instance.addToDB(index, leitner, nextTest, span, grammar, eng, gender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveWordTable method, of class DBTools.
     */
    @Test
    public void testRetrieveWordTable() {
        System.out.println("retrieveWordTable");
        int level = 0;
        DBTools instance = new DBTools();
        ResultSet expResult = null;
        ResultSet result = instance.retrieveWordTable(level);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateLeitnerLevel method, of class DBTools.
     */
    @Test
    public void testUpdateLeitnerLevel() {
        System.out.println("updateLeitnerLevel");
        Word w = null;
        DBTools instance = new DBTools();
        instance.updateLeitnerLevel(w);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetLeitnerLevel method, of class DBTools.
     */
    @Test
    public void testResetLeitnerLevel() {
        System.out.println("resetLeitnerLevel");
        Word w = null;
        DBTools instance = new DBTools();
        instance.resetLeitnerLevel(w);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
