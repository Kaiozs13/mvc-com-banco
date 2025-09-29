package model;

public class Fornecedor {
    private String idFornecedor;  // agora é String
    private String nome;
    private String email;
    private String CNPJ;
    private String representante;
    private String telefone;

    private String rua;
    private String bairro;
    private int Ndacasa;
    private String cidade;
    private String estado;
    private String cep;

    public Fornecedor(String idFornecedor, String nome, String email, String CNPJ, String representante, String telefone,
                      String rua, String bairro, int Ndacasa, String cidade, String estado, String cep) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.email = email;
        this.CNPJ = CNPJ;
        this.representante = representante;
        this.telefone = telefone;

        this.rua = rua;
        this.bairro = bairro;
        this.Ndacasa = Ndacasa;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getIdFornecedor() {
        return idFornecedor;
    }
    public void setIdFornecedor(String idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRepresentante() {
        return representante;
    }
    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNdacasa() {
        return Ndacasa;
    }
    public void setNdacasa(int Ndacasa) {
        this.Ndacasa = Ndacasa;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
