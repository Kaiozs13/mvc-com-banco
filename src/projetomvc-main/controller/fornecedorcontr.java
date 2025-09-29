package controller;

import model.Fornecedor;

public class fornecedorcontr {
    public Fornecedor criarFornecedor(String idFornecedor, String nome, String email, String CNPJ, String representante, String telefone,
                                      String rua, String bairro, int nCasa, String cidade, String estado, String cep) {

        return new Fornecedor(idFornecedor, nome, email, CNPJ, representante, telefone, rua, bairro, nCasa, cidade, estado, cep);
    }

    public void exibirFornecedor(Fornecedor fornecedor) {
        System.out.println("ID: " + fornecedor.getIdFornecedor() + ", Nome: " + fornecedor.getNome() +
                ", CNPJ: " + fornecedor.getCNPJ());
    }
}
