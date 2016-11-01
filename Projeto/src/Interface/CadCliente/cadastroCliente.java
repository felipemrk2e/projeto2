/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadCliente;

import Interface.TelaPrincipal.Sessao;
import Interface.TelaPrincipal.TelaPrincipal;
import dao.EstadoCivilDAO;
import dao.EstadoDAO;
import dao.PessoaDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import global.model.Bairro;
import global.model.Cidade;
import global.model.Endereco;
import global.model.Estado;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.pessoa.EstadoCivil;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import model.pessoa.PessoaJuridica;
import model.pessoa.Telefone;
import validacao.*;

/**
 *
 * @author Sala
 */
public class cadastroCliente extends javax.swing.JFrame {

    private static cadastroCliente instancia;     

    /**
     * Creates new form cadastroCliente
     */
    public cadastroCliente() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        ativaPessoa(true);
        mascaraCPF_CNPJ(true);
        jrbPessoaFisica.setSelected(true);
        configuraMascaras();
        carregaEstados();
        carregaEstadosCivis();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        populaPessoaFisica();

    }
    
    public static cadastroCliente getInstancia() {
        if (instancia == null) {
            instancia = new cadastroCliente();
        }
        return instancia;
    }

    public static void encerrarInstancia() {
        instancia = null;
    }

    public void acesso(int nivel) {
        System.out.println("====================================================Nível de Acesso: "+nivel);
        DisableEnable(false);
        switch (nivel) {
            case 1:
                DisableEnable(true);
                jbConfirmar.setEnabled(true);
                jbEditar.setEnabled(false);
                break;
            case 2:
                DisableEnable(true);
                jbConfirmar.setEnabled(true);
                jbEditar.setEnabled(false);
                break;
            case 3:
                DisableEnable(false);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Acesso negado!\nNível de Acesso Inválido");
        }
    }       

    public void DisableEnable(Boolean b) {

        //cad
        jtfNome.setEnabled(b);
        jftCPF.setEnabled(b);
        jtfRG.setEnabled(b);
        jftDataNascimento.setEnabled(b);
        jtfCargo.setEnabled(b);
        jtfNomeFantasia.setEnabled(b);
        jtfFiador.setEnabled(b);
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

        //cad Fim 
        // JRB
        jrbPessoaFisica.setEnabled(b);
        jrbPessoaJuridica.setEnabled(b);
        jrbMasculino.setEnabled(b);
        jrbFeminino.setEnabled(b);

        // jrb fim
        // jcb     
        jcbAtivo.setEnabled(b);
        jcbCompra.setEnabled(b);
        jcbTroca.setEnabled(b);
        jcbLocacao.setEnabled(b);
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
        jtfCargo.setText("");
        jtfNomeFantasia.setText("");
        jtfFiador.setText("");
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
        jftCPFResponsavel.setText("");

        //cad Fim 
        // JRB
        jrbPessoaFisica.setSelected(false);
        jrbPessoaJuridica.setSelected(false);
        jrbMasculino.setSelected(false);
        jrbFeminino.setSelected(false);

        // jrb fim
        // jcb     
        jcbAtivo.setSelected(false);
        jcbCompra.setSelected(false);
        jcbTroca.setSelected(false);
        jcbLocacao.setSelected(false);
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
        jtfCargo.setBackground(Color.white);
        jtfFiador.setBackground(Color.white);
        jtfNomeFantasia.setBackground(Color.white);
        jftCPFResponsavel.setBackground(Color.white);
        jtfComplemento.setBackground(Color.white);
        jtfEmail.setBackground(Color.white);
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
        jtfCargo.setText(null);
        jtfNomeFantasia.setText(null);
        jtfFiador.setText(null);
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

        //cad Fim 
        // JRB
        if (true) {
            jrbPessoaFisica.setSelected(true);
            ativaPessoa(true);
            mascaraCPF_CNPJ(true);
        } else if (true) {
            jrbPessoaJuridica.setSelected(true);
            ativaPessoa(false);
            mascaraCPF_CNPJ(false);
        }

        if (true) {
            jrbMasculino.setSelected(true);

        } else if (true) {
            jrbFeminino.setSelected(true);
        }
        // jrb fim

        // jcb     // falta arrumar o estado pois muda bem a logica..
        if (true) {
            jcbAtivo.setSelected(true);

        }

        if (true) {
            jcbCompra.setSelected(true);
        }

        if (true) {
            jcbTroca.setSelected(true);
        }

        if (true) {
            jcbLocacao.setSelected(true);
        }

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

    public void cadastrarPessoaFisica() throws ParseException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNomePessoa(jtfNome.getText());
        pessoaFisica.setCPF(jftCPF.getText());
        pessoaFisica.setRG(jtfRG.getText());
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataNascimento.getText());
        pessoaFisica.setDataNascimento(dataNascimento);
        pessoaFisica.setObservacoes(jtaObs.getText());

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
        pessoaFisica.setEndereco(endereco);

        List<Telefone> telefones = new ArrayList<Telefone>();
        Telefone telefone = new Telefone();
        Telefone celular = new Telefone();
        Telefone comercial = new Telefone();

        telefone.setNumero(jftTelefone.getText());
        telefone.setPessoa(pessoaFisica);
        telefone.setOperadora("");
        celular.setNumero(jftCelular.getText());
        celular.setPessoa(pessoaFisica);
        celular.setOperadora("");
        comercial.setNumero(jftComercial.getText());
        comercial.setPessoa(pessoaFisica);
        comercial.setOperadora("");

        telefones.add(telefone);
        telefones.add(celular);
        telefones.add(comercial);
        pessoaFisica.setTelefone(telefones);

        pessoaFisica.setEmail(jtfEmail.getText());

        if (jrbMasculino.isSelected()) {
            pessoaFisica.setSexo('M');
        } else if (jrbFeminino.isSelected()) {
            pessoaFisica.setSexo('F');
        }

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = new EstadoCivil();
        estadoCivil = estadoCivilDAO.getById((long) jcbEstadoCivil.getSelectedIndex() + 1);

        pessoaFisica.setEstadoCivil(estadoCivil);

        pessoaFisicaDAO.persist(pessoaFisica);

    }

    public void cadastrarPessoaJuridica() throws ParseException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNomePessoa(jtfNome.getText());
        pessoaJuridica.setCnpj(jftCPF.getText());
        pessoaJuridica.setInscricaoEstadual(jtfRG.getText());
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataNascimento.getText());
        pessoaJuridica.setDataNascimento(dataNascimento);
        pessoaJuridica.setObservacoes(jtaObs.getText());

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
        pessoaJuridica.setEndereco(endereco);

        List<Telefone> telefones = new ArrayList<Telefone>();
        Telefone telefone = new Telefone();
        Telefone celular = new Telefone();
        Telefone comercial = new Telefone();

        telefone.setNumero(jftTelefone.getText());
        telefone.setPessoa(pessoaJuridica);
        telefone.setOperadora("");
        celular.setNumero(jftCelular.getText());
        celular.setPessoa(pessoaJuridica);
        celular.setOperadora("");
        comercial.setNumero(jftComercial.getText());
        comercial.setPessoa(pessoaJuridica);
        comercial.setOperadora("");

        telefones.add(telefone);
        telefones.add(celular);
        telefones.add(comercial);
        pessoaJuridica.setTelefone(telefones);

        pessoaJuridica.setEmail(jtfEmail.getText());

        pessoaJuridica.setCpfResponsavel(jftCPFResponsavel.getText());
        pessoaJuridica.setNomeFantasia(jtfNomeFantasia.getText());
        pessoaJuridica.setNomeResponsavel(jtfFiador.getText());
        pessoaJuridica.setCadastroAtivo(jcbAtivo.isSelected());

        pessoaJuridicaDAO.persist(pessoaJuridica);

    }

    public void populaPessoaFisica() {
        Pessoa pessoa = new Pessoa();
        jtfCodigoInterno.setText(pessoa.getIdPessoa() + "");
        jtfNome.setText("Jean Felipe");
        jftCPF.setText("38933784802");
        System.out.println("Aqui CPF" + jftCPF.getText());
        jtfRG.setText("RG");
        jftDataNascimento.setText("25/08/1991");
        jtaObs.setText("Qualquer OBS");

        jtfCargo.setText("Chefe");
        jtfFiador.setText("Fiador");
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
    }

    public void populaPessoaJuridica() {
        Pessoa pessoa = new Pessoa();
        jtfCodigoInterno.setText(pessoa.getIdPessoa() + "");
        jtfNome.setText("Empresa S/A");
        jftCPF.setText("19.339.754/0001-07");
        System.out.println("Aqui CNPJ" + jftCPF.getText());
        jtfRG.setText("Inscrição Estadual");
        jftDataNascimento.setText("28/08/1991");
        jtaObs.setText("Qualquer OBS");

        jftCPFResponsavel.setText("11301353493");
        jtfNomeFantasia.setText("Empresa S/A Fantasia");
        jtfFiador.setText("José Maria");
        jcbAtivo.setSelected(true);

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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPessoa = new javax.swing.ButtonGroup();
        bgSexo = new javax.swing.ButtonGroup();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jlCodigoInterno = new javax.swing.JLabel();
        jtfCodigoInterno = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jlCPF_CNPJ = new javax.swing.JLabel();
        jlRG_Incricao = new javax.swing.JLabel();
        jlSexo = new javax.swing.JLabel();
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
        jtfCargo = new javax.swing.JTextField();
        jlDataNascimento = new javax.swing.JLabel();
        jlEstadoCivil = new javax.swing.JLabel();
        jcbEstadoCivil = new javax.swing.JComboBox();
        jlFiador = new javax.swing.JLabel();
        jtfFiador = new javax.swing.JTextField();
        jftDataNascimento = new javax.swing.JFormattedTextField();
        jlNomeFantasia = new javax.swing.JLabel();
        jtfNomeFantasia = new javax.swing.JTextField();
        jlCPFResponsavel = new javax.swing.JLabel();
        jftCPFResponsavel = new javax.swing.JFormattedTextField();
        jspObs = new javax.swing.JScrollPane();
        jtaObs = new javax.swing.JTextArea();
        jlInteresses = new javax.swing.JLabel();
        jcbCompra = new javax.swing.JCheckBox();
        jcbTroca = new javax.swing.JCheckBox();
        jcbLocacao = new javax.swing.JCheckBox();
        jtfNumero = new javax.swing.JTextField();
        jlCEP = new javax.swing.JLabel();
        jftCEP = new javax.swing.JFormattedTextField();
        jcbEstado = new javax.swing.JComboBox();
        jtfComplemento = new javax.swing.JTextField();
        jftTelefone = new javax.swing.JFormattedTextField();
        jftCelular = new javax.swing.JFormattedTextField();
        jftComercial = new javax.swing.JFormattedTextField();
        jtfEmail = new javax.swing.JTextField();
        jrbPessoaFisica = new javax.swing.JRadioButton();
        jrbPessoaJuridica = new javax.swing.JRadioButton();
        jcbAtivo = new javax.swing.JCheckBox();
        jlSituacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
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
        getContentPane().add(jbConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 140, 70));

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 140, 70));

        jbEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar2.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEditarMouseClicked(evt);
            }
        });
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 140, 70));

        jlCodigoInterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoInterno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCodigoInterno.setText("Código Interno:");
        getContentPane().add(jlCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 30));

        jtfCodigoInterno.setEditable(false);
        getContentPane().add(jtfCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 100, 30));

        jlNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNome.setText("Nome:");
        getContentPane().add(jlNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 140, 30));

        jlCPF_CNPJ.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF_CNPJ.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCPF_CNPJ.setText("CPF:");
        getContentPane().add(jlCPF_CNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 100, 140, 30));

        jlRG_Incricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRG_Incricao.setText("RG:");
        getContentPane().add(jlRG_Incricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, 30));

        jlSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSexo.setText("Sexo:");
        getContentPane().add(jlSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 40, 30));
        getContentPane().add(jtfRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 160, 30));
        getContentPane().add(jtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 350, 30));
        getContentPane().add(jtfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 170, 30));
        getContentPane().add(jtfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 230, 30));
        getContentPane().add(jtfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 350, 30));

        bgSexo.add(jrbMasculino);
        jrbMasculino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbMasculino.setText("Masculino");
        getContentPane().add(jrbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, 30));

        bgSexo.add(jrbFeminino);
        jrbFeminino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbFeminino.setText("Feminino");
        getContentPane().add(jrbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, -1, 30));
        getContentPane().add(jftCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 150, 30));

        jlEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEndereco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlEndereco.setText("Endereço:");
        getContentPane().add(jlEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 150, 30));

        jlNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNumero.setText("Número:");
        getContentPane().add(jlNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, 30));

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setText("Bairro:");
        getContentPane().add(jlBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, 30));

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setText("Cidade:");
        getContentPane().add(jlCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 260, 50, 30));

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("Estado:");
        getContentPane().add(jlEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, -1, 30));

        jlTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTelefone.setText("Telefone:");
        getContentPane().add(jlTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 150, 30));

        jlCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCelular.setText("Celular:");
        getContentPane().add(jlCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 60, 30));

        jlComercial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComercial.setText("Alternativo:");
        getContentPane().add(jlComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, -1, 30));

        jlEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlEmail.setText("Email:");
        getContentPane().add(jlEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 150, 30));

        jlComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComplemento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlComplemento.setText("Complemento:");
        getContentPane().add(jlComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 340, 150, 30));

        jlObs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlObs.setText("Observações:");
        getContentPane().add(jlObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, -1, 30));

        jlCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCargo.setText("Cargo:");
        getContentPane().add(jlCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 140, 130, 30));
        getContentPane().add(jtfCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, 30));

        jlDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDataNascimento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlDataNascimento.setText("Data de Nascimento:");
        getContentPane().add(jlDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 160, 30));

        jlEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstadoCivil.setText("Estado Civil:");
        getContentPane().add(jlEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, 30));

        jcbEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoCivilActionPerformed(evt);
            }
        });
        getContentPane().add(jcbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, -1, 30));

        jlFiador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlFiador.setText("Fiador:");
        getContentPane().add(jlFiador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 40, 30));
        getContentPane().add(jtfFiador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 350, 30));
        getContentPane().add(jftDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 120, 30));

        jlNomeFantasia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeFantasia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNomeFantasia.setText("Nome Fantasia:");
        getContentPane().add(jlNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 140, 140, 30));
        getContentPane().add(jtfNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 350, 30));

        jlCPFResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPFResponsavel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCPFResponsavel.setText("CPF Responsavel:");
        getContentPane().add(jlCPFResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 180, 140, 30));
        getContentPane().add(jftCPFResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, 30));

        jspObs.setBorder(null);

        jtaObs.setColumns(20);
        jtaObs.setRows(5);
        jspObs.setViewportView(jtaObs);

        getContentPane().add(jspObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 290, 70));

        jlInteresses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlInteresses.setText("Interesses");
        getContentPane().add(jlInteresses, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, -1, 30));

        jcbCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbCompra.setText("Compra");
        getContentPane().add(jcbCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 110, -1, 30));

        jcbTroca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbTroca.setText("Temporada");
        getContentPane().add(jcbTroca, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 100, 30));

        jcbLocacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbLocacao.setText("Locação");
        getContentPane().add(jcbLocacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, 30));
        getContentPane().add(jtfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 50, 30));

        jlCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCEP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCEP.setText("CEP:");
        getContentPane().add(jlCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 260, 140, 30));
        getContentPane().add(jftCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 110, 30));

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 260, 60, 30));
        getContentPane().add(jtfComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 760, 30));
        getContentPane().add(jftTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 180, 30));
        getContentPane().add(jftCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 200, 30));
        getContentPane().add(jftComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, 220, 30));
        getContentPane().add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 760, 30));

        bgPessoa.add(jrbPessoaFisica);
        jrbPessoaFisica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbPessoaFisica.setSelected(true);
        jrbPessoaFisica.setText("Física");
        jrbPessoaFisica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jrbPessoaFisicaMousePressed(evt);
            }
        });
        getContentPane().add(jrbPessoaFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 30));

        bgPessoa.add(jrbPessoaJuridica);
        jrbPessoaJuridica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbPessoaJuridica.setText("Jurídica");
        jrbPessoaJuridica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jrbPessoaJuridicaMousePressed(evt);
            }
        });
        getContentPane().add(jrbPessoaJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 30));

        jcbAtivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbAtivo.setText("Ativo");
        getContentPane().add(jcbAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        jlSituacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSituacao.setText("Situação Cadastral:");
        getContentPane().add(jlSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMouseClicked
        //        if (jbConfirmar.isEnabled()) {
//            if (bgPessoa.getSelection() == jrbPessoaFisica) {
//                System.out.println("Física");
//                cadastrarPessoaFisica();
//            } else if (bgPessoa.getSelection() == jrbPessoaJuridica) {
//                System.out.println("Juridica");
//            }
//
////            Pessoa pessoa;
////            PessoaFisica pessoaFisica;
////            PessoaJuridica pessoaJuridica;
////            Endereco endereco;
////            Bairro bairro;
////            Cidade cidade;
////            Estado estado;
////            Telefone telefone;
////
////            
////            if (this.getPessoa() == null) {
////                
////                pessoa = new Pessoa();
////                pessoaFisica = new PessoaFisica();
////                pessoaJuridica = new PessoaJuridica();
////                endereco = new Endereco();
////                bairro = new Bairro();
////                cidade = new Cidade();
////                estado = new Estado();
////                telefone = new Telefone();
////                
////                EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
////                EstadoCivil estadoCivil = new EstadoCivil();
////                List<EstadoCivil> estadoCivilTemp = new ArrayList<EstadoCivil>();
////                estadoCivilTemp = estadoCivilDAO.getAll();
////                
////            } else {
////                pessoa = pessoaTemp;
////                endereco = pessoa.getEndereco();
////                bairro = pessoa.getEndereco().getBairro();
////                cidade = pessoa.getEndereco().getBairro().getCidade();
////                estado = pessoa.getEndereco().getBairro().getCidade().getEstado();
////
////            }
//            if (!validaCampos(true)) {
//                JOptionPane.showMessageDialog(null, "Verifique os campos obrigatórios!");
//            }
//
//        }
        if (jrbPessoaFisica.isSelected()) {
            try {
                cadastrarPessoaFisica();
            } catch (ParseException ex) {
                Logger.getLogger(cadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (jrbPessoaJuridica.isSelected()) {
            try {
                cadastrarPessoaJuridica();
            } catch (ParseException ex) {
                Logger.getLogger(cadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jbConfirmarMouseClicked

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        cadastroClienteHome homeCliente = cadastroClienteHome.getInstancia();
       cadastroClienteHome.getInstancia().setVisible(true);
        dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jrbPessoaJuridicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPessoaJuridicaMousePressed
        ativaPessoa(false);
        mascaraCPF_CNPJ(false);
        limpaCampos();
        carregaEstados();
        populaPessoaJuridica();
    }//GEN-LAST:event_jrbPessoaJuridicaMousePressed

    private void jrbPessoaFisicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPessoaFisicaMousePressed
        ativaPessoa(true);
        mascaraCPF_CNPJ(true);
        limpaCampos();
        carregaEstados();
        carregaEstadosCivis();
        populaPessoaFisica();
    }//GEN-LAST:event_jrbPessoaFisicaMousePressed

    private void jcbEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEstadoCivilActionPerformed

    private void jbEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMouseClicked
        if (jbEditar.isEnabled()) {
            DisableEnable(true);
            jbConfirmar.setEnabled(true);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jbEditarMouseClicked

    public void ativaPessoa(boolean ativo) {
        if (ativo == false) {
            jlCPF_CNPJ.setText("CNPJ");
            jlRG_Incricao.setText("Inscrição Estadual");
            jlNome.setText("Razão Social");
            jlEndereco.setText("Logradouro");
            jlDataNascimento.setText("Data Fundação");
        } else {
            jlCPF_CNPJ.setText("CPF");
            jlRG_Incricao.setText("RG");
            jlNome.setText("Nome");
            jlEndereco.setText("Endereço");
            jlDataNascimento.setText("Data Nascimento");
        }
        //Passando True Ativa Pessoa Fisica, False Pessoa Juridica
        jlCargo.setVisible(ativo);
        jlCargo.setEnabled(ativo);
        jtfCargo.setVisible(ativo);
        jtfCargo.setEnabled(ativo);
        jlFiador.setVisible(ativo);
        jtfFiador.setVisible(ativo);
        jtfFiador.setEnabled(ativo);
        jlEstadoCivil.setVisible(ativo);
        jlEstadoCivil.setEnabled(ativo);
        jcbEstadoCivil.setVisible(ativo);
        jcbEstadoCivil.setEnabled(ativo);
        jlSexo.setVisible(ativo);
        jlSexo.setEnabled(ativo);
        jrbFeminino.setVisible(ativo);
        jrbMasculino.setVisible(ativo);
        jrbFeminino.setEnabled(ativo);
        jrbMasculino.setEnabled(ativo);

        //Passando False Pessoa Juridica
        jlNomeFantasia.setVisible(!ativo);
        jlNomeFantasia.setEnabled(!ativo);
        jtfNomeFantasia.setEnabled(!ativo);
        jtfNomeFantasia.setVisible(!ativo);
        jlCPFResponsavel.setVisible(!ativo);
        jlCPFResponsavel.setEnabled(!ativo);
        jftCPFResponsavel.setVisible(!ativo);
        jftCPFResponsavel.setEnabled(!ativo);
        jcbAtivo.setVisible(!ativo);
        jcbAtivo.setEnabled(!ativo);
        jlSituacao.setVisible(!ativo);
        jlSituacao.setEnabled(!ativo);
    }

    public void mascaraCPF_CNPJ(boolean ativa) {
        try {
            if (ativa) {
                jftCPF.setFormatterFactory(new DefaultFormatterFactory(
                        new MaskFormatter("###.###.###-##")));
            } else {
                jftCPF.setFormatterFactory(new DefaultFormatterFactory(
                        new MaskFormatter("##.###.###/####-##")));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraData() {
        try {
            jftDataNascimento.setFormatterFactory(new DefaultFormatterFactory(
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
    }

    public boolean validaCampos(boolean valida) {
        if (jrbPessoaFisica.isSelected()) {
            if (!jtfNome.getText().equals("") && validacao.validaLetras(jtfNome.getText())) {
                jtfNome.setBackground(Color.white);
            } else {
                jtfNome.setBackground(Color.red);
                valida = false;
            }
            if (jftCPF.getText().trim().length() == 14) {
                jftCPF.setBackground(Color.white);
            } else {
                jftCPF.setBackground(Color.red);
                valida = false;
            }
            if (!jtfEndereco.getText().equals("") && validacao.validaLetras(jtfEndereco.getText())) {
                jtfEndereco.setBackground(Color.white);
            } else {
                jtfEndereco.setBackground(Color.red);
                valida = false;
            }
            if (!jtfBairro.getText().equals("") && validacao.validaLetras(jtfBairro.getText())) {
                jtfBairro.setBackground(Color.white);
            } else {
                jtfBairro.setBackground(Color.red);
                valida = false;
            }
            if (!jtfCidade.getText().equals("") && validacao.validaLetras(jtfCidade.getText())) {
                jtfCidade.setBackground(Color.white);
            } else {
                jtfCidade.setBackground(Color.red);
                valida = false;
            }
            if (jftDataNascimento.getText().trim().length() == 10) {
                jftDataNascimento.setBackground(Color.white);
            } else {
                jftDataNascimento.setBackground(Color.red);
                valida = false;
            }
            if (!jtfNumero.getText().equals("") && validacao.validaNumeros(jtfNumero.getText())) {
                jtfNumero.setBackground(Color.white);
            } else {
                jtfNumero.setBackground(Color.red);
                valida = false;
            }
            if (jcbEstado.getSelectedItem() != null) {
                jcbEstado.setBackground(Color.white);
            } else {
                jcbEstado.setBackground(Color.red);
                valida = false;
            }
            System.out.println(jftTelefone.getText().trim().length());
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
            if (jrbMasculino.isSelected() || jrbFeminino.isSelected()) {
                jrbMasculino.setBackground(Color.white);
                jrbFeminino.setBackground(Color.white);
            } else {
                jrbMasculino.setBackground(Color.red);
                jrbFeminino.setBackground(Color.red);
                valida = false;
            }
            if (jcbEstadoCivil.getSelectedItem() != null) {
                jcbEstadoCivil.setBackground(Color.white);
            } else {
                jcbEstadoCivil.setBackground(Color.red);
                valida = false;
            }
        } else if (jrbPessoaJuridica.isSelected()) {
            if (!jtfNome.getText().equals("") && validacao.validaLetras(jtfNome.getText())) {
                jtfNome.setBackground(Color.white);
            } else {
                jtfNome.setBackground(Color.red);
                valida = false;
            }
            if (jftCPF.getText().trim().length() == 18) {
                jftCPF.setBackground(Color.white);
            } else {
                jftCPF.setBackground(Color.red);
                valida = false;
            }
            if (!jtfEndereco.getText().equals("") && validacao.validaLetras(jtfEndereco.getText())) {
                jtfEndereco.setBackground(Color.white);
            } else {
                jtfEndereco.setBackground(Color.red);
                valida = false;
            }
            if (!jtfBairro.getText().equals("") && validacao.validaLetras(jtfBairro.getText())) {
                jtfBairro.setBackground(Color.white);
            } else {
                jtfBairro.setBackground(Color.red);
                valida = false;
            }
            if (!jtfCidade.getText().equals("") && validacao.validaLetras(jtfCidade.getText())) {
                jtfCidade.setBackground(Color.white);
            } else {
                jtfCidade.setBackground(Color.red);
                valida = false;
            }
            if (jftDataNascimento.getText().trim().length() == 10) {
                jftDataNascimento.setBackground(Color.white);
            } else {
                jftDataNascimento.setBackground(Color.red);
                valida = false;
            }
            if (!jtfNumero.getText().equals("") && validacao.validaNumeros(jtfNumero.getText())) {
                jtfNumero.setBackground(Color.white);
            } else {
                jtfNumero.setBackground(Color.red);
                valida = false;
            }

            if (jcbEstado.getSelectedItem() == "") {
                jcbEstado.setBackground(Color.white);
            } else {
                jcbEstado.setBackground(Color.red);
                valida = false;
            }
            System.out.println(jftTelefone.getText().trim().length());
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
        }
        return valida;
    }

    public void limpaCampos() {
        jtfNome.setText("");
        jtfNome.setBackground(Color.white);
        jftCPF.setText("");
        jftCPF.setBackground(Color.white);
        jtfEndereco.setText("");
        jtfEndereco.setBackground(Color.white);
        jtfBairro.setText("");
        jtfBairro.setBackground(Color.white);
        jtfCidade.setText("");
        jtfCidade.setBackground(Color.white);
        jftDataNascimento.setText("");
        jftDataNascimento.setBackground(Color.white);
        jtfNumero.setText("");
        jtfNumero.setBackground(Color.white);
        jcbEstado.setBackground(Color.white);
        jftTelefone.setText("");
        jftTelefone.setBackground(Color.white);
        jftCelular.setText("");
        jftCelular.setBackground(Color.white);
        jftComercial.setText("");
        jftComercial.setBackground(Color.white);
        jcbEstadoCivil.setBackground(Color.white);
        jtfCargo.setText("");
        jtfCargo.setBackground(Color.white);
        jtfFiador.setText("");
        jtfFiador.setBackground(Color.white);
        jtfNomeFantasia.setText("");
        jtfNomeFantasia.setBackground(Color.white);
        jftCPFResponsavel.setText("");
        jftCPFResponsavel.setBackground(Color.white);
        jtfComplemento.setText("");
        jtfComplemento.setBackground(Color.white);
        jtfEmail.setText("");
        jtfEmail.setBackground(Color.white);
    }

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
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPessoa;
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JCheckBox jcbAtivo;
    private javax.swing.JCheckBox jcbCompra;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JComboBox jcbEstadoCivil;
    private javax.swing.JCheckBox jcbLocacao;
    private javax.swing.JCheckBox jcbTroca;
    private javax.swing.JFormattedTextField jftCEP;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JFormattedTextField jftCPFResponsavel;
    private javax.swing.JFormattedTextField jftCelular;
    private javax.swing.JFormattedTextField jftComercial;
    private javax.swing.JFormattedTextField jftDataNascimento;
    private javax.swing.JFormattedTextField jftTelefone;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCEP;
    private javax.swing.JLabel jlCPFResponsavel;
    private javax.swing.JLabel jlCPF_CNPJ;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlCelular;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlCodigoInterno;
    private javax.swing.JLabel jlComercial;
    private javax.swing.JLabel jlComplemento;
    private javax.swing.JLabel jlDataNascimento;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlEstadoCivil;
    private javax.swing.JLabel jlFiador;
    private javax.swing.JLabel jlInteresses;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNomeFantasia;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlObs;
    private javax.swing.JLabel jlRG_Incricao;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlSituacao;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JRadioButton jrbFeminino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JRadioButton jrbPessoaFisica;
    private javax.swing.JRadioButton jrbPessoaJuridica;
    private javax.swing.JScrollPane jspObs;
    private javax.swing.JTextArea jtaObs;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCargo;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfCodigoInterno;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfFiador;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNomeFantasia;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRG;
    // End of variables declaration//GEN-END:variables
}
