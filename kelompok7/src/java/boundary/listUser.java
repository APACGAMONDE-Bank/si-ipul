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
import jpa.UserJpaController;
import jpa.exceptions.NonexistentEntityException;

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
            List<members> i = (List<members>) dib.memberAll();
            List<operator> a = (List<operator>) dib.operatorAll();
            getRequest().setAttribute("daftar_user", i.iterator());
            getRequest().setAttribute("daftar_op", a.iterator());
                }
        else{
            try {
                getResponse().sendRedirect("listUserKosong");
            } catch (IOException ex) {
                Logger.getLogger(listUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    private void delUser() throws NonexistentEntityException{
    UserJpaController d = new UserJpaController();
    members m = new members();
    d.destroy(getRequest().getParameter("username"));
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

