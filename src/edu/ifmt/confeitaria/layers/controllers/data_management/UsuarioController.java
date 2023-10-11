/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.layers.models.usuario.UsuarioService;
import edu.ifmt.confeitaria.layers.views.data_management.UsuarioView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperView;
import edu.ifmt.confeitaria.util.services.ValidationResponses;
import edu.ifmt.confeitaria.util.views.ViewUtils;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.text.View;

/**
 *
 * @author Gabriel
 */
public class UsuarioController extends SuperController<Usuario> {
    private final UsuarioView usuarioView;
    private final UsuarioService usuarioService;
    private DatabaseAccessComponentManager<Usuario> usuarioDBCManager;
    
    public UsuarioController(JFrame previousView, UsuarioService usuarioService, DatabaseAccessComponentManager<Usuario> usuarioDBCManager) {
        //Injeção de dependências
        this.usuarioService = usuarioService;
        this.usuarioDBCManager = usuarioDBCManager;

        //Instancia a View e define esta instância como seu controlador
        this.usuarioView = new UsuarioView(this, previousView);

        //Configurando o DatabaseAccessComponentManager
        List<Component> fields = Arrays.asList(usuarioView.getEdtCodUsuario(), usuarioView.getEdtNome(), usuarioView.getEdtLogin(), usuarioView.getPswdSenha());;
        this.usuarioDBCManager.setFields(fields);
        this.usuarioDBCManager.configureComponents(Usuario.class, this, this.usuarioService, usuarioView.getBtnInsert(),
            usuarioView.getBtnUpdate(),usuarioView.getBtnDelete(), usuarioView.getBtnPost(),
            usuarioView.getBtnCancel(), usuarioView.getBtnRefresh(), usuarioView.getTblUsuario());

        //Adicionando as validações aos campos
        ViewUtils.addTextChangeListeners(this.usuarioView.getEdtCodUsuario(), this::validateCodUsuarioField);
        ViewUtils.addTextChangeListeners(this.usuarioView.getEdtNome(), this::validateNomeField);
        ViewUtils.addTextChangeListeners(this.usuarioView.getEdtLogin(), this::validateLoginField);
        ViewUtils.addTextChangeListeners(this.usuarioView.getPswdSenha(), this::validateSenhaField);

        //Cor inicial dos labels de validação
        this.usuarioView.getLblCodUsuarioValidation().setForeground(SuperView.DEFAULT_BACKGROUND_COLOR);
        this.usuarioView.getLblNomeValidation().setForeground(SuperView.DEFAULT_BACKGROUND_COLOR);
        this.usuarioView.getLblLoginValidation().setForeground(SuperView.DEFAULT_BACKGROUND_COLOR);
        this.usuarioView.getLblSenhaValidation().setForeground(SuperView.DEFAULT_BACKGROUND_COLOR);
    }

    @Override
    public void displayView () {
        this.usuarioView.setVisible(true);
    }

    public void partialSearch(String nome, String login) {
        this.usuarioDBCManager.setTemporaryTDataList(this.usuarioService.partialSearch(nome, login));
    }

    @Override
    public Object[] modelToTableRow(Usuario usuario){
        return new Object[]{
            usuario.getID(), 
            usuario.getNome(),
            usuario.getLogin(),
            usuario.getSenha()
        };
    }

    @Override
    public void modelToFields(Usuario usuario) {
        if(usuario.getID() == null) {
            this.usuarioView.getEdtCodUsuario().setText("");
        } else { 
            this.usuarioView.getEdtCodUsuario().setText(usuario.getID().toString());
        }
        this.usuarioView.getEdtNome().setText(usuario.getNome());
        this.usuarioView.getEdtLogin().setText(usuario.getLogin());
        this.usuarioView.getPswdSenha().setText(usuario.getSenha());
    }

    @Override
    public Usuario fieldsToModel() {
        return new Usuario(
            this.usuarioView.getEdtCodUsuario().getText().isEmpty() ? null : Long.parseLong(this.usuarioView.getEdtCodUsuario().getText()),
            this.usuarioView.getEdtNome().getText(),
            this.usuarioView.getEdtLogin().getText(),
            new String(this.usuarioView.getPswdSenha().getPassword())
        );
    }

    public void validateNomeField() {
        //Se o usuário estiver inserindo um novo registro ou atualizando um registro existente, o nome é validado
        if(this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.INSERT 
                || this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.UPDATE) {
            
            String nome = this.usuarioView.getEdtNome().getText();
            ValidationResponses response = this.usuarioService.validateNome(nome);
                    
            switch(response) {
                case REQUIRED_FIELD:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblNomeValidation(), "Campo obrigatório !!!");
                    break;
                case MIN_LENGTH_NOT_REACHED:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblNomeValidation(), "Limite mín. de " + UsuarioService.NOME_MIN_LENGTH + " caracteres !!!");
                    break;
                case MAX_LENGTH_EXCEEDED:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblNomeValidation(), "Limite máx. de " + UsuarioService.NOME_MAX_LENGTH + " caracteres !!!");
                    break;
                case VALID:
                    ViewUtils.setLabelOnSuccessValidation(this.usuarioView.getLblNomeValidation());
                    break;
                default:
                    break;
            }
        } else {
            ViewUtils.setLabelOnSuccessValidation(this.usuarioView.getLblNomeValidation());
        }
    }

    public void validateCodUsuarioField() {
        //Se o campo não estiver vazio e o usuário estiver inserindo um novo registro ou atualizando um registro existente, o código(ID) é validado
        if(!this.usuarioView.getEdtCodUsuario().getText().isEmpty() && (this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.INSERT
                || this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.UPDATE)) {
            /*Tenta converter o texto do campo para um número inteiro, sendo possível, o código(ID) é validado*/
            try {
                Long id = Long.parseLong(this.usuarioView.getEdtCodUsuario().getText());
                Long originalID = this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.UPDATE 
                        ? this.usuarioDBCManager.getTSelectedRecord().getValue().getID() : null;

                ValidationResponses response = this.usuarioService.validateID(id, originalID);
                
                switch(response) {
                    case BELOW_MIN_VALUE:
                        ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblCodUsuarioValidation(), "Código inválido !!!");
                        break;
                    case MAX_VALUE_EXCEEDED:
                        ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblCodUsuarioValidation(), "Limite máx. excedido !!!");
                        break;
                    case ALREADY_EXISTS:
                        ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblCodUsuarioValidation(), "Código já existente !!!");
                        break;
                    case VALID:
                        ViewUtils.setLabelOnSuccessValidation(this.usuarioView.getLblCodUsuarioValidation());
                        break;
                    default:
                        break;
                }
            } catch(NumberFormatException e) {
                //Se houver erro na conversão, então o código(ID) é inválido
                ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblCodUsuarioValidation(), "Código inválido !!!");
            }
        } else {
            ViewUtils.setLabelOnSuccessValidation(this.usuarioView.getLblCodUsuarioValidation());
        }
    }

    public void validateLoginField() {
        //Se o usuário estiver inserindo um novo registro ou atualizando um registro existente, o login é validado
        if(this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.INSERT 
                || this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.UPDATE) {
            
            String login = this.usuarioView.getEdtLogin().getText();
            String originalLogin = this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.UPDATE
                ? this.usuarioDBCManager.getTSelectedRecord().getValue().getLogin() : null;

            ValidationResponses response = this.usuarioService.validateLogin(login, originalLogin);
                    
            switch(response) {
                case REQUIRED_FIELD:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblLoginValidation(), "Campo obrigatório !!!");
                    break;
                case MIN_LENGTH_NOT_REACHED:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblLoginValidation(), "Limite mín. de " + UsuarioService.LOGIN_MIN_LENGTH + " caracteres !!!");
                    break;
                case MAX_LENGTH_EXCEEDED:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblLoginValidation(), "Limite máx. de " + UsuarioService.LOGIN_MAX_LENGTH + " caracteres !!!");
                    break;
                case ALREADY_EXISTS:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblLoginValidation(), "Login já existente !!!");
                    break;
                case VALID:
                    ViewUtils.setLabelOnSuccessValidation(this.usuarioView.getLblLoginValidation());
                    break;
                default:
                    break;
            }
        } else {
            ViewUtils.setLabelOnSuccessValidation(this.usuarioView.getLblLoginValidation());
        }
    }

    public void validateSenhaField() {
        //Se o usuário estiver inserindo um novo registro ou atualizando um registro existente, a senha é validada
        if(this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.INSERT 
                || this.usuarioDBCManager.getCurrentOperation() == DatabaseAccessComponentManager.Operation.UPDATE) {
            
            String senha = new String(this.usuarioView.getPswdSenha().getPassword());
            ValidationResponses response = this.usuarioService.validateSenha(senha);
                    
            switch(response) {
                case REQUIRED_FIELD:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblSenhaValidation(), "Campo obrigatório !!!");
                    break;
                case MIN_LENGTH_NOT_REACHED:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblSenhaValidation(), "Limite mín. de " + UsuarioService.SENHA_MIN_LENGTH + " caracteres !!!");
                    break;
                case MAX_LENGTH_EXCEEDED:
                    ViewUtils.setLabelOnErrorValidation(this.usuarioView.getLblSenhaValidation(), "Limite máx. de " + UsuarioService.SENHA_MAX_LENGTH + " caracteres !!!");
                    break;
                case VALID:
                    ViewUtils.setLabelOnSuccessValidation(this.usuarioView.getLblSenhaValidation());
                    break;
                default:
                    break;
            }
        } else {
            ViewUtils.setLabelOnSuccessValidation(this.usuarioView.getLblSenhaValidation());
        }
    } 

}
