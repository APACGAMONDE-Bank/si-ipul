/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

//import entity.DaftarPengunjung;
//import entity.DaftarPesan;
//import entity.Pengunjung;
//import entity.Pesan;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
//public class addMember extends Boundary {
public class addMember {
   // super();
       // setTemplate("/WEB-INF/jsps/halaman_tambah_pesan.jsp");
    

    @Override
    protected void process() {

        setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_email()) {
                    if (validate_pesan()) {
                        DaftarMember dp = new DaftarMember();
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
                        getResponse().sendRedirect("tambah__e2");
                    }
                } else {
                    getResponse().sendRedirect("tambah_member_e1");
                }
                getResponse().sendRedirect("daftar_member");
            } catch (IOException ex) {
                Logger.getLogger(addMember.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
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

    public boolean validate_pesan() {

        String pesan = getRequest().getParameter("member");

        if(member == null){
            return false;
        }

        if(pesan.trim().equals("")){
            return false;
        }

        return true;
    }
}

