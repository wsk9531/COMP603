/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class SpanishToEnglish implements LeitnerSystem {
    ArrayList<Word> wordList;

    public SpanishToEnglish(DBTools db) {
        
        wordList = Compose(db);
    }
    
    private ArrayList<Word> Compose(DBTools db) {
        ResultSet WordTable;
        wordList = new ArrayList<>();
        Word tempWord = new Word();
        
        for (int i = 4; i > 0; i--) {
            try {
              WordTable = db.retrieveWordTable(i);

                while (WordTable.next() && (wordList.size() <= 10)) {
                    System.out.println(WordTable.getString(1));
                    System.out.println(WordTable.getString(4));
// add word to word array up to 10 from 5, then 4, then 3, then 2, then 1
//randomly mix them (factorial function to reduce index placement in array) sort)
//

                }
            } catch (SQLException ex) {
                Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return wordList;
    }
    
    @Override
    public void IncrementLeitnerLevel(Word w) {
        w.setLeitnerLevel(w.getLeitnerLevel()+1);
    }

    @Override
    public void ResetLeitnerLevel(Word w) {
        w.setLeitnerLevel(0);
    }
    
}
