/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael Brock
 */
import dao.CargoDAO;
import dao.CidadeDAO;
import dao.DepartamentoDAO;
import dao.EstadoCivilDAO;
import dao.FiadorDeDAO;
import dao.FuncionarioDAO;
import dao.LoginDAO;
import dao.PessoaDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import dao.TelefoneDAO;
import global.model.Cidade;
import global.model.Endereco;
import global.model.Estado;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.pessoa.Cargo;
import model.pessoa.Departamento;
import model.pessoa.EstadoCivil;
import model.pessoa.FiadorDe;
import model.pessoa.Funcionario;
import model.pessoa.Login;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import model.pessoa.PessoaJuridica;
import model.pessoa.Telefone;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rafael Brock
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Data sistema para inclusão de data
        Date data = new Date();

        //Teste Pessoa
        System.out.println("===========================================PESSOA===================================================");
        Endereco enderecoPessoa = new Endereco();
        enderecoPessoa.setNomeEndereco("Endereço Pessoa");
        enderecoPessoa.setNumero(1);
        enderecoPessoa.setCep("1");
        enderecoPessoa.setBairro("Morro do Algodão");

        Estado estadoPessoa = new Estado();
        estadoPessoa.setId(26);

        CidadeDAO cidadePessoaDAO = new CidadeDAO();
        Cidade cidadePessoa = cidadePessoaDAO.getById(Long.parseLong("8797"));

        enderecoPessoa.setCidade(cidadePessoa);

        PessoaDAO pessoaDao = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        pessoa.setEndereco(enderecoPessoa);
        pessoa.setNomePessoa("Jean");
        pessoa.setEmail("teste@teste");
        pessoa.setDataNascimento(data);
        pessoa.setObservacoes("xxxxx");

        pessoaDao.persist(pessoa);

        //Teste Pessoa Juridica
        System.out.println("===========================================PESSOA JURIDICA===================================================");
        Endereco enderecoPessoaJuridica = new Endereco();
        enderecoPessoaJuridica.setNomeEndereco("Endereço PessoaJuridica");
        enderecoPessoaJuridica.setNumero(2);
        enderecoPessoaJuridica.setCep("2");
        enderecoPessoaJuridica.setBairro("Morro do Algodão");

        Estado estadoPessoaJuridica = new Estado();
        estadoPessoaJuridica.setId(26);

        CidadeDAO cidadePessoaJuridicaDAO = new CidadeDAO();
        Cidade cidadePessoaJuridica = cidadePessoaJuridicaDAO.getById(Long.parseLong("8797"));

        enderecoPessoaJuridica.setCidade(cidadePessoaJuridica);

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNomePessoa("Empresa A");
        pessoaJuridica.setEmail("email@");
        pessoaJuridica.setObservacoes("xxxxx");
        pessoaJuridica.setDataNascimento(data);
        pessoaJuridica.setEndereco(enderecoPessoaJuridica);
        pessoaJuridica.setCnpj("CNPJ");
        pessoaJuridica.setInscricaoEstadual("Inscrição");
        pessoaJuridica.setCadastroAtivo(true);
        pessoaJuridica.setNomeFantasia("QualquerNome");
        pessoaJuridica.setNomeResponsavel("Nome Responsavel");
        pessoaJuridica.setCpfResponsavel("CPF Res");
        Telefone telPessoaJutidica = new Telefone();
        telPessoaJutidica.setPessoa(pessoaJuridica);
        telPessoaJutidica.setNumero("123");
        telPessoaJutidica.setOperadora("Vivo");

        Telefone celPessoaJuridica = new Telefone();
        celPessoaJuridica.setPessoa(pessoaJuridica);
        celPessoaJuridica.setNumero("456");
        celPessoaJuridica.setOperadora("Tim");
        pessoaJuridica.addTelefone(telPessoaJutidica);
        pessoaJuridica.addTelefone(celPessoaJuridica);

        pessoaJuridicaDAO.persist(pessoaJuridica);

        //Teste PessoaFisica  
        System.out.println("===========================================PESSOA FÍSICA===================================================");
        Endereco enderecoPessoaFisica = new Endereco();
        enderecoPessoaFisica.setNomeEndereco("Endereço PessoaFisica");
        enderecoPessoaFisica.setNumero(3);
        enderecoPessoaFisica.setCep("3");
        enderecoPessoaFisica.setBairro("Morro do Algodão");

        Estado estadoPessoaFisica = new Estado();
        estadoPessoaFisica.setId(26);

        CidadeDAO cidadePessoaFisicaDAO = new CidadeDAO();
        Cidade cidadePessoaFisica = cidadePessoaFisicaDAO.getById(Long.parseLong("8797"));

        enderecoPessoaFisica.setCidade(cidadePessoaFisica);

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNomePessoa("Jean Brock");
        pessoaFisica.setEmail("email@");
        pessoaFisica.setObservacoes("xxxxx");
        pessoaFisica.setDataNascimento(data);
        pessoaFisica.setEndereco(enderecoPessoaFisica);
        pessoaFisica.setCPF("CPF");
        pessoaFisica.setRG("RG");
        pessoaFisica.setSexo('M');

        //Teste EstadoCivil
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        List<EstadoCivil> estadosCivis = new ArrayList<EstadoCivil>();
        estadosCivis = estadoCivilDAO.getAll();
        pessoaFisica.setEstadoCivil(estadosCivis.get(0));

        Telefone telPessoaFisica = new Telefone();
        telPessoaFisica.setPessoa(pessoaFisica);
        telPessoaFisica.setNumero("123");
        telPessoaFisica.setOperadora("Vivo");

        Telefone celPessoaFisica = new Telefone();
        celPessoaFisica.setPessoa(pessoaFisica);
        celPessoaFisica.setNumero("456");
        celPessoaFisica.setOperadora("Tim");
        pessoaFisica.addTelefone(telPessoaFisica);
        pessoaFisica.addTelefone(celPessoaFisica);

        pessoaFisicaDAO.persist(pessoaFisica);

