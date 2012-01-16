/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;

import entity.members;
import entity.DaftarUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import jpa.UserJpaController;
import jpa.exceptions.NonexistentEntityException;

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
            HttpSession session = getRequest().getSession();
            String n = getRequest().getParameter("name");
            String p = getRequest().getParameter("password");
            String a = getRequest().getParameter("address");
            String h = getRequest().getParameter("handphone");
            String e = getRequest().getParameter("email");
            try {    
                    if (validate_field()) {
                            DaftarUser dm = new DaftarUser();
                            UserJpaController d = new UserJpaController();
                            //String uname = (String) session.getAttribute("username");
                            members m = (members) session.getAttribute("member");
                                m.setNameMb(n);
                                m.setPassword(p);
                                m.setAddressMb(a);
                                m.setHandphoneMb(h);
                                m.setEmailMb(e);
                                session.setAttribute("name", n);
                                session.setAttribute("hp", h);
                                session.setAttribute("email", e);
                                session.setAttribute("address",a);
                    try {
                        d.edit(m);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(editProfil.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(editProfil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    else{
                        getResponse().sendRedirect("fieldKosong");
                        }
                    getResponse().sendRedirect("homeMember");
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
        
        String password = getRequest().getParameter("password");
        String address = getRequest().getParameter("address");
        String handphone = getRequest().getParameter("handphone");
        String email = getRequest().getParameter("email");
        if(password == null||address == null||handphone == null||email == null){
            return false;
        }

        return true;
    }
    
}
