/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import static java.lang.Integer.parseInt;
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
        System.out.println(wordList);
    }
    
    private ArrayList<Word> Compose(DBTools db) {
        ResultSet WordTable;
        wordList = new ArrayList<>();
        
        
        for (int i = 4; i > 0; i--) {
            try {
              WordTable = db.retrieveWordTable(i);

                while (WordTable.next() && (wordList.size() < 10)) {
                    
                    Word tempWord = new Word();
                    int tempNumber;
                    
                    tempWord.setIndex(tempNumber = parseInt(WordTable.getString(1)));
                    tempWord.setLeitnerLevel(tempNumber = parseInt(WordTable.getString(2)));
                    tempWord.setNextTestSession(tempNumber = parseInt(WordTable.getString(3)));
                    tempWord.setSpanishMeaning(WordTable.getString(4));
                    tempWord.setGrammarType(WordTable.getString(5));
                    tempWord.setEnglishMeaning(WordTable.getString(6));
                    tempWord.setGender(WordTable.getString(7));
                    
                   wordList.add(tempWord);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //TODO Assert WordList has 10 things in it
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
