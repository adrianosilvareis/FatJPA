package br.entidade.business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import br.data.bancodedados.CriaConexao;

public class Business {
    private EntityManager em;

    public Business() {
        this.em = CriaConexao.getInstance().getEntityManager();
    }
    
    public EntityManager getEntityManager(){
        return this.em;
    }
    
    public void start(EntityManager em){
        EntityManager entity = em;
        if(em == null){
            entity = this.em;
        }
        entity.getTransaction().begin();
        this.em = entity;
    }
    
    public void close() {
        this.em.close();
    }
    
    public void criar(Object o){
        try{
            em.persist(o);
        }catch(Exception e){
            System.out.println("Erro ao criar Objeto: " + e);
        }
    }
    
    public void editar(Object o){
        try{
            em.merge(o);
        }catch(Exception e){
            System.out.println("Erro ao editar Objeto: " + e);
        }
    }
    
    public void remover(Object o){
        try{
            em.remove(o);
        }catch(Exception e){
            System.out.println("Erro ao remover Objeto: " + e);
        }
    }
    
    public void salvar(){
        try{
            em.getTransaction().commit();
            em.getTransaction().begin();
        }catch(Exception e){
            System.out.println("commit exception: " + e);
        }
    }
    
    public void refresh(){
        try{
            em.getTransaction().rollback();
        }catch(Exception e){
            System.out.println("Rollback exception: " + e);
        }
        em.getTransaction().begin();
    }
    /*
    Instruções
    <T extends Object> antes do retorno, 
    seguido do retorno tipo T
    recebendo Class<T> objeto no formato Object.class
    
    
    public <T extends Object> List<T> getLista(Class<T> objeto){
        
        List<T> list = new ArrayList<>();
        return list;
    }
    */
    
    public <T extends Object> List<T> findAll(Class<T> objeto) {

        CriteriaQuery cq = this.em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(objeto));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    public <T extends Object> T find(Class<T> entityClass, Object primaryKey){
        return em.find(entityClass, primaryKey);
    }
    
}
