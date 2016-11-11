/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadFuncionario;

import Interface.TelaPrincipal.Sessao;
import Interface.TelaPrincipal.TelaPrincipal;
import dao.CargoDAO;
import dao.CidadeDAO;
import dao.DepartamentoDAO;
import dao.EstadoCivilDAO;
import dao.EstadoDAO;
import dao.FuncionarioDAO;
import dao.PessoaFisicaDAO;
import global.model.Cidade;
import global.model.Endereco;
import global.model.Estado;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.pessoa.Cargo;
import model.pessoa.Departamento;
import model.pessoa.EstadoCivil;
import model.pessoa.Funcionario;
import model.pessoa.Login;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import model.pessoa.Telefone;
import validacao.criaLogin;
import validacao.validacao;

/**
 *
 * @author Sala
 */
public class cadastroFuncionario extends javax.swing.JFrame {

    private static cadastroFuncionario instancia;

    public static Funcionario funcionario = null;
    private List<Cidade> listaCidadesGlobal;
    private int indexCidade;

    /**
     * Creates new form cadastroFuncionario
     */
    public cadastroFuncionario() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        this.setTitle("Cadastro de Funcionários");
        configuraMascaras();
        carregaCargos();
        carregaEstados();
        carregaCidades();
        carregaEstadosCivis();
        if (funcionario == null) {
//            populaFuncionario();
        }
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());

    }

    public static cadastroFuncionario getInstancia() {
        if (instancia == null) {
            instancia = new cadastroFuncionario();
        }
        return instancia;
    }

    public static void encerrarInstancia() {
        instancia = null;
    }

    public void acesso(int nivel) {
        DisableEnable(false);
        switch (nivel) {
            case 1:
                DisableEnable(true);
                jbConfirmar.setEnabled(true);
                jbEditar.setEnabled(true);
                break;
            case 2:
                DisableEnable(true);
                break;
            case 3:
                DisableEnable(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void DisableEnable(Boolean b) {
        jtfCodigoInterno.setEnabled(false);
        //cad
        jtfNome.setEnabled(b);
        jftCPF.setEnabled(b);
        jtfRG.setEnabled(b);
        jftDataNascimento.setEnabled(b);
        jtfEndereco.setEnabled(b);
        jtfNumero.setEnabled(b);
        jtfBairro.setEnabled(b);
        jftCEP.setEnabled(b);
        jtfComplemento.setEnabled(b);
        jftTelefone.setEnabled(b);
        jftCelular.setEnabled(b);
        jftComercial.setEnabled(b);
        jtfEmail.setEnabled(b);
        jtaObs.setEnabled(b);

        jtfEscolaridade.setEnabled(b);
        jtfDependentes.setEnabled(b);
        jtfBanco.setEnabled(b);
        jtfTipoConta.setEnabled(b);
        jtfNConta.setEnabled(b);
        jtfAgencia.setEnabled(b);
        jtfAgencia.setEnabled(b);
        jtfNCTPS.setEnabled(b);
        jtfSerieCTPS.setEnabled(b);
        jtfCargaHoraria.setEnabled(b);
        jftDataAdmissao.setEnabled(b);
        jtfSalario.setEnabled(b);

        //cad Fim 
        // JRB
        jrbMasculino.setEnabled(b);
        jrbFeminino.setEnabled(b);

        // jrb fim
        // jcb     
        jcbEstadoCivil.setEnabled(b);
        jcbEstado.setEnabled(b);
        jcbCidade.setEnabled(b);
        jcbCargo.setEnabled(b);
    }

    public void ZerarCampos() {
        jtfCodigoInterno.setText("");
        //cad
        jtfNome.setText("");
        jftCPF.setText("");
        jtfRG.setText("");
        jftDataNascimento.setText("");
        jtfEndereco.setText("");
        jtfNumero.setText("");
        jtfBairro.setText("");
        jftCEP.setText("");
        jtfComplemento.setText("");
        jftTelefone.setText("");
        jftCelular.setText("");
        jftComercial.setText("");
        jtfEmail.setText("");
        jtaObs.setText("");

        jtfSalario.setText("");
        jtfEscolaridade.setText("");
        jtfDependentes.setText("");
        jtfBanco.setText("");
        jtfTipoConta.setText("");
        jtfNConta.setText("");
        jtfAgencia.setText("");
        jtfAgencia.setText("");
        jtfNCTPS.setText("");
        jtfSerieCTPS.setText("");
        jtfCargaHoraria.setText("");
        jftDataAdmissao.setText("");

        //cad Fim 
        // JRB
        jrbMasculino.setSelected(false);
        jrbFeminino.setSelected(false);

        // jrb fim
        // jcb     
        jcbEstadoCivil.setSelectedIndex(-1);
        jcbEstado.setSelectedIndex(-1);
        jcbCidade.setSelectedIndex(-1);
        jcbCargo.setSelectedIndex(-1);

        // jcb fim
        //Tirando os alertas
        jtfNome.setBackground(Color.white);
        jftCPF.setBackground(Color.white);
        jtfEndereco.setBackground(Color.white);
        jtfBairro.setBackground(Color.white);
        jcbCidade.setBackground(Color.white);
        jftDataNascimento.setBackground(Color.white);
        jtfNumero.setBackground(Color.white);
        jcbEstado.setBackground(Color.white);
        jftTelefone.setBackground(Color.white);
        jftCelular.setBackground(Color.white);
        jftComercial.setBackground(Color.white);
        jcbEstadoCivil.setBackground(Color.white);
        jtfComplemento.setBackground(Color.white);
        jtfEmail.setBackground(Color.white);

        jtfEscolaridade.setBackground(Color.white);
        jtfDependentes.setBackground(Color.white);
        jtfBanco.setBackground(Color.white);
        jtfTipoConta.setBackground(Color.white);
        jtfNConta.setBackground(Color.white);
        jtfAgencia.setBackground(Color.white);
        jtfAgencia.setBackground(Color.white);
        jtfNCTPS.setBackground(Color.white);
        jtfSerieCTPS.setBackground(Color.white);
        jtfCargaHoraria.setBackground(Color.white);
        jftDataAdmissao.setBackground(Color.white);
        // Fim
    }

    public void cadastrarFuncionario() throws ParseException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();
        funcionario.setNomePessoa(jtfNome.getText());
        funcionario.setCPF(jftCPF.getText());
        funcionario.setRG(jtfRG.getText());
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataNascimento.getText());
        funcionario.setDataNascimento(dataNascimento);
        funcionario.setObservacoes(jtaObs.getText());

        Cidade cidade = (Cidade) jcbCidade.getSelectedItem();

        Endereco endereco = new Endereco();
        endereco.setNomeEndereco(jtfEndereco.getText());
        endereco.setNumero(Integer.parseInt(jtfNumero.getText()));
        endereco.setCep(jftCEP.getText());
        endereco.setComplemento(jtfComplemento.getText());
        endereco.setBairro(jtfBairro.getText());
        endereco.setCidade(cidade);
        funcionario.setEndereco(endereco);

        List<Telefone> telefones = new ArrayList<Telefone>();
        Telefone telefone = new Telefone();
        Telefone celular = new Telefone();
        Telefone comercial = new Telefone();

        telefone.setNumero(jftTelefone.getText());
        telefone.setPessoa(funcionario);
        telefone.setOperadora("");
        celular.setNumero(jftCelular.getText());
        celular.setPessoa(funcionario);
        celular.setOperadora("");
        comercial.setNumero(jftComercial.getText());
        comercial.setPessoa(funcionario);
        comercial.setOperadora("");

        telefones.add(telefone);
        telefones.add(celular);
        telefones.add(comercial);
        funcionario.setTelefone(telefones);

        funcionario.setEmail(jtfEmail.getText());

        if (jrbMasculino.isSelected()) {
            funcionario.setSexo('M');
        } else if (jrbFeminino.isSelected()) {
            funcionario.setSexo('F');
        }

        EstadoCivil estadoCivil = (EstadoCivil) jcbEstadoCivil.getSelectedItem();
        funcionario.setEstadoCivil(estadoCivil);

        Cargo cargo = (Cargo) jcbCargo.getSelectedItem();
        funcionario.setCargo(cargo);

        funcionario.setDependentes(Integer.parseInt(jtfDependentes.getText()));
        funcionario.setEscolaridade(jtfEscolaridade.getText());

        funcionario.setBanco(jtfBanco.getText());
        funcionario.setTipoConta(jtfTipoConta.getText());
        funcionario.setConta(jtfNConta.getText());
        funcionario.setAgencia(jtfNConta.getText());
        funcionario.setSalario(Double.parseDouble(jtfSalario.getText()));
        funcionario.setCtps(jtfNCTPS.getText());
        funcionario.setSerieCtps(jtfSerieCTPS.getText());
        funcionario.setCargaHoraria(jtfCargaHoraria.getText());
        Date admissao = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataAdmissao.getText());
        funcionario.setDataAdmissao(admissao);

        criaLogin loginNovo = new criaLogin();

        Login login = new Login();
        login.setNivelAcesso(0);
        login.setNomeUsuario(loginNovo.geraNovoUsuario(funcionario.getNomePessoa()));
        login.setSenhaUsuario(loginNovo.gerarNovaSenha());
        funcionario.setLogin(login);

        funcionarioDAO.persist(funcionario);
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws ParseException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionario.setNomePessoa(jtfNome.getText());
        funcionario.setCPF(jftCPF.getText());
        funcionario.setRG(jtfRG.getText());
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataNascimento.getText());
        funcionario.setDataNascimento(dataNascimento);
        funcionario.setObservacoes(jtaObs.getText());

        Cidade cidade = (Cidade) jcbCidade.getSelectedItem();

        Endereco endereco = new Endereco();
        endereco.setNomeEndereco(jtfEndereco.getText());
        endereco.setNumero(Integer.parseInt(jtfNumero.getText()));
        endereco.setCep(jftCEP.getText());
        endereco.setComplemento(jtfComplemento.getText());
        endereco.setBairro(jtfBairro.getText());
        endereco.setCidade(cidade);
        funcionario.setEndereco(endereco);

        List<Telefone> telefones = new ArrayList<Telefone>();
        Telefone telefone = new Telefone();
        Telefone celular = new Telefone();
        Telefone comercial = new Telefone();

        telefone.setNumero(jftTelefone.getText());
        telefone.setPessoa(funcionario);
        telefone.setOperadora("");
        celular.setNumero(jftCelular.getText());
        celular.setPessoa(funcionario);
        celular.setOperadora("");
        comercial.setNumero(jftComercial.getText());
        comercial.setPessoa(funcionario);
        comercial.setOperadora("");

        telefones.add(telefone);
        telefones.add(celular);
        telefones.add(comercial);
        funcionario.setTelefone(telefones);

        funcionario.setEmail(jtfEmail.getText());

        if (jrbMasculino.isSelected()) {
            funcionario.setSexo('M');
        } else if (jrbFeminino.isSelected()) {
            funcionario.setSexo('F');
        }

        EstadoCivil estadoCivil = (EstadoCivil) jcbEstadoCivil.getSelectedItem();
        funcionario.setEstadoCivil(estadoCivil);

        Cargo cargo = (Cargo) jcbCargo.getSelectedItem();
        funcionario.setCargo(cargo);

        funcionario.setDependentes(Integer.parseInt(jtfDependentes.getText()));
        funcionario.setEscolaridade(jtfEscolaridade.getText());

        funcionario.setBanco(jtfBanco.getText());
        funcionario.setTipoConta(jtfTipoConta.getText());
        funcionario.setConta(jtfNConta.getText());
        funcionario.setAgencia(jtfNConta.getText());
        funcionario.setSalario(Double.parseDouble(jtfSalario.getText()));
        funcionario.setCtps(jtfNCTPS.getText());
        funcionario.setSerieCtps(jtfSerieCTPS.getText());
        funcionario.setCargaHoraria(jtfCargaHoraria.getText());
        Date admissao = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataAdmissao.getText());
        funcionario.setDataAdmissao(admissao);

        funcionarioDAO.merge(funcionario);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        jtfCodigoInterno.setText("" + funcionario.getIdPessoa());
        jtfNome.setText(funcionario.getNomePessoa());
        jftCPF.setText(funcionario.getCPF());
        jtfRG.setText(funcionario.getRG());
        String dataString = new SimpleDateFormat("dd/MM/yyyy").format(funcionario.getDataNascimento());
        jftDataNascimento.setText(dataString);
        jtaObs.setText(funcionario.getObservacoes());

        jcbEstado.setSelectedIndex((int) funcionario.getEndereco().getCidade().getEstado().getId() - 1);

        for (int i = 0; i < listaCidadesGlobal.size(); i++) {
            if (listaCidadesGlobal.get(i).getIdCidade() == funcionario.getEndereco().getCidade().getIdCidade()) {
                indexCidade = i;
            }
        } 
        jcbCidade.setSelectedIndex(indexCidade);

        jtfBairro.setText(funcionario.getEndereco().getBairro());

        jtfEndereco.setText(funcionario.getEndereco().getNomeEndereco());
        jtfNumero.setText("" + funcionario.getEndereco().getNumero());
        jftCEP.setText(funcionario.getEndereco().getCep());
        jtfComplemento.setText(funcionario.getEndereco().getComplemento());

        if (funcionario.getTelefone().get(0).getNumero().trim().length() == 13) {
            jftTelefone.setText(funcionario.getTelefone().get(0).getNumero());
        } else {
            jftTelefone.setText(null);
        }

        if (funcionario.getTelefone().get(1).getNumero().trim().length() == 14) {
            jftCelular.setText(funcionario.getTelefone().get(1).getNumero());
        } else {
            jftCelular.setText(null);
        }

        if (funcionario.getTelefone().get(1).getNumero().trim().length() == 13) {
            jftComercial.setText(funcionario.getTelefone().get(1).getNumero());
        } else {
            jftComercial.setText(null);
        }//        

        jtfEmail.setText(funcionario.getEmail());

        if (funcionario.getSexo() == 'M') {
            jrbMasculino.setSelected(true);
        }
        if (funcionario.getSexo() == 'F') {
            jrbFeminino.setSelected(true);
        }
        jcbEstadoCivil.setSelectedIndex((int) funcionario.getEstadoCivil().getIdEstadoCivil() - 1);

        jtfDependentes.setText("" + funcionario.getDependentes());
        jtfEscolaridade.setText(funcionario.getEscolaridade());
        jtfBanco.setText(funcionario.getBanco());
        jtfAgencia.setText(funcionario.getAgencia());
        jtfTipoConta.setText(funcionario.getTipoConta());
        jtfNConta.setText(funcionario.getConta());
        jtfSalario.setText("" + funcionario.getSalario());
        jtfNCTPS.setText(funcionario.getCtps());
        jtfSerieCTPS.setText(funcionario.getSerieCtps());
        jtfCargaHoraria.setText(funcionario.getCargaHoraria());
        String dataAdmissao = new SimpleDateFormat("dd/MM/yyyy").format(funcionario.getDataAdmissao());
        jftDataAdmissao.setText(dataAdmissao);
        jcbCargo.setSelectedIndex((int) funcionario.getCargo().getIdCargo() - 1);
    }

    public void populaFuncionario() {
        Pessoa pessoa = new Pessoa();
        jtfCodigoInterno.setText(pessoa.getIdPessoa() + "");
        jtfNome.setText("Jean Felipe");
        jftCPF.setText("38933784802");
        jtfRG.setText("RG");
        jftDataNascimento.setText("25/08/1991");
        jtaObs.setText("Qualquer OBS");

        jcbEstadoCivil.setSelectedIndex(0);
        jtfEndereco.setText("Av. Guilherme de Almeida");
        jtfNumero.setText("2025");
        jtfComplemento.setText("");
        jtfBairro.setText("Morro do Algodão");

        jftCEP.setText("11.671-000");
        jcbCidade.setSelectedIndex(1);

        jcbEstado.setSelectedIndex(25);

        jftTelefone.setText("1238875776");
        jftCelular.setText("12981097059");
        jftComercial.setText("");
        jtfEmail.setText("teste@teste");

        jtfEscolaridade.setText("Ensino Médio");
        jtfDependentes.setText("0");

        jtfBanco.setText("Santander");
        jtfTipoConta.setText("Corrente");
        jtfNConta.setText("1111");
        jtfAgencia.setText("2222");
        jtfSalario.setText("2.500");
        jtfNCTPS.setText("5454545");
        jtfSerieCTPS.setText("5");
        jtfCargaHoraria.setText("8");
        jftDataAdmissao.setText("01/07/2013");
        jrbMasculino.setSelected(true);
        jcbCargo.setSelectedIndex(0);
    }

    public boolean validaCampos(boolean valida) {
        //PESSOA        
        //Email
        if (!jtfEmail.getText().equals("")) {
            jtfEmail.setBackground(Color.white);
        } else {
            jtfEmail.setBackground(Color.red);
            valida = false;
        }
        //Endereço
        if (!jtfEndereco.getText().equals("")) {
            jtfEndereco.setBackground(Color.white);
        } else {
            jtfEndereco.setBackground(Color.red);
            valida = false;
        }
        //Número
        if (!jtfNumero.getText().equals("") && validacao.validaNumeros(jtfNumero.getText())) {
            jtfNumero.setBackground(Color.white);
        } else {
            jtfNumero.setBackground(Color.red);
            valida = false;
        }
        //Bairro
        if (!jtfBairro.getText().equals("") && validacao.validaLetras(jtfBairro.getText())) {
            jtfBairro.setBackground(Color.white);
        } else {
            jtfBairro.setBackground(Color.red);
            valida = false;
        }
        //Cidade
        if (jcbCidade.getSelectedItem() != null) {
            jcbCidade.setBackground(Color.white);
        } else {
            jcbCidade.setBackground(Color.red);
            valida = false;
        }
        //Estado
        if (jcbEstado.getSelectedItem() != null) {
            jcbEstado.setBackground(Color.white);
        } else {
            jcbEstado.setBackground(Color.red);
            valida = false;
        }
        //CEP
        if (jftCEP.getText().trim().length() == 10) {
            jftCEP.setBackground(Color.white);
        } else {
            jftCEP.setBackground(Color.red);
            valida = false;
        }
        //Data Nascimento
        if (jftDataNascimento.getText().trim().length() == 10) {
            jftDataNascimento.setBackground(Color.white);
        } else {
            jftDataNascimento.setBackground(Color.red);
            valida = false;
        }
        //Telefone
        if (jftTelefone.getText().trim().length() == 13 || jftCelular.getText().trim().length() == 14 || jftComercial.getText().trim().length() == 13) {
            jftTelefone.setBackground(Color.white);
            jftCelular.setBackground(Color.white);
            jftComercial.setBackground(Color.white);
        } else {
            jftTelefone.setBackground(Color.red);
            jftCelular.setBackground(Color.red);
            jftComercial.setBackground(Color.red);
            valida = false;
        }
        //Nome
        if (!jtfNome.getText().equals("") && validacao.validaLetras(jtfNome.getText())) {
            jtfNome.setBackground(Color.white);
        } else {
            jtfNome.setBackground(Color.red);
            valida = false;
        }
        //CPF
        if (jftCPF.getText().trim().length() == 14) {
            jftCPF.setBackground(Color.white);
        } else {
            jftCPF.setBackground(Color.red);
            valida = false;
        }
        if (!jtfRG.getText().isEmpty()) {
            jtfRG.setBackground(Color.white);
        } else {
            jtfRG.setBackground(Color.red);
            valida = false;
        }
        //Sexo
        if (jrbMasculino.isSelected() || jrbFeminino.isSelected()) {
            jrbMasculino.setBackground(Color.white);
            jrbFeminino.setBackground(Color.white);
        } else {
            jrbMasculino.setBackground(Color.red);
            jrbFeminino.setBackground(Color.red);
            valida = false;
        }
        //Estado Cívil
        if (jcbEstadoCivil.getSelectedItem() != null) {
            jcbEstadoCivil.setBackground(Color.white);
        } else {
            jcbEstadoCivil.setBackground(Color.red);
            valida = false;
        }
        //Salário
        if (!jtfSalario.getText().equals("") && validacao.validaNumeros(jtfSalario.getText())) {
            jtfSalario.setBackground(Color.white);
        } else {
            jtfSalario.setBackground(Color.red);
            valida = false;
        }
        //Banco
        if (!jtfBanco.getText().isEmpty()) {
            jtfBanco.setBackground(Color.white);
        } else {
            jtfBanco.setBackground(Color.red);
            valida = false;
        }
        //Tipo Conta
        if (!jtfTipoConta.getText().isEmpty()) {
            jtfTipoConta.setBackground(Color.white);
        } else {
            jtfTipoConta.setBackground(Color.red);
            valida = false;
        }
        //Conta
        if (!jtfNConta.getText().isEmpty()) {
            jtfNConta.setBackground(Color.white);
        } else {
            jtfNConta.setBackground(Color.red);
            valida = false;
        }
        //Agencia
        if (!jtfAgencia.getText().isEmpty()) {
            jtfAgencia.setBackground(Color.white);
        } else {
            jtfAgencia.setBackground(Color.red);
            valida = false;
        }
        //CTPS
        if (!jtfNCTPS.getText().isEmpty()) {
            jtfNCTPS.setBackground(Color.white);
        } else {
            jtfNCTPS.setBackground(Color.red);
            valida = false;
        }
        //Serie CTPS
        if (!jtfSerieCTPS.getText().isEmpty()) {
            jtfSerieCTPS.setBackground(Color.white);
        } else {
            jtfSerieCTPS.setBackground(Color.red);
            valida = false;
        }
        //Data Admissão
        if (jftDataAdmissao.getText().trim().length() == 10) {
            jftDataAdmissao.setBackground(Color.white);
        } else {
            jftDataAdmissao.setBackground(Color.red);
            valida = false;
        }
        //Carga Horária
        if (!jtfCargaHoraria.getText().isEmpty()) {
            jtfCargaHoraria.setBackground(Color.white);
        } else {
            jtfCargaHoraria.setBackground(Color.red);
            valida = false;
        }
        //Escolaridade
        if (!jtfEscolaridade.getText().isEmpty()) {
            jtfEscolaridade.setBackground(Color.white);
        } else {
            jtfEscolaridade.setBackground(Color.red);
            valida = false;
        }
        //Dependentes
        if (!jtfDependentes.getText().isEmpty()) {
            jtfDependentes.setBackground(Color.white);
        } else {
            jtfDependentes.setBackground(Color.red);
            valida = false;
        }
        //Cargo
        if (jcbCargo.getSelectedItem() != null) {
            jcbCargo.setBackground(Color.white);
        } else {
            jcbCargo.setBackground(Color.red);
            valida = false;
        }

        return valida;
    }

    public void mascaraCPF() {
        try {
            jftCPF.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("###.###.###-##")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraData() {
        try {
            jftDataNascimento.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##/##/####")));
            jftDataAdmissao.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##/##/####")));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void mascaraCEP() {
        try {
            jftCEP.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##.###-###")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraTelefone() {
        try {
            jftTelefone.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##)####-####")));
            jftComercial.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraCelular() {
        try {
            jftCelular.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##)#####-####")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void configuraMascaras() {
        mascaraCelular();
        mascaraTelefone();
        mascaraCEP();
        mascaraData();
        mascaraCPF();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSexo = new javax.swing.ButtonGroup();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jlCodigoInterno = new javax.swing.JLabel();
        jtfCodigoInterno = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jlCPF = new javax.swing.JLabel();
        jlSexo = new javax.swing.JLabel();
        jlRG = new javax.swing.JLabel();
        jtfRG = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jtfEndereco = new javax.swing.JTextField();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFeminino = new javax.swing.JRadioButton();
        jftCPF = new javax.swing.JFormattedTextField();
        jlEndereco = new javax.swing.JLabel();
        jlNumero = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jlEstado = new javax.swing.JLabel();
        jlTelefone = new javax.swing.JLabel();
        jlCelular = new javax.swing.JLabel();
        jlComercial = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jlComplemento = new javax.swing.JLabel();
        jlObs = new javax.swing.JLabel();
        jlCargo = new javax.swing.JLabel();
        jlDataNascimento = new javax.swing.JLabel();
        jlEstadoCivil = new javax.swing.JLabel();
        jcbEstadoCivil = new javax.swing.JComboBox();
        jftDataNascimento = new javax.swing.JFormattedTextField();
        jspObs = new javax.swing.JScrollPane();
        jtaObs = new javax.swing.JTextArea();
        jtfNumero = new javax.swing.JTextField();
        jlCEP = new javax.swing.JLabel();
        jftCEP = new javax.swing.JFormattedTextField();
        jcbEstado = new javax.swing.JComboBox();
        jcbCidade = new javax.swing.JComboBox<String>();
        jtfComplemento = new javax.swing.JTextField();
        jftTelefone = new javax.swing.JFormattedTextField();
        jftCelular = new javax.swing.JFormattedTextField();
        jftComercial = new javax.swing.JFormattedTextField();
        jtfEmail = new javax.swing.JTextField();
        jlBanco = new javax.swing.JLabel();
        jtfBanco = new javax.swing.JTextField();
        jlTipoConta = new javax.swing.JLabel();
        jtfTipoConta = new javax.swing.JTextField();
        jlNConta = new javax.swing.JLabel();
        jtfNConta = new javax.swing.JTextField();
        jlAgencia = new javax.swing.JLabel();
        jtfAgencia = new javax.swing.JTextField();
        jlSalario = new javax.swing.JLabel();
        jtfSalario = new javax.swing.JTextField();
        jlDependentes = new javax.swing.JLabel();
        jtfDependentes = new javax.swing.JTextField();
        jlEscolaridade = new javax.swing.JLabel();
        jtfEscolaridade = new javax.swing.JTextField();
        jlDataAdmissao = new javax.swing.JLabel();
        jlNCTPS = new javax.swing.JLabel();
        jtfNCTPS = new javax.swing.JTextField();
        jlSerieCTPS = new javax.swing.JLabel();
        jtfSerieCTPS = new javax.swing.JTextField();
        jlCargaHoraria = new javax.swing.JLabel();
        jftDataAdmissao = new javax.swing.JFormattedTextField();
        jcbCargo = new javax.swing.JComboBox();
        jlAddCargo = new javax.swing.JLabel();
        jtfCargaHoraria = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 640));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbConfirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbConfirmar.setText("Confirmar");
        jbConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConfirmarMouseClicked(evt);
            }
        });
        getContentPane().add(jbConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, 140, 70));

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, 140, 70));

        jbEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar2.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbEditarMousePressed(evt);
            }
        });
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 140, 70));

        jlCodigoInterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoInterno.setText("Código Interno");
        getContentPane().add(jlCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 30));
        getContentPane().add(jtfCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 100, 30));

        jlNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNome.setText("Nome:");
        getContentPane().add(jlNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 50, 30));

        jlCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF.setText("CPF:");
        getContentPane().add(jlCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 40, 30));

        jlSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSexo.setText("Sexo:");
        getContentPane().add(jlSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, -1, 30));

        jlRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRG.setText("RG:");
        getContentPane().add(jlRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 30, 30));
        getContentPane().add(jtfRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 150, 30));
        getContentPane().add(jtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 490, 30));
        getContentPane().add(jtfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 140, 30));
        getContentPane().add(jtfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 400, 30));

        bgSexo.add(jrbMasculino);
        jrbMasculino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbMasculino.setText("Masculino");
        getContentPane().add(jrbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        bgSexo.add(jrbFeminino);
        jrbFeminino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbFeminino.setText("Feminino");
        getContentPane().add(jrbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, -1, -1));
        getContentPane().add(jftCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 150, 30));

        jlEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEndereco.setText("Endereço:");
        getContentPane().add(jlEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 70, 30));

        jlNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNumero.setText("Número:");
        getContentPane().add(jlNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, -1, 30));

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setText("Bairro:");
        getContentPane().add(jlBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, 30));

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setText("Cidade:");
        getContentPane().add(jlCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, 30));

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("Estado:");
        getContentPane().add(jlEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, 30));

        jlTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTelefone.setText("Telefone:");
        getContentPane().add(jlTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, 30));

        jlCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCelular.setText("Celular:");
        getContentPane().add(jlCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 50, 30));

        jlComercial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComercial.setText("Alternativo:");
        getContentPane().add(jlComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 80, 30));

        jlEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEmail.setText("Email:");
        getContentPane().add(jlEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, 30));

        jlComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComplemento.setText("Complemento:");
        getContentPane().add(jlComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, 30));

        jlObs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlObs.setText("Observações:");
        getContentPane().add(jlObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, 30));

        jlCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargo.setText("Cargo:");
        getContentPane().add(jlCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 50, 30));

        jlDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDataNascimento.setText("Data de Nascimento: ");
        getContentPane().add(jlDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 140, 30));

        jlEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstadoCivil.setText("Estado Civil: ");
        getContentPane().add(jlEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, 30));

        jcbEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, 30));
        getContentPane().add(jftDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 130, 30));

        jspObs.setBorder(null);

        jtaObs.setColumns(20);
        jtaObs.setRows(5);
        jspObs.setViewportView(jtaObs);

        getContentPane().add(jspObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 230, 70));
        getContentPane().add(jtfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 50, 30));

        jlCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCEP.setText("CEP:");
        getContentPane().add(jlCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 40, 30));
        getContentPane().add(jftCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 110, 30));

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, 30));

        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 140, 30));
        getContentPane().add(jtfComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 270, 30));
        getContentPane().add(jftTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 210, 30));
        getContentPane().add(jftCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 180, 30));
        getContentPane().add(jftComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, 180, 30));
        getContentPane().add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 720, 30));

        jlBanco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBanco.setText("Banco:");
        getContentPane().add(jlBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, 30));
        getContentPane().add(jtfBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 210, 30));

        jlTipoConta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTipoConta.setText("Tipo de Conta:");
        getContentPane().add(jlTipoConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, 30));
        getContentPane().add(jtfTipoConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 130, 30));

        jlNConta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNConta.setText("Número da Conta:");
        getContentPane().add(jlNConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, -1, 30));
        getContentPane().add(jtfNConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 140, 30));

        jlAgencia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlAgencia.setText("Agência:");
        getContentPane().add(jlAgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, 30));
        getContentPane().add(jtfAgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 70, 30));

        jlSalario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSalario.setText("Salário:");
        getContentPane().add(jlSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, 30));
        getContentPane().add(jtfSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 100, 30));

        jlDependentes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDependentes.setText("Dependentes:");
        getContentPane().add(jlDependentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, -1, 30));
        getContentPane().add(jtfDependentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 110, 30));

        jlEscolaridade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEscolaridade.setText("Escolaridade: ");
        getContentPane().add(jlEscolaridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, 30));
        getContentPane().add(jtfEscolaridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 200, 30));

        jlDataAdmissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDataAdmissao.setText("Data de Admissão:");
        getContentPane().add(jlDataAdmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, -1, 30));

        jlNCTPS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNCTPS.setText("Número da CTPS:");
        getContentPane().add(jlNCTPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, 30));
        getContentPane().add(jtfNCTPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 150, 30));

        jlSerieCTPS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSerieCTPS.setText("Série CTPS:");
        getContentPane().add(jlSerieCTPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, 30));
        getContentPane().add(jtfSerieCTPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 70, 30));

        jlCargaHoraria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargaHoraria.setText("Carga Horária:");
        getContentPane().add(jlCargaHoraria, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, -1, 30));
        getContentPane().add(jftDataAdmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 100, 30));

        jcbCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 150, 30));

        jlAddCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jlAddCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlAddCargoMousePressed(evt);
            }
        });
        getContentPane().add(jlAddCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 20, 30));
        getContentPane().add(jtfCargaHoraria, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 70, 30));

        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Funcionário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 930, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMouseClicked
        if (jbConfirmar.isEnabled()) {
            if (validaCampos(true)) {
                try {
                    if (funcionario == null) {
                        cadastrarFuncionario();
                        JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
                        ZerarCampos();
                        funcionario = null;
                        encerrarInstancia();
                        CadFuncionarioHome homeFuncionario = CadFuncionarioHome.getInstancia();
                        CadFuncionarioHome.getInstancia().setVisible(true);
                        CadFuncionarioHome.getInstancia().setLocationRelativeTo(this);
                        CadFuncionarioHome.getInstancia().popularTabela();
                        dispose();
                    } else {
                        cadastrarFuncionario(funcionario);
                        JOptionPane.showMessageDialog(this, "Atualização efetuada com sucesso!");
                        ZerarCampos();
                        funcionario = null;
                        encerrarInstancia();
                        dispose();
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(cadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(cadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Verifique os campos obrigatórios!");
            }

        }

    }//GEN-LAST:event_jbConfirmarMouseClicked

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        if (jbCancelar.isEnabled()) {//                   
            String ObjButtons[] = {"Sim", "Não"};
            int PromptResult = JOptionPane.showOptionDialog(this, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
            if (PromptResult == JOptionPane.YES_OPTION) {
                CadFuncionarioHome homeFuncionario = CadFuncionarioHome.getInstancia();
                CadFuncionarioHome.getInstancia().setVisible(true);
                CadFuncionarioHome.getInstancia().setLocationRelativeTo(this);
                CadFuncionarioHome.getInstancia().popularTabela();
                dispose();
                encerrarInstancia();
            }
        }
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jlAddCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAddCargoMousePressed
        //add cargo
    }//GEN-LAST:event_jlAddCargoMousePressed

    private void jbEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMousePressed
        if (jbEditar.isEnabled()) {
            cadastroFuncionario.getInstancia().DisableEnable(true);
            JOptionPane.showMessageDialog(this, "Campos abertos para edição!");
        }
    }//GEN-LAST:event_jbEditarMousePressed

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        if (jcbEstado.getSelectedIndex() > -1) {
            carregaCidadeEstados();
        }
    }//GEN-LAST:event_jcbEstadoActionPerformed

    public void carregaEstados() {
        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = new Estado();
        List<Estado> listaEstados = estadoDAO.getAll();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaEstados.toArray());
        jcbEstado.setModel(defaultComboBox);
    }

    public void carregaCidades() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> listaCidades = cidadeDAO.getAll();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaCidades.toArray());
        jcbCidade.setModel(defaultComboBox);
    }

    public void carregaCidadeEstados() {
        Estado estado = (Estado) jcbEstado.getSelectedItem();
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> listaCidades = cidadeDAO.getWhereIdEstado(estado.getId());
        jcbCidade.removeAllItems();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaCidades.toArray());
        jcbCidade.setModel(defaultComboBox);
        listaCidadesGlobal = listaCidades;
        
    }

    public void carregaEstadosCivis() {
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        List<EstadoCivil> listaEstadoCivis = estadoCivilDAO.getAll();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaEstadoCivis.toArray());
        jcbEstadoCivil.setModel(defaultComboBox);
    }

    public void carregaCargos() {
        CargoDAO cargoDAO = new CargoDAO();
        List<Cargo> cargos = cargoDAO.getAll();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(cargos.toArray());
        jcbCargo.setModel(defaultComboBox);
        jcbCargo.setSelectedIndex(-1);
    }

    public void fecharCadastro() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {

//                if (COLOCAR VERIFICACAO) {
//                    int resposta = JOptionPane.showConfirmDialog(null,
//                            "Cadastro não salvo, Deseja salvar antes de sair?",
//                            "Segurança",
//                            JOptionPane.YES_NO_OPTION);
//                    if (resposta == 1) {
//
//                        System.exit(0);
//
//                    } else {
//
//                    }
//
//                } else {
                String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    dispose();
                }
