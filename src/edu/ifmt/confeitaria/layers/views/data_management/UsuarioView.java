/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package edu.ifmt.confeitaria.layers.views.data_management;

import edu.ifmt.confeitaria.layers.controllers.data_management.UsuarioController;
import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.util.UtilMethods;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperView;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class UsuarioView extends SuperView {

    /**
     * Creates new form NewJFrame
     */
    private UsuarioView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditingUsuario = new javax.swing.JPanel();
        pnlFiltroUsuario = new javax.swing.JPanel();
        lblNomeFiltro = new javax.swing.JLabel();
        lblLoginFiltro = new javax.swing.JLabel();
        edtNomeFiltro = new javax.swing.JTextField();
        edtLoginFiltro = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnEnabledSenha = new javax.swing.JButton();
        lblSenha = new javax.swing.JLabel();
        edtLogin = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        pswdSenha = new javax.swing.JPasswordField();
        lblCodCliente = new javax.swing.JLabel();
        recordEditing = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        edtNome = new javax.swing.JFormattedTextField();
        edtCodCliente = new javax.swing.JFormattedTextField();
        lblCodUsuarioValidation = new javax.swing.JLabel();
        lblLoginValidation = new javax.swing.JLabel();
        editConfirmationWithRefresh = new javax.swing.JPanel();
        btnPost = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlEditingUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlFiltroUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFiltroUsuario.setName("pnlFiltroUsuario"); // NOI18N

        lblNomeFiltro.setText("Nome:");
        lblNomeFiltro.setName("lblNomeFiltro"); // NOI18N

        lblLoginFiltro.setText("Login:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Login", "Senha"
            }
        ));
        tblUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblUsuario.setGridColor(new java.awt.Color(204, 204, 204));
        tblUsuario.setShowGrid(true);
        jScrollPane1.setViewportView(tblUsuario);
        if (tblUsuario.getColumnModel().getColumnCount() > 0) {
            tblUsuario.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        javax.swing.GroupLayout pnlFiltroUsuarioLayout = new javax.swing.GroupLayout(pnlFiltroUsuario);
        pnlFiltroUsuario.setLayout(pnlFiltroUsuarioLayout);
        pnlFiltroUsuarioLayout.setHorizontalGroup(
            pnlFiltroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlFiltroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiltroUsuarioLayout.createSequentialGroup()
                        .addGroup(pnlFiltroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNomeFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoginFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFiltroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtLoginFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(edtNomeFiltro))
                        .addGap(41, 41, 41)
                        .addComponent(btnPesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlFiltroUsuarioLayout.setVerticalGroup(
            pnlFiltroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroUsuarioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlFiltroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtNomeFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeFiltro)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFiltroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtLoginFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoginFiltro))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEnabledSenha.setText("Habilitar/Desabilitar Senha");
        btnEnabledSenha.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnEnabledSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnabledSenhaActionPerformed(evt);
            }
        });

        lblSenha.setText("Senha:");

        lblLogin.setText("Login:");

        lblNome.setText("Nome:");
        lblNome.setName("lblNomeFiltro"); // NOI18N

        lblCodCliente.setText("Código:");

        recordEditing.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-add-30.png"))); // NOI18N
        btnInsert.setToolTipText("Inserir");
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-remove-30.png"))); // NOI18N
        btnDelete.setToolTipText("Deletar");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-edit-30.png"))); // NOI18N
        btnUpdate.setToolTipText("Editar");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout recordEditingLayout = new javax.swing.GroupLayout(recordEditing);
        recordEditing.setLayout(recordEditingLayout);
        recordEditingLayout.setHorizontalGroup(
            recordEditingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordEditingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        recordEditingLayout.setVerticalGroup(
            recordEditingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordEditingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recordEditingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnInsert))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        edtNome.setColumns(5);

        edtCodCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        lblCodUsuarioValidation.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblCodUsuarioValidation.setForeground(new java.awt.Color(204, 51, 0));
        lblCodUsuarioValidation.setText("Código já existente !!!");

        lblLoginValidation.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblLoginValidation.setForeground(new java.awt.Color(204, 51, 0));
        lblLoginValidation.setText("Login já existente !!!");

        javax.swing.GroupLayout pnlEditingUsuarioLayout = new javax.swing.GroupLayout(pnlEditingUsuario);
        pnlEditingUsuario.setLayout(pnlEditingUsuarioLayout);
        pnlEditingUsuarioLayout.setHorizontalGroup(
            pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFiltroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pswdSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoginValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(edtLogin)
                                .addComponent(edtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
                        .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCodUsuarioValidation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edtCodCliente)))
                            .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnEnabledSenha)))))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditingUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recordEditing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        pnlEditingUsuarioLayout.setVerticalGroup(
            pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlFiltroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(0, 0, 0)
                .addComponent(lblCodUsuarioValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin)
                    .addComponent(btnEnabledSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(lblLoginValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(pswdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(recordEditing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblCodUsuarioValidation.getAccessibleContext().setAccessibleName("");

        btnPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-accept-30.png"))); // NOI18N
        btnPost.setToolTipText("Salvar");
        btnPost.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-cancel-30.png"))); // NOI18N
        btnCancel.setToolTipText("Cancelar");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancel.setName(""); // NOI18N
        btnCancel.setRolloverEnabled(false);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-refresh-30.png"))); // NOI18N
        btnRefresh.setToolTipText("Atualizar");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefresh.setName(""); // NOI18N
        btnRefresh.setRolloverEnabled(false);

        javax.swing.GroupLayout editConfirmationWithRefreshLayout = new javax.swing.GroupLayout(editConfirmationWithRefresh);
        editConfirmationWithRefresh.setLayout(editConfirmationWithRefreshLayout);
        editConfirmationWithRefreshLayout.setHorizontalGroup(
            editConfirmationWithRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editConfirmationWithRefreshLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh))
        );
        editConfirmationWithRefreshLayout.setVerticalGroup(
            editConfirmationWithRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editConfirmationWithRefreshLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editConfirmationWithRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRefresh)
                    .addComponent(btnCancel)
                    .addComponent(btnPost))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlEditingUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editConfirmationWithRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEditingUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(editConfirmationWithRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnabledSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnabledSenhaActionPerformed
        this.setPasswordsVisibility();
    }//GEN-LAST:event_btnEnabledSenhaActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        //Atulizando a lista de dados. O manager irá atualizar os componentes necessários 
        this.usuarioDBCManager.setTemporaryTDataList(this.usuarioController.select(this.edtNomeFiltro.getText(), this.edtLoginFiltro.getText()));
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEnabledSenha;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPost;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel editConfirmationWithRefresh;
    private javax.swing.JFormattedTextField edtCodCliente;
    private javax.swing.JTextField edtLogin;
    private javax.swing.JTextField edtLoginFiltro;
    private javax.swing.JFormattedTextField edtNome;
    private javax.swing.JTextField edtNomeFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodCliente;
    private javax.swing.JLabel lblCodUsuarioValidation;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLoginFiltro;
    private javax.swing.JLabel lblLoginValidation;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeFiltro;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel pnlEditingUsuario;
    private javax.swing.JPanel pnlFiltroUsuario;
    private javax.swing.JPasswordField pswdSenha;
    private javax.swing.JPanel recordEditing;
    private javax.swing.JTable tblUsuario;
    // End of variables declaration//GEN-END:variables
   
    //CÓDIGOS PRÓPRIOS DA CLASSE
    //Atributos
    private UsuarioController usuarioController;
    private DatabaseAccessComponentManager<Usuario> usuarioDBCManager;
    private int defaultColumnMaxWidth;
    private int defaultColumnPreferredWidth;

    //Constructors
    public UsuarioView(UsuarioController usuarioController, DatabaseAccessComponentManager<Usuario> usuarioDBCManager, JFrame previousView) { 
        //Default codes
        this.initComponents();
        super.setDefaultViewSettings("Cadastro de Usuários", previousView);
        
        //HANDLING CODES
            //Injectons
            this.usuarioController = usuarioController;
            this.usuarioDBCManager = usuarioDBCManager; 
            
            //Default attribute values
            this.defaultColumnMaxWidth = 0;
            this.defaultColumnPreferredWidth = 0;
            this.lblCodUsuarioValidation.setForeground(SuperView.DEFAULT_BACKGROUND_COLOR);
            this.lblLoginValidation.setForeground(SuperView.DEFAULT_BACKGROUND_COLOR);
            
            //Triggering methods
                //Configurando o DatabaseAccessComponentManager
                List<Component> fields = Arrays.asList(this.edtCodCliente, this.edtNome, this.edtLogin, this.pswdSenha);;
                this.usuarioDBCManager.setFields(fields);
                this.usuarioDBCManager.setModelToTableRow(this::modelToTableRow);
                this.usuarioDBCManager.setModelToFields(this::modelToFields);
                this.usuarioDBCManager.setFieldsToModel(this::fieldsToModel);
                this.usuarioDBCManager.configureComponents(Usuario.class, this.usuarioController, this.btnInsert,
                this.btnUpdate, this.btnDelete, this.btnPost, this.btnCancel, this.btnRefresh, this.tblUsuario); 

                //Por padrão, a senha não é visível ao exibir a interface
                this.setPasswordsVisibility();
                
                //Adicionando as validações dos campos
                UtilMethods.addTextChangeListeners(this.edtCodCliente, this::validateCodUsuario);
                UtilMethods.addTextChangeListeners(this.edtLogin, this::validateLogin);
    }
    //Getters e Setters 
    public int getDefaultColumnMaxWidth() {
        return defaultColumnMaxWidth;
    }

    //O valor defaultColumnMaxWidth só pode ser setado uma vez. Se o valor for 0(valor default), o valor passado será setado.
    public void setDefaultColumnMaxWidth(int defaultColumnMaxWidth) {
        if(this.defaultColumnMaxWidth == 0) {
            this.defaultColumnMaxWidth = defaultColumnMaxWidth;
        }
    }
    
    public int getDefaultColumnPreferredWidth() {
        return defaultColumnPreferredWidth;
    }

    //O valor defaultColumnPreferredWidth só pode ser setado uma vez. Se o valor for 0(valor default), o valor passado será setado.
    public void setDefaultColumnPreferredWidth(int defaultColumnPreferredWidth) {
        if(this.defaultColumnPreferredWidth == 0) {
            this.defaultColumnPreferredWidth = defaultColumnPreferredWidth;
        }
    }

    //Métodos
    //Método para mostrar/esconder os campos relacionados a senha
    public void setPasswordsVisibility() {
        javax.swing.table.TableColumn column = this.tblUsuario.getColumnModel().getColumn(3);

        //Salvando os valores padrões de largura das colunas
        this.setDefaultColumnMaxWidth(column.getMaxWidth());
        this.setDefaultColumnPreferredWidth(column.getPreferredWidth());
        
        //Se a coluna estiver visível, esconde ela e vice-versa
        if(this.defaultColumnMaxWidth == column.getMaxWidth()) {
            column.setMaxWidth(10);
            this.pswdSenha.setEchoChar('\u2022');
            
        }
        else{
            column.setMaxWidth(this.defaultColumnMaxWidth);
            column.setPreferredWidth(this.defaultColumnPreferredWidth);
            this.pswdSenha.setEchoChar('\u0000');
        }
    }

    /*Método para realizar mapeamento do model(Objeto Usuario)
    para um objeto que possa ser inserido na tabela*/
    public Object[] modelToTableRow(Usuario usuario){
        return new Object[]{
            usuario.getIdUsuario(), 
            usuario.getNome(),
            usuario.getLogin(),
            usuario.getSenha()
        };
    }

    /*Método para realizar mapeamento do model(Objeto Usuario) para os campos da interface*/
    public void modelToFields(Usuario usuario) {
        if(usuario.getIdUsuario() == null) {
            this.edtCodCliente.setText("");
        } else { 
            this.edtCodCliente.setText(usuario.getIdUsuario().toString());
        }
        this.edtNome.setText(usuario.getNome());
        this.edtLogin.setText(usuario.getLogin());
        this.pswdSenha.setText(usuario.getSenha());
    }

    //Método para realizar mapeamento dos campos da interface para um objeto Usuario
    public Usuario fieldsToModel() {
       return new Usuario(
            this.edtCodCliente.getText().isEmpty() ? null : Long.parseLong(this.edtCodCliente.getText()),
            this.edtNome.getText(),
            this.edtLogin.getText(),
            this.pswdSenha.getPassword().toString()
       );
    }


    //MÉTODOS PARA ADICIONAR VALIDAÇÕES AOS CAMPOS
    public void validateCodUsuario() {
        Long id = null;

        if(!this.edtCodCliente.getText().isEmpty()) {
            try {
                id = Long.parseLong(this.edtCodCliente.getText());
            } catch(NumberFormatException e) {
             
            }
        }

        /*Se o usuário estiver atualizando um registro e o id do registro selecionado(que está sendo editado) for
        diferente do id que está sendo digitado ou se o usuário estiver inserindo um novo registro e, atendendo
        algum dos casos anteriores, se o id já existir, a label de validação ficará vermelha, mostrando o erro*/
        if(     ((this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.UPDATE
                    && !this.usuarioDBCManager.getTSelectedRecord().getValue().getIdUsuario().equals(id))
                || this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.INSERT)
            && this.usuarioController.isIdExists(id) 
            ) {

            this.lblCodUsuarioValidation.setForeground(SuperView.ERROR_COLOR);
        } else {
            this.lblCodUsuarioValidation.setForeground(SuperView.DEFAULT_BACKGROUND_COLOR);
        }
    }

    public void validateLogin() {
        String login = this.edtLogin.getText();

        /*Se o usuário estiver atualizando um registro e o login do registro selecionado(que está sendo editado) for
        diferente do login que está sendo digitado ou se o usuário estiver inserindo um novo registro e, atendendo
        algum dos casos anteriores, se o login já existir, a label de validação ficará vermelha, mostrando o erro*/
        if(     ((this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.UPDATE
                    && !this.usuarioDBCManager.getTSelectedRecord().getValue().getLogin().equals(login))
                || this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.INSERT)
            && this.usuarioController.isLoginExists(login) 
            ) {

            this.lblLoginValidation.setForeground(SuperView.ERROR_COLOR);
        } else {
            this.lblLoginValidation.setForeground(SuperView.DEFAULT_BACKGROUND_COLOR);
        }
    }
}
