package jpa;

import entity.lapangan;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

public class LapanganJpaController {

    public LapanganJpaController() {
        emf = Persistence.createEntityManagerFactory("kelompok7PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(lapangan lapangan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lapangan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /*public void edit(String l) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            l = em.merge(l);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = lapangan.getId();
                if (findLapangan(id) == null) {
                    throw new NonexistentEntityException("Lapangan dengan id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }*/

        public void editLap(lapangan lap) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            lapangan l;
            try {
                l = em.getReference(lapangan.class, lap);
                l.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lapangan with username " + lap + " no longer exists.", enfe);
            }
            em.merge(l);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            lapangan lap;
            try {
                lap = em.getReference(lapangan.class, id);
                lap.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Lapangan dengan id " + id + " no longer exists.", enfe);
            }
            em.remove(lap);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<lapangan> findLapanganEntities() {
        return findLapanganEntities(true, -1, -1);
    }

    public List<lapangan> findLapanganEntities(int maxResults, int firstResult) {
        return findLapanganEntities(false, maxResults, firstResult);
    }

    private List<lapangan> findLapanganEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(lapangan.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public lapangan findLapangan(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(lapangan.class, id);
        } finally {
            em.close();
        }
    }

    public int getLapanganCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<lapangan> rt = cq.from(lapangan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
