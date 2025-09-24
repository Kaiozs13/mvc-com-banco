package model;

public class Venda {
    private int idVenda;
    private Produtos produto;
    private int quantidadeVendida;
    private double precoUnitario;
    private String dataVenda;
    private String nomeCliente;

    public Venda(int idVenda, Produtos produto, int quantidadeVendida, double precoUnitario, String dataVenda, String nomeCliente) {
        this.idVenda = idVenda;
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.precoUnitario = precoUnitario;
        this.dataVenda = dataVenda;
        this.nomeCliente = nomeCliente;
    }

    public int getIdVenda() { return idVenda; }
    public Produtos getProduto() { return produto; }
    public int getQuantidadeVendida() { return quantidadeVendida; }
    public double getPrecoUnitario() { return precoUnitario; }
    public String getDataVenda() { return dataVenda; }
    public String getNomeCliente() { return nomeCliente; }
}
