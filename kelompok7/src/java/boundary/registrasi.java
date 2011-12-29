package boundary;

import entity.DaftarUser;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registrasi extends Boundary {



    public registrasi(){
        super();
        setTemplate("/WEB-INF/registrasi.jsp");
    }

    @Override
    protected void process() {

        setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_field()) {
                        DaftarUser dm = new DaftarUser();
                        String stats = getRequest().getParameter("tp");
                        int stat = Integer.parseInt(stats);
                        {if (stat == 1) {
                        members m = dm.getMember(getRequest().getParameter("username"));
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
                         }
                        
                        {if (stat == 0) {
                        operator o = dm.getOperator(getRequest().getParameter("username"));
                        if (o == null) {
                            o = new operator();
                            o.setUsername(getRequest().getParameter("username"));
                            o.setPassword(getRequest().getParameter("password"));
                            o.setNameOp(getRequest().getParameter("name"));
                            o.setAddressOp(getRequest().getParameter("address"));
                            o.setHandphoneOp(getRequest().getParameter("handphone"));
                            o.setEmailOp(getRequest().getParameter("email"));
                            o.setStatOp(stat);
                            dm.tambahOperator(o);
                                }
                            }
                        }
                        }
                } else {
                    getResponse().sendRedirect("fieldKosong");
                }
                getResponse().sendRedirect("homeMember");
            } catch (IOException ex) {
                Logger.getLogger(registrasi.class.getName()).log(Level.SEVERE, null, ex);
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
