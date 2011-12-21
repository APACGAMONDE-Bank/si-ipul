package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class infoBerita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private operator operator;

    private String infoBerita;
    private String title;
    private int picture;

     public infoBerita() {
    }
   
     public infoBerita(Long id) {
        this.id = id;
    }

    public infoBerita(Long id, operator operator, String info, int picture) {
        this.id = id;
        this.operator = operator;
        this.infoBerita = info;
        this.picture = picture;
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

    public String getInfoBerita() {
        return infoBerita;
    }

    public void setInfoBerita(String infoBerita) {
        this.infoBerita = infoBerita;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int pic) {
        this.picture = pic;
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
        if (!(object instanceof infoBerita)) {
            return false;
        }
        infoBerita other = (infoBerita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.infoBerita[ id=" + id + " ]";
    }

}
