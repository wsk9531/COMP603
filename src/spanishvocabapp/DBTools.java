/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Methods to work with derby instance
 * @author Ben
 */
public class DBTools {
    
    public static final String TABLENAME = "WORD";
    private final DBManager dbManager;
    private DatabaseMetaData metaData;
    private Statement statement;
    ResultSet wordsTableCheck;
    ResultSet rs;
    
    public DBTools () {
        dbManager = new DBManager();
    }

    public boolean checkAndCreateTable() {
        Boolean databaseNeedsFillingFlag = false;
        try {
        metaData = dbManager.conn.getMetaData();
        wordsTableCheck = metaData.getTables(null, null, TABLENAME, null); // checks for table named "WORDS"
        if (!wordsTableCheck.next()) {
            statement = dbManager.conn.createStatement();
            
            String sqlCreationStatement = "CREATE TABLE " 
                    + TABLENAME 
                    + " (ID int not null,"
                    + "LEITNERLEVEL int not null, "
                    + "nextTestSession int not null, "
                    + "espanol varchar(50) not null,"
                    + "grammar varchar(10) not null,"
                    + "english varchar(50) not null, "
                    + "gender varchar(10)"
                    +")";
            
            String sqlPK = "ALTER TABLE " + TABLENAME + "\n"
                    + " ADD CONSTRAINT " + TABLENAME + "_PK\n"
                    + " PRIMARY KEY (ID)";
            
            statement.executeUpdate(sqlCreationStatement);
            statement.executeUpdate(sqlPK);
            return databaseNeedsFillingFlag = true;
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return databaseNeedsFillingFlag;
    }
    
    /**
     * If there's zero table data from a past session, this can be used to pull 
     * a 101 word dictionary from a text file, and populate the database.
     */
    public void populateTableFromText() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
            String input = null; // creates String to hold a line for parsing.
            br.readLine(); //essential: skips header row in csv.
            while ((input = br.readLine()) != null) {
                String[] str = input.split(",");
                int tempIndex = Integer.parseInt(str[0]);
                int tempLeitner = Integer.parseInt(str[1]);
                int tempNextTest = Integer.parseInt(str[2]);
                String tempSpan = str[3];
                String tempGrammar = str[4];
                String tempEng = str[5];
                String tempGend = str[6];
                
                addToDB(tempIndex, tempLeitner, tempNextTest, tempSpan, tempGrammar, tempEng, tempGend);
            }
        } catch (FileNotFoundException ex) {
                Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addToDB(int index, int leitner, int nextTest, String span, String grammar, String eng, String gender)  {
        try {
        statement = dbManager.conn.createStatement();
        String sqlAdd = "INSERT INTO " + TABLENAME + " (ID, LEITNERLEVEL, nextTestSession, espanol, grammar, english, gender) \n"
                + "VALUES ("+ index + ", " + leitner + ", "+ nextTest + ", '"+ span + "', '"+ grammar + "', '"+ eng + "', '"+ gender + "')";
        statement.executeUpdate(sqlAdd);
        } catch (SQLException ex) {
           Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet retrieveWordTable(int level) {
        String str = ("SELECT * FROM " + TABLENAME 
                + " w WHERE w.LEITNERLEVEL = " + level);
        try {
            statement = this.dbManager.conn.createStatement();
            this.rs = statement.executeQuery(str);
        } catch (SQLException ex) {
            
        }
        return rs;
    }

    public void updateLeitnerLevel(Word w) {

        try {
            statement = this.dbManager.conn.createStatement();
            String str = ("UPDATE " + TABLENAME 
                    + " SET LEITNERLEVEL = " + w.getLeitnerLevel() 
                    + " WHERE ID = " + w.getIndex());
            statement.executeUpdate(str);
        } catch(SQLException ex) {
            Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void resetLeitnerLevel(Word w) {
        try {
            statement = this.dbManager.conn.createStatement();
            String str = ("UPDATE " + TABLENAME 
                    + " SET LEITNERLEVEL = " + w.getLeitnerLevel() 
                    + " WHERE ID = " + w.getIndex());
            statement.executeUpdate(str);
        } catch(SQLException ex) {
            Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
// TODO: write add word function -- user feature
// TODO: write remove word function -- user feature


    
}
