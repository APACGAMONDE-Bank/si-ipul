package boundary;

import entity.DaftarLapangan;
import entity.lapangan;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class addLapangan extends Boundary {
    private operator operator;

    public addLapangan(){
        super();
        setTemplate("/WEB-INF/addLapangan.jsp");
    }

    @Override
    protected void process() {

        setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_field()) {
                        HttpSession session = getRequest().getSession();
                        operator op = (operator) session.getAttribute("op");
                        operator p = (operator) session.getAttribute("username");
                        String b = (String) p;
                        DaftarLapangan dl = new DaftarLapangan();
                        lapangan l = dl.getLapangan(p);
                        if (l == null) {
                            l = new lapangan();
                            l.setAddressLap(getRequest().getParameter("address"));
                            l.setOperator(p);
                            dl.tambahLapangan(l);
                        }
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

        String address = getRequest().getParameter("address");

        if(address == null){
            return false;
        /*}
        if(username.trim().equals("")||password.trim().equals("")||address.trim().equals("")||handphone.trim().equals("")||email.trim().equals("")){
            return false;*/
        }

        return true;
    }

   
}
