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

                    Produtos prod = produtoController.criarProduto(
                            idP, nomeP, desc, categoriaP, fab, preco, val,
                            qtd, local, entrada, saida
                    );
                    produtoDAO.salvar(prod);
                    break;

                case 2: // CADASTRO FORNECEDOR
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
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();
                    System.out.print("CEP: ");
                    String cep = sc.nextLine();

                    Fornecedor f = fornecedorController.criarFornecedor(
                            idF, nomeF, email, cnpj, rep, tel,
                            rua, bairro, nCasa, cidade, estado, cep
                    );
                    fornecedorDAO.salvar(f);
                    break;

                case 3: // CADASTRO DE VENDA
                    System.out.print("ID Venda: ");
                    int idV = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ID Produto: ");
                    String idProdV = sc.nextLine();
                    Produtos prodV = produtoDAO.buscarPorId(idProdV);
                    if (prodV == null) {
                        System.out.println("Produto não encontrado!");
                        break;
                    }
                    System.out.print("Quantidade Vendida: ");
                    int qtdV = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Preço Unitário: ");
                    double precoV = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Data Venda: ");
                    String dataV = sc.nextLine();
                    System.out.print("Nome Cliente: ");
                    String clienteV = sc.nextLine();

                    Venda venda = vendaController.criarVenda(idV, prodV, qtdV, precoV, dataV, clienteV);
                    vendaDAO.salvar(venda);
                    break;

                case 4: // CADASTRO CONVÊNIO
                    System.out.print("ID Convênio: ");
                    int idC = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Desconto: ");
                    int desconto = sc.nextInt();
                    sc.nextLine();
                    System.out.print("CNPJ: ");
                    String cnpjC = sc.nextLine();

                    Convenio conv = convenioController.criarConvenio(idC, desconto, cnpjC);
                    convenioDAO.salvar(conv);
                    break;

                case 5: // CADASTRO CLIENTE
                    System.out.print("ID Cliente: ");
                    String codCliente = sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeC = sc.nextLine();
                    System.out.print("Email: ");
                    String emailC = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpfC = sc.nextLine();

                    Cliente cliente = clienteController.criarCliente(nomeC, emailC, cpfC);
                    clienteDAO.salvar(codCliente, cliente);
                    break;

                case 6: // CADASTRO FUNCIONÁRIO
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
                    System.out.print("Estado: ");
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
                    produtoDAO.listarTodos().forEach(produtoController::exibirProduto);
                    break;
                case 8:
                    fornecedorDAO.listarTodos().forEach(fornecedorController::exibirFornecedor);
                    break;
                case 9:
                    vendaDAO.listarTodos().forEach(vendaController::exibirVenda);
                    break;
                case 10:
                    convenioDAO.listarTodos().forEach(convenioController::exibirConvenio);
                    break;
                case 11:
                    funcionarioDAO.listarTodos().forEach(funcionarioController::exibirFuncionario);
                    break;
                case 12:
                    clienteDAO.listarTodos().forEach(clienteController::exibirCliente);
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


