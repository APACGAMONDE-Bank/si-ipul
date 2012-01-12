/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarInfoBerita;
import entity.DaftarUser;
import entity.admin;
import entity.infoBerita;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class login3 extends Boundary {

public login3(){
        super();
        setTemplate("/WEB-INF/index.jsp");
    }


    @Override
    protected void process() {
        HttpSession session = getRequest().getSession();
        DaftarUser du = new DaftarUser();
        String username = getRequest().getParameter("username");
        String password = getRequest().getParameter("password");
        //password = enkripsi.getEnkripsi(password);
        DaftarInfoBerita dib = new DaftarInfoBerita();
            List<infoBerita> i = dib.sepuluhInfoTerbaru();
            getRequest().setAttribute("daftar_berita", i.iterator());

        if (validate_field()) {
            members member = du.getMember(username);
            String d = member.getNameMb();
            operator op = du.getOperator(username);
            admin ad = du.getAdmin(username);
            //if (du.getMember(username).equals(username)&& password.equals(du.getMember(password))) {
            if (username.equals(member.getUsername()) && password.equals(member.getPassword())||
                    username.equals(op.getUsername()) && password.equals(op.getPassword())||
                    username.equals(ad.getUsername()) && password.equals(ad.getPassword())) {
                session.setAttribute("username", username);
                if (member.getStatMb() == 0){
                    try {
                        getResponse().sendRedirect("homeMember");
                    } catch (IOException ex) {
                        Logger.getLogger(login3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                else if (member.getStatMb() == 1){
                try {
                    getResponse().sendRedirect("homeOperator");
                } catch (IOException ex) {
                    Logger.getLogger(login3.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                     else {
            try {
                getResponse().sendRedirect("login");
            } catch (IOException ex) {
                Logger.getLogger(login3.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    
    
    /*public void setSession() {
        HttpSession session = getRequest().getSession();
        DaftarUser du = new DaftarUser();
        String username = getRequest().getParameter("username");
        String password = getRequest().getParameter("password");
        members member = du.getMember(username);
        String d = member.getNameMb();
        operator op = du.getOperator(username);
            if (username.equals(member.getUsername()) && password.equals(member.getPassword())) {
                String name = member.getNameMb();
                String address = member.getAddressMb();
                String email = member.getEmailMb();
                String hp = member.getHandphoneMb();
                session.setAttribute("username", username);
                session.setAttribute("name", name);
                session.setAttribute("address", address);
                session.setAttribute("email", email);
                session.setAttribute("hp", hp);
        }
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
