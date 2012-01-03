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
import javax.servlet.http.HttpSession;

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
        HttpSession session = getRequest().getSession();
                if (validate_field()) {
                        DaftarUser dm = new DaftarUser();
                        String uname = (String) session.getAttribute("username");
                        members m = dm.getMember(getRequest().getParameter(uname));
                            m.setPassword(getRequest().getParameter("password"));
                            m.setAddressMb(getRequest().getParameter("address"));
                            m.setHandphoneMb(getRequest().getParameter("handphone"));
                            m.setEmailMb(getRequest().getParameter("email"));
                            dm.editMember(m);
                } else {
                try {
                    getResponse().sendRedirect("fieldKosong");
                } catch (IOException ex) {
                    Logger.getLogger(editProfil.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    }
    }


    boolean check() {
     HttpSession session = getRequest().getSession();
        if (session.getAttribute("username") == null) {
            //members uname = (members) session.getAttribute("username");
            return false;
        }
        return true;
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

        return true;
    }
    
}
