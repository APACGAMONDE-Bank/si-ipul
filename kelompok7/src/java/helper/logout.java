/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import boundary.Boundary;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class logout extends Boundary {

    @Override
    protected void process() {
        HttpSession session = getRequest().getSession();
        if (session.getAttribute("uname") != null) {
            session.removeAttribute("uname");
            session.invalidate();
            try {
                getResponse().sendRedirect("login");
            } catch (IOException ex) {
                Logger.getLogger(logout.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            session.setAttribute("error", "sudah logout sebelumnya");
            try {
                getResponse().sendRedirect("login");
            } catch (IOException ex) {
                Logger.getLogger(logout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}