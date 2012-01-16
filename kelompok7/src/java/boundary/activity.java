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

public class activity extends Boundary {
    private operator operator;

    public activity() {
        super();
        setTemplate("/WEB-INF/activity.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
        DaftarLapangan dl = new DaftarLapangan();
        HttpSession session = getRequest().getSession();
        //if(check()){
        if (session.getAttribute("username") != null ) {
            if(validate_activity()){
            List<lapangan> i = dl.lapanganTerbaru();
            getRequest().setAttribute("daftar_lapangan", i.iterator());
        }
        else{
            try {
                getResponse().sendRedirect("listLapanganKosong");
            } catch (IOException ex) {
                Logger.getLogger(activity.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        }try {
            getResponse().sendRedirect("login");
        } catch (IOException ex) {
            Logger.getLogger(activity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       boolean check() {
        DaftarUser dm = new DaftarUser();
        HttpSession session = getRequest().getSession();
        String u = (String) session.getAttribute("username");
        if (dm.getMember(u) != null ) {
            return true;
        }
        return false;
    } 
    
    private boolean validate_activity(){
        DaftarLapangan dl = new DaftarLapangan();
        int xx = dl.getJumlahLapangan();
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
}

