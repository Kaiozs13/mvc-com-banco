package dao;

import java.util.ArrayList;
import java.util.List;
import model.Venda;

public class VendaDAO {
    private List<Venda> listaVendas = new ArrayList<>();

    public void salvar(Venda venda) {
        listaVendas.add(venda);
        System.out.println("Venda registrada com sucesso!");
    }

    public List<Venda> listarTodos() {
        return listaVendas;
    }
}
