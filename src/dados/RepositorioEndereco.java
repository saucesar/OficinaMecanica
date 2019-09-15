package dados;

import negocio.entidades.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioEndereco extends RepositorioBasico{
    public RepositorioEndereco() throws SQLException { super(); }

    public void salvar(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO enderecos (cpfCliente, rua, numero, bairro, cidade, complemento) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = this.conexao.prepareStatement(sql);

        ps.setString(1,endereco.getCpfCliente());
        ps.setString(2,endereco.getRua());
        ps.setString(3,endereco.getNumero());
        ps.setString(4,endereco.getBairro());
        ps.setString(5,endereco.getCidade());
        ps.setString(6,endereco.getComplemento());
        ps.executeUpdate();
    }

    public Endereco buscar(String cpfCliente) throws SQLException {
        String sql = "SELECT * FROM enderecos WHERE cpfCliente = ?";

        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setString(1,cpfCliente);
        ResultSet rs = ps.executeQuery();

        rs.next();
        int id = rs.getInt("id");
        String rua = rs.getString("rua");
        String numero = rs.getString("numero");
        String bairro = rs.getString("bairro");
        String cidade = rs.getString("cidade");
        String complemento = rs.getString("complemento");

        return new Endereco(id,rua,numero,bairro,cidade,complemento,cpfCliente);
    }

    public void atualizar(Endereco endereco) throws SQLException {
        String sql = "UPDATE enderecos SET cpfCliente = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, complemento = ? WHERE id = ?";
        PreparedStatement ps = this.conexao.prepareStatement(sql);

        ps.setString(1,endereco.getCpfCliente());
        ps.setString(2,endereco.getRua());
        ps.setString(3,endereco.getNumero());
        ps.setString(4,endereco.getBairro());
        ps.setString(5,endereco.getCidade());
        ps.setString(6,endereco.getComplemento());
        ps.setInt(7,endereco.getId());

        ps.executeUpdate();
    }

    public void deletar(String cpfCliente) throws SQLException {
        String sql = "DELETE FROM enderecos WHERE cpfCliente = ?";
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setString(1,cpfCliente);
        ps.executeUpdate();
    }
}
