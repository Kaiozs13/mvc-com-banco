package dao;

import java.util.ArrayList;
import java.util.List;
import model.Estoque;

public class estoquedao {
    private List<Estoque> listaEstoques = new ArrayList<>();

    public void salvar(Estoque estoque) {
        listaEstoques.add(estoque);
        //System.out.println("Estoque salvo com sucesso!");
    }

    public List<Estoque> listarTodos() {
        return listaEstoques;
    }
}