//                }

            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JComboBox jcbCargo;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JComboBox jcbEstadoCivil;
    private javax.swing.JFormattedTextField jftCEP;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JFormattedTextField jftCelular;
    private javax.swing.JFormattedTextField jftComercial;
    private javax.swing.JFormattedTextField jftDataAdmissao;
    private javax.swing.JFormattedTextField jftDataNascimento;
    private javax.swing.JFormattedTextField jftTelefone;
    private javax.swing.JLabel jlAddCargo;
    private javax.swing.JLabel jlAgencia;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlBanco;
    private javax.swing.JLabel jlCEP;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCargaHoraria;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlCelular;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlCodigoInterno;
    private javax.swing.JLabel jlComercial;
    private javax.swing.JLabel jlComplemento;
    private javax.swing.JLabel jlDataAdmissao;
    private javax.swing.JLabel jlDataNascimento;
    private javax.swing.JLabel jlDependentes;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlEscolaridade;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlEstadoCivil;
    private javax.swing.JLabel jlNCTPS;
    private javax.swing.JLabel jlNConta;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlObs;
    private javax.swing.JLabel jlRG;
    private javax.swing.JLabel jlSalario;
    private javax.swing.JLabel jlSerieCTPS;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JLabel jlTipoConta;
    private javax.swing.JRadioButton jrbFeminino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JScrollPane jspObs;
    private javax.swing.JTextArea jtaObs;
    private javax.swing.JTextField jtfAgencia;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfBanco;
    private javax.swing.JTextField jtfCargaHoraria;
    private javax.swing.JTextField jtfCodigoInterno;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfDependentes;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfEscolaridade;
    private javax.swing.JTextField jtfNCTPS;
    private javax.swing.JTextField jtfNConta;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRG;
    private javax.swing.JTextField jtfSalario;
    private javax.swing.JTextField jtfSerieCTPS;
    private javax.swing.JTextField jtfTipoConta;
    // End of variables declaration//GEN-END:variables
}
