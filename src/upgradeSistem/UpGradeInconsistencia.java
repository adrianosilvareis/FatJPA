/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upgradeSistem;

import br.entidade.Convenio;
import br.entidade.business.Business;
import br.entidade.sft.SftInputAten;
import br.entidade.sft.SftInputNcon;
import br.entidade.sft.SftInputStat;
import br.entidade.sft.SftInputUnid;
import br.entidade.sft.SftOutputInco;
import entidade.controle.OutputIncoCtrl;
import form.util.LeData;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import br.data.bancodedados.CriaConexao;
import superior.entrada.Tradutor;
import superior.mensagens.ErroMensagens;
import superior.sessao.Logger;
import superior.sessao.Sessao;

/**
 *
 * @author Adriano
 */
public class UpGradeInconsistencia extends javax.swing.JFrame {

    /**
     * Creates new form UpGradeInconsistencia
     */
    public UpGradeInconsistencia() {
        initComponents();
        iniciarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JPanel();
        uploadButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        pesquisarButton = new javax.swing.JButton();
        pesquisaFild = new javax.swing.JTextField();
        Painel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        uploadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/upload.png"))); // NOI18N
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/save.png"))); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/refresh.png"))); // NOI18N
        refreshButton.setToolTipText("Atualizar");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        pesquisarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/search.png"))); // NOI18N
        pesquisarButton.setToolTipText("Pesquisar");
        pesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uploadButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisaFild, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(refreshButton)
                            .addComponent(pesquisarButton))
                        .addComponent(saveButton)
                        .addComponent(uploadButton))
                    .addComponent(pesquisaFild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        Painel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        masterTable.setModel(dtm);
        jScrollPane1.setViewportView(masterTable);

        javax.swing.GroupLayout Painel2Layout = new javax.swing.GroupLayout(Painel2);
        Painel2.setLayout(Painel2Layout);
        Painel2Layout.setHorizontalGroup(
            Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
        );
        Painel2Layout.setVerticalGroup(
            Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        jProgressBar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Painel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Painel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Painel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        // TODO add your handling code here:
        Sessao.getInstance().setSessao("admin", "admin");
        upload();
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        list = dao.Save(list);
        mostraPesquisa();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        list = dao.refresh(list);
        mostraPesquisa();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void pesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarButtonActionPerformed
        // TODO add your handling code here:
        pesquisa(pesquisaFild.getText());
    }//GEN-LAST:event_pesquisarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpGradeInconsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpGradeInconsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpGradeInconsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpGradeInconsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpGradeInconsistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JPanel Painel2;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField pesquisaFild;
    private javax.swing.JButton pesquisarButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
    private EntityManager emf;
    private List<SftOutputInco> list;
    private List<String[]> result;
    private List<SftInputUnid> boxUnid;
    private List<Convenio> boxConv;
    private List<SftInputNcon> boxNcon;
    private List<SftInputAten> boxAten;
    private List<SftInputStat> boxStatus;
    private List<String> codStatus;
    private List<String> codAten;
    private List<Integer> codUnid;
    private List<String> codMascara;
    private List<String> codNcon;
    private OutputIncoCtrl dao;

    private DefaultTableModel dtm = new DefaultTableModel(null, new String[]{
        "Usuario", "Data", "Numero OS", "Unidade", "Atendente",
        "Convenio", "Não Conformidade", "Observação", "Status"});

    private void iniciarComponentes() {
        CriaConexao.getInstance().setNomeUnidadePersistencia("FatJPA");
        emf = CriaConexao.getInstance().getEntityManager();
        dao = new OutputIncoCtrl(emf);
        dao.getEntityManager().getTransaction().begin();//inicia a transação
        listarPesquisa();
        listarBox();
    }

    private void listarPesquisa() {
        list = dao.getIncoList("%%");
        boxUnid = new Business().findAll(SftInputUnid.class);
        boxAten = new Business().findAll(SftInputAten.class);
        boxConv = new Business().findAll(Convenio.class);
        boxNcon = new Business().findAll(SftInputNcon.class);
        boxStatus = new Business().findAll(SftInputStat.class);
        mostraPesquisa();
    }

    public void pesquisa(String os) {
        list = dao.getIncoList("%" + os + "%");
        mostraPesquisa();
    }

    private void listarBox() {

        codAten = new ArrayList<>();
        for (SftInputAten aten : boxAten) {
            codAten.add(aten.getAtenNmNmaten());
        }

        codUnid = new ArrayList<>();
        for (SftInputUnid sftUnid : boxUnid) {
            codUnid.add(sftUnid.getUnidCodCodigo());
        }

        codMascara = new ArrayList<>();
        for (Convenio conv : boxConv) {
            codMascara.add(conv.getMascaraConvenioId().getDescricao());
        }
        
        codStatus = new ArrayList<>();
        for (SftInputStat status : boxStatus) {
            codStatus.add(status.getStatusNmDescricao());
        }
        
        codNcon = new ArrayList<>();
        for (SftInputNcon ncon : boxNcon) {
            codNcon.add(ncon.getNconNmNmncon());
        }
    }


    private void mostraPesquisa() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        if (list.isEmpty()) {
            ErroMensagens.getInstancia().InformacaoMensagem("Nenhum resultado encontrado");
        } else {

            String[] linha = new String[]{null, null, null, null, null, null, null, null, null};
            int i = 0;
            for (SftOutputInco sftInco : list) {
                try {
                    int size = sftInco.getSftCtrlHistoricoList().size() - 1;
                    dtm.addRow(linha);//adiciona linha vazia
                    dtm.setValueAt(sftInco.getIncoOsNumos(), i, 2);//OS

                    dtm.setValueAt(((sftInco.getSftCtrlHistoricoList() != null) ? sftInco.getSftCtrlHistoricoList()
                            .get(size).getUsuariosId().getLogin() : null), i, 0);//Seta usuario se não for nulo
                    dtm.setValueAt(((sftInco.getFkUnid() != null) ? sftInco.getFkUnid()
                            .getUnidNmNmunid() : null), i, 3);//Seta unidade se não for nulo
                    dtm.setValueAt(((sftInco.getFkAten() != null) ? sftInco.getFkAten()
                            .getAtenNmNmaten() : null), i, 4);//Seta atendente se não for nulo
                    dtm.setValueAt(((sftInco.getFkConv() != null) ? sftInco.getFkConv()
                            .getMascaraConvenioId().getDescricao() : null), i, 5);//Seta convenio se não for nulo
                    dtm.setValueAt(((sftInco.getFkNcon() != null) ? sftInco.getFkNcon()
                            .getNconNmNmncon() : null), i, 6);//Seta nao conformidade se não for nulo
                    dtm.setValueAt(sftInco.getIncoObObsinco(), i, 7);//seta Observação
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    dtm.setValueAt(formato.format(sftInco.getSftCtrlHistoricoList().get(size).getHistDtRegis()), i, 1);//seta data
                    dtm.setValueAt((sftInco.getFkStat() != null) ? sftInco.getFkStat()//seta Status se naõ for nulo
                            .getStatusNmDescricao() : null, i, 8);
                    i++;
                } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Erro na visualização");
                }
            }
        }
    }

    private void upload() throws HeadlessException {
        // TODO add your handling code here:
        JFileChooser choose = new JFileChooser();
        choose.showOpenDialog(null);
        File file = choose.getSelectedFile();
        if (choose.getSelectedFile() != null) {
            String filename = file.getAbsolutePath();
            try {
                result = Tradutor.getInstance().getResultList(SftOutputInco.class, filename);
                new Thread(new UpGradeInconsistencia.upload()).start();
            } catch (IOException ex) {
                ErroMensagens.getInstancia().ErroMensagem("Arquivo com formato incompativel!");
            } catch (NullPointerException e) {
            }
        }
    }
    
    private boolean teste(String texto) {
        List<SftOutputInco> incos = dao.getIncoList(texto);
        if (incos.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    /*
        OS columns[0]
        Unidade columns[0].split("-")[0]
        Atendente columns[3]
        Convenio columns[4]
        Não conformidade columns[5]
        Status columns[8]
        Data columns[7]
    */
    private class upload implements Runnable {

        @Override
        public void run() {
            list.clear();
            
            int codunid = 0;
            int i = 0;
            for (String[] columns : result) {
                jProgressBar.setValue((i * 100 / result.size()) + 1);
                
                i++;
                if (teste(columns[0])) {
                    //Novo
                    br.entidade.sft.SftOutputInco s = new br.entidade.sft.SftOutputInco();
                    s.setSftCtrlHistoricoList(
                            Logger.getInstance().incoRegistros("upload", columns[0], 
                                    new ArrayList<>(),s));
                    ErroMensagens.getInstancia().close();
                    
                    //OS
                    s.setIncoOsNumos(columns[0]);
                    //Unidade
                    try {
                        codunid = Integer.parseInt(columns[0].split("-")[0]);
                        SftInputUnid unid = boxUnid.get(codUnid.indexOf(codunid));
                        s.setFkUnid(unid);
                    } catch (ArrayIndexOutOfBoundsException a) {
                        ErroMensagens.getInstancia().Erros(columns[0], "Unidade", codunid + "");
                    }
                    //Convenio
                    try {
                        Convenio get = boxConv.get(codMascara.indexOf(columns[4]));
                        s.setFkConv(get);
                    } catch (ArrayIndexOutOfBoundsException a) {
                        ErroMensagens.getInstancia().Erros(columns[0], "Convenio", columns[4]);
                    }
                    //Atendente
                    try {
                        if (codunid == 10) {
                            columns[3] = "FATURAMENTO MERIDIONAL";
                        }
                        if (codunid == 26) {
                            columns[3] = "FATURAMENTO SANTA RITA";
                        }
                        SftInputAten fkAten;
                        fkAten = boxAten.get(codAten.indexOf(columns[3]));
                        s.setFkAten(fkAten);
                        
                    } catch (ArrayIndexOutOfBoundsException a) {
                        ErroMensagens.getInstancia().Erros(columns[0], "Atendente", columns[3]);
                    }
                    //status
                    try{
                        SftInputStat stat = boxStatus.get(codStatus.indexOf(columns[8]));
                        s.setFkStat(stat);
                    } catch (ArrayIndexOutOfBoundsException a) {
                        SftInputStat stat = boxStatus.get(codStatus.indexOf("OK"));
                        s.setFkStat(stat);
                    }
                    //Obs
                    s.setIncoObObsinco(columns[6]);
                    //Não conformidade
                    try {
                        SftInputNcon ncon = boxNcon.get(codNcon.indexOf(columns[5]));
                        s.setFkNcon(ncon);
                    } catch (ArrayIndexOutOfBoundsException a) {
                        ErroMensagens.getInstancia().Erros(columns[0], "Não Conformidade", columns[5]);
                    }
                    //Data
                    Date date = LeData.LeBrasil(columns[7],"/");
                    s.getSftCtrlHistoricoList().get(0).setHistDtRegis(date);
                    s.setIncoDtRegis(date);
                    //verifica se tem erro
                    if (!ErroMensagens.getInstancia().isErroEnable()) {
                        list.add(s);
                        dao.create(s);
                    }
                }
            }
            exportErro();
            mostraPesquisa();
        }
    }

    private void exportErro() {
        //metodo para exortar os Erros encontrados

        jProgressBar.setValue(0);
        if (ErroMensagens.getInstancia().getErros() != null) {
            ErroMensagens.getInstancia().ErroMensagem(ErroMensagens.getInstancia().getErros().size() + " Erros encontrados!");

            StringBuilder sb = new StringBuilder();
            List<String[]> toError = ErroMensagens.getInstancia().getErros();
            for (String[] toErro : toError) {
                sb.append(toErro[0])
                        .append("\t")
                        .append(toErro[1])
                        .append("\t")
                        .append(toErro[2])
                        .append("\n");
            }
            String conteudo = sb.toString();
            try (FileWriter excelFile = new FileWriter("C:\\MKT\\ERROS.xls")) {
                excelFile.write(conteudo);
            } catch (IOException ex) {
            }
        }
    }
}
