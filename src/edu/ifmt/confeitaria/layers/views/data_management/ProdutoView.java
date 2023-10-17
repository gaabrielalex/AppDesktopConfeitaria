package edu.ifmt.confeitaria.layers.views.data_management;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.controllers.data_management.ProdutoController;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperView;
import edu.ifmt.confeitaria.util.themes.NimbusTheme;

public class ProdutoView extends SuperView {

    private ProdutoView() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditingProduto = new javax.swing.JPanel();
        pnlFiltroProduto = new javax.swing.JPanel();
        lblDescricaoFiltro = new javax.swing.JLabel();
        lblTipoChocFiltro = new javax.swing.JLabel();
        edtDescricaoFiltro = new javax.swing.JTextField();
        cmbTipoChocFiltro = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        edtDescricao = new javax.swing.JTextField();
        edtObs = new javax.swing.JTextField();
        edtVlrUnt = new javax.swing.JTextField();
        cmbTipoChoc = new javax.swing.JComboBox<>();
        lblObs = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblVlrUnt = new javax.swing.JLabel();
        lblTipoChoc = new javax.swing.JLabel();
        recordEditing = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        editConfirmationWithRefresh = new javax.swing.JPanel();
        btnPost = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlEditingProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlFiltroProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFiltroProduto.setName("pnlFiltroProduto"); // NOI18N

        lblDescricaoFiltro.setText("Descrição:");
        lblDescricaoFiltro.setName("lblDescricaoFiltro"); // NOI18N

        lblTipoChocFiltro.setText("Tipo Choc.:");

        cmbTipoChocFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoChocFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnPesquisar.setText("Pesquisar");

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Tipo do Chocolate", "Valor Unitário", "Observações"
            }
        ));
        tblProduto.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblProduto.setGridColor(new java.awt.Color(204, 204, 204));
        tblProduto.setShowGrid(true);
        jScrollPane2.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(0).setMaxWidth(60);
            tblProduto.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblProduto.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblProduto.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblProduto.getColumnModel().getColumn(4).setPreferredWidth(580);
        }

        javax.swing.GroupLayout pnlFiltroProdutoLayout = new javax.swing.GroupLayout(pnlFiltroProduto);
        pnlFiltroProduto.setLayout(pnlFiltroProdutoLayout);
        pnlFiltroProdutoLayout.setHorizontalGroup(
            pnlFiltroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroProdutoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlFiltroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFiltroProdutoLayout.createSequentialGroup()
                        .addGroup(pnlFiltroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDescricaoFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTipoChocFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFiltroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtDescricaoFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(cmbTipoChocFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(btnPesquisar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlFiltroProdutoLayout.setVerticalGroup(
            pnlFiltroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroProdutoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlFiltroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricaoFiltro)
                    .addComponent(edtDescricaoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFiltroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoChocFiltro)
                    .addComponent(cmbTipoChocFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        cmbTipoChoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblObs.setText("Observações:");

        lblDescricao.setText("Descrição:");
        lblDescricao.setName("lblNomeFiltro"); // NOI18N

        lblVlrUnt.setText("Vlr. Unit.:");

        lblTipoChoc.setText("Tipo Choc.:");

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

        javax.swing.GroupLayout pnlEditingProdutoLayout = new javax.swing.GroupLayout(pnlEditingProduto);
        pnlEditingProduto.setLayout(pnlEditingProdutoLayout);
        pnlEditingProdutoLayout.setHorizontalGroup(
            pnlEditingProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditingProdutoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(recordEditing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
            .addGroup(pnlEditingProdutoLayout.createSequentialGroup()
                .addGroup(pnlEditingProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditingProdutoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnlEditingProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblObs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTipoChoc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEditingProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlEditingProdutoLayout.createSequentialGroup()
                                .addGroup(pnlEditingProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipoChoc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(lblVlrUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtVlrUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edtObs)))
                    .addGroup(pnlEditingProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlFiltroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pnlEditingProdutoLayout.setVerticalGroup(
            pnlEditingProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditingProdutoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlFiltroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlEditingProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(edtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoChoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoChoc)
                    .addComponent(lblVlrUnt)
                    .addComponent(edtVlrUnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObs)
                    .addComponent(edtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(pnlEditingProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editConfirmationWithRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEditingProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(editConfirmationWithRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        NimbusTheme.setTheme();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoView().setVisible(true);
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
    private javax.swing.JComboBox<String> cmbTipoChoc;
    private javax.swing.JComboBox<String> cmbTipoChocFiltro;
    private javax.swing.JPanel editConfirmationWithRefresh;
    private javax.swing.JTextField edtDescricao;
    private javax.swing.JTextField edtDescricaoFiltro;
    private javax.swing.JTextField edtObs;
    private javax.swing.JTextField edtVlrUnt;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDescricaoFiltro;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblTipoChoc;
    private javax.swing.JLabel lblTipoChocFiltro;
    private javax.swing.JLabel lblVlrUnt;
    private javax.swing.JPanel pnlEditingProduto;
    private javax.swing.JPanel pnlFiltroProduto;
    private javax.swing.JPanel recordEditing;
    private javax.swing.JTable tblProduto;
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

    public javax.swing.JTable getTblProduto() {
        return tblProduto;
    }
    
    //CÓDIGOS PRÓPRIOS DA CLASSE
    private ProdutoController produtoController;
    
    public ProdutoView(ProdutoController produtoController, JFrame previousView) {
        //Códigos padrões de inicialização da interface
        this.initComponents();
        super.setDefaultViewSettings("Cadastro de Produtos", previousView);
        this.produtoController = produtoController; 
    }
    
}
