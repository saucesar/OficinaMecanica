package fachada;

import negocio.NegocioCliente;
import negocio.entidades.Cliente;
import negocio.entidades.Endereco;
import java.sql.SQLException;

public class Fachada {
    private NegocioCliente clientes;
    private static Fachada fachada;
    private Fachada() throws SQLException {
        this.clientes = new NegocioCliente();
    }

    public static Fachada getInstance() throws SQLException {
        if (fachada == null){ fachada = new Fachada();}
        return fachada;
    }

    public void salvarCliente( String nome, String cpf, String telefone,
                               String rua, String numero, String bairro,
                               String cidade, String complemento) throws SQLException {

        Endereco endereco = new Endereco(rua,numero,bairro,cidade,complemento,cpf);
        Cliente cliente = new Cliente(cpf,nome,telefone,endereco);
        this.clientes.salvarCliente(cliente);
    }
}
