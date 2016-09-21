/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadImovel;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import validacao.validacao;


public class cadastroImovel extends javax.swing.JFrame {

    /**
     * Creates new form cadastroImovel2
     */
    public cadastroImovel() {
        initComponents();
        fecharCadastro();
        removerTitleBar();

    }

    public cadastroImovel(String idImovel) {
        initComponents();
        fecharCadastro();
        removerTitleBar();
        //Falta fazer a consulta no banco e mudar o popular para receber o objeto com os dados do banco e setar dentro dele

        popular();
    }

    public void popular() {
        //-----------------
        if (true) {
            jrbCasa.setSelected(true);
        } else if (true) {
            jrbApartamento.setSelected(true);
        } else if (true) {
            jrbCondominio.setSelected(true);
        } else if (true) {

            jrbComercio.setSelected(true);

        } else if (true) {
            jrbSalao.setSelected(true);

        }

        //----------------  Falta dar enable nos campos apos a população
        if (true) {
            jcbLocacao.setSelected(true);
            jtValorLocacaoMes.setEnabled(true);

        }
        if (true) {
            jcbTemporada.setSelected(true);
            jtValorTemporada.setEnabled(true);
        }
        if (true) {
            jcbVenda.setSelected(true);
            jtValorVenda.setEnabled(true);
        }
        if (true) {
            jcbFesta.setSelected(true);
            jtValorDiaria.setEnabled(true);
        }

        //---------------- 
        if (true) {
            jrbMobiliada.setSelected(true);
        } else if (true) {
            jrbSemMobilia.setSelected(true);
        } else if (true) {
            jrbSemiMobiliada.setSelected(true);
        }

        jtCodigo.setText("");
        jtfStatus.setText("");

        //Endereço
        jtfLogradouro.setText("");
        jtfNumero.setText("");
        jtfComplemento.setText("");
        jtfCidade.setText("");
        jtfBairro.setText("");
        jtfUF.setText("");
        jtfReferencia.setText("");
        jtfZona.setText("");
        jtfCondominio.setText("");

        //valores
        jtValorLocacaoMes.setText("");
        jtValorVenda.setText("");
        jtValorTemporada.setText("");
        jtValorIptu.setText("");
        jtValorCondominio.setText("");
        jtValorDiaria.setText("");

        //Outros 
        jtMatriculo.setText("");
        jtContaAgua.setText("");
        jtContaLuz.setText("");
        jtIptu.setText("");
        jtContrato.setText("");
        jtCartorio.setText("");
        jtSituacaoEscritura.setText("");
        //Precisa adicionar as medidas do terreno
        jtAreaConstruida.setText("");
        //não esquecer
        jtMobilia.setText("");
        jtChaves.setText("");
        jtObservacao.setText("");

        //Descrição  
        jtQuartos.setText("");
        jtSuites.setText("");
        jtSalas.setText("");
        jtBanheiros.setText("");
        jtLavados.setText("");
        jtAreaServico.setText("");
        jtLavanderia.setText("");
        jtPisos.setText("");
        jtIdadeImovel.setText("");
        jtPscina.setText("");
        jtVagasGaragem.setText("");
        jtDepEmpregada.setText("");
        jtTipoImovel.setText("");
        jtAreaExterna.setText("");
        jtAcabamento.setText("");
        jtOutros.setText("");

    }

    public void removerTitleBar() {

        ((javax.swing.plaf.basic.BasicInternalFrameUI) jifEndereco.getUI()).setNorthPane(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) jifOutros.getUI()).setNorthPane(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) jifDescricao.getUI()).setNorthPane(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) jifValores.getUI()).setNorthPane(null);

    }

    public void fecharCadastro() {
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
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
                    System.exit(0);
                }
