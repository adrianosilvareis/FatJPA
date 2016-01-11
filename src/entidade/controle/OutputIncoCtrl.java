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
import br.entidade.sft.SftOutputInco;
import entidade.controle.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Adriano
 */
public class OutputIncoCtrl implements Serializable {
    private static final long serialVersionUID = 1L;

    public OutputIncoCtrl(EntityManager em) {
        this.emf = em;
    }
    
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(SftOutputInco sftOutputInco) {
        EntityManager em = getEntityManager();
        em.persist(sftOutputInco);
    }

    public SftOutputInco edit(SftOutputInco sftOutputInco) {
        EntityManager em = getEntityManager();
        return em.merge(sftOutputInco);
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        SftOutputInco sftOutputInco;
        try {
            sftOutputInco = em.getReference(SftOutputInco.class, id);
            sftOutputInco.getIncoIdIdinco();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The sftOutputInco with id " + id + " no longer exists.", enfe);
        }
        List<SftCtrlHistorico> sftCtrlHistoricoList = sftOutputInco.getSftCtrlHistoricoList();
        for (SftCtrlHistorico sftCtrlHistoricoListSftCtrlHistorico : sftCtrlHistoricoList) {
            em.remove(sftCtrlHistoricoListSftCtrlHistorico);
        }
        em.remove(sftOutputInco);
    }

    public List<SftOutputInco> findSftOutputIncoEntities() {
        return findSftOutputIncoEntities(true, -1, -1);
    }

    public List<SftOutputInco> findSftOutputIncoEntities(int maxResults, int firstResult) {
        return findSftOutputIncoEntities(false, maxResults, firstResult);
    }

    private List<SftOutputInco> findSftOutputIncoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(SftOutputInco.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public SftOutputInco findSftOutputInco(Integer id) {
        EntityManager em = getEntityManager();

        return em.find(SftOutputInco.class, id);

    }

    public int getSftOutputIncoCount() {
        EntityManager em = getEntityManager();

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<SftOutputInco> rt = cq.from(SftOutputInco.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();

    }
    
    public List<br.entidade.sft.SftOutputInco> Save(List<SftOutputInco> list) throws RollbackException {
        EntityManager em = getEntityManager();
        List<br.entidade.sft.SftOutputInco> merged = new ArrayList<>(list.size());
        for (br.entidade.sft.SftOutputInco s : list) {
            if (s.getIncoOsNumos() != null) {
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
    
    public List<SftOutputInco> refresh(List<SftOutputInco> list){
        EntityManager em = getEntityManager();
        
        em.getTransaction().rollback();
        em.getTransaction().begin();
        List data = getIncoMonth();
        for (Object entity : data) {
            em.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        return list;
    }
    
    public List<SftOutputInco> getIncoList(String os) {
        EntityManager em = getEntityManager();
        return em.createNamedQuery("SftOutputInco.findByIncoOsNumos", SftOutputInco.class).setParameter("incoOsNumos", os).getResultList();
    }
    
    public List<SftOutputInco> getIncoMonth() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<SftOutputInco> q = em.createNamedQuery("SftOutputInco.findMes", SftOutputInco.class);
            q.setParameter("ano", getIncoMaxYear());
            q.setParameter("mes", getIncoMaxMonth());
            return q.getResultList();
        } catch (Exception e) {
        }
        return null;
    }
    
    public String getIncoMaxMonth() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("SftOutputInco.findMaxMonth").setParameter("incoDtRegis", getIncoMaxYear()).getSingleResult().toString();
        } catch (Exception e) {
        }
        return null;
    }
    
    public String getIncoMaxYear() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("SftOutputInco.findMaxYear").getSingleResult().toString(); 
        }catch(Exception e){
        }
        return null;
    }

}
