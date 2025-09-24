package model;

public class Funcionario {
    private String nome;
    private double cpf;
    private String categoria;
<<<<<<< HEAD
    private String rua;
    private String bairro;
    private int Ndacasa;
    private String cidade;
    private String estado;
    private String cep;
    private double telefone;

    public Funcionario(String nome, double cpf, String categoria, String rua, String bairro, int Ndacasa, String cidade, String estado, String cep, double telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.categoria = categoria;
        this.rua = rua;
        this.bairro = bairro;
        this.Ndacasa = Ndacasa;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCpf() {
        return cpf;
    }

    public void setCpf(double cpf) {
        this.cpf = cpf;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNdacasa() {
        return Ndacasa;
    }

    public void setNdacasa(int Ndacasa) {
        this.Ndacasa = Ndacasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public double getTelefone() {
        return telefone;
    }

    public void setTelefone(double telefone) {
        this.telefone = telefone;
    }
}

   
=======
    private String endereco;
    private double telefone;

    public Funcionario(String nome, double cpf, String categoria, String endereco, double telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.categoria = categoria;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }
    public double getCpf() { return cpf; }
    public String getCategoria() { return categoria; }
    public String getEndereco() { return endereco; }
    public double getTelefone() { return telefone; }
}
>>>>>>> 5b0563573f0971f6e6555c6125a1c3676340252b
