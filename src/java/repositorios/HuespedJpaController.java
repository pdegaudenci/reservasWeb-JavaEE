
package repositorios;

import Entidades.Huesped;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Reserva;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import repositorios.exceptions.NonexistentEntityException;


public class HuespedJpaController implements Serializable {

    public HuespedJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    public HuespedJpaController() {
     this.emf = Persistence.createEntityManagerFactory("ReservasCRUDPU");
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Huesped huesped) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva reserva = huesped.getReserva();
            if (reserva != null) {
                reserva = em.getReference(reserva.getClass(), reserva.getIdReserva());
                huesped.setReserva(reserva);
            }
            em.persist(huesped);
            if (reserva != null) {
                Huesped oldHuespedOfReserva = reserva.getHuesped();
                if (oldHuespedOfReserva != null) {
                    oldHuespedOfReserva.setReserva(null);
                    oldHuespedOfReserva = em.merge(oldHuespedOfReserva);
                }
                reserva.setHuesped(huesped);
                reserva = em.merge(reserva);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Huesped huesped) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Huesped persistentHuesped = em.find(Huesped.class, huesped.getIdPersona());
            Reserva reservaOld = persistentHuesped.getReserva();
            Reserva reservaNew = huesped.getReserva();
            if (reservaNew != null) {
                reservaNew = em.getReference(reservaNew.getClass(), reservaNew.getIdReserva());
                huesped.setReserva(reservaNew);
            }
            huesped = em.merge(huesped);
            if (reservaOld != null && !reservaOld.equals(reservaNew)) {
                reservaOld.setHuesped(null);
                reservaOld = em.merge(reservaOld);
            }
            if (reservaNew != null && !reservaNew.equals(reservaOld)) {
                Huesped oldHuespedOfReserva = reservaNew.getHuesped();
                if (oldHuespedOfReserva != null) {
                    oldHuespedOfReserva.setReserva(null);
                    oldHuespedOfReserva = em.merge(oldHuespedOfReserva);
                }
                reservaNew.setHuesped(huesped);
                reservaNew = em.merge(reservaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = huesped.getIdPersona();
                if (findHuesped(id) == null) {
                    throw new NonexistentEntityException("The huesped with id " + id + " no longer exists.");
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
            Huesped huesped;
            try {
                huesped = em.getReference(Huesped.class, id);
                huesped.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The huesped with id " + id + " no longer exists.", enfe);
            }
            Reserva reserva = huesped.getReserva();
            if (reserva != null) {
                reserva.setHuesped(null);
                reserva = em.merge(reserva);
            }
            em.remove(huesped);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Huesped> findHuespedEntities() {
        return findHuespedEntities(true, -1, -1);
    }

    public List<Huesped> findHuespedEntities(int maxResults, int firstResult) {
        return findHuespedEntities(false, maxResults, firstResult);
    }

    private List<Huesped> findHuespedEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Huesped.class));
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

    public Huesped findHuesped(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Huesped.class, id);
        } finally {
            em.close();
        }
    }

    public int getHuespedCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Huesped> rt = cq.from(Huesped.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
