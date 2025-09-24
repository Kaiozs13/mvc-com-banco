package model;

public class Estoque {
    private int idEstoque;
    private Produtos produto;
    private int quantidadeAtual;
    private String localArmazenamento;
    private String dataEntrada;
    private String dataUltimaSaida;

    public Estoque(int idEstoque, Produtos produto, int quantidadeAtual, String localArmazenamento, String dataEntrada, String dataUltimaSaida) {
        this.idEstoque = idEstoque;
        this.produto = produto;
        this.quantidadeAtual = quantidadeAtual;
        this.localArmazenamento = localArmazenamento;
        this.dataEntrada = dataEntrada;
        this.dataUltimaSaida = dataUltimaSaida;
    }

    public int getIdEstoque() { return idEstoque; }
    public Produtos getProduto() { return produto; }
    public int getQuantidadeAtual() { return quantidadeAtual; }
    public String getLocalArmazenamento() { return localArmazenamento; }
    public String getDataEntrada() { return dataEntrada; }
    public String getDataUltimaSaida() { return dataUltimaSaida; }
}
