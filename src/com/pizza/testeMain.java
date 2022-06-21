package com.pizza;

import com.pizza.dao.DatabaseConnection;
import com.pizza.model.Cadastro;

import java.sql.*;

public class testeMain {

    public static void main(String[] args){
        Connection connection = DatabaseConnection.getConnection();

        try{
            Statement createTable = connection.createStatement();
            createTable.execute("CREATE TABLE IF NOT EXISTS CADASTRO (ID INTEGER, NOME VARCHAR(255), IDADE INTEGER, TELEFONE INTEGER, ENDERECO VARCHAR(255), RG INTEGER, VISITAS INTEGER)");

            Cadastro cadastro = new Cadastro(2,"Ana",24,43543545,"aaaaaa",43554343,2);

            PreparedStatement insertUser = connection.prepareStatement("INSERT INTO CADASTRO VALUES (?,?,?,?,?,?,?)");
            insertUser.setInt(1, cadastro.getId());
            insertUser.setString( 2, cadastro.getNome());
            insertUser.setInt( 3, cadastro.getIdade());
            insertUser.setInt(4, cadastro.getTelefone());
            insertUser.setString(5, cadastro.getEndereco());
            insertUser.setInt(6, cadastro.getRg());
            insertUser.setInt(7, cadastro.getVisitas());
            insertUser.execute();

            Statement getAll = connection.createStatement();
            ResultSet result = getAll.executeQuery("SELECT * FROM CADASTRO");

            while(result.next()){
                System.out.println("==========");
                System.out.println(result.getInt("ID"));
                System.out.println(result.getString("NOME"));
                System.out.println(result.getInt("IDADE"));
                System.out.println(result.getInt("TELEFONE"));
                System.out.println(result.getString("ENDERECO"));
                System.out.println(result.getInt("RG"));
                System.out.println(result.getInt("VISITAS"));
                System.out.println("==========");
                result.next();
            }
            connection.createStatement().execute("DELETE FROM CADASTRO");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
