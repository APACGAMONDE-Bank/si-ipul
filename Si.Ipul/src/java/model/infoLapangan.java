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
public class infoLapangan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idInfoLap;

    @Basic
    private String descInfo;

    @Basic
    private String idLap;

    @Basic
    private String pict;

    public infoLapangan() {
    }

    public infoLapangan(String idInfoLap, String descInfo, String idLap, String pict) {
        this.idInfoLap = idInfoLap;
        this.descInfo = descInfo;
        this.idLap = idLap;
        this.pict = pict;
    }

    public String getIdInfoLap() {
        return idInfoLap;
    }

    public void setIdInfoLap(String idInfoLap) {
        this.idInfoLap = idInfoLap;
    }

    public String getIdLap() {
        return idLap;
    }

    public void setIdLap(String idLap) {
        this.idLap = idLap;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    public String getPict() {
        return pict;
    }

    public void setPict(String pict) {
        this.pict = pict;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfoLap != null ? idInfoLap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof infoLapangan)) {
            return false;
        }
        infoLapangan other = (infoLapangan) object;
        if ((this.idInfoLap == null && other.idInfoLap != null) || (this.idInfoLap != null && !this.idInfoLap.equals(other.idInfoLap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.member[idInfoLap=" + idInfoLap + "]";
    }

}
