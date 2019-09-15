package main;

import dados.RepositorioCliente;
import dados.RepositorioEndereco;
import negocio.entidades.Cliente;
import negocio.entidades.Endereco;

public class Main {
    public static void main(String args[]) throws Exception {
        Endereco e = new Endereco("STREET","01","CENTRO","GARANHUNS","SEM COMPLEMENTO");
        Cliente c = new Cliente("11122233144","TESTE NOME","(87)988996655",e);
        RepositorioCliente rc = new RepositorioCliente();
        RepositorioEndereco re = new RepositorioEndereco();
        try{
            rc.salvar(c);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
