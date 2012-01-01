package entity;

import entity.infoBerita;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaftarInfoBerita {

    private int jumlahInfoBerita = -1;

    public DaftarInfoBerita() {
        emf = Persistence.createEntityManagerFactory("kelompok7PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahMember
     */
    public int getJumlahInfoBerita() {

        if (jumlahInfoBerita == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) FROM infoBerita as o");
                Number jumlah = (Number) q.getSingleResult();
                jumlahInfoBerita = jumlah.intValue();

            } catch (javax.persistence.EntityNotFoundException e) {
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        } 

        return jumlahInfoBerita;
    }

    public List<infoBerita> sepuluhInfoTerbaru() {
        List<infoBerita> infoBerita= null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM infoBerita as o ORDER BY o.id DESC");
            q.setMaxResults(10);
            infoBerita= q.getResultList();

        } catch (javax.persistence.EntityNotFoundException e) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return infoBerita;
    }

    public infoBerita getIBOp (String operator){
        infoBerita ib  = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM infoBerita as o WHERE o.operator = :operator");
            q.setParameter("operator", operator);
            ib = (infoBerita) q.getSingleResult();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return ib;
    }

    public infoBerita getInfoBerita (Long id){
        infoBerita ib  = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM infoBerita as o WHERE o.id = :id");
            q.setParameter("id", id);
            ib = (infoBerita) q.getSingleResult();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return ib;
    }
    
    public void tambahInfoBerita(infoBerita ib) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ib);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void hapusInfoBerita(infoBerita ib) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ib);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    public void editInfoBerita(infoBerita ib) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ib);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

}
