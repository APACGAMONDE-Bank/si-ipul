/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;

import entity.members;
import entity.DaftarUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yogi
 */
public class editProfil extends Boundary {
   

    public editProfil(){
        super();
        setTemplate("/WEB-INF/edit-profil.jsp");
    }

    @Override
    protected void process() {

        setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_field()) {
                        DaftarUser dm = new DaftarUser();
                        members m = dm.getMember(getRequest().getParameter("username"));
                            m.setUsername(getRequest().getParameter("username"));
                            m.setPassword(getRequest().getParameter("password"));
                            m.setAddressMb(getRequest().getParameter("address"));
                            m.setHandphoneMb(getRequest().getParameter("handphone"));
                            m.setEmailMb(getRequest().getParameter("email"));
                            dm.editMember(m);
                } else {
                    getResponse().sendRedirect("fieldKosong");
                }
                getResponse().sendRedirect("home");
            } catch (IOException ex) {
                Logger.getLogger(addBerita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    boolean validate_field() {
        
        String username = getRequest().getParameter("username");
        String password = getRequest().getParameter("password");
        String address = getRequest().getParameter("address");
        String handphone = getRequest().getParameter("handphone");
        String email = getRequest().getParameter("email");
        if(username == null||password == null||address == null||handphone == null||email == null){
            return false;
        }
        if(username.trim().equals("")||password.trim().equals("")||address.trim().equals("")||handphone.trim().equals("")||email.trim().equals("")){
            return false;
        }

        return true;
    }
    
}
