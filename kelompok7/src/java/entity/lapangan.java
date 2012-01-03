package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class lapangan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDLAP;

    @ManyToOne
    private operator operator;

    private String addressLap;
    private Integer statLap;

     public lapangan() {
    }
   
     public lapangan(Long IDLAP) {
        this.IDLAP = IDLAP;
    }

    public lapangan(Long IDLAP, operator operator, String address) {
        this.IDLAP = IDLAP;
        this.operator = operator;
        this.addressLap = address;
    }

    public Long getId() {
        return IDLAP;
    }

    public operator getOperator() {
        return operator;
    }

    public void setOperator(operator operator) {
        this.operator = operator;
    }

    public String getAddressLap() {
        return addressLap;
    }

    public void setAddressLap(String addressLap) {
        this.addressLap = addressLap;
    }

    public Integer getStatLap() {
        return statLap;
    }

    public void setStatLap(Integer statLap) {
        this.statLap = statLap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDLAP != null ? IDLAP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the IDLAP fields are not set
        if (!(object instanceof lapangan)) {
            return false;
        }
        lapangan other = (lapangan) object;
        if ((this.IDLAP == null && other.IDLAP != null) || (this.IDLAP != null && !this.IDLAP.equals(other.IDLAP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.lapangan[ IDLAP=" + IDLAP + " ]";
    }

}
