package model;

public class Cliente {
    private String nome;
    private String email;
    private String CPF;

    // Construtor completo: para quando você tem todos os dados.
    public Cliente(String nome, String email, String CPF) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
    }

    // Construtor vazio (sem erros): para quando você precisa criar o objeto
    // e preencher os dados depois usando os métodos 'set'.
    public Cliente() {
        // Correção feita aqui: o corpo do construtor foi deixado vazio.
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