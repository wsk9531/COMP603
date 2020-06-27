/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

/**
 * Interface for game logic. Games need to implement these functions for proper
 * spaced repetition
 * @author Ben
 */
public interface LeitnerSystem {
    public void IncrementLeitnerLevel(Word w);
    public void ResetLeitnerLevel(Word w);
}
