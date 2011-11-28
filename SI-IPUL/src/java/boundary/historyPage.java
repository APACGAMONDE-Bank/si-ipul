/**
 * @author yogi
 * @version 1.0
 */

package boundary;

import model.listBooking;
import model.booking;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radityo
 */
public class historyPage extends boundary {

    public historyPage() {
        super();
        setTemplate("/WEB-INF/jsps/historyReservasiPage.jsp");
    }

    @Override
    protected void process() {
        setMessage("");
        listBooking lb = new listBooking();
        if(validate_jumlah_booking()){
            List<booking> list = lb.listBook();
            getRequest().setAttribute("listBooking", list.iterator());
        }else{
            try {
                getResponse().sendRedirect("history-pemesanan-kosong");
            } catch (IOException ex) {
                Logger.getLogger(historyPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean validate_jumlah_booking(){
        listBooking lb = new listBooking();
        int jumlahBooking = lb.getJumlahBooking();
        
        if( jumlahBooking == 0){
            return false;
        }

        return true;
    }

}
