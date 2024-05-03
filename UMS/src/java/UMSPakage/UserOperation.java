/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMSPakage;

import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author samee
 */
public class UserOperation {
    public static int saveUser(User user) {
        int status = 0;
        
        try {
            Connection con = Conn.ConnectToDb();
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (email,password,fname,lname,phone) VALUES (?,?,?,?,?)");
            ps.setString(1, user.getEmail());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFname());
            ps.setString(4, user.getLname());
            ps.setString(5, user.getPhone());
            
            status = ps.executeUpdate();
            
            con.close();
            
        } catch (Exception e) {
        }
        
        return status;
    }
    
    public static List<User> viewAllUsers() {
        List<User>ulist = new ArrayList<>();
        try {
            Connection con = Conn.ConnectToDb();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
            ResultSet rs =  ps.executeQuery();
            
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFname(rs.getString(4));
                user.setLname(rs.getString(5));
                user.setPhone(rs.getString(6));
                ulist.add(user);
               
            }
        } catch (Exception e) {
            System.out.println("UMSPakage.UserOperation.viewAllUsers()"+e);
        }
      return ulist;
    }
    
    
    public static User getUserById(int id) {
        User user   = new User();
        try {
            Connection con = Conn.ConnectToDb();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            user.setEmail(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setFname(rs.getString(4));
            user.setLname(rs.getString(5));
            user.setPhone(rs.getString(6));
            }
         
                    
        } catch (Exception e) {
            System.err.println(e);
        }
        
       return user;
    }
    
    
    public static int editUser(User user) {
       int status = 0;
        try {
            Connection con = Conn.ConnectToDb();
            PreparedStatement ps = con.prepareStatement("UPDATE user SET email=?, password=?,fname=? , lname=? , phone=? WHERE id=?");
            
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3,user.getFname());
            ps.setString(4,user.getLname());
            ps.setString(5,user.getPhone());
            ps.setInt(6, user.getId());
            
           status =  ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        
        return status;
    }
    
    public static int deleteUser(int id) {
        int status = 0;
        
        try {
            Connection con = Conn.ConnectToDb();
            PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) {
        }
   return status;
    }

   
    
    
}
