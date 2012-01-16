
package boundary;


import entity.DaftarInfoBerita;
import entity.DaftarUser;
import entity.infoBerita;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class listBerita extends Boundary {
    private operator operator;
   
    public listBerita() {
        super();
        setTemplate("/WEB-INF/listBerita.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
       HttpSession session = getRequest().getSession();
       String op = (String) session.getAttribute("username");
        DaftarInfoBerita dib = new DaftarInfoBerita();
        //if(check()){
            if(validate_berita()){
            List<infoBerita> i = (List<infoBerita>) dib.getListBeritaOperator(op);
            getRequest().setAttribute("daftar_berita", i.iterator());
        }
        else{
            try {
                getResponse().sendRedirect("listBeritaKosong");
            } catch (IOException ex) {
                Logger.getLogger(listBerita.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        
    }

        boolean check() {
        DaftarUser dm = new DaftarUser();
        HttpSession session = getRequest().getSession();
        String u = (String) session.getAttribute("username");
        if (dm.getOperator(u) != null ) {
            return true;
        }
        return false;
    }
    
    private boolean validate_berita(){
        DaftarInfoBerita dib = new DaftarInfoBerita();
         HttpSession session = getRequest().getSession();
        String op = (String) session.getAttribute("username");
        int xx = dib.countIBOp(op);
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
}

