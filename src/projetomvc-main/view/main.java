package view;

import java.util.Scanner;
import controller.*;
import dao.*;
import model.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        produtosdao produtoDAO = new produtosdao();
        estoquedao estoqueDAO = new estoquedao();
        fornecedordao fornecedorDAO = new fornecedordao();
        VendaDAO vendaDAO = new VendaDAO();
        conveniodao convenioDAO = new conveniodao();

        produtoscontr produtoController = new produtoscontr();
        estoquecontr estoqueController = new estoquecontr();
        fornecedorcontr fornecedorController = new fornecedorcontr();
        VendaController vendaController = new VendaController();
        conveniocontr convenioController = new conveniocontr();

        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar Produto");
<<<<<<< HEAD
            System.out.println("2 - Cadastrar Fornecedor");
            System.out.println("3 - Cadastrar Venda");
            System.out.println("4 - Cadastrar Convênio");
            System.out.println("5 - Listar Produtos");
            System.out.println("6 - Listar Estoques");
            System.out.println("7 - Listar Fornecedores");
            System.out.println("8 - Listar Vendas");
            System.out.println("9 - Listar Convênios");
=======
            System.out.println("2 - Cadastrar Estoque");
            System.out.println("3 - Cadastrar Fornecedor");
            System.out.println("4 - Cadastrar Venda");
            System.out.println("5 - Cadastrar Convênio");
            System.out.println("6 - Listar Produtos");
            System.out.println("7 - Listar Estoques");
            System.out.println("8 - Listar Fornecedores");
            System.out.println("9 - Listar Vendas");
            System.out.println("10 - Listar Convênios");
