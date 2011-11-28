/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;

import model.members;
import model.daftarUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yogi
 */
public class formRegistration extends boundary {
   

    public formRegistration(){
        super();
        setTemplate("/WEB-INF/jsps/register.jsp");
    }

    @Override
    protected void process() {

        setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_username()) {
                    if (validate_password()) {
                        if (validate_name()) {
                            if (validate_address()) {
                                if (validate_email()) {
                                    if (validate_handphone()) {
                                    members mem = new members();
                                    mem.setUsernameMb(getRequest().getParameter("username"));
                                    mem.setPasswordMb(getRequest().getParameter("password"));
                                    mem.setNameMb(getRequest().getParameter("name"));
                                    mem.setAddressMb(getRequest().getParameter("address"));
                                    //mem.setHandphoneMb(getRequest().getParameter("handphone"));
                                    mem.setEmailMb(getRequest().getParameter("email"));
                        
                                    /*daftarUser du = new daftarUser();


                                    if (p == null) {
                                        p = new Pengunjung();
                                        p.setEmail(getRequest().getParameter("email"));
                                        dpn.tambahPengunjung(p);
                                    }
                                    Pesan pesan = new Pesan();
                                    pesan.setPengunjung(p);
                                    String pesanHtml = getRequest().getParameter("pesan");
                                    pesanHtml = pesanHtml.replaceAll("\n", "<br>");
                                    pesan.setPesan(pesanHtml);

                                    dp.tambahPesan(pesan);*/
                            } else {
                                getResponse().sendRedirect("e2");
                            }
                        } else {
                            getResponse().sendRedirect("tambah_pesan_e1");
                        }
                    } else {
                        getResponse().sendRedirect("tambah_pesan_e2");
                    }
                } else {
                    getResponse().sendRedirect("tambah_pesan_e1");
                }
            } else {
                getResponse().sendRedirect("tambah_pesan_e2");
            }
        } else {
            getResponse().sendRedirect("tambah_pesan_e1");
        }
                getResponse().sendRedirect("daftar_pesan");
            } catch (IOException ex) {
                Logger.getLogger(formRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
    }

    boolean validate_username() {
        
        String email = getRequest().getParameter("username");
        if(email == null){
            return false;
        }
        if(email.trim().equals("")){
            return false;
        }

        return true;
    }

    public boolean validate_password() {

        String pesan = getRequest().getParameter("password");

        if(pesan == null){
            return false;
        }

        if(pesan.trim().equals("")){
            return false;
        }

        return true;
    }
    
    boolean validate_name() {
        
        String email = getRequest().getParameter("name");
        if(email == null){
            return false;
        }
        if(email.trim().equals("")){
            return false;
        }

        return true;
    }

    public boolean validate_address() {

        String pesan = getRequest().getParameter("address");

        if(pesan == null){
            return false;
        }

        if(pesan.trim().equals("")){
            return false;
        }

        return true;
    }
    
    boolean validate_email() {
        
        String email = getRequest().getParameter("email");
        if(email == null){
            return false;
        }
        if(email.trim().equals("")){
            return false;
        }

        return true;
    }

    public boolean validate_handphone() {

        String pesan = getRequest().getParameter("handphone");

        if(pesan == null){
            return false;
        }

        if(pesan.trim().equals("")){
            return false;
        }

        return true;
    }
    
}
