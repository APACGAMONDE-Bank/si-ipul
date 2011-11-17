/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yogi
 */
public class formRegistration extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Form</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Form Pendaftaran Si.Ipul</h2>");
            out.println("<form method ='post'action='show'>");
            out.println("<fieldset>"
                    + "Username: " + "<input type='text' name='username' />" +
                    "</br>"+"</br>"
                    + "Password: " + "<input type='text' name='password' />" +
                    "</br>"+"</br>"
                    + "Nama: " + "<input type='text' name='name' />" +
                    "</br>"+"</br>"
                    + "Alamat: " + "<textarea name='address'> + </textarea>" +
                    "</br>"+"</br>"
                    + "Nomer Handphone: " + "<input type='text' name='handphone' />" +
                    "</br>"+"</br>"
                    + "Email: " + "<input type='text' name='email' />" +
                    "</br>"+"</br>"
                    + "Tipe: " + "<input type='radio' name='typeUser' value='member' />" + "Member"
                    + "<input type='radio' name='typeUser' value='operator' />" + "Pemilik Lapangan" +
                    "</br>"+"</br>"
                    + "<input type='submit' value='Daftar ' />" +
                    "</fieldset>"
                    );
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
