/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadCliente;

import Interface.TelaPrincipal.Sessao;
import dao.CidadeDAO;
import dao.EstadoCivilDAO;
import dao.EstadoDAO;
import dao.PessoaFisicaDAO;
import dao.TipoContratoDAO;
import global.model.Cidade;
import global.model.Endereco;
import global.model.Estado;
import imovel.model.TipoContrato;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.pessoa.EstadoCivil;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import model.pessoa.Telefone;
import validacao.validacao;

/**
 *
 * @author Rafael Brock
 */
public class cadastroFiador extends javax.swing.JFrame {

    /**
     * Creates new form cadastroFiador
     */
    private static cadastroFiador instancia;
    private List<Cidade> listaCidadesGlobal;
    private int indexCidade;
    
    public cadastroFiador() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        this.setTitle("Cadastro de Fiador");
        configuraMascaras();
        carregaEstados();
        carregaCidades();
        carregaEstadosCivis();
        populaFiador();
//        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
    }
    
    public static cadastroFiador getInstancia() {
        if (instancia == null) {
            instancia = new cadastroFiador();
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
                break;
            case 2:
                DisableEnable(true);
                jbConfirmar.setEnabled(true);
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
        jtfEndereco.setEnabled(b);
        jtfNumero.setEnabled(b);
        jtfBairro.setEnabled(b);
        jftCEP.setEnabled(b);
        jcbCidade.setEnabled(b);
        jtfComplemento.setEnabled(b);
        jftTelefone.setEnabled(b);
        jftCelular.setEnabled(b);
        jftComercial.setEnabled(b);
        jtfEmail.setEnabled(b);

        //cad Fim 
        // JRB        
        jrbMasculino.setEnabled(b);
        jrbFeminino.setEnabled(b);

        // jrb fim
        // jcb     
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
        jtfEndereco.setText("");
        jtfNumero.setText("");
        jtfBairro.setText("");
        jftCEP.setText("");
        jtfComplemento.setText("");
        jftTelefone.setText("");
        jftCelular.setText("");
        jftComercial.setText("");
        jtfEmail.setText("");

        //cad Fim 
        // JRB
        jrbMasculino.setSelected(false);
        jrbFeminino.setSelected(false);

        // jrb fim
        // jcb     
        jcbCompra.setSelected(false);
        jcbTroca.setSelected(false);
        jcbLocacao.setSelected(false);
        jcbEstadoCivil.setSelectedIndex(-1);
        jcbCidade.setSelectedIndex(-1);
        jcbEstado.setSelectedIndex(-1);

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
        // Fim
    }
    
    public void cadastrarFiador() throws ParseException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica fiador = new PessoaFisica();
        fiador.setTipoPessoa(true);
        fiador.setNomePessoa(jtfNome.getText());
        fiador.setCPF(jftCPF.getText());
        fiador.setRG(jtfRG.getText());
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataNascimento.getText());
        fiador.setDataNascimento(dataNascimento);
        
        Cidade cidade = (Cidade) jcbCidade.getSelectedItem();
        
        Endereco endereco = new Endereco();
        endereco.setBairro(jtfBairro.getText());
        endereco.setNomeEndereco(jtfEndereco.getText());
        endereco.setNumero(Integer.parseInt(jtfNumero.getText()));
        endereco.setCep(jftCEP.getText());
        endereco.setComplemento(jtfComplemento.getText());
        endereco.setCidade(cidade);
        fiador.setEndereco(endereco);
        
        List<Telefone> telefones = new ArrayList<Telefone>();
        Telefone telefone = new Telefone();
        Telefone celular = new Telefone();
        Telefone comercial = new Telefone();
        
        telefone.setNumero(jftTelefone.getText());
        telefone.setPessoa(fiador);
        telefone.setOperadora("");
        celular.setNumero(jftCelular.getText());
        celular.setPessoa(fiador);
        celular.setOperadora("");
        comercial.setNumero(jftComercial.getText());
        comercial.setPessoa(fiador);
        comercial.setOperadora("");
        
        telefones.add(telefone);
        telefones.add(celular);
        telefones.add(comercial);
        fiador.setTelefone(telefones);
        
        fiador.setEmail(jtfEmail.getText());
        
        if (jrbMasculino.isSelected()) {
            fiador.setSexo('M');
        } else if (jrbFeminino.isSelected()) {
            fiador.setSexo('F');
        }
        
        EstadoCivil estadoCivil = (EstadoCivil) jcbEstadoCivil.getSelectedItem();
        fiador.setEstadoCivil(estadoCivil);
        
        fiador.setEstadoCivil(estadoCivil);
        
        TipoContratoDAO tipoContratoDAO = new TipoContratoDAO();
        TipoContrato tipoContrato = new TipoContrato();
        List<TipoContrato> tiposContrato = new ArrayList<TipoContrato>();
        tiposContrato = tipoContratoDAO.getAll();
        List<TipoContrato> interesses = new ArrayList<TipoContrato>();
        
        if (jcbLocacao.isSelected()) {
            interesses.add(tiposContrato.get(0));
        }
        if (jcbCompra.isSelected()) {
            interesses.add(tiposContrato.get(1));
        }
        if (jcbTroca.isSelected()) {
            interesses.add(tiposContrato.get(2));
        }
        fiador.setInteresses(interesses);
        
        pessoaFisicaDAO.persist(fiador);
        
        cadastroCliente.getInstancia().fiadorGlobal = fiador;
        System.out.println("=================================================" + cadastroCliente.getInstancia().fiadorGlobal.getNomePessoa());
    }
    
    public void populaFiador() {
        Pessoa pessoa = new Pessoa();
        jtfCodigoInterno.setText(pessoa.getIdPessoa() + "");
        jtfNome.setText(cadastroCliente.getInstancia().jtfNovoFiador.getText());
        jftCPF.setText("38933784802");
        System.out.println("Aqui CPF" + jftCPF.getText());
        jtfRG.setText("RG");
        jftDataNascimento.setText("25/08/1991");
        jrbMasculino.setSelected(true);
        jcbEstadoCivil.setSelectedIndex(0);
        jtfEndereco.setText("Av. Guilherme de Almeida");
        jtfNumero.setText("2025");
        jtfComplemento.setText("");
        jtfBairro.setText("Morro do Algodão");
        
        jftCEP.setText("11.671-000");
        jcbCidade.setSelectedIndex(189);
        
        jftTelefone.setText("1238875776");
        jftCelular.setText("12981097059");
        jftComercial.setText("");
        jtfEmail.setText("teste@teste");
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
        //PESSOA FÍSICA

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
        //Estado Cíveil
        if (jcbEstadoCivil.getSelectedItem() != null) {
            jcbEstadoCivil.setBackground(Color.white);
        } else {
            jcbEstadoCivil.setBackground(Color.red);
            valida = false;
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
//        jcbCidade.setText("");
        jcbCidade.setBackground(Color.white);
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
        jtfComplemento.setText("");
        jtfComplemento.setBackground(Color.white);
        jtfEmail.setText("");
        jtfEmail.setBackground(Color.white);
    }
    
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
        jlCodigoInterno = new javax.swing.JLabel();
        jtfCodigoInterno = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jlCPF_CNPJ = new javax.swing.JLabel();
        jlRG_Incricao = new javax.swing.JLabel();
        jlSexo = new javax.swing.JLabel();
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
        jlDataNascimento = new javax.swing.JLabel();
        jlEstadoCivil = new javax.swing.JLabel();
        jcbEstadoCivil = new javax.swing.JComboBox();
        jftDataNascimento = new javax.swing.JFormattedTextField();
        jlInteresses = new javax.swing.JLabel();
        jcbLocacao = new javax.swing.JCheckBox();
        jcbCompra = new javax.swing.JCheckBox();
        jcbTroca = new javax.swing.JCheckBox();
        jtfNumero = new javax.swing.JTextField();
        jlCEP = new javax.swing.JLabel();
        jftCEP = new javax.swing.JFormattedTextField();
        jcbEstado = new javax.swing.JComboBox();
        jcbCidade = new javax.swing.JComboBox<>();
        jtfComplemento = new javax.swing.JTextField();
        jftTelefone = new javax.swing.JFormattedTextField();
        jftCelular = new javax.swing.JFormattedTextField();
        jftComercial = new javax.swing.JFormattedTextField();
        jtfEmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 640));
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setPreferredSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbConfirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbConfirmar.setText("Confirmar");
        jbConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConfirmarMouseClicked(evt);
            }
        });
        getContentPane().add(jbConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 140, 70));

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 140, 70));

        jlCodigoInterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoInterno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCodigoInterno.setText("Código Interno:");
        getContentPane().add(jlCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 30));

        jtfCodigoInterno.setEditable(false);
        getContentPane().add(jtfCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 100, 30));

        jlNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNome.setText("Nome:");
        getContentPane().add(jlNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 30));

        jlCPF_CNPJ.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF_CNPJ.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCPF_CNPJ.setText("CPF:");
        getContentPane().add(jlCPF_CNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 150, 30));

        jlRG_Incricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRG_Incricao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlRG_Incricao.setText("RG:");
        getContentPane().add(jlRG_Incricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 30, 30));

        jlSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSexo.setText("Sexo:");
        getContentPane().add(jlSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 40, 30));
        getContentPane().add(jtfRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 160, 30));
        getContentPane().add(jtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 350, 30));
        getContentPane().add(jtfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 170, 30));
        getContentPane().add(jtfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 350, 30));

        jrbMasculino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbMasculino.setText("Masculino");
        getContentPane().add(jrbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, 30));

        jrbFeminino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbFeminino.setText("Feminino");
        getContentPane().add(jrbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, -1, 30));
        getContentPane().add(jftCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 150, 30));

        jlEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEndereco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlEndereco.setText("Endereço:");
        getContentPane().add(jlEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 150, 30));

        jlNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNumero.setText("Número:");
        getContentPane().add(jlNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, 30));

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setText("Bairro:");
        getContentPane().add(jlBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, 30));

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setText("Cidade:");
        getContentPane().add(jlCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 50, 30));

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("Estado:");
        getContentPane().add(jlEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, 30));

        jlTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTelefone.setText("Telefone:");
        getContentPane().add(jlTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 150, 30));

        jlCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCelular.setText("Celular:");
        getContentPane().add(jlCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 60, 30));

        jlComercial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComercial.setText("Alternativo:");
        getContentPane().add(jlComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, -1, 30));

        jlEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlEmail.setText("Email:");
        getContentPane().add(jlEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 150, 30));

        jlComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComplemento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlComplemento.setText("Complemento:");
        getContentPane().add(jlComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, 30));

        jlDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDataNascimento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlDataNascimento.setText("Data de Nascimento:");
        getContentPane().add(jlDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 140, 30));

        jlEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstadoCivil.setText("Estado Civil:");
        getContentPane().add(jlEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, 30));

        jcbEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 130, 30));
        getContentPane().add(jftDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 100, 30));

        jlInteresses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlInteresses.setText("Interesses");
        getContentPane().add(jlInteresses, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, -1, 30));

        jcbLocacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbLocacao.setText("Locação");
        getContentPane().add(jcbLocacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, -1, 30));

        jcbCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbCompra.setText("Compra");
        getContentPane().add(jcbCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, -1, 30));

        jcbTroca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbTroca.setText("Temporada");
        getContentPane().add(jcbTroca, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 100, 30));
        getContentPane().add(jtfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 50, 30));

        jlCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCEP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCEP.setText("CEP:");
        getContentPane().add(jlCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 150, 30));
        getContentPane().add(jftCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 110, 30));

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 70, 30));

        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 230, 30));
        getContentPane().add(jtfComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 760, 30));
        getContentPane().add(jftTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 180, 30));
        getContentPane().add(jftCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 200, 30));
        getContentPane().add(jftComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 220, 30));
        getContentPane().add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 760, 30));

        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Fiador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18)));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 970, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMouseClicked
        if (jbConfirmar.isEnabled()) {
            if (validaCampos(true)) {
                try {
                    cadastrarFiador();
                    JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
                    ZerarCampos();
                    cadastroCliente.getInstancia().carregaFiadores();
                    cadastroCliente.getInstancia().jcbFiador.getModel().setSelectedItem(cadastroCliente.getInstancia().fiadorGlobal);
//                    cadastroCliente.getInstancia().jtfNovoFiador.setText("");
                    cadastroFiador.getInstancia().dispose();
                    instancia = null;
                } catch (ParseException ex) {
                    Logger.getLogger(cadastroFiador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Verifique os campos obrigatórios!");
            }
        }
    }//GEN-LAST:event_jbConfirmarMouseClicked

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        if (jbCancelar.isEnabled()) {
            if (jbCancelar.isEnabled()) {//
                String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(this, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    cadastroFiador.getInstancia().dispose();
                    instancia = null;
                }
            }
        }
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        if (jcbEstado.getSelectedIndex() > -1) {
            carregaCidadeEstados();
        }
    }//GEN-LAST:event_jcbEstadoActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cadastroFiador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroFiador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroFiador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroFiador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroFiador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JCheckBox jcbCompra;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JComboBox jcbEstadoCivil;
    private javax.swing.JCheckBox jcbLocacao;
    private javax.swing.JCheckBox jcbTroca;
    private javax.swing.JFormattedTextField jftCEP;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JFormattedTextField jftCelular;
    private javax.swing.JFormattedTextField jftComercial;
    private javax.swing.JFormattedTextField jftDataNascimento;
    private javax.swing.JFormattedTextField jftTelefone;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCEP;
    private javax.swing.JLabel jlCPF_CNPJ;
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
    private javax.swing.JLabel jlInteresses;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlRG_Incricao;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JRadioButton jrbFeminino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCodigoInterno;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRG;
    // End of variables declaration//GEN-END:variables
}
