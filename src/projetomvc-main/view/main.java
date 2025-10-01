package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.*;
import dao.*;
import model.*;

public class main {
    private static final Scanner sc = new Scanner(System.in);


    private static final produtosdao produtoDAO = new produtosdao();
    private static final fornecedordao fornecedorDAO = new fornecedordao();
    private static final VendaDAO vendaDAO = new VendaDAO();
    private static final conveniodao convenioDAO = new conveniodao();
    private static final funcionariodao funcionarioDAO = new funcionariodao();
    private static final clientedao clienteDAO = new clientedao();
    private static final produtoscontr produtoController = new produtoscontr();
    private static final fornecedorcontr fornecedorController = new fornecedorcontr();
    private static final VendaController vendaController = new VendaController();
    private static final conveniocontr convenioController = new conveniocontr();
    private static final funcionariocontr funcionarioController = new funcionariocontr();
    private static final clientecontr clienteController = new clientecontr();


    
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("=== BEM-VINDO AO SISTEMA DE FARMÁCIA! ===");
        System.out.println("=========================================\n");

        Funcionario funcionarioLogado = autenticarFuncionario();

        if (funcionarioLogado != null) {
            System.out.println("\nLogin realizado com sucesso! Bem-vindo(a), " + funcionarioLogado.getNome() + ".");
            exibirMenuPorCategoria(funcionarioLogado);
        } else {
            System.out.println("\nFalha no login. Funcionário não encontrado ou CPF inválido. Sistema encerrado.");
        }

