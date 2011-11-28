/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/*import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;*/
import java.util.Calendar;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author yogi
 */


public class listBooking {

    private int jumlahBooking = -1;

    public listBooking() {
        emf = Persistence.createEntityManagerFactory("SI-IPULPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahPesan
     */
    public int getJumlahBooking() {

        if (jumlahBooking == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) FROM booking as o");
                Number jumlah = (Number) q.getSingleResult();
                jumlahBooking = jumlah.intValue();

            } catch (javax.persistence.EntityNotFoundException e) {
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        return jumlahBooking;
    }

    public List<booking> listBook() {
        List<booking> booking = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM booking as o ORDER BY o.username DESC");
            //q.setMaxResults(10);
            booking = q.getResultList();

        } catch (javax.persistence.EntityNotFoundException e) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return booking;
    }

    public void tambahBooking(booking booking) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            //listBooking.setTanggal(Calendar.getInstance().getTime());
            em.persist(booking);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}


/**/
