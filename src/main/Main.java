package main;

import db.ConexaoDB;
import negocio.entidades.Cliente;
import negocio.entidades.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {
    public static void main(String args[]){
        Endereco e = new Endereco("STREET","01","CENTRO","GARANHUNS","SEM COMPLEMENTO");
        Cliente c = new Cliente("11122233344","TESTE NOME","(87)988996655",e);

        String sql = "INSERT INTO clientes (cpf,nome,telefone) VALUES (?,?,?)";
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = ConexaoDB.getInstance().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,c.getCpf());
            ps.setString(2,c.getNome());
            ps.setString(3,c.getTelefone());
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
