package superior.sessao;

import br.entidade.business.Business;
import br.entidade.sft.SftCtrlAcao;
import br.entidade.sft.SftCtrlHistorico;
import br.entidade.sft.SftOutputGlos;
import br.entidade.sft.SftOutputInco;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import br.data.bancodedados.CriaConexao;
import br.entidade.sft.SftOutputPart;
import static javafx.scene.input.KeyCode.T;

public class Logger {

    private Logger() {
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    private static class LoggerHolder {

        private static final Logger INSTANCE = new Logger();
    }
    
    public List<SftCtrlHistorico> glosRegistros(String acao, String descricao, List<SftCtrlHistorico> list, SftOutputGlos g) {
        List<SftOutputGlos> outList = new ArrayList<>();
        outList.add(g);
        Date dat = new Date(new java.util.Date().getTime());
        SftCtrlHistorico hist = new SftCtrlHistorico();
        hist.setSftOutputGlosList(outList);
        hist.setHistDtRegis(dat);
        try {
            hist.setFkAcao(findAcao(acao));
        } catch (NoResultException e) {
            hist.setFkAcao(cadastroAcao(acao));
        }
        hist.setUsuariosId(Sessao.getInstance().getUser());
        hist.setHistNmDescricao(descricao);

        int result = teste(acao, descricao, list);
        if (result == -1) {
            //passou
            list.add(hist);
        }
        return list;
    }
    
    public List<SftCtrlHistorico> incoRegistros(String acao, String descricao, List<SftCtrlHistorico> list, SftOutputInco i) {
        List<SftOutputInco> outList = new ArrayList<>();
        outList.add(i);
        Date dat = new Date(new java.util.Date().getTime());
        SftCtrlHistorico hist = new SftCtrlHistorico();
        hist.setSftOutputIncoList(outList);
        hist.setHistDtRegis(dat);
        try {
            hist.setFkAcao(findAcao(acao));
        } catch (NoResultException e) {
            hist.setFkAcao(cadastroAcao(acao));
        }
        hist.setUsuariosId(Sessao.getInstance().getUser());
        hist.setHistNmDescricao(descricao);

        int result = teste(acao, descricao, list);
        if (result == -1) {
            //passou
            list.add(hist);
        }
        return list;
    }
    
      public List<SftCtrlHistorico> partRegistros(String acao, String descricao, SftOutputPart p) {
        List<SftOutputPart> listPart = new ArrayList<>();
        listPart.add(p);
        Date dat = new Date(new java.util.Date().getTime());
        SftCtrlHistorico hist = new SftCtrlHistorico();
        hist.setHistDtRegis(dat);
        hist.setSftOutputPartList(listPart);
        List<SftCtrlHistorico> list = new ArrayList<>();
        try {
            hist.setFkAcao(findAcao(acao));
        } catch (NoResultException e) {
            hist.setFkAcao(cadastroAcao(acao));
        }
        hist.setUsuariosId(Sessao.getInstance().getUser());
        hist.setHistNmDescricao(descricao);
        CriaConexao.getInstance().getEntityManager().persist(hist);
        list.add(hist);
        return list;
    }
      
    private int teste(String acao, String descricao, List<SftCtrlHistorico> list) {
        
        int i = 0;
        for (SftCtrlHistorico h : list) {
            if (h.getFkAcao().getAcaoNmNome().equals(acao) && h.getHistNmDescricao().equals(descricao) || descricao.equals("")) {
                //reprovou
                return i;
            }
            i++;
        }
        //passsou
        return -1;
    }

    private SftCtrlAcao findAcao(String acao) {
        Business dao = new Business();
        return dao.getEntityManager()
                .createNamedQuery("SftCtrlAcao.findByAcaoNmNome", SftCtrlAcao.class)
                .setParameter("acaoNmNome", acao).getSingleResult();
    }

    private SftCtrlAcao cadastroAcao(String acao) {
        SftCtrlAcao action = new SftCtrlAcao();
        action.setAcaoNmNome(acao);
        Business dao = new Business();
        dao.getEntityManager().getTransaction().begin();
        dao.criar(action);
        dao.getEntityManager().getTransaction().commit();
        return action;
    }
}
