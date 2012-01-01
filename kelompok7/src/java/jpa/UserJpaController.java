package jpa;

import entity.members;
import entity.operator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

public class UserJpaController {

    public UserJpaController() {
        emf = Persistence.createEntityManagerFactory("kelompok7PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(members member) {
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

    public void edit(members member) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            member = em.merge(member);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String username = member.getUsername();
                if (findMember(username) == null) {
                    throw new NonexistentEntityException("The member with username " + username + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String username) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            members member;
            try {
                member = em.getReference(members.class, username);
                member.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The member with username " + username + " no longer exists.", enfe);
            }
            em.remove(member);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<members> findMemberEntities() {
        return findMemberEntities(true, -1, -1);
    }

    public List<members> findMemberEntities(int maxResults, int firstResult) {
        return findMemberEntities(false, maxResults, firstResult);
    }

    private List<members> findMemberEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(members.class));
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

    public members findMember(String username) {
        EntityManager em = getEntityManager();
        try {
            return em.find(members.class, username);
        } finally {
            em.close();
        }
    }

    public int getMemberCount() {
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
    
//--------------------------------------------------------------------------------------
    
    public void create(operator op) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(op);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(operator op) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            op = em.merge(op);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String username = op.getUsername();
                if (findop(username) == null) {
                    throw new NonexistentEntityException("The operator with username " + username + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroyOp(String username) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            operator op;
            try {
                op = em.getReference(operator.class, username);
                op.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The op with username " + username + " no longer exists.", enfe);
            }
            em.remove(op);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<operator> findopEntities() {
        return findopEntities(true, -1, -1);
    }

    public List<operator> findopEntities(int maxResults, int firstResult) {
        return findopEntities(false, maxResults, firstResult);
    }

    private List<operator> findopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(operator.class));
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

    public operator findop(String username) {
        EntityManager em = getEntityManager();
        try {
            return em.find(operator.class, username);
        } finally {
            em.close();
        }
    }

    public int getopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<operator> rt = cq.from(operator.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