>>>>>>> 5b0563573f0971f6e6555c6125a1c3676340252b
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opc = sc.nextInt();
            sc.nextLine(); // consumir enter

            switch(opc) {
                case 1:
<<<<<<< HEAD
                    // Cadastro de Produto
                    System.out.print("ID Produto: "); 
                    int idP = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("Nome: "); 
                    String nomeP = sc.nextLine();
                    System.out.print("Descrição: "); 
                    String desc = sc.nextLine();
                    System.out.print("Fabricante: "); 
                    String fab = sc.nextLine();
                    System.out.print("Preço: "); 
                    double preco = sc.nextDouble(); 
                    sc.nextLine();
                    System.out.print("Data Validade: "); 
                    String val = sc.nextLine();

                    Produtos prod = produtoController.criarProduto(idP, nomeP, desc, fab, preco, val);
                    produtoDAO.salvar(prod);
                  
                    System.out.print("Quantidade: "); 
                    int qtd = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("Local Armazenamento: "); 
                    String local = sc.nextLine();
                    System.out.print("Data Entrada: "); 
                    String entrada = sc.nextLine();
                    System.out.print("Data Última Saída: "); 
                    String saida = sc.nextLine();

                    // usa o mesmo id do produto
                    Estoque est = estoqueController.criarEstoque(idP, prod, qtd, local, entrada, saida);
                    estoqueDAO.salvar(est);

                    break;


                case 2:
                    System.out.print("ID Fornecedor: "); 
                    int idF = sc.nextInt(); sc.nextLine();
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

                    // Endereço
                    System.out.println("\n--- Endereço do Fornecedor ---");
                    System.out.print("Rua: "); 
                    String rua = sc.nextLine();
                    System.out.print("Bairro: "); 
                    String bairro = sc.nextLine();
                    System.out.print("Número da casa: "); 
                    int nCasa = sc.nextInt(); sc.nextLine();
                    System.out.print("Cidade: "); 
                    String cidade = sc.nextLine();
                    System.out.print("Estado: "); 
                    String estado = sc.nextLine();
                    System.out.print("CEP: "); 
                    String cep = sc.nextLine();

                    Fornecedor f = fornecedorController.criarFornecedor(idF, nomeF, email, cnpj, rep, tel, rua, bairro, nCasa, cidade, estado, cep); 
                    fornecedorDAO.salvar(f); 
                    
                    break;

                    
                case 3:
=======
                    System.out.print("ID Produto: "); int idP = sc.nextInt(); sc.nextLine();
                    System.out.print("Nome: "); String nomeP = sc.nextLine();
                    System.out.print("Descrição: "); String desc = sc.nextLine();
                    System.out.print("Fabricante: "); String fab = sc.nextLine();
                    System.out.print("Preço: "); double preco = sc.nextDouble(); sc.nextLine();
                    System.out.print("Data Validade: "); String val = sc.nextLine();

                    Produtos prod = produtoController.criarProduto(idP, nomeP, desc, fab, preco, val);
                    produtoDAO.salvar(prod);
                    break;

                case 2:
                    System.out.print("ID Estoque: "); int idE = sc.nextInt(); sc.nextLine();
                    System.out.print("ID Produto (existente): "); int idProd = sc.nextInt(); sc.nextLine();
                    Produtos pEst = produtoDAO.buscarPorId(idProd);
                    if(pEst == null) { System.out.println("Produto não encontrado!"); break; }

                    System.out.print("Quantidade: "); int qtd = sc.nextInt(); sc.nextLine();
                    System.out.print("Local Armazenamento: "); String local = sc.nextLine();
                    System.out.print("Data Entrada: "); String entrada = sc.nextLine();
                    System.out.print("Data Última Saída: "); String saida = sc.nextLine();

                    Estoque est = estoqueController.criarEstoque(idE, pEst, qtd, local, entrada, saida);
                    estoqueDAO.salvar(est);
                    break;

                case 3:
                    System.out.print("ID Fornecedor: "); int idF = sc.nextInt(); sc.nextLine();
                    System.out.print("Nome: "); String nomeF = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("CNPJ: "); String cnpj = sc.nextLine();
                    System.out.print("Representante: "); String rep = sc.nextLine();
                    System.out.print("Telefone: "); String tel = sc.nextLine();

                    Fornecedor f = fornecedorController.criarFornecedor(idF, nomeF, email, cnpj, rep, tel);
                    fornecedorDAO.salvar(f);
                    break;
                    
                case 4:
>>>>>>> 5b0563573f0971f6e6555c6125a1c3676340252b
                    System.out.print("ID Venda: "); int idV = sc.nextInt(); sc.nextLine();
                    System.out.print("ID Produto: "); int idProdV = sc.nextInt(); sc.nextLine();
                    Produtos prodV = produtoDAO.buscarPorId(idProdV);
                    if(prodV == null) { System.out.println("Produto não encontrado!"); break; }

                    System.out.print("Quantidade Vendida: "); int qtdV = sc.nextInt(); sc.nextLine();
                    System.out.print("Preço Unitário: "); double precoV = sc.nextDouble(); sc.nextLine();
                    System.out.print("Data Venda: "); String dataV = sc.nextLine();
                    System.out.print("Nome Cliente: "); String clienteV = sc.nextLine();

                    Venda venda = vendaController.criarVenda(idV, prodV, qtdV, precoV, dataV, clienteV);
                    vendaDAO.salvar(venda);
                    break;

<<<<<<< HEAD
                case 4:
=======
                case 5:
>>>>>>> 5b0563573f0971f6e6555c6125a1c3676340252b
                    System.out.print("ID Convênio: "); int idC = sc.nextInt(); sc.nextLine();
                    System.out.print("Desconto: "); int desconto = sc.nextInt(); sc.nextLine();
                    System.out.print("CNPJ: "); String cnpjC = sc.nextLine();

                    Convenio conv = convenioController.criarConvenio(idC, desconto, cnpjC);
                    convenioDAO.salvar(conv);
                    break;

<<<<<<< HEAD
                case 5:
                    produtoDAO.listarTodos().forEach(produtoController::exibirProduto);
                    break;

                case 6:
                    estoqueDAO.listarTodos().forEach(estoqueController::exibirEstoque);
                    break;

                case 7:
                    fornecedorDAO.listarTodos().forEach(fornecedorController::exibirFornecedor);
                    break;

                case 8:
                    vendaDAO.listarTodos().forEach(vendaController::exibirVenda);
                    break;

                case 9:
=======
                case 6:
                    produtoDAO.listarTodos().forEach(produtoController::exibirProduto);
                    break;

                case 7:
                    estoqueDAO.listarTodos().forEach(estoqueController::exibirEstoque);
                    break;

                case 8:
                    fornecedorDAO.listarTodos().forEach(fornecedorController::exibirFornecedor);
                    break;

                case 9:
                    vendaDAO.listarTodos().forEach(vendaController::exibirVenda);
                    break;

                case 10:
>>>>>>> 5b0563573f0971f6e6555c6125a1c3676340252b
                    convenioDAO.listarTodos().forEach(convenioController::exibirConvenio);
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
