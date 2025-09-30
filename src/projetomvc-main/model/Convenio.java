package model;

public class Convenio {
    private String idConvenio;
    private String descontoOferecido;
    private String CNPJ;

    public Convenio(String idConvenio, String descontoOferecido, String CNPJ) {
        this.idConvenio = idConvenio;
        this.descontoOferecido = descontoOferecido;
        this.CNPJ = CNPJ;
    }

    public String getIdConvenio() { return idConvenio; }
    public String getDescontoOferecido() { return descontoOferecido; }
    public String getCNPJ() { return CNPJ; }
}
