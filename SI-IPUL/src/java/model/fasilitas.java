/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
//import java.sql.Time;
//import java.util.Date;
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
public class fasilitas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idFasil;

    @Basic
    private String descFasil;

    @Basic
    private String idLap;

    public fasilitas() {
    }

    public fasilitas(String idFasil, String descFasil, String idLap) {
        this.idFasil = idFasil;
        this.descFasil = descFasil;
        this.idLap = idLap;
    }

    public String getIdFasil() {
        return idFasil;
    }

    public void setIdFasil(String idFasil) {
        this.idFasil = idFasil;
    }

    public String getIdLap() {
        return idLap;
    }

    public void setIdLap(String idLap) {
        this.idLap = idLap;
    }

    public String getDescFasil() {
        return descFasil;
    }

    public void setDescFasil(String descFasil) {
        this.descFasil = descFasil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFasil != null ? idFasil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof fasilitas)) {
            return false;
        }
        fasilitas other = (fasilitas) object;
        if ((this.idFasil == null && other.idFasil != null) || (this.idFasil != null && !this.idFasil.equals(other.idFasil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.member[idFasil=" + idFasil + "]";
    }

}
