package negocio.entidades;

public class Endereco extends ClasseBasica{
    private int id;
    private String rua,numero,bairro,cidade,complemento,cpfCliente;

    public Endereco(String rua, String numero, String bairro, String cidade, String complem,String cpfCliente){
        this.id = 0;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complem;
        this.cpfCliente = cpfCliente;
    }

    public Endereco(int id, String rua, String numero, String bairro, String cidade, String complem,String cpfCliente){
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complem;
        this.cpfCliente = cpfCliente;
    }

    public String getCpfCliente(){return this.cpfCliente;}
    public void setCpfCliente(String cpf){this.cpfCliente = cpf;}
    public int getId(){return this.id;}
    public String getRua(){return this.rua;}
    public void setRua(String rua){ this.rua = rua;}
    public String getNumero(){return this.numero;}
    public void setNumero(String numero){ this.numero = numero;}
    public String getBairro(){return this.bairro;}
    public void setBairro(String bairro){ this.bairro = bairro;}
    public String getCidade(){return this.cidade;}
    public void setCidade(String cidade){ this.cidade = cidade;}
    public String getComplemento(){return this.complemento;}
    public void setComplemento(String complem){ this.complemento = complem;}

    public boolean dadosValidos(){ return (ruaValida() && bairroValido() && cidadeValida());}

    @Override
    public String toString(){
        return (this.rua+", "+this.numero+", "+this.bairro+", "+this.cidade+", "+this.complemento);
    }

    private boolean ruaValida(){ return (this.rua.length() > 5); }
    private boolean bairroValido(){ return (this.bairro.length() > 5); }
    private boolean cidadeValida(){ return (this.cidade.length() > 5); }
}
