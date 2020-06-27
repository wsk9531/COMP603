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
 *
 * @author Ben
 */
public class DBTools {
    
    private static final String TABLENAME = "WORDS";
    private DBManager dbManager;
    private DatabaseMetaData metaData;
    private Statement statement;
    
    public DBTools () {
        dbManager = new DBManager();
    }

    public void checkAndCreateTable() {
        try {
        ResultSet wordsTableCheck = this.metaData.getTables(null, null,"WORDS", null); // checks for table named "WORDS"
        if (!wordsTableCheck.next()) {
            statement = dbManager.conn.createStatement();
            
            String sqlCreationStatement = "CREATE TABLE " 
                    + TABLENAME.toUpperCase() 
                    + " (ID int not null,"
                    + "LEITNERLEVEL int not null, "
                    + "nextTestSession int not null "
                    + "espanol varchar(50) not null"
                    + "grammar varchar(10) not null"
                    + "english varchar(50) not null "
                    + "gender varchar(10)"
                    +")";
            
            String sqlPK = "ALTER TABLE " + TABLENAME.toUpperCase() + "\n"
                    + " ADD CONSTRAINT " + TABLENAME.toUpperCase() + "_PK\n"
                    + " PRIMARY KEY (ID)";
            
            statement.executeUpdate(sqlCreationStatement);
            statement.executeUpdate(sqlPK);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
                String tempEng = str[5];
                String tempGend = str[6];
                
                addToDB(tempIndex, tempLeitner, tempNextTest, tempSpan, tempEng, tempGend);
            }
        } catch (FileNotFoundException ex) {
                Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
                Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addToDB(int index, int leitner, int nextTest, String span, String eng, String gender) throws SQLException {
        statement = dbManager.conn.createStatement();
        String sqlAdd = "INSERT INTO " + TABLENAME.toUpperCase() + " VALUES ("
                + index + " "
                + leitner + " "
                + nextTest + " "
                + span + " "
                + eng + " " 
                + gender + ")";
        statement.executeUpdate(sqlAdd);
    }

        
// TODO: write add word function -- user feature
// TODO: write remove word function -- user feature
// TODO: write update word level function -- game logic
        
    }
