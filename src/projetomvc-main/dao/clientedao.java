package dao;

import model.Cliente;
import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clientedao {

    public void salvar(Cliente cliente) {
        // Corrigido: a instrução INSERT agora corresponde à sua tabela (sem 'CodCliente')
        String sql = "INSERT INTO Clientes (Nome, Email, CPF) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCPF());



            ps.executeUpdate();
            System.out.println("Cliente salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarPorCPF(String cpf) {
        // A busca já estava correta, mas a instrução SELECT foi ajustada.
        String sql = "SELECT Nome, Email, CPF FROM Clientes WHERE CPF = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getString("Nome"),
                        rs.getString("Email"),
                        rs.getString("CPF")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cliente> listarTodos() {
        String sql = "SELECT Nome, Email, CPF FROM Clientes";
        List<Cliente> lista = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getString("Nome"),
                        rs.getString("Email"),
                        rs.getString("CPF")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}