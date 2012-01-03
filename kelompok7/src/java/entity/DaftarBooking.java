package entity;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaftarBooking {

    private int jumlahBooking = -1;

    public DaftarBooking() {
        emf = Persistence.createEntityManagerFactory("kelompok7PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahMember
     */
    public int getJumlahBooking() {

        if (jumlahBooking == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) booking FROM booking as o");
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
    
    public int getJumlahBookingOp(String operator) {

        if (jumlahBooking == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) booking FROM booking o, lapangan l WHERE o.LAP= l.IDLAP and l.OPERATOR_USERNAME = :username");
                q.setParameter("username", operator);
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

    public List<DaftarBooking> BookingTerbaru() {
        List<DaftarBooking> Booking = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM booking o, lapangan l, members m WHERE o.IDLAP = l.IDLAP AND o.USERNAME = m.USERNAME ORDER BY o.IDLAP");
            Booking = q.getResultList();

        } catch (javax.persistence.EntityNotFoundException e) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return Booking;
    }

    public booking getBooking (Long IDBOOK){
        booking l  = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM booking as o WHERE o.IDBOOK= :IDBOOK");
            q.setParameter("IDBOOK", IDBOOK);
            l = (booking) q.getSingleResult();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return l;
    }
    
    public booking getBO (String members){
        booking ib  = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM booking o WHERE o.members= :username");
            q.setParameter("username", members);
            ib = (booking) q.getSingleResult();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return ib;
    }
    
    public booking getBOp (String operator){
        booking ib  = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM booking o, lapangan l WHERE o.LAP= l.IDLAP and l.OPERATOR_USERNAME = :username");
            q.setParameter("username", operator);
            ib = (booking) q.getSingleResult();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return ib;
    }
    
    
    public void tambahBooking(booking Booking) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Booking.setDateBook(Calendar.getInstance().getTime());
            em.persist(Booking);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void hapusBooking(booking Booking) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(Booking);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public void editBooking(booking Booking) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(Booking);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
