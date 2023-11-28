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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + qtde;
        result = prime * result + ((vlrTotalItem == null) ? 0 : vlrTotalItem.hashCode());
        result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemPedido other = (ItemPedido) obj;
        if (qtde != other.qtde)
            return false;
        if (vlrTotalItem == null) {
            if (other.vlrTotalItem != null)
                return false;
        } else if (!vlrTotalItem.equals(other.vlrTotalItem))
            return false;
        if (pedido == null) {
            if (other.pedido != null)
                return false;
        } else if (!pedido.equals(other.pedido))
            return false;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        return true;
    }
}
