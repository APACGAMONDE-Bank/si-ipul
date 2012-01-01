package boundary;

import entity.DaftarLapangan;
import entity.lapangan;
import entity.operator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                        DaftarLapangan dl = new DaftarLapangan();
                        lapangan l = dl.getLapangan(operator);
                        if (l == null) {
                            l = new lapangan();
                            l.setAddressLap(getRequest().getParameter("address"));
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
        
        String username = getRequest().getParameter("username");
        String password = getRequest().getParameter("password");
        String address = getRequest().getParameter("address");
        String handphone = getRequest().getParameter("handphone");
        String email = getRequest().getParameter("email");
        if(username == null||password == null||address == null||handphone == null||email == null){
            return false;
        /*}
        if(username.trim().equals("")||password.trim().equals("")||address.trim().equals("")||handphone.trim().equals("")||email.trim().equals("")){
            return false;*/
        }

        return true;
    }

   
}
