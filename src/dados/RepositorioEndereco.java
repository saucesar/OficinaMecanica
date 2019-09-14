package dados;

import negocio.entidades.Endereco;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositorioEndereco extends RepositorioBasico{
    public RepositorioEndereco() throws Exception { super(); }

    public void salvar(Endereco endereco, String cpfCliente) throws SQLException {
        String sql = "INSERT INTO enderecos (cpfCliente, rua, numero, bairro, cidade, complemento) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = this.conexao.prepareStatement(sql);

        ps.setString(1,cpfCliente);
        ps.setString(2,endereco.getRua());
        ps.setString(3,endereco.getNumero());
        ps.setString(4,endereco.getBairro());
        ps.setString(5,endereco.getCidade());
        ps.setString(6,endereco.getComplemento());
        ps.executeUpdate();
    }
}
