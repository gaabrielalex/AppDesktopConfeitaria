package edu.ifmt.confeitaria.layers.views.data_management;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.controllers.data_management.ClienteController;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperView;
import edu.ifmt.confeitaria.util.themes.NimbusTheme;

public class ClienteView extends SuperView {

    private ClienteView() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditingCliente = new javax.swing.JPanel();
        pnlFiltroCliente = new javax.swing.JPanel();
        lblNomeFiltro = new javax.swing.JLabel();
        lblCPFFiltro = new javax.swing.JLabel();
        edtNomeFiltro = new javax.swing.JTextField();
        edtCPFFiltro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        edtNome = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        edtCPF = new javax.swing.JTextField();
        edtLinkEnd = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        edtEndereco = new javax.swing.JTextField();
        lblLinkEnd = new javax.swing.JLabel();
        edtTelefones = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblTelefones = new javax.swing.JLabel();
        recordEditing = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        editConfirmationWithRefresh = new javax.swing.JPanel();
        btnPost = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlEditingCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlFiltroCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFiltroCliente.setName("pnlFiltroCliente"); // NOI18N

        lblNomeFiltro.setText("Nome:");
        lblNomeFiltro.setName("lblNomeFiltro"); // NOI18N

        lblCPFFiltro.setText("CPF:");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "CPF", "Telefones", "Endereço", "Link Endereço"
            }
        ));
        tblCliente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCliente.setGridColor(new java.awt.Color(204, 204, 204));
        tblCliente.setShowGrid(true);
        jScrollPane2.setViewportView(tblCliente);
        if (tblCliente.getColumnModel().getColumnCount() > 0) {
            tblCliente.getColumnModel().getColumn(0).setMaxWidth(60);
            tblCliente.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblCliente.getColumnModel().getColumn(2).setMinWidth(85);
            tblCliente.getColumnModel().getColumn(2).setMaxWidth(85);
            tblCliente.getColumnModel().getColumn(3).setPreferredWidth(125);
            tblCliente.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblCliente.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltroClienteLayout = new javax.swing.GroupLayout(pnlFiltroCliente);
        pnlFiltroCliente.setLayout(pnlFiltroClienteLayout);
        pnlFiltroClienteLayout.setHorizontalGroup(
            pnlFiltroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlFiltroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(pnlFiltroClienteLayout.createSequentialGroup()
                        .addGroup(pnlFiltroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPFFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFiltroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtCPFFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(edtNomeFiltro))
                        .addGap(41, 41, 41)
                        .addComponent(btnPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        pnlFiltroClienteLayout.setVerticalGroup(
            pnlFiltroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroClienteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlFiltroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeFiltro)
                    .addComponent(edtNomeFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFiltroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtCPFFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPFFiltro))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblEndereco.setText("Endereço:");

        edtCPF.setToolTipText("");

        lblCPF.setText("CPF:");

        lblLinkEnd.setText("Link End.:");

        lblNome.setText("Nome:");
        lblNome.setName("lblNomeFiltro"); // NOI18N

        lblTelefones.setText("Telefones:");

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

        javax.swing.GroupLayout pnlEditingClienteLayout = new javax.swing.GroupLayout(pnlEditingCliente);
        pnlEditingCliente.setLayout(pnlEditingClienteLayout);
        pnlEditingClienteLayout.setHorizontalGroup(
            pnlEditingClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditingClienteLayout.createSequentialGroup()
                .addGroup(pnlEditingClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditingClienteLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnlEditingClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLinkEnd)
                            .addComponent(lblEndereco)
                            .addComponent(lblTelefones)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEditingClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(edtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                            .addComponent(edtTelefones)
                            .addComponent(edtLinkEnd)
                            .addComponent(edtNome, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(30, 30, 30)
                        .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditingClienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditingClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(recordEditing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );
        pnlEditingClienteLayout.setVerticalGroup(
            pnlEditingClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditingClienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlEditingClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPF)
                    .addComponent(edtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefones)
                    .addComponent(edtTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(edtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLinkEnd)
                    .addComponent(edtLinkEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(recordEditing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
                .addContainerGap()
                .addComponent(btnPost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(pnlEditingCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editConfirmationWithRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEditingCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(editConfirmationWithRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        //Atulizando a lista de dados. O manager atualizará os componentes necessários
        this.clienteController.partialSearch(this.edtNomeFiltro.getText(), this.edtCPFFiltro.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    public static void main(String args[]) {
        NimbusTheme.setTheme();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPost;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel editConfirmationWithRefresh;
    private javax.swing.JTextField edtCPF;
    private javax.swing.JTextField edtCPFFiltro;
    private javax.swing.JTextField edtEndereco;
    private javax.swing.JTextField edtLinkEnd;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtNomeFiltro;
    private javax.swing.JTextField edtTelefones;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCPFFiltro;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblLinkEnd;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeFiltro;
    private javax.swing.JLabel lblTelefones;
    private javax.swing.JPanel pnlEditingCliente;
    private javax.swing.JPanel pnlFiltroCliente;
    private javax.swing.JPanel recordEditing;
    private javax.swing.JTable tblCliente;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getEdtCPF() {
        return edtCPF;
    }

    public javax.swing.JTextField getEdtEndereco() {
        return edtEndereco;
    }

    public javax.swing.JTextField getEdtLinkEnd() {
        return edtLinkEnd;
    }

    public javax.swing.JTextField getEdtNome() {
        return edtNome;
    }

    public javax.swing.JTextField getEdtTelefones() {
        return edtTelefones;
    }

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

    public javax.swing.JTable getTblCliente() {
        return tblCliente;
    }

    //CÓDIGOS PRÓPRIOS DA CLASSE
    private ClienteController clienteController;

    public ClienteView(ClienteController clienteController, JFrame previousView) {
        //Códigos padrões de inicialização da interface
        this.initComponents();
        super.setDefaultViewSettings("Cadastro de Clientes", previousView);
        this.clienteController = clienteController;     
    }
}
