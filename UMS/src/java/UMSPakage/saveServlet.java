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
import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 *
 * @author samee
 */
@WebServlet(name = "saveServlet", urlPatterns = {"/saveServlet"})
public class saveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
      String email = request.getParameter("email");
      String fname = request.getParameter("fname");
      String lname = request.getParameter("lname");
      String password = request.getParameter("password");
      String phone = request.getParameter("phone");
      
      
      
      User user = new User();
      user.setEmail(email);
      user.setPassword(password);
      user.setFname(fname);
      user.setLname(lname);
      user.setPhone(phone);
      
      
      int status = UserOperation.saveUser(user);
      
        if (status>0) {
            System.out.println("User Entered to Database!");
            request.getRequestDispatcher("index.html").include(request, response);
            
        }else{
             System.out.println("error");
        }
      
    }


}
