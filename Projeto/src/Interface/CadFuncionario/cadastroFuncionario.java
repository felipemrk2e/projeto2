/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadFuncionario;

import Interface.TelaPrincipal.Sessao;
import Interface.TelaPrincipal.TelaPrincipal;
import dao.CargoDAO;
import dao.DepartamentoDAO;
import dao.EstadoCivilDAO;
import dao.EstadoDAO;
import dao.FuncionarioDAO;
import dao.PessoaFisicaDAO;
import global.model.Bairro;
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
import model.pessoa.Cargo;
import model.pessoa.Departamento;
import model.pessoa.EstadoCivil;
import model.pessoa.Funcionario;
import model.pessoa.Login;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import model.pessoa.Telefone;
import validacao.criaLogin;

/**
 *
 * @author Sala
 */
public class cadastroFuncionario extends javax.swing.JFrame {

    private static cadastroFuncionario instancia;
    int user = Sessao.getInstance().getUsuario().getNivelAcesso();

    /**
     * Creates new form cadastroFuncionario
     */
    public cadastroFuncionario() {
        this.setUndecorated(true);
        initComponents();
        carregaCargos();
        carregaEstados();
        carregaEstadosCivis();
        populaFuncionario();

    }

    public cadastroFuncionario(int user) {
        this.setUndecorated(true);
        this.user = user;
        initComponents();
        verificaNivel0();

    }

    public cadastroFuncionario(int user, String idFuncionario) {
        this.user = user;
        initComponents();
        popular();
        verificaNivel();

    }
    
    public static cadastroFuncionario getInstancia() {
        if (instancia == null) {
            instancia = new cadastroFuncionario();
        }
        return instancia;
    }

    public void verificaNivel0() {
        if (user <= 2) {
            DisableEnable(true);
            jbEditar.setEnabled(false);
            jbConfirmar.setEnabled(true);

        } else {
            DisableEnable(false);
            jbEditar.setEnabled(false);
            jbConfirmar.setEnabled(false);

        }
    }

    public void verificaNivel() {
        if (user <= 2) {
            DisableEnable(false);
            jbEditar.setEnabled(true);
            jbConfirmar.setEnabled(false);

        } else {
            DisableEnable(false);
            jbConfirmar.setEnabled(false);

        }
    }

