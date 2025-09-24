package view;

import java.util.Scanner;
import controller.estoquecontr;
import dao.estoquedao;
import model.Estoque;
import model.Produtos;

public class estoqueview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        estoquecontr controller = new estoquecontr();
        estoquedao dao = new estoquedao();

        // Cadastro do produto
        System.out.println("=== Cadastro de Produto ===");
        System.out.print("ID Produto: ");
        int idProduto = sc.nextInt();
        sc.nextLine(); // consumir quebra de linha

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        System.out.print("Fabricante: ");
        String fabricante = sc.nextLine();

        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        System.out.print("Data Validade: ");
        String dataValidade = sc.nextLine();

        Produtos produto = new Produtos(idProduto, nome, descricao, fabricante, preco, dataValidade);

        // Cadastro do estoque
        System.out.println("\n=== Cadastro de Estoque ===");
        System.out.print("ID Estoque: ");
        int idEstoque = sc.nextInt();

        System.out.print("Quantidade Atual: ");
        int quantidadeAtual = sc.nextInt();
        sc.nextLine();

        System.out.print("Local Armazenamento: ");
        String localArmazenamento = sc.nextLine();

        System.out.print("Data Entrada: ");
        String dataEntrada = sc.nextLine();

        System.out.print("Data Última Saída: ");
        String dataUltimaSaida = sc.nextLine();

        Estoque estoque = controller.criarEstoque(idEstoque, produto, quantidadeAtual, localArmazenamento, dataEntrada, dataUltimaSaida);
        dao.salvar(estoque);
        controller.exibirEstoque(estoque);

        sc.close();
    }
}
