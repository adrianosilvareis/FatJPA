package form.output;

import br.entidade.business.Business;
import br.entidade.sft.SftInputAten;
import br.entidade.sft.SftInputUnid;
import br.entidade.sft.SftOutputPart;
import static form.JFPrincipal.ativo;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import superior.entrada.Tradutor;
import superior.mensagens.ErroMensagens;
import superior.sessao.Logger;

public class JPParticular extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    public JPParticular() {
        initComponents();
        iniciarComponentes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numeroFild = new javax.swing.JTextField();
        descontosFild = new javax.swing.JTextField();
        debitoFild = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalFild = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        uploadBoton = new javax.swing.JButton();
        jScrollTabela = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jScrollTabela = new javax.swing.JScrollPane();
        masterTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lsm = masterTable.getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    jTTabelaLinhaSelecionada(masterTable);
                }
            }
        });
        jBarradeProgresso = new javax.swing.JProgressBar();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(972, 478));
        jPanel1.setMinimumSize(new java.awt.Dimension(972, 478));
        jPanel1.setName(""); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(798, 122));
        jPanel2.setName(""); // NOI18N

        jLabel1.setText("Numero OS");

        numeroFild.setEditable(false);
        numeroFild.setBackground(new java.awt.Color(255, 255, 255));
        numeroFild.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        descontosFild.setEditable(false);
        descontosFild.setBackground(new java.awt.Color(255, 255, 255));
        descontosFild.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        debitoFild.setEditable(false);
        debitoFild.setBackground(new java.awt.Color(255, 255, 255));
        debitoFild.setForeground(new java.awt.Color(204, 0, 0));
        debitoFild.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Soma Descontos");

        jLabel3.setText("Soma Debito");

        totalFild.setEditable(false);
        totalFild.setBackground(new java.awt.Color(255, 255, 255));
        totalFild.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Soma Total");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(numeroFild, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(descontosFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(debitoFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(totalFild, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(374, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {debitoFild, descontosFild, numeroFild, totalFild});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descontosFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(debitoFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/new.png"))); // NOI18N
        newButton.setToolTipText("Novo");
        newButton.setDisabledIcon(null);
        newButton.setEnabled(false);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/Delete.png"))); // NOI18N
        deleteButton.setToolTipText(" Deletar Tudo");
        deleteButton.setDisabledIcon(null);
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/refresh.png"))); // NOI18N
        refreshButton.setToolTipText("Atualizar");
        refreshButton.setDisabledIcon(null);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/save.png"))); // NOI18N
        saveButton.setToolTipText("Salvar");
        saveButton.setDisabledIcon(null);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        uploadBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/upload.png"))); // NOI18N
        uploadBoton.setToolTipText("Upload");
        uploadBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uploadBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uploadBoton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(refreshButton)
                        .addComponent(deleteButton)
                        .addComponent(newButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        uploadBoton.setEnabled(ativo("UpIn"));

        masterTable.setModel(dtm);
        jScrollTabela.setViewportView(masterTable);

        jBarradeProgresso.setBackground(new java.awt.Color(255, 255, 255));
        jBarradeProgresso.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollTabela)
                    .addComponent(jBarradeProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBarradeProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        dao.refresh();
        list = dao.findAll(SftOutputPart.class);
        mostraPesquisa();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            dao.salvar();
        } catch (RollbackException rex) {
            System.out.println(rex);
            dao.getEntityManager().getTransaction().begin();
            ErroMensagens.getInstancia().ErroMensagem("Houve um erro ao salvar este lote, \n tente novamente!");
        }
        mostraPesquisa();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void uploadBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBotonActionPerformed
        limparTabela();
        upload();

    }//GEN-LAST:event_uploadBotonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        limparTabela();
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField debitoFild;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descontosFild;
    private javax.swing.JProgressBar jBarradeProgresso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollTabela;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField numeroFild;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField totalFild;
    private javax.swing.JButton uploadBoton;
    // End of variables declaration//GEN-END:variables
    private List<SftOutputPart> list;
    private List<String[]> text;
    private List<SftInputUnid> boxUnid;
    private List<SftInputAten> boxAten;
    private List<Integer> codUnid;
    private List<String> codAten;
    private Business dao;
    //Data	Código OS	Paciente	VL.Total	
    //% Desc	VL. Líquido	VL. Pago	VL.Debito	 Autorizado por

    DefaultTableModel dtm = new DefaultTableModel(null, new String[]{
        "Data", "Codigo OS", "Posto", "Paciente", "Vl Total", "Desconto", "Desc %", 
        "Vl Liquido","Vl Pago", "Vl Debito", "Autorizado por", "Usuario"});
    private ListSelectionModel lsm;

    private void iniciarComponentes() {
        dao = new Business();
        dao.getEntityManager().getTransaction().begin();
        listarPesquisa();
        listarCod();
    }

    private void listarPesquisa() {
        list = dao.findAll(SftOutputPart.class);
        boxUnid = dao.findAll(SftInputUnid.class);
        boxAten = dao.findAll(SftInputAten.class);
        mostraPesquisa();
    }

    public void pesquisa(String os) {
        list = dao.getEntityManager().createNamedQuery("SftOutputPart.findByPartOsOspart", SftOutputPart.class)
                .setParameter("partOsOspart", os).getResultList();
        mostraPesquisa();
    }

    private void listarCod() {
        codUnid = new ArrayList<>();
        for (SftInputUnid u : boxUnid) {
            codUnid.add(u.getUnidCodCodigo());
        }
        codAten = new ArrayList<>();
        for (SftInputAten a : boxAten) {
            try {
                int cod = Integer.parseInt(a.getAtenUsUsaten().replace("USER", ""));
                codAten.add(String.valueOf(cod));
            } catch (NumberFormatException n) {
                codAten.add(a.getAtenUsUsaten());
            }
        }
    }

    //Data	Código OS	Paciente	VL.Total	 Desc
    //% Desc	VL. Líquido	VL. Pago	VL.Debito	 Autorizado por
    private void mostraPesquisa() {
        somatoria(list);
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        if (list.isEmpty()) {
            //ErroMensagens.getInstancia().InformacaoMensagem("Nenhum Resultado!");
        } else {
            String[] linha = new String[]{null, null, null, null, null, null, null, null, null, null, null, null};
            int i = 0;
            for (SftOutputPart l : list) {
                try {
                    dtm.addRow(linha);
                    Double calc = (l.getPartVlDesc()*l.getPartVlTotal())/100;
                    dtm.setValueAt(l.getPartDataRegist(), i, 0);
                    dtm.setValueAt(l.getPartOsOspart(), i, 1);
                    dtm.setValueAt(((l.getFkUnid() != null)
                            ? l.getFkUnid().getUnidNmNmunid() : null), i, 2);//se unidade for diferente de nulo
                    dtm.setValueAt(l.getPartNmPaciente(), i, 3);
                    dtm.setValueAt(l.getPartVlTotal(), i, 4);
                    dtm.setValueAt(calc, i, 5);
                    dtm.setValueAt(l.getPartVlDesc() + " %", i, 6);
                    dtm.setValueAt(l.getPartVlLiquido(), i, 7);
                    dtm.setValueAt(l.getPartVlPago(), i, 8);
                    dtm.setValueAt(l.getPartVlDebito(), i, 9);
                    dtm.setValueAt(((l.getFkAten() != null)
                            ? l.getFkAten().getAtenNmNmaten() : null), i, 10);//se atendente for diferente de nulo
                    dtm.setValueAt(((l.getSftCtrlHistoricoList().get(0) != null)
                            ? l.getSftCtrlHistoricoList().get(0).getUsuariosId().getLogin() : null), i, 11);//se historico diferente de nulo
                    i++;
                } catch (NullPointerException | ArrayStoreException a) {
                    ErroMensagens.getInstancia().ErroMensagem("Erro na visualização");
                }
            }
        }
    }

    public void jTTabelaLinhaSelecionada(JTable masterTable) {
        if(masterTable.getSelectedRow() != -1) {
            int[] selected = masterTable.getSelectedRows();
            List<br.entidade.sft.SftOutputPart> toView = new ArrayList<>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                br.entidade.sft.SftOutputPart s = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                toView.add(s);
            }
            somatoria(toView);
        } else {
            somatoria(list);
        }
    }
    
    public void somatoria(List<SftOutputPart> list){
        double descontos = 0;
        double debitos = 0;
        double total = 0;
        double tpCent = 0;
        for (SftOutputPart l : list) {
            tpCent = l.getPartVlDesc()*l.getPartVlTotal()/100;
            total = total + l.getPartVlTotal();
            descontos = descontos + tpCent;
            debitos = debitos + l.getPartVlDebito();
        }
        DecimalFormat df = new DecimalFormat("#.00");
        numeroFild.setText(String.valueOf(list.size()));
        descontosFild.setText(String.valueOf(df.format(descontos)));
        debitoFild.setText(String.valueOf(df.format(debitos)));
        totalFild.setText(String.valueOf(df.format(total)));
        
    } 
    
    private void upload() throws HeadlessException {
        // TODO add your handling code here:
        JFileChooser choose = new JFileChooser();
        choose.showOpenDialog(null);
        File file = choose.getSelectedFile();
        if (choose.getSelectedFile() != null) {
            String filename = file.getAbsolutePath();
            try {
                text = Tradutor.getInstance().getResultList(SftOutputPart.class, filename);
                new Thread(new JPParticular.upload()).start();
            } catch (IOException ex) {
                ErroMensagens.getInstancia().ErroMensagem("Arquivo com formato incompativel!");
                System.out.println("Erro IOException " + ex);
            } catch (NullPointerException e) {
            }
        }
    }

        
    private void limparTabela() {
        for (SftOutputPart l : list) {
            dao.remover(l);
        }
        list.clear();
        if(ErroMensagens.getInstancia().getErros() != null){
            ErroMensagens.getInstancia().ErrosClear();
            ErroMensagens.getInstancia().close();
        }
    }

    public Double toDouble(String num) {
        String mp = num.replace(".", "");
        String real = mp.replace(",", ".");
        try{
           return Double.parseDouble(real);
        }catch(NumberFormatException e){
            ErroMensagens.getInstancia().ErroMensagem(num + " Não pode ser convertido em Double!");
        }
        return 0.0;
    }
    /*
        Data columns[0]
        OS columns[1]
        Unidade columns[1].split("-")[0]
        Paciente columns[2]
        Vl Total columns[3]
        Vl Descontos columns[4]
        Vl Liquido columns[5]
        Vl Pago columns[6]
        Vl Debito columns[7]
        Atendente columns[8]
    */
    private class upload implements Runnable {

        @Override
        public void run() {
            list.clear();
            int codunid = 0;
            int i = 0;
            for (String[] columns : text) {
                jBarradeProgresso.setValue((i * 100 / text.size()) + 1);
                i++;
                //Novo
                br.entidade.sft.SftOutputPart s = new br.entidade.sft.SftOutputPart();
                s.setSftCtrlHistoricoList(Logger.getInstance().partRegistros("upload", columns[1], s));
                ErroMensagens.getInstancia().close();
                //Data
                s.setPartDataRegist(columns[0]);
                //OS
                s.setPartOsOspart(columns[1]);
                //Unidade
                try {
                    codunid = Integer.parseInt(columns[1].split("-")[0]);
                    SftInputUnid unid = boxUnid.get(codUnid.indexOf(codunid));
                    s.setFkUnid(unid);
                } catch (ArrayIndexOutOfBoundsException a) {
                    ErroMensagens.getInstancia().Erros(columns[1], "Unidade", codunid + "");
                }
                //Paciente 
                s.setPartNmPaciente(columns[2]);
                //Vl Total
                s.setPartVlTotal(toDouble(columns[3]));
                //%Desconto
                s.setPartVlDesc(toDouble(columns[4]));
                //vl Liquido
                s.setPartVlLiquido(toDouble(columns[5]));
                //vl Pago
                s.setPartVlPago(toDouble(columns[6]));
                //vl Debito
                s.setPartVlDebito(toDouble(columns[7]));
                
                //Atendente Autorizador
                try {
                    if (codunid == 10) {
                        columns[8] = "FATURAMENTO MERIDIONAL";
                    }
                    if (codunid == 26) {
                        columns[8] = "FATURAMENTO SANTA RITA";
                    }
                    SftInputAten fkAten;
                    try {
                        String replace = columns[8].replace("*", "&");
                        
                        int pint = Integer.parseInt(replace.split("&")[0]);
                        
                        fkAten = boxAten.get(codAten.indexOf(String.valueOf(pint)));
                        
                    } catch (NumberFormatException n) {
                        fkAten = boxAten.get(codAten.indexOf(columns[8]));
                    }
                    s.setFkAten(fkAten);
                } catch (ArrayIndexOutOfBoundsException a) {
                    ErroMensagens.getInstancia().Erros(columns[1], "Atendente", columns[8]);
                }
                if (!ErroMensagens.getInstancia().isErroEnable()) {
                    list.add(s);
                    dao.criar(s);
                }
            }
            exportErro();
            mostraPesquisa();
        }
    }

    private void exportErro() {
        //metodo para exortar os Erros encontrados
        jBarradeProgresso.setValue(0);
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
