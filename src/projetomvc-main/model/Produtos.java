package model;

public class Produtos {
    private int idProduto;
    private String nome;
    private String descricao;
    private String fabricante;
    private double preco;
    private String dataValidade;

    public Produtos(int idProduto, String nome, String descricao, String fabricante, double preco, String dataValidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public int getIdProduto() { return idProduto; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getFabricante() { return fabricante; }
    public double getPreco() { return preco; }
    public String getDataValidade() { return dataValidade; }
}
