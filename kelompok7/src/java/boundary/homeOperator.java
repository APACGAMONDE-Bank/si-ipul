/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarLapangan;
import entity.lapangan;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class homeOperator extends Boundary {
    private operator operator;

    public homeOperator() {
        super();
        setTemplate("/WEB-INF/homeOperator.jsp");
    }

    @Override
    protected void process() {
      /*setMessage("");
        DaftarLapangan dl = new DaftarLapangan();
        if(validate_lapangan()){
            List<DaftarLapangan> getLapangan = (List<DaftarLapangan>) dl.getLapangan(operator);
            getRequest().setAttribute("daftarLapangan", getLapangan.iterator());
        /*}else{
            try {
                getResponse().sendRedirect("homeMember");
            } catch (IOException ex) {
                Logger.getLogger(homeMember.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean validate_lapangan(){
        DaftarLapangan dl = new DaftarLapangan();
        int xx = dl.getJumlahLapangan();
        
        if( xx == 0){
            return false;
        }

        return true;
    }  */
    }
}
