package negocio.entidades;

public class Endereco {
    private String rua,numero,bairro,cidade,complemento,cpfCliente;

    public Endereco(String rua, String numero, String bairro, String cidade, String complem){
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complem;
    }

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

    @Override
    public String toString(){
        String str = "RUA "+this.rua+", NUMERO: "+this.numero+", "+this.bairro+", "+this.cidade+", "+this.complemento;
        return str;
    }
}
