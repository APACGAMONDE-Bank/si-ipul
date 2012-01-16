package entity;

import entity.infoBerita;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.exceptions.NonexistentEntityException;

public class DaftarInfoBerita {

    private int jumlahInfoBerita = -1;
    private String username;

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

    public List<infoBerita> getListBeritaOperator(String op) {
        List<infoBerita> infoBerita= null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM infoBerita as o WHERE o.operator = :operator");
            q.setParameter("operator", op);
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
            ib = (infoBerita) q.getResultList();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return ib;
    }
    
    public int countIBOp (String operator){
        infoBerita ib  = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery(" SELECT count(o) FROM infoBerita as o WHERE o.operator = :operator");
            q.setParameter("operator", operator);
            Number jumlah = (Number) q.getSingleResult();
            jumlahInfoBerita = jumlah.intValue();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return jumlahInfoBerita;
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
    
    public void hapusInfo(String ib) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            infoBerita inf;
            try {
                inf = em.getReference(infoBerita.class, ib);
                inf.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The info with id " + ib + " no longer exists.", enfe);
            }
            em.remove(inf);
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
