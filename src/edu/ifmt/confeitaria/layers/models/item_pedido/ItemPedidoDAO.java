package edu.ifmt.confeitaria.layers.models.item_pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ifmt.confeitaria.layers.models.pedido.Pedido;
import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.util.database.DBConnection;

public class ItemPedidoDAO {
    private String lastSqlPartialSearch;

    /* ------ Operações básicas de banco de dados ------ */
    public List<ItemPedido> selectById(Long idItemPedido) {
        if(idItemPedido == null) return null;

        //Cria o PreparedStatement e o ResultSet
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        //Cria a query
        String sql =    "SELECT * " +
                        "FROM item_pedido " +
                            "WHERE id_item_pedido = ?";

        try{
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, idItemPedido);

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

    public List<ItemPedido> selectAll() {
        return this.partialSearch(null, null);
    }
    
    public List<ItemPedido> partialSearch(Long idPedido, String produto, String tipoChocolate) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        /*Define por quais campos o usuário deseja realizar a pesquisa*/
        boolean selectByIdPedido = idPedido != null && idPedido > 0;
        boolean selectByProduto = produto != null && !produto.isEmpty();
        boolean selectByTipoChocolate = tipoChocolate != null && !tipoChocolate.isEmpty();
        
        //Cria a query
        String sql =    "SELECT item.*, prod.*, tc.descricao as tipo_chocolate FROM item_pedido item, produto prod LEFT JOIN tipo_chocolate tc ON prod.id_tipo_chocolate = tc.id_tipo_chocolate WHERE item.id_produto = prod.id_produto " +
                                (selectByIdPedido ? "AND item.id_pedido = ? " : "") + // Se o usuário deseja pesquisar pelo ID do pedido, adiciona a condição à query
                                (selectByProduto ?  "AND unaccent(prod.descricao) ILIKE unaccent(?)" : "") +  // Se o usuário deseja pesquisar pelo produto, adiciona a condição à query
                                (selectByTipoChocolate ? "AND tc.descricao = ?" : "") + // Se o usuário deseja pesquisar pelo tipo do chocolate, adiciona a condição à query
                        "ORDER BY prod.descricao, tc.descricao, item.vlr_total_item";

        /*Define o padrão de pesquisa em relação aos parâmetros fornecidos pelo usuário*/
        produto = "%" + produto + "%";

        //Define uma variável para armazenar o índice do parâmetro a ser configurado
        int paramIndexCount = 1;
        try{
            //Define o PreparedStatement com o SQL
            statement = DBConnection.getConnection().prepareStatement(sql);

            //Configura os parâmetros necessários
            if(selectByIdPedido) {
                statement.setLong(paramIndexCount, idPedido);
                paramIndexCount++; //Incrementa o índice do parâmetro para que o próximo seja configurado corretamente
            } 
            if(selectByProduto) {
                statement.setString(paramIndexCount, produto);
                paramIndexCount++;
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

    public List<ItemPedido> redoLastPartialSearch() {
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

    public boolean insert(ItemPedido itemPedido) {
        PreparedStatement statement = null;
        try {
            //Cria a query
            String sql =    "INSERT INTO item_pedido(qtde, vlr_total_item, id_pedido, id_produto) " +
                            "VALUES(?, ?, ?, ?) " +
                            "RETURNING id_item_pedido";
            
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setInt(1, itemPedido.getQtde());
            statement.setBigDecimal(2, itemPedido.getVlrTotalItem());
            statement.setLong(3, itemPedido.getPedido().getID());
            statement.setLong(4, itemPedido.getProduto().getID());
            
            //Executa a query e obtém o ResultSet(que deverá conter o ID do item do pedido retornado pela inserção)
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                //Se a inserção foi realizada com sucesso, define o ID do item do pedido
                itemPedido.setID(resultSet.getLong("id_item_pedido"));
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

    public boolean update(ItemPedido pedido, Long originalID) {
        if(originalID == null) return false;
        PreparedStatement statement = null;

        //Cria a query
            String sql =    "UPDATE item_pedido " +
                            "SET qtde = ?, vlr_total_item = ?, id_produto = ? " +
                            "WHERE id_item_pedido = ?";

        try {
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setInt(1, pedido.getQtde());
            statement.setBigDecimal(2, pedido.getVlrTotalItem());
            statement.setLong(3, pedido.getProduto().getID());
            statement.setLong(4, originalID);
            
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

    public boolean delete(Long idItemPedido) {
        if(idItemPedido == null) return false;
        PreparedStatement statement = null;

        //Cria a query
        String sql =    "DELETE FROM item_pedido " +
                        "WHERE id_item_pedido = ?";
        
        try {
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, idItemPedido);
            
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
    public List<ItemPedido> resultSetToList(ResultSet resultSet) throws SQLException {
        List<ItemPedido> itensPedido = new ArrayList<>();
        
        //Percorre o ResultSet preenchendo a lista de itens do pedido
        while(resultSet.next()) {
            Pedido pedido = new Pedido();
            pedido.setID(resultSet.getLong("id_pedido"));

            itensPedido.add(new ItemPedido(
                    resultSet.getLong("id_item_pedido"),
                    resultSet.getInt("qtde"),
                    resultSet.getBigDecimal("vlr_total_item"),
                    pedido,
                    new Produto(resultSet.getLong("id_produto"),
                        resultSet.getString("descricao"),
                        resultSet.getBigDecimal("vlr_unitario"),
                        resultSet.getString("observacoes"),
                        resultSet.getString("tipo_chocolate"))
                ));
        }
        return itensPedido;
    }
}
