package model;

public class Convenio {
    private int idConvenio;
    private int descontoOferecido;
    private String CNPJ;

    public Convenio(int idConvenio, int descontoOferecido, String CNPJ) {
        this.idConvenio = idConvenio;
        this.descontoOferecido = descontoOferecido;
        this.CNPJ = CNPJ;
    }

    public int getIdConvenio() { return idConvenio; }
    public int getDescontoOferecido() { return descontoOferecido; }
    public String getCNPJ() { return CNPJ; }
}
