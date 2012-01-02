/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class activity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IDACT;
    private String IDLAP;
    private String dateBook;
    @ManyToOne
    private members member;
    members nameBooker = member;
    
    public String getIDLAP() {
        return IDLAP;
    }

    public void setIDLAP(String IDLAP) {
        this.IDLAP = IDLAP;
    }

    public members getNameBooker() {
        return nameBooker;
    }

    public void setMember(members member) {
        this.member = nameBooker;
    }

    public Integer getIDACT() {
        return IDACT;
    }

    public void setIDACT(Integer IDACT) {
        this.IDACT = IDACT;
    }

    public String getTanggalPayment() {
        return dateBook;
    }

    public void setTanggalPayment(String dateBook) {
        this.dateBook = dateBook;
    }
            
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDACT != null ? IDACT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the IDACT fields are not set
        if (!(object instanceof activity)) {
            return false;
        }
        activity other = (activity) object;
        if ((this.IDACT == null && other.IDACT != null) || (this.IDACT != null && !this.IDACT.equals(other.IDACT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.activity[ id=" + IDACT + " ]";
    }
    
}
