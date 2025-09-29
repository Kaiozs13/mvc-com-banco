package dao;

import model.Produtos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class produtosdao {

    public void salvar(Produtos produto) {
        String sql = "INSERT INTO Produtos (IdProduto, Nome, Produtos, Preco, Categoria, Fabricante, DataDeValidade, QuantidadeAtual, LocalArmazenamento, DataEntrada, DataUltimaSaida) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getIdProduto());
            ps.setString(2, produto.getNome());
            ps.setString(3, produto.getDescricao());
            ps.setDouble(4, produto.getPreco());
            ps.setString(5, produto.getCategoria());
            ps.setString(6, produto.getFabricante());
            ps.setString(7, produto.getDataValidade());
            ps.setInt(8, produto.getQuantidadeAtual());
            ps.setString(9, produto.getLocalArmazenamento());
            ps.setString(10, produto.getDataEntrada());
            ps.setString(11, produto.getDataUltimaSaida());

            ps.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produtos buscarPorId(String idProduto) {
        String sql = "SELECT * FROM Produtos WHERE IdProduto = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idProduto);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Produtos(
                        rs.getString("IdProduto"),
                        rs.getString("Nome"),
                        rs.getString("Produtos"),
                        rs.getString("Categoria"),
                        rs.getString("Fabricante"),
                        rs.getDouble("Preco"),
                        rs.getString("DataDeValidade"),
                        rs.getInt("QuantidadeAtual"),
                        rs.getString("LocalArmazenamento"),
                        rs.getString("DataEntrada"),
                        rs.getString("DataUltimaSaida")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Produtos> listarTodos() {
        List<Produtos> lista = new ArrayList<>();
        String sql = "SELECT * FROM Produtos";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produtos p = new Produtos(
                        rs.getString("IdProduto"),
                        rs.getString("Nome"),
                        rs.getString("Produtos"),
                        rs.getString("Categoria"),
                        rs.getString("Fabricante"),
                        rs.getDouble("Preco"),
                        rs.getString("DataDeValidade"),
                        rs.getInt("QuantidadeAtual"),
                        rs.getString("LocalArmazenamento"),
                        rs.getString("DataEntrada"),
                        rs.getString("DataUltimaSaida")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizar(Produtos produto) {
        String sql = "UPDATE Produtos SET Nome=?, Produtos=?, Preco=?, Categoria=?, Fabricante=?, DataDeValidade=?, QuantidadeAtual=?, LocalArmazenamento=?, DataEntrada=?, DataUltimaSaida=? " +
                "WHERE IdProduto=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getPreco());
            ps.setString(4, produto.getCategoria());
            ps.setString(5, produto.getFabricante());
            ps.setString(6, produto.getDataValidade());
            ps.setInt(7, produto.getQuantidadeAtual());
            ps.setString(8, produto.getLocalArmazenamento());
            ps.setString(9, produto.getDataEntrada());
            ps.setString(10, produto.getDataUltimaSaida());
            ps.setString(11, produto.getIdProduto());

            ps.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String idProduto) {
        String sql = "DELETE FROM Produtos WHERE IdProduto=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idProduto);
            ps.executeUpdate();
            System.out.println("Produto removido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
