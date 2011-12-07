/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.members;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author yogi
 */


public class daftarUser {

    public daftarUser() {
        emf = Persistence.createEntityManagerFactory("SI-IPULPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public members getPengunjung(String USERNAMEMB){
        members member = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM members as o WHERE o.USERNAMEMB = :USERNAMEMB");
            q.setParameter("USERNAMEMB", USERNAMEMB);
            member = (members) q.getSingleResult();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return member;
    }

    public void addMembers(members member){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(member);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


/*@Entity
public class daftarUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idAkun;

    private String password;

    private String USERNAMEMB;

    public daftarUser() {
    }

    public daftarUser(String idAkun, String password, String USERNAMEMB) {
        this.idAkun = idAkun;
        this.password = password;
        this.USERNAMEMB = USERNAMEMB;
    }

    public String getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(String idAkun) {
        this.idAkun = idAkun;
    }

    public String getUsername() {
        return USERNAMEMB;
    }

    public void setUsername(String USERNAMEMB) {
        this.USERNAMEMB = USERNAMEMB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAkun != null ? idAkun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof daftarUser)) {
            return false;
        }
        daftarUser other = (daftarUser) object;
        if ((this.idAkun == null && other.idAkun != null) || (this.idAkun != null && !this.idAkun.equals(other.idAkun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.daftarUser[idAkun=" + idAkun + "]";
    }*/

}
