package main;

import dados.RepositorioCliente;
import dados.RepositorioEndereco;
import negocio.entidades.Cliente;
import negocio.entidades.Endereco;

public class Main {
    public static void main(String args[]) throws Exception {
        Endereco e = new Endereco("STREET","01","CENTRO","GARANHUNS","SEM COMPLEMENTO");
        Cliente c = new Cliente("11122233344","TESTE NOME","(87)988996655",e);
        RepositorioCliente rc = new RepositorioCliente();
        RepositorioEndereco re = new RepositorioEndereco();
        try{
            Cliente cliente = rc.buscar("11122233344");
            rc.salvar(cliente);
        }catch (Exception ex){
            System.out.println(ex.getClass());
        }
    }
}
