/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMSPakage;

import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author samee
 */
public class Conn {
    
    public static Connection ConnectToDb() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/UserManagementSystem";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,"root","");
            
        } catch (Exception e) {
            System.out.println("UMSPakage.Conn.getConnection()"+e);
        }
        return con;
    }
}
