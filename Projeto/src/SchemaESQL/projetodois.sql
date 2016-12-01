CREATE DATABASE projetodois;
USE projetodois;

/* Adição da tabela Status que se relaciona com Imovel
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

CREATE TABLE Documentacao(
    idDocumentacao INT AUTO_INCREMENT NOT NULL,
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
    bairro VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    zona VARCHAR(255),
    referencia VARCHAR(255),
    complemento VARCHAR(255),
    nomeCondominio VARCHAR(255),
    cep VARCHAR(10) NOT NULL,
    idCidade INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idEndereco),
    CONSTRAINT FOREIGN KEY (idCidade)
    REFERENCES Cidade(idCidade)
);

CREATE TABLE Terreno(
    idTerreno INT NOT NULL AUTO_INCREMENT,
    comprimento DOUBLE NOT NULL,
    largura DOUBLE NOT NULL,
    areaConstruida DOUBLE NOT NULL,
    situacaoEscritura VARCHAR(255) NOT NULL,
    CONSTRAINT PRIMARY KEY (idTerreno)
);

CREATE TABLE `Status`(
	idStatus INT NOT NULL AUTO_INCREMENT,
    `status` VARCHAR(255) NOT NULL,
    CONSTRAINT PRIMARY KEY(idStatus)
);

CREATE TABLE Imovel(
    idImovel INT AUTO_INCREMENT NOT NULL,
    ativo BOOLEAN DEFAULT 1 NOT NULL,
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
    anoConstrucao INT NOT NULL,
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
    idStatus INT NOT NULL,
    CONSTRAINT pk_idImovel PRIMARY KEY (idImovel),
    CONSTRAINT fk_tipoImovel FOREIGN KEY (idTipoImovel)
    REFERENCES TipoImovel(idTipoImovel),
    CONSTRAINT fk_idEndereco FOREIGN KEY (idEndereco)
    REFERENCES Endereco(idEndereco),
    CONSTRAINT fk_idDocumentacao FOREIGN KEY(idDocumentacao)
    REFERENCES Documentacao(idDocumentacao),
    CONSTRAINT fk_idTerreno FOREIGN KEY(idTerreno)
    REFERENCES Terreno(idTerreno),
    CONSTRAINT fk_idStatus FOREIGN KEY(idStatus)
    REFERENCES `Status`(idStatus)
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

CREATE TABLE EstadoCivil(
    idEstadoCivil INT AUTO_INCREMENT NOT NULL,
    nomeEstadoCivil VARCHAR(45) NOT NULL,
    CONSTRAINT PRIMARY KEY(idEstadoCivil)
);

CREATE TABLE Departamento(
    idDepartamento INT AUTO_INCREMENT NOT NULL,
    nomeDepartamento VARCHAR(45) NOT NULL,
    telefoneDepartamento VARCHAR(45) NOT NULL,
    ramal VARCHAR(45),
    CONSTRAINT PRIMARY KEY(idDepartamento)
);

CREATE TABLE Cargo(
    idCargo INT AUTO_INCREMENT NOT NULL,
    nomeCargo VARCHAR(45) NOT NULL,
    descricaoCargo VARCHAR(45),
    idDepartamento INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idCargo),
    CONSTRAINT FOREIGN KEY(idDepartamento)
    REFERENCES Departamento(idDepartamento)
);

CREATE TABLE Pessoa(
    idPessoa INT AUTO_INCREMENT NOT NULL,
    ativo BOOLEAN DEFAULT 1 NOT NULL,
    nomePessoa VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    observacoes VARCHAR(60),
    dataNascimento DATE NOT NULL,
    idEndereco INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idPessoa),
    CONSTRAINT FOREIGN KEY(idEndereco)
    REFERENCES Endereco(idEndereco)
);

CREATE TABLE Locacao(
    idImovel INT NOT NULL,
    idPessoa INT NOT NULL,
    dataInicio DATE NOT NULL,
    dataFim DATE NOT NULL,
    CONSTRAINT PRIMARY KEY(idImovel),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES Pessoa(idPessoa),
    CONSTRAINT FOREIGN KEY(idImovel)
    REFERENCES Imovel(idImovel)
);

CREATE TABLE Telefone(
    idTelefone INT AUTO_INCREMENT NOT NULL,
    numero VARCHAR(14) NOT NULL,
    operadora VARCHAR(45) NOT NULL,
    idPessoa INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idTelefone),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES Pessoa(idPessoa)
);

CREATE TABLE PessoaFisica(
	idPessoa INT NOT NULL,
    cpf CHAR(14) NOT NULL,
    rg VARCHAR(25) NOT NULL,
    sexo CHAR(1) NOT NULL,
    idEstadoCivil INT NOT NULL,    
    CONSTRAINT PRIMARY KEY(idPessoa),
    CONSTRAINT FOREIGN KEY(idEstadoCivil)
    REFERENCES EstadoCivil(idEstadoCivil),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES Pessoa(idPessoa)
);

CREATE TABLE fiadorDe(
    idPessoa INT NOT NULL,
    idFiador INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idPessoa, idFiador),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES PessoaFisica(idPessoa),
    CONSTRAINT FOREIGN KEY(idFiador)
    REFERENCES PessoaFisica(idPessoa)
);

CREATE TABLE Login(
    idLogin INT AUTO_INCREMENT NOT NULL,
    nomeUsuario VARCHAR(40) NOT NULL,
    senhaUsuario VARCHAR(40) NOT NULL,
    nivelAcesso INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idLogin)    
);

CREATE TABLE Funcionario(  
    idPessoa INT NOT NULL,  
    salario DOUBLE NOT NULL,
    banco VARCHAR(45) NOT NULL,
    tipoConta VARCHAR(45) NOT NULL,
    conta VARCHAR(45) NOT NULL,
    agencia VARCHAR(45) NOT NULL,
    ctps VARCHAR(20) NOT NULL,
    serieCtps VARCHAR(20) NOT NULL,
    dataAdmissao DATE NOT NULL,
    cargaHoraria VARCHAR(20) NOT NULL,
    escolaridade VARCHAR(45) NOT NULL,
    dependentes INT NOT NULL,
    
    idCargo INT NOT NULL,
    idLogin INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idPessoa),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES PessoaFisica(idPessoa),
    CONSTRAINT FOREIGN KEY(idCargo)
    REFERENCES Cargo(idCargo),
	CONSTRAINT FOREIGN KEY(idLogin)
    REFERENCES Login(idLogin)	
	);

CREATE TABLE PessoaJuridica(   
	idPessoa INT NOT NULL,
    cnpj CHAR(18) NOT NULL,
    inscricaoEstadual VARCHAR(20),
    cadastroAtivo BOOLEAN NOT NULL,
    nomeFantasia VARCHAR(45) NOT NULL,
    nomeResponsavel VARCHAR(45) NOT NULL,
    cpfResponsavel CHAR(14) NOT NULL,    
	CONSTRAINT PRIMARY KEY(idPessoa),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES Pessoa(idPessoa)
);

CREATE TABLE Pessoa_has_Interesse(
    idPessoa INT NOT NULL,
    idTipoContrato INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idPessoa, idTipoContrato),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES Pessoa(idPessoa),
    CONSTRAINT FOREIGN KEY(idTipoContrato)
    REFERENCES TipoContrato(idTipoContrato)
);
