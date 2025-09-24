package view;

import java.util.Scanner;
import controller.fornecedorcontr;
import dao.fornecedordao;
import model.Fornecedor;

public class fornecedorview {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fornecedorcontr controller = new fornecedorcontr();
        fornecedordao dao = new fornecedordao();

        System.out.println("Digite o ID do fornecedor:");
        int id = sc.nextInt();
        sc.nextLine(); // limpar buffer

        System.out.println("Digite o nome do fornecedor:");
        String nome = sc.nextLine();

        System.out.println("Digite o email do fornecedor:");
        String email = sc.nextLine();

        System.out.println("Digite o CNPJ do fornecedor:");
        String cnpj = sc.nextLine();

        System.out.println("Digite o representante do fornecedor:");
        String representante = sc.nextLine();

        System.out.println("Digite o telefone do fornecedor:");
        String telefone = sc.nextLine();

        Fornecedor fornecedor = controller.criarFornecedor(id, nome, email, cnpj, representante, telefone);
        dao.salvar(fornecedor);
        controller.exibirFornecedor(fornecedor);
    }
}