//        //Teste Departamento
//        System.out.println("===========================================DEPARTAMENTO===================================================");
//        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
//        Departamento departamento = new Departamento();
//        departamento.setNomeDepartamento("Logistica");
//        departamento.setTelefoneDepartamento("TelefoneLog");
//        departamento.setRamal("ramalLog");
//        
//        departamentoDAO.persist(departamento);
//        
//        //Teste Cargo
//        System.out.println("===========================================CARGO===================================================");
//        CargoDAO cargoDAO = new CargoDAO();
//        Cargo cargo = new Cargo();
//        cargo.setNomeCargo("Testador");
//        cargo.setDescricaoCargo("Testador de testes");
//        cargo.setDepartamento(departamento);
//        
//        cargoDAO.persist(cargo);
        //Teste Funcionario
        System.out.println("===========================================FUNCIONÁRIO===================================================");
        Endereco enderecofuncionario = new Endereco();
        enderecofuncionario.setNomeEndereco("Endereço Funcionario");
        enderecofuncionario.setNumero(4);
        enderecofuncionario.setCep("4");
        enderecofuncionario.setBairro("Golfinho");

        Estado estadofuncionario = new Estado();
        estadofuncionario.setId(26);

        CidadeDAO cidadeFuncionarioDAO = new CidadeDAO();
        Cidade cidadeFuncionario = cidadeFuncionarioDAO.getById(Long.parseLong("8797"));

        enderecofuncionario.setCidade(cidadeFuncionario);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();
        funcionario.setNomePessoa("Nome Funcionario");
        funcionario.setEmail("email@");
        funcionario.setObservacoes("xxxxx");
        funcionario.setDataNascimento(data);
        funcionario.setEndereco(enderecofuncionario);
        funcionario.setCPF("CPF");
        funcionario.setRG("RG");
        funcionario.setSexo('M');
        funcionario.setSalario(100.00);
        funcionario.setBanco("Santander");
        funcionario.setTipoConta("Normal");
        funcionario.setConta("64545");
        funcionario.setAgencia("515");
        funcionario.setCtps("ctps");
        funcionario.setSerieCtps("serie");
        funcionario.setDataAdmissao(data);
        funcionario.setCargaHoraria("20");
        funcionario.setEscolaridade("Ensino Médio Completo");
        funcionario.setDependentes(0);
//        funcionario.setPIS(0);  

        CargoDAO cargoDAO = new CargoDAO();
        Cargo cargo = cargoDAO.getById(Long.parseLong("1"));
        funcionario.setCargo(cargo);

        Telefone telFuncionario = new Telefone();
        telFuncionario.setPessoa(funcionario);
        telFuncionario.setNumero("123");
        telFuncionario.setOperadora("Vivo");

        Telefone celFuncionario = new Telefone();
        celFuncionario.setPessoa(funcionario);
        celFuncionario.setNumero("456");
        celFuncionario.setOperadora("Tim");
        funcionario.addTelefone(telFuncionario);
        funcionario.addTelefone(celFuncionario);

        EstadoCivilDAO estadoCivilDAOFuncionario = new EstadoCivilDAO();
        List<EstadoCivil> estadosCivisF = new ArrayList<EstadoCivil>();
        estadosCivisF = estadoCivilDAOFuncionario.getAll();
        funcionario.setEstadoCivil(estadosCivisF.get(0));

        System.out.println("===========================================LOGIN===================================================");
        LoginDAO loginDAO = new LoginDAO();
        Login login = new Login();
        login.setNivelAcesso(1);
        login.setNomeUsuario("teste");
        login.setSenhaUsuario("teste");
//        login.setFuncionario(funcionario);
        funcionario.setLogin(login);

        funcionarioDAO.persist(funcionario);
//
////
//        
////        PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
////        List<PessoaFisica> fiadores = new ArrayList<PessoaFisica>();        
////        fiadores = pessoaDAO.getAll();
////        FiadorDeDAO fiadorDAO = new FiadorDeDAO();
////        FiadorDe fiador = new FiadorDe();
//////        fiador.addFiador(pessoas.get(0), pessoas.get(1));
////        fiador.addFiador(funcionario);
////           
////        
//////        fiadorDAO.persist(fiador);

    }

}
