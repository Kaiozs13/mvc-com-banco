package controller;

import model.Venda;
import model.Produtos;

public class VendaController {
    public Venda criarVenda(String idVenda, Produtos produto, int quantidade, double precoUnitario, String dataVenda, String nomeCliente) {
        return new Venda(idVenda, produto, quantidade, precoUnitario, dataVenda, nomeCliente);
    }

    public void exibirVenda(Venda venda) {
        System.out.println("ID Venda: " + venda.getIdVenda() + ", Produto: " + venda.getProduto().getNome() +
                           ", Quantidade: " + venda.getQuantidadeVendida() + ", Cliente: " + venda.getNomeCliente());
    }
}
