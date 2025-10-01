package dao;

import model.Funcionario;
import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class funcionariodao {

    public void salvar(String codigo, Funcionario funcionario) {
        String sqlFunc = "INSERT INTO Funcionarios (Codigo, Nome, CategoriaFunc, CPF) VALUES (?, ?, ?, ?)";
        String sqlTel = "INSERT INTO TelefonesFuncionarios (Numero, Codigo) VALUES (?, ?)";
        String sqlEnd = "INSERT INTO EnderecosFun (Rua, Numero, Bairro, Cidade, Estado, CEP, Codigo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sqlFunc)) {
                ps.setString(1, codigo);
                ps.setString(2, funcionario.getNome());
                ps.setString(3, funcionario.getCategoria());
                ps.setString(4, funcionario.getCpf());
                ps.executeUpdate();
            }

            try (PreparedStatement ps = conn.prepareStatement(sqlTel)) {
                ps.setString(1, funcionario.getTelefone());
                ps.setString(2, codigo);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = conn.prepareStatement(sqlEnd)) {
                ps.setString(1, funcionario.getRua());
                ps.setInt(2, funcionario.getNdacasa());
                ps.setString(3, funcionario.getBairro());
                ps.setString(4, funcionario.getCidade());
                ps.setString(5, funcionario.getEstado());
                ps.setString(6, funcionario.getCep());
                ps.setString(7, codigo);
                ps.executeUpdate();
            }

            conn.commit();
            System.out.println("Funcionário salvo com sucesso no banco!");

        } catch (Exception e) {
            System.err.println("Erro ao salvar funcionário: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Funcionario> listarTodos() {
        List<Funcionario> lista = new ArrayList<>();

        String sql = "SELECT f.Nome, f.CPF, f.CategoriaFunc, " +
                "e.Rua, e.Numero, e.Bairro, e.Cidade, e.Estado, e.CEP, " +
                "t.Numero AS Telefone " +
                "FROM Funcionarios f " +
                "LEFT JOIN EnderecosFun e ON f.Codigo = e.Codigo " +
                "LEFT JOIN TelefonesFuncionarios t ON f.Codigo = t.Codigo";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("Nome");
                String cpf = rs.getString("CPF");
                String categoria = rs.getString("CategoriaFunc");
                String rua = rs.getString("Rua");
                String bairro = rs.getString("Bairro");
                String cidade = rs.getString("Cidade");
                String estado = rs.getString("Estado");
                String cep = rs.getString("CEP");
                String telefone = rs.getString("Telefone");


                int numeroCasa = rs.getInt("Numero");
                if (rs.wasNull()) {
                    numeroCasa = 0;
                }

                Funcionario f = new Funcionario(
                        nome, cpf, categoria,
                        rua, bairro,
                        numeroCasa,
                        cidade, estado, cep,
                        telefone
                );
                lista.add(f);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar funcionários: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    public Funcionario buscarPorCPF(String cpf) {
        String sql = "SELECT f.Codigo, f.Nome, f.CategoriaFunc, f.CPF, " +
                "e.Rua, e.Numero, e.Bairro, e.Cidade, e.Estado, e.CEP, " +
                "t.Numero AS Telefone " +
                "FROM Funcionarios f " +
                "LEFT JOIN EnderecosFun e ON f.Codigo = e.Codigo " +
                "LEFT JOIN TelefonesFuncionarios t ON f.Codigo = t.Codigo " +
                "WHERE f.CPF = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int numeroCasa = rs.getInt("Numero");
                if (rs.wasNull()) {
                    numeroCasa = 0;
                }

                return new Funcionario(
                        rs.getString("Nome"),
                        rs.getString("CPF"),
                        rs.getString("CategoriaFunc"),
                        rs.getString("Rua"),
                        rs.getString("Bairro"),
                        numeroCasa,
                        rs.getString("Cidade"),
                        rs.getString("Estado"),
                        rs.getString("CEP"),
                        rs.getString("Telefone")
                );
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar funcionário por CPF: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}