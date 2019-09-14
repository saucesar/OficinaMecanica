package dados;

import java.sql.*;

public class ConexaoDB {
    private Connection conexao;
    private static ConexaoDB conexaoDB;

    private ConexaoDB() throws SQLException{
        String url = "jdbc:sqlite:src/db/data.sqlite";
        this.conexao = DriverManager.getConnection(url);
    }

    public static ConexaoDB getInstance() throws SQLException{
        if (conexaoDB == null){
            conexaoDB = new ConexaoDB();
        }
        return conexaoDB;
    }

    public Connection getConexao(){return this.conexao;}
}
