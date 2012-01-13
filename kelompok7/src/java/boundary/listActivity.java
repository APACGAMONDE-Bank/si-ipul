/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;


import entity.DaftarBooking;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class listActivity extends Boundary {
    private operator operator;

    public listActivity() {
        super();
        setTemplate("/WEB-INF/listActivity.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
        DaftarBooking dib = new DaftarBooking();
        HttpSession session = getRequest().getSession();
        String mem = (String) session.getAttribute("username.username");
        if(validate_book()){
            List<DaftarBooking> i = dib.getBO(mem);
            getRequest().setAttribute("daftar_book", i.iterator());
        }
        else{
            try {
                getResponse().sendRedirect("listActivityKosong");
            } catch (IOException ex) {
                Logger.getLogger(listActivity.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        }

    private boolean validate_book(){
        DaftarBooking dib = new DaftarBooking();
        int xx = dib.getJumlahBooking();
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
}

