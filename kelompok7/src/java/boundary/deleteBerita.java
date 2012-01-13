package boundary;

import entity.DaftarInfoBerita;
import entity.DaftarUser;
import entity.infoBerita;
import jpa.UserJpaController;
import entity.members;
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
                            infoBerita m = new infoBerita();
                            dm.hapusInfoBerita(getRequest().getParameter("id"));
                } else {
                    getResponse().sendRedirect("fieldKosong");
                }
                getResponse().sendRedirect("homeOperator");
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