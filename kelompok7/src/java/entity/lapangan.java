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
    private Long id;

    @ManyToOne
    private operator operator;

    private String addressLap;
    private Integer statLap;

     public lapangan() {
    }
   
     public lapangan(Long id) {
        this.id = id;
    }

    public lapangan(Long id, operator operator, String address) {
        this.id = id;
        this.operator = operator;
        this.addressLap = address;
    }

    public Long getId() {
        return id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof lapangan)) {
            return false;
        }
        lapangan other = (lapangan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.lapangan[ id=" + id + " ]";
    }

}
