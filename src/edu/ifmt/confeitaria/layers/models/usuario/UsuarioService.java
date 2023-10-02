package edu.ifmt.confeitaria.layers.models.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    //Attributes
    private final UsuarioDAO usuarioDAO;

    //Constructors
    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    //Methods
    public List<Usuario> select(){
        return this.select("", "");
    }

    public List<Usuario> select(String nome, String login) {
        //Remove os espaços em branco do início e do fim das strings
        nome = nome.stripLeading().stripTrailing();
        login = login.stripLeading().stripTrailing();

        //Solita a DAO a execução da query e armazena a resposta(ResultSet)
        ResultSet resultSet = this.usuarioDAO.select(nome, login);

        return this.resultSetToList(resultSet);
    }

    public List<Usuario> remakeLastSelect(){
        //Solita a DAO a execução da query e armazena a resposta(ResultSet)
        ResultSet resultSet = this.usuarioDAO.remakeLastSelect();

        return this.resultSetToList(resultSet);
    }

    public List<Usuario> resultSetToList(ResultSet resultSet){
        //Cria uma lista de usuários e a preenche com os dados do ResultSet
        List<Usuario> usuarios = new ArrayList<>();
        try {
            while(resultSet.next()) {
                usuarios.add(Usuario.fromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            /*Todas as conexões devem ser fechadas após o uso de qualquer serviço da DAO
            (exceto nos serviços onde todos os recursos do banco de dados são usados
            dentro da propria DAO, neste caso, as conexões são fechadas por ela mesma)*/
            this.usuarioDAO.getConnectionManager().closeConnections();
        }

        return usuarios;
    }

}
