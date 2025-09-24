package view;

import java.util.Scanner;
import controller.clientecontr;
import dao.clientedao;
import model.Cliente;

public class clienteview {

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        clientecontr controler = new clientecontr();
        clientedao dao = new clientedao();

        System.out.println("Digite o nome do cliente:");
        String nome1 = c.nextLine();

        System.out.println("Digite o email do cliente:");
        String email1 = c.nextLine();

        System.out.println("Digite o CPF do cliente (apenas números):");
        int cpf1 = (int) c.nextDouble();

        Cliente cliente = controler.criarCliente(nome1, email1, cpf1);
        dao.salvar(cliente);
        controler.exibirCliente(cliente);
    }
}
