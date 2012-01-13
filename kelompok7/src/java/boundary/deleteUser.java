package boundary;

import boundary.Boundary;
import entity.DaftarUser;
import jpa.UserJpaController;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import jpa.exceptions.NonexistentEntityException;
import org.eclipse.persistence.sessions.Session;

public class deleteUser extends Boundary {



    public deleteUser(){
        super();
        setTemplate("/WEB-INF/deleteUser.jsp");
    }

    @Override
    protected void process() {

        setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_field()) {
                        DaftarUser dm = new DaftarUser();
                        UserJpaController d = new UserJpaController();
                            members m = new members();
                    try {
                        d.destroy(getRequest().getParameter("username"));
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(deleteUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    getResponse().sendRedirect("fieldKosong");
                }
                getResponse().sendRedirect("homeAdmin");
            } catch (IOException ex) {
                Logger.getLogger(deleteUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

            
    boolean validate_field() {
        
        String username = getRequest().getParameter("username");
        if(username == null){
            return false;
        }

        return true;
    }

   
}