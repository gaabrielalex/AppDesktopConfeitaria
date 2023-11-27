package edu.ifmt.confeitaria.layers.models.item_pedido;

import java.math.BigDecimal;

import edu.ifmt.confeitaria.layers.models.pedido.Pedido;
import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class ItemPedido extends SuperModel {
    private int qtde;
    private BigDecimal vlrTotalItem;
    private Pedido pedido;
    private Produto produto;

    /* Construtor vazio para configurações do DatabaseAcessComponentManager */
    public ItemPedido() {
        super(null);
    }

}