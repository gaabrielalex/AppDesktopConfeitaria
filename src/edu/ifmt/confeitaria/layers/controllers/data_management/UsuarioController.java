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

import java.util.List;

import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class UsuarioController extends SuperController<Usuario> {
    private final UsuarioView usuarioView;
    private final UsuarioService usuarioService;
    
    public UsuarioController (JFrame previousView, UsuarioService usuarioService) {
        //Injectons
        this.usuarioService = usuarioService;
        
        this.usuarioView = new UsuarioView(this, new DatabaseAccessComponentManager<Usuario>(),previousView);
    }

    @Override
    public void displayView () {
        this.usuarioView.setVisible(true);
    }

    /* ----- Métodos principais de manipulação de dados ----- */
    @Override
    public List<Usuario> select() {
        return this.usuarioService.select();
    }
    
    public List<Usuario> select(String nome, String login) {
        return this.usuarioService.select(nome, login);
    }

    @Override
    public List<Usuario> remakeLastSelect(){
        return this.usuarioService.remakeLastSelect();
    }

    @Override
    public boolean insert(Usuario usuario) {
        /*Solicita a inserção a Service já retornando o 
        resultado, se a inserção foi bem sucedida ou não*/
        return this.usuarioService.insert(usuario);
    }

    /* ----- Regras de negócio ----- */
    public boolean isIdExists(Long idUsuario){
        //Solicita a Service a verificação já retornando o resultado
        return this.usuarioService.isIdExists(idUsuario);
    }
}
