CREATE DATABASE projetodois;
USE projetodois;

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
    idEndereco INT AUTO_INCREMENT NOT NULL,
    nomeEndereco VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    zona VARCHAR(255),
    referencia VARCHAR(255),
    complemento VARCHAR(255),
    nomeCondominio VARCHAR(255),
    cep VARCHAR(10) NOT NULL,
    idBairro INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idEndereco),
    CONSTRAINT FOREIGN KEY (idBairro)
    REFERENCES Bairro(idBairro)
);

CREATE TABLE TipoContrato(
    idTipoContrato INT NOT NULL AUTO_INCREMENT,
    tipoContrato VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    CONSTRAINT PRIMARY KEY(idTipoContrato)
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
    nomePessoa VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    observacoes VARCHAR(60),
    dataNascimento DATE NOT NULL,
    idEndereco INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idPessoa),
    CONSTRAINT FOREIGN KEY(idEndereco)
    REFERENCES Endereco(idEndereco)
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
    idPessoaFisica INT AUTO_INCREMENT NOT NULL,
    cpf CHAR(14) NOT NULL,
    rg VARCHAR(25) NOT NULL,
    sexo CHAR(1) NOT NULL,
    idEstadoCivil INT NOT NULL,
    idPessoa INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idPessoaFisica),
    CONSTRAINT FOREIGN KEY(idEstadoCivil)
    REFERENCES EstadoCivil(idEstadoCivil),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES Pessoa(idPessoa)
);

CREATE TABLE fiadorDe(
    idPessoaFisica INT NOT NULL,
    idFiador INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idPessoaFisica, idFiador),
    CONSTRAINT FOREIGN KEY(idPessoaFisica)
    REFERENCES PessoaFisica(idPessoaFisica),
    CONSTRAINT FOREIGN KEY(idFiador)
    REFERENCES PessoaFisica(idPessoaFisica)
);

CREATE TABLE Funcionario(
    idFuncionario INT AUTO_INCREMENT NOT NULL,
    salario DOUBLE NOT NULL,
    banco VARCHAR(45) NOT NULL,
    tipoConta VARCHAR(45) NOT NULL,
    conta VARCHAR(45) NOT NULL,
    agencia VARCHAR(45) NOT NULL,
    ctps VARCHAR(20) NOT NULL,
    pis VARCHAR(30) NOT NULL,
    serieCtps VARCHAR(20) NOT NULL,
    dataAdmissao DATE NOT NULL,
    cargaHoraria VARCHAR(20) NOT NULL,
    escolaridade VARCHAR(45) NOT NULL,
    dependentes INT NOT NULL,
    idPessoaFisica INT NOT NULL,
    idCargo INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idFuncionario),
    CONSTRAINT FOREIGN KEY(idPessoaFisica)
    REFERENCES PessoaFisica(idPessoaFisica),
    CONSTRAINT FOREIGN KEY(idCargo)
    REFERENCES Cargo(idCargo)
);

CREATE TABLE PessoaJuridica(
    idPessoaJuridica INT AUTO_INCREMENT NOT NULL,
    cnpj CHAR(18) NOT NULL,
    inscricaoEstadual VARCHAR(20),
    cadastroAtivo BOOLEAN NOT NULL,
    nomeFantasia VARCHAR(45),
    nomeResponsavel VARCHAR(45) NOT NULL,
    cpfResponsavel CHAR(14) NOT NULL,
    idPessoa INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idPessoaJuridica),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES Pessoa(idPessoa)
);

CREATE TABLE Login(
    idLogin INT NOT NULL,
    nomeUsuario VARCHAR(40) NOT NULL,
    senhaUsuario VARCHAR(40) NOT NULL,
    nivelAcesso INT NOT NULL,
    idFuncionario INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idLogin),
    CONSTRAINT FOREIGN KEY(idFuncionario)
    REFERENCES Funcionario(idFuncionario)
);

CREATE TABLE Pessoa_has_Interesse(
    idPessoa INT NOT NULL,
    idTipoContrato INT NOT NULL,
    CONSTRAINT PRIMARY KEY(idPessoa, idInteresse),
    CONSTRAINT FOREIGN KEY(idPessoa)
    REFERENCES Pessoa(idPessoa),
    CONSTRAINT FOREIGN KEY(idTipoContrato)
    REFERENCES TipoContrato(idTipoContrato)
);
