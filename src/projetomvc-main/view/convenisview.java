package view;

import java.util.Scanner;
import controller.conveniocontr;
import dao.conveniodao;
import model.Convenio;

public class convenisview {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        conveniocontr controller = new conveniocontr();
        conveniodao dao = new conveniodao();

        System.out.println("Digite o ID do convênio:");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Digite o desconto oferecido (%):");
        int desconto = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o CNPJ do convênio:");
        int cnpj = sc.nextInt();

        Convenio convenio = controller.criarConvenio(id, desconto, cnpj);
        dao.salvar(convenio);
        controller.exibirConvenio(convenio);
    }
}
