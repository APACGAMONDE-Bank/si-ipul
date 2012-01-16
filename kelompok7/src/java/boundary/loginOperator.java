/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarInfoBerita;
import entity.DaftarUser;
import entity.infoBerita;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yogi
 */
public class loginOperator extends Boundary {

public loginOperator(){
        super();
        setTemplate("/WEB-INF/index2.jsp");
    }


    @Override
    protected void process() {
        HttpSession session = getRequest().getSession();
        DaftarUser du = new DaftarUser();
        String username = getRequest().getParameter("username");
        String password = getRequest().getParameter("password");
        DaftarInfoBerita dib = new DaftarInfoBerita();
            List<infoBerita> i = dib.sepuluhInfoTerbaru();
            getRequest().setAttribute("daftar_berita", i.iterator());

        if (validate_field()) {
            operator op = du.getOperator(username);
            if (username.equals(op.getUsername()) && password.equals(op.getPassword())){
                session.setAttribute("op", op);
                session.setAttribute("username", op.getUsername());
                session.setAttribute("name", op.getNameOp());
                session.setAttribute("hp", op.getHandphoneOp());
                session.setAttribute("email", op.getEmailOp());
                session.setAttribute("address", op.getAddressOp());
                try {
                    getResponse().sendRedirect("homeOperator");
                } catch (IOException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
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
        }

        return true;
    }
    
    
    
}
