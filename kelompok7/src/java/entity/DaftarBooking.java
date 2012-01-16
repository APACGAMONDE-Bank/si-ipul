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
    
    public int getJumlahBookingOp(operator username) {

        if (jumlahBooking == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) booking FROM booking o, lapangan l WHERE o.lap = l.IDLAP and l.operator = :operator");
                q.setParameter("operator", username);
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
    
    public List<DaftarBooking> getBO(String username) {
        List<DaftarBooking> booking = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM booking as o WHERE o.members = :username");
            q.setParameter("username", username);
            booking = q.getResultList();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return booking;
    }
    
    public List<DaftarBooking> getBOp (operator op){
        List<DaftarBooking> booking = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM booking o, lapangan l WHERE o.lap= l.IDLAP and l.statLap = 1 and l.operator = :username");
            q.setParameter("username", op);
            booking = q.getResultList();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return booking;
    }
    
    public List<DaftarBooking> getHistory (operator op){
        List<DaftarBooking> booking = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM booking o, lapangan l WHERE o.lap= l.IDLAP and l.statLap = 2 and l.operator = :username");
            q.setParameter("username", op);
            booking = q.getResultList();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return booking;
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
