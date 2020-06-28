/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * test cases for various wordList functions to ensure optimal function.
 * @author Ben
 */
public class WordListTest {
    
    public WordListTest() {
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
     * Test of getWordList method, of class WordList.
     */
    @Test
    public void testGetWordList() {
        System.out.println("getWordList");
        WordList instance = null;
        ArrayList<Word> expResult = null;
        ArrayList<Word> result = instance.getWordList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrderMixer method, of class WordList.
     */
    @Test
    public void testGetOrderMixer() {
        System.out.println("getOrderMixer");
        WordList instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getOrderMixer();
        assertEquals(expResult, result);

    }

    /**
     * Test of IncrementLeitnerLevel method, of class WordList.
     */
    @Test
    public void testIncrementLeitnerLevel() {
        System.out.println("IncrementLeitnerLevel");
        Word w = null;
        DBTools db = null;
        WordList instance = null;
        instance.IncrementLeitnerLevel(w, db);
    }

    /**
     * Test of ResetLeitnerLevel method, of class WordList.
     */
    @Test
    public void testResetLeitnerLevel() {
        System.out.println("ResetLeitnerLevel");
        Word w = null;
        DBTools db = null;
        WordList instance = null;
        instance.ResetLeitnerLevel(w, db);
    }
    
}
