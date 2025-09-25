package model;

public class Funcionario {
    private String nome;
    private String cpf; // alterado para String, mas mantive o nome
    private String categoria;

    private String rua;
    private String bairro;
    private int Ndacasa;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone; // alterado para String, mas mantive o nome

    public Funcionario(String nome, String cpf, String categoria, String rua, String bairro, int Ndacasa, String cidade, String estado, String cep, String telefone) {
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

    public String getCpf() { // continua com nome cpf
        return cpf;
    }

    public void setCpf(String cpf) { // continua com nome cpf
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

    public String getTelefone() { // nome igual
        return telefone;
    }

    public void setTelefone(String telefone) { // nome igual
        this.telefone = telefone;
    }
}

