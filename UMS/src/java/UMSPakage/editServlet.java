/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMSPakage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author samee
 */
@WebServlet(name = "editServlet", urlPatterns = {"/editServlet"})
public class editServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PrintWriter out = response.getWriter();
        int id =Integer.parseInt(request.getParameter("id")) ;
        String email = request.getParameter("email");
      String fname = request.getParameter("fname");
      String lname = request.getParameter("lname");
      String password = request.getParameter("password");
      String phone = request.getParameter("phone");
      
        System.err.println(id+email);
        User user = new User();
        
        user.setId(id);
        user.setEmail(email);
      user.setPassword(password);
      user.setFname(fname);
      user.setLname(lname);
      user.setPhone(phone);
        int status = UserOperation.editUser(user);
        
          if (status>0) {
            
             response.sendRedirect("view.jsp");
        }else{
              System.err.println("Unable to Update !");
        }
    }


}
