/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.layers.models.cliente.ClienteService;
import edu.ifmt.confeitaria.layers.models.usuario.UsuarioService;
import edu.ifmt.confeitaria.layers.views.data_management.ClienteView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class ClienteController extends SuperController<Cliente> {
    private final ClienteView clienteView;
    private final ClienteService clienteService;
    private DatabaseAccessComponentManager<Cliente> clienteDBCManager;
    
    public ClienteController(JFrame previousView, ClienteService clienteService, DatabaseAccessComponentManager clienteDBCManager) {
        //Injeção de dependências
        this.clienteService = clienteService;
        this.clienteDBCManager = clienteDBCManager;

        //Instancia a View e define esta instância como seu controlador
        this.clienteView = new ClienteView(this, previousView);

        //Configurando o DatabaseAccessComponentManager
        List<Component> fields = Arrays.asList(clienteView.getEdtNome(), clienteView.getEdtCPF(), 
            clienteView.getEdtTelefones(), clienteView.getEdtEndereco(), clienteView.getEdtLinkEnd());
        this.clienteDBCManager.setFields(fields);
        this.clienteDBCManager.configureComponents(null, this, null, clienteView.getBtnInsert(),
            clienteView.getBtnUpdate(), clienteView.getBtnDelete(), clienteView.getBtnPost(),
            clienteView.getBtnCancel(), clienteView.getBtnRefresh(), clienteView.getTblCliente());
    }
    
    @Override
    public void displayView() {
        this.clienteView.setVisible(true);
    }
    
    public void displayViewForLookUp() {
        //Configurações obrigatórias
        this.clienteView.setTitle("Pesquisa de Clientes");
        this.clienteView.setResizable(false);
        this.clienteView.setSize(this.clienteView.getWidth(), 360);

        //Exibe a view
        this.displayView();
    }

    @Override
    public Object[] modelToTableRow(Object object) {
        // TODO Auto-generated method stub
       return null;
    }

    @Override
    public void modelToFields(Object object) {
        // TODO Auto-generated method stub
    }

    @Override
    public Object fieldsToModel() {
        // TODO Auto-generated method stub
        return null;
    }

}
