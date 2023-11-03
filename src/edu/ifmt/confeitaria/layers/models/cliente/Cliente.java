package edu.ifmt.confeitaria.layers.models.cliente;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class Cliente extends SuperModel {
    private String nome;
    private String CPF;
    private String telefones;
    private String endereco;
    private String link_endereco;

    /* Construtor vazio para configurações do DatabaseAcessComponentManager */
    public Cliente() {
        super(null);
    }

    public Cliente(Long ID, String nome, String CPF, String telefones, String endereco, String link_endereco) {
        super(ID);
        this.nome = nome;
        this.CPF = CPF;
        this.telefones = telefones;
        this.endereco = endereco;
        this.link_endereco = link_endereco;
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

    public String getLink_endereco() {
        return link_endereco;
    }

    public void setLink_endereco(String link_endereco) {
        this.link_endereco = link_endereco;
    }
}
