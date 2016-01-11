package br.data.bancodedados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaConexao {
    
    private CriaConexao() {
    }
    
    public static CriaConexao getInstance() {
        return CriaConexaoHolder.INSTANCE;
    }
    
    private static class CriaConexaoHolder {
        private static final CriaConexao INSTANCE = new CriaConexao();
    }
    private String nome;
    
    private EntityManagerFactory getConnection(){
        return Persistence.createEntityManagerFactory(getNomeUnidadePersistencia());
    }
    
    public EntityManager getEntityManager(){
        return getConnection().createEntityManager();
    }
    
    public void setNomeUnidadePersistencia(String nome){
        this.nome = nome;
    }
    
    public String getNomeUnidadePersistencia(){
        if(this.nome == null){
            nome = "JPAPU";
        }
        return this.nome;
    }
}