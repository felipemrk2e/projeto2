-- Inserts BASE para o banco --

INSERT INTO TipoImovel(idTipoImovel, tipo) VALUES (0, 'Casa'),(0, 'Apartamento'), (0, 'Salão'), (0, 'Comércio'), (0, 'Temporário');

INSERT INTO TipoContrato(idTipoContrato, tipoContrato) VALUES(0, 'Locação'), (0, 'Venda'), (0, 'Temporada'), (0, 'Festa');

INSERT INTO Estado VALUES(1, 'Acre', 'AC');
INSERT INTO Estado VALUES(2, 'Alagoas', 'AL');
INSERT INTO Estado VALUES(3, 'Amazonas', 'AM');
INSERT INTO Estado VALUES(4, 'Amapá', 'AP');
INSERT INTO Estado VALUES(5, 'Bahia', 'BA');
INSERT INTO Estado VALUES(6, 'Ceará', 'CE');
INSERT INTO Estado VALUES(7, 'Distrito Federal', 'DF');
INSERT INTO Estado VALUES(8, 'Espírito Santo', 'ES');
INSERT INTO Estado VALUES(9, 'Goiás', 'GO');
INSERT INTO Estado VALUES(10, 'Maranhão', 'MA');
INSERT INTO Estado VALUES(11, 'Minas Gerais', 'MG');
INSERT INTO Estado VALUES(12, 'Mato Grosso do Sul', 'MS');
INSERT INTO Estado VALUES(13, 'Mato Grosso', 'MT');
INSERT INTO Estado VALUES(14, 'Pará', 'PA');
INSERT INTO Estado VALUES(15, 'Paraíba', 'PB');
INSERT INTO Estado VALUES(16, 'Pernambuco', 'PE');
INSERT INTO Estado VALUES(17, 'Piauí', 'PI');
INSERT INTO Estado VALUES(18, 'Paraná', 'PR');
INSERT INTO Estado VALUES(19, 'Rio de Janeiro', 'RJ');
INSERT INTO Estado VALUES(20, 'Rio Grande do Norte', 'RN');
INSERT INTO Estado VALUES(21, 'Rondônia', 'RO');
INSERT INTO Estado VALUES(22, 'Roraima', 'RR');
INSERT INTO Estado VALUES(23, 'Rio Grande do Sul', 'RS');
INSERT INTO Estado VALUES(24, 'Santa Catarina', 'SC');
INSERT INTO Estado VALUES(25, 'Sergipe', 'SE');
INSERT INTO Estado VALUES(26, 'São Paulo', 'SP');
INSERT INTO Estado VALUES(27, 'Tocantins', 'TO');

INSERT INTO EstadoCivil(nomeEstadoCivil) VALUES("Solteiro");
INSERT INTO EstadoCivil(nomeEstadoCivil) VALUES("Casado");
INSERT INTO EstadoCivil(nomeEstadoCivil) VALUES("Viuvo");