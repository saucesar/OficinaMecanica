package negocio;

import dados.RepositorioCliente;
import dados.RepositorioEndereco;
import negocio.entidades.Cliente;

import java.sql.SQLException;

public class NegocioCliente {
    private RepositorioCliente clientes;
    private RepositorioEndereco enderecos;

    public NegocioCliente() throws SQLException {
        this.clientes = new RepositorioCliente();
        this.enderecos = new RepositorioEndereco();
    }

    public void salvarCliente(Cliente cliente) throws SQLException {
        if(cliente.dadosValidos() && cliente.getEndereco().dadosValidos()){
            clientes.salvar(cliente);
            enderecos.salvar(cliente.getEndereco());
        }
    }
}
