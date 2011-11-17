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
public class operator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String usernameOp;

    @Basic
    private String password;

    @Basic
    private String nameOp;

    @Basic
    private String addressOp;

    @Basic
    private int handphoneOp;

    @Basic
    private String emailOp;

    public operator() {
    }

    public operator(String usernameOp, String password, String nameOp, String addressOp, int handphoneOp, String emailOp) {
        this.usernameOp = usernameOp;
        this.password = password;
        this.nameOp = nameOp;
        this.addressOp = addressOp;
        this.handphoneOp = handphoneOp;
        this.emailOp = emailOp;
    }

    public String getUsernameOp() {
        return usernameOp;
    }

    public void setUsernameOp(String usernameOp) {
        this.usernameOp = usernameOp;
    }

    public String getNameOp() {
        return nameOp;
    }

    public void setNameOp(String nameOp) {
        this.nameOp = nameOp;
    }

    public String getAddressOp() {
        return addressOp;
    }

    public void setAddressOp(String addressOp) {
        this.addressOp = addressOp;
    }

    public int getHandphoneOp() {
        return handphoneOp;
    }

    public void setHandphoneOp(int handphoneOp) {
        this.handphoneOp = handphoneOp;
    }

    public String getEmailOp() {
        return emailOp;
    }

    public void setEmailOp(String emailOp) {
        this.emailOp = emailOp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usernameOp != null ? usernameOp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof operator)) {
            return false;
        }
        operator other = (operator) object;
        if ((this.usernameOp == null && other.usernameOp != null) || (this.usernameOp != null && !this.usernameOp.equals(other.usernameOp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.member[usernameOp=" + usernameOp + "]";
    }

}
