package model;

public class Fornecedor {
    private int idFornecedor;
    private String nome;
    private String email;
    private String CNPJ;
    private String representante;
    private String telefone;
<<<<<<< HEAD
    private String rua;
    private String bairro;
    private int Ndacasa;
    private String cidade;
    private String estado;
    private String cep;
=======
>>>>>>> 5b0563573f0971f6e6555c6125a1c3676340252b

    public Fornecedor(int idFornecedor, String nome, String email, String CNPJ, String representante, String telefone) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.email = email;
        this.CNPJ = CNPJ;
        this.representante = representante;
        this.telefone = telefone;
<<<<<<< HEAD
        this.rua = rua;
        this.bairro = bairro;
        this.Ndacasa = Ndacasa;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
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

    
=======
    }

    public int getIdFornecedor() { return idFornecedor; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCNPJ() { return CNPJ; }
    public String getRepresentante() { return representante; }
    public String getTelefone() { return telefone; }
}
>>>>>>> 5b0563573f0971f6e6555c6125a1c3676340252b