//                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgMobilia = new javax.swing.ButtonGroup();
        bgTipo = new javax.swing.ButtonGroup();
        jtpCadastro = new javax.swing.JTabbedPane();
        jifEndereco = new javax.swing.JInternalFrame();
        jlComplemento = new javax.swing.JLabel();
        jlZona = new javax.swing.JLabel();
        jlReferencia = new javax.swing.JLabel();
        jlCondominio = new javax.swing.JLabel();
        jlUF = new javax.swing.JLabel();
        jlNumero = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jlLogradouro = new javax.swing.JLabel();
        jtfUF = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jtfCidade = new javax.swing.JTextField();
        jtfLogradouro = new javax.swing.JTextField();
        jtfNumero = new javax.swing.JTextField();
        jtfCondominio = new javax.swing.JTextField();
        jtfZona = new javax.swing.JTextField();
        jtfComplemento = new javax.swing.JTextField();
        jtfReferencia = new javax.swing.JTextField();
        jifValores = new javax.swing.JInternalFrame();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jtValorLocacaoMes = new javax.swing.JTextField();
        jtValorVenda = new javax.swing.JTextField();
        jtValorCondominio = new javax.swing.JTextField();
        jtValorTemporada = new javax.swing.JTextField();
        jtValorIptu = new javax.swing.JTextField();
        jtValorDiaria = new javax.swing.JTextField();
        jifOutros = new javax.swing.JInternalFrame();
        jLabel35 = new javax.swing.JLabel();
        jtMedidasTerreno = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jtAreaConstruida = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jtSituacaoEscritura = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jtTamanhoTerreno = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtChaves = new javax.swing.JTextArea();
        jLabel40 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtMobilia = new javax.swing.JTextArea();
        jtMatriculo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtContrato = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtContaAgua = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtIptu = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtContaLuz = new javax.swing.JTextField();
        jtCartorio = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtObservacao = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jrbMobiliada = new javax.swing.JRadioButton();
        jrbSemiMobiliada = new javax.swing.JRadioButton();
        jrbSemMobilia = new javax.swing.JRadioButton();
        jifDescricao = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jtSalas = new javax.swing.JTextField();
        jtBanheiros = new javax.swing.JTextField();
        jtLavanderia = new javax.swing.JTextField();
        jtSuites = new javax.swing.JTextField();
        jtQuartos = new javax.swing.JTextField();
        jtLavados = new javax.swing.JTextField();
        jtAreaServico = new javax.swing.JTextField();
        jtPscina = new javax.swing.JTextField();
        jtDepEmpregada = new javax.swing.JTextField();
        jtPisos = new javax.swing.JTextField();
        jtVagasGaragem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTipoImovel = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAreaExterna = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtAcabamento = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtOutros = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtIdadeImovel = new javax.swing.JTextField();
        jlCodigo = new javax.swing.JLabel();
        jcbLocacao = new javax.swing.JCheckBox();
        jtCodigo = new javax.swing.JTextField();
        jcbVenda = new javax.swing.JCheckBox();
        jcbTemporada = new javax.swing.JCheckBox();
        jcbFesta = new javax.swing.JCheckBox();
        jlTipo = new javax.swing.JLabel();
        jrbCasa = new javax.swing.JRadioButton();
        jrbApartamento = new javax.swing.JRadioButton();
        jrbSalao = new javax.swing.JRadioButton();
        jrbComercio = new javax.swing.JRadioButton();
        jrbCondominio = new javax.swing.JRadioButton();
        jlStatus = new javax.swing.JLabel();
        jtfStatus = new javax.swing.JTextField();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jmenuCadastro = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        jifEndereco.setVisible(true);
        jifEndereco.getContentPane().setLayout(null);

        jlComplemento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlComplemento.setText("Complemento");
        jifEndereco.getContentPane().add(jlComplemento);
        jlComplemento.setBounds(530, 40, 110, 15);

        jlZona.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlZona.setText("Zona");
        jifEndereco.getContentPane().add(jlZona);
        jlZona.setBounds(540, 160, 34, 15);

        jlReferencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlReferencia.setText("Referência");
        jifEndereco.getContentPane().add(jlReferencia);
        jlReferencia.setBounds(70, 160, 60, 15);

        jlCondominio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlCondominio.setText("Condomínio");
        jifEndereco.getContentPane().add(jlCondominio);
        jlCondominio.setBounds(68, 213, 68, 15);

        jlUF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlUF.setText("UF");
        jifEndereco.getContentPane().add(jlUF);
        jlUF.setBounds(540, 100, 16, 15);

        jlNumero.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlNumero.setText("Nº");
        jifEndereco.getContentPane().add(jlNumero);
        jlNumero.setBounds(460, 40, 13, 15);

        jlBairro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlBairro.setText("Bairro");
        jifEndereco.getContentPane().add(jlBairro);
        jlBairro.setBounds(312, 100, 80, 15);

        jlCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlCidade.setText("Cidade");
        jifEndereco.getContentPane().add(jlCidade);
        jlCidade.setBounds(68, 100, 40, 15);

        jlLogradouro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlLogradouro.setText("Logradouro");
        jifEndereco.getContentPane().add(jlLogradouro);
        jlLogradouro.setBounds(68, 40, 64, 15);

        jtfUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUFActionPerformed(evt);
            }
        });
        jifEndereco.getContentPane().add(jtfUF);
        jtfUF.setBounds(540, 120, 70, 20);
        jifEndereco.getContentPane().add(jtfBairro);
        jtfBairro.setBounds(312, 120, 190, 20);
        jifEndereco.getContentPane().add(jtfCidade);
        jtfCidade.setBounds(68, 120, 150, 20);
        jifEndereco.getContentPane().add(jtfLogradouro);
        jtfLogradouro.setBounds(68, 60, 370, 20);

        jtfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNumeroActionPerformed(evt);
            }
        });
        jifEndereco.getContentPane().add(jtfNumero);
        jtfNumero.setBounds(458, 60, 50, 20);
        jifEndereco.getContentPane().add(jtfCondominio);
        jtfCondominio.setBounds(68, 234, 230, 20);
        jifEndereco.getContentPane().add(jtfZona);
        jtfZona.setBounds(538, 183, 90, 20);
        jifEndereco.getContentPane().add(jtfComplemento);
        jtfComplemento.setBounds(528, 60, 100, 20);
        jifEndereco.getContentPane().add(jtfReferencia);
        jtfReferencia.setBounds(68, 183, 450, 20);

        jtpCadastro.addTab("Endereço", jifEndereco);

        jifValores.setVisible(true);
        jifValores.getContentPane().setLayout(null);

        jLabel38.setText("valor locação mes");
        jifValores.getContentPane().add(jLabel38);
        jLabel38.setBounds(10, 20, 120, 14);

        jLabel39.setText("valor  iptu");
        jifValores.getContentPane().add(jLabel39);
        jLabel39.setBounds(10, 110, 100, 14);

        jLabel41.setText("valor condominio");
        jifValores.getContentPane().add(jLabel41);
        jLabel41.setBounds(10, 140, 120, 14);

        jLabel43.setText("valor venda");
        jifValores.getContentPane().add(jLabel43);
        jLabel43.setBounds(10, 50, 100, 14);

        jLabel44.setText("valor temporada");
        jifValores.getContentPane().add(jLabel44);
        jLabel44.setBounds(10, 80, 110, 14);

        jLabel45.setText("valor Festa");
        jifValores.getContentPane().add(jLabel45);
        jLabel45.setBounds(10, 170, 110, 14);

        jtValorLocacaoMes.setEditable(false);
        jtValorLocacaoMes.setEnabled(false);
        jifValores.getContentPane().add(jtValorLocacaoMes);
        jtValorLocacaoMes.setBounds(130, 20, 60, 20);

        jtValorVenda.setEditable(false);
        jtValorVenda.setEnabled(false);
        jifValores.getContentPane().add(jtValorVenda);
        jtValorVenda.setBounds(130, 50, 60, 20);
        jifValores.getContentPane().add(jtValorCondominio);
        jtValorCondominio.setBounds(130, 140, 60, 20);

        jtValorTemporada.setEditable(false);
        jtValorTemporada.setEnabled(false);
        jifValores.getContentPane().add(jtValorTemporada);
        jtValorTemporada.setBounds(130, 80, 60, 20);
        jifValores.getContentPane().add(jtValorIptu);
        jtValorIptu.setBounds(130, 110, 60, 20);

        jtValorDiaria.setEditable(false);
        jtValorDiaria.setEnabled(false);
        jifValores.getContentPane().add(jtValorDiaria);
        jtValorDiaria.setBounds(130, 170, 60, 20);

        jtpCadastro.addTab("Valores", jifValores);

        jifOutros.setVisible(true);
        jifOutros.getContentPane().setLayout(null);

        jLabel35.setText("Medidas terreno");
        jifOutros.getContentPane().add(jLabel35);
        jLabel35.setBounds(235, 10, 100, 20);
        jifOutros.getContentPane().add(jtMedidasTerreno);
        jtMedidasTerreno.setBounds(360, 10, 60, 20);

        jLabel34.setText("Area construida");
        jifOutros.getContentPane().add(jLabel34);
        jLabel34.setBounds(235, 40, 100, 14);
        jifOutros.getContentPane().add(jtAreaConstruida);
        jtAreaConstruida.setBounds(360, 40, 60, 20);

        jLabel36.setText("Tamanho terreno");
        jifOutros.getContentPane().add(jLabel36);
        jLabel36.setBounds(235, 70, 110, 20);
        jifOutros.getContentPane().add(jtSituacaoEscritura);
        jtSituacaoEscritura.setBounds(40, 240, 130, 20);

        jLabel37.setText("Situação Escritura");
        jifOutros.getContentPane().add(jLabel37);
        jLabel37.setBounds(50, 210, 140, 20);
        jifOutros.getContentPane().add(jtTamanhoTerreno);
        jtTamanhoTerreno.setBounds(360, 70, 60, 20);

        jtChaves.setColumns(20);
        jtChaves.setRows(5);
        jScrollPane6.setViewportView(jtChaves);

        jifOutros.getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(570, 120, 190, 90);

        jLabel40.setText("Chaves");
        jifOutros.getContentPane().add(jLabel40);
        jLabel40.setBounds(500, 130, 80, 22);

        jLabel46.setText("observaçoes gerais");
        jifOutros.getContentPane().add(jLabel46);
        jLabel46.setBounds(440, 240, 120, 20);

        jtMobilia.setColumns(20);
        jtMobilia.setRows(5);
        jScrollPane5.setViewportView(jtMobilia);

        jifOutros.getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(580, 20, 180, 80);
        jifOutros.getContentPane().add(jtMatriculo);
        jtMatriculo.setBounds(100, 10, 110, 20);

        jLabel15.setText("Nº Matricula");
        jifOutros.getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 10, 80, 20);

        jLabel16.setText("Nº Conta Agua");
        jifOutros.getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 40, 90, 14);
        jifOutros.getContentPane().add(jtContrato);
        jtContrato.setBounds(100, 130, 110, 20);

        jLabel17.setText("Nº Conta de luz");
        jifOutros.getContentPane().add(jLabel17);
        jLabel17.setBounds(10, 70, 90, 14);
        jifOutros.getContentPane().add(jtContaAgua);
        jtContaAgua.setBounds(100, 40, 110, 20);

        jLabel18.setText("Nº Iptu");
        jifOutros.getContentPane().add(jLabel18);
        jLabel18.setBounds(10, 100, 80, 20);
        jifOutros.getContentPane().add(jtIptu);
        jtIptu.setBounds(100, 100, 110, 20);

        jLabel19.setText("Cartorio");
        jifOutros.getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 160, 70, 14);

        jtContaLuz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtContaLuzActionPerformed(evt);
            }
        });
        jifOutros.getContentPane().add(jtContaLuz);
        jtContaLuz.setBounds(100, 70, 110, 20);
        jifOutros.getContentPane().add(jtCartorio);
        jtCartorio.setBounds(100, 160, 110, 20);

        jLabel20.setText("Nº Contrato");
        jifOutros.getContentPane().add(jLabel20);
        jLabel20.setBounds(10, 130, 80, 14);

        jtObservacao.setColumns(20);
        jtObservacao.setRows(5);
        jScrollPane8.setViewportView(jtObservacao);

        jifOutros.getContentPane().add(jScrollPane8);
        jScrollPane8.setBounds(570, 220, 190, 90);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setAlignmentX(2.0F);
        jSeparator1.setAlignmentY(2.0F);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jifOutros.getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 0, 220, 290);

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jifOutros.getContentPane().add(jSeparator2);
        jSeparator2.setBounds(230, 0, 210, 160);

        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jifOutros.getContentPane().add(jSeparator3);
        jSeparator3.setBounds(450, 10, 330, 100);

        bgMobilia.add(jrbMobiliada);
        jrbMobiliada.setText("Mobiliada");
        jifOutros.getContentPane().add(jrbMobiliada);
        jrbMobiliada.setBounds(460, 20, 90, 23);

        bgMobilia.add(jrbSemiMobiliada);
        jrbSemiMobiliada.setText("Semi Mobiliada");
        jifOutros.getContentPane().add(jrbSemiMobiliada);
        jrbSemiMobiliada.setBounds(460, 50, 120, 23);

        bgMobilia.add(jrbSemMobilia);
        jrbSemMobilia.setText("Sem Mobilia");
        jifOutros.getContentPane().add(jrbSemMobilia);
        jrbSemMobilia.setBounds(460, 80, 110, 23);

        jtpCadastro.addTab("Outros", jifOutros);

        jifDescricao.setVisible(true);
        jifDescricao.getContentPane().setLayout(null);

        jLabel1.setText("Quartos");
        jifDescricao.getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 20, 60, 14);

        jLabel2.setText("Suites");
        jifDescricao.getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 50, 60, 14);

        jLabel3.setText("Salas");
        jifDescricao.getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 80, 50, 14);

        jLabel4.setText("Lavanderia");
        jifDescricao.getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 200, 80, 14);

        jLabel23.setText("Vagas Garagem");
        jifDescricao.getContentPane().add(jLabel23);
        jLabel23.setBounds(200, 50, 100, 14);

        jLabel24.setText("Area de serviço");
        jifDescricao.getContentPane().add(jLabel24);
        jLabel24.setBounds(60, 170, 100, 14);

        jLabel25.setText("Pscina");
        jifDescricao.getContentPane().add(jLabel25);
        jLabel25.setBounds(200, 20, 50, 14);

        jLabel26.setText("Lavabos");
        jifDescricao.getContentPane().add(jLabel26);
        jLabel26.setBounds(60, 140, 60, 14);

        jLabel27.setText("Banheiros");
        jifDescricao.getContentPane().add(jLabel27);
        jLabel27.setBounds(60, 110, 70, 14);

        jLabel28.setText("Dep. Empregada");
        jifDescricao.getContentPane().add(jLabel28);
        jLabel28.setBounds(200, 80, 100, 14);

        jLabel29.setText("Pisos (Andares)");
        jifDescricao.getContentPane().add(jLabel29);
        jLabel29.setBounds(60, 230, 100, 14);
        jifDescricao.getContentPane().add(jtSalas);
        jtSalas.setBounds(15, 80, 30, 20);
        jifDescricao.getContentPane().add(jtBanheiros);
        jtBanheiros.setBounds(15, 110, 30, 20);
        jifDescricao.getContentPane().add(jtLavanderia);
        jtLavanderia.setBounds(15, 200, 30, 20);
        jifDescricao.getContentPane().add(jtSuites);
        jtSuites.setBounds(15, 50, 30, 20);
        jifDescricao.getContentPane().add(jtQuartos);
        jtQuartos.setBounds(15, 20, 30, 20);
        jifDescricao.getContentPane().add(jtLavados);
        jtLavados.setBounds(15, 140, 30, 20);
        jifDescricao.getContentPane().add(jtAreaServico);
        jtAreaServico.setBounds(15, 170, 30, 20);
        jifDescricao.getContentPane().add(jtPscina);
        jtPscina.setBounds(150, 20, 30, 20);
        jifDescricao.getContentPane().add(jtDepEmpregada);
        jtDepEmpregada.setBounds(150, 80, 30, 20);
        jifDescricao.getContentPane().add(jtPisos);
        jtPisos.setBounds(15, 230, 30, 20);
        jifDescricao.getContentPane().add(jtVagasGaragem);
        jtVagasGaragem.setBounds(150, 50, 30, 20);

        jtTipoImovel.setColumns(20);
        jtTipoImovel.setRows(5);
        jScrollPane1.setViewportView(jtTipoImovel);

        jifDescricao.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(500, 20, 200, 70);

        jtAreaExterna.setColumns(20);
        jtAreaExterna.setRows(5);
        jScrollPane2.setViewportView(jtAreaExterna);

        jifDescricao.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(500, 100, 200, 60);

        jtAcabamento.setColumns(20);
        jtAcabamento.setRows(5);
        jScrollPane3.setViewportView(jtAcabamento);

        jifDescricao.getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(500, 170, 200, 60);

        jLabel30.setText("Descrição Imovel");
        jifDescricao.getContentPane().add(jLabel30);
        jLabel30.setBounds(380, 50, 110, 14);

        jLabel31.setText("Area Externa");
        jifDescricao.getContentPane().add(jLabel31);
        jLabel31.setBounds(410, 110, 80, 14);

        jtOutros.setColumns(20);
        jtOutros.setRows(5);
        jScrollPane4.setViewportView(jtOutros);

        jifDescricao.getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(500, 240, 200, 60);

        jLabel33.setText("Acabamento");
        jifDescricao.getContentPane().add(jLabel33);
        jLabel33.setBounds(410, 180, 80, 14);

        jLabel32.setText("Outros");
        jifDescricao.getContentPane().add(jLabel32);
        jLabel32.setBounds(430, 240, 50, 14);

        jLabel14.setText("Idade Imovel");
        jifDescricao.getContentPane().add(jLabel14);
        jLabel14.setBounds(60, 260, 100, 20);
        jifDescricao.getContentPane().add(jtIdadeImovel);
        jtIdadeImovel.setBounds(15, 260, 30, 20);

        jtpCadastro.addTab("Descrição", jifDescricao);

        getContentPane().add(jtpCadastro);
        jtpCadastro.setBounds(160, 100, 820, 380);

        jlCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlCodigo.setText("Código Interno");
        getContentPane().add(jlCodigo);
        jlCodigo.setBounds(40, 10, 100, 15);

        jcbLocacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbLocacao.setText("Locação");
        jcbLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbLocacaoMouseClicked(evt);
            }
        });
        getContentPane().add(jcbLocacao);
        jcbLocacao.setBounds(40, 110, 90, 23);

        jtCodigo.setEditable(false);
        getContentPane().add(jtCodigo);
        jtCodigo.setBounds(30, 30, 110, 20);

        jcbVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbVenda.setText("Venda");
        jcbVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbVendaMouseClicked(evt);
            }
        });
        getContentPane().add(jcbVenda);
        jcbVenda.setBounds(40, 140, 90, 23);

        jcbTemporada.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbTemporada.setText("Temporada");
        jcbTemporada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbTemporadaMouseClicked(evt);
            }
        });
        getContentPane().add(jcbTemporada);
        jcbTemporada.setBounds(40, 170, 90, 23);

        jcbFesta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbFesta.setText("Festa");
        jcbFesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbFestaMouseClicked(evt);
            }
        });
        jcbFesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFestaActionPerformed(evt);
            }
        });
        getContentPane().add(jcbFesta);
        jcbFesta.setBounds(40, 200, 60, 23);

        jlTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlTipo.setText("Tipo");
        getContentPane().add(jlTipo);
        jlTipo.setBounds(470, 10, 40, 15);

        bgTipo.add(jrbCasa);
        jrbCasa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrbCasa.setText("Casa");
        getContentPane().add(jrbCasa);
        jrbCasa.setBounds(230, 30, 55, 23);

        bgTipo.add(jrbApartamento);
        jrbApartamento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrbApartamento.setText("Apartamento");
        getContentPane().add(jrbApartamento);
        jrbApartamento.setBounds(310, 30, 95, 23);

        bgTipo.add(jrbSalao);
        jrbSalao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrbSalao.setText("Salão");
        getContentPane().add(jrbSalao);
        jrbSalao.setBounds(430, 30, 57, 23);

        bgTipo.add(jrbComercio);
        jrbComercio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrbComercio.setText("Comércio");
        jrbComercio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbComercioActionPerformed(evt);
            }
        });
        getContentPane().add(jrbComercio);
        jrbComercio.setBounds(520, 30, 79, 23);

        bgTipo.add(jrbCondominio);
        jrbCondominio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrbCondominio.setText("Temporario");
        getContentPane().add(jrbCondominio);
        jrbCondominio.setBounds(630, 30, 89, 23);

        jlStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlStatus.setText("Status");
        getContentPane().add(jlStatus);
        jlStatus.setBounds(880, 10, 35, 15);
        getContentPane().add(jtfStatus);
        jtfStatus.setBounds(860, 30, 90, 20);

        jbConfirmar.setText("Confirmar");
        jbConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConfirmarMouseClicked(evt);
            }
        });
        getContentPane().add(jbConfirmar);
        jbConfirmar.setBounds(320, 500, 140, 70);

        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(490, 500, 140, 70);

        jbEditar.setText("Editar");
        getContentPane().add(jbEditar);
        jbEditar.setBounds(660, 500, 140, 70);

        jSeparator4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(30, 100, 110, 140);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(10, 0, 980, 70);

        jMenu1.setText("File");

        jMenuItem1.setText("Novo Cadastro");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jmenuCadastro.add(jMenu1);

        jMenu2.setText("Edit");
        jmenuCadastro.add(jMenu2);

        setJMenuBar(jmenuCadastro);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbFestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFestaActionPerformed

    private void jtfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNumeroActionPerformed

    private void jtfUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUFActionPerformed

    private void jrbComercioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbComercioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbComercioActionPerformed

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        new cadastroImovelHome().setVisible(true);
        dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jcbFestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbFestaMouseClicked

        if (jcbFesta.isSelected()) {
            jtValorDiaria.setEditable(true);
            jtValorDiaria.setEnabled(true);

        } else {
            jtValorDiaria.setEditable(false);
            jtValorDiaria.setEnabled(false);
            jtValorDiaria.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jcbFestaMouseClicked

    private void jcbTemporadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbTemporadaMouseClicked

        if (jcbTemporada.isSelected()) {
            jtValorTemporada.setEditable(true);
            jtValorTemporada.setEnabled(true);

        } else {
            jtValorTemporada.setEditable(false);
            jtValorTemporada.setEnabled(false);
            jtValorTemporada.setText("");
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jcbTemporadaMouseClicked

    private void jcbVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbVendaMouseClicked

        if (jcbVenda.isSelected()) {
            jtValorVenda.setEditable(true);
            jtValorVenda.setEnabled(true);

        } else {
            jtValorVenda.setEditable(false);
            jtValorVenda.setEnabled(false);
            jtValorVenda.setText("");
        } // TODO add your handling code here:
    }//GEN-LAST:event_jcbVendaMouseClicked

    private void jcbLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbLocacaoMouseClicked
        if (jcbLocacao.isSelected()) {
            jtValorLocacaoMes.setEditable(true);
            jtValorLocacaoMes.setEnabled(true);

        } else {
            jtValorLocacaoMes.setEditable(false);
            jtValorLocacaoMes.setEnabled(false);
            jtValorLocacaoMes.setText("");
        } // TODO add your handling code here:
    }//GEN-LAST:event_jcbLocacaoMouseClicked

    private void jbConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMouseClicked
        int control = 0;
        boolean control2 = true;
