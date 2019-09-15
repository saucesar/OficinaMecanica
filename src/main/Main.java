package main;

import dados.RepositorioCliente;
import dados.RepositorioEndereco;
import negocio.entidades.Cliente;
import negocio.entidades.Endereco;

public class Main {
    public static void main(String args[]) throws Exception {
        String cpf = "11111111111";
        Endereco e = new Endereco("STREET MODIF","01","CENTRO","GARANHUNS","SEM COMPLEMENTO",cpf);
        Cliente c = new Cliente(cpf,"TESTE NOME mod2","(87)988996655",e);
        RepositorioCliente rc = new RepositorioCliente();
        RepositorioEndereco re = new RepositorioEndereco();
        try{
            Cliente c2 = rc.buscarPorCpf(cpf);
            c2.setNome(c.getNome());

            Endereco e2 = re.buscar(c2.getCpf());
            c2.setCpf("11122233344");

            e2.setRua("MODIFICADO de novo");
            e2.setCpfCliente(c2.getCpf());
            rc.atualizar(c2);
            re.atualizar(e2);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
