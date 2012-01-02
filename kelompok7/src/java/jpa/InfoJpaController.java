package jpa;

import entity.infoBerita;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

public class InfoJpaController {

    public InfoJpaController() {
        emf = Persistence.createEntityManagerFactory("kelompok7PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(infoBerita ib) {
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

    public void edit(infoBerita ib) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ib = em.merge(ib);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id  = ib.getId();
                if (findBerita(id) == null) {
                    throw new NonexistentEntityException("The berita with id " + id + " no longer exists.");
                }
            }
            throw ex;
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
            infoBerita ib;
            try {
                ib = em.getReference(infoBerita.class, id);
                ib.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Berita dengan id " + id + " no longer exists.", enfe);
            }
            em.remove(ib);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<infoBerita> findBeritaEntities() {
        return findBeritaEntities(true, -1, -1);
    }

    public List<infoBerita> findBeritaEntities(int maxResults, int firstResult) {
        return findBeritaEntities(false, maxResults, firstResult);
    }

    private List<infoBerita> findBeritaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(infoBerita.class));
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

    public infoBerita findBerita(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(infoBerita.class, id);
        } finally {
            em.close();
        }
    }

    public int getBeritaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<infoBerita> rt = cq.from(infoBerita.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
