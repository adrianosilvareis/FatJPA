package form.output;

import br.entidade.Convenio;
import br.entidade.MascaraConvenio;
import br.entidade.business.Business;
import br.entidade.sft.SftCtrlHistorico;
import br.entidade.sft.SftInputAten;
import br.entidade.sft.SftInputNcon;
import br.entidade.sft.SftInputStat;
import br.entidade.sft.SftInputUnid;
import br.entidade.sft.SftOutputInco;
import entidade.controle.OutputIncoCtrl;
import static form.JFPrincipal.ativo;
import form.output.historico.JDIncoHist;
import form.util.Documents;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import br.data.bancodedados.CriaConexao;
import form.output.dialog.JDInconsistencia;
import form.output.eraser.JDInco;
import form.util.TableModel;
import superior.entrada.Tradutor;
import superior.mensagens.ErroMensagens;
import superior.sessao.Logger;

/**admin
 *
 * @author Adriano
 */
public class JPInconsistencia extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form JPInconsistencia
     */
    public JPInconsistencia() {
        initComponents();
        iniciarComponentes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        obsFild = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        statusCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        osFild = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        atenFild = new javax.swing.JTextField();
        convFild = new javax.swing.JTextField();
        nConCombo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        uploadBoton = new javax.swing.JButton();
        numeroLabel = new javax.swing.JLabel();
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

        setMaximumSize(new java.awt.Dimension(970, 468));
        setMinimumSize(new java.awt.Dimension(970, 468));
        setPreferredSize(new java.awt.Dimension(970, 468));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(970, 478));
        jPanel1.setMinimumSize(new java.awt.Dimension(970, 478));
        jPanel1.setPreferredSize(new java.awt.Dimension(970, 478));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(798, 122));
        jPanel2.setName(""); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), obsFild, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        obsFild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                obsFildKeyReleased(evt);
            }
        });

        jLabel6.setText("Observação");

        jLabel7.setText("Situação");

        statusCombo.setMinimumSize(new java.awt.Dimension(169, 25));
        statusCombo.setNextFocusableComponent(saveButton);
        statusCombo.setPreferredSize(new java.awt.Dimension(169, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), statusCombo, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        statusCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                statusComboFocusLost(evt);
            }
        });
        statusCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboActionPerformed(evt);
            }
        });
        statusCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                statusComboKeyPressed(evt);
            }
        });

        jLabel4.setText("Convenio");

        jLabel3.setText("Não Conformidade");

        jLabel1.setText("Atendente");

        osFild.setDocument(Documents.getDocuments().DigitaOS());
        osFild.setMinimumSize(new java.awt.Dimension(129, 25));
        osFild.setName(""); // NOI18N
        osFild.setNextFocusableComponent(osFild);
        osFild.setPreferredSize(new java.awt.Dimension(129, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), osFild, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        osFild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                osFildKeyReleased(evt);
            }
        });

        jLabel5.setText("OS");

        atenFild.setMinimumSize(new java.awt.Dimension(170, 25));
        atenFild.setNextFocusableComponent(atenFild);
        atenFild.setPreferredSize(new java.awt.Dimension(170, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), atenFild, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        atenFild.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                atenFildFocusGained(evt);
            }
        });
        atenFild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                atenFildKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                atenFildKeyReleased(evt);
            }
        });

        convFild.setMinimumSize(new java.awt.Dimension(170, 25));
        convFild.setNextFocusableComponent(convFild);
        convFild.setPreferredSize(new java.awt.Dimension(170, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), convFild, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        convFild.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                convFildFocusGained(evt);
            }
        });
        convFild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                convFildKeyPressed(evt);
            }
        });

        nConCombo.setModel(new DefaultComboBoxModel());
        nConCombo.setMinimumSize(new java.awt.Dimension(246, 25));
        nConCombo.setPreferredSize(new java.awt.Dimension(246, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), nConCombo, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        nConCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nConComboActionPerformed(evt);
            }
        });
        nConCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nConComboKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(obsFild, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(osFild, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(atenFild, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(convFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nConCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(80, 80, 80))))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {convFild, osFild});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(osFild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(atenFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(convFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(nConCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obsFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {atenFild, convFild, obsFild, osFild, statusCombo});

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/new.png"))); // NOI18N
        newButton.setToolTipText("Novo");
        newButton.setDisabledIcon(null);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        infoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/Info.png"))); // NOI18N
        infoButton.setToolTipText("Informação");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), infoButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
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
        uploadBoton.setEnabled(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoButton)
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numeroLabel)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton)
                            .addComponent(refreshButton)
                            .addComponent(infoButton)
                            .addComponent(newButton))
                        .addComponent(uploadBoton)))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollTabela)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBarradeProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        novo();
        statusCombo.setSelectedIndex(0);
        nConCombo.setSelectedIndex(0);
    }//GEN-LAST:event_newButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        
        openDielog();
        list = dao.refresh(list);
        mostraPesquisa();

    }//GEN-LAST:event_infoButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        list = dao.refresh(list);
        mostraPesquisa();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            list = dao.Save(list);
        } catch (RollbackException rex) {
            System.out.println(rex);
            dao.getEntityManager().getTransaction().begin();
            ErroMensagens.getInstancia().ErroMensagem("Houve um erro ao salvar este lote, \n tente novamente!");
        }
        mostraPesquisa();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void osFildKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_osFildKeyReleased
        // TODO add your handling code here:
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            ErroMensagens.getInstancia().close();
            modelaOS();
            if (ErroMensagens.getInstancia().isErroEnable()) {
                ErroMensagens.getInstancia().AtencaoMensagem("OS invalida");
                osFild.setText("");
                ErroMensagens.getInstancia().close();
            } else {
                if(!osFild.getText().isEmpty())
                    atenFild.requestFocus();
            }
        }
    }//GEN-LAST:event_osFildKeyReleased

    private void nConComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nConComboKeyPressed
        // TODO add your handling code here:
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            obsFild.requestFocus();
        }
    }//GEN-LAST:event_nConComboKeyPressed

    private void atenFildKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atenFildKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_atenFildKeyReleased

    private void atenFildKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atenFildKeyPressed
        // TODO add your handling code here:
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            atenCod(atenFild.getText().replace("USER", ""));
            if (ErroMensagens.getInstancia().isErroEnable()) {
                ErroMensagens.getInstancia().AtencaoMensagem("Atendente não encontrado");
                atenFild.setText("");
                ErroMensagens.getInstancia().close();
            } else {
                convFild.requestFocus();
            }
        }
    }//GEN-LAST:event_atenFildKeyPressed

    private void atenFildFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_atenFildFocusGained
        // TODO add your handling code here:
        atendente = true;
    }//GEN-LAST:event_atenFildFocusGained

    private void convFildFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_convFildFocusGained
        // TODO add your handling code here:
        convenio = true;
    }//GEN-LAST:event_convFildFocusGained

    private void convFildKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_convFildKeyPressed
        // TODO add your handling code here:
        convFild.setText(convFild.getText().toUpperCase());
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            convCod(convFild.getText());
            if (ErroMensagens.getInstancia().isErroEnable()) {
                ErroMensagens.getInstancia().AtencaoMensagem("Convenio não encontrado");
                convFild.setText("");
                ErroMensagens.getInstancia().close();
            } else {
                nConCombo.requestFocus();
            }
        }
    }//GEN-LAST:event_convFildKeyPressed

    private void nConComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nConComboActionPerformed
        try {
            nCombo(nConCombo.getSelectedItem().toString());
        } catch (NullPointerException e) {
            nCombo("");
        }
    }//GEN-LAST:event_nConComboActionPerformed

    private void statusComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboActionPerformed
        // TODO add your handling code here:
        status();
    }//GEN-LAST:event_statusComboActionPerformed

    private void statusComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_statusComboFocusLost
        // TODO add your handling code here:
        status();
    }//GEN-LAST:event_statusComboFocusLost

    private void statusComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_statusComboKeyPressed
        // TODO add your handling code here:
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            saveButton.requestFocus();
        }
    }//GEN-LAST:event_statusComboKeyPressed

    private void uploadBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBotonActionPerformed

        if (nConCombo.getSelectedItem() != null) {
            upload();
        } else {
            ErroMensagens.getInstancia().AtencaoMensagem("A inconsistencia deve ser selecionada!");
        }

    }//GEN-LAST:event_uploadBotonActionPerformed

    private void obsFildKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_obsFildKeyReleased
        // TODO add your handling code here:
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            obs(obsFild.getText());
            statusCombo.requestFocus();
        }
    }//GEN-LAST:event_obsFildKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField atenFild;
    private javax.swing.JTextField convFild;
    private javax.swing.JButton infoButton;
    private javax.swing.JProgressBar jBarradeProgresso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollTabela;
    private javax.swing.JTable masterTable;
    private javax.swing.JComboBox nConCombo;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JTextField obsFild;
    private javax.swing.JTextField osFild;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox statusCombo;
    private javax.swing.JButton uploadBoton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private EntityManager emf;
    private List<SftOutputInco> list;
    private List<SftOutputInco> listHist;
    private List<String[]> result;
    private List<SftInputUnid> boxUnid;
    private List<MascaraConvenio> boxConv;
    private List<SftInputNcon> boxNcon;
    private List<SftInputAten> boxAten;
    private List<SftInputStat> boxStatus;
    private List<Convenio> mascara;
    private List<String> codAten;
    private List<Integer> codUnid;
    private List<String> codMascara;
    private OutputIncoCtrl dao;
    public static JDInco info;
    public static JDInconsistencia multUnid;
    public static JDIncoHist hist;
    private boolean atendente;
    private boolean convenio;
    private TableModel dtm = new TableModel();
    private SftInputUnid unidade;
    
    private ListSelectionModel lsm;
    //Fim da Criacao de variaveiz

    //Construtor
    private void iniciarComponentes() {
        emf = CriaConexao.getInstance().getEntityManager();
        dao = new OutputIncoCtrl(emf);
        dao.getEntityManager().getTransaction().begin();//inicia a transação
        listarPesquisa();
        listarBox();
    }

    //Realiza buscas para combos e inconsistencia
    private void listarPesquisa() {
        list = dao.getIncoMonth();
        boxUnid = new Business().findAll(SftInputUnid.class);
        boxAten = new Business().findAll(SftInputAten.class);
        boxConv = new Business().findAll(MascaraConvenio.class);
        boxNcon = new Business().findAll(SftInputNcon.class);
        boxStatus = new Business().findAll(SftInputStat.class);
        mascara = new Business().findAll(Convenio.class);
        mostraPesquisa();
    }

    //Pesquisa Por os
    public void pesquisa(String os) {
        list = dao.getIncoList(os);
        mostraPesquisa();
    }

    //Preenche os combobox com os objetos respectivos
    //Inicio Exibição
    @SuppressWarnings("unchecked")
    private void listarBox() {

        codAten = new ArrayList<>();
        for (SftInputAten sftAten : boxAten) {
            codAten.add(sftAten.getAtenUsUsaten().replace("USER", ""));
        }

        codUnid = new ArrayList<>();
        for (SftInputUnid sftUnid : boxUnid) {
            codUnid.add(sftUnid.getUnidCodCodigo());
        }

        nConCombo.removeAllItems();
        nConCombo.addItem(null);
        List<SftInputNcon> removeNcon = new ArrayList<>();
        for (SftInputNcon sftNcon : boxNcon) {
            if (sftNcon.getNconNmNmncon().contains("ZZ ")) {
                removeNcon.add(sftNcon);
            } else {
                nConCombo.addItem(sftNcon.getNconNmNmncon());
            }
        }
        boxNcon.removeAll(removeNcon);

        statusCombo.removeAllItems();
        statusCombo.addItem(null);
        List<SftInputStat> removeStatus = new ArrayList<>();
        for (SftInputStat sftStatus : boxStatus) {
            if (sftStatus.getStatusNmDescricao().contains("ZZ ")) {
                removeStatus.add(sftStatus);
            } else {
                statusCombo.addItem(sftStatus.getStatusNmDescricao());
            }
        }

        codMascara = new ArrayList<>();
        for (Convenio sftConvenios : mascara) {
            codMascara.add(String.valueOf(sftConvenios.getCodigo()));
        }
    }

    /*
     "Usuario", "Data", "Numero OS", "Unidade", "Atendente", 
     "Convenio", "Não Conformidade", "Observação", "Status"}
     */
    public void mostraPesquisa() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        if (list.isEmpty()) {
            //ErroMensagens.getInstancia().InformacaoMensagem("Nenhum resultado encontrado");
            numeroLabel.setText("Nenhum resultado encontrado!");
        } else {
            numeroLabel.setText(String.valueOf(list.size()));
            for (SftOutputInco sftInco : list) {
                dtm.addRow(sftInco);
            }
        }
    }

    public void jTTabelaLinhaSelecionada(JTable masterTable) {
        try {
            osFild.setText(list.get(masterTable.getSelectedRow()).getIncoOsNumos());
            obsFild.setText(list.get(masterTable.getSelectedRow()).getIncoObObsinco());
            statusCombo.setSelectedItem(list.get(masterTable.getSelectedRow()).getFkStat().getStatusNmDescricao());
            atenFild.setText(list.get(masterTable.getSelectedRow()).getFkAten().getAtenNmNmaten());
            convFild.setText(list.get(masterTable.getSelectedRow()).getFkConv().getMascaraConvenioId().getDescricao());
            nConCombo.setSelectedItem(list.get(masterTable.getSelectedRow()).getFkNcon().getNconNmNmncon());

        } catch (ArrayIndexOutOfBoundsException a) {
            osFild.setText("");
            atenFild.setText("");
            convFild.setText("");
            nConCombo.setSelectedItem(null);
            obsFild.setText("");
            statusCombo.setSelectedItem("");
        } catch (NullPointerException n) {
        }
    }
    //Fim Exibição

    //Inicio JDealog
    public void openDielog() {
        info = new JDInco(this, true);
        info.setVisible(true);
    }

    public void openHistorico() {
        hist = new JDIncoHist(this, true);
        hist.setVisible(true);
    }

    public void setBoxUnid(List<SftInputUnid> boxUnid) {
        this.boxUnid = boxUnid;
    }
    
    public List<SftOutputInco> toRemove() {
        int[] selected = masterTable.getSelectedRows();
        List<br.entidade.sft.SftOutputInco> toRemove = new ArrayList<>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            br.entidade.sft.SftOutputInco s = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(s);
        }
        return toRemove;
    }

    public void setHist(List<SftOutputInco> list) {
        this.listHist = list;
    }

    public List<SftOutputInco> getHist() {
        return listHist;
    }
    //Fim JDialog

    //Novo Cadastro 
    //Edição inicio
    private void novo() {
        br.entidade.sft.SftOutputInco s = new br.entidade.sft.SftOutputInco();
        List<SftCtrlHistorico> registros = Logger.getInstance()
                .incoRegistros("cadastro", "nova inconsistencia",
                        new ArrayList<>(), s);
        EntityManager em = dao.getEntityManager();
        for (SftCtrlHistorico r : registros) {
            em.persist(r);
        }
        s.setSftCtrlHistoricoList(registros);
        s.setIncoDtRegis(s.getSftCtrlHistoricoList().get(0).getHistDtRegis());
        dao.create(s);
        list.add(s);
        mostraPesquisa();
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }

    //Alteração OS
    private void modelaOS() throws NumberFormatException {
        // TODO add your handling code here:
        try {
            //Modela texto recebido de osFild
            StringBuilder sb = new StringBuilder(osFild.getText().replace("-", ""));
            sb.insert(3, "-");
            sb.insert(9, "-");
            String texto = sb.toString();
            osFild.setText(texto);
            adicionaOS(texto);

        } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException s) {
            if (!"".equals(osFild.getText())) {
                ErroMensagens.getInstancia().Errado();
                osFild.setText("");
                osFild.requestFocus();
            }
        }
    }

    private void adicionaOS(String texto) throws NumberFormatException {
        //adiciona na lista e no tabela a OS encotrada
        if (teste(texto)) {
            SftOutputInco get = list.get(masterTable.getSelectedRow());
            get.setIncoOsNumos(texto);
            dtm.setValueAt(osFild.getText(), masterTable.getSelectedRow(), 2);
            int unid = Integer.parseInt(texto.split("-")[0]);
            int cod = codUnid.indexOf(unid);
            get.setSftCtrlHistoricoList(
                    Logger.getInstance().incoRegistros("adiciona", texto, get.getSftCtrlHistoricoList(),
                            get));
            //Adiciona na lista e na tabela a unidade encontrada
            setUnidade(boxUnid.get(cod));
            if(!boxUnid.get(cod).isUnidMtMultiplo()){
                get.setFkUnid(getUnidade());
            }else{
                mostraMultUnid();
            }
            dtm.setValueAt(getUnidade(), masterTable.getSelectedRow(), 3);
            //adiciona user de Hospitais
            if (unid == 10) {
                atendente = true;
                atenCod("MERID");
            }
            if (unid == 26) {
                atendente = true;
                atenCod("SRITA");
            }
        } else {
            osFild.setText("");
            ErroMensagens.getInstancia().AtencaoMensagem("OS já cadastrada!");
        }
    }

    public SftInputUnid getUnidade() {
        return unidade;
    }

    public void setUnidade(SftInputUnid unidade) {
        this.unidade = unidade;
    }
    
    public List<SftInputUnid> getBoxUnid() {
        return boxUnid;
    }
    
    private void mostraMultUnid() {
        multUnid = new JDInconsistencia(this, true);
        multUnid.setVisible(true);
    }

    //Teste se OS já existe
    private boolean teste(String texto) {

        List<SftOutputInco> incos = dao.getIncoList(texto);
        for (SftOutputInco inco : incos) {
            System.out.println(inco.getIncoOsNumos());
        }
        return incos.isEmpty();
    }

    //Fim alteracao OS
    //Alteração Atendente
    private void atenCod(String user) {
        int cod;
        if (atendente) {
            try {
                Integer.parseInt(user);
                cod = codAten.indexOf(user);
                if (cod != -1) {
                    atenEncontrado(cod);
                } else {
                    ErroMensagens.getInstancia().Errado();
                    atenFild.setText("");
                }
            } catch (NumberFormatException n) {
                if (user.contains("MERID")) {
                    user = "FATURAMENTO MERIDIONAL";
                }
                if (user.contains("SRITA")) {
                    user = "FATURAMENTO SANTA RITA";
                }
                cod = codAten.indexOf(user);
                if (cod != -1) {
                    atenEncontrado(cod);
                }
                if (atendente) {
                    if (!atenFild.getText().isEmpty()) {
                        for (int i = 0; i < boxAten.size(); i++) {
                            if (boxAten.get(i).getAtenNmNmaten().contains(atenFild.getText())) {
                                atenEncontrado(i);
                                return;
                            }
                        }
                        ErroMensagens.getInstancia().Errado();
                        atenFild.setText("");
                    }
                }
            }
        }
    }

    private void atenEncontrado(int cod) {
        SftOutputInco s = list.get(masterTable.getSelectedRow());
        SftInputAten get = boxAten.get(cod);
        atenFild.setText(get.getAtenNmNmaten());
        list.get(masterTable.getSelectedRow()).setFkAten(get);
        s.setSftCtrlHistoricoList(
                Logger.getInstance().incoRegistros("atendente", get.getAtenNmNmaten(),
                        s.getSftCtrlHistoricoList(), s));
        dtm.setValueAt(get, masterTable.getSelectedRow(), 4);
        atendente = false;
    }
    //Fim atendente

    //incio Convenio
    private void convCod(String conv) {
        // TODO add your handling code here:
        if (convenio) {
            try {
                Integer.parseInt(conv);
                int cod = codMascara.indexOf(conv);
                if (cod != -1) {
                    convEncontrado(cod);
                } else {
                    ErroMensagens.getInstancia().Errado();
                    convFild.setText("");
                }
            } catch (NumberFormatException e) {
                if (!convFild.getText().isEmpty()) {
                    if (convenio) {
                        for (int i = 0; i < boxConv.size(); i++) {
                            if (mascara.get(i).getMascaraConvenioId().getDescricao().contains(convFild.getText())) {
                                convEncontrado(i);
                                return;
                            }
                        }
                        ErroMensagens.getInstancia().Errado();
                        convFild.setText("");
                    }
                }
            }
        }
    }

    private void convEncontrado(int cod) {
        SftOutputInco s = list.get(masterTable.getSelectedRow());
        Convenio get = mascara.get(cod);
        convFild.setText(get.getMascaraConvenioId().getDescricao());
        list.get(masterTable.getSelectedRow()).setFkConv(get);
        s.setSftCtrlHistoricoList(
                Logger.getInstance().incoRegistros("convenio", get.getDescricao(),
                        s.getSftCtrlHistoricoList(), s));
        dtm.setValueAt(get, masterTable.getSelectedRow(), 5);
        convenio = false;
    }

    //Fim convenio
    //inicio Status
    private void status() {
        // TODO add your handling code here:
        if (masterTable.getSelectedRow() != -1) {
            for (SftInputStat sftStatus : boxStatus) {
                if (statusCombo.getSelectedItem() != null && sftStatus.hashCode() == statusCombo.getSelectedItem().hashCode()) {
                    SftOutputInco s = list.get(masterTable.getSelectedRow());
                    s.setFkStat(sftStatus);
                    dtm.setValueAt(sftStatus, masterTable.getSelectedRow(), 8);
                    list.get(masterTable.getSelectedRow()).setSftCtrlHistoricoList(Logger.getInstance().incoRegistros("status", statusCombo.getSelectedItem().toString(),
                                    s.getSftCtrlHistoricoList(), s));
                }
            }
        }
    }

    private SftInputNcon nCombo(String nCon) {
        // TODO add your handling code here:
        if (masterTable.getSelectedRow() != -1) {
            if (nConCombo.getSelectedItem() != null) {
                for (SftInputNcon sftNcon : boxNcon) {
                    if (sftNcon.getNconNmNmncon().equals(nCon)) {
                        SftOutputInco s = list.get(masterTable.getSelectedRow());
                        s.setFkNcon(sftNcon);
                        dtm.setValueAt(sftNcon, masterTable.getSelectedRow(), 6);
                        s.setSftCtrlHistoricoList(
                                Logger.getInstance().incoRegistros("inconsistencia", sftNcon.getNconNmNmncon(),
                                        s.getSftCtrlHistoricoList(), s));
                        return sftNcon;
                    }
                }
            } else {
                dtm.setValueAt(null, masterTable.getSelectedRow(), 6);
            }
        }
        return null;
    }

    private void obs(String obs) {
        // TODO add your handling code here:
        SftOutputInco s = list.get(masterTable.getSelectedRow());
        s.setIncoObObsinco(obs);
        dtm.setValueAt(obs, masterTable.getSelectedRow(), 7);
        s.setSftCtrlHistoricoList(
                Logger.getInstance().incoRegistros("observacao", obs,
                        s.getSftCtrlHistoricoList(), s));
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
                new Thread(new upload()).start();
            } catch (IOException ex) {
                ErroMensagens.getInstancia().ErroMensagem("Arquivo com formato incompativel!");
            } catch (NullPointerException e) {
            }
        }
    }
    
    /*
     Não conformidade é selecionada ao iniciar o upload
     Unidade é tirada da OS columns[0].split("-")[0]
     OS columns[0]
     Convenio columns[1]
     Atendente columns[2]
     Status columns[3]
     Obs columns[4] + columns[5] 
     */
    private class upload implements Runnable {

        @Override
        public void run() {
            list.clear();
            //não conformidade
            SftInputNcon ncon = null;
            for (SftInputNcon sftNcon : boxNcon) {
                if (sftNcon.getNconNmNmncon().equals(nConCombo.getSelectedItem().toString())) {
                    ncon = sftNcon;
                    break;
                }
            }
            int codunid = 0;
            int i = 0;
            for (String[] columns : result) {
                jBarradeProgresso.setValue((i * 100 / result.size()) + 1);
                i++;
                if (teste(columns[0])) {
                    //Novo
                    br.entidade.sft.SftOutputInco s = new br.entidade.sft.SftOutputInco();
                    s.setSftCtrlHistoricoList(Logger.getInstance().incoRegistros("upload", columns[0], new ArrayList<>(), s));
                    s.setFkNcon(ncon);
                    s.setIncoDtRegis(s.getSftCtrlHistoricoList().get(0).getHistDtRegis());//data para exibição do mês
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
                        Convenio conv = mascara.get(codMascara.indexOf(columns[1]));
                        s.setFkConv(conv);
                    } catch (ArrayIndexOutOfBoundsException a) {
                        ErroMensagens.getInstancia().Erros(columns[0], "Convenio", columns[1]);
                    }
                    //Atendente
                    try {
                        if (codunid == 10) {
                            columns[2] = "FATURAMENTO MERIDIONAL";
                        }
                        if (codunid == 26) {
                            columns[2] = "FATURAMENTO SANTA RITA";
                        }
                        SftInputAten fkAten;
                        try {
                            int pint = Integer.parseInt(columns[2]);
                            if (pint < 100) {
                                fkAten = boxAten.get(codAten.indexOf("0" + pint));
                            } else {
                                fkAten = boxAten.get(codAten.indexOf("" + pint));
                            }
                        } catch (NumberFormatException n) {
                            fkAten = boxAten.get(codAten.indexOf(columns[2]));
                        }
                        s.setFkAten(fkAten);
                    } catch (ArrayIndexOutOfBoundsException a) {
                        ErroMensagens.getInstancia().Erros(columns[0], "Atendente", columns[2]);
                    }
                    //status
                    for (SftInputStat sftStatus : boxStatus) {
                        if (sftStatus.getStatusNmDescricao().equals(columns[3])) {
                            s.setFkStat(sftStatus);
                            break;
                        }
                    }
                    if (s.getFkStat() == null) {
                        ErroMensagens.getInstancia().Erros(columns[0], "Status", columns[3]);
                    }
                    //Obs
                    s.setIncoObObsinco(columns[4] + " " + columns[5]);

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
