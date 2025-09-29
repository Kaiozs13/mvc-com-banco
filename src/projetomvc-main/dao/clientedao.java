package dao;

import model.Cliente;
import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class clientedao {

    public void salvar(String codCliente, Cliente cliente) {
        String sql = "INSERT INTO Clientes (CodCliente, Nome, Email, CPF) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codCliente);
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getCPF());

            ps.executeUpdate();
            System.out.println("Cliente salvo com sucesso no banco!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT Nome, Email, CPF FROM Clientes";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("Nome");
                String email = rs.getString("Email");
                String cpf = rs.getString("CPF");

                Cliente c = new Cliente(nome, email, cpf);
                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
