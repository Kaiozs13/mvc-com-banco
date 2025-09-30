package view;

import java.util.Scanner;
import controller.*;
import dao.*;
import model.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        produtosdao produtoDAO = new produtosdao();
        fornecedordao fornecedorDAO = new fornecedordao();
        VendaDAO vendaDAO = new VendaDAO();
        conveniodao convenioDAO = new conveniodao();
        funcionariodao funcionarioDAO = new funcionariodao();
        clientedao clienteDAO = new clientedao();

        produtoscontr produtoController = new produtoscontr();
        fornecedorcontr fornecedorController = new fornecedorcontr();
        VendaController vendaController = new VendaController();
        conveniocontr convenioController = new conveniocontr();
        funcionariocontr funcionarioController = new funcionariocontr();
        clientecontr clienteController = new clientecontr();

        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Cadastrar Fornecedor");
            System.out.println("3 - Cadastrar Venda");
            System.out.println("4 - Cadastrar Convênio");
            System.out.println("5 - Cadastrar Cliente");
            System.out.println("6 - Cadastrar Funcionário");
            System.out.println("7 - Listar Produtos");
            System.out.println("8 - Listar Fornecedores");
            System.out.println("9 - Listar Vendas");
            System.out.println("10 - Listar Convênios");
            System.out.println("11 - Listar Funcionários");
            System.out.println("12 - Listar Clientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opc = sc.nextInt();
            sc.nextLine(); // consumir ENTER


            switch (opc) {
                case 1: // CADASTRO DE PRODUTO + ESTOQUE
                    System.out.println("\n--- CADASTRO DE PRODUTO ---\n");

                    System.out.print("ID Produto: ");
                    String idP = sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeP = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoriaP = sc.nextLine();
                    System.out.print("Fabricante: ");
                    String fab = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Data Validade: ");
                    String val = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Local Armazenamento: ");
                    String local = sc.nextLine();
                    System.out.print("Data Entrada: ");
                    String entrada = sc.nextLine();
                    System.out.print("Data Última Saída: ");
                    String saida = sc.nextLine();

                    Produtos produto = produtoController.criarProduto(
                            idP, nomeP, desc, categoriaP, fab, preco, val,
                            qtd, local, entrada, saida
                    );
                    produtoDAO.salvar(produto);
                    break;


                case 2: // CADASTRO FORNECEDOR
                    System.out.println("\n--- CADASTRO DE FORNECEDOR ---\n");

                    System.out.print("ID Fornecedor: ");
                    String idF = sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeF = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("CNPJ: ");
                    String cnpj = sc.nextLine();
                    System.out.print("Representante: ");
                    String rep = sc.nextLine();
                    System.out.print("Telefone: ");
                    String tel = sc.nextLine();
                    System.out.print("Rua: ");
                    String rua = sc.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = sc.nextLine();
                    System.out.print("Número da casa: ");
                    int nCasa = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("Estado(Sigla): ");
                    String estado = sc.nextLine();
                    System.out.print("CEP: ");
                    String cep = sc.nextLine();

                    Fornecedor f = fornecedorController.criarFornecedor(
                            idF, nomeF, email, cnpj, rep, tel,
                            rua, bairro, nCasa, cidade, estado, cep
                    );
                    fornecedorDAO.salvar(f);
                    break;


                case 3: // CADASTRO VENDA
                    System.out.println("\n--- CADASTRO DE VENDA ---\n");

                    System.out.print("ID Venda: ");
                    String idVenda = sc.nextLine();

                    System.out.print("CPF do Cliente: ");
                    String cpfCliente = sc.nextLine();

                    Cliente clienteVenda = clienteDAO.buscarPorCPF(cpfCliente);
                    String clienteId = (clienteVenda != null) ? clienteVenda.getCPF() : cpfCliente;

                    System.out.print("Quantos produtos foram vendidos nesta venda? ");
                    int numProdutos = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < numProdutos; i++) {
                        Produtos produtoVenda = null;

                        while (produtoVenda == null) {
                            System.out.println("\n--- Produto " + (i + 1) + " ---");
                            System.out.print("ID do Produto: ");
                            String idProd = sc.nextLine();

                            produtoVenda = produtoDAO.buscarPorId(idProd);
                            if (produtoVenda == null) {
                                System.out.println("Produto não encontrado! Tente novamente.");
                            }
                        }

                        System.out.print("Quantidade vendida: ");
                        int qtdV = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Preço unitário: ");
                        double precoV = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Data da venda: ");
                        String dataV = sc.nextLine();

                        Venda venda = vendaController.criarVenda(idVenda, produtoVenda, qtdV, precoV, dataV, clienteId);
                        vendaDAO.salvar(venda);
                    }
                    break;


                case 4: // CADASTRO CONVÊNIO
                    System.out.println("\n--- CADASTRO DE CONVÊNIO ---\n");

                    System.out.print("ID Convênio: ");
                    String idC = sc.nextLine();

                    System.out.print("Desconto: ");
                    String desconto = sc.nextLine();

                    System.out.print("CNPJ: ");
                    String cnpjC = sc.nextLine();

                    Convenio conv = convenioController.criarConvenio(idC, desconto, cnpjC);
                    convenioDAO.salvar(conv);
                    break;


                case 5: // CADASTRO CLIENTE
                    System.out.println("\n--- CADASTRO DE CLIENTE ---\n");

                    System.out.print("ID Cliente: ");
                    String codCliente = sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeC = sc.nextLine();
                    System.out.print("Email: ");
                    String emailC = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpfC = sc.nextLine();

                    Cliente clienteNovo = clienteController.criarCliente(nomeC, emailC, cpfC);
                    clienteDAO.salvar(clienteNovo);
                    break;


                case 6: // CADASTRO FUNCIONÁRIO
                    System.out.println("\n--- CADASTRO DE FUNCIONÁRIO ---\n");

                    System.out.print("ID Funcionário: ");
                    String codigoFunc = sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeFunc = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    System.out.print("Rua: ");
                    String ruaFunc = sc.nextLine();
                    System.out.print("Bairro: ");
                    String bairroFunc = sc.nextLine();
                    System.out.print("Número da casa: ");
                    int nCasaFunc = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeFunc = sc.nextLine();
                    System.out.print("Estado(Sigla): ");
                    String estadoFunc = sc.nextLine();
                    System.out.print("CEP: ");
                    String cepFunc = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telFunc = sc.nextLine();

                    Funcionario func = funcionarioController.criarFuncionario(
                            nomeFunc, cpf, categoria, ruaFunc, bairroFunc,
                            nCasaFunc, cidadeFunc, estadoFunc, cepFunc, telFunc
                    );
                    funcionarioDAO.salvar(codigoFunc, func);
                    break;


                case 7: // LISTAR PRODUTOS
                    System.out.println("\n--- LISTA DE PRODUTOS ---");
                    produtoDAO.listarTodos().forEach(produtoController::exibirProduto);
                    System.out.println("-------------------------");
                    break;


                case 8:
                    System.out.println("\n--- LISTA DE FORNECEDORES ---");
                    fornecedorDAO.listarTodos().forEach(fornecedorController::exibirFornecedor);
                    System.out.println("-----------------------------");
                    break;


                case 9:
                    System.out.println("\n--- LISTA DE VENDAS ---");
                    vendaDAO.listarTodos().forEach(vendaController::exibirVenda);
                    System.out.println("-----------------------");
                    break;


                case 10:
                    System.out.println("\n--- LISTA DE CONVÊNIOS ---");
                    convenioDAO.listarTodos().forEach(convenioController::exibirConvenio);
                    System.out.println("--------------------------");
                    break;


                case 11:
                    System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
                    funcionarioDAO.listarTodos().forEach(funcionarioController::exibirFuncionario);
                    System.out.println("-----------------------------");
                    break;


                case 12:
                    System.out.println("\n--- LISTA DE CLIENTES ---");
                    clienteDAO.listarTodos().forEach(clienteController::exibirCliente);
                    System.out.println("-------------------------");
                    break;


                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
        System.out.println("Sistema encerrado.");
    }
}


