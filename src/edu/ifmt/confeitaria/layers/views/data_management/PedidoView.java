package edu.ifmt.confeitaria.layers.views.data_management;

import edu.ifmt.confeitaria.layers.controllers.data_management.ItemPedidoController;
import edu.ifmt.confeitaria.layers.controllers.data_management.PedidoController;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperView;
import edu.ifmt.confeitaria.util.themes.NimbusTheme;

import javax.swing.JFrame;

public class PedidoView extends SuperView {

    private PedidoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPedido = new javax.swing.JPanel();
        lblTituloPedido = new javax.swing.JLabel();
        editConfirmationWithRefreshPedido = new javax.swing.JPanel();
        btnPostPedido = new javax.swing.JButton();
        btnCancelPedido = new javax.swing.JButton();
        btnRefreshPedido = new javax.swing.JButton();
        pnlEditingPedido = new javax.swing.JPanel();
        pnlFiltroPedido = new javax.swing.JPanel();
        lblClienteFiltro = new javax.swing.JLabel();
        lblSttsPagtoFiltro = new javax.swing.JLabel();
        edtClienteFiltro = new javax.swing.JTextField();
        cmbSttsPagtoFiltro = new javax.swing.JComboBox<>();
        btnPesquisarPedido = new javax.swing.JButton();
        lblDestinatarioFiltro = new javax.swing.JLabel();
        edtDestinatarioFiltro = new javax.swing.JTextField();
        lblSttsPedidoFiltro = new javax.swing.JLabel();
        cmbSttsPedidoFiltro = new javax.swing.JComboBox<>();
        btnClienteExpandir = new javax.swing.JButton();
        btnClienteReduzir = new javax.swing.JButton();
        scrlPnPedido = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        recordEditingPedido = new javax.swing.JPanel();
        btnInsertPedido = new javax.swing.JButton();
        btnDeletePedido = new javax.swing.JButton();
        btnUpdatePedido = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        btnPesquisarCliente = new javax.swing.JButton();
        dtChooserDtPedido = new com.toedter.calendar.JDateChooser();
        edtCliente = new javax.swing.JTextField();
        lblObs = new javax.swing.JLabel();
        dtChooserDtEntrega = new com.toedter.calendar.JDateChooser();
        lblSttsPedido = new javax.swing.JLabel();
        cmbSttsPagto = new javax.swing.JComboBox<>();
        lblSttsPagto = new javax.swing.JLabel();
        edtDestinatario = new javax.swing.JTextField();
        edtObs = new javax.swing.JTextField();
        edtDesconto = new javax.swing.JTextField();
        cmbSttsPedido = new javax.swing.JComboBox<>();
        cmbMtdPagto = new javax.swing.JComboBox<>();
        ckBRetirada = new javax.swing.JCheckBox();
        edtCodCliente = new javax.swing.JTextField();
        lblCodCliente = new javax.swing.JLabel();
        javax.swing.JLabel lblVlrTotalPedido = new javax.swing.JLabel();
        lblDtPedido = new javax.swing.JLabel();
        lblDtEntrega = new javax.swing.JLabel();
        lblMtdPagto = new javax.swing.JLabel();
        lblDesconto = new javax.swing.JLabel();
        lblDestinatario = new javax.swing.JLabel();
        edtVlrTotalPedido = new javax.swing.JTextField();
        javax.swing.JLabel lblSubTotalPedido = new javax.swing.JLabel();
        edtSubTotalPedido = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        pnlItemPedido = new javax.swing.JPanel();
        lblTituloItemPedido = new javax.swing.JLabel();
        editConfirmationWithRefreshItemPedido = new javax.swing.JPanel();
        btnPostItemPedido = new javax.swing.JButton();
        btnCancelItemPedido = new javax.swing.JButton();
        btnRefreshItemPedido = new javax.swing.JButton();
        pnlEditingItemPedido = new javax.swing.JPanel();
        pnlFiltroItemPedido = new javax.swing.JPanel();
        lblProdutoFiltro = new javax.swing.JLabel();
        lblTipoChocFiltro = new javax.swing.JLabel();
        edtProdutoFiltro = new javax.swing.JTextField();
        cmbTipoChocFiltro = new javax.swing.JComboBox<>();
        btnPesquisarItemPedido = new javax.swing.JButton();
        scrlPnItemPedido = new javax.swing.JScrollPane();
        tblItemPedido = new javax.swing.JTable();
        btnPesquisarProduto = new javax.swing.JButton();
        edtProduto = new javax.swing.JTextField();
        edtVlrTotalItemPedido = new javax.swing.JTextField();
        edtQtde = new javax.swing.JTextField();
        edtCodProduto = new javax.swing.JTextField();
        lblCodProduto = new javax.swing.JLabel();
        lblProduto = new javax.swing.JLabel();
        lblVlrTotalItemPedido = new javax.swing.JLabel();
        lblQtde = new javax.swing.JLabel();
        recordEditingItemPedido = new javax.swing.JPanel();
        btnInsertItemPedido = new javax.swing.JButton();
        btnDeleteItemPedido = new javax.swing.JButton();
        btnUpdateItemPedido = new javax.swing.JButton();
        edtVlrUnt = new javax.swing.JTextField();
        lblVlrUnt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloPedido.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTituloPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloPedido.setText("Pedido");
        lblTituloPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPostPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-accept-30.png"))); // NOI18N
        btnPostPedido.setToolTipText("Salvar");
        btnPostPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCancelPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-cancel-30.png"))); // NOI18N
        btnCancelPedido.setToolTipText("Cancelar");
        btnCancelPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelPedido.setName(""); // NOI18N
        btnCancelPedido.setRolloverEnabled(false);

        btnRefreshPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-refresh-30.png"))); // NOI18N
        btnRefreshPedido.setToolTipText("Atualizar");
        btnRefreshPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefreshPedido.setName(""); // NOI18N
        btnRefreshPedido.setRolloverEnabled(false);

        javax.swing.GroupLayout editConfirmationWithRefreshPedidoLayout = new javax.swing.GroupLayout(editConfirmationWithRefreshPedido);
        editConfirmationWithRefreshPedido.setLayout(editConfirmationWithRefreshPedidoLayout);
        editConfirmationWithRefreshPedidoLayout.setHorizontalGroup(
            editConfirmationWithRefreshPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editConfirmationWithRefreshPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPostPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefreshPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editConfirmationWithRefreshPedidoLayout.setVerticalGroup(
            editConfirmationWithRefreshPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editConfirmationWithRefreshPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editConfirmationWithRefreshPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRefreshPedido)
                    .addComponent(btnCancelPedido)
                    .addComponent(btnPostPedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEditingPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlFiltroPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFiltroPedido.setName("pnlFiltroItemPedido"); // NOI18N

        lblClienteFiltro.setText("Cliente:");
        lblClienteFiltro.setName("lblProdutoFiltro"); // NOI18N

        lblSttsPagtoFiltro.setText("Stts Pagamento:");

        cmbSttsPagtoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSttsPagtoFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnPesquisarPedido.setText("Pesquisar");
        btnPesquisarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPedidoActionPerformed(evt);
            }
        });

        lblDestinatarioFiltro.setText("Destinatário:");

        lblSttsPedidoFiltro.setText("Stts Pedido:");

        cmbSttsPedidoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSttsPedidoFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnClienteExpandir.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnClienteExpandir.setText("Expandir informações do cliente");
        btnClienteExpandir.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnClienteExpandir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteExpandirActionPerformed(evt);
            }
        });

        btnClienteReduzir.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnClienteReduzir.setText("Reduzir");
        btnClienteReduzir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteReduzirActionPerformed(evt);
            }
        });

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, "23/02/2003 - 18:00", null, "R$ 10.000,99", "R$ 1.000,99", "cartão de crédito", null, null, "Cancelado", "Aberto", null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Cliente", "Telefones", "Endereço", "Link Endereço", "Data Pedido", "Data Entrega", "Valor Total", "Desconto", "Método Pag.", "Destinatário", "Retirada na Loja", "Stts Pedido", "Stts Pag.", "Observações", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPedido.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPedido.setGridColor(new java.awt.Color(204, 204, 204));
        tblPedido.setShowGrid(true);
        scrlPnPedido.setViewportView(tblPedido);
        if (tblPedido.getColumnModel().getColumnCount() > 0) {
            tblPedido.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblPedido.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblPedido.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblPedido.getColumnModel().getColumn(3).setPreferredWidth(10);
            tblPedido.getColumnModel().getColumn(4).setPreferredWidth(10);
            tblPedido.getColumnModel().getColumn(5).setPreferredWidth(110);
            tblPedido.getColumnModel().getColumn(6).setPreferredWidth(110);
            tblPedido.getColumnModel().getColumn(7).setPreferredWidth(90);
            tblPedido.getColumnModel().getColumn(8).setPreferredWidth(85);
            tblPedido.getColumnModel().getColumn(9).setPreferredWidth(105);
            tblPedido.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblPedido.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblPedido.getColumnModel().getColumn(13).setPreferredWidth(60);
            tblPedido.getColumnModel().getColumn(14).setPreferredWidth(630);
            tblPedido.getColumnModel().getColumn(15).setPreferredWidth(250);
        }

        javax.swing.GroupLayout pnlFiltroPedidoLayout = new javax.swing.GroupLayout(pnlFiltroPedido);
        pnlFiltroPedido.setLayout(pnlFiltroPedidoLayout);
        pnlFiltroPedidoLayout.setHorizontalGroup(
            pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroPedidoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlPnPedido)
                    .addGroup(pnlFiltroPedidoLayout.createSequentialGroup()
                        .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFiltroPedidoLayout.createSequentialGroup()
                                .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblSttsPagtoFiltro)
                                        .addGroup(pnlFiltroPedidoLayout.createSequentialGroup()
                                            .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblClienteFiltro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblDestinatarioFiltro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(2, 2, 2)
                                            .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(edtDestinatarioFiltro)
                                                .addComponent(edtClienteFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                                    .addGroup(pnlFiltroPedidoLayout.createSequentialGroup()
                                        .addComponent(lblSttsPedidoFiltro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbSttsPedidoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFiltroPedidoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbSttsPagtoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlFiltroPedidoLayout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(btnPesquisarPedido))))
                            .addGroup(pnlFiltroPedidoLayout.createSequentialGroup()
                                .addComponent(btnClienteExpandir)
                                .addGap(18, 18, 18)
                                .addComponent(btnClienteReduzir)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        pnlFiltroPedidoLayout.setVerticalGroup(
            pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroPedidoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteFiltro)
                    .addComponent(edtClienteFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestinatarioFiltro)
                    .addComponent(edtDestinatarioFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSttsPagtoFiltro)
                    .addComponent(lblSttsPedidoFiltro)
                    .addComponent(cmbSttsPedidoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSttsPagtoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlFiltroPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClienteReduzir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClienteExpandir))
                .addGap(18, 18, 18)
                .addComponent(scrlPnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        recordEditingPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnInsertPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-add-30.png"))); // NOI18N
        btnInsertPedido.setToolTipText("Inserir");
        btnInsertPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnDeletePedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-remove-30.png"))); // NOI18N
        btnDeletePedido.setToolTipText("Deletar");
        btnDeletePedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnUpdatePedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-edit-30.png"))); // NOI18N
        btnUpdatePedido.setToolTipText("Editar");
        btnUpdatePedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout recordEditingPedidoLayout = new javax.swing.GroupLayout(recordEditingPedido);
        recordEditingPedido.setLayout(recordEditingPedidoLayout);
        recordEditingPedidoLayout.setHorizontalGroup(
            recordEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordEditingPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInsertPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdatePedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletePedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        recordEditingPedidoLayout.setVerticalGroup(
            recordEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordEditingPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recordEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdatePedido)
                    .addComponent(btnDeletePedido)
                    .addComponent(btnInsertPedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCliente.setText("Cliente:");
        lblCliente.setName("lblNomeFiltro"); // NOI18N

        btnPesquisarCliente.setText("Pesquisar Cliente");
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        dtChooserDtPedido.setDateFormatString("dd/MM/y  H:m");

        edtCliente.setEditable(false);
        edtCliente.setEnabled(false);

        lblObs.setText("Observações:");

        dtChooserDtEntrega.setDateFormatString("dd/MM/y  H:m");

        lblSttsPedido.setText("Stts Pedido:");

        cmbSttsPagto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSttsPagto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblSttsPagto.setText("Stts Pag.:");

        cmbSttsPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSttsPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cmbMtdPagto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartão de crédito", "Cartão de débito", "Dinheiro", "Pix" }));

        ckBRetirada.setText("Retirada na Loja");
        ckBRetirada.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        edtCodCliente.setEditable(false);
        edtCodCliente.setEnabled(false);

        lblCodCliente.setText("Código C.:");

        lblVlrTotalPedido.setText("Total:");

        lblDtPedido.setText("Data Pedido:");

        lblDtEntrega.setText("Data Ent.:");

        lblMtdPagto.setText("Método P.:");

        lblDesconto.setText("Desconto:");

        lblDestinatario.setText("Destinatário:");

        edtVlrTotalPedido.setEditable(false);
        edtVlrTotalPedido.setEnabled(false);

        lblSubTotalPedido.setText("SubTotal:");

        edtSubTotalPedido.setEditable(false);
        edtSubTotalPedido.setEnabled(false);

        javax.swing.GroupLayout pnlEditingPedidoLayout = new javax.swing.GroupLayout(pnlEditingPedido);
        pnlEditingPedido.setLayout(pnlEditingPedidoLayout);
        pnlEditingPedidoLayout.setHorizontalGroup(
            pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditingPedidoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(recordEditingPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
            .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDtPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSttsPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblObs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                                .addComponent(lblSubTotalPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                                .addComponent(cmbSttsPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lblSttsPagto)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(edtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEditingPedidoLayout.createSequentialGroup()
                                            .addComponent(dtChooserDtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblDtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                                        .addComponent(lblCodCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(dtChooserDtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarCliente)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditingPedidoLayout.createSequentialGroup()
                                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                                        .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                                                .addComponent(edtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(ckBRetirada)
                                                    .addComponent(cmbSttsPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                                                .addComponent(edtSubTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(78, 78, 78)
                                                .addComponent(edtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblMtdPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblVlrTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                                        .addComponent(edtObs)
                                        .addGap(76, 76, 76)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbMtdPagto, 0, 130, Short.MAX_VALUE)
                                    .addComponent(edtVlrTotalPedido))
                                .addGap(18, 18, 18))))
                    .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                        .addComponent(pnlFiltroPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlEditingPedidoLayout.setVerticalGroup(
            pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEditingPedidoLayout.createSequentialGroup()
                        .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCliente)
                            .addComponent(edtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarCliente)
                            .addComponent(edtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtChooserDtPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDtPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDtEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(dtChooserDtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDesconto)
                        .addComponent(lblSubTotalPedido)
                        .addComponent(edtSubTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtVlrTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblVlrTotalPedido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestinatario)
                    .addComponent(edtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckBRetirada)
                    .addComponent(cmbMtdPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMtdPagto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSttsPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSttsPedido)
                    .addComponent(lblSttsPagto)
                    .addComponent(cmbSttsPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObs)
                    .addComponent(edtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(recordEditingPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlPedidoLayout = new javax.swing.GroupLayout(pnlPedido);
        pnlPedido.setLayout(pnlPedidoLayout);
        pnlPedidoLayout.setHorizontalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTituloPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlEditingPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editConfirmationWithRefreshPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
        );
        pnlPedidoLayout.setVerticalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addComponent(lblTituloPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlEditingPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(editConfirmationWithRefreshPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 30));

        lblTituloItemPedido.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTituloItemPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloItemPedido.setText("Item Pedido");
        lblTituloItemPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPostItemPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-accept-30.png"))); // NOI18N
        btnPostItemPedido.setToolTipText("Salvar");
        btnPostItemPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCancelItemPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-cancel-30.png"))); // NOI18N
        btnCancelItemPedido.setToolTipText("Cancelar");
        btnCancelItemPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelItemPedido.setName(""); // NOI18N
        btnCancelItemPedido.setRolloverEnabled(false);

        btnRefreshItemPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-refresh-30.png"))); // NOI18N
        btnRefreshItemPedido.setToolTipText("Atualizar");
        btnRefreshItemPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefreshItemPedido.setName(""); // NOI18N
        btnRefreshItemPedido.setRolloverEnabled(false);

        javax.swing.GroupLayout editConfirmationWithRefreshItemPedidoLayout = new javax.swing.GroupLayout(editConfirmationWithRefreshItemPedido);
        editConfirmationWithRefreshItemPedido.setLayout(editConfirmationWithRefreshItemPedidoLayout);
        editConfirmationWithRefreshItemPedidoLayout.setHorizontalGroup(
            editConfirmationWithRefreshItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editConfirmationWithRefreshItemPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPostItemPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelItemPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefreshItemPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editConfirmationWithRefreshItemPedidoLayout.setVerticalGroup(
            editConfirmationWithRefreshItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editConfirmationWithRefreshItemPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editConfirmationWithRefreshItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRefreshItemPedido)
                    .addComponent(btnCancelItemPedido)
                    .addComponent(btnPostItemPedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEditingItemPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlFiltroItemPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFiltroItemPedido.setName("pnlFiltroItemPedido"); // NOI18N
        pnlFiltroItemPedido.setPreferredSize(new java.awt.Dimension(642, 360));

        lblProdutoFiltro.setText("Produto:");
        lblProdutoFiltro.setName("lblProdutoFiltro"); // NOI18N

        lblTipoChocFiltro.setText("Tipo Choc.:");

        cmbTipoChocFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoChocFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnPesquisarItemPedido.setText("Pesquisar");
        btnPesquisarItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarItemPedidoActionPerformed(evt);
            }
        });

        tblItemPedido.setModel(new javax.swing.table.DefaultTableModel(
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
                "Código", "Produto", "Tipo do Chocolate", "Qtde", "Vlr Unit.", "Vlr Total"
            }
        ));
        tblItemPedido.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblItemPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblItemPedido.setGridColor(new java.awt.Color(204, 204, 204));
        tblItemPedido.setShowGrid(true);
        scrlPnItemPedido.setViewportView(tblItemPedido);
        if (tblItemPedido.getColumnModel().getColumnCount() > 0) {
            tblItemPedido.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblItemPedido.getColumnModel().getColumn(1).setPreferredWidth(215);
            tblItemPedido.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblItemPedido.getColumnModel().getColumn(3).setPreferredWidth(69);
            tblItemPedido.getColumnModel().getColumn(4).setPreferredWidth(90);
            tblItemPedido.getColumnModel().getColumn(5).setPreferredWidth(110);
        }

        javax.swing.GroupLayout pnlFiltroItemPedidoLayout = new javax.swing.GroupLayout(pnlFiltroItemPedido);
        pnlFiltroItemPedido.setLayout(pnlFiltroItemPedidoLayout);
        pnlFiltroItemPedidoLayout.setHorizontalGroup(
            pnlFiltroItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroItemPedidoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlFiltroItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlPnItemPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                    .addGroup(pnlFiltroItemPedidoLayout.createSequentialGroup()
                        .addGroup(pnlFiltroItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblProdutoFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTipoChocFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFiltroItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtProdutoFiltro)
                            .addComponent(cmbTipoChocFiltro, 0, 250, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(btnPesquisarItemPedido)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        pnlFiltroItemPedidoLayout.setVerticalGroup(
            pnlFiltroItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroItemPedidoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlFiltroItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProdutoFiltro)
                    .addComponent(edtProdutoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarItemPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFiltroItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoChocFiltro)
                    .addComponent(cmbTipoChocFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(scrlPnItemPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnPesquisarProduto.setText("Pesquisar Produto");
        btnPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoActionPerformed(evt);
            }
        });

        edtProduto.setEditable(false);
        edtProduto.setEnabled(false);

        edtVlrTotalItemPedido.setEditable(false);
        edtVlrTotalItemPedido.setEnabled(false);

        edtCodProduto.setEditable(false);
        edtCodProduto.setEnabled(false);

        lblCodProduto.setText("Código P.:");

        lblProduto.setText("Produto:");
        lblProduto.setName("lblNomeFiltro"); // NOI18N

        lblVlrTotalItemPedido.setText("Vlr. Total:");

        lblQtde.setText("Qtde:");

        recordEditingItemPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnInsertItemPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-add-30.png"))); // NOI18N
        btnInsertItemPedido.setToolTipText("Inserir");
        btnInsertItemPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnDeleteItemPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-remove-30.png"))); // NOI18N
        btnDeleteItemPedido.setToolTipText("Deletar");
        btnDeleteItemPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnUpdateItemPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/icons8-edit-30.png"))); // NOI18N
        btnUpdateItemPedido.setToolTipText("Editar");
        btnUpdateItemPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout recordEditingItemPedidoLayout = new javax.swing.GroupLayout(recordEditingItemPedido);
        recordEditingItemPedido.setLayout(recordEditingItemPedidoLayout);
        recordEditingItemPedidoLayout.setHorizontalGroup(
            recordEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordEditingItemPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInsertItemPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateItemPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteItemPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        recordEditingItemPedidoLayout.setVerticalGroup(
            recordEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordEditingItemPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recordEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateItemPedido)
                    .addComponent(btnDeleteItemPedido)
                    .addComponent(btnInsertItemPedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        edtVlrUnt.setEnabled(false);

        lblVlrUnt.setText("Vlr. Unit.:");

        javax.swing.GroupLayout pnlEditingItemPedidoLayout = new javax.swing.GroupLayout(pnlEditingItemPedido);
        pnlEditingItemPedido.setLayout(pnlEditingItemPedidoLayout);
        pnlEditingItemPedidoLayout.setHorizontalGroup(
            pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditingItemPedidoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEditingItemPedidoLayout.createSequentialGroup()
                        .addComponent(edtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVlrUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtVlrUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCodProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVlrTotalItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtVlrTotalItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnPesquisarProduto)
                .addGap(30, 39, Short.MAX_VALUE))
            .addGroup(pnlEditingItemPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltroItemPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditingItemPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recordEditingItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        pnlEditingItemPedidoLayout.setVerticalGroup(
            pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditingItemPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltroItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto)
                    .addComponent(edtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarProduto)
                    .addComponent(edtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVlrUnt)
                        .addComponent(edtVlrUnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditingItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQtde)
                        .addComponent(lblVlrTotalItemPedido)
                        .addComponent(edtVlrTotalItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(recordEditingItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblCodProduto.getAccessibleContext().setAccessibleName("Código Prod:");

        javax.swing.GroupLayout pnlItemPedidoLayout = new javax.swing.GroupLayout(pnlItemPedido);
        pnlItemPedido.setLayout(pnlItemPedidoLayout);
        pnlItemPedidoLayout.setHorizontalGroup(
            pnlItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTituloItemPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlItemPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEditingItemPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItemPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editConfirmationWithRefreshItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
        );
        pnlItemPedidoLayout.setVerticalGroup(
            pnlItemPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemPedidoLayout.createSequentialGroup()
                .addComponent(lblTituloItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlEditingItemPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(editConfirmationWithRefreshItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlItemPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(pnlPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed
        this.itemPedidoController.requestDisplayProdutoViewForLookUp(this);
    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

    private void btnClienteExpandirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteExpandirActionPerformed
        this.resizeCustomerFields(true);
    }//GEN-LAST:event_btnClienteExpandirActionPerformed

    private void btnClienteReduzirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteReduzirActionPerformed
        this.resizeCustomerFields(false);
    }//GEN-LAST:event_btnClienteReduzirActionPerformed

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        this.pedidoController.requestDisplayClienteViewForLookUp();
    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void btnPesquisarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPedidoActionPerformed
        this.pedidoController.partialSearch(this.edtClienteFiltro.getText(), this.edtDestinatarioFiltro.getText(), 
                this.cmbSttsPagtoFiltro.getSelectedItem().toString().toUpperCase(),
                this.cmbSttsPedidoFiltro.getSelectedItem().toString().toUpperCase());
    }//GEN-LAST:event_btnPesquisarPedidoActionPerformed

    private void btnPesquisarItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarItemPedidoActionPerformed
        this.itemPedidoController.partialSearch(this.edtProdutoFiltro.getText(), this.cmbTipoChocFiltro.getSelectedItem().toString());
    }//GEN-LAST:event_btnPesquisarItemPedidoActionPerformed

    public static void main(String args[]) {
        NimbusTheme.setTheme();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelItemPedido;
    private javax.swing.JButton btnCancelPedido;
    private javax.swing.JButton btnClienteExpandir;
    private javax.swing.JButton btnClienteReduzir;
    private javax.swing.JButton btnDeleteItemPedido;
    private javax.swing.JButton btnDeletePedido;
    private javax.swing.JButton btnInsertItemPedido;
    private javax.swing.JButton btnInsertPedido;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPesquisarItemPedido;
    private javax.swing.JButton btnPesquisarPedido;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JButton btnPostItemPedido;
    private javax.swing.JButton btnPostPedido;
    private javax.swing.JButton btnRefreshItemPedido;
    private javax.swing.JButton btnRefreshPedido;
    private javax.swing.JButton btnUpdateItemPedido;
    private javax.swing.JButton btnUpdatePedido;
    private javax.swing.JCheckBox ckBRetirada;
    private javax.swing.JComboBox<String> cmbMtdPagto;
    private javax.swing.JComboBox<String> cmbSttsPagto;
    private javax.swing.JComboBox<String> cmbSttsPagtoFiltro;
    private javax.swing.JComboBox<String> cmbSttsPedido;
    private javax.swing.JComboBox<String> cmbSttsPedidoFiltro;
    private javax.swing.JComboBox<String> cmbTipoChocFiltro;
    private com.toedter.calendar.JDateChooser dtChooserDtEntrega;
    private com.toedter.calendar.JDateChooser dtChooserDtPedido;
    private javax.swing.JPanel editConfirmationWithRefreshItemPedido;
    private javax.swing.JPanel editConfirmationWithRefreshPedido;
    private javax.swing.JTextField edtCliente;
    private javax.swing.JTextField edtClienteFiltro;
    private javax.swing.JTextField edtCodCliente;
    private javax.swing.JTextField edtCodProduto;
    private javax.swing.JTextField edtDesconto;
    private javax.swing.JTextField edtDestinatario;
    private javax.swing.JTextField edtDestinatarioFiltro;
    private javax.swing.JTextField edtObs;
    private javax.swing.JTextField edtProduto;
    private javax.swing.JTextField edtProdutoFiltro;
    private javax.swing.JTextField edtQtde;
    private javax.swing.JTextField edtSubTotalPedido;
    private javax.swing.JTextField edtVlrTotalItemPedido;
    private javax.swing.JTextField edtVlrTotalPedido;
    private javax.swing.JTextField edtVlrUnt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblClienteFiltro;
    private javax.swing.JLabel lblCodCliente;
    private javax.swing.JLabel lblCodProduto;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblDestinatario;
    private javax.swing.JLabel lblDestinatarioFiltro;
    private javax.swing.JLabel lblDtEntrega;
    private javax.swing.JLabel lblDtPedido;
    private javax.swing.JLabel lblMtdPagto;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblProdutoFiltro;
    private javax.swing.JLabel lblQtde;
    private javax.swing.JLabel lblSttsPagto;
    private javax.swing.JLabel lblSttsPagtoFiltro;
    private javax.swing.JLabel lblSttsPedido;
    private javax.swing.JLabel lblSttsPedidoFiltro;
    private javax.swing.JLabel lblTipoChocFiltro;
    private javax.swing.JLabel lblTituloItemPedido;
    private javax.swing.JLabel lblTituloPedido;
    private javax.swing.JLabel lblVlrTotalItemPedido;
    private javax.swing.JLabel lblVlrUnt;
    private javax.swing.JPanel pnlEditingItemPedido;
    private javax.swing.JPanel pnlEditingPedido;
    private javax.swing.JPanel pnlFiltroItemPedido;
    private javax.swing.JPanel pnlFiltroPedido;
    private javax.swing.JPanel pnlItemPedido;
    private javax.swing.JPanel pnlPedido;
    private javax.swing.JPanel recordEditingItemPedido;
    private javax.swing.JPanel recordEditingPedido;
    private javax.swing.JScrollPane scrlPnItemPedido;
    private javax.swing.JScrollPane scrlPnPedido;
    private javax.swing.JTable tblItemPedido;
    private javax.swing.JTable tblPedido;
    // End of variables declaration//GEN-END:variables
    
    public javax.swing.JButton getBtnCancelItemPedido() {
        return btnCancelItemPedido;
    }

    public javax.swing.JTextField getEdtSubTotalPedido() {
        return edtSubTotalPedido;
    }

    public javax.swing.JTextField getEdtProdutoFiltro() {
        return edtProdutoFiltro;
    }

    public javax.swing.JTextField getEdtVlrUnt() {
        return edtVlrUnt;
    }

    public javax.swing.JTextField getEdtCodProduto() {
        return edtCodProduto;
    }

    public javax.swing.JTextField getEdtProduto() {
        return edtProduto;
    }

    public javax.swing.JTextField getEdtQtde() {
        return edtQtde;
    }

    public javax.swing.JTextField getEdtVlrTotalItemPedido() {
        return edtVlrTotalItemPedido;
    }

    public javax.swing.JComboBox<String> getCmbTipoChocFiltro() {
        return cmbTipoChocFiltro;
    }

    public javax.swing.JComboBox<String> getCmbSttsPagtoFiltro() {
        return cmbSttsPagtoFiltro;
    }

    public javax.swing.JComboBox<String> getCmbSttsPedidoFiltro() {
        return cmbSttsPedidoFiltro;
    }

    public javax.swing.JButton getBtnCancelPedido() {
        return btnCancelPedido;
    }

    public javax.swing.JButton getBtnDeleteItemPedido() {
        return btnDeleteItemPedido;
    }

    public javax.swing.JButton getBtnDeletePedido() {
        return btnDeletePedido;
    }

    public javax.swing.JButton getBtnInsertItemPedido() {
        return btnInsertItemPedido;
    }

    public javax.swing.JButton getBtnInsertPedido() {
        return btnInsertPedido;
    }

    public javax.swing.JButton getBtnPostItemPedido() {
        return btnPostItemPedido;
    }

    public javax.swing.JButton getBtnPostPedido() {
        return btnPostPedido;
    }

    public javax.swing.JButton getBtnRefreshItemPedido() {
        return btnRefreshItemPedido;
    }

    public javax.swing.JButton getBtnRefreshPedido() {
        return btnRefreshPedido;
    }

    public javax.swing.JButton getBtnUpdateItemPedido() {
        return btnUpdateItemPedido;
    }

    public javax.swing.JButton getBtnUpdatePedido() {
        return btnUpdatePedido;
    }

    public javax.swing.JTable getTblItemPedido() {
        return tblItemPedido;
    }

    public javax.swing.JTable getTblPedido() {
        return tblPedido;
    }

    public javax.swing.JComboBox<String> getCmbSttsPedido() {
        return cmbSttsPedido;
    }

    public com.toedter.calendar.JDateChooser getDtChooserDtPedido() {
        return dtChooserDtPedido;
    }

    public javax.swing.JTextField getEdtCodCliente() {
        return edtCodCliente;
    }

    public javax.swing.JTextField getEdtDesconto() {
        return edtDesconto;
    }

    public javax.swing.JTextField getEdtDestinatario() {
        return edtDestinatario;
    }

    public javax.swing.JTextField getEdtDestinatarioFiltro() {
        return edtDestinatarioFiltro;
    }

    public javax.swing.JTextField getEdtObs() {
        return edtObs;
    }

    public javax.swing.JTextField getEdtVlrTotalPedido() {
        return edtVlrTotalPedido;
    }

    public javax.swing.JTextField getEdtCliente() {
        return edtCliente;
    }

    public com.toedter.calendar.JDateChooser getDtChooserDtEntrega() {
        return dtChooserDtEntrega;
    }

    public javax.swing.JComboBox<String> getCmbMtdPagto() {
        return cmbMtdPagto;
    }

    public javax.swing.JComboBox<String> getCmbSttsPagto() {
        return cmbSttsPagto;
    }

    public javax.swing.JCheckBox getCkBRetirada() {
        return ckBRetirada;
    }

    //CÓDIGOS PRÓPRIOS DA CLASSE
     /* A PedidoController é a classe que controla tanto as ações
    relacionada a sua entidade 'Pedido' quanto a ações gerais da view/*/
    private PedidoController pedidoController;
    private ItemPedidoController itemPedidoController;
 
    public PedidoView(PedidoController pedidoController, ItemPedidoController itemPedidoController, JFrame previousView) {
        //Códigos padrões de inicialização da interface
        this.initComponents();
        super.setDefaultViewSettings("Cadastro de Pedidos", previousView);
        this.pedidoController = pedidoController; 
        this.itemPedidoController = itemPedidoController; 
            
        /*Por padrão os campos da tabela referentes ao cliente vem reduzidos */
        this.resizeCustomerFields(false);
    }

    public void setItemPedidoController(ItemPedidoController itemPedidoController) {
        this.itemPedidoController = itemPedidoController;
    }

    /*Método que regula o tamanho dos campos da tabela de pesquisa referentes ao clientes com o propósito de não mostrar
    todas as informações do cliente na tabela de pesquisa, mas sim apenas o nome. Caso o usuário queira ver todas as
    informações do cliente, ele deve clicar no botão "Expandir informações do "cliente" na área de pesquisa. Caso queira
    reduzir novamente, basta clicar no botão "Reduzir". O sistema tratará de redimensionar as colunas da tabela*/
    public final void resizeCustomerFields(boolean expand) {
        //Tamanho que as colunas terão após serem redimensionadas
        int newColumnWidth = 10;

        //Capturando cada coluna que será redimensionada
        javax.swing.table.TableColumn clTelefones = this.tblPedido.getColumnModel().getColumn(2);
        javax.swing.table.TableColumn clEndereco = this.tblPedido.getColumnModel().getColumn(3);
        javax.swing.table.TableColumn clLinkEndereco = this.tblPedido.getColumnModel().getColumn(4);
   
        //Verificando se o usuário quer expandir ou reduzir os campos
        if (expand) {
            //Expandindo as colunas
            clTelefones.setPreferredWidth(80);
            clEndereco.setPreferredWidth(180);
            clLinkEndereco.setPreferredWidth(180);
        } else {
            //Reduzindo as colunas
            clTelefones.setPreferredWidth(newColumnWidth);
            clEndereco.setPreferredWidth(newColumnWidth);
            clLinkEndereco.setPreferredWidth(newColumnWidth);  
        }
    }
}
