package controller;

import model.Estoque;

public class estoquecontr {
    public Estoque criarEstoque(int idEstoque, model.Produtos produto, int quantidadeAtual, String localArmazenamento, String dataEntrada, String dataUltimaSaida) {
        return new Estoque(idEstoque, produto, quantidadeAtual, localArmazenamento, dataEntrada, dataUltimaSaida);
    }

    public void exibirEstoque(Estoque estoque) {
        System.out.println("ID Estoque: " + estoque.getIdEstoque() + ", Produto: " + estoque.getProduto().getNome() +
                           ", Quantidade: " + estoque.getQuantidadeAtual() + ", Local: " + estoque.getLocalArmazenamento());
    }
}
