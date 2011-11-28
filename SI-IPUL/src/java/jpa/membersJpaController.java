/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import model.members;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author yogi
 */
public class membersJpaController {

    public membersJpaController() {
        emf = Persistence.createEntityManagerFactory("SI-IPULPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(members members) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(members);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(members members) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            members = em.merge(members);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String uname = members.getUsernameMb();
                if (findMembers(uname) == null) {
                    throw new NonexistentEntityException("The members with usernameMb" + uname + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String uname) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            members members;
            try {
                members = em.getReference(members.class, uname);
                members.getUsernameMb();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pengunjung with username" + uname + " no longer exists.", enfe);
            }
            em.remove(members);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /*public List<members> findMembersEntities() {
        return findMembersEntities(true, -1, -1);
    }

    public List<Members> findMembersEntities(int maxResults, int firstResult) {
        return findMembersEntities(false, maxResults, firstResult);
    }

    private List<Pengunjung> findPengunjungEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pengunjung.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }*/

    public members findMembers(String uname) {
        EntityManager em = getEntityManager();
        try {
            return em.find(members.class, uname);
        } finally {
            em.close();
        }
    }

    public int getMembersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<members> rt = cq.from(members.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
