package boundary;

import entity.DaftarInfoBerita;
import entity.DaftarUser;
import entity.infoBerita;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class addBerita extends Boundary {

    public addBerita(){
        super();
        setTemplate("/WEB-INF/addBerita.jsp");
    }

    @Override
    protected void process() {

        setMessage("");

         if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
                 if(check()){
                //if (validate_field()) {
                        DaftarInfoBerita dib = new DaftarInfoBerita();
                        if (getRequest().getParameter("picture") != null){
                                String pics = getRequest().getParameter("picture");
                                int pic = Integer.parseInt(pics);
                                HttpSession session = getRequest().getSession();
                                String op = (String) session.getAttribute("operator");
                                infoBerita m = dib.getIBOp("operator"); 
                        //if (m == null) {
                            m = new infoBerita();
                            m.setOperator(op);
                            m.setInfoBerita(getRequest().getParameter("berita"));
                            m.setPicture(pic);
                            m.setTitle(getRequest().getParameter("title"));                            
                            dib.tambahInfoBerita(m);}
                        else {int pic = 0;
                        HttpSession session = getRequest().getSession();
                        String op = (String) session.getAttribute("operator");
                        infoBerita m = dib.getIBOp("operator"); 
                        //if (m == null) {
                            m = new infoBerita();
                            m.setOperator(op);
                            m.setInfoBerita(getRequest().getParameter("berita"));
                            m.setPicture(pic);
                            m.setTitle(getRequest().getParameter("title"));                            
                            dib.tambahInfoBerita(m);
                        }
                    try {
                        //} else {
                        //    getResponse().sendRedirect("fieldKosong");
                        //}
                            getResponse().sendRedirect("homeOperator");
                    } catch (IOException ex) {
                        Logger.getLogger(addBerita.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }try {
                    getResponse().sendRedirect("loginOp");
                } catch (IOException ex) {
                    Logger.getLogger(addBerita.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            } 
    
       boolean check() {
        /*DaftarUser dm = new DaftarUser();
        HttpSession session = getRequest().getSession();
        String u = (String) session.getAttribute("username");
        if (dm.getMember(u) != null ) {
            return true;
        }*/
        return true;
    } 

    

    boolean validate_field() {
        
        String username = getRequest().getParameter("username");
        String j = getRequest().getParameter("title");
        String b = getRequest().getParameter("berita");
        if(username == null||j == null||b == null){
            return false;
        /*}
        if(username.trim().equals("")||password.trim().equals("")||address.trim().equals("")||handphone.trim().equals("")||email.trim().equals("")){
            return false;*/
        }

        return true;
    }

   
}
