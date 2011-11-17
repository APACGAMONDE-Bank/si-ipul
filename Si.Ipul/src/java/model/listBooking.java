/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author yogi
 */
@Entity
public class listBooking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idBooking;

    @Basic
    private String nameBooking;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateBooking;

    @Basic
    private String statusBooking;

    @Basic
    private String booker;

    @Basic
    private String lapanganBooked;

    public listBooking() {
    }

    public listBooking(String idBooking, String nameBooking, Date dateBooking, String statusBooking, String booker, String lapanganBooked) {
        this.idBooking = idBooking;
        this.nameBooking = nameBooking;
        this.dateBooking = dateBooking;
        this.statusBooking = statusBooking;
        this.booker = booker;
        this.lapanganBooked = lapanganBooked;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getNameBooking() {
        return nameBooking;
    }

    public void setNameBooking(String nameBooking) {
        this.nameBooking = nameBooking;
    }

    public String getStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(String statusBooking) {
        this.statusBooking = statusBooking;
    }

    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    public String getLapanganBooked() {
        return lapanganBooked;
    }

    public void setLapanganBooked(String lapanganBooked) {
        this.lapanganBooked = lapanganBooked;
    }

   @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBooking != null ? idBooking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof listBooking)) {
            return false;
        }
        listBooking other = (listBooking) object;
        if ((this.idBooking == null && other.idBooking != null) || (this.idBooking != null && !this.idBooking.equals(other.idBooking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.listBooking[idBooking=" + idBooking + "]";
    }

}
