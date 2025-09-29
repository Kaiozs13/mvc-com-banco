package dao;

import model.Fornecedor;
import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class fornecedordao {

    public void salvar(Fornecedor fornecedor) {
        String sqlFor = "INSERT INTO Fornecedores (IdFornecedor, Nome, Email, CNPJ, Representante) VALUES (?, ?, ?, ?, ?)";
        String sqlTel = "INSERT INTO TelefonesFornecedores (Numero, IdFornecedor) VALUES (?, ?)";
        String sqlEnd = "INSERT INTO EnderecosFor (Rua, Numero, Bairro, Cidade, Estado, CEP, IdFornecedor) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            // --- Fornecedor
            try (PreparedStatement ps = conn.prepareStatement(sqlFor)) {
                ps.setString(1, fornecedor.getIdFornecedor());
                ps.setString(2, fornecedor.getNome());
                ps.setString(3, fornecedor.getEmail());
                ps.setString(4, fornecedor.getCNPJ());
                ps.setString(5, fornecedor.getRepresentante());
                ps.executeUpdate();
            }

            // --- Telefone
            try (PreparedStatement ps = conn.prepareStatement(sqlTel)) {
                ps.setString(1, fornecedor.getTelefone());
                ps.setString(2, fornecedor.getIdFornecedor());
                ps.executeUpdate();
            }

            // --- Endereço
            try (PreparedStatement ps = conn.prepareStatement(sqlEnd)) {
                ps.setString(1, fornecedor.getRua());
                ps.setString(2, String.valueOf(fornecedor.getNdacasa()));
                ps.setString(3, fornecedor.getBairro());
                ps.setString(4, fornecedor.getCidade());
                ps.setString(5, fornecedor.getEstado());
                ps.setString(6, fornecedor.getCep());
                ps.setString(7, fornecedor.getIdFornecedor());
                ps.executeUpdate();
            }

            conn.commit();
            System.out.println("Fornecedor salvo com sucesso no banco!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Fornecedor> listarTodos() {
        List<Fornecedor> lista = new ArrayList<>();

        String sql = "SELECT f.IdFornecedor, f.Nome, f.Email, f.CNPJ, f.Representante, " +
                "t.Numero AS Telefone, " +
                "e.Rua, e.Numero, e.Bairro, e.Cidade, e.Estado, e.CEP " +
                "FROM Fornecedores f " +
                "LEFT JOIN TelefonesFornecedores t ON f.IdFornecedor = t.IdFornecedor " +
                "LEFT JOIN EnderecosFor e ON f.IdFornecedor = e.IdFornecedor";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String idFornecedor = rs.getString("IdFornecedor");
                String nome = rs.getString("Nome");
                String email = rs.getString("Email");
                String cnpj = rs.getString("CNPJ");
                String representante = rs.getString("Representante");
                String telefone = rs.getString("Telefone");

                String rua = rs.getString("Rua");
                String numeroCasa = rs.getString("Numero");
                String bairro = rs.getString("Bairro");
                String cidade = rs.getString("Cidade");
                String estado = rs.getString("Estado");
                String cep = rs.getString("CEP");

                Fornecedor fornecedor = new Fornecedor(
                        idFornecedor, nome, email, cnpj, representante, telefone,
                        rua, bairro, numeroCasa != null ? Integer.parseInt(numeroCasa) : 0,
                        cidade, estado, cep
                );

                lista.add(fornecedor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
