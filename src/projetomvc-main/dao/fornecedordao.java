package dao;

import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

public class fornecedordao {
    private List<Fornecedor> listaFornecedores = new ArrayList<>();

    public void salvar(Fornecedor fornecedor) {
        listaFornecedores.add(fornecedor);
        System.out.println("Fornecedor salvo com sucesso!");
    }

    public List<Fornecedor> listarTodos() {
        return listaFornecedores;
    }
}
