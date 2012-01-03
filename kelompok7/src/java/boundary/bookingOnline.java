package boundary;

import entity.DaftarBooking;
import entity.DaftarLapangan;
import entity.DaftarUser;
import entity.lapangan;
import entity.members;
import entity.operator;
import entity.booking;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class bookingOnline extends Boundary {



    public bookingOnline(){
        super();
        setTemplate("/WEB-INF/booking.jsp");
    }

    @Override
    protected void process() {

        setMessage("");
        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_field()) {
                    HttpSession session = getRequest().getSession();
                        DaftarBooking db = new DaftarBooking();
                        booking m = new booking();
                        int jams = Integer.parseInt(getRequest().getParameter("jam"));
                        //lapangan idLap = (lapangan) session.getAttribute(idLaps);
                            m.setMembers(session.getAttribute("username"));
                            //m.setLap(session.getAttribute("lapangan"));
                            m.setLap(getRequest().getParameter("idLap"));
                            m.setJam(jams);
                            db.tambahBooking(m);
                        
                } else {
                    getResponse().sendRedirect("fieldKosong");
                }
                getResponse().sendRedirect("homeMember");
            } catch (IOException ex) {
                Logger.getLogger(addLapangan.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
    }
        
                       
        boolean validate_field() {

        String lap = getRequest().getParameter("idLap");
        String jam = getRequest().getParameter("jam");

        if(lap == null|jam == null){
            return false;
        /*}
        if(username.trim().equals("")||password.trim().equals("")||address.trim().equals("")||handphone.trim().equals("")||email.trim().equals("")){
            return false;*/
        }

        return true;
    }

   
    }
