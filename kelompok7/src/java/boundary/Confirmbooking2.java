package boundary;

import entity.DaftarLapangan;
import entity.lapangan;

public class Confirmbooking2 extends Boundary {



    public Confirmbooking2(){
        super();
        setTemplate("/WEB-INF/listBooking.jsp");
    }

    @Override
    protected void process() {
                        DaftarLapangan db = new DaftarLapangan();
                        lapangan m = new lapangan();
                            m.setStatLap(1);
        }
    }
        
                       
       