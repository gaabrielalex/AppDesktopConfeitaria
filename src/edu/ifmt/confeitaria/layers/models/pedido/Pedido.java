package edu.ifmt.confeitaria.layers.models.pedido;

import java.math.BigDecimal;
import java.util.Date;

import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class Pedido extends SuperModel {
    public enum StatusPagto {
        ABERTO('A'),
        PAGO('P');

        private char descricao;

        StatusPagto(char descricao) {
            this.descricao = descricao;
        }

        public char getDescricao() {
            return descricao;
        }
    }

    public enum StatusPedido {
        ATIVO('A'),
        CANCELADO('C'),
        ENTREGUE('E'),
        PRONTO('P');

        private char descricao;

        StatusPedido(char descricao) {
            this.descricao = descricao;
        }

        public char getDescricao() {
            return descricao;
        }        
    }

    private Usuario usuario;
    private Cliente cliente;
    private Date dtHrPedido;
    private Date dtHrEntrega;
    private BigDecimal vlrTotalPedido;
    private BigDecimal desconto;
    private String nomeDestinatario;
    private boolean retiradaLoja;
    private StatusPagto statusPagto;
    private StatusPedido statusPedido;
    private String observacoes;
    private String metodoPagto;

    /* Construtor vazio para configurações do DatabaseAcessComponentManager */
    public Pedido() {
        super(null);
    }

    public Pedido(Long ID, Usuario usuario, Cliente cliente, Date dtHrPedido, Date dtHrEntrega,
            BigDecimal vlrTotalPedido, BigDecimal desconto, String nomeDestinatario, boolean retiradaLoja,
            StatusPagto statusPagto, StatusPedido statusPedido, String observacoes, String metodoPagto) {
        super(ID);
        this.usuario = usuario;
        this.cliente = cliente;
        this.dtHrPedido = dtHrPedido;
        this.dtHrEntrega = dtHrEntrega;
        this.vlrTotalPedido = vlrTotalPedido;
        this.desconto = desconto;
        this.nomeDestinatario = nomeDestinatario;
        this.retiradaLoja = retiradaLoja;
        this.statusPagto = statusPagto;
        this.statusPedido = statusPedido;
        this.observacoes = observacoes;
        this.metodoPagto = metodoPagto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDtHrPedido() {
        return dtHrPedido;
    }

    public void setDtHrPedido(Date dtHrPedido) {
        this.dtHrPedido = dtHrPedido;
    }

    public Date getDtHrEntrega() {
        return dtHrEntrega;
    }

    public void setDtHrEntrega(Date dtHrEntrega) {
        this.dtHrEntrega = dtHrEntrega;
    }

    public BigDecimal getVlrTotalPedido() {
        return vlrTotalPedido;
    }

    public void setVlrTotalPedido(BigDecimal vlrTotalPedido) {
        this.vlrTotalPedido = vlrTotalPedido;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public boolean isRetiradaLoja() {
        return retiradaLoja;
    }

    public void setRetiradaLoja(boolean retiradaLoja) {
        this.retiradaLoja = retiradaLoja;
    }

    public StatusPagto getStatusPagto() {
        return statusPagto;
    }

    public void setStatusPagto(StatusPagto statusPagto) {
        this.statusPagto = statusPagto;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getMetodoPagto() {
        return metodoPagto;
    }

    public void setMetodoPagto(String metodoPagto) {
        this.metodoPagto = metodoPagto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((dtHrPedido == null) ? 0 : dtHrPedido.hashCode());
        result = prime * result + ((dtHrEntrega == null) ? 0 : dtHrEntrega.hashCode());
        result = prime * result + ((vlrTotalPedido == null) ? 0 : vlrTotalPedido.hashCode());
        result = prime * result + ((desconto == null) ? 0 : desconto.hashCode());
        result = prime * result + ((nomeDestinatario == null) ? 0 : nomeDestinatario.hashCode());
        result = prime * result + (retiradaLoja ? 1231 : 1237);
        result = prime * result + ((statusPagto == null) ? 0 : statusPagto.hashCode());
        result = prime * result + ((statusPedido == null) ? 0 : statusPedido.hashCode());
        result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
        result = prime * result + ((metodoPagto == null) ? 0 : metodoPagto.hashCode());
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
        Pedido other = (Pedido) obj;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (dtHrPedido == null) {
            if (other.dtHrPedido != null)
                return false;
        } else if (!dtHrPedido.equals(other.dtHrPedido))
            return false;
        if (dtHrEntrega == null) {
            if (other.dtHrEntrega != null)
                return false;
        } else if (!dtHrEntrega.equals(other.dtHrEntrega))
            return false;
        if (vlrTotalPedido == null) {
            if (other.vlrTotalPedido != null)
                return false;
        } else if (!vlrTotalPedido.equals(other.vlrTotalPedido))
            return false;
        if (desconto == null) {
            if (other.desconto != null)
                return false;
        } else if (!desconto.equals(other.desconto))
            return false;
        if (nomeDestinatario == null) {
            if (other.nomeDestinatario != null)
                return false;
        } else if (!nomeDestinatario.equals(other.nomeDestinatario))
            return false;
        if (retiradaLoja != other.retiradaLoja)
            return false;
        if (statusPagto != other.statusPagto)
            return false;
        if (statusPedido != other.statusPedido)
            return false;
        if (observacoes == null) {
            if (other.observacoes != null)
                return false;
        } else if (!observacoes.equals(other.observacoes))
            return false;
        if (metodoPagto == null) {
            if (other.metodoPagto != null)
                return false;
        } else if (!metodoPagto.equals(other.metodoPagto))
            return false;
        return true;
    }
}
