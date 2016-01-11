/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form.administrador;
 
import br.entidade.Acessos;
import br.entidade.GrupoUsuarios;
import br.entidade.business.Business;
import form.JFPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import superior.mensagens.ErroMensagens;

/**
 *
 * @author Adriano
 */
public class JIGrupoUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIGrupoUsuario
     */
    public JIGrupoUsuario() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPCorpo = new javax.swing.JPanel();
        jPInformacao = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTUsuario = new javax.swing.JTextField();
        jPPrivilegios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMasterDisponivel = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMasterDisponivel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lsm = jMasterDisponivel.getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    jTTabelaDisponivel(jMasterDisponivel);
                }
            }
        });
        jScrollPane2 = new javax.swing.JScrollPane();
        jMasterUsuario = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jMasterUsuario.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lsm = jMasterUsuario.getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    jTTabelaUsuario(jMasterUsuario);
                }
            }
        });
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
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

        jPCorpo.setBackground(new java.awt.Color(255, 255, 255));
        jPCorpo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPInformacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        jLabel3.setText("Grupo de Usuários:");

        jTUsuario.setEditable(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jTUsuario, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jTUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTUsuarioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPInformacaoLayout = new javax.swing.GroupLayout(jPInformacao);
        jPInformacao.setLayout(jPInformacaoLayout);
        jPInformacaoLayout.setHorizontalGroup(
            jPInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInformacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTUsuario)
                .addContainerGap())
        );
        jPInformacaoLayout.setVerticalGroup(
            jPInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInformacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPPrivilegios.setBorder(javax.swing.BorderFactory.createTitledBorder("Privilégios"));

        jMasterDisponivel.setModel(dtmDispo);
        jScrollPane1.setViewportView(jMasterDisponivel);

        jMasterUsuario.setModel(dtmUser);
        jScrollPane2.setViewportView(jMasterUsuario);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(">>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("<<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPPrivilegiosLayout = new javax.swing.GroupLayout(jPPrivilegios);
        jPPrivilegios.setLayout(jPPrivilegiosLayout);
        jPPrivilegiosLayout.setHorizontalGroup(
            jPPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrivilegiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPrivilegiosLayout.setVerticalGroup(
            jPPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPrivilegiosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPPrivilegiosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/exit.png"))); // NOI18N
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/new.png"))); // NOI18N
        newButton.setToolTipText("Novo");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/Delete.png"))); // NOI18N
        deleteButton.setToolTipText("Deletar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/refresh.png"))); // NOI18N
        refreshButton.setToolTipText("Atualizar");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/save.png"))); // NOI18N
        saveButton.setToolTipText("Salvar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCorpoLayout = new javax.swing.GroupLayout(jPCorpo);
        jPCorpo.setLayout(jPCorpoLayout);
        jPCorpoLayout.setHorizontalGroup(
            jPCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCorpoLayout.createSequentialGroup()
                        .addComponent(exitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton))
                    .addComponent(jPInformacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPPrivilegios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPCorpoLayout.setVerticalGroup(
            jPCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(refreshButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)
                    .addComponent(exitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        masterTable.setModel(dtm);
        jScrollTabela.setViewportView(masterTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        JFPrincipal.setGu(null);
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        GrupoUsuarios s = new GrupoUsuarios();
        dao.criar(s);
        list.add(s);
        mostraPesquisa();
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<GrupoUsuarios> toRemove = new ArrayList<>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            GrupoUsuarios s = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(s);
            
            dao.remover(s);
        }
        list.removeAll(toRemove);
        mostraPesquisa();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        listToSelect.clear();
        userList.clear();
        dao.refresh();
        list = dao.findAll(GrupoUsuarios.class);
        mostraPesquisa();
        masterDisponivel();
        masterUsuario();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            dao.salvar();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            dao.getEntityManager().getTransaction().begin();
            ErroMensagens.getInstancia().ErroMensagem("Houve um erro ao salver este lote \n tente novemente!");
            mostraPesquisa();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        toRight();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:.
        toLeft();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        toRightAll();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        toLeftAll();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTUsuarioKeyReleased
        // TODO add your handling code here:
        jTUsuario.setText(jTUsuario.getText().toUpperCase());
        list.get(masterTable.getSelectedRow()).setDescricao(jTUsuario.getText());
        masterTable.setValueAt(list.get(masterTable.getSelectedRow()).getDescricao(), masterTable.getSelectedRow(), 0);
    }//GEN-LAST:event_jTUsuarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTable jMasterDisponivel;
    private javax.swing.JTable jMasterUsuario;
    private javax.swing.JPanel jPCorpo;
    private javax.swing.JPanel jPInformacao;
    private javax.swing.JPanel jPPrivilegios;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollTabela;
    private javax.swing.JTextField jTUsuario;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private Business dao;
    private List<GrupoUsuarios> list;
    private List<Acessos> availableList;
    private List<Acessos> userList;
    private List<Acessos> listToSelect;
    private List<Acessos> transferencia;
    private final DefaultTableModel dtm = new DefaultTableModel(null, new String[]{"Grupo de Usuarios"});
    private final DefaultTableModel dtmDispo = new DefaultTableModel(null, new String[]{"Permissoes disponiveis"});
    private final DefaultTableModel dtmUser = new DefaultTableModel(null, new String[]{"Permissoes do usuario"});
    private ListSelectionModel lsm;
    
    public final void iniciarComponentes(){
        dao = new Business();
        dao.getEntityManager().getTransaction().begin();
        listarPesquisa();
    }
    
    private void listarPesquisa() {
        list = dao.findAll(GrupoUsuarios.class);
        availableList = dao.findAll(Acessos.class);
        mostraPesquisa();
    }
    
    private void mostraPesquisa() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        if (list.isEmpty()) {
            ErroMensagens.getInstancia().AtencaoMensagem("Nenhum resultado encontrado");
            //nenhum perfil cadastrado
        } else {
            String[] linha = new String[]{null};
            int i = 0;
            for (GrupoUsuarios gu : list) {
                dtm.addRow(linha);
                dtm.setValueAt(gu.getDescricao(), i, 0);
                i++;
            }
        }        
    }
    
    private void atualizaLista() {
        List<Acessos> removeList = new ArrayList<>();
        for (Acessos p : userList) {
            for (Acessos d : availableList) {
                if(p.hashCode() == d.hashCode()){
                    removeList.add(d);
                }
            }
        }
        listToSelect = new ArrayList<>(availableList);
        listToSelect.removeAll(removeList);
    }
    
    private void masterDisponivel() {
        while (dtmDispo.getRowCount() > 0) {
            dtmDispo.removeRow(0);
        }
        if (listToSelect.isEmpty()) {
            //nenhuma permissao no banco
        } else {
            String[] linha = new String[]{null};
            int i = 0;
            for (Acessos pe : listToSelect) {
                dtmDispo.addRow(linha);
                dtmDispo.setValueAt(pe.getDescricao(), i, 0);
                i++;
            }
        }
    }

    private void masterUsuario() {
        while (dtmUser.getRowCount() > 0) {
            dtmUser.removeRow(0);
        }
        if (userList.isEmpty()) {
            //nenhuma permissao para o usuario
        } else {
            String[] linha = new String[]{null};
            int i = 0;
            for (Acessos pe : userList) {
                dtmUser.addRow(linha);
                dtmUser.setValueAt(pe.getDescricao(), i, 0);
                i++;
            }
        }
    }
    
    public void jTTabelaLinhaSelecionada(JTable masterTable) {
        try {
            jTUsuario.setText(list.get(masterTable.getSelectedRow()).getDescricao());
            userList = list.get(masterTable.getSelectedRow()).getAcessosList();
            atualizaLista();
            masterDisponivel();
            masterUsuario();
        } catch (ArrayIndexOutOfBoundsException a) {
            jTUsuario.setText("");
        }
    }
    
    public void jTTabelaDisponivel(JTable jMasterDisponivel) {
        try {
            int[] selected = jMasterDisponivel.getSelectedRows();
            transferencia = new ArrayList<>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                Acessos s = listToSelect.get(jMasterDisponivel.convertRowIndexToModel(selected[idx]));
                transferencia.add(s);
            }
        } catch (ArrayIndexOutOfBoundsException a) {
        }
    }
    
    public void jTTabelaUsuario(JTable jMasterUsuario) {
        try {
            int[] selected = jMasterUsuario.getSelectedRows();
            transferencia = new ArrayList<>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                Acessos s = userList.get(jMasterUsuario.convertRowIndexToModel(selected[idx]));
                transferencia.add(s);
            }
        } catch (ArrayIndexOutOfBoundsException a) {
        }
    }

    private void toRight() {
        if (listToSelect.containsAll(transferencia)) {
            listToSelect.removeAll(transferencia);
            userList.addAll(transferencia);
            masterDisponivel();
            masterUsuario();
        }
    }
    
    private void toRightAll() {
        userList.addAll(listToSelect);
        listToSelect.clear();
        masterDisponivel();
        masterUsuario();
    }
    
    private void toLeft() {
        if (userList.containsAll(transferencia)) {
            userList.removeAll(transferencia);
            listToSelect.addAll(transferencia);
            masterDisponivel();
            masterUsuario();
        }
    }

    private void toLeftAll() {
        listToSelect.addAll(userList);
        userList.clear();
        masterDisponivel();
        masterUsuario();
    }

   

    
}
