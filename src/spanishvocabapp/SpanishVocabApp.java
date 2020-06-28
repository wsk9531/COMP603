/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

/**
 * On Github at https://github.com/wsk9531/COMP603
 * @author Ben Henshall
 * @id 14867281
 */
public class SpanishVocabApp {
    
    public static void main(String[] args) {
        DBTools db = new DBTools();
        boolean tableNeedsFillingFlag = db.checkAndCreateTable();
        if (tableNeedsFillingFlag) {
            db.populateTableFromText();
        }
        WordList gameList = new WordList(db);
        
        
        
        
        System.out.println("Database connection working: " + db);
    }
}
