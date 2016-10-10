CREATE DATABASE projetodois;
USE projetodois;


-- V 2.1 do SQL --
-- edicoes --
/*
	A tabela Endereco recebeu o atributo Complemento
	Imovel:TipoImovel agora é do tipo INT
	Documentacao recebeu o atributo numMatricula
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

CREATE TABLE Documentacao(
    idDocumentacao INT NOT NULL,
	numMatricula VARCHAR(255),
    numContaAgua VARCHAR(255) NOT NULL,
    numContaLuz VARCHAR(255) NOT NULL,
    numIptu VARCHAR(255) NOT NULL,
    numContrato VARCHAR(255) NOT NULL,
    cartorio VARCHAR(255) NOT NULL,
    CONSTRAINT PRIMARY KEY(idDocumentacao)
);

CREATE TABLE Endereco(
    idEndereco INT AUTO_INCREMENT NOT NULL,
    nomeEndereco VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    zona VARCHAR(255),
    referencia VARCHAR(255),
	complemento VARCHAR(255),
    nomeCondominio VARCHAR(255),
    idBairro INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idEndereco),
    CONSTRAINT FOREIGN KEY (idBairro)
    REFERENCES Bairro(idBairro)
);

CREATE TABLE Terreno(
    idTerreno INT NOT NULL AUTO_INCREMENT,
    comprimento DOUBLE NOT NULL,
    largura DOUBLE NOT NULL,
    areaConstruida DOUBLE NOT NULL,
    situacaoEscritura VARCHAR(255) NOT NULL,
    CONSTRAINT PRIMARY KEY (idTerreno)
);

CREATE TABLE Imovel(
    idImovel INT AUTO_INCREMENT NOT NULL,
    qtdQuartos INT NOT NULL,
    qtdSuites INT NOT NULL,
    qtdSalas INT NOT NULL,
    qtdBanheiros INT NOT NULL,
    qtdPisos INT NOT NULL,
    lavanderia INT NOT NULL,
    vagasGaragem INT NOT NULL,
    areaServico INT NOT NULL,
    piscina INT NOT NULL,
    lavabos INT NOT NULL,
    depEmpregados INT NOT NULL,
    areaExterna VARCHAR(255),
    dataConstrucao DATE NOT NULL,
    acabamento TEXT,
    outrosItens TEXT,
    descImovel VARCHAR(255) NOT NULL,
    observacoes VARCHAR(255),
    chaves VARCHAR(125) NOT NULL,
    tipoMobilia INT NOT NULL,
    descMobilia VARCHAR(255),   
    valorIptu DECIMAL(10,2) NOT NULL,
    valorCondominio DECIMAL(10,2),
    idTipoImovel INT NOT NULL,
    idEndereco INT NOT NULL,
    idDocumentacao INT NOT NULL,
    idTerreno INT NOT NULL,
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


CREATE TABLE Documentos(
    idImovel INT NOT NULL,
    numContaAgua VARCHAR(255) NOT NULL,
    numContaLuz VARCHAR(255) NOT NULL,
    numIptu VARCHAR(255) NOT NULL,
    numContrato VARCHAR(255) NOT NULL,
    cartorio VARCHAR(255) NOT NULL,
    CONSTRAINT PRIMARY KEY(idImovel),
    CONSTRAINT FOREIGN KEY (idImovel)
    REFERENCES Imovel(idImovel)
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
