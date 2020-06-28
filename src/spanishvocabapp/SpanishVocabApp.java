/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import java.util.Scanner;

/**
 * SPECIAL FEATURE: GIT. USED LOCALLY AND ALSO ON GITHUB AT
 * https://github.com/wsk9531/COMP603/tree/master/src/spanishvocabapp
 *
 * @author Ben Henshall
 * @id 14867281
 */
public class SpanishVocabApp extends SpanishVocabAppUI {

    public static void main(String[] args) {
        /*
        Initial setup of database. In event of an empty database, text file used
        for initial propagation.
        */
        DBTools db = new DBTools();
        System.out.println("Database connection working: " + db);

        boolean tableNeedsFillingFlag = db.checkAndCreateTable();
        if (tableNeedsFillingFlag) {
            db.populateTableFromText();
        }

        /* GENERATED
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SpanishVocabAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpanishVocabAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpanishVocabAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpanishVocabAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpanishVocabAppUI().setVisible(true);
            }
        });

        /*
        Generates list of words for this session.
        */
        WordList gameList = new WordList(db);
        //Lists answers in console log for testing / assessment.
        System.out.println(gameList.getWordList());

        //runs the game, involves use of DBTools and the above gameList
        runGame(gameList, db);
        //userAddWord();

        /*
        Closes connection to DB at end of program
        */
      //  db.dbManager.closeConnectionToDB();
    }

    /*
        Spaced repetition system game. Takes in a list of words,
        reads user input and tests against the Word object made of Derby data.
        Contains exit clause 
    */
    public static void runGame(WordList gameList, DBTools db) {
        System.out.println("What do the following 10 Spanish words mean in English?");
        System.out.println("Type your answer, then press enter to move on. \n" 
                + "Type Exit or Quit to stop the session. Good Luck!");
        Scanner scan = new Scanner(System.in);

        //work through the 10 values present
        for (int i = 0; i < 10; i++) {
            int shuffledIndexNum = gameList.getOrderMixer().get(i);
            Word tested = gameList.getWordList().get(shuffledIndexNum);

            System.out.println(tested.getSpanishMeaning() + "? Answer:");
            String scannerGameInput = scan.nextLine();

            if ((scannerGameInput.trim().equalsIgnoreCase("exit")) || (scannerGameInput.trim().equalsIgnoreCase("quit"))) {
                System.out.println("Exiting back to menu!");
                return;
            } else if (scannerGameInput.trim().equalsIgnoreCase(tested.getEnglishMeaning())) {
                System.out.println("Correct!");
                gameList.IncrementLeitnerLevel(tested, db);
            } else {
                System.out.println("Incorrect!");
                gameList.ResetLeitnerLevel(tested, db);
            }
        }
    }
}
