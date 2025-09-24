package dao;

import java.util.ArrayList;
import java.util.List;
import model.Produtos;

public class produtosdao {
    private List<Produtos> listaProdutos = new ArrayList<>();

    public void salvar(Produtos produto) {
        listaProdutos.add(produto);
        System.out.println("Produto salvo com sucesso!");
    }

    public List<Produtos> listarTodos() {
        return listaProdutos;
    }

    public Produtos buscarPorId(int id) {
        return listaProdutos.stream().filter(p -> p.getIdProduto() == id).findFirst().orElse(null);
    }
}
