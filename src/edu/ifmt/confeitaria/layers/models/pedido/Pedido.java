package edu.ifmt.confeitaria.layers.models.pedido;

import java.math.BigDecimal;
import java.util.Date;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class Pedido extends SuperModel {

    enum StatusPagto {
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

    enum StatusPedido {
        PENDENTE, EM_PREPARO, PRONTO, ENTREGUE, CANCELADO
    }

    private Date dtHrPedido;
    private Date dtHrEntrega;
    private BigDecimal vlrTotalPedido;
    private BigDecimal desconto;
    private String nomeDestinatario;
    private boolean retiradaLoja;
    private char statusPagto;
    private char statusPedido;
    private String observacoes;
    private Long idCliente;
    private Long idMetodoPagto;
    private Long idUsuario;

    /* Construtor vazio para configurações do DatabaseAcessComponentManager */
    public Pedido() {
        super(null);
    }

    public Pedido(Long ID, Date dtHrPedido, Date dtHrEntrega, BigDecimal vlrTotalPedido, BigDecimal desconto,
            String nomeDestinatario, boolean retiradaLoja, char statusPagto, char statusPedido, String observacoes,
            Long idCliente, Long idMetodoPagto, Long idUsuario) {
        super(ID);
        this.dtHrPedido = dtHrPedido;
        this.dtHrEntrega = dtHrEntrega;
        this.vlrTotalPedido = vlrTotalPedido;
        this.desconto = desconto;
        this.nomeDestinatario = nomeDestinatario;
        this.retiradaLoja = retiradaLoja;
        this.statusPagto = statusPagto;
        this.statusPedido = statusPedido;
        this.observacoes = observacoes;
        this.idCliente = idCliente;
        this.idMetodoPagto = idMetodoPagto;
        this.idUsuario = idUsuario;
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

    public char getStatusPagto() {
        return statusPagto;
    }

    public void setStatusPagto(char statusPagto) {
        this.statusPagto = statusPagto;
    }

    public char getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(char statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdMetodoPagto() {
        return idMetodoPagto;
    }

    public void setIdMetodoPagto(Long idMetodoPagto) {
        this.idMetodoPagto = idMetodoPagto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
