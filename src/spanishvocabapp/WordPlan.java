/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

/**
 *
 * @author Ben
 */
/**
 * Abstract Class representing a Word. Contains a 6- & 5-parameter constructor,
 * get and set methods, a CompareTo override to compare Strings, and a
 * toString.
 *
 * @author Ben
 */
public abstract class WordPlan implements Comparable<Word> {

    private int index;
    private int leitnerLevel;
    private int nextTestSession;
    private String englishMeaning;
    private String spanishMeaning;
    private String grammarType;
    private String gender;

    // constructor for gendered word
    public WordPlan(int index, int leitnerLevel, int nextTestSession,
            String englishMeaning, String spanishMeaning, 
            String grammarType, String gender) {
        this.index = index;
        this.leitnerLevel = leitnerLevel;
        this.nextTestSession = nextTestSession;
        this.englishMeaning = englishMeaning;
        this.spanishMeaning = spanishMeaning;
        this.grammarType = grammarType;
        this.gender = gender;
    }

    //empty constructor
    public WordPlan() {
        this.index = 0;
        this.leitnerLevel = 0;
        this.nextTestSession = 0;
        this.englishMeaning = "";
        this.spanishMeaning = "";
        this.grammarType = null;
        this.gender = null;
    }

    /**
     * Comparators: Checks Grammar Type of two words. Checks Word vs Word to see
     * if same or different Subclasses implement a CompareTo<Word> for index
     * value checks.
     */

    public abstract boolean CompareWord(Word word);
    public abstract boolean CompareGrammarType(Word word);

    /**
     * @return the grammarType
     */
    public String getGrammarType() {
        return grammarType;
    }

    /**
     * @param grammarType the grammarType to set
     */
    public void setString(String grammarType) {
        this.grammarType = grammarType;
    }

    /**
     * @return the englishMeaning
     */
    public String getEnglishMeaning() {
        return englishMeaning;
    }

    /**
     * @param englishMeaning the englishMeaning to set
     */
    public void setEnglishMeaning(String englishMeaning) {
        this.englishMeaning = englishMeaning;
    }

    /**
     * @return the spanishMeaning
     */
    public String getSpanishMeaning() {
        return spanishMeaning;
    }

    /**
     * @param spanishMeaning the spanishMeaning to set
     */
    public void setSpanishMeaning(String spanishMeaning) {
        this.spanishMeaning = spanishMeaning;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the leitnerLevel
     */
    public int getLeitnerLevel() {
        return leitnerLevel;
    }

    /**
     * @param leitnerLevel the leitnerLevel to set
     */
    public void setLeitnerLevel(int leitnerLevel) {
        this.leitnerLevel = leitnerLevel;
    }

    /**
     * @return the nextTestSession
     */
    public int getNextTestSession() {
        return nextTestSession;
    }

    /**
     * @param nextTestSession the nextTestSession to set
     */
    public void setNextTestSession(int nextTestSession) {
        this.nextTestSession = nextTestSession;
    }
    
        /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.index)
                .append(",")
                .append(this.leitnerLevel)
                .append(",")
                .append(this.nextTestSession)
                .append(",")
                .append(this.spanishMeaning)
                .append(",")
                .append(this.grammarType)
                .append(",")
                .append(this.englishMeaning)
                .append(",")
                .append(this.gender);
        
        return sb.toString();
    } 
}

