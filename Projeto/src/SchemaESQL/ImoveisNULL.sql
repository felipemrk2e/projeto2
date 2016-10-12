CREATE DATABASE projetodois;
USE projetodois;

-- V 2.4 do SQL null--
-- edicoes --
/*
	Acréscimo do atributo booleano 'ativo' à tabela Imovel
*/

CREATE TABLE TipoImovel(
    idTipoImovel INT AUTO_INCREMENT NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    CONSTRAINT pk_idTipoImovel PRIMARY KEY(idTipoImovel)
);

CREATE TABLE Estado(
    id int(11) NOT NULL,
    nome varchar(45) NOT NULL,
    sigla varchar(2) NOT NULL,
    PRIMARY KEY (id, sigla)
);


CREATE TABLE Cidade(
    idCidade INT NOT NULL AUTO_INCREMENT,
    nomeCidade VARCHAR(255) NOT NULL,
    idEstado INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idCidade),
    CONSTRAINT FOREIGN KEY (idEstado)
    REFERENCES Estado(id)
);


CREATE TABLE Bairro(
    idBairro INT NOT NULL AUTO_INCREMENT,
    nomeBairro VARCHAR(255) NOT NULL,
    idCidade INT NOT NULL,
    CONSTRAINT PRIMARY KEY (idBairro),
    CONSTRAINT FOREIGN KEY (idCidade)
    REFERENCES Cidade(idCidade)
);

CREATE TABLE Endereco(
    idEndereco INT NOT NULL AUTO_INCREMENT,
    nomeEndereco VARCHAR(255),
    numero INT,
    zona VARCHAR(255),
    referencia VARCHAR(255),
    complemento VARCHAR(255),
    nomeCondominio VARCHAR(255),
    cep VARCHAR(10),
    idBairro INT,
    CONSTRAINT PRIMARY KEY(idEndereco),
    CONSTRAINT FOREIGN KEY (idBairro)
    REFERENCES Bairro(idBairro)
);

CREATE TABLE Documentacao(
    idDocumentacao INT NOT NULL AUTO_INCREMENT,
    numMatricula VARCHAR(255),
    numContaAgua VARCHAR(255),
    numContaLuz VARCHAR(255),
    numIptu VARCHAR(255),
    numContrato VARCHAR(255),
    cartorio VARCHAR(255),
    CONSTRAINT PRIMARY KEY(idDocumentacao)
);

CREATE TABLE Terreno(
    idTerreno INT NOT NULL AUTO_INCREMENT,
    comprimento DOUBLE,
    largura DOUBLE,
    areaConstruida DOUBLE,
    situacaoEscritura VARCHAR(255),
    CONSTRAINT PRIMARY KEY (idTerreno)
);

CREATE TABLE Imovel(
    idImovel INT AUTO_INCREMENT NOT NULL,
    ativo BOOLEAN DEFAULT 1,
    qtdQuartos INT,
    qtdSuites INT,
    qtdSalas INT,
    qtdBanheiros INT,
    qtdPisos INT,
    lavanderia INT,
    vagasGaragem INT,
    areaServico INT,
    piscina INT,
    lavabos INT,
    depEmpregados INT,
    areaExterna VARCHAR(255),
    dataConstrucao DATE,
    acabamento TEXT,
    outrosItens TEXT,
    descImovel VARCHAR(255),
    observacoes VARCHAR(255),
    chaves VARCHAR(125),
    tipoMobilia INT,
    descMobilia VARCHAR(255),   
    valorIptu DECIMAL(10,2),
    valorCondominio DECIMAL(10,2),
    idTipoImovel INT,
    idEndereco INT,
    idDocumentacao INT,
    idTerreno INT,
    CONSTRAINT pk_idImovel PRIMARY KEY (idImovel),
    CONSTRAINT fk_tipoImovel FOREIGN KEY (idTipoImovel)
    REFERENCES TipoImovel(idTipoImovel),
    CONSTRAINT fk_idEndereco FOREIGN KEY (idEndereco)
    REFERENCES Endereco(idEndereco),
    CONSTRAINT fk_idDocumentacao FOREIGN KEY(idDocumentacao)
    REFERENCES Documentacao(idDocumentacao),
    CONSTRAINT fk_idTerreno FOREIGN KEY(idTerreno)
    REFERENCES Terreno(idTerreno)
);

CREATE TABLE TipoContrato(
    idTipoContrato INT NOT NULL AUTO_INCREMENT,
    tipoContrato VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    CONSTRAINT PRIMARY KEY(idTipoContrato)
);

CREATE TABLE Imovel_has_TipoContrato(
    idImovel INT NOT NULL,
    idTipoContrato INT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    CONSTRAINT PRIMARY KEY(idImovel, idTipoContrato),
    CONSTRAINT FOREIGN KEY(idImovel)
    REFERENCES Imovel(idImovel),
    CONSTRAINT FOREIGN KEY(idTipoContrato)
    REFERENCES TipoContrato(idTipoContrato)
);