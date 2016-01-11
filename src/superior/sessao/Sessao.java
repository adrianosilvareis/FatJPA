package superior.sessao;

import br.entidade.Usuarios;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import br.data.bancodedados.CriaConexao;

public class Sessao {

    private Sessao() {
    }

    private Usuarios user = new Usuarios();

    public static Sessao getInstance() {
        return SessaoHolder.INSTANCE;
    }

    private static class SessaoHolder {

        private static final Sessao INSTANCE = new Sessao();
    }

    public boolean setSessao(String nome, String senha) {
        EntityManager em = CriaConexao.getInstance().getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Usuarios> query = em.createNamedQuery("Usuarios.findBySessao", Usuarios.class);
        query.setParameter("login", nome);
        query.setParameter("senha", senha);

        try {
            setUser(query.getSingleResult());
            return true;
        } catch (NoResultException e) {
            return false;
        }

    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
}
