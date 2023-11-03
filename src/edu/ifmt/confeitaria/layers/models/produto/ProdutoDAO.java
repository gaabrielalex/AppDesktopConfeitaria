package edu.ifmt.confeitaria.layers.models.produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ifmt.confeitaria.util.database.DBConnection;

public class ProdutoDAO {
    private String lastSqlPartialSearch;

    /* ------ Operações básicas de banco de dados ------ */
    public List<Produto> selectById(Long idProduto) {
        if(idProduto == null) return null;

        //Cria o PreparedStatement e o ResultSet
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        //Cria a query
        String sql =    "SELECT * " +
                        "FROM produto " +
                            "WHERE id_produto = ?";

        try{
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, idProduto);

            //Obtém o ResultSet exexutando a query
            resultSet = statement.executeQuery();
            
            return this.resultSetToList(resultSet); 
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement, resultSet);
        }
    }

    public List<Produto> selectAll() {
        return this.partialSearch(null, null);
    }
    
    public List<Produto> partialSearch(String nome, String tipoChocolate) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        /*Verifica se os parâmetros foram fornecidos e se não são vazios, ou seja,
        confere se o usuário deseja realizar a pesquisa por nome e/ou pelo tipo do chocolate*/
        boolean selectByNome = nome != null && !nome.isEmpty();
        boolean selectByTipoChocolate = tipoChocolate != null && !tipoChocolate.isEmpty();
        
        //Cria a query
        String sql =    "SELECT *"+
                        "FROM cliente " +
                            "WHERE 1 = 1" +
                                (selectByNome ?  "AND unaccent(nome) ILIKE unaccent(?)" : "") +  // Se o usuário deseja pesquisar por nome, adiciona a condição à query
                                (selectByTipoChocolate ? "AND cpf = ?" : "") + // Se o usuário deseja pesquisar pelo tipo do chocolate, adiciona a condição à query
                        "ORDER BY nome, cpf";

        /*Define o padrão de pesquisa em relação aos parâmetros fornecidos pelo usuário*/
        nome= "%" + nome + "%";

        //Define uma variável para armazenar o índice do parâmetro a ser configurado
        int paramIndexCount = 1;
        try{
            //Define o PreparedStatement com o SQL
            statement = DBConnection.getConnection().prepareStatement(sql);

            //Configura os parâmetros necessários
            if(selectByNome) {
                statement.setString(paramIndexCount, nome);
                paramIndexCount++; //Incrementa o índice do parâmetro para que o próximo seja configurado corretamente
            } 
            if(selectByTipoChocolate) {
                statement.setString(paramIndexCount, tipoChocolate);
            }
            //Armazena o SQL para haver refefência da última consulta realizada pelo DAO
            this.lastSqlPartialSearch = statement.toString();

            //Obtém o ResultSet exexutando a query
            resultSet = statement.executeQuery();

            return this.resultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement, resultSet);
        }
    }

    public List<Produto> redoLastPartialSearch() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            //Define o PreparedStatement com o SQL da última consulta
            statement = DBConnection.getConnection().prepareStatement(this.lastSqlPartialSearch);

            //Obtém o ResultSet exexutando a query
            resultSet = statement.executeQuery();

            return this.resultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement, resultSet);
        }
    }

    public boolean insert(Produto produto) {
        PreparedStatement statement = null;
        try {
            //Cria a query
            String sql =    "INSERT INTO produto(descricao, vlr_unitario, observacoes, id_tipo_chocolate)" +
                            "VALUES(?, ?, ?, (select id_tipo_chocolate from tipo_chocolate where descricao = ?)) " +
                            "RETURNING id_produto";
            
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, produto.getDescricao());
            statement.setBigDecimal(2, produto.getVlrUnitario());
            statement.setString(3, produto.getObservacoes());
            statement.setString(4, produto.getTipoChocolate());
            
            //Executa a query e obtém o ResultSet(que deverá conter o ID do produto retornado pela inserção)
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                //Se a inserção foi realizada com sucesso, define o ID do produto
                produto.setID(resultSet.getLong("id_produto"));
            }
            //Se a inserção foi realizada com sucesso, retorna true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //Se a inserção não foi realizada com sucesso, retorna false
            return false;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement);
        }
    }

    public boolean update(Produto produto, Long originalID) {
        if(originalID == null) return false;
        PreparedStatement statement = null;

        //Cria a query
            String sql =    "UPDATE produto " +
                            "SET id_produto = ?, descricao = ?, vlr_unitario = ?, observacoes = ?," +
                                "id_tipo_chocolate = (select id_tipo_chocolate from tipo_chocolate where descricao = ?) " +
                            "WHERE id_produto = ?";

        try {
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, produto.getID());
            statement.setString(2, produto.getDescricao());
            statement.setBigDecimal(3, produto.getVlrUnitario());
            statement.setString(4, produto.getObservacoes());
            statement.setString(5, produto.getTipoChocolate());
            statement.setLong(6, originalID);
            
            //Executa a query
            statement.executeUpdate();

            //Se a atualização foi realizada com sucesso, retorna true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //Se a atualização não foi realizada com sucesso, retorna false
            return false;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement);
        }
    }

    public boolean delete(Long idProduto) {
        if(idProduto == null) return false;
        PreparedStatement statement = null;

        //Cria a query
        String sql =    "DELETE FROM produto " +
                        "WHERE id_produto = ?";
        
        try {
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, idProduto);
            
            //Executa a query
            statement.executeUpdate();

            //Se a exclusão foi realizada com sucesso, retorna true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //Se a exclusão não foi realizada com sucesso, retorna false
            return false;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement);
        }
    }

    /* ------ Métodos/Operações auxiliares ------ */
    public List<Produto> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        
        //Percorre o ResultSet preenchendo a lista de produtos
        while(resultSet.next()) {
            produtos.add(new Produto(resultSet.getLong("id_produto"),
                                    resultSet.getString("descricao"),
                                    resultSet.getBigDecimal("vlr_unitario"),
                                    resultSet.getString("observacoes"),
                                    resultSet.getString("tipo_chocolate")));
        }
        return produtos;
    }
}
