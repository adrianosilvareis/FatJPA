package br.data.bancodedados;

import br.entidade.Acessos;
import br.entidade.GrupoUsuarios;
import br.entidade.Usuarios;
import br.entidade.business.Business;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class NovoBanco {
    
    private NovoBanco() {
    }
    
    public static NovoBanco getInstance() {
        return NovoBancoHolder.INSTANCE;
    }
    
    private static class NovoBancoHolder {
        private static final NovoBanco INSTANCE = new NovoBanco();
    }
    
    private EntityManager em = CriaConexao.getInstance().getEntityManager();
    
    public void NewBank() {
        GrupoUsuarios gu = new GrupoUsuarios("Administrador");
        gu.setAcessosList(acessos());
        Usuarios u = new Usuarios("Administrador", "ADMIN", "", false, gu);
        Business b = new Business();
        b.start(em);
        b.criar(gu);
        b.criar(u);
        b.salvar();
    }
    
    public List<Acessos> acessos(){
        List<Acessos> list = new ArrayList<>();
        //cadastro
        list.add(new Acessos("Atendente", "aten"));
        list.add(new Acessos("Convênio", "conv"));
        list.add(new Acessos("DePara Convênio", "deCo"));
        list.add(new Acessos("Mascara", "masc"));
        list.add(new Acessos("Status", "stat"));
        list.add(new Acessos("Não Conformidade", "ncon"));
        list.add(new Acessos("Unidade", "unid"));
        list.add(new Acessos("Banco", "bank"));
        list.add(new Acessos("Forma De Pagamento", "foPg"));
        //gerenciamento
        list.add(new Acessos("Acao", "acao"));
        list.add(new Acessos("Historico", "hist"));
        //Cadastro Administrativo
        list.add(new Acessos("Usuario", "usua"));
        list.add(new Acessos("Grupo Usuario", "GuUs"));
        list.add(new Acessos("Acessos", "aces"));
        //Upload
        list.add(new Acessos("Upload Inconsistencia", "UpIn"));
        list.add(new Acessos("Upload Desconto", "UpDe"));
        list.add(new Acessos("Upload Cortesia", "UpCo"));
        list.add(new Acessos("Upload Particular", "UpPa"));
        //Saida
        list.add(new Acessos("Auditoria de Inconsistencia", "au_inco"));
        list.add(new Acessos("Autditoria de Glosa", "au_glos"));
        list.add(new Acessos("Autditoria de Particular", "au_part"));
        list.add(new Acessos("Auditoria de Descontos", "au_desc"));
        list.add(new Acessos("Auditoria de Cortesia", "au_cort"));
        //producao
        list.add(new Acessos("Producao", "prod"));
        list.add(new Acessos("Fatura", "fatu"));
        list.add(new Acessos("Glosa", "glos"));
        list.add(new Acessos("Imposto", "impo"));
        //financeiro
        list.add(new Acessos("Perda", "perd"));
        list.add(new Acessos("Cobrança", "cobr"));
        list.add(new Acessos("Baixa Cobranca", "baCo"));
        list.add(new Acessos("Devedores", "deve"));
        
        for (Acessos l : list) {
            em.persist(l);
        }
        return list;
    }
}
