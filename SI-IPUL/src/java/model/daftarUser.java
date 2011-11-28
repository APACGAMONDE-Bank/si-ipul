/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author yogi
 */
@Entity
public class daftarUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idAkun;

    private String password;

    private String username;

    public daftarUser() {
    }

    public daftarUser(String idAkun, String password, String username) {
        this.idAkun = idAkun;
        this.password = password;
        this.username = username;
    }

    public String getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(String idAkun) {
        this.idAkun = idAkun;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAkun != null ? idAkun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof daftarUser)) {
            return false;
        }
        daftarUser other = (daftarUser) object;
        if ((this.idAkun == null && other.idAkun != null) || (this.idAkun != null && !this.idAkun.equals(other.idAkun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.daftarUser[idAkun=" + idAkun + "]";
    }

}
