package edu.ifmt.confeitaria.layers.models.pedido;

import java.math.BigDecimal;
import java.util.Date;

import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class Pedido extends SuperModel {
    public enum StatusPagto {
        PAGO('P'),
        ABERTO('A');

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
        PRONTO('P'),
        ENTREGUE('E'),
        CANCELADO('C');

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
        metodoPagto = metodoPagto;
    }
}
