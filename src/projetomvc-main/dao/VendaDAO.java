package dao;

import model.Venda;
import model.Produtos;
import model.Cliente; // Importar a classe Cliente
import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    // Salvar uma venda
    public void salvar(Venda venda) {

        // --- INÍCIO DA LÓGICA ADICIONAL ---
        try (Connection conn = DBConnection.getConnection()) {
            // Verifica se o cliente já existe no banco de dados
            String sqlCheckCliente = "SELECT COUNT(*) FROM Clientes WHERE CPF = ?";
            try (PreparedStatement psCheck = conn.prepareStatement(sqlCheckCliente)) {
                psCheck.setString(1, venda.getNomeCliente());
                ResultSet rsCheck = psCheck.executeQuery();

                if (rsCheck.next() && rsCheck.getInt(1) == 0) {
                    System.out.println("Cliente com CPF " + venda.getNomeCliente() + " não encontrado. Cadastrando automaticamente...");

                    // Se o cliente não existe, cria uma nova instância e salva
                    clientedao clienteDAO = new clientedao();
                    Cliente clienteNovo = new Cliente();
                    clienteNovo.setCPF(venda.getNomeCliente());

                    clienteNovo.setNome("Cliente Desconhecido");
                    clienteNovo.setEmail("nao_informado@email.com");

                    clienteDAO.salvar(clienteNovo);
                    System.out.println("Cliente cadastrado com sucesso!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao verificar/cadastrar cliente. A venda não será salva.");
            return;
        }
        // --- FIM DA LÓGICA ADICIONAL ---

        String sql = "INSERT INTO Vendas (IdVenda, IdProduto, Quantidade, PrecoUnitario, DataVenda, CPF) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, venda.getIdVenda());
            ps.setString(2, venda.getProduto().getIdProduto());
            ps.setInt(3, venda.getQuantidadeVendida());
            ps.setDouble(4, venda.getPrecoUnitario());
            ps.setString(5, venda.getDataVenda());
            ps.setString(6, venda.getNomeCliente());

            ps.executeUpdate();

            System.out.println("Venda registrada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Listar todas as vendas (sem alterações)
    public List<Venda> listarTodos() {
        List<Venda> lista = new ArrayList<>();
        String sql = "SELECT v.IdVenda, v.Quantidade, v.PrecoUnitario, v.DataVenda, v.CPF, " +
                "p.IdProduto, p.Nome, p.Descricao, p.Categoria, p.Fabricante, p.Preco, p.DataDeValidade, " +
                "e.QuantidadeAtual, e.LocalArmazenamento, e.DataEntrada, e.DataUltimaSaida " +
                "FROM Vendas v " +
                "LEFT JOIN Produtos p ON v.IdProduto = p.IdProduto " +
                "LEFT JOIN Produtos e ON p.IdProduto = e.IdProduto";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produtos produto = new Produtos(
                        rs.getString("IdProduto"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getString("Categoria"),
                        rs.getString("Fabricante"),
                        rs.getDouble("Preco"),
                        rs.getString("DataDeValidade"),
                        rs.getInt("QuantidadeAtual"),
                        rs.getString("LocalArmazenamento"),
                        rs.getString("DataEntrada"),
                        rs.getString("DataUltimaSaida")
                );

                Venda venda = new Venda(
                        rs.getString("IdVenda"),
                        produto,
                        rs.getInt("Quantidade"),
                        rs.getDouble("PrecoUnitario"),
                        rs.getString("DataVenda"),
                        rs.getString("CPF")
                );

                lista.add(venda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Buscar venda por ID (sem alterações)
    public Venda buscarPorId(String idVenda) {
        Venda venda = null;
        String sql = "SELECT v.IdVenda, v.Quantidade, v.PrecoUnitario, v.DataVenda, v.CPF, " +
                "p.IdProduto, p.Nome, p.Descricao, p.Categoria, p.Fabricante, p.Preco, p.DataDeValidade, " +
                "e.QuantidadeAtual, e.LocalArmazenamento, e.DataEntrada, e.DataUltimaSaida " +
                "FROM Vendas v " +
                "LEFT JOIN Produtos p ON v.IdProduto = p.IdProduto " +
                "LEFT JOIN Produtos e ON p.IdProduto = e.IdProduto " +
                "WHERE v.IdVenda = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idVenda);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Produtos produto = new Produtos(
                        rs.getString("IdProduto"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getString("Categoria"),
                        rs.getString("Fabricante"),
                        rs.getDouble("Preco"),
                        rs.getString("DataDeValidade"),
                        rs.getInt("QuantidadeAtual"),
                        rs.getString("LocalArmazenamento"),
                        rs.getString("DataEntrada"),
                        rs.getString("DataUltimaSaida")
                );

                venda = new Venda(
                        rs.getString("IdVenda"),
                        produto,
                        rs.getInt("Quantidade"),
                        rs.getDouble("PrecoUnitario"),
                        rs.getString("DataVenda"),
                        rs.getString("CPF")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return venda;
    }
}