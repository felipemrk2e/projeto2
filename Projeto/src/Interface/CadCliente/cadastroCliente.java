/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadCliente;

import dao.EstadoDAO;
import global.model.Estado;
import java.awt.Color;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import validacao.*;

/**
 *
 * @author Sala
 */
public class cadastroCliente extends javax.swing.JFrame {

    private boolean fiador;

    /**
     * Creates new form cadastroCliente
     */
    public cadastroCliente() {
        initComponents();
        ativaPessoa(true);
        mascaraCPF_CNPJ(true);
        jrbPessoaFisica.setSelected(true);
        configuraMascaras();
//        carregaEstados();

        UIManager.getDefaults().put("jtpCadastroCliente.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.getDefaults().put("jtpCadastroCliente.tabsOverlapBorder", true);

    }

    public cadastroCliente(int user, long idCliente) {
        initComponents();
        ativaPessoa(true);
        mascaraCPF_CNPJ(true);
        jrbPessoaFisica.setSelected(true);
        configuraMascaras();

        UIManager.getDefaults().put("jtpCadastroCliente.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.getDefaults().put("jtpCadastroCliente.tabsOverlapBorder", true);

        popular();
        DisableEnable(false);

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
        jSeparator1 = new javax.swing.JSeparator();
        jtfNumero = new javax.swing.JTextField();
        jlCEP = new javax.swing.JLabel();
        jftCEP = new javax.swing.JFormattedTextField();
        jcbEstado = new javax.swing.JComboBox();
        jtfComplemento = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jftTelefone = new javax.swing.JFormattedTextField();
        jftCelular = new javax.swing.JFormattedTextField();
        jftComercial = new javax.swing.JFormattedTextField();
        jtfEmail = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jrbPessoaFisica = new javax.swing.JRadioButton();
        jrbPessoaJuridica = new javax.swing.JRadioButton();
        jcbAtivo = new javax.swing.JCheckBox();
        jlSituacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbConfirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbConfirmar.setText("Confirmar");
        jbConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConfirmarMouseClicked(evt);
            }
        });
        getContentPane().add(jbConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 140, 70));

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 140, 70));

        jbEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEditarMouseClicked(evt);
            }
        });
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 140, 70));

        jlCodigoInterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoInterno.setText("Código Interno");
        getContentPane().add(jlCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jtfCodigoInterno.setEditable(false);
        getContentPane().add(jtfCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, -1));

        jlNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNome.setText("Nome");
        getContentPane().add(jlNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jlCPF_CNPJ.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF_CNPJ.setText("CPF");
        getContentPane().add(jlCPF_CNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        jlRG_Incricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRG_Incricao.setText("RG");
        getContentPane().add(jlRG_Incricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        jlSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSexo.setText("Sexo");
        getContentPane().add(jlSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));
        getContentPane().add(jtfRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 150, -1));
        getContentPane().add(jtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 400, -1));
        getContentPane().add(jtfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 130, -1));
        getContentPane().add(jtfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 140, -1));
        getContentPane().add(jtfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 400, -1));

        bgSexo.add(jrbMasculino);
        jrbMasculino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbMasculino.setText("Masculino");
        getContentPane().add(jrbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 28, -1, -1));

        bgSexo.add(jrbFeminino);
        jrbFeminino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbFeminino.setText("Feminino");
        getContentPane().add(jrbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 28, -1, -1));
        getContentPane().add(jftCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 150, -1));

        jlEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEndereco.setText("Endereço");
        getContentPane().add(jlEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jlNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNumero.setText("Nº");
        getContentPane().add(jlNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setText("Bairro");
        getContentPane().add(jlBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setText("Cidade");
        getContentPane().add(jlCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("Estado");
        getContentPane().add(jlEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        jlTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTelefone.setText("Telefone");
        getContentPane().add(jlTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));

        jlCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCelular.setText("Celular");
        getContentPane().add(jlCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 60, -1));

        jlComercial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComercial.setText("Alternativo");
        getContentPane().add(jlComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        jlEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEmail.setText("Email");
        getContentPane().add(jlEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        jlComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComplemento.setText("Complemento");
        getContentPane().add(jlComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        jlObs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlObs.setText("Observações");
        getContentPane().add(jlObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, 30));

        jlCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargo.setText("Cargo");
        getContentPane().add(jlCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));
        getContentPane().add(jtfCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 150, -1));

        jlDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDataNascimento.setText("Data de Nascimento");
        getContentPane().add(jlDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        jlEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstadoCivil.setText("Estado Civil");
        getContentPane().add(jlEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, -1, -1));

        jcbEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoCivilActionPerformed(evt);
            }
        });
        getContentPane().add(jcbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, -1, -1));

        jlFiador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlFiador.setText("Fiador");
        getContentPane().add(jlFiador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));
        getContentPane().add(jtfFiador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 400, -1));
        getContentPane().add(jftDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 130, -1));

        jlNomeFantasia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeFantasia.setText("Nome Fantasia");
        getContentPane().add(jlNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));
        getContentPane().add(jtfNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 400, -1));

        jlCPFResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPFResponsavel.setText("CPF Responsavel");
        getContentPane().add(jlCPFResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));
        getContentPane().add(jftCPFResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 150, -1));

        jspObs.setBorder(null);

        jtaObs.setColumns(20);
        jtaObs.setRows(5);
        jspObs.setViewportView(jtaObs);

        getContentPane().add(jspObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 380, 65));

        jlInteresses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlInteresses.setText("Interesses");
        getContentPane().add(jlInteresses, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, -1, -1));

        jcbCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbCompra.setText("Compra");
        getContentPane().add(jcbCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, -1, -1));

        jcbTroca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbTroca.setText("Troca");
        getContentPane().add(jcbTroca, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, -1, -1));

        jcbLocacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbLocacao.setText("Locação");
        getContentPane().add(jcbLocacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 830, 140));
        getContentPane().add(jtfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 50, -1));

        jlCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCEP.setText("CEP");
        getContentPane().add(jlCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));
        getContentPane().add(jftCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 110, -1));

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));
        getContentPane().add(jtfComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 230, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 830, 120));
        getContentPane().add(jftTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 110, -1));
        getContentPane().add(jftCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 130, -1));
        getContentPane().add(jftComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 110, -1));
        getContentPane().add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 230, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 830, 90));

        bgPessoa.add(jrbPessoaFisica);
        jrbPessoaFisica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbPessoaFisica.setText("Física");
        jrbPessoaFisica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jrbPessoaFisicaMousePressed(evt);
            }
        });
        getContentPane().add(jrbPessoaFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        bgPessoa.add(jrbPessoaJuridica);
        jrbPessoaJuridica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbPessoaJuridica.setText("Jurídica");
        jrbPessoaJuridica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jrbPessoaJuridicaMousePressed(evt);
            }
        });
        getContentPane().add(jrbPessoaJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jcbAtivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbAtivo.setText("Ativo");
        getContentPane().add(jcbAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        jlSituacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSituacao.setText("Situação Cadastral");
        getContentPane().add(jlSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMouseClicked
        if (jbConfirmar.isEnabled()) {

            if (!validaCampos(true)) {
                JOptionPane.showMessageDialog(null, "Verifique os campos obrigatórios!");
            }

        }


    }//GEN-LAST:event_jbConfirmarMouseClicked

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
//        new cadastroImovelHome().setVisible(true);
//        dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jrbPessoaJuridicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPessoaJuridicaMousePressed
        ativaPessoa(false);
        mascaraCPF_CNPJ(false);
        limpaCampos();
    }//GEN-LAST:event_jrbPessoaJuridicaMousePressed

    private void jrbPessoaFisicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPessoaFisicaMousePressed
        ativaPessoa(true);
        mascaraCPF_CNPJ(true);
        limpaCampos();
    }//GEN-LAST:event_jrbPessoaFisicaMousePressed

    private void jcbEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEstadoCivilActionPerformed

    private void jbEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMouseClicked
        if (jbEditar.isEnabled()) {

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
            if (jrbMasculino.isSelected() || jrbFeminino.isSelected()) {
                jrbMasculino.setBackground(Color.white);
                jrbFeminino.setBackground(Color.white);
            } else {
                jrbMasculino.setBackground(Color.red);
                jrbFeminino.setBackground(Color.red);
                valida = false;
            }
            if (jcbEstadoCivil.getSelectedItem() == "") {
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

    public void carregaEstados(){
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
    
    
    public void setJcbEstado() throws SQLException {
//        List<String> strList = new ArrayList<String>();
//        String query = "SELECT UF FROM Estado";
//        Connection con = Conexao.getConnection();
//        PreparedStatement ps = con.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next) {
//            strList.add(rs.getString("UF"));
//        }
//        ps.close();
//
//        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(strList.toArray());
//        jcbEstado.setModel(defaultComboBox);
    }

    public void setJcbEstadoCivil() throws SQLException {
//        List<String> strList = new ArrayList<String>();
//        String query = "SELECT nomeEstadoCivil FROM EstadoCivil";
//        Connection con = Conexao.getConnection();
//        PreparedStatement ps = con.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next) {
//            strList.add(rs.getString("nomeEstadoCivil"));
//        }
//        ps.close();
//
//        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(strList.toArray());
//        jcbEstadoCivil.setModel(defaultComboBox);
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
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
