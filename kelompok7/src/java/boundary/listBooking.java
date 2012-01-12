/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;


import entity.DaftarBooking;
import entity.booking;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.eclipse.persistence.sessions.Session;

public class listBooking extends Boundary {
    private operator operator;

    public listBooking() {
        super();
        setTemplate("/WEB-INF/listBooking.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
        DaftarBooking dib = new DaftarBooking();
        HttpSession session = getRequest().getSession();
        String op = (String) session.getAttribute("username");
        if(validate_book()){
            List<DaftarBooking> i = dib.getBOp(op);
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

    private boolean validate_book(){
        DaftarBooking dib = new DaftarBooking();
         HttpSession session = getRequest().getSession();
        String mem = (String) session.getAttribute("username");
        int xx = dib.getJumlahBookingOp(mem);
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
}

