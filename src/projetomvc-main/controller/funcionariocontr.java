package controller;

import model.Funcionario;

public class funcionariocontr {

    public Funcionario criarFuncionario(String nome, String cpf, String categoria,
                                        String rua, String bairro, int Ndacasa,
                                        String cidade, String estado, String cep,
                                        String telefone) {

        return new Funcionario(nome, cpf, categoria, rua, bairro, Ndacasa, cidade, estado, cep, telefone);
    }

    public void exibirFuncionario(Funcionario funcionario) {
        System.out.println("Nome: " + funcionario.getNome() +
                ", CPF: " + funcionario.getCpf() +
                ", Categoria: " + funcionario.getCategoria() +
                ", Cidade: " + funcionario.getCidade());
    }
}
