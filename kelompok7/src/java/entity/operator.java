/**
 * @author radityo.p.w (radityo.p.w@gmail.com)
 * @version 1.0
 */

package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;


@Entity
public class operator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;

    //@ManyToOne
    //private members member;

    private String password;
    private String nameOp;
    private String addressOp;
    private String handphoneOp;
    private String emailOp;
    private Integer statOp;

     public operator() {
    }
   
     public operator(String username) {
        this.username = username;
    }

    public operator(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public operator(String username, String password, String name, String address, String handphone, String email) {
        this.username = username;
        this.password = password;
        this.nameOp = name;
        this.addressOp = address;
        this.handphoneOp = handphone;
        this.emailOp = email;
        
    }
    
        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getHandphoneOp() {
        return handphoneOp;
    }

    public void setHandphoneOp(String handphoneOp) {
        this.handphoneOp = handphoneOp;
    }

    public String getEmailOp() {
        return emailOp;
    }

    public void setEmailOp(String emailOp) {
        this.emailOp = emailOp;
    }

    public Integer getStatOp() {
        return statOp;
    }

    public void setStatOp(Integer statOp) {
        this.statOp = statOp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof operator)) {
            return false;
        }
        operator other = (operator) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.operator[ username=" + username + " ]";
    }

}
