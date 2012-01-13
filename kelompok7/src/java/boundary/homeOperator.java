/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarLapangan;
import entity.DaftarUser;
import entity.lapangan;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class homeOperator extends Boundary {
    private operator operator;

    public homeOperator() {
        super();
        setTemplate("/WEB-INF/homeOperator.jsp");
    }

    @Override
    protected void process() {
     HttpSession session = getRequest().getSession();
        operator user = new operator();
        DaftarUser du = new DaftarUser();
        if (check()){
            String username = (String) session.getAttribute("username.username");
            user = du.getOperator(username);
        } else {
            try {
                getResponse().sendRedirect("login");
            } catch (IOException ex) {
                Logger.getLogger(homeMember.class.getName()).log(Level.SEVERE, null, ex);
            }
        
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
    
    private boolean validate_lapangan(){
        DaftarLapangan dl = new DaftarLapangan();
        int xx = dl.getJumlahLapangan();
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
}
