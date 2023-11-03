package edu.ifmt.confeitaria.layers.models.produto;

import java.math.BigDecimal;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class Produto extends SuperModel {
    private String descricao;
    private BigDecimal VlrUnitario;
    private String observacoes;
    private String tipo_chocolate;

    /* Construtor vazio para configurações do DatabaseAcessComponentManager */
    public Produto() {
        super(null);
    }

    public Produto(Long ID, String descricao, BigDecimal vlrUnitario, String observacoes, String tipo_chocolate) {
        super(ID);
        this.descricao = descricao;
        VlrUnitario = vlrUnitario;
        this.observacoes = observacoes;
        this.tipo_chocolate = tipo_chocolate;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getVlrUnitario() {
        return VlrUnitario;
    }

    public void setVlrUnitario(BigDecimal vlrUnitario) {
        VlrUnitario = vlrUnitario;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getTipo_chocolate() {
        return tipo_chocolate;
    }

    public void setTipo_chocolate(String tipo_chocolate) {
        this.tipo_chocolate = tipo_chocolate;
    }

}
