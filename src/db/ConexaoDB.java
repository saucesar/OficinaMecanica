package db;

import java.sql.*;

public class ConexaoDB {
    private Connection conexao;
    private static ConexaoDB conexaoDB;

    private ConexaoDB() throws Exception{
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:data.sqlite";
        this.conexao = DriverManager.getConnection(url);
    }

    public static ConexaoDB getInstance() throws Exception{
        if (conexaoDB == null){
            conexaoDB = new ConexaoDB();
        }
        return conexaoDB;
    }

    public Connection getConexao(){return this.conexao;}
}
