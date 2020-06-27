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
public class SpanishVocabApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBTools db = new DBTools();
        
        boolean tableNeedsFillingFlag = db.checkAndCreateTable();
        if (tableNeedsFillingFlag) {
            db.populateTableFromText();
        }
        
        System.out.println(db);
    }
}
