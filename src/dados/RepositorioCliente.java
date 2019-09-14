package dados;

import negocio.entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositorioCliente extends RepositorioBasico {

    public RepositorioCliente() throws SQLException{ super(); }

    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (cpf,nome,telefone) VALUES (?,?,?)";
        PreparedStatement ps = this.conexao.prepareStatement(sql);

        ps.setString(1,cliente.getCpf());
        ps.setString(2,cliente.getNome());
        ps.setString(3,cliente.getTelefone());
        ps.executeUpdate();
    }
}
