CREATE DATABASE ProjetoDois;
USE ProjetoDois;


-- V 1.6 do SQL NULL --

CREATE TABLE TipoImovel(
    idTipoImovel INT AUTO_INCREMENT NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    CONSTRAINT pk_idTipoImovel PRIMARY KEY(idTipoImovel)
);


CREATE TABLE Mobilia(
    idMobilia INT NOT NULL AUTO_INCREMENT,
    tipoMobilia VARCHAR(65) NOT NULL,
    CONSTRAINT PRIMARY KEY(idMobilia)
);


CREATE TABLE Imovel(
    idImovel INT AUTO_INCREMENT NOT NULL,
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
    depEmpregrados INT,
    areaExterna VARCHAR(255),
    dataConstrucao DATE,
    acabamento TEXT,
    outrosItens TEXT,
    descricaoImovel VARCHAR(255),
    observacoes VARCHAR(255),
    chaves VARCHAR(125),
    valorIptu DECIMAL(10,2),
    valorCondominio DECIMAL(10,2),
    idTipoImovel INT,
    idMobilia INT,
    CONSTRAINT pk_idImovel PRIMARY KEY (idImovel),
    CONSTRAINT fk_tipoImovel FOREIGN KEY (idTipoImovel)
    REFERENCES TipoImovel(idTipoImovel),
    CONSTRAINT fk_mobilia FOREIGN KEY (idMobilia)
    REFERENCES Mobilia(idMobilia)
);


CREATE TABLE Documentos(
    idImovel INT NOT NULL,
    numContaAgua VARCHAR(255),
    numContaLuz VARCHAR(255),
    numIptu VARCHAR(255),
    numContrato VARCHAR(255),
    cartorio VARCHAR(255),
    CONSTRAINT PRIMARY KEY(idImovel),
    CONSTRAINT FOREIGN KEY (idImovel)
    REFERENCES Imovel(idImovel)
);


-- 1.5 cumprimento-> comprimento -- 
CREATE TABLE Terreno(
    idTerreno INT NOT NULL AUTO_INCREMENT,
    idImovel INT,
    comprimento DOUBLE,
    largura DOUBLE,
    situacaoEscritura VARCHAR(255),
    CONSTRAINT PRIMARY KEY (idTerreno),
    CONSTRAINT FOREIGN KEY (idImovel)
    REFERENCES Imovel(idImovel)
);



CREATE TABLE TipoLocacao(
    idTipoLocacao INT NOT NULL AUTO_INCREMENT,
    tipoContrato VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    CONSTRAINT PRIMARY KEY(idTipoLocacao)
);


CREATE TABLE Imovel_has_TipoLocacao(
    idImovel INT NOT NULL,
    idTipoLocacao INT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    CONSTRAINT PRIMARY KEY(idImovel, idTipoLocacao),
    CONSTRAINT FOREIGN KEY(idImovel)
    REFERENCES Imovel(idImovel),
    CONSTRAINT FOREIGN KEY(idTipoLocacao)
    REFERENCES TipoLocacao(idTipoLocacao)
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



CREATE TABLE LocalImovel(
    idImovel INT NOT NULL AUTO_INCREMENT,
    rua VARCHAR(255),
    numero INT,
    zona VARCHAR(255) NOT NULL,
    referencia VARCHAR(255),
    nomeCondominio VARCHAR(255),
    idBairro INT,
    CONSTRAINT pk_LocalImovel_idImovel PRIMARY KEY(idImovel),
    CONSTRAINT fk_Imovel_idImovel FOREIGN KEY (idImovel)
    REFERENCES Imovel(idImovel),
    CONSTRAINT FOREIGN KEY (idBairro)
    REFERENCES Bairro(idBairro)
);




