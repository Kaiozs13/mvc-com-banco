package model;

public class Produtos {
    private String idProduto;
    private String nome;
    private String descricao;
    private String categoria;
    private String fabricante;
    private double preco;
    private String dataValidade;

    private int quantidadeAtual;
    private String localArmazenamento;
    private String dataEntrada;
    private String dataUltimaSaida;

    public Produtos(String idProduto, String nome, String descricao, String categoria, String fabricante, double preco, String dataValidade, int quantidadeAtual, String localArmazenamento, String dataEntrada, String dataUltimaSaida) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.fabricante = fabricante;
        this.preco = preco;
        this.dataValidade = dataValidade;
        this.quantidadeAtual = quantidadeAtual;
        this.localArmazenamento = localArmazenamento;
        this.dataEntrada = dataEntrada;
        this.dataUltimaSaida = dataUltimaSaida;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public String getLocalArmazenamento() {
        return localArmazenamento;
    }

    public void setLocalArmazenamento(String localArmazenamento) {
        this.localArmazenamento = localArmazenamento;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataUltimaSaida() {
        return dataUltimaSaida;
    }

    public void setDataUltimaSaida(String dataUltimaSaida) {
        this.dataUltimaSaida = dataUltimaSaida;
    }
}


