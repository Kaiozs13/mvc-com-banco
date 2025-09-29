package model;

public class Cliente {
    private String nome;
    private String email;
    private String CPF;

    public Cliente(String nome, String email, String CPF) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
    }

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void cadastrarCliente() {
        System.out.println("Cliente cadastrado: " + nome);
    }
}
