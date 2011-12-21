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
public class members implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;

    //@ManyToOne
    //private members member;

    private String password;
    private String nameMb;
    private String addressMb;
    private String handphoneMb;
    private String emailMb;
    private int statMb;

     public members() {
    }
   
     public members(String username) {
        this.username = username;
    }

    public members(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public members(String username, String password, String name, String address, String handphone, String email) {
        this.username = username;
        this.password = password;
        this.nameMb = name;
        this.addressMb = address;
        this.handphoneMb = handphone;
        this.emailMb = email;
        
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

    public String getHandphoneMb() {
        return handphoneMb;
    }

    public void setHandphoneMb(String handphoneMb) {
        this.handphoneMb = handphoneMb;
    }

    public String getEmailMb() {
        return emailMb;
    }

    public void setEmailMb(String emailMb) {
        this.emailMb = emailMb;
    }

    public int getStatMb() {
        return statMb;
    }

    public void setStatMb(int statMb) {
        this.statMb = statMb;
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
        if (!(object instanceof members)) {
            return false;
        }
        members other = (members) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.members[ username=" + username + " ]";
    }

}
