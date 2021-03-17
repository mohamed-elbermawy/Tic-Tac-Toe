/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamed
 */
public class SqlHandler {

    private Connection con;
    private Statement stmt;
    private PreparedStatement ps;
    private ResultSet rs;

    private String dbName = "TIC_TAC_TOE_DB";
    private String dbUserName = "admin";
    private String dbPassword = "12345";
    
    public boolean isConnected() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUserName, dbPassword);
            System.out.println("DB Connected");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean login(String playerUsername, String playerPassword) {
        if (isConnected()) {
            try {
                ps = con.prepareStatement("SELECT player_name , player_password FROM Player WHERE player_name = ? AND player_Password = ?");
                ps.setString(1, playerUsername);
                ps.setString(2, playerPassword);
                rs=ps.executeQuery();

                if (rs.next()) {
                    return true;
                }

                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean signUp(String playerUsername, String playerPassword) {
        if (isConnected()) {
            try {
                ps = con.prepareStatement("INSERT INTO Player (player_name,player_Password) VALUES(?,?)");
                ps.setString(1, playerUsername);
                ps.setString(2, playerPassword);
                int result = ps.executeUpdate();

                if (result>0) {
                    return true;
                }

                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    
}
