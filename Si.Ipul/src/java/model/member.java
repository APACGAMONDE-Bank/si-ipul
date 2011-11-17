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
public class member implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String usernameMb;

    @Basic
    private String password;

    @Basic
    private String nameMb;

    @Basic
    private String addressMb;

    @Basic
    private int handphoneMb;

    @Basic
    private String emailMb;

    private boolean isLogin;


    public member() {
    }

    public member(String usernameMb, String password, String nameMb, String addressMb, int handphoneMb, String emailMb) {
        this.usernameMb = usernameMb;
        this.password = password;
        this.nameMb = nameMb;
        this.addressMb = addressMb;
        this.handphoneMb = handphoneMb;
        this.emailMb = emailMb;
    }

    public String getUsernameMb() {
        return usernameMb;
    }

    public void setUsernameMb(String usernameMb) {
        this.usernameMb = usernameMb;
    }

    public String getNameMb() {
        return nameMb;
    }

    public void setNameMb(String nameMb) {
        this.nameMb = nameMb;
    }

    public String getAddressMb() {
        return addressMb;
    }

    public void setAddressMb(String addressMb) {
        this.addressMb = addressMb;
    }

    public int getHandphoneMb() {
        return handphoneMb;
    }

    public void setHandphoneMb(int handphoneMb) {
        this.handphoneMb = handphoneMb;
    }

    public String getEmailMb() {
        return emailMb;
    }

    public void setEmailMb(String emailMb) {
        this.emailMb = emailMb;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usernameMb != null ? usernameMb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof member)) {
            return false;
        }
        member other = (member) object;
        if ((this.usernameMb == null && other.usernameMb != null) || (this.usernameMb != null && !this.usernameMb.equals(other.usernameMb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.member[usernameMb=" + usernameMb + "]";
    }

}
