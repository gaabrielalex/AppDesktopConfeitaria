/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.ifmt.confeitaria.layers.views.main;

import edu.ifmt.confeitaria.layers.controllers.data_management.ClienteController;
import edu.ifmt.confeitaria.layers.controllers.data_management.PedidoController;
import edu.ifmt.confeitaria.layers.controllers.data_management.ProdutoController;
import edu.ifmt.confeitaria.layers.controllers.data_management.UsuarioController;
import edu.ifmt.confeitaria.layers.controllers.main.MainController;
import edu.ifmt.confeitaria.layers.models.usuario.UsuarioDAO;
import edu.ifmt.confeitaria.layers.models.usuario.UsuarioService;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperView;

import javax.swing.Box;

/**
 *
 * @author Gabriel
 */
public class MainView extends SuperView {

    /**
     * Creates new form MainView
     */
    private MainView() {
        this.initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
        this.mainController.requestDisplayMenuItemView(new UsuarioController(this, new UsuarioService(new UsuarioDAO())));
    }//GEN-LAST:event_mnItemUsuarioActionPerformed

    private void mnItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemClienteActionPerformed
        this.mainController.requestDisplayMenuItemView(new ClienteController(this));
    }//GEN-LAST:event_mnItemClienteActionPerformed

    private void mnItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemProdutoActionPerformed
        this.mainController.requestDisplayMenuItemView(new ProdutoController(this));
    }//GEN-LAST:event_mnItemProdutoActionPerformed

    private void mnItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemPedidoActionPerformed
        this.mainController.requestDisplayMenuItemView(new PedidoController(this));
    }//GEN-LAST:event_mnItemPedidoActionPerformed
    
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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
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
    //Atributos
    private MainController mainController; 
    
    //Constructors
    //Constutor público para ser chamado pelo main da aplicação fazendo as devidas injeções de dependência
    public MainView(MainController mainController) {       
        //Default codes
        this.initComponents();
        super.setDefaultViewSettings("Confeitaria: Gerenciamento de Pedidos", null);
        
        //Handling Code
        this.mainController = mainController; 
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(this.mnApresentacaoUsuario);
    }
    
    //Getters e Setters
    
    //Métodos

}
