/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadImovel;

import Interface.TelaPrincipal.Sessao;
import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.ImovelDAO;
import global.model.Cidade;
import global.model.Estado;
import imovel.model.Imovel;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import validacao.validacao;
import model.TableModel.ImovelTableModel;
import model.TableModel.ImovelTableModel2;

/**
 *
 * @author user
 */
public class cadastroImovelHome extends javax.swing.JFrame {

    private static cadastroImovelHome instancia;
    int user;
    List<Estado> estadoGlobal;
    List<Cidade> cidadeGlobal;
    List<Imovel> imovelGlobal;
    ImovelDAO dao = new ImovelDAO();
    List<Imovel> imovel = new ArrayList<>();

    /**
     * Creates new form cadastroImovelHome
     */
    public cadastroImovelHome() {
        //this.setUndecorated(true);

        initComponents();
        //setAlwaysOnTop(true);
        fechar();
        popularTable();
        ComboBox();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
    }

    public cadastroImovelHome(int user) {
        this.setUndecorated(true);
        this.user = user;

        initComponents();
        setAlwaysOnTop(true);
        fechar();
        if (user <= 2) {
            jbRemover.setEnabled(true);
            jbCadastrar.setEnabled(true);
        } else {
            jbRemover.setEnabled(false);
            jbCadastrar.setEnabled(false);
        }
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());

    }

    public void acesso(int nivel) {
        DisableEnable(false);
        switch (nivel) {
            case 1:
                DisableEnable(true);
                break;
            case 2:
                DisableEnable(true);
                jbRemover.setEnabled(false);
                break;
            case 3:
                DisableEnable(true);
                jbRemover.setEnabled(false);
                jbVisualisar.setEnabled(false);
                jbCadastrar.setEnabled(false);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void DisableEnable(boolean b) {
        jbRemover.setEnabled(b);
        jbVisualisar.setEnabled(b);
        jbCadastrar.setEnabled(b);
        jbPesquisar.setEnabled(b);
        jtNomeProprietario.setEnabled(b);
        jtBairro.setEnabled(b);
        jtRua.setEnabled(b);
        jtQtdQuarto.setEnabled(b);
        jtVagasGaragem.setEnabled(b);
        jcbEstado.setEnabled(b);
        jtImovel.setEnabled(b);
        jcbCasa.setEnabled(b);
        jcbApartamento.setEnabled(b);
        jcbSalao.setEnabled(b);
        jcbTemporario.setEnabled(b);
        jcbComercio.setEnabled(b);
        jcbCidade.setEnabled(b);
    }

    public void ComboBox() {
        EstadoDAO estadoDao = new EstadoDAO();
        List<Estado> estadoTemp = new ArrayList<>();
        List<String> listaSigla = new ArrayList<String>();
        estadoTemp = estadoDao.getAll();
        for (int i = 0; i < estadoTemp.size(); i++) {
            listaSigla.add(estadoTemp.get(i).getSigla());
        }
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaSigla.toArray());
        jcbEstado.setModel(defaultComboBox);

        CidadeDAO cidadeDao = new CidadeDAO();

        List<Cidade> cidadeTemp = new ArrayList<>();
        cidadeTemp = cidadeDao.getWhereIdEstado((long) (jcbEstado.getSelectedIndex() + 1));

        List<String> listaCidade = new ArrayList<String>();
        for (int i = 0; i < cidadeTemp.size(); i++) {
            listaCidade.add(cidadeTemp.get(i).getNomeCidade());
        }
        DefaultComboBoxModel defaultComboBox3 = new DefaultComboBoxModel(listaCidade.toArray());
        jcbCidade.setModel(defaultComboBox3);

        estadoGlobal = estadoTemp;
        cidadeGlobal = cidadeTemp;
    }

    public static cadastroImovelHome getInstancia() {
        if (instancia == null) {
            instancia = new cadastroImovelHome();
        }
        return instancia;
    }

    public void popularTable() {

        //ImovelDAO dao = new ImovelDAO();
        imovel = dao.getAll();
        imovelGlobal = imovel;
        //  ImovelTableModel test = new ImovelTableModel(imovel);
        jtImovel.setModel(new ImovelTableModel2(imovel));

    }

    public static void encerrarInstancia() {
        instancia = null;
    }

    public void fechar() {
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {

                String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

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

        jbCadastrar = new javax.swing.JButton();
        jbVisualisar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtImovel = new javax.swing.JTable();
        jcbCasa = new javax.swing.JCheckBox();
        jcbApartamento = new javax.swing.JCheckBox();
        jcbSalao = new javax.swing.JCheckBox();
        jcbTemporario = new javax.swing.JCheckBox();
        jcbComercio = new javax.swing.JCheckBox();
        jlFiltro = new javax.swing.JLabel();
        jbPesquisar = new javax.swing.JButton();
        jlNomeProprietario = new javax.swing.JLabel();
        jtNomeProprietario = new javax.swing.JTextField();
        jlBairro = new javax.swing.JLabel();
        jtBairro = new javax.swing.JTextField();
        jlEstado = new javax.swing.JLabel();
        jtRua = new javax.swing.JTextField();
        jtQtdQuarto = new javax.swing.JTextField();
        jtVagasGaragem = new javax.swing.JTextField();
        jlRua = new javax.swing.JLabel();
        jlQuantidadeQuartos = new javax.swing.JLabel();
        jlVagasGaragem = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox();
        jlCidade = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        jcbCidade = new javax.swing.JComboBox();
        jcbAtivo = new javax.swing.JCheckBox();
        jcbInativo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        jbCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.setEnabled(false);
        jbCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCadastrarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCadastrar);
        jbCadastrar.setBounds(860, 240, 140, 70);

        jbVisualisar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbVisualisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.png"))); // NOI18N
        jbVisualisar.setText("Visualizar");
        jbVisualisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVisualisarMouseClicked(evt);
            }
        });
        getContentPane().add(jbVisualisar);
        jbVisualisar.setBounds(710, 240, 140, 70);

        jbRemover.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove2.png"))); // NOI18N
        jbRemover.setText("<html><center>Desativar / <br/>Ativar</html>");
        jbRemover.setEnabled(false);
        jbRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRemoverMouseClicked(evt);
            }
        });
        getContentPane().add(jbRemover);
        jbRemover.setBounds(560, 240, 140, 70);

        jtImovel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtImovel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 30, 980, 200);

        jcbCasa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbCasa.setText("Casa");
        getContentPane().add(jcbCasa);
        jcbCasa.setBounds(190, 350, 60, 30);

        jcbApartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbApartamento.setText("Apartamento");
        getContentPane().add(jcbApartamento);
        jcbApartamento.setBounds(260, 350, 110, 30);

        jcbSalao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbSalao.setText("Salão");
        getContentPane().add(jcbSalao);
        jcbSalao.setBounds(380, 350, 70, 30);

        jcbTemporario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbTemporario.setText("Temporario");
        getContentPane().add(jcbTemporario);
        jcbTemporario.setBounds(460, 350, 100, 30);

        jcbComercio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbComercio.setText("Comercio");
        getContentPane().add(jcbComercio);
        jcbComercio.setBounds(570, 350, 90, 30);

        jlFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlFiltro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlFiltro.setText("Filtros:");
        jlFiltro.setMinimumSize(new java.awt.Dimension(35, 18));
        getContentPane().add(jlFiltro);
        jlFiltro.setBounds(130, 350, 50, 30);

        jbPesquisar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPesquisarMouseClicked(evt);
            }
        });
        getContentPane().add(jbPesquisar);
        jbPesquisar.setBounds(860, 390, 140, 70);

        jlNomeProprietario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeProprietario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNomeProprietario.setText("Nome do Proprietário:");
        getContentPane().add(jlNomeProprietario);
        jlNomeProprietario.setBounds(20, 390, 160, 30);

        jtNomeProprietario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jtNomeProprietario);
        jtNomeProprietario.setBounds(190, 390, 660, 30);

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlBairro.setText("Bairro:");
        getContentPane().add(jlBairro);
        jlBairro.setBounds(120, 470, 60, 30);

        jtBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jtBairro);
        jtBairro.setBounds(190, 470, 250, 30);

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlEstado.setText("Estado:");
        getContentPane().add(jlEstado);
        jlEstado.setBounds(710, 470, 60, 30);

        jtRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jtRua);
        jtRua.setBounds(190, 430, 660, 30);

        jtQtdQuarto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jtQtdQuarto);
        jtQtdQuarto.setBounds(190, 510, 80, 30);

        jtVagasGaragem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jtVagasGaragem);
        jtVagasGaragem.setBounds(430, 510, 80, 30);

        jlRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlRua.setText("Rua:");
        getContentPane().add(jlRua);
        jlRua.setBounds(120, 430, 60, 30);

        jlQuantidadeQuartos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlQuantidadeQuartos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlQuantidadeQuartos.setText("Quantidade de Quartos:");
        getContentPane().add(jlQuantidadeQuartos);
        jlQuantidadeQuartos.setBounds(20, 510, 160, 30);

        jlVagasGaragem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlVagasGaragem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlVagasGaragem.setText("Vagas de Garagem:");
        getContentPane().add(jlVagasGaragem);
        jlVagasGaragem.setBounds(280, 510, 140, 30);

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(jcbEstado);
        jcbEstado.setBounds(780, 470, 66, 30);

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCidade.setText("Cidade:");
        getContentPane().add(jlCidade);
        jlCidade.setBounds(460, 470, 60, 30);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(860, 470, 140, 70);

        separador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de Imóvel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(separador);
        separador.setBounds(10, 330, 1010, 250);

        jcbCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbCidade);
        jcbCidade.setBounds(520, 470, 190, 30);

        jcbAtivo.setText("Ativo");
        jcbAtivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbAtivoMouseClicked(evt);
            }
        });
        getContentPane().add(jcbAtivo);
        jcbAtivo.setBounds(680, 350, 51, 23);

        jcbInativo.setText("Inativo");
        jcbInativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbInativoMouseClicked(evt);
            }
        });
        getContentPane().add(jcbInativo);
        jcbInativo.setBounds(780, 350, 59, 23);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarMouseClicked
        if (jbCadastrar.isEnabled()) {
            new cadastroImovel(user).setVisible(true);     // TODO add your handling code here:
            dispose();
        }


    }//GEN-LAST:event_jbCadastrarMouseClicked

    private void jbRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRemoverMouseClicked

        if (jbRemover.isEnabled()) {
            if (jtImovel.getSelectedRow() != -1) {

                imovelGlobal.get(jtImovel.getSelectedRow()).mudaAtivo();
                //    ImovelDAO dao = new ImovelDAO();
                dao.merge(imovelGlobal.get(jtImovel.getSelectedRow()));
                dao = new ImovelDAO();
                popularTable();
                JOptionPane.showMessageDialog(null, "Cadastro desativado com Sucesso !");
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jbRemoverMouseClicked

    private void jbVisualisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVisualisarMouseClicked
        //Falta pegar a id da table;
        if (jtImovel.getSelectedRow() != -1) {

            new cadastroImovel(String.valueOf(imovelGlobal.get(jtImovel.getSelectedRow()).getIdImovel())).setVisible(true);
            dispose();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jbVisualisarMouseClicked

    private void jbPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPesquisarMouseClicked
        // Verificar campos antes de pesquisar 
        boolean control = true;
        boolean controlTipo = false;

        String Rua = "";
        String Bairro = "";
        long idcidade = 0;
        int qtdQuartos = 0;
        int garagem = 0;
        List<Long> ids = new ArrayList<>();
        int ativo;

        if (jcbCasa.isSelected()) {
            ids.add(Long.valueOf("1"));
            controlTipo = true;
            jlFiltro.setForeground(Color.black);
        }

        if (jcbApartamento.isSelected()) {
            ids.add(Long.valueOf("2"));
            controlTipo = true;
            jlFiltro.setForeground(Color.black);
        }

        if (jcbSalao.isSelected()) {
            ids.add(Long.valueOf("3"));
            controlTipo = true;
            jlFiltro.setForeground(Color.black);
        }

        if (jcbComercio.isSelected()) {
            ids.add(Long.valueOf("4"));
            controlTipo = true;
            jlFiltro.setForeground(Color.black);
        }
        if (jcbTemporario.isSelected()) {
            ids.add(Long.valueOf("5"));
            controlTipo = true;
            jlFiltro.setForeground(Color.black);
        }

        if (jtNomeProprietario.getText().equals("")) {
            jtNomeProprietario.setBackground(Color.white);
        } else if (!jtNomeProprietario.getText().equals("") && validacao.validaLetras(jtNomeProprietario.getText())) {

            jtNomeProprietario.setBackground(Color.white);
        } else {
            jtNomeProprietario.setBackground(Color.red);
            control = false;
        }

        if (jtQtdQuarto.getText().equals("")) {
            jtQtdQuarto.setBackground(Color.white);
        } else if (!jtQtdQuarto.getText().equals("") && validacao.validaNumeros(jtQtdQuarto.getText())) {
            qtdQuartos = Integer.parseInt(jtQtdQuarto.getText());
            jtQtdQuarto.setBackground(Color.white);
        } else {
            jtQtdQuarto.setBackground(Color.red);
            control = false;
        }

        if (jtVagasGaragem.getText().equals("")) {
            jtVagasGaragem.setBackground(Color.white);
        } else if (!jtVagasGaragem.getText().equals("") && validacao.validaNumeros(jtVagasGaragem.getText())) {
            garagem = Integer.parseInt(jtVagasGaragem.getText());
            jtVagasGaragem.setBackground(Color.white);
        } else {
            jtVagasGaragem.setBackground(Color.red);
            control = false;
        }

        if (jtRua.getText().equals("")) {
            jtRua.setBackground(Color.white);
        } else if (!jtRua.getText().equals("") && validacao.validaLetras(jtRua.getText())) {
            Rua = jtRua.getText();
            jtRua.setBackground(Color.white);
        } else {
            jtRua.setBackground(Color.red);
            control = false;
        }
        if (jtBairro.getText().equals("")) {
            jtBairro.setBackground(Color.white);
        } else if (!jtBairro.getText().equals("") && validacao.validaLetras(jtBairro.getText())) {
            Bairro = jtBairro.getText();
            jtBairro.setBackground(Color.white);
        } else {
            jtBairro.setBackground(Color.red);
            control = false;
        }

        if (jcbAtivo.isSelected()) {
            ativo = 1;
        } else if (jcbInativo.isSelected()) {
            ativo = 0;
        } else {
            ativo = 3;
        }

        if (control & controlTipo) {
            //   ImovelDAO dao = new ImovelDAO();
            imovel = dao.searchImovel(ids, Rua, Bairro, idcidade, qtdQuartos, garagem, ativo);
            imovelGlobal = imovel;
            jtImovel.setModel(new ImovelTableModel2(imovel));
        } else {
            if (!controlTipo) {
                jlFiltro.setForeground(Color.red);
            }
            control = true;
            JOptionPane.showMessageDialog(null, "Verifique os campos !");
        }

        // fim verificação   // TODO add your handling code here:
    }//GEN-LAST:event_jbPesquisarMouseClicked

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        CidadeDAO cidadeDao = new CidadeDAO();

        List<Cidade> cidadeTemp = new ArrayList<>();
        cidadeTemp = cidadeDao.getWhereIdEstado((long) (jcbEstado.getSelectedIndex() + 1));

        List<String> listaCidade = new ArrayList<String>();
        for (int i = 0; i < cidadeTemp.size(); i++) {
            listaCidade.add(cidadeTemp.get(i).getNomeCidade());
        }
        DefaultComboBoxModel defaultComboBox3 = new DefaultComboBoxModel(listaCidade.toArray());
        jcbCidade.setModel(defaultComboBox3);

        cidadeGlobal = cidadeTemp; // TODO add your handling code here:
    }//GEN-LAST:event_jcbEstadoActionPerformed

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        popularTable();
        JOptionPane.showMessageDialog(null, "Buscas Canceladas!");
        jcbAtivo.setSelected(false);
        jcbInativo.setSelected(false);
        jcbCasa.setSelected(false);
        jcbTemporario.setSelected(false);
        jcbSalao.setSelected(false);
        jcbApartamento.setSelected(false);
        jcbComercio.setSelected(false);
        jtNomeProprietario.setText("");
        jtRua.setText("");
        jtBairro.setText("");
        jtQtdQuarto.setText("");
        jtVagasGaragem.setText("");
        ;// TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jcbAtivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbAtivoMouseClicked
        if (jcbInativo.isSelected()) {
            jcbInativo.setSelected(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAtivoMouseClicked

    private void jcbInativoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbInativoMouseClicked
        if (jcbAtivo.isSelected()) {
            jcbAtivo.setSelected(false);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jcbInativoMouseClicked

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
            java.util.logging.Logger.getLogger(cadastroImovelHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroImovelHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroImovelHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroImovelHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroImovelHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbRemover;
    private javax.swing.JButton jbVisualisar;
    private javax.swing.JCheckBox jcbApartamento;
    private javax.swing.JCheckBox jcbAtivo;
    private javax.swing.JCheckBox jcbCasa;
    private javax.swing.JComboBox jcbCidade;
    private javax.swing.JCheckBox jcbComercio;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JCheckBox jcbInativo;
    private javax.swing.JCheckBox jcbSalao;
    private javax.swing.JCheckBox jcbTemporario;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlFiltro;
    private javax.swing.JLabel jlNomeProprietario;
    private javax.swing.JLabel jlQuantidadeQuartos;
    private javax.swing.JLabel jlRua;
    private javax.swing.JLabel jlVagasGaragem;
    private javax.swing.JTextField jtBairro;
    private javax.swing.JTable jtImovel;
    private javax.swing.JTextField jtNomeProprietario;
    private javax.swing.JTextField jtQtdQuarto;
    private javax.swing.JTextField jtRua;
    private javax.swing.JTextField jtVagasGaragem;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
