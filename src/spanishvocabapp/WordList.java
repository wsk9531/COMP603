/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class WordList implements LeitnerSystem {
    private ArrayList<Word> wordList;
    private ArrayList<Integer> orderMixer;
    private static final Integer MAXSIZE = 10; ;

    public WordList(DBTools db) {
        
        this.wordList = Compose(db);
        this.orderMixer = MixOrder(MAXSIZE);
    }
    
    private ArrayList<Word> Compose(DBTools db) {
        ResultSet WordTable;
        this.wordList = new ArrayList<>();
        
        
        for (int i = 4; i > 0; i--) {
            try {
              WordTable = db.retrieveWordTable(i);

                while (WordTable.next() && (wordList.size() < MAXSIZE)) {
                    
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
    
    private ArrayList MixOrder(int maxElementNumber) {
        orderMixer = new ArrayList<>();

        for (int i = 0; i < MAXSIZE; i++) {
            orderMixer.add(i);
        }  
        Collections.shuffle(orderMixer);
        
        return orderMixer;
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
