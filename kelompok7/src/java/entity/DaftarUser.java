package entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaftarUser {

    private int jumlahMember = -1;
    private int jumlahOperator = -1;

    public DaftarUser() {
        emf = Persistence.createEntityManagerFactory("kelompok7PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahMember
     */
    public int getJumlahMember() {

        if (jumlahMember == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) FROM members as o");
                Number jumlah = (Number) q.getSingleResult();
                jumlahMember = jumlah.intValue();

            } catch (javax.persistence.EntityNotFoundException e) {
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        } 

        return jumlahMember;
    }
    
    public int getJumlahOperator() {

        if (jumlahOperator == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) FROM operators as o");
                Number jumlah = (Number) q.getSingleResult();
                jumlahOperator = jumlah.intValue();

            } catch (javax.persistence.EntityNotFoundException e) {
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        } 

        return jumlahOperator;
    }

    /*public List<members> memberTerbaru() {
        List<members> member = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM member as o ORDER BY o.username DESC");
            q.setMaxResults(10);
            member = q.getResultList();

        } catch (javax.persistence.EntityNotFoundException e) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return member;
    }*/
    
    public members getMember(String username){
        members member = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM members as o WHERE o.username = :username");
            q.setParameter("username", username);
            member = (members) q.getSingleResult();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return member;
    }
    
    public operator getOperator(String username){
        operator op = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM operator as o WHERE o.username = :username");
            q.setParameter("username", username);
            op = (operator) q.getSingleResult();
        }catch(NoResultException e){
            
        }finally {
            if (em != null) {
                em.close();
            }
        }

        return op;
    }
    
    public void tambahMember(members member) {

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
    
    public void tambahOperator(operator op) {

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

    public void hapusMember(members member) {

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
    
    public void hapusOperator(operator op) {

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
    
    public void editMember(members member) {

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
    
    public void editOperator(operator op) {

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
}
