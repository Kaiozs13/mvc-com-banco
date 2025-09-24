package controller;

import model.Fornecedor;

public class fornecedorcontr{
<<<<<<< HEAD
    public Fornecedor criarFornecedor(int idFornecedor, String nome, String email, String CNPJ, String representante, String telefone, String rua, String bairro, int nCasa, String cidade, String estado, String cep) {
=======
    public Fornecedor criarFornecedor(int idFornecedor, String nome, String email, String CNPJ, String representante, String telefone) {
>>>>>>> 5b0563573f0971f6e6555c6125a1c3676340252b
        return new Fornecedor(idFornecedor, nome, email, CNPJ, representante, telefone);
    }

    public void exibirFornecedor(Fornecedor fornecedor) {
        System.out.println("ID: " + fornecedor.getIdFornecedor() + ", Nome: " + fornecedor.getNome() +
                           ", CNPJ: " + fornecedor.getCNPJ());
    }
}
