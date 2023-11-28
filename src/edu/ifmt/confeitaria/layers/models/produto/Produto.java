package edu.ifmt.confeitaria.layers.models.produto;

import java.math.BigDecimal;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class Produto extends SuperModel {
    private String descricao;
    private BigDecimal vlrUnitario;
    private String observacoes;
    private String tipoChocolate;

    /* Construtor vazio para configurações do DatabaseAcessComponentManager */
    public Produto() {
        super(null);
    }

    public Produto(Long ID, String descricao, BigDecimal vlrUnitario, String observacoes, String tipoChocolate) {
        super(ID);
        this.descricao = descricao;
        this.vlrUnitario = vlrUnitario;
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
        return vlrUnitario;
    }

    public void setVlrUnitario(BigDecimal vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((vlrUnitario == null) ? 0 : vlrUnitario.hashCode());
        result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
        result = prime * result + ((tipoChocolate == null) ? 0 : tipoChocolate.hashCode());
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
        Produto other = (Produto) obj;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (vlrUnitario == null) {
            if (other.vlrUnitario != null)
                return false;
        } else if (!vlrUnitario.equals(other.vlrUnitario))
            return false;
        if (observacoes == null) {
            if (other.observacoes != null)
                return false;
        } else if (!observacoes.equals(other.observacoes))
            return false;
        if (tipoChocolate == null) {
            if (other.tipoChocolate != null)
                return false;
        } else if (!tipoChocolate.equals(other.tipoChocolate))
            return false;
        return true;
    }

    
}
