/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;


import entity.DaftarInfoBerita;
import entity.infoBerita;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class listBerita extends Boundary {
    private operator operator;

    public listBerita() {
        super();
        setTemplate("/WEB-INF/listBerita.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
        DaftarInfoBerita dib = new DaftarInfoBerita();
        if(validate_berita()){
            List<infoBerita> i = dib.sepuluhInfoTerbaru();
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

    private boolean validate_berita(){
        DaftarInfoBerita dib = new DaftarInfoBerita();
        int xx = dib.getJumlahInfoBerita();
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
}

