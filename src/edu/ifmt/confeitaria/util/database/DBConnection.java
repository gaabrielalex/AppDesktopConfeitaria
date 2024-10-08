/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriel
 */
public class DBConnection {
    //Configuração do banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/DB_CONFEITARIA";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345678";
    private static final String DRIVER = "org.postgresql.Driver";

    //APLICAÇÃO DO PADRÃO SINGLETON
    //Apenas uma instância da conexão é criada
    private static Connection connection;

    //Construtor privado para evitar que a classe seja instanciada
	private DBConnection() {
        //O construtor dispara o método para criar a conexão
        DBConnection.setConnection();
    }
	
    //Método para obter a instância da conexão
	public static synchronized Connection getConnection(){
		try {
            if (DBConnection.connection == null || DBConnection.connection.isClosed())
            	new DBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		return DBConnection.connection;
	}

    //Método privado para criar a conexão
    private static void setConnection() {
        try {
            Class.forName(DRIVER);
            DBConnection.connection =DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            DBConnection.connection = null;
        }
    }

    /*Métodos para fechar a conexão com o banco de dados por meio da 
    instância única e também os recursos criadoss a partir dela*/
    public static void closeConnection(Statement statement) {
        DBConnection.closeConnection(statement, null);
    }

    public static void closeConnection(Statement statement, ResultSet resultSet) {
        if (DBConnection.connection != null) {
            try {
                DBConnection.connection.close();
                statement.close();
                if(resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}