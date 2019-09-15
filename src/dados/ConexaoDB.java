package dados;

import java.sql.*;

class ConexaoDB {
    private Connection conexao;
    private static ConexaoDB conexaoDB;

    private ConexaoDB() throws SQLException{
        String url = "jdbc:sqlite:C:\\sqlite\\db/data.sqlite";
        this.conexao = DriverManager.getConnection(url);
    }

    static ConexaoDB getInstance() throws SQLException{
        if (conexaoDB == null){
            conexaoDB = new ConexaoDB();
        }
        return conexaoDB;
    }

    Connection getConexao(){return this.conexao;}
}
