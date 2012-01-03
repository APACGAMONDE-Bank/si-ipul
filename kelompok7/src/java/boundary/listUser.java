/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;


import entity.DaftarUser;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class listUser extends Boundary {

    public listUser() {
        super();
        setTemplate("/WEB-INF/listUser.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
        DaftarUser dib = new DaftarUser();
        if(validate_user()){
            List<members> i = (List<members>) dib.getMember(null);
            List<operator> ii = (List<operator>) dib.getOperator(null);
            getRequest().setAttribute("daftar_user", i.iterator());
        }
        else{
            try {
                getResponse().sendRedirect("listUserKosong");
            } catch (IOException ex) {
                Logger.getLogger(listUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        }

    private boolean validate_user(){
        DaftarUser dib = new DaftarUser();
        int xx = dib.getJumlahUser();
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
}

