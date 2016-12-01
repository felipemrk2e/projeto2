/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Relatorio;

import Interface.TelaPrincipal.Sessao;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.ImovelDAO;
import dao.PessoaDAO;
import global.model.Cidade;
import global.model.Estado;
import imovel.model.Imovel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.pessoa.Pessoa;

/**
 *
 * @author jeanbrock
 */
public class RelatorioHome extends javax.swing.JFrame {

    /**
     * Creates new form RelatorioHome
     */
    private static RelatorioHome instancia;

    private List<Cidade> listaCidadesGlobal;
    private int indexCidade;

    public RelatorioHome() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        this.setTitle("Relatórios");
        carregaEstados();
        carregaCidades();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
    }

    public static RelatorioHome getInstancia() {
        if (instancia == null) {
            instancia = new RelatorioHome();
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
                break;
            case 2:
                DisableEnable(true);
                break;
            case 3:
                DisableEnable(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void DisableEnable(boolean b) {
        jrbAtivos.setEnabled(b);
        jrbInteresseCompra.setEnabled(b);
        jrbInteresseLocar.setEnabled(b);
        jrbInteresseTemporada.setEnabled(b);
        jrbrLocados.setEnabled(b);
        jcbEstado.setEnabled(b);
        jcbCidade.setEnabled(b);
        jbImprimirRelatorio.setEnabled(b);
        jbSalvarRelatorio.setEnabled(b);
    }

    public void gerarPDFImoveisAtivos(long idCidade) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String user = System.getProperty("user.name");

        ImovelDAO imovelDAO = new ImovelDAO();
        List<Imovel> imoveisAtivos = imovelDAO.ativosPorCidade(idCidade);

        if (imoveisAtivos.size() > 0) {
            PDF pdf = new PDF();
            pdf.criaPDF();
            pdf.abrePDF();

            pdf.addTituloPDF("Relatório de Imoveis Ativos na Cidade de " + imoveisAtivos.get(0).getEndereco().getCidade().getNomeCidade());
            pdf.addLinhaPDF("");
            pdf.addLinhaPDF("");
            pdf.addImagemPDF("C:\\Users\\" + user + "\\Documents\\NetBeansProjects\\projeto2\\Projeto\\src\\image\\locacao.png");

            pdf.addLinhaPDF("");
            pdf.addLinhaPDF("");
            pdf.addLinhaPDF("Quantidade de Registros: " + imoveisAtivos.size());
            pdf.addLinhaPDF("");
            pdf.addLinhaPDF("\n");
            pdf.addTabela(new String[]{"ID", "Status", "Ano", "Endereço", "Bairro"});
            for (int i = 0; i < imoveisAtivos.size(); i++) {
                pdf.addTabela(new String[]{Long.toString(imoveisAtivos.get(i).getIdImovel()), imoveisAtivos.get(i).getStatus().getStatus(), Integer.toString(imoveisAtivos.get(i).getAnoConstrucao()), imoveisAtivos.get(i).getEndereco().getNomeEndereco(), imoveisAtivos.get(i).getEndereco().getBairro()});
            }
            pdf.fechaPDF();
            System.out.println("=========================================================================================");
            pdf.carregaPDF(null);
        } else {
            JOptionPane.showMessageDialog(this, "Não há itens para essa pesquisa!");
        }

    }

    public void gerarPDFInteresseCompra() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String user = System.getProperty("user.name");

        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas = pessoaDAO.getAll();

        PDF pdf = new PDF();
        pdf.criaPDF();
        pdf.abrePDF();

        pdf.addTituloPDF("Relatório de Clientes Interessados em Comprar Imóveis");
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("");
        pdf.addImagemPDF("C:\\Users\\" + user + "\\Documents\\NetBeansProjects\\projeto2\\Projeto\\src\\image\\locacao.png");

        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("Quantidade de Registros: " + pessoas.size());
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("\n");
        pdf.addTabela(new String[]{"ID", "Nome", "Contato", "Endereço", "Bairro"});
        for (int i = 0; i < pessoas.size(); i++) {
            for (int j = 0; j < pessoas.get(i).getInteresses().size(); j++) {
                if (pessoas.get(i).getInteresses().get(j) != null) {
                    if (pessoas.get(i).getInteresses().get(j).getIdTipoContrato() == 2) {
                        pdf.addTabela(new String[]{Long.toString(pessoas.get(i).getIdPessoa()), pessoas.get(i).getNomePessoa(), retornaTelefone(pessoas.get(i)), pessoas.get(i).getEndereco().getNomeEndereco(), pessoas.get(i).getEndereco().getBairro()});
                        System.out.println(Long.toString(pessoas.get(i).getIdPessoa()) + "" + retornaTelefone(pessoas.get(i)) + "" + pessoas.get(i).getEndereco().getNomeEndereco() + "" + pessoas.get(i).getEndereco().getBairro());
                    }
                }
            }
        }
        pdf.fechaPDF();
        pdf.carregaPDF(null);
    }

    public void gerarPDFInteresseTemporada() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String user = System.getProperty("user.name");

        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas = pessoaDAO.getAll();

        PDF pdf = new PDF();
        pdf.criaPDF();
        pdf.abrePDF();

        pdf.addTituloPDF("Relatório de Clientes Interessados em Imóveis para Temporada");
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("");
        pdf.addImagemPDF("C:\\Users\\" + user + "\\Documents\\NetBeansProjects\\projeto2\\Projeto\\src\\image\\locacao.png");

        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("Quantidade de Registros: " + pessoas.size());
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("\n");
        pdf.addTabela(new String[]{"ID", "Nome", "Contato", "Endereço", "Bairro"});
        for (int i = 0; i < pessoas.size(); i++) {
            for (int j = 0; j < pessoas.get(i).getInteresses().size(); j++) {
                if (pessoas.get(i).getInteresses().get(j) != null) {
                    if (pessoas.get(i).getInteresses().get(j).getIdTipoContrato() == 3) {
                        pdf.addTabela(new String[]{Long.toString(pessoas.get(i).getIdPessoa()), pessoas.get(i).getNomePessoa(), retornaTelefone(pessoas.get(i)), pessoas.get(i).getEndereco().getNomeEndereco(), pessoas.get(i).getEndereco().getBairro()});
                        System.out.println(Long.toString(pessoas.get(i).getIdPessoa()) + "" + retornaTelefone(pessoas.get(i)) + "" + pessoas.get(i).getEndereco().getNomeEndereco() + "" + pessoas.get(i).getEndereco().getBairro());
                    }
                }
            }
        }
        pdf.fechaPDF();
        pdf.carregaPDF(null);

    }

    public void gerarPDFInteresseLocacao() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String user = System.getProperty("user.name");

        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas = pessoaDAO.getAll();

        PDF pdf = new PDF();
        pdf.criaPDF();
        pdf.abrePDF();

        pdf.addTituloPDF("Relatório de Clientes Interessados em Locação de Imóveis");
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("");
        pdf.addImagemPDF("C:\\Users\\" + user + "\\Documents\\NetBeansProjects\\projeto2\\Projeto\\src\\image\\locacao.png");

        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("Quantidade de Registros: " + pessoas.size());
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("\n");
        pdf.addTabela(new String[]{"ID", "Nome", "Contato", "Endereço", "Bairro"});
        for (int i = 0; i < pessoas.size(); i++) {
            for (int j = 0; j < pessoas.get(i).getInteresses().size(); j++) {
                if (pessoas.get(i).getInteresses().get(j) != null) {
                    if (pessoas.get(i).getInteresses().get(j).getIdTipoContrato() == 1) {
                        pdf.addTabela(new String[]{Long.toString(pessoas.get(i).getIdPessoa()), pessoas.get(i).getNomePessoa(), retornaTelefone(pessoas.get(i)), pessoas.get(i).getEndereco().getNomeEndereco(), pessoas.get(i).getEndereco().getBairro()});
                        System.out.println(Long.toString(pessoas.get(i).getIdPessoa()) + "" + retornaTelefone(pessoas.get(i)) + "" + pessoas.get(i).getEndereco().getNomeEndereco() + "" + pessoas.get(i).getEndereco().getBairro());
                    }
                }
            }
        }
        pdf.fechaPDF();
        pdf.carregaPDF(null);
    }

    public void gerarPDFImoveisLocados() {

    }

    public String retornaTelefone(Pessoa pessoa) {
        for (int i = 0; i < pessoa.getTelefone().size(); i++) {
            if (i == 0) {
                return pessoa.getTelefone().get(i).getNumero();
            } else if (i == 1) {
                return pessoa.getTelefone().get(i).getNumero();
            } else if (i == 2) {
                return pessoa.getTelefone().get(i).getNumero();
            }
        }
        return "Sem Telefone";
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgRelatotio = new javax.swing.ButtonGroup();
        jrbAtivos = new javax.swing.JRadioButton();
        jrbInteresseCompra = new javax.swing.JRadioButton();
        jrbInteresseLocar = new javax.swing.JRadioButton();
        jrbInteresseTemporada = new javax.swing.JRadioButton();
        jrbrLocados = new javax.swing.JRadioButton();
        jbSalvarRelatorio = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbImprimirRelatorio = new javax.swing.JButton();
        jlTipoRelatório = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jcbCidade = new javax.swing.JComboBox<>();
        jlEstado = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jsRelatorio = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 640));
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setPreferredSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(null);

        btgRelatotio.add(jrbAtivos);
        jrbAtivos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jrbAtivos.setText("Relatório de Imóveis Ativos por Cidade");
        getContentPane().add(jrbAtivos);
        jrbAtivos.setBounds(50, 100, 310, 30);

        btgRelatotio.add(jrbInteresseCompra);
        jrbInteresseCompra.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jrbInteresseCompra.setText("Relatório de Clientes Interessados em Comprar Imóveis");
        getContentPane().add(jrbInteresseCompra);
        jrbInteresseCompra.setBounds(50, 140, 510, 30);

        btgRelatotio.add(jrbInteresseLocar);
        jrbInteresseLocar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jrbInteresseLocar.setText("Relatório de Clientes Interessados em Locar Imóveis");
        getContentPane().add(jrbInteresseLocar);
        jrbInteresseLocar.setBounds(50, 180, 420, 30);

        btgRelatotio.add(jrbInteresseTemporada);
        jrbInteresseTemporada.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jrbInteresseTemporada.setText("Relatório de Clientes Interessados em Imóveis para Temporada");
        getContentPane().add(jrbInteresseTemporada);
        jrbInteresseTemporada.setBounds(50, 220, 480, 30);

        btgRelatotio.add(jrbrLocados);
        jrbrLocados.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jrbrLocados.setText("Relatório de Imóveis Locados");
        getContentPane().add(jrbrLocados);
        jrbrLocados.setBounds(50, 260, 250, 30);

        jbSalvarRelatorio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbSalvarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pdf.png"))); // NOI18N
        jbSalvarRelatorio.setText("<html><center>Salvar<br/>Relatório</html>");
        jbSalvarRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalvarRelatorioMouseClicked(evt);
            }
        });
        getContentPane().add(jbSalvarRelatorio);
        jbSalvarRelatorio.setBounds(820, 150, 140, 70);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(820, 230, 140, 70);

        jbImprimirRelatorio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbImprimirRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imprimir.png"))); // NOI18N
        jbImprimirRelatorio.setText("<html><center>Imprimir<br/>Relatório</html>");
        jbImprimirRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbImprimirRelatorioMouseClicked(evt);
            }
        });
        getContentPane().add(jbImprimirRelatorio);
        jbImprimirRelatorio.setBounds(820, 70, 140, 70);

        jlTipoRelatório.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlTipoRelatório.setText("Selecionar Tipo de Relatório");
        getContentPane().add(jlTipoRelatório);
        jlTipoRelatório.setBounds(40, 50, 250, 30);

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(jcbEstado);
        jcbEstado.setBounds(370, 100, 160, 30);

        jcbCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbCidade);
        jcbCidade.setBounds(540, 100, 140, 30);

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("Estado");
        getContentPane().add(jlEstado);
        jlEstado.setBounds(390, 70, 44, 30);

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setText("Cidade");
        getContentPane().add(jlCidade);
        jlCidade.setBounds(540, 70, 45, 30);

        jsRelatorio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerar Relatório", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jsRelatorio);
        jsRelatorio.setBounds(20, 20, 980, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbImprimirRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbImprimirRelatorioMouseClicked
        if (jbImprimirRelatorio.isEnabled()) {
            PDF pdf = new PDF();
            if (jrbAtivos.isSelected()) {
                try {
                    Cidade cidadeSelecionada = (Cidade) jcbCidade.getSelectedItem();
                    gerarPDFImoveisAtivos(cidadeSelecionada.getIdCidade());
                    pdf.imprimePDF(null);
                } catch (DocumentException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jrbInteresseCompra.isSelected()) {
                try {
                    gerarPDFInteresseCompra();
                    pdf.imprimePDF(null);
                } catch (DocumentException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jrbrLocados.isSelected()) {
                gerarPDFImoveisLocados();
                pdf.imprimePDF(null);
            } else if (jrbInteresseLocar.isSelected()) {
                try {
                    gerarPDFInteresseLocacao();
                    pdf.imprimePDF(null);
                } catch (DocumentException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jrbInteresseTemporada.isSelected()) {
                try {
                    gerarPDFInteresseTemporada();
                    pdf.imprimePDF(null);
                } catch (DocumentException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione o tipo de Relatório!");
            }
            RelatorioHome.getInstancia().encerrarInstancia();
            dispose();
        }
    }//GEN-LAST:event_jbImprimirRelatorioMouseClicked

    private void jbSalvarRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvarRelatorioMouseClicked
        if (jbSalvarRelatorio.isEnabled()) {
            if (jrbAtivos.isSelected()) {
                try {
                    Cidade cidadeSelecionada = (Cidade) jcbCidade.getSelectedItem();
                    gerarPDFImoveisAtivos(cidadeSelecionada.getIdCidade());
                } catch (DocumentException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jrbInteresseCompra.isSelected()) {
                try {
                    gerarPDFInteresseCompra();
                } catch (DocumentException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jrbrLocados.isSelected()) {
                gerarPDFImoveisLocados();
            } else if (jrbInteresseLocar.isSelected()) {
                try {
                    gerarPDFInteresseLocacao();
                } catch (DocumentException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jrbInteresseTemporada.isSelected()) {
                try {
                    gerarPDFInteresseTemporada();
                } catch (DocumentException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RelatorioHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione o tipo de Relatório!");
            }
            RelatorioHome.getInstancia().encerrarInstancia();
            dispose();
        }
    }//GEN-LAST:event_jbSalvarRelatorioMouseClicked

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(RelatorioHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgRelatotio;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbImprimirRelatorio;
    private javax.swing.JButton jbSalvarRelatorio;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlTipoRelatório;
    private javax.swing.JRadioButton jrbAtivos;
    private javax.swing.JRadioButton jrbInteresseCompra;
    private javax.swing.JRadioButton jrbInteresseLocar;
    private javax.swing.JRadioButton jrbInteresseTemporada;
    private javax.swing.JRadioButton jrbrLocados;
    private javax.swing.JSeparator jsRelatorio;
    // End of variables declaration//GEN-END:variables
}
