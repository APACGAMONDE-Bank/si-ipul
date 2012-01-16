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
        if (session.getAttribute("member") != null) {
            session.removeAttribute("member");
            session.removeAttribute("username");
            session.removeAttribute("email");
            session.removeAttribute("name");
            session.removeAttribute("address");
            session.removeAttribute("handphone");
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