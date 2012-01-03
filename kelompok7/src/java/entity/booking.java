package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


@Entity
public class booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDBOOK;

    //@ManyToOne
    //private members members ;
    private String members ;

    //@ManyToOne
    private String lap;
    
    private int jam;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DATEBOOK;


     public booking() {
    }
   
     public booking(Long IDBOOK) {
        this.IDBOOK = IDBOOK;
    }

    public booking(Long IDBOOK, String members, String lap, int jam ) {
        this.IDBOOK = IDBOOK;
        this.members = members;
        this.lap = lap;
        this.jam = jam;
    }
    
    /*public booking(Long IDBOOK, members members, lapangan lap ) {
        this.IDBOOK = IDBOOK;
        this.members = members;
        this.lap = lap;
    }*/
        
        public Long getid() {
        return IDBOOK;
    }

    public void setid(Long IDBOOK) {
        this.IDBOOK = IDBOOK;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(Object member) {
        this.members = (String) member;
    }
    
    /*public void setMembers(members members) {
        this.members = members;
    }*/

    public String getLapangan() {
        return lap;
    }

     /*public void setLap(Object lap) {
        this.lap = (String) lap;
    }*/
     
     public void setLap(String lap) {
        this.lap = lap;
    }

    public Date getDateBook() {
        return DATEBOOK;
    }

    public void setDateBook(Date db) {
        this.DATEBOOK = db;
    }

    public int getJam() {
        return jam;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDBOOK != null ? IDBOOK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the IDBOOK fields are not set
        if (!(object instanceof booking)) {
            return false;
        }
        booking other = (booking) object;
        if ((this.IDBOOK == null && other.IDBOOK != null) || (this.IDBOOK != null && !this.IDBOOK.equals(other.IDBOOK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.booking[ IDBOOK=" + IDBOOK + " ]";
    }



}
