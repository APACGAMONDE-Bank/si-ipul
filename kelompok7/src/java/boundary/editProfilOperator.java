package boundary;

import entity.members;
import entity.DaftarUser;
import entity.operator;
import helper.check;
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

public class editProfilOperator extends Boundary {
   

    public editProfilOperator(){
        super();
        setTemplate("/WEB-INF/edit-profil-op.jsp");
    }

    @Override
    protected void process() {

        setMessage("");
        if (check()){
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
                            operator m = (operator) session.getAttribute("username");
                                m.setNameOp(n);
                                m.setPassword(p);
                                m.setAddressOp(a);
                                m.setHandphoneOp(h);
                                m.setEmailOp(e);
                    try {
                        dm.editOperator(m);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(editProfilOperator.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(editProfilOperator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    else{
                        getResponse().sendRedirect("fieldKosong");
                        }
                    //getResponse().sendRedirect("homeMember");
            } catch (IOException ex) {
                Logger.getLogger(editProfilOperator.class.getName()).log(Level.SEVERE, null, ex);
            }
    
            }
        }
        try {
            getResponse().sendRedirect("login");
        } catch (IOException ex) {
            Logger.getLogger(editProfilOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    boolean check() {
        DaftarUser dm = new DaftarUser();
        HttpSession session = getRequest().getSession();
        if (dm.getOperator("username") != null ) {
            return true;
        }
        return false;
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
