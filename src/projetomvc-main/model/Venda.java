package model;

import java.util.List;

public class Venda {
    private String idVenda;
    private Produtos produto;
    private int quantidadeVendida;
    private double precoUnitario;
    private String dataVenda;
    private String nomeCliente;

    private List<Produtos> produtos;
    private List<Integer> quantidades;


    public Venda(String idVenda, Produtos produto, int quantidadeVendida, double precoUnitario, String dataVenda, String nomeCliente) {
        this.idVenda = idVenda;
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.precoUnitario = precoUnitario;
        this.dataVenda = dataVenda;
        this.nomeCliente = nomeCliente;
    }


    public Venda(String idVenda, List<Produtos> produtos, List<Integer> quantidades, String dataVenda, String nomeCliente) {
        this.idVenda = idVenda;
        this.produtos = produtos;
        this.quantidades = quantidades;
        this.dataVenda = dataVenda;
        this.nomeCliente = nomeCliente;
    }


    public String getIdVenda() { return idVenda; }
    public Produtos getProduto() { return produto; }
    public int getQuantidadeVendida() { return quantidadeVendida; }
    public double getPrecoUnitario() { return precoUnitario; }
    public String getDataVenda() { return dataVenda; }
    public String getNomeCliente() { return nomeCliente; }

    public void setIdVenda(String idVenda) { this.idVenda = idVenda; }
    public void setProduto(Produtos produto) { this.produto = produto; }
    public void setQuantidadeVendida(int quantidadeVendida) { this.quantidadeVendida = quantidadeVendida; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }
    public void setDataVenda(String dataVenda) { this.dataVenda = dataVenda; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }


    public List<Produtos> getProdutos() { return produtos; }
    public void setProdutos(List<Produtos> produtos) { this.produtos = produtos; }

    public List<Integer> getQuantidades() { return quantidades; }
    public void setQuantidades(List<Integer> quantidades) { this.quantidades = quantidades; }
}
