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
 * WordList is a concrete implementation of the spaced repetition system. A
 * WordList object contains a Word and Integer arraylist. The orderMixer integer
 * sequence is used to present the Word list in psuedo-random order.
 *
 * @author Ben
 */
public class WordList implements LeitnerSystem {

    private ArrayList<Word> wordList;
    private ArrayList<Integer> orderMixer;
    private static final Integer MAXSIZE = 10;

    ;

    public WordList(DBTools db) {
        this.wordList = Compose(db);
        this.orderMixer = MixOrder(MAXSIZE);
    }

    /*
    Pulls ResultSets from the WORD table in order of leitner level.
    It populates 10 values, searching from high levels to low, until 10 are filled.
    @return wordList a collection of words for a session.
    */
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

    /*
    Creates an ArrayList of integers from 0-9, shuffles their values and returns
    the shuffled, psuedorandom values for mixing with the wordList.
    */
    private ArrayList MixOrder(int maxElementNumber) {
        orderMixer = new ArrayList<>();

        for (int i = 0; i < MAXSIZE; i++) {
            orderMixer.add(i);
        }
        Collections.shuffle(orderMixer);

        return orderMixer;
    }

    public ArrayList<Word> getWordList() {
        return this.wordList;
    }

    public ArrayList<Integer> getOrderMixer() {
        return this.orderMixer;
    }

    @Override
    public void IncrementLeitnerLevel(Word w, DBTools db) {
        w.setLeitnerLevel(w.getLeitnerLevel() + 1); // make value change to word object
        db.updateLeitnerLevel(w); // send changed object to db.
    }

    @Override
    public void ResetLeitnerLevel(Word w, DBTools db) {
        w.setLeitnerLevel(1); // make value change to word object
        db.resetLeitnerLevel(w); // send changed object to db.
    }
}
