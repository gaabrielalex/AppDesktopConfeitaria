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

    public ItemPedido(Long ID, int qtde, BigDecimal vlrTotalItem, Pedido pedido, Produto produto) {
        super(ID);
        this.qtde = qtde;
        this.vlrTotalItem = vlrTotalItem;
        this.pedido = pedido;
        this.produto = produto;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getVlrTotalItem() {
        return vlrTotalItem;
    }

    public void setVlrTotalItem(BigDecimal vlrTotalItem) {
        this.vlrTotalItem = vlrTotalItem;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}