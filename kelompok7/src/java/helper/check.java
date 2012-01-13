/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import boundary.Boundary;
import entity.DaftarUser;
import javax.servlet.http.HttpSession;

public class check extends Boundary {

        public boolean checkOp() {
        DaftarUser dm = new DaftarUser();
        HttpSession session = getRequest().getSession();
        if (dm.getOperator("username") != null ) {
            return true;
        }
        return false;
    }
        
        public boolean checkMem() {
        DaftarUser dm = new DaftarUser();
        HttpSession session = getRequest().getSession();
        if (dm.getMember("username") != null ) {
            return true;
        }
        return false;
    }
        
        public boolean checkAdm() {
        DaftarUser dm = new DaftarUser();
        HttpSession session = getRequest().getSession();
        if (dm.getAdmin("username") != null ) {
            return true;
        }
        return false;
    }

    @Override
    protected void process() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}