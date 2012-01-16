package boundary;

import entity.DaftarLapangan;
import entity.lapangan;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.LapanganJpaController;
import jpa.exceptions.NonexistentEntityException;


public class confirmBooking extends Boundary {
    
    public confirmBooking(){
        super();
        setTemplate("/WEB-INF/listBooking.jsp");
    }

    @Override
    protected void process() {

        setMessage("");
                        DaftarLapangan db = new DaftarLapangan();
                        LapanganJpaController la = new LapanganJpaController();
                        Long i = Long.parseLong(getRequest().getParameter("lap"));
                        lapangan m = (lapangan) db.getLapanganId(i);
                        
                    try {
                            m.setStatLap(2);
            try {
                la.editLap(m);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(confirmBooking.class.getName()).log(Level.SEVERE, null, ex);
            }
            getResponse().sendRedirect("listUser");
        } catch (IOException ex) {
            Logger.getLogger(confirmBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

            
   
    }

      