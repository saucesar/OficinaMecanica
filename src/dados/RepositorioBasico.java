package dados;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class RepositorioBasico {
    protected Connection conexao;
    public RepositorioBasico() throws SQLException { this.conexao = ConexaoDB.getInstance().getConexao(); }
}
