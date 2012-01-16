/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarLapangan;
import entity.infoBerita;
import entity.lapangan;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.LapanganJpaController;
import jpa.exceptions.NonexistentEntityException;

public class listLapangan extends Boundary {
    private operator operator;

    public listLapangan() {
        super();
        setTemplate("/WEB-INF/listLapangan.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
        DaftarLapangan dl = new DaftarLapangan();
        if(validate_lapangan()){
            List<lapangan> i = dl.lapanganTerbaru();
            getRequest().setAttribute("daftar_lapangan", i.iterator());
        }
        else{
            try {
                getResponse().sendRedirect("listLapanganKosong");
            } catch (IOException ex) {
                Logger.getLogger(listLapangan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        }

    private void delLap() throws NonexistentEntityException{
        DaftarLapangan dl = new DaftarLapangan();
        LapanganJpaController j = new LapanganJpaController();
        infoBerita m = new infoBerita();
        Long i = Long.parseLong(getRequest().getParameter("id"));
        j.destroy(i);
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

