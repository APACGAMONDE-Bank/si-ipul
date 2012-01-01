/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarUser;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yogi
 */
public class login extends Boundary {

public login(){
        super();
        setTemplate("/WEB-INF/index.jsp");
    }


    @Override
    protected void process() {
        HttpSession session = getRequest().getSession();
        DaftarUser du = new DaftarUser();
        String username = getRequest().getParameter("username");
        String password = getRequest().getParameter("password");

        if (validate_field()) {
            members member = du.getMember(username);
            //operator op = du.getOperator(username);
            //if (du.getMember(username).equals(username)&& password.equals(du.getMember(password))) {
            if (username.equals(member.getUsername()) && password.equals(member.getPassword())) {
                session.setAttribute("uname", username);
                try {
                    getResponse().sendRedirect("homeMember");
                } catch (IOException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
              /*  } else if 
                    (username.equals(op.getUsername()) && password.equals(op.getPassword())){
                    session.setAttribute("uname", username);
                try {
                    getResponse().sendRedirect("homeOperator");
                } catch (IOException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                    
            } else {
                try {
                    getResponse().sendRedirect("login");
                } catch (IOException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        

    }
    
    boolean validate_field() {
        
        String username = getRequest().getParameter("username");
        String password = getRequest().getParameter("password");
        if(username == null||password == null){
            return false;
        /*}
        if(username.trim().equals("")||password.trim().equals("")||address.trim().equals("")||handphone.trim().equals("")||email.trim().equals("")){
            return false;*/
        }

        return true;
    }
    
/*protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        String name = request.getParameter("username");  
        String password = request.getParameter("password");  
          
        if((name.equals("raja"))&&(password.equals("raja")))  
       {  
   
            response.sendRedirect("homeMember.jsp");  
        } else {  
            request.setAttribute("lfail", "Login Failed Try Again");  
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");  
            rd.forward(request, response);  
        }  
    }  
  
   
    @Override  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        processRequest(request, response);  
    }  
  
    
    @Override  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        processRequest(request, response);  
    }

    @Override
    protected void process() {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/

    
}
