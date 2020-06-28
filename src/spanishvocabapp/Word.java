/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

/**
 * Concrete of the WordPlan abstract class. 
 * Contains calls to the full and empty super constructors.
 * Contains comparator methods necessary for game logic.
 * @author Ben
 */
public class Word extends WordPlan {
     
     public Word(int index, int leitnerLevel, int nextTestSession, String englishMeaning, String spanishMeaning, String grammarType, String gender) {
         super(index, leitnerLevel, nextTestSession, englishMeaning, spanishMeaning, grammarType, gender);
     }
     
     public Word() {
         super();
     }
    
    @Override
    public int compareTo(Word word) {
        if (this.getIndex() < word.getIndex() ) {
            return -1; // this word has been added earlier than comparison input
        }
        else if (this.getIndex() > word.getIndex() ) {
            return 1; // this word added later than comparison input
        }
        else 
            return 0; // same word - shouldn't exist.
    }
    
    @Override
    public boolean CompareGrammarType(Word word) {
         return this.getGrammarType().equals(word.getGrammarType());
    }
    
    @Override
    public boolean CompareWord(Word word) {
        return (this == word);
    }
}