// Fora das tabs..

        if (jcbLocacao.isSelected()) {

        } else {

        }
        if (jcbVenda.isSelected()) {

        } else {

        }

        if (jcbTemporada.isSelected()) {

        } else {

        }

        if (jcbFesta.isSelected()) {

        } else {

        }

        //Endereço
// Principal
        if (jrbCasa.isSelected()) {
            control++;
        }
        if (jrbSalao.isSelected()) {
            control++;
        }
        if (jrbComercio.isSelected()) {
            control++;
        }
        if (jrbCondominio.isSelected()) {
            control++;
        }

        if (!jtfLogradouro.getText().equals("") && validacao.validaLetras(jtfLogradouro.getText())) {
            System.out.println("x");
            jtfLogradouro.setBackground(Color.white);
            control++;
        } else {

            jtfLogradouro.setBackground(Color.red);

        }
        if (!jtfNumero.getText().equals("") && validacao.validaNumeros(jtfNumero.getText())) {
            System.out.println("x");
            jtfNumero.setBackground(Color.white);
            control++;
        } else {
            jtfNumero.setBackground(Color.red);

        }

        if (!jtfCidade.getText().equals("") && validacao.validaLetras(jtfCidade.getText())) {
            System.out.println("x");
            jtfCidade.setBackground(Color.white);
            control++;
        } else {
            jtfCidade.setBackground(Color.red);

        }
        if (!jtfBairro.getText().equals("") && validacao.validaLetras(jtfBairro.getText())) {
            System.out.println("x");
            jtfBairro.setBackground(Color.white);
            control++;
        } else {
            jtfBairro.setBackground(Color.red);

        }

        if (!jtfUF.getText().equals("") && validacao.validaLetras(jtfUF.getText())) {
            System.out.println("x");
            jtfUF.setBackground(Color.white);
            control++;
        } else {
            jtfUF.setBackground(Color.red);

        }
