CREATE DATABASE MVCVITALIS;
USE MVCVITALIS;

CREATE TABLE Clientes (
    CodCliente VARCHAR(5) NOT NULL,
    Nome VARCHAR(30) NOT NULL,
    Email VARCHAR(60) NOT NULL,
    CPF VARCHAR(11) NOT NULL, 
    PRIMARY KEY (CodCliente)
);


CREATE TABLE Fornecedores (
    IdFornecedor VARCHAR(5) NOT NULL,
    Nome VARCHAR(70) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    CNPJ VARCHAR(14) NOT NULL, 
    Representante VARCHAR(200) NOT NULL,
    PRIMARY KEY (IdFornecedor)
);


CREATE TABLE Funcionarios (
    Codigo VARCHAR(5) NOT NULL,
    Nome VARCHAR(30) NOT NULL,
    CategoriaFunc VARCHAR(30) NOT NULL,
    CPF VARCHAR(14) NOT NULL,
    PRIMARY KEY (Codigo)
);


CREATE TABLE TelefonesFuncionarios (
    Numero VARCHAR(15) NOT NULL,
    Codigo VARCHAR(5) NOT NULL,
    PRIMARY KEY (Numero),
    FOREIGN KEY (Codigo) REFERENCES Funcionarios(Codigo)
);


CREATE TABLE TelefonesFornecedores (
    Numero VARCHAR(15) NOT NULL,
    IdFornecedor VARCHAR(5) NOT NULL,
    PRIMARY KEY (Numero),
    FOREIGN KEY (IdFornecedor) REFERENCES Fornecedores(IdFornecedor)
);


CREATE TABLE Produtos (
    IdProduto VARCHAR(5) NOT NULL,
    Nome VARCHAR(50) NOT NULL,
    Produtos VARCHAR(200) NOT NULL,
    Preco DECIMAL(10,2) NOT NULL,
    Categoria VARCHAR(30) NOT NULL,
    Fabricante VARCHAR(50) NOT NULL,
    DataDeValidade VARCHAR(50) NOT NULL,
    PRIMARY KEY (IdProduto)
);


CREATE TABLE Vendas (
    IdVenda VARCHAR(5) NOT NULL,
    Quantidade INT NOT NULL,
    PrecoUnitario DECIMAL(10,2) NOT NULL,
    IdProduto VARCHAR(5) NOT NULL,
    CodCliente VARCHAR(5) NOT NULL,
    PRIMARY KEY (IdVenda),
    FOREIGN KEY (IdProduto) REFERENCES Produtos (IdProduto),
    FOREIGN KEY (CodCliente) REFERENCES Clientes (CodCliente)
);


CREATE TABLE Convenios (
    IdConvenio VARCHAR(5) NOT NULL,
    DescontoOferecido INT NOT NULL,
    CNPJ VARCHAR(14) NOT NULL,
    PRIMARY KEY (IdConvenio)
);


CREATE TABLE EnderecosFun (
    Rua VARCHAR(100) NOT NULL,
    Numero VARCHAR(10) NOT NULL,
    Bairro VARCHAR(50) NOT NULL,
    Cidade VARCHAR(50) NOT NULL,
    Estado VARCHAR(2) NOT NULL,
    CEP VARCHAR(9) NOT NULL,
    Codigo VARCHAR(5) NULL, 
    PRIMARY KEY (CEP),
    FOREIGN KEY (Codigo) REFERENCES Funcionarios(Codigo)
);


CREATE TABLE EnderecosFor (
    Rua VARCHAR(100) NOT NULL,
    Numero VARCHAR(10) NOT NULL,
    Bairro VARCHAR(50) NOT NULL,
    Cidade VARCHAR(50) NOT NULL,
    Estado VARCHAR(2) NOT NULL,
    CEP VARCHAR(9) NOT NULL,
    IdFornecedor VARCHAR(5) NULL,
    PRIMARY KEY (CEP),
    FOREIGN KEY (IdFornecedor) REFERENCES Fornecedores(IdFornecedor)
);

SELECT * FROM Clientes;
SELECT * FROM Fornecedores;
SELECT * FROM Funcionarios;
SELECT * FROM TelefonesFuncionarios;
SELECT * FROM TelefonesFornecedores;
SELECT * FROM Produtos;
SELECT * FROM Vendas;
SELECT * FROM Convenios;
SELECT * FROM EnderecosFun;
SELECT * FROM EnderecosFor;

ALTER TABLE Fornecedores
ADD COLUMN Telefone VARCHAR(20) NULL;

ALTER TABLE EnderecosFun
MODIFY CEP VARCHAR(15) NOT NULL;