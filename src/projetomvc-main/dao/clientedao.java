package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class clientedao {
    
    private List<Cliente> listaClientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        listaClientes.add(cliente);
        System.out.println("Cliente salvo no DAO.");
    }

    public List<Cliente> listarTodos() {
        return listaClientes;
    }
}