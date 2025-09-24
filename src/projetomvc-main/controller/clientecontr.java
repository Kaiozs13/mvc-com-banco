package controller;

import model.Cliente;

public class clientecontr {
    
    public Cliente criarCliente(String nome, String email, int cpf) {
        Cliente cliente = new Cliente(nome, email, cpf);
        cliente.cadastrarCliente(); // Apenas um print no momento
        return cliente;
    }

    public void exibirCliente(Cliente cliente) {
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("CPF: " + cliente.getCPF());
    }
}

