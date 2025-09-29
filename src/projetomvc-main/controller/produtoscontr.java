package controller;

import model.Produtos;

public class produtoscontr {

    public Produtos criarProduto(String idProduto, String nome, String descricao, String categoria,
                                String fabricante, double preco, String dataValidade,
                                int quantidadeAtual, String localArmazenamento,
                                String dataEntrada, String dataUltimaSaida) {
        return new Produtos(idProduto, nome, descricao, categoria, fabricante, preco, dataValidade,
                quantidadeAtual, localArmazenamento, dataEntrada, dataUltimaSaida);
    }

    public void exibirProduto(Produtos produto) {
        System.out.println("ID: " + produto.getIdProduto() + " | Produto: " + produto.getNome() + " | Preço: " + produto.getPreco() +
                " | Quantidade: " + produto.getQuantidadeAtual());
    }
}
