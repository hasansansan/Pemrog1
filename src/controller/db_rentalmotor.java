/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hasan
 */
public class db_rentalmotor {
      public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost/db_rentalmotor";
    public String username = "root";
    public String password = "";
    public Connection con;
    
     public db_rentalmotor()
    {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(db_rentalmotor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(db_rentalmotor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection()
    {
        return con;
    }
    public static void main(String[] args) {
        System.out.println(new db_rentalmotor().getConnection());
    }
    
}
