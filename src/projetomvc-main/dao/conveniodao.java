package dao;

import model.Convenio;
import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class conveniodao {

    public void salvar(Convenio convenio) {
        String sql = "INSERT INTO Convenios (IdConvenio, Desconto, CNPJ) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, convenio.getIdConvenio());
            ps.setString(2, convenio.getDescontoOferecido());
            ps.setString(3, convenio.getCNPJ());

            ps.executeUpdate();
            System.out.println("Convênio salvo com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Convenio buscarPorId(String idConvenio) {
        String sql = "SELECT * FROM Convenios WHERE IdConvenio = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idConvenio);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Convenio(
                        rs.getString("IdConvenio"),
                        rs.getString("Desconto"),
                        rs.getString("CNPJ")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Convenio> listarTodos() {
        List<Convenio> lista = new ArrayList<>();
        String sql = "SELECT * FROM Convenios";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Convenio(
                        rs.getString("IdConvenio"),
                        rs.getString("Desconto"),
                        rs.getString("CNPJ")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
