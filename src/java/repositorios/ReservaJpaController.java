/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Huesped;
import Entidades.Reserva;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import repositorios.exceptions.NonexistentEntityException;
import repositorios.exceptions.PreexistingEntityException;

/**
 *
 * @author pdega
 */
public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    public ReservaJpaController() {
        
this.emf = Persistence.createEntityManagerFactory("ReservasCRUDPU");
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Huesped huesped = reserva.getHuesped();
            if (huesped != null) {
                huesped = em.getReference(huesped.getClass(), huesped.getIdPersona());
                reserva.setHuesped(huesped);
            }
            em.persist(reserva);
            if (huesped != null) {
                Reserva oldReservaOfHuesped = huesped.getReserva();
                if (oldReservaOfHuesped != null) {
                    oldReservaOfHuesped.setHuesped(null);
                    oldReservaOfHuesped = em.merge(oldReservaOfHuesped);
                }
                huesped.setReserva(reserva);
                huesped = em.merge(huesped);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReserva(reserva.getIdReserva()) != null) {
                throw new PreexistingEntityException("Reserva " + reserva + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getIdReserva());
            Huesped huespedOld = persistentReserva.getHuesped();
            Huesped huespedNew = reserva.getHuesped();
            if (huespedNew != null) {
                huespedNew = em.getReference(huespedNew.getClass(), huespedNew.getIdPersona());
                reserva.setHuesped(huespedNew);
            }
            reserva = em.merge(reserva);
            if (huespedOld != null && !huespedOld.equals(huespedNew)) {
                huespedOld.setReserva(null);
                huespedOld = em.merge(huespedOld);
            }
            if (huespedNew != null && !huespedNew.equals(huespedOld)) {
                Reserva oldReservaOfHuesped = huespedNew.getReserva();
                if (oldReservaOfHuesped != null) {
                    oldReservaOfHuesped.setHuesped(null);
                    oldReservaOfHuesped = em.merge(oldReservaOfHuesped);
                }
                huespedNew.setReserva(reserva);
                huespedNew = em.merge(huespedNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reserva.getIdReserva();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
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
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getIdReserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            Huesped huesped = reserva.getHuesped();
            if (huesped != null) {
                huesped.setReserva(null);
                huesped = em.merge(huesped);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
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

    public Reserva findReserva(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
