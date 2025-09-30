package controller;

import model.Convenio;

public class conveniocontr {
    public Convenio criarConvenio(String idConvenio, String desconto, String CNPJ) {
        return new Convenio(idConvenio, desconto, CNPJ);
    }

    public void exibirConvenio(Convenio convenio) {
        System.out.println("ID: " + convenio.getIdConvenio() + ", Desconto: " + convenio.getDescontoOferecido() +
                           "%, CNPJ: " + convenio.getCNPJ());
    }
}
