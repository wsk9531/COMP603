/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spanishvocabapp;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author Ben
 */
public class DBManager {
    private static final String URL = "jdbc:derby:WordDB;create=true";
    private static final String USR = "ben";
    private static final String PWD = "123";
    Connection conn;
    
    public DBManager() {
        connectToDatabase();
    }
    
    public void connectToDatabase() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USR, PWD);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void closeConnectionToDB() {
        if (conn != null) {
             try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
 
    
 

    
            
            
            
}
