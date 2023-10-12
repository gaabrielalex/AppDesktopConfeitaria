package edu.ifmt.confeitaria.layers.views.data_management;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.controllers.data_management.UsuarioController;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperView;
import edu.ifmt.confeitaria.util.themes.NimbusTheme;

public class UsuarioView extends SuperView {

    private UsuarioView() {
        initComponents();
    }

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
        lblSenha = new javax.swing.JLabel();
        edtLogin = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        pswdSenha = new javax.swing.JPasswordField();
        recordEditing = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        edtNome = new javax.swing.JFormattedTextField();
        lblLoginValidation = new javax.swing.JLabel();
        lblNomeValidation = new javax.swing.JLabel();
        lblSenhaValidation = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCodUsuario = new javax.swing.JLabel();
        btnEnabledSenha = new javax.swing.JButton();
        lblCodUsuarioValidation = new javax.swing.JLabel();
        edtCodUsuario = new javax.swing.JFormattedTextField();
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
                .addContainerGap(20, Short.MAX_VALUE))
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

        lblSenha.setText("Senha:");

        lblLogin.setText("Login:");

        lblNome.setText("Nome:");
        lblNome.setName("lblNomeFiltro"); // NOI18N

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

        lblLoginValidation.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblLoginValidation.setForeground(new java.awt.Color(204, 51, 0));
        lblLoginValidation.setText("x");

        lblNomeValidation.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblNomeValidation.setForeground(new java.awt.Color(204, 51, 0));
        lblNomeValidation.setText("x");

        lblSenhaValidation.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblSenhaValidation.setForeground(new java.awt.Color(204, 51, 0));
        lblSenhaValidation.setText("x");

        lblCodUsuario.setText("Código:");

        btnEnabledSenha.setText("Habilitar/Desabilitar Senha");
        btnEnabledSenha.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnEnabledSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnabledSenhaActionPerformed(evt);
            }
        });

        lblCodUsuarioValidation.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblCodUsuarioValidation.setForeground(new java.awt.Color(204, 51, 0));
        lblCodUsuarioValidation.setText("Código já existente !!!");

        edtCodUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCodUsuarioValidation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnEnabledSenha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(lblCodUsuarioValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEnabledSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        lblCodUsuarioValidation.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout pnlEditingUsuarioLayout = new javax.swing.GroupLayout(pnlEditingUsuario);
        pnlEditingUsuario.setLayout(pnlEditingUsuarioLayout);
        pnlEditingUsuarioLayout.setHorizontalGroup(
            pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                        .addComponent(pnlFiltroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                        .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(lblNomeValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditingUsuarioLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lblLoginValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(pswdSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblSenhaValidation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(edtLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditingUsuarioLayout.createSequentialGroup()
                        .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome))
                        .addGap(0, 0, 0)
                        .addComponent(lblNomeValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogin))
                        .addGap(0, 0, 0)
                        .addComponent(lblLoginValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnlEditingUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSenha)
                            .addComponent(pswdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(lblSenhaValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(recordEditing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editConfirmationWithRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEditingUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        this.usuarioController.partialSearch(this.edtNomeFiltro.getText(), this.edtLoginFiltro.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    public static void main(String args[]) {
        NimbusTheme.setTheme();
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
    private javax.swing.JFormattedTextField edtCodUsuario;
    private javax.swing.JTextField edtLogin;
    private javax.swing.JTextField edtLoginFiltro;
    private javax.swing.JFormattedTextField edtNome;
    private javax.swing.JTextField edtNomeFiltro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodUsuario;
    private javax.swing.JLabel lblCodUsuarioValidation;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLoginFiltro;
    private javax.swing.JLabel lblLoginValidation;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeFiltro;
    private javax.swing.JLabel lblNomeValidation;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaValidation;
    private javax.swing.JPanel pnlEditingUsuario;
    private javax.swing.JPanel pnlFiltroUsuario;
    private javax.swing.JPasswordField pswdSenha;
    private javax.swing.JPanel recordEditing;
    private javax.swing.JTable tblUsuario;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnCancel() {
        return btnCancel;
    }

    public javax.swing.JButton getBtnDelete() {
        return btnDelete;
    }

    public javax.swing.JButton getBtnInsert() {
        return btnInsert;
    }

    public javax.swing.JButton getBtnPost() {
        return btnPost;
    }

    public javax.swing.JButton getBtnRefresh() {
        return btnRefresh;
    }

    public javax.swing.JButton getBtnUpdate() {
        return btnUpdate;
    }

    public javax.swing.JFormattedTextField getEdtCodUsuario() {
        return edtCodUsuario;
    }

    public javax.swing.JTextField getEdtLogin() {
        return edtLogin;
    }

    public javax.swing.JFormattedTextField getEdtNome() {
        return edtNome;
    }

    public javax.swing.JLabel getLblCodUsuarioValidation() {
        return lblCodUsuarioValidation;
    }

    public javax.swing.JLabel getLblLoginValidation() {
        return lblLoginValidation;
    }

    public javax.swing.JPasswordField getPswdSenha() {
        return pswdSenha;
    }

    public javax.swing.JTable getTblUsuario() {
        return tblUsuario;
    }

    public javax.swing.JLabel getLblNomeValidation() {
        return lblNomeValidation;
    }

    public javax.swing.JLabel getLblSenhaValidation() {
        return lblSenhaValidation;
    }

    //CÓDIGOS PRÓPRIOS DA CLASSE
    private UsuarioController usuarioController;
    private int defaultColumnMaxWidth;
    private int defaultColumnPreferredWidth; 

    public UsuarioView(UsuarioController usuarioController, JFrame previousView) { 
        //Códigos padrões de inicialização da interface
        this.initComponents();
        super.setDefaultViewSettings("Cadastro de Usuários", previousView);
        this.usuarioController = usuarioController;
            
        //Valores padrões de atributos e componentes
        this.defaultColumnMaxWidth = 0;
        this.defaultColumnPreferredWidth = 0;
        
        //Por padrão, a senha não é visível ao exibir a interface
        this.setPasswordsVisibility();
    }

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
    
}
