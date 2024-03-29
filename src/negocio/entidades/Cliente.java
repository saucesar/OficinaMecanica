package negocio.entidades;

public class Cliente extends ClasseBasica{
    private int id;
    private String cpf, nome,telefone;
    private Endereco endereco;

    public Cliente(String cpf,String nome, String telefone,Endereco e){
        this.id = 0;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = e;
    }

    public Cliente(int id,String cpf,String nome, String telefone){
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = null;
    }

    public int getId(){return this.id;}
    public String getCpf(){return this.cpf;}
    public void setCpf(String cpf){this.cpf = cpf;}
    public String getNome(){return this.nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getTelefone(){return this.telefone;}
    public void setTelefone(String telefone){this.telefone = telefone;}
    public Endereco getEndereco(){return this.endereco;}
    public void setEndereco(Endereco e){this.endereco = e;}

    private String formatarCpf(String cpf){
        return cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
    }

    @Override
    public String toString(){
        String str = formatarCpf(this.cpf)+" | "+this.nome+" | "+this.telefone+" | ";
        if(this.endereco != null){str += this.endereco.toString();}
        return str+"\n";
    }

    private boolean nomeValido(){ return (this.nome.length() > 5); }
    private boolean telefoneValido(){ return (this.telefone.length() > 8); }

    @Override
    public boolean dadosValidos() { return (nomeValido() && eNumerico(this.cpf) && telefoneValido());}
}
