CREATE DATABASE ProjetoDois;
USE ProjetoDois;


-- V 1.6 do SQL --
-- Estrutura das entidades Estado e Cidade foram alteradas --



/* Tipo do Imovel:
*  casa, apartamento, etc. */

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
    depEmpregrados INT NOT NULL,
    areaExterna VARCHAR(255) NOT NULL,
    dataConstrucao DATE NOT NULL,
    acabamento TEXT NOT NULL,
    outrosItens TEXT NOT NULL,
    descricaoImovel VARCHAR(255) NOT NULL,
    observacoes VARCHAR(255) NOT NULL,
    chaves VARCHAR(125) NOT NULL,
    valorIptu DECIMAL(10,2) NOT NULL,
    valorCondominio DECIMAL(10,2),
    idTipoImovel INT NOT NULL,
    idMobilia INT NOT NULL,
    CONSTRAINT pk_idImovel PRIMARY KEY (idImovel),
    CONSTRAINT fk_tipoImovel FOREIGN KEY (idTipoImovel)
    REFERENCES TipoImovel(idTipoImovel),
    CONSTRAINT fk_mobilia FOREIGN KEY (idMobilia)
    REFERENCES Mobilia(idMobilia)
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


/* Tipos de Contrato:
*  Locação, venda, etc. */
CREATE TABLE TipoLocacao(
    idTipoLocacao INT NOT NULL AUTO_INCREMENT,
    tipoContrato VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    CONSTRAINT PRIMARY KEY(idTipoLocacao)
);


/* Relação do Imovel e dos Tipos de Contrato 
*  O preço encontra-se na relação */


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

-- 1.2 add:Cidade
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
    rua VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    zona VARCHAR(255) NOT NULL,
    referencia VARCHAR(255) NOT NULL,
    nomeCondominio VARCHAR(255),
    idBairro INT NOT NULL,
    CONSTRAINT pk_LocalImovel_idImovel PRIMARY KEY(idImovel),
    CONSTRAINT fk_Imovel_idImovel FOREIGN KEY (idImovel)
    REFERENCES Imovel(idImovel),
    CONSTRAINT FOREIGN KEY (idBairro)
    REFERENCES Bairro(idBairro)
);




