package boundary;

import entity.DaftarLapangan;
import entity.DaftarUser;
import entity.lapangan;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class booking extends Boundary {



    public booking(){
        super();
        setTemplate("/WEB-INF/booking.jsp");
    }

    @Override
    protected void process() {

        /*setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_field()) {
                        DaftarLapangan dl = new DaftarLapangan();
                        lapangan m = dl.editLapangan(getRequest().getParameter("lapangan"));
                        if (m == null) {
                            m = new members();
                            m.setUsername(getRequest().getParameter("username"));
                            m.setPassword(getRequest().getParameter("password"));
                            m.setNameMb(getRequest().getParameter("name"));
                            m.setAddressMb(getRequest().getParameter("address"));
                            m.setHandphoneMb(getRequest().getParameter("handphone"));
                            m.setEmailMb(getRequest().getParameter("email"));
                            m.setStatMb(stat);
                            dm.tambahMember(m);
                            }
                        
                } else {
                    getResponse().sendRedirect("fieldKosong");
                }
                getResponse().sendRedirect("homeMember");
            } catch (IOException ex) {
                Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
            }



        }*/
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
