package dao;

import model.Venda;
import model.Produtos;
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
        String sql = "INSERT INTO Vendas (IdVenda, IdProduto, Quantidade, PrecoUnitario, DataVenda, CodCliente) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, venda.getIdVenda());
            ps.setString(2, venda.getProduto().getIdProduto());
            ps.setInt(3, venda.getQuantidadeVendida());
            ps.setDouble(4, venda.getPrecoUnitario());
            ps.setString(5, venda.getDataVenda());
            ps.setString(6, venda.getNomeCliente()); // pode ser "" se cliente não existir

            ps.executeUpdate();

            System.out.println("Venda registrada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Listar todas as vendas
    public List<Venda> listarTodos() {
        List<Venda> lista = new ArrayList<>();
        String sql = "SELECT v.IdVenda, v.Quantidade, v.PrecoUnitario, v.DataVenda, v.CodCliente, " +
                "p.IdProduto, p.Nome, p.Descricao, p.Categoria, p.Fabricante, p.Preco, p.DataDeValidade, " +
                "e.QuantidadeAtual, e.LocalArmazenamento, e.DataEntrada, e.DataUltimaSaida " +
                "FROM Vendas v " +
                "LEFT JOIN Produtos p ON v.IdProduto = p.IdProduto " +
                "LEFT JOIN Produtos e ON p.IdProduto = e.IdProduto"; // Pega dados do estoque se existir

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Produtos
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

                // Venda
                Venda venda = new Venda(
                        rs.getString("IdVenda"),
                        produto,
                        rs.getInt("Quantidade"),
                        rs.getDouble("PrecoUnitario"),
                        rs.getString("DataVenda"),
                        rs.getString("CodCliente")
                );

                lista.add(venda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar venda por ID
    public Venda buscarPorId(String idVenda) {
        Venda venda = null;
        String sql = "SELECT v.IdVenda, v.Quantidade, v.PrecoUnitario, v.DataVenda, v.CodCliente, " +
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
                        rs.getString("CodCliente")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return venda;
    }
}
