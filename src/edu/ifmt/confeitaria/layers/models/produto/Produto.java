package edu.ifmt.confeitaria.layers.models.produto;

import java.math.BigDecimal;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class Produto extends SuperModel {
    private String descricao;
    private BigDecimal VlrUnitario;
    private String observacoes;
    private String tipoChocolate;

    /* Construtor vazio para configurações do DatabaseAcessComponentManager */
    public Produto() {
        super(null);
    }

    public Produto(Long ID, String descricao, BigDecimal vlrUnitario, String observacoes, String tipoChocolate) {
        super(ID);
        this.descricao = descricao;
        VlrUnitario = vlrUnitario;
        this.observacoes = observacoes;
        this.tipoChocolate = tipoChocolate;
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

    public String getTipoChocolate() {
        return tipoChocolate;
    }

    public void setTipoChocolate(String tipo_chocolate) {
        this.tipoChocolate = tipo_chocolate;
    }

}
