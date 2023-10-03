/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import java.util.List;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

/**
 *
 * @author Gabriel
 */
public class ItemPedidoController extends SuperController {

    /* O método displey view não faz nada, pois a view em que a entidade
     do sistema 'item pedido' está inserida, é a view do pedido (por se 
    tratar de um mestre detalhe), logo, quem é resposável por exibir a 
    interface do pedido, é a controller da entidade principal desta view, 
    a controller do 'pedido'*/
    @Override
    public void displayView() {}
    
    public void requestDisplayProdutoViewForLookUp(JFrame current) {
        new ProdutoController(current).displayViewForLookUp();
    }

    @Override
    public List<?> select() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> remakeLastSelect() {
        // TODO Auto-generated method stub
        return null;
    }

}
