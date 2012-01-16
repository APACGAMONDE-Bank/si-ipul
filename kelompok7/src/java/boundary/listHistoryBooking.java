/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;


import entity.DaftarBooking;
import entity.DaftarLapangan;
import entity.operator;
import entity.lapangan;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class listHistoryBooking extends Boundary {
    private operator operator;

    public listHistoryBooking() {
        super();
        setTemplate("/WEB-INF/listHBooking.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
        DaftarBooking dib = new DaftarBooking();
        HttpSession session = getRequest().getSession();
        operator op = (operator) session.getAttribute("op");
        if(validate_book()){
            List<DaftarBooking> i = dib.getHistory(op);
            getRequest().setAttribute("daftar_book", i.iterator());
        }
        else{
            try {
                getResponse().sendRedirect("listBookingKosong");
            } catch (IOException ex) {
                Logger.getLogger(listActivity.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        }
    
        public void confirm(){
            DaftarLapangan db = new DaftarLapangan();
            lapangan m = new lapangan();
            m.setStatLap(1);
        }

    private boolean validate_book(){
        DaftarBooking dib = new DaftarBooking();
         HttpSession session = getRequest().getSession();
        operator mem = (operator) session.getAttribute("op");
        int xx = dib.getJumlahBookingOp(mem);
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
}