        sc.close();
    }

    private static Funcionario autenticarFuncionario() {
        System.out.print("Por favor, digite o CPF do funcionário para login: ");
        String cpf = sc.nextLine();
        return funcionarioDAO.buscarPorCPF(cpf);
    }

    private static void exibirMenuPorCategoria(Funcionario funcionario) {
        int opc;
        String categoria = funcionario.getCategoria();
        boolean sair = false;

        while (!sair) {
            switch (categoria) {
                case "Gerente":
                    exibirMenuGerente();
                    opc = lerOpcao();
                    switch (opc) {
                        case 1: cadastrarProduto(); break;
                        case 2: cadastrarFornecedor(); break;
                        case 3: cadastrarVenda(); break;
                        case 4: cadastrarConvenio(); break;
                        case 5: cadastrarCliente(); break;
                        case 6: cadastrarFuncionario(); break;
                        case 7: listarProdutos(); break;
                        case 8: listarFornecedores(); break;
                        case 9: listarVendas(); break;
                        case 10: listarConvenios(); break;
                        case 11: listarFuncionarios(); break;
                        case 12: listarClientes(); break;
                        case 0: sair = true; break;
                        default: System.out.println("\nOpção inválida! Por favor, escolha um número de 0 a 12.");
                    }
                    break;

                case "Vendedor":
                case "Farmacêutico":
                case "Operador de Caixa":
                    exibirMenuPadrao();
                    opc = lerOpcao();
                    switch (opc) {
                        case 1: cadastrarVenda(); break;
                        case 2: listarProdutos(); break;
                        case 3: listarVendas(); break;
                        case 4: listarClientes(); break;
                        case 0: sair = true; break;
                        default: System.out.println("\nOpção inválida! Por favor, escolha um número de 0 a 4.");
                    }
                    break;

                default:
                    System.out.println("Categoria de funcionário não reconhecida.");
                    sair = true;
                    break;
            }
        }
    }

    private static void exibirMenuGerente() {
        System.out.println("\n=== MENU DO GERENTE ===");
        System.out.println("1  - Cadastrar Produto");
        System.out.println("2  - Cadastrar Fornecedor");
        System.out.println("3  - Cadastrar Venda");
        System.out.println("4  - Cadastrar Convênio");
        System.out.println("5  - Cadastrar Cliente");
        System.out.println("6  - Cadastrar Funcionário");
        System.out.println("7  - Listar Produtos");
        System.out.println("8  - Listar Fornecedores");
        System.out.println("9  - Listar Vendas");
        System.out.println("10 - Listar Convênios");
        System.out.println("11 - Listar Funcionários");
        System.out.println("12 - Listar Clientes");
        System.out.println("0  - Sair");
        System.out.print(">>> Escolha uma opção: ");
    }

    private static void exibirMenuPadrao() {
        System.out.println("\n=== MENU DO VENDEDOR/CAIXA ===");
        System.out.println("1 - Cadastrar Venda");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Listar Vendas");
        System.out.println("4 - Listar Clientes");
        System.out.println("0 - Sair");
        System.out.print(">>> Escolha uma opção: ");
    }


    private static int lerOpcao() {
        try {
            int opc = sc.nextInt();
            sc.nextLine();
            return opc;
        } catch (InputMismatchException e) {
            sc.nextLine();
            return -1;
        }
    }

    private static void cadastrarProduto() {
        System.out.println("\n--- CADASTRO DE PRODUTO ---");
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

        Produtos produto = produtoController.criarProduto(idP, nomeP, desc, categoriaP, fab, preco, val, qtd, local, entrada, saida);
        produtoDAO.salvar(produto);
        System.out.println("\nProduto cadastrado com sucesso!");
    }

    private static void cadastrarFornecedor() {
        System.out.println("\n--- CADASTRO DE FORNECEDOR ---");
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

        Fornecedor f = fornecedorController.criarFornecedor(idF, nomeF, email, cnpj, rep, tel, rua, bairro, nCasa, cidade, estado, cep);
        fornecedorDAO.salvar(f);
        System.out.println("\nFornecedor cadastrado com sucesso!");
    }

    private static void cadastrarVenda() {
        System.out.println("\n--- CADASTRO DE VENDA ---");
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
        System.out.println("\nVenda(s) registrada(s) com sucesso!");
    }

    private static void cadastrarConvenio() {
        System.out.println("\n--- CADASTRO DE CONVÊNIO ---");
        System.out.print("ID Convênio: ");
        String idC = sc.nextLine();
        System.out.print("Desconto: ");
        String desconto = sc.nextLine();
        System.out.print("CNPJ: ");
        String cnpjC = sc.nextLine();

        Convenio conv = convenioController.criarConvenio(idC, desconto, cnpjC);
        convenioDAO.salvar(conv);
        System.out.println("\nConvênio cadastrado com sucesso!");
    }

    private static void cadastrarCliente() {
        System.out.println("\n--- CADASTRO DE CLIENTE ---");
        System.out.print("Nome: ");
        String nomeC = sc.nextLine();
        System.out.print("Email: ");
        String emailC = sc.nextLine();
        System.out.print("CPF: ");
        String cpfC = sc.nextLine();

        Cliente clienteNovo = clienteController.criarCliente(nomeC, emailC, cpfC);
        clienteDAO.salvar(clienteNovo);
        System.out.println("\nCliente cadastrado com sucesso!");
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n--- CADASTRO DE FUNCIONÁRIO ---");
        System.out.print("ID Funcionário: ");
        String codigoFunc = sc.nextLine();
        System.out.print("Nome: ");
        String nomeFunc = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        String categoria = null;
        while (categoria == null) {
            System.out.println("\nSelecione a Categoria do Funcionário:");
            System.out.println("1 - Gerente");
            System.out.println("2 - Vendedor");
            System.out.println("3 - Farmacêutico");
            System.out.print("Escolha uma opção (1-3): ");

            try {
                int opcCat = sc.nextInt();
                sc.nextLine();
                switch (opcCat) {
                    case 1: categoria = "Gerente"; break;
                    case 2: categoria = "Vendedor"; break;
                    case 3: categoria = "Farmacêutico"; break;
                    default: System.out.println("\nOpção inválida! Por favor, escolha um número de 1 a 4.");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\nEntrada inválida! Por favor, digite um número.");
            }
        }

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
        System.out.println("\nFuncionário cadastrado com sucesso!");
    }

    private static void listarProdutos() {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        produtoDAO.listarTodos().forEach(produtoController::exibirProduto);
        System.out.println("-------------------------");
    }

    private static void listarFornecedores() {
        System.out.println("\n--- LISTA DE FORNECEDORES ---");
        fornecedorDAO.listarTodos().forEach(fornecedorController::exibirFornecedor);
        System.out.println("-----------------------------");
    }

    private static void listarVendas() {
        System.out.println("\n--- LISTA DE VENDAS ---");
        vendaDAO.listarTodos().forEach(vendaController::exibirVenda);
        System.out.println("-----------------------");
    }

    private static void listarConvenios() {
        System.out.println("\n--- LISTA DE CONVÊNIOS ---");
        convenioDAO.listarTodos().forEach(convenioController::exibirConvenio);
        System.out.println("--------------------------");
    }

    private static void listarFuncionarios() {
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
        funcionarioDAO.listarTodos().forEach(funcionarioController::exibirFuncionario);
        System.out.println("-----------------------------");
    }

    private static void listarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        clienteDAO.listarTodos().forEach(clienteController::exibirCliente);
        System.out.println("-------------------------");
    }
}

