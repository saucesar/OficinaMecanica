package negocio;

import dados.RepositorioCliente;
import dados.RepositorioEndereco;
import negocio.entidades.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public void deletar(String cpf) throws SQLException {this.clientes.deletar(cpf);}
    public ArrayList<Cliente> getAll() throws SQLException{
        ArrayList<Cliente> clientes = this.clientes.getAll();
        for(Cliente c:clientes){ c.setEndereco(this.enderecos.buscar(c.getCpf())); }
        return clientes;
    }

    public Cliente buscarCliente(String cpf) throws SQLException { return clientes.buscarPorCpf(cpf); }
}
