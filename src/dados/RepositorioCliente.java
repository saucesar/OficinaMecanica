package dados;

import negocio.entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Cliente buscar(String cpfCliente) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE cpf = ?";

        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setString(1,Cliente.formatarCpf(cpfCliente));
        ResultSet rs = ps.executeQuery();

        Cliente c = null;

        if (rs.next()){
            String nome = rs.getString("nome");
            String telefone = rs.getString("telefone");
            c = new Cliente(cpfCliente,nome,telefone);
        }

        return c;
    }
}