    public void DisableEnable(Boolean b) {

        //cad
        jtfNome.setEnabled(b);
        jftCPF.setEnabled(b);
        jtfRG.setEnabled(b);
        jftDataNascimento.setEnabled(b);
        jtfEndereco.setEnabled(b);
        jtfNumero.setEnabled(b);
        jtfBairro.setEnabled(b);
        jftCEP.setEnabled(b);
        jtfCidade.setEnabled(b);
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

        //cad Fim 
        // JRB
        jrbMasculino.setEnabled(b);
        jrbFeminino.setEnabled(b);

        // jrb fim
        // jcb     
        jcbEstadoCivil.setEnabled(b);
        jcbEstado.setEnabled(b);
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
        jtfCidade.setText("");
        jtfComplemento.setText("");
        jftTelefone.setText("");
        jftCelular.setText("");
        jftComercial.setText("");
        jtfEmail.setText("");
        jtaObs.setText("");

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

        // jcb fim
        //Tirando os alertas
        jtfNome.setBackground(Color.white);
        jftCPF.setBackground(Color.white);
        jtfEndereco.setBackground(Color.white);
        jtfBairro.setBackground(Color.white);
        jtfCidade.setBackground(Color.white);
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

    public void popular() {
        //nivel usuario
        if (true) {
            jbConfirmar.setEnabled(true);
            jbEditar.setEnabled(true);
        } else {
            jbConfirmar.setEnabled(false);
            jbEditar.setEnabled(false);
        }

        jtfCodigoInterno.setText(null);
        //cad

        jtfNome.setText(null);
        jftCPF.setText(null);
        jtfRG.setText(null);
        jftDataNascimento.setText(null);

        jtfEndereco.setText(null);
        jtfNumero.setText(null);
        jtfBairro.setText(null);
        jftCEP.setText(null);
        jtfCidade.setText(null);
        jtfComplemento.setText(null);
        jftTelefone.setText(null);
        jftCelular.setText(null);
        jftComercial.setText(null);
        jtfEmail.setText(null);
        jtaObs.setText(null);

        jtfEscolaridade.setText(null);
        jtfDependentes.setText(null);
        jtfBanco.setText(null);
        jtfTipoConta.setText(null);
        jtfNConta.setText(null);
        jtfAgencia.setText(null);
        jtfAgencia.setText(null);
        jtfNCTPS.setText(null);
        jtfSerieCTPS.setText(null);
        jtfCargaHoraria.setText(null);
        jftDataAdmissao.setText(null);

        //cad Fim 
        // JRB
        if (true) {
            jrbMasculino.setSelected(true);

        } else if (true) {
            jrbFeminino.setSelected(true);
        }
        // jrb fim

        // jcb     // falta arrumar o estado pois muda bem a logica..
        if (true) {
            jcbEstadoCivil.setSelectedIndex(0);
        } else if (true) {
            jcbEstadoCivil.setSelectedIndex(1);
        } else if (true) {
            jcbEstadoCivil.setSelectedIndex(2);
        } else if (true) {
            jcbEstadoCivil.setSelectedIndex(3);
        }

        // Estado vai ser necessario elaborar mais isso..
        if (true) {
            jcbEstado.setSelectedIndex(WIDTH);
        }
        // jcb fim

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

        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = new Estado();
        estado = estadoDAO.getById((long) jcbEstado.getSelectedIndex() + 1);

        Cidade cidade = new Cidade();
        cidade.setNomeCidade(jtfCidade.getText());
        cidade.setEstado(estado);

        Bairro bairro = new Bairro();
        bairro.setNomeBairro(jtfBairro.getText());
        bairro.setCidade(cidade);

        Endereco endereco = new Endereco();
        endereco.setNomeEndereco(jtfEndereco.getText());
        endereco.setNumero(Integer.parseInt(jtfNumero.getText()));
        endereco.setCep(jftCEP.getText());
        endereco.setComplemento(jtfComplemento.getText());
        endereco.setBairro(bairro);
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

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = new EstadoCivil();
        estadoCivil = estadoCivilDAO.getById((long) jcbEstadoCivil.getSelectedIndex() + 1);
        funcionario.setEstadoCivil(estadoCivil);

        CargoDAO cargoDAO = new CargoDAO();
        Cargo cargo = new Cargo();
        cargo = cargoDAO.getById((long) jcbCargo.getSelectedIndex() + 1);
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

    public void populaFuncionario() {
        Pessoa pessoa = new Pessoa();
        jtfCodigoInterno.setText(pessoa.getIdPessoa() + "");
        jtfNome.setText("Jean Felipe");
        jftCPF.setText("38933784802");
        System.out.println("Aqui CPF" + jftCPF.getText());
        jtfRG.setText("RG");
        jftDataNascimento.setText("25/08/1991");
        jtaObs.setText("Qualquer OBS");

        jcbEstadoCivil.setSelectedIndex(0);
        jtfEndereco.setText("Av. Guilherme de Almeida");
        jtfNumero.setText("2025");
        jtfComplemento.setText("");
        jtfBairro.setText("Morro do Algodão");

        jftCEP.setText("11.671-000");
        jtfCidade.setText("Caraguatatuba");

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jtfCidade = new javax.swing.JTextField();
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
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

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
        getContentPane().add(jbConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 140, 70));

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 140, 70));

        jbEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar2.png"))); // NOI18N
        jbEditar.setText("Editar");
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 140, 70));

        jlCodigoInterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoInterno.setText("Código Interno");
        getContentPane().add(jlCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        getContentPane().add(jtfCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, -1));

        jlNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNome.setText("Nome");
        getContentPane().add(jlNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jlCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF.setText("CPF");
        getContentPane().add(jlCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jlSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSexo.setText("Sexo");
        getContentPane().add(jlSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        jlRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRG.setText("RG");
        getContentPane().add(jlRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));
        getContentPane().add(jtfRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 150, -1));
        getContentPane().add(jtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 400, -1));
        getContentPane().add(jtfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 130, -1));
        getContentPane().add(jtfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 140, -1));
        getContentPane().add(jtfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 400, -1));

        jrbMasculino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbMasculino.setText("Masculino");
        getContentPane().add(jrbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        jrbFeminino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbFeminino.setText("Feminino");
        getContentPane().add(jrbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));
        getContentPane().add(jftCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 150, -1));

        jlEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEndereco.setText("Endereço");
        getContentPane().add(jlEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        jlNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNumero.setText("Nº");
        getContentPane().add(jlNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, -1, -1));

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setText("Bairro");
        getContentPane().add(jlBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, -1, -1));

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setText("Cidade");
        getContentPane().add(jlCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("Estado");
        getContentPane().add(jlEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        jlTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTelefone.setText("Telefone");
        getContentPane().add(jlTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        jlCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCelular.setText("Celular");
        getContentPane().add(jlCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 60, -1));

        jlComercial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComercial.setText("Alternativo");
        getContentPane().add(jlComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        jlEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEmail.setText("Email");
        getContentPane().add(jlEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, -1, -1));

        jlComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComplemento.setText("Complemento");
        getContentPane().add(jlComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, -1, -1));

        jlObs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlObs.setText("Observações");
        getContentPane().add(jlObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, 30));

        jlCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargo.setText("Cargo");
        getContentPane().add(jlCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jlDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDataNascimento.setText("Data de Nascimento");
        getContentPane().add(jlDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        jlEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstadoCivil.setText("Estado Civil");
        getContentPane().add(jlEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, -1, -1));

        jcbEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));
        getContentPane().add(jftDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 130, -1));

        jspObs.setBorder(null);

        jtaObs.setColumns(20);
        jtaObs.setRows(5);
        jspObs.setViewportView(jtaObs);

        getContentPane().add(jspObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 380, 30));
        getContentPane().add(jtfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 50, -1));

        jlCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCEP.setText("CEP");
        getContentPane().add(jlCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));
        getContentPane().add(jftCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 110, -1));

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));
        getContentPane().add(jtfComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 230, -1));
        getContentPane().add(jftTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 110, -1));
        getContentPane().add(jftCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 130, -1));
        getContentPane().add(jftComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 110, -1));
        getContentPane().add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 230, -1));

        jlBanco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBanco.setText("Banco");
        getContentPane().add(jlBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));
        getContentPane().add(jtfBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 150, -1));

        jlTipoConta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTipoConta.setText("Tipo de Conta");
        getContentPane().add(jlTipoConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));
        getContentPane().add(jtfTipoConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 130, -1));

        jlNConta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNConta.setText("Nº Conta");
        getContentPane().add(jlNConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));
        getContentPane().add(jtfNConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 100, -1));

        jlAgencia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlAgencia.setText("Agência");
        getContentPane().add(jlAgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, -1, -1));
        getContentPane().add(jtfAgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 50, -1));

        jlSalario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSalario.setText("Salário");
        getContentPane().add(jlSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));
        getContentPane().add(jtfSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 100, -1));

        jlDependentes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDependentes.setText("Dependentes");
        getContentPane().add(jlDependentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, -1, -1));
        getContentPane().add(jtfDependentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 80, -1));

        jlEscolaridade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEscolaridade.setText("Escolaridade");
        getContentPane().add(jlEscolaridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));
        getContentPane().add(jtfEscolaridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 200, -1));

        jlDataAdmissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDataAdmissao.setText("Data de Admissão");
        getContentPane().add(jlDataAdmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));

        jlNCTPS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNCTPS.setText("Nº CTPS");
        getContentPane().add(jlNCTPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));
        getContentPane().add(jtfNCTPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 120, -1));

        jlSerieCTPS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSerieCTPS.setText("Série CTPS");
        getContentPane().add(jlSerieCTPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));
        getContentPane().add(jtfSerieCTPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 70, -1));

        jlCargaHoraria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargaHoraria.setText("Carga Horária");
        getContentPane().add(jlCargaHoraria, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));
        getContentPane().add(jftDataAdmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 100, -1));

        jcbCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 150, -1));

        jlAddCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jlAddCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlAddCargoMousePressed(evt);
            }
        });
        getContentPane().add(jlAddCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 20, 20));
        getContentPane().add(jtfCargaHoraria, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 70, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 830, 140));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 830, 110));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 830, 90));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 830, 120));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMouseClicked
        try {
            cadastrarFuncionario();
        } catch (ParseException ex) {
            Logger.getLogger(cadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbConfirmarMouseClicked

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
//        new CadFuncionarioHome(user).setVisible(true);
//        dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jlAddCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAddCargoMousePressed
        //add cargo
    }//GEN-LAST:event_jlAddCargoMousePressed

    public void carregaEstados() {
        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = new Estado();
        List<Estado> listaEstados = new ArrayList<Estado>();
        List<String> listaSigla = new ArrayList<String>();
        listaEstados = estadoDAO.getAll();
        for (int i = 0; i < listaEstados.size(); i++) {
            listaSigla.add(listaEstados.get(i).getSigla());
        }
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaSigla.toArray());
        jcbEstado.setModel(defaultComboBox);
    }

    public void carregaEstadosCivis() {
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = new EstadoCivil();
        List<EstadoCivil> listaEstadoCivis = new ArrayList<EstadoCivil>();
        List<String> listaNomeEstadoCivis = new ArrayList<String>();
        listaEstadoCivis = estadoCivilDAO.getAll();
        for (int i = 0; i < listaEstadoCivis.size(); i++) {
            listaNomeEstadoCivis.add(listaEstadoCivis.get(i).getNomeEstadoCivil());
        }
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaNomeEstadoCivis.toArray());
        jcbEstadoCivil.setModel(defaultComboBox);
    }

    public void carregaCargos() {
        CargoDAO cargoDAO = new CargoDAO();
        Cargo cargo = new Cargo();
        List<Cargo> listaCargos = new ArrayList<Cargo>();
        List<String> listaNomeCargos = new ArrayList<String>();
        listaCargos = cargoDAO.getAll();
        for (int i = 0; i < listaCargos.size(); i++) {
            listaNomeCargos.add(listaCargos.get(i).getNomeCargo());
        }
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaNomeCargos.toArray());
        jcbCargo.setModel(defaultComboBox);
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JComboBox jcbCargo;
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
    private javax.swing.JTextField jtfCidade;
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
