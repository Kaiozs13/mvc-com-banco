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
        String sqlTel  = "INSERT INTO TelefonesFuncionarios (Numero, Codigo) VALUES (?, ?)";
        String sqlEnd  = "INSERT INTO EnderecosFun (Rua, Numero, Bairro, Cidade, Estado, CEP, Codigo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false); // tudo ou nada

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
                ps.setString(2, String.valueOf(funcionario.getNdacasa()));
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
                String numeroCasa = rs.getString("Numero");
                String bairro = rs.getString("Bairro");
                String cidade = rs.getString("Cidade");
                String estado = rs.getString("Estado");
                String cep = rs.getString("CEP");
                String telefone = rs.getString("Telefone");

                Funcionario f = new Funcionario(
                        nome, cpf, categoria,
                        rua, bairro,
                        numeroCasa != null && !numeroCasa.isEmpty() ? Integer.parseInt(numeroCasa) : 0,
                        cidade, estado, cep,
                        telefone
                );
                lista.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
