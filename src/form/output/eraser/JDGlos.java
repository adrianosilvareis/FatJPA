package form.output.eraser;

import br.entidade.sft.SftOutputGlos;
import entidade.controle.OutputGlosCtrl;
import entidade.controle.exceptions.NonexistentEntityException;
import form.output.JPGlosa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.table.DefaultTableModel;
import br.data.bancodedados.CriaConexao;
import superior.mensagens.ErroMensagens;

public final class JDGlos extends javax.swing.JDialog {

    public JDGlos(JPGlosa parent, boolean modal) {
        this.glos = parent;
        this.setModal(modal);
        initComponents();
        iniciarComponentes();
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        pesquisaButton = new javax.swing.JButton();
        shearFild = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        historicoButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/Delete.png"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        pesquisaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/search.png"))); // NOI18N
        pesquisaButton.setToolTipText("Pesquisa");
        pesquisaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaButtonActionPerformed(evt);
            }
        });

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/save.png"))); // NOI18N
        saveButton.setToolTipText("Salvar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        historicoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/historico.png"))); // NOI18N
        historicoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historicoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(historicoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pesquisaButton))
                    .addComponent(shearFild))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(deleteButton)
                        .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(pesquisaButton)
                    .addComponent(historicoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shearFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        masterTable.setModel(dtm);
        jScrollPane1.setViewportView(masterTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        try {
            int[] selected = masterTable.getSelectedRows();
            List<br.entidade.sft.SftOutputGlos> toRemove = new ArrayList<>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                br.entidade.sft.SftOutputGlos s = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                toRemove.add(s);
                try {
                    dao.destroy(s.getGlosIdIdglos());
                } catch (IllegalArgumentException | NonexistentEntityException e) {
                }
            }
            list.removeAll(toRemove);
            mostrarPesquisa();
        } catch (ConcurrentModificationException c) {
            list = glos.toRemove();
            mostrarPesquisa();
            System.out.println("Ao deletar: " + c);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void pesquisaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaButtonActionPerformed
        // TODO add your handling code here:
        pesquisa(shearFild.getText());
    }//GEN-LAST:event_pesquisaButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:admin   admin
        if (ErroMensagens.getInstancia().confirmMessenger("aperte 'SIM' para salvar as alterações! \n ou 'NÃO' para desistir.")) {
            try {
                list = dao.Save(list);
                mostrarPesquisa();
            } catch (ConcurrentModificationException c) {
                System.out.println(c);
            } catch (RollbackException r) {
                dao.getEntityManager().getTransaction().begin();
                System.out.println(r);
            }
        }else {
            list = glos.toRemove();
            mostrarPesquisa();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void historicoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historicoButtonActionPerformed
        // TODO add your handling code here:
        int[] selected = masterTable.getSelectedRows();
        List<br.entidade.sft.SftOutputGlos> toHist = new ArrayList<>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            br.entidade.sft.SftOutputGlos s = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toHist.add(s);
        }
        glos.setHist(toHist);
        glos.openHistorico();
    }//GEN-LAST:event_historicoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(JDGlos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDGlos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDGlos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDGlos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDGlos dialog = new JDGlos(glos, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton historicoButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton pesquisaButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField shearFild;
    // End of variables declaration//GEN-END:variables
    private OutputGlosCtrl dao;
    private List<SftOutputGlos> list;
    private DefaultTableModel dtm = new DefaultTableModel(null, new String[]{"OS", "Data","Atendente", "Unidade","Convênio", "Não Conformidade"});
    public static JPGlosa glos;
    
    public void iniciarComponentes() {
        dao = new OutputGlosCtrl(CriaConexao.getInstance().getEntityManager());
        dao.getEntityManager().getTransaction().begin();
        listarPesquisa();
    }

    public void listarPesquisa() {
        list = glos.toRemove();
        mostrarPesquisa();
    }

    public void mostrarPesquisa() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        if (list.isEmpty()) {
            ErroMensagens.getInstancia().AtencaoMensagem("Nenhum objeto encontrado!");
        } else {
            String[] linha = new String[]{null,null,null,null,null,null};
            int i = 0;
            for (SftOutputGlos l : list) {
                dtm.addRow(linha);
                dtm.setValueAt(l.getGlosOsNumos(), i, 0);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
                dtm.setValueAt(format.format(l.getGlosDtRegis()), i, 1);
                dtm.setValueAt(((l.getFkAten() != null) ? l.getFkAten().getAtenUsUsaten() : null), i, 2);
                dtm.setValueAt(((l.getFkUnid() != null) ? l.getFkUnid().getUnidNmNmunid() : null), i, 3);
                dtm.setValueAt(((l.getFkConv() != null) ? l.getFkConv().getCodigo()   : null), i, 4);
                dtm.setValueAt(((l.getFkNcon() != null) ? l.getFkNcon().getNconNmNmncon() : null), i, 5);
                i++;
            }
        }
    }
    
    public void pesquisa(String OS){
        list = dao.getGlosList("%" + OS + "%");
        mostrarPesquisa();
    }
}
