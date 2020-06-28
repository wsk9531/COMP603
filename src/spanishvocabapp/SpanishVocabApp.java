/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import java.util.Scanner;

/**
 * On Github at https://github.com/wsk9531/COMP603
 *
 * @author Ben Henshall
 * @id 14867281
 */
public class SpanishVocabApp {

    boolean continueFlag;

    public static void main(String[] args) {
        DBTools db = new DBTools();
        System.out.println("Database connection working: " + db);

        boolean tableNeedsFillingFlag = db.checkAndCreateTable();
        if (tableNeedsFillingFlag) {
            db.populateTableFromText();
        }

        WordList gameList = new WordList(db);
        System.out.println(gameList.getWordList());

        runGame(gameList, db);

    }

    public static void runGame(WordList gameList, DBTools db) {
        System.out.println("What do the following 10 Spanish words mean in English?");
        System.out.println("Type your answer, then press enter to move on. Good Luck!");
        Scanner scan = new Scanner(System.in);

        //work through the 10 values present
        for (int i = 0; i < 10; i++) {
            int shuffledIndexNum = gameList.getOrderMixer().get(i);
            Word tested = gameList.getWordList().get(shuffledIndexNum);

            System.out.println(tested.getSpanishMeaning() + "? Answer:");
            String scannerGameInput = scan.nextLine();

            if (scannerGameInput.trim().equalsIgnoreCase(tested.getEnglishMeaning())) {
                System.out.println("Correct!");
                gameList.IncrementLeitnerLevel(tested, db);

            } else {
                System.out.println("Incorrect!");
                gameList.ResetLeitnerLevel(tested, db);
            }
        }
    }
}


