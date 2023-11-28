package edu.ifmt.confeitaria.layers.models.cliente;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class Cliente extends SuperModel {
    private String nome;
    private String CPF;
    private String telefones;
    private String endereco;
    private String linkEndereco;

    /* Construtor vazio para configurações do DatabaseAcessComponentManager */
    public Cliente() {
        super(null);
    }

    public Cliente(Long ID, String nome, String CPF, String telefones, String endereco, String linkEndereco) {
        super(ID);
        this.nome = nome;
        this.CPF = CPF;
        this.telefones = telefones;
        this.endereco = endereco;
        this.linkEndereco = linkEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf) {
        this.CPF = cpf;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLinkEndereco() {
        return linkEndereco;
    }

    public void setLinkEndereco(String link_endereco) {
        this.linkEndereco = link_endereco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
        result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((linkEndereco == null) ? 0 : linkEndereco.hashCode());
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
        Cliente other = (Cliente) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (CPF == null) {
            if (other.CPF != null)
                return false;
        } else if (!CPF.equals(other.CPF))
            return false;
        if (telefones == null) {
            if (other.telefones != null)
                return false;
        } else if (!telefones.equals(other.telefones))
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        if (linkEndereco == null) {
            if (other.linkEndereco != null)
                return false;
        } else if (!linkEndereco.equals(other.linkEndereco))
            return false;
        return true;
    }
}
