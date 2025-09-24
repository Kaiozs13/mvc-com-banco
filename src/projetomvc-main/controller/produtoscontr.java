package controller;

import model.Produtos;

public class produtoscontr {
    public Produtos criarProduto(int idProduto, String nome, String descricao, String fabricante, double preco, String dataValidade) {
        return new Produtos(idProduto, nome, descricao, fabricante, preco, dataValidade);
    }

    public void exibirProduto(Produtos produto) {
        System.out.println("ID: " + produto.getIdProduto() + ", Nome: " + produto.getNome() +
                           ", Fabricante: " + produto.getFabricante() + ", Preço: " + produto.getPreco());
    }
}
