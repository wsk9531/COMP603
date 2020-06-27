/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public class WordList {
    private ArrayList<ArrayList<Word>> list;
    
    public WordList(ResultSet rs) {
        populateWordList(rs);
    };
    
    public ArrayList<ArrayList<Word>> populateWordList(ResultSet rs) {
        
        return list;
    }
    
    
    
    
    
    
}
