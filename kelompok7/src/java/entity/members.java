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

    private String PASSWORD;
    private String NAMEMB;
    private String ADDRESSMB;
    private String HANDPHONEMB;
    private String EMAILMB;
    private int BOOKING;
    private int STATMB;

     public members() {
    }
   
     public members(String username) {
        this.username = username;
    }

    public members(String username, String PASSWORD) {
        this.username = username;
        this.PASSWORD = PASSWORD;
    }
    
    public members(String username, String PASSWORD, String name, String address, String handphone, String email) {
        this.username = username;
        this.PASSWORD = PASSWORD;
        this.NAMEMB = name;
        this.ADDRESSMB = address;
        this.HANDPHONEMB = handphone;
        this.EMAILMB = email;
        
    }
    
        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public void setPassword(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNameMb() {
        return NAMEMB;
    }

    public void setNameMb(String NAMEMB) {
        this.NAMEMB = NAMEMB;
    }

    public String getAddressMb() {
        return ADDRESSMB;
    }

    public void setAddressMb(String ADDRESSMB) {
        this.ADDRESSMB = ADDRESSMB;
    }

    public String getHandphoneMb() {
        return HANDPHONEMB;
    }

    public void setHandphoneMb(String HANDPHONEMB) {
        this.HANDPHONEMB = HANDPHONEMB;
    }

    public String getEmailMb() {
        return EMAILMB;
    }

    public void setEmailMb(String EMAILMB) {
        this.EMAILMB = EMAILMB;
    }

    public int getBooking() {
        return STATMB;
    }

    public void setBooking(int BOOKING) {
        this.BOOKING = BOOKING;
    }
    
    public int getStatMb() {
        return STATMB;
    }

    public void setStatMb(int STATMB) {
        this.STATMB = STATMB;
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
