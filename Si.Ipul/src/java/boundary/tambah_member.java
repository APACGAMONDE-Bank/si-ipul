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
public class tambah_member {
    public tambah_member(){
        super();
        setTemplate("/WEB-INF/jsps/tambah_member.jsp");
    }

    @Override
    protected void process() {

        setMessage("");

        if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_email()) {
                    if (validate_pesan()) {
                        DaftarPesan dp = new DaftarPesan();
                        DaftarPengunjung dpn = new DaftarPengunjung();
                        Pengunjung p = dpn.getPengunjung(getRequest().getParameter("email"));
                        if (p == null) {
                            p = new Pengunjung();
                            p.setEmail(getRequest().getParameter("email"));
                            dpn.tambahPengunjung(p);
                        }
                        Member member = new Member();
                        member.setPengunjung(p);
                        String memberHtml = getRequest().getParameter("Member");
                        memberHtml = memberHtml.replaceAll("\n", "<br>");
                        member.setMember(memberHtml);

                        dp.tambah_member(member);
                    } else {
                        getResponse().sendRedirect("tambah_member_e2");
                    }
                } else {
                    getResponse().sendRedirect("tambah_member_e1");
                }
                getResponse().sendRedirect("daftar_member");
            } catch (IOException ex) {
                Logger.getLogger(HalamanTambahPesan.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean validate_member() {

        String member = getRequest().getParameter("pesan");

        if(member == null){
            return false;
        }

        if(password.trim().equals("")){
            return false;
        }

        return true;
    }
}

