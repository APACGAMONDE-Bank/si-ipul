/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yogi
 */
public class formLogin extends boundary {

public formLogin(){
        super();
        setTemplate("/WEB-INF/jsps/index.jsp");
    }

    @Override
    protected void process() {

/*        setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_username()) {
                    if (validate_password()) {
                        member dp = new member();
                        DaftarPengunjung dpn = new DaftarPengunjung();
                        Pengunjung p = dpn.getPengunjung(getRequest().getParameter("email"));
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

                        dp.tambahPesan(pesan);
                    } else {
                        getResponse().sendRedirect("tambah_pesan_e2");
                    }
                } else {
                    getResponse().sendRedirect("tambah_pesan_e1");
                }
                getResponse().sendRedirect("daftar_pesan");
            } catch (IOException ex) {
                Logger.getLogger(HalamanTambahPesan.class.getName()).log(Level.SEVERE, null, ex);
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

        String pesan = getRequest().getParameter("pesan");

        if(pesan == null){
            return false;
        }

        if(pesan.trim().equals("")){
            return false;
        }*/

       // return true;
    }
}
