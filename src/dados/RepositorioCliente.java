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

    public Cliente buscarPorId(int idBusca) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ?";

        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1,idBusca);
        ResultSet rs = ps.executeQuery();

        Cliente c = null;

        if (rs.next()){
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String telefone = rs.getString("telefone");
            c = new Cliente(idBusca,cpf,nome,telefone);
        }
        return c;
    }

    public Cliente buscarPorCpf(String cpfCliente) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE cpf = ?";

        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setString(1,cpfCliente);
        ResultSet rs = ps.executeQuery();

        Cliente c = null;

        if (rs.next()){
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String telefone = rs.getString("telefone");
            c = new Cliente(id,cpfCliente,nome,telefone);
        }
        return c;
    }

    public void atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, cpf = ?,telefone = ? WHERE id = ?";
        PreparedStatement ps = this.conexao.prepareStatement(sql);

        ps.setString(1,cliente.getNome());
        ps.setString(2,cliente.getCpf());
        ps.setString(3,cliente.getTelefone());
        ps.setInt(4,cliente.getId());
        ps.executeUpdate();
    }

    public void deletar(String cpf) throws SQLException {
        String sql = "DELETE FROM clientes WHERE cpf = ?";
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setString(1,cpf);
        ps.executeUpdate();
    }
}
