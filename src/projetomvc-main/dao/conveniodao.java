package dao;

import java.util.ArrayList;
import java.util.List;
import model.Convenio;

public class conveniodao {
    private List<Convenio> listaConvenios = new ArrayList<>();

    public void salvar(Convenio convenio) {
        listaConvenios.add(convenio);
        System.out.println("Convênio salvo com sucesso!");
    }

    public List<Convenio> listarTodos() {
        return listaConvenios;
    }
}
