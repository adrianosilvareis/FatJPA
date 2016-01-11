/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.controle;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.entidade.sft.SftCtrlHistorico;
import br.entidade.sft.SftOutputGlos;
import entidade.controle.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

/**
 *
 * @author Adriano
 */
public class OutputGlosCtrl implements Serializable {

    public OutputGlosCtrl(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(SftOutputGlos sftOutputGlos) {
        EntityManager em = getEntityManager();
        em.persist(sftOutputGlos);
    }

    public SftOutputGlos edit(SftOutputGlos sftOutputGlos) {
        EntityManager em = getEntityManager();
        return em.merge(sftOutputGlos);
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        SftOutputGlos sftOutputGlos;
        try {
            sftOutputGlos = em.getReference(SftOutputGlos.class, id);
            sftOutputGlos.getGlosIdIdglos();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The sftOutputGlos with id " + id + " no longer exists.", enfe);
        }
        List<SftCtrlHistorico> sftCtrlHistoricoList = sftOutputGlos.getSftCtrlHistoricoList();
        for (SftCtrlHistorico sftCtrlHistoricoListSftCtrlHistorico : sftCtrlHistoricoList) {
            sftCtrlHistoricoListSftCtrlHistorico.getSftOutputGlosList().remove(sftOutputGlos);
            sftCtrlHistoricoListSftCtrlHistorico = em.merge(sftCtrlHistoricoListSftCtrlHistorico);
        }
        em.remove(sftOutputGlos);
    }

    public List<SftOutputGlos> findSftOutputGlosEntities() {
        return findSftOutputGlosEntities(true, -1, -1);
    }

    public List<SftOutputGlos> findSftOutputGlosEntities(int maxResults, int firstResult) {
        return findSftOutputGlosEntities(false, maxResults, firstResult);
    }

    private List<SftOutputGlos> findSftOutputGlosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(SftOutputGlos.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public SftOutputGlos findSftOutputGlos(Integer id) {
        EntityManager em = getEntityManager();
        return em.find(SftOutputGlos.class, id);
    }

    public int getSftOutputGlosCount() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<SftOutputGlos> rt = cq.from(SftOutputGlos.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<SftOutputGlos> getGlosMonth() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("SftOutputGlos.findMes", SftOutputGlos.class).setParameter("glosDtRegis", getGlosMaxMonth()).getResultList();
        } catch (Exception e) {
        }
        return null;
    }

    private String getGlosMaxMonth() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("SftOutputGlos.findMaxMonth").setParameter("glosDtRegis", getGlosMaxYear()).getSingleResult().toString();
        } catch (Exception e) {
        }
        return null;
    }

    private String getGlosMaxYear() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("SftOutputGlos.findMaxYear").getSingleResult().toString();
        } catch (Exception e) {
        }
        return null;
    }

    public List<SftOutputGlos> getGlosList(String os) throws IllegalStateException {
        EntityManager em = getEntityManager();
        return em.createNamedQuery("SftOutputGlos.findByGlosOsNumos", SftOutputGlos.class).setParameter("glosOsNumos", os).getResultList();
    }

    public List<br.entidade.sft.SftOutputGlos> Save(List<SftOutputGlos> list) throws RollbackException {
        EntityManager em = getEntityManager();
        List<br.entidade.sft.SftOutputGlos> merged = new ArrayList<>(list.size());
        for (br.entidade.sft.SftOutputGlos s : list) {
            if (s.getGlosOsNumos() != null) {
                merged.add(edit(s));
            } else {
                em.remove(s);
            }
        }
        list.clear();
        list.addAll(merged);
        em.getTransaction().commit();
        em.getTransaction().begin();

        return list;
    }

    public List<SftOutputGlos> refresh(List<SftOutputGlos> list) {
        EntityManager em = getEntityManager();

        em.getTransaction().rollback();
        em.getTransaction().begin();
        List data = getGlosMonth();
        for (Object entity : data) {
            em.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        return list;
    }

}
