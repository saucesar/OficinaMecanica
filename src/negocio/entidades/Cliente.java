package negocio.entidades;

import java.lang.annotation.Inherited;

public class Cliente {
    private String cpf, nome,telefone;
    private Endereco endereco;

    public Cliente(String cpf,String nome, String telefone,Endereco e){
        this.cpf = formatarCpf(cpf);
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = e;
    }

    public Cliente(String cpf,String nome, String telefone){
        this.cpf = formatarCpf(cpf);
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = null;
    }

    public String getCpf(){return this.cpf;}
    public void setCpf(String cpf){this.cpf = formatarCpf(cpf);}
    public String getNome(){return this.nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getTelefone(){return this.telefone;}
    public void setTelefone(String telefone){this.telefone = telefone;}
    public Endereco getEndereco(){return this.endereco;}
    public void setEndereco(Endereco e){this.endereco = e;}

    public static String formatarCpf(String cpf){
        return cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
    }

    @Override
    public String toString(){
        String str = this.cpf+" | "+this.nome+" | "+this.telefone+" | ";
        if(this.endereco != null){str += this.endereco.toString();}
        return str;
    }
}
