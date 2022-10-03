/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao1;

import dao1.exceptions.NonexistentEntityException;
import dao1.exceptions.PreexistingEntityException;
import dao1.exceptions.RollbackFailureException;
import entities.MasterCliente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author Damian Sasia Ybar
 */
public class MasterClienteDAO implements Serializable {

    public MasterClienteDAO(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    // contrustructor por defecto
        public MasterClienteDAO() {
    }
    
    private UserTransaction utx = null;
    private EntityManagerFactory emf = Persistence.createEntityFactory("my_persistence_unit") ;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MasterCliente masterCliente) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(masterCliente);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMasterCliente(masterCliente.getCliId()) != null) {
                throw new PreexistingEntityException("MasterCliente " + masterCliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MasterCliente masterCliente) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            masterCliente = em.merge(masterCliente);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = masterCliente.getCliId();
                if (findMasterCliente(id) == null) {
                    throw new NonexistentEntityException("The masterCliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            MasterCliente masterCliente;
            try {
                masterCliente = em.getReference(MasterCliente.class, id);
                masterCliente.getCliId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The masterCliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(masterCliente);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MasterCliente> findMasterClienteEntities() {
        return findMasterClienteEntities(true, -1, -1);
    }

    public List<MasterCliente> findMasterClienteEntities(int maxResults, int firstResult) {
        return findMasterClienteEntities(false, maxResults, firstResult);
    }

    private List<MasterCliente> findMasterClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MasterCliente.class));
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

    public MasterCliente findMasterCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MasterCliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getMasterClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MasterCliente> rt = cq.from(MasterCliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    private static class Persistence {

        private static EntityManagerFactory createEntityFactory(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public Persistence() {
        }
    }
    
}
