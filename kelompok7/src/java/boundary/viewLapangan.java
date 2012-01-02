/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarLapangan;
import entity.lapangan;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class viewLapangan extends Boundary {
    private operator operator;

    public viewLapangan() {
        super();
        setTemplate("/WEB-INF/viewLapangan.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
                    DaftarLapangan dl = new DaftarLapangan();
                    String ids = getRequest().getParameter("id");
                    Long id = Long.parseLong(ids);
                            dl.getLapanganId(id);
    }
}