// Pricipal End

        if (!jtfComplemento.getText().equals("")) {
            System.out.println("x");
        }

        if (!jtfReferencia.getText().equals("")) {
            System.out.println("x");
        }
        if (!jtfCondominio.getText().equals("")) {
            System.out.println("x");

        }

        if (jtfZona.getText().equals("")) {
            jtfZona.setBackground(Color.white);
        } else if (!jtfZona.getText().equals("") && validacao.validaLetras(jtfZona.getText())) {
            System.out.println("x");
            jtfZona.setBackground(Color.white);
        } else {
            control2 = false;
            jtfZona.setBackground(Color.red);

        }
        //Fim Endereço

        //Valores 
        if (jtValorLocacaoMes.getText().equals("")) {
            jtValorLocacaoMes.setBackground(Color.white);
        } else if (!jtValorLocacaoMes.getText().equals("") && validacao.validaNumeros(jtValorLocacaoMes.getText())) {
            System.out.println("x");
            jtValorLocacaoMes.setBackground(Color.white);
        } else {
            control2 = false;
            jtValorLocacaoMes.setBackground(Color.red);

        }
        if (jtValorVenda.getText().equals("")) {
            jtValorVenda.setBackground(Color.white);
        } else if (!jtValorVenda.getText().equals("") && validacao.validaNumeros(jtValorVenda.getText())) {
            System.out.println("x");
            jtValorVenda.setBackground(Color.white);
        } else {
            control2 = false;
            jtValorVenda.setBackground(Color.red);

        }
        if (jtValorTemporada.getText().equals("")) {
            jtValorTemporada.setBackground(Color.white);
        } else if (!jtValorTemporada.getText().equals("") && validacao.validaNumeros(jtValorTemporada.getText())) {
            System.out.println("x");
            jtValorTemporada.setBackground(Color.white);
        } else {
            control2 = false;
            jtValorTemporada.setBackground(Color.red);

        }

        if (jtValorIptu.getText().equals("")) {
            jtValorIptu.setBackground(Color.white);
        } else if (!jtValorIptu.getText().equals("") && validacao.validaNumeros(jtValorIptu.getText())) {
            System.out.println("x");
            jtValorIptu.setBackground(Color.white);
        } else {
            control2 = false;
            jtValorIptu.setBackground(Color.red);

        }

        if (jtValorCondominio.getText().equals("")) {
            jtValorCondominio.setBackground(Color.white);
        } else if (!jtValorCondominio.getText().equals("") && validacao.validaNumeros(jtValorCondominio.getText())) {
            System.out.println("x");
            jtValorCondominio.setBackground(Color.white);
        } else {
            control2 = false;
            jtValorCondominio.setBackground(Color.red);

        }

        if (jtValorDiaria.getText().equals("")) {

            jtValorDiaria.setBackground(Color.white);

        } else if (!jtValorDiaria.getText().equals("") && validacao.validaNumeros(jtValorDiaria.getText())) {
            System.out.println("x");
            jtValorDiaria.setBackground(Color.white);
        } else {
            control2 = false;
            jtValorDiaria.setBackground(Color.red);

        }
        //Valores End
        //Outros    
        // Ficou de fora o medidas terreno,tamanho terreno

        if (jrbMobiliada.isSelected()) {

        }

        if (jrbSemiMobiliada.isSelected()) {

        }

        if (jrbSemMobilia.isSelected()) {

        }

        if (jtMatriculo.getText().equals("")) {
            jtMatriculo.setBackground(Color.white);
        } else if (!jtMatriculo.getText().equals("") && validacao.validaNumeros(jtMatriculo.getText())) {
            System.out.println("x");
            jtMatriculo.setBackground(Color.white);
        } else {
            control2 = false;
            jtMatriculo.setBackground(Color.red);

        }
        if (jtContaAgua.getText().equals("")) {
            jtContaAgua.setBackground(Color.white);
        } else if (!jtContaAgua.getText().equals("") && validacao.validaNumeros(jtContaAgua.getText())) {
            System.out.println("x");
            jtContaAgua.setBackground(Color.white);
        } else {
            control2 = false;
            jtContaAgua.setBackground(Color.red);

        }
        if (jtContaLuz.getText().equals("")) {
            jtContaLuz.setBackground(Color.white);
        } else if (!jtContaLuz.getText().equals("") && validacao.validaNumeros(jtContaLuz.getText())) {
            System.out.println("x");
            jtContaLuz.setBackground(Color.white);
        } else {
            control2 = false;
            jtContaLuz.setBackground(Color.red);

        }
        if (jtIptu.getText().equals("")) {
            jtIptu.setBackground(Color.white);
        } else if (!jtIptu.getText().equals("") && validacao.validaNumeros(jtIptu.getText())) {
            System.out.println("x");
            jtIptu.setBackground(Color.white);
        } else {
            control2 = false;
            jtIptu.setBackground(Color.red);

        }

        if (jtContrato.getText().equals("")) {
            jtContrato.setBackground(Color.white);
        } else if (!jtContrato.getText().equals("") && validacao.validaNumeros(jtContrato.getText())) {
            System.out.println("x");
            jtContrato.setBackground(Color.white);
        } else {
            control2 = false;
            jtContrato.setBackground(Color.red);

        }
        if (!jtCartorio.getText().equals("")) {
            System.out.println("x");
        }

        if (jtSituacaoEscritura.getText().equals("")) {
            jtSituacaoEscritura.setBackground(Color.white);
        } else if (!jtSituacaoEscritura.getText().equals("") && validacao.validaLetras(jtSituacaoEscritura.getText())) {
            System.out.println("x");
            jtSituacaoEscritura.setBackground(Color.white);
        } else {
            control2 = false;
            jtSituacaoEscritura.setBackground(Color.red);

        }

        if (jtAreaConstruida.getText().equals("")) {
            jtAreaConstruida.setBackground(Color.white);
        } else if (!jtAreaConstruida.getText().equals("") && validacao.validaNumeros(jtAreaConstruida.getText())) {
            System.out.println("x");
            jtAreaConstruida.setBackground(Color.white);
        } else {
            control2 = false;
            jtAreaConstruida.setBackground(Color.red);

        }
        if (!jtMobilia.getText().equals("")) {
            System.out.println("x");
        }
        if (!jtChaves.getText().equals("")) {
            System.out.println("x");
        }
        if (!jtObservacao.getText().equals("")) {
            System.out.println("x");
        }
        //Outros End
        //Descrição

        if (jtQuartos.getText().equals("")) {

            jtQuartos.setBackground(Color.white);
        } else if (!jtQuartos.getText().equals("") && validacao.validaNumeros(jtQuartos.getText())) {
            System.out.println("x");
            jtQuartos.setBackground(Color.white);
        } else {
            control2 = false;
            jtQuartos.setBackground(Color.red);

        }

        if (jtSuites.getText().equals("")) {
            jtSuites.setBackground(Color.white);
        } else if (!jtSuites.getText().equals("") && validacao.validaNumeros(jtSuites.getText())) {
            System.out.println("x");
            jtSuites.setBackground(Color.white);
        } else {
            control2 = false;
            jtSuites.setBackground(Color.red);

        }

        if (jtSalas.getText().equals("")) {
            jtSalas.setBackground(Color.white);
        } else if (!jtSalas.getText().equals("") && validacao.validaNumeros(jtSalas.getText())) {
            System.out.println("x");
            jtSalas.setBackground(Color.white);
        } else {
            control2 = false;
            jtSalas.setBackground(Color.red);

        }

        if (jtBanheiros.getText().equals("")) {
            jtBanheiros.setBackground(Color.white);
        } else if (!jtBanheiros.getText().equals("") && validacao.validaNumeros(jtBanheiros.getText())) {
            System.out.println("x");
            jtBanheiros.setBackground(Color.white);
        } else {
            control2 = false;
            jtBanheiros.setBackground(Color.red);

        }

        if (jtLavados.getText().equals("")) {
            jtLavados.setBackground(Color.white);
        } else if (!jtLavados.getText().equals("") && validacao.validaNumeros(jtLavados.getText())) {
            System.out.println("x");
            jtLavados.setBackground(Color.white);
        } else {
            control2 = false;
            jtLavados.setBackground(Color.red);

        }

        if (jtAreaServico.getText().equals("")) {
            jtAreaServico.setBackground(Color.white);
        } else if (!jtAreaServico.getText().equals("") && validacao.validaNumeros(jtAreaServico.getText())) {
            System.out.println("x");
            jtAreaServico.setBackground(Color.white);
        } else {
            control2 = false;
            jtAreaServico.setBackground(Color.red);

        }

        if (jtLavanderia.getText().equals("")) {
            jtLavanderia.setBackground(Color.white);
        } else if (!jtLavanderia.getText().equals("") && validacao.validaNumeros(jtLavanderia.getText())) {
            System.out.println("x");
            jtLavanderia.setBackground(Color.white);
        } else {
            control2 = false;
            jtLavanderia.setBackground(Color.red);

        }

        if (jtPisos.getText().equals("")) {
            jtPisos.setBackground(Color.white);
        } else if (!jtPisos.getText().equals("") && validacao.validaNumeros(jtPisos.getText())) {
            System.out.println("x");
            jtPisos.setBackground(Color.white);
        } else {
            control2 = false;
            jtPisos.setBackground(Color.red);

        }

        if (jtIdadeImovel.getText().equals("")) {
            jtIdadeImovel.setBackground(Color.white);
        } else if (!jtIdadeImovel.getText().equals("") && validacao.validaNumeros(jtIdadeImovel.getText())) {
            //  System.out.println("x");
            jtIdadeImovel.setBackground(Color.white);
        } else {
            control2 = false;
            jtIdadeImovel.setBackground(Color.red);

        }

        if (jtPscina.getText().equals("")) {
            jtPscina.setBackground(Color.white);
        } else if (!jtPscina.getText().equals("") && validacao.validaNumeros(jtPscina.getText())) {
            System.out.println("x");
            jtPscina.setBackground(Color.white);
        } else {
            control2 = false;
            jtPscina.setBackground(Color.red);

        }
        if (jtVagasGaragem.getText().equals("")) {
            jtVagasGaragem.setBackground(Color.white);
        } else if (!jtVagasGaragem.getText().equals("") && validacao.validaNumeros(jtVagasGaragem.getText())) {
            System.out.println("x");
            jtVagasGaragem.setBackground(Color.white);
        } else {
            control2 = false;
            jtVagasGaragem.setBackground(Color.red);

        }
        if (jtDepEmpregada.getText().equals("")) {
            jtDepEmpregada.setBackground(Color.white);
        } else if (!jtDepEmpregada.getText().equals("") && validacao.validaNumeros(jtDepEmpregada.getText())) {
            System.out.println("x");
            jtDepEmpregada.setBackground(Color.white);
        } else {
            control2 = false;
            jtDepEmpregada.setBackground(Color.red);

        }

        if (!jtTipoImovel.getText().equals("")) {
            System.out.println("x");
        }
        if (!jtAreaExterna.getText().equals("")) {
            System.out.println("x");
        }
        if (!jtAcabamento.getText().equals("")) {
            System.out.println("x");
        }
        if (!jtOutros.getText().equals("")) {
            System.out.println("x");
        }

        //Descrição End
        if ((control == 6) && control2 == true) {

            System.out.println("Cadastro Efetuado");
//        conexao banco;    

            new cadastroImovelHome().setVisible(true);
            dispose();
        } else {
            bgMobilia.clearSelection();
            bgTipo.clearSelection();
            control = 0;
            control2 = true;
            System.out.println("Erro Verifique os campos");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jbConfirmarMouseClicked

    public void zerarCampos() {

        bgTipo.clearSelection();
        bgMobilia.clearSelection();

        jcbLocacao.setSelected(false);

        jcbTemporada.setSelected(false);

        jcbVenda.setSelected(false);

        jcbFesta.setSelected(false);

        jtCodigo.setText("");
        jtfStatus.setText("");

        //Endereço
        jtfLogradouro.setText("");
        jtfNumero.setText("");
        jtfComplemento.setText("");
        jtfCidade.setText("");
        jtfBairro.setText("");
        jtfUF.setText("");
        jtfReferencia.setText("");
        jtfZona.setText("");
        jtfCondominio.setText("");

        //valores
        jtValorLocacaoMes.setText("");
        jtValorVenda.setText("");
        jtValorTemporada.setText("");
        jtValorIptu.setText("");
        jtValorCondominio.setText("");
        jtValorDiaria.setText("");

        //Outros 
        jtMatriculo.setText("");
        jtContaAgua.setText("");
        jtContaLuz.setText("");
        jtIptu.setText("");
        jtContrato.setText("");
        jtCartorio.setText("");
        jtSituacaoEscritura.setText("");
        //Precisa adicionar as medidas do terreno
        jtAreaConstruida.setText("");
        //não esquecer
        jtMobilia.setText("");
        jtChaves.setText("");
        jtObservacao.setText("");

        //Descrição  
        jtQuartos.setText("");
        jtSuites.setText("");
        jtSalas.setText("");
        jtBanheiros.setText("");
        jtLavados.setText("");
        jtAreaServico.setText("");
        jtLavanderia.setText("");
        jtPisos.setText("");
        jtIdadeImovel.setText("");
        jtPscina.setText("");
        jtVagasGaragem.setText("");
        jtDepEmpregada.setText("");
        jtTipoImovel.setText("");
        jtAreaExterna.setText("");
        jtAcabamento.setText("");
        jtOutros.setText("");
    }


    private void jtContaLuzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtContaLuzActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtContaLuzActionPerformed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        zerarCampos();
        jtValorLocacaoMes.setEnabled(false);
        jtValorVenda.setEnabled(false);
        jtValorTemporada.setEnabled(false);
        jtValorDiaria.setEnabled(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MousePressed

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
            java.util.logging.Logger.getLogger(cadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroImovel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgMobilia;
    private javax.swing.ButtonGroup bgTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JCheckBox jcbFesta;
    private javax.swing.JCheckBox jcbLocacao;
    private javax.swing.JCheckBox jcbTemporada;
    private javax.swing.JCheckBox jcbVenda;
    private javax.swing.JInternalFrame jifDescricao;
    private javax.swing.JInternalFrame jifEndereco;
    private javax.swing.JInternalFrame jifOutros;
    private javax.swing.JInternalFrame jifValores;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlComplemento;
    private javax.swing.JLabel jlCondominio;
    private javax.swing.JLabel jlLogradouro;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlReferencia;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JLabel jlUF;
    private javax.swing.JLabel jlZona;
    private javax.swing.JMenuBar jmenuCadastro;
    private javax.swing.JRadioButton jrbApartamento;
    private javax.swing.JRadioButton jrbCasa;
    private javax.swing.JRadioButton jrbComercio;
    private javax.swing.JRadioButton jrbCondominio;
    private javax.swing.JRadioButton jrbMobiliada;
    private javax.swing.JRadioButton jrbSalao;
    private javax.swing.JRadioButton jrbSemMobilia;
    private javax.swing.JRadioButton jrbSemiMobiliada;
    private javax.swing.JTextArea jtAcabamento;
    private javax.swing.JTextField jtAreaConstruida;
    private javax.swing.JTextArea jtAreaExterna;
    private javax.swing.JTextField jtAreaServico;
    private javax.swing.JTextField jtBanheiros;
    private javax.swing.JTextField jtCartorio;
    private javax.swing.JTextArea jtChaves;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTextField jtContaAgua;
    private javax.swing.JTextField jtContaLuz;
    private javax.swing.JTextField jtContrato;
    private javax.swing.JTextField jtDepEmpregada;
    private javax.swing.JTextField jtIdadeImovel;
    private javax.swing.JTextField jtIptu;
    private javax.swing.JTextField jtLavados;
    private javax.swing.JTextField jtLavanderia;
    private javax.swing.JTextField jtMatriculo;
    private javax.swing.JTextField jtMedidasTerreno;
    private javax.swing.JTextArea jtMobilia;
    private javax.swing.JTextArea jtObservacao;
    private javax.swing.JTextArea jtOutros;
    private javax.swing.JTextField jtPisos;
    private javax.swing.JTextField jtPscina;
    private javax.swing.JTextField jtQuartos;
    private javax.swing.JTextField jtSalas;
    private javax.swing.JTextField jtSituacaoEscritura;
    private javax.swing.JTextField jtSuites;
    private javax.swing.JTextField jtTamanhoTerreno;
    private javax.swing.JTextArea jtTipoImovel;
    private javax.swing.JTextField jtVagasGaragem;
    private javax.swing.JTextField jtValorCondominio;
    private javax.swing.JTextField jtValorDiaria;
    private javax.swing.JTextField jtValorIptu;
    private javax.swing.JTextField jtValorLocacaoMes;
    private javax.swing.JTextField jtValorTemporada;
    private javax.swing.JTextField jtValorVenda;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfCondominio;
    private javax.swing.JTextField jtfLogradouro;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfReferencia;
    private javax.swing.JTextField jtfStatus;
    private javax.swing.JTextField jtfUF;
    private javax.swing.JTextField jtfZona;
    private javax.swing.JTabbedPane jtpCadastro;
    // End of variables declaration//GEN-END:variables
}
