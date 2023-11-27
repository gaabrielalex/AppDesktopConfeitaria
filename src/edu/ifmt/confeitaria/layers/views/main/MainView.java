package edu.ifmt.confeitaria.layers.views.main;

import javax.swing.Box;

import edu.ifmt.confeitaria.layers.controllers.data_management.ClienteController;
import edu.ifmt.confeitaria.layers.controllers.data_management.PedidoController;
import edu.ifmt.confeitaria.layers.controllers.data_management.ProdutoController;
import edu.ifmt.confeitaria.layers.controllers.data_management.UsuarioController;
import edu.ifmt.confeitaria.layers.controllers.main.MainController;
import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.layers.models.cliente.ClienteDAO;
import edu.ifmt.confeitaria.layers.models.cliente.ClienteService;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido;
import edu.ifmt.confeitaria.layers.models.pedido.PedidoDAO;
import edu.ifmt.confeitaria.layers.models.pedido.PedidoService;
import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoDAO;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoService;
import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.layers.models.usuario.UsuarioService;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperView;
import edu.ifmt.confeitaria.util.themes.NimbusTheme;

public class MainView extends SuperView {

    private MainView() {
        this.initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoImage = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnCadastros = new javax.swing.JMenu();
        mnItemCliente = new javax.swing.JMenuItem();
        mnItemPedido = new javax.swing.JMenuItem();
        mnItemProduto = new javax.swing.JMenuItem();
        mnItemUsuario = new javax.swing.JMenuItem();
        mnRelatorios = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenu();
        mnApresentacaoUsuario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        logoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ifmt/confeitaria/assets/images/logos/logo9-large.jpg"))); // NOI18N

        menuBar.setToolTipText("");
        menuBar.setName(""); // NOI18N

        mnCadastros.setText("Cadastros");

        mnItemCliente.setText("Cliente");
        mnItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemClienteActionPerformed(evt);
            }
        });
        mnCadastros.add(mnItemCliente);

        mnItemPedido.setText("Pedido");
        mnItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemPedidoActionPerformed(evt);
            }
        });
        mnCadastros.add(mnItemPedido);

        mnItemProduto.setText("Produto");
        mnItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemProdutoActionPerformed(evt);
            }
        });
        mnCadastros.add(mnItemProduto);

        mnItemUsuario.setText("Usuário");
        mnItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemUsuarioActionPerformed(evt);
            }
        });
        mnCadastros.add(mnItemUsuario);
        mnItemUsuario.getAccessibleContext().setAccessibleDescription("");

        menuBar.add(mnCadastros);

        mnRelatorios.setText("Relatórios");
        menuBar.add(mnRelatorios);

        mnSair.setText("Sair");
        mnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnSairMouseClicked(evt);
            }
        });
        menuBar.add(mnSair);

        mnApresentacaoUsuario.setText("Bem-Vindo, Usuário??????????????!");
        mnApresentacaoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mnApresentacaoUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        menuBar.add(mnApresentacaoUsuario);

        setJMenuBar(menuBar);
        menuBar.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(logoImage)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(logoImage)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemUsuarioActionPerformed
        this.mainController.requestDisplayMenuItemView(new UsuarioController(this, UsuarioService.getInstance(), new DatabaseAccessComponentManager<Usuario>()));
    }//GEN-LAST:event_mnItemUsuarioActionPerformed

    private void mnItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemClienteActionPerformed
        this.mainController.requestDisplayMenuItemView(new ClienteController(this, new ClienteService(new ClienteDAO()), new DatabaseAccessComponentManager<Cliente>()));
    }//GEN-LAST:event_mnItemClienteActionPerformed

    private void mnItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemProdutoActionPerformed
        this.mainController.requestDisplayMenuItemView(new ProdutoController(this, new ProdutoService(new ProdutoDAO()), new DatabaseAccessComponentManager<Produto>()));
    }//GEN-LAST:event_mnItemProdutoActionPerformed

    private void mnItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemPedidoActionPerformed
        this.mainController.requestDisplayMenuItemView(new PedidoController(this, new PedidoService(new PedidoDAO()) ,new DatabaseAccessComponentManager<Pedido>()));
    }//GEN-LAST:event_mnItemPedidoActionPerformed

    private void mnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSairMouseClicked
        this.mainController.requestUserSignOut();
    }//GEN-LAST:event_mnSairMouseClicked
    
    public static void main(String args[]) {
        NimbusTheme.setTheme();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel logoImage;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnApresentacaoUsuario;
    private javax.swing.JMenu mnCadastros;
    private javax.swing.JMenuItem mnItemCliente;
    private javax.swing.JMenuItem mnItemPedido;
    private javax.swing.JMenuItem mnItemProduto;
    private javax.swing.JMenuItem mnItemUsuario;
    private javax.swing.JMenu mnRelatorios;
    private javax.swing.JMenu mnSair;
    // End of variables declaration//GEN-END:variables
 
    //CÓDIGOS PRÓPRIOS DA CLASSE
    private MainController mainController; 
    
    public MainView(MainController mainController) {
        //Códigos padrões de inicialização da interface
        this.initComponents();
        super.setDefaultViewSettings("Confeitaria: Gerenciamento de Pedidos", null);
        this.mainController = mainController; 

        //Adiciona um espaço vazio na barra de menu para que o nome do usuário fique alinhado à direita
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(this.mnApresentacaoUsuario);
 
        //Seta o nome do usuário na barra de menu 
        UsuarioService.getInstance().getLoggedUser().subscribe(this::setUserName);
    }

    private void setUserName(Usuario usuario) {
        this.mnApresentacaoUsuario.setText("Bem-Vindo, " + usuario.getNome() + "!");
    }

}
