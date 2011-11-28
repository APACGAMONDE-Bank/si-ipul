/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.sql.Time;
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
public class lapangan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idLap;

    @Basic
    private String nameLap;

    @Basic
    private String ownerLap;

    @Basic
    private String statusLap;

    @Basic
    private Time timeLap;

    public lapangan() {
    }

    public lapangan(String idLap, String nameLap, String ownerLap, String statusLap, Time timeLap) {
        this.idLap = idLap;
        this.nameLap = nameLap;
        this.ownerLap = ownerLap;
        this.statusLap = statusLap;
        this.timeLap = timeLap;
    }

    public String getIdLap() {
        return idLap;
    }

    public void setIdLap(String idLap) {
        this.idLap = idLap;
    }

    public String getNameLap() {
        return nameLap;
    }

    public void setNameLap(String nameLap) {
        this.nameLap = nameLap;
    }

    public String getOwnerLap() {
        return ownerLap;
    }

    public void setOwnerLap(String ownerLap) {
        this.ownerLap = ownerLap;
    }

    public String getStatusLap() {
        return statusLap;
    }

    public void setStatusLap(String statusLap) {
        this.statusLap = statusLap;
    }

    public Time getTimeLap() {
        return timeLap;
    }

    public void setTimeLap(Time timeLap) {
        this.timeLap = timeLap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLap != null ? idLap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof lapangan)) {
            return false;
        }
        lapangan other = (lapangan) object;
        if ((this.idLap == null && other.idLap != null) || (this.idLap != null && !this.idLap.equals(other.idLap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.member[idLap=" + idLap + "]";
    }

}
