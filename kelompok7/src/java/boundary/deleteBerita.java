package boundary;

import entity.DaftarInfoBerita;
import entity.infoBerita;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;

public class deleteBerita extends Boundary {



    public deleteBerita(){
        super();
        setTemplate("/WEB-INF/deleteBerita.jsp");
    }

    @Override
    protected void process() {

        setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_field()) {
                    DaftarInfoBerita dm = new DaftarInfoBerita();
                    try {
                        dm.hapusInfo(getRequest().getParameter("id"));
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(deleteBerita.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    getResponse().sendRedirect("fieldKosong");
                }
                getResponse().sendRedirect("login");
            } catch (IOException ex) {
                Logger.getLogger(deleteBerita.class.getName()).log(Level.SEVERE, null, ex);
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