/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadCliente;

import Interface.TelaPrincipal.Sessao;
import dao.PessoaDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.TableModel.PessoaFisicaTableModel;
import model.TableModel.PessoaJuridicaTableModel;
import model.TableModel.PessoaTableModel;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import model.pessoa.PessoaJuridica;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import validacao.validacao;

/**
 *
 * @author Sala
 */
public class cadastroClienteHome extends javax.swing.JFrame {

    private static cadastroClienteHome instancia;
    int user;

    /**
     * Creates new form cadastroClienteHome
     */
    public cadastroClienteHome() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        jcbPessoaFisica.setSelected(true);
        jcbPessoaJuridica.setSelected(true);
        popularTabela();
        mascaraTelefone();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
    }

    public static cadastroClienteHome getInstancia() {
        if (instancia == null) {
            instancia = new cadastroClienteHome();
        }
        return instancia;
    }

    public static void encerrarInstancia() {
        instancia = null;
    }

    public void acesso(int nivel) {
        System.out.println("====================================================Nível de Acesso: " + nivel);
        DisableEnable(false);
        switch (nivel) {
            case 1:
                DisableEnable(true);
                jbCadastrar.setEnabled(true);
                jbVisualizar.setEnabled(true);
                jbRemover.setEnabled(true);
                jbPesquisar.setEnabled(true);
                break;
            case 2:
                DisableEnable(true);
                jbCadastrar.setEnabled(true);
                jbVisualizar.setEnabled(true);
                jbRemover.setEnabled(true);
                jbPesquisar.setEnabled(true);
                break;
            case 3:
                DisableEnable(false);
                jbPesquisar.setEnabled(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void DisableEnable(Boolean b) {
        jbCadastrar.setEnabled(b);
        jbVisualizar.setEnabled(b);
        jbRemover.setEnabled(b);
        jbPesquisar.setEnabled(b);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbCadastrar = new javax.swing.JButton();
        jbVisualizar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbPessoaFisica = new javax.swing.JCheckBox();
        jcbPessoaJuridica = new javax.swing.JCheckBox();
        jtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jftTelefone = new javax.swing.JFormattedTextField();
        jlCPF = new javax.swing.JLabel();
        jftCPF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 46, 920, 240));

        jbCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCadastrarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 140, 70));

        jbVisualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.png"))); // NOI18N
        jbVisualizar.setText("Visualizar");
        jbVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVisualizarMouseClicked(evt);
            }
        });
        getContentPane().add(jbVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 140, 70));

        jbRemover.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove2.png"))); // NOI18N
        jbRemover.setText("Remover");
        jbRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRemoverMouseClicked(evt);
            }
        });
        getContentPane().add(jbRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 140, 70));

        jbPesquisar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPesquisarMouseClicked(evt);
            }
        });
        getContentPane().add(jbPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, 140, 70));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Filtros");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 50, -1));

        jcbPessoaFisica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbPessoaFisica.setText("Pessoa Física");
        jcbPessoaFisica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbPessoaFisicaMouseClicked(evt);
            }
        });
        getContentPane().add(jcbPessoaFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 130, 20));

        jcbPessoaJuridica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbPessoaJuridica.setText("Pessoa Júridica");
        jcbPessoaJuridica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbPessoaJuridicaMouseClicked(evt);
            }
        });
        getContentPane().add(jcbPessoaJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 140, -1));

        jtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtNomeKeyReleased(evt);
            }
        });
        getContentPane().add(jtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 270, -1));

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        jLabel3.setText("Telefone");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        jftTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftTelefoneKeyPressed(evt);
            }
        });
        getContentPane().add(jftTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 120, -1));

        jlCPF.setText("CPF");
        getContentPane().add(jlCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, -1, -1));
        getContentPane().add(jftCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 552, 270, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarMouseClicked
        if (jbCadastrar.isEnabled()) {
            cadastroCliente cliente = cadastroCliente.getInstancia();
            cliente.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            cliente.getInstancia().setVisible(true);     // TODO add your handling code here:
            dispose();
        }

    }//GEN-LAST:event_jbCadastrarMouseClicked

    private void jbPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPesquisarMouseClicked
        // Verificação do pesquisar   // falta tudo !
//        if (!jtNome.getText().equals("") && validacao.validaLetras(jtNome.getText())) {
//            jtNome.setBackground(Color.white);
        popularTabelaQuery();
//        } else {
//            jtNome.setBackground(Color.red);
//        }
// arrumar a validacao...

//        if (jtTelefone.getText().equals("")) {
//            jtTelefone.setBackground(Color.white);
//        } else if (!jtTelefone.getText().equals("") && validaAlgo......) {
//            jtTelefone.setBackground(Color.white);
//        } else {
//            jtTelefone.setBackground(Color.red);
//            control = false;
//        }
        if (jcbPessoaFisica.isSelected()) {

        }
        if (jcbPessoaJuridica.isSelected()) {

        }


    }//GEN-LAST:event_jbPesquisarMouseClicked

    public void popularTabela() {
        if (jcbPessoaFisica.isSelected() && jcbPessoaJuridica.isSelected()) {
            jlCPF.setVisible(false);
            jlCPF.setEnabled(false);
            jftCPF.setVisible(false);
            jftCPF.setEnabled(false);

            PessoaDAO pessoaDAO = new PessoaDAO();
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            pessoas = pessoaDAO.getAll();
            jTable1.setModel(new PessoaTableModel(pessoas));
        } else if (jcbPessoaFisica.isSelected()) {
            jlCPF.setVisible(true);
            jlCPF.setEnabled(true);
            jftCPF.setVisible(true);
            jftCPF.setEnabled(true);
            jlCPF.setText("CPF");
            mascaraCPF_CNPJ(true);
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            List<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
            pessoasFisicas = pessoaFisicaDAO.getAll();
            jTable1.setModel(new PessoaFisicaTableModel(pessoasFisicas));
        } else if (jcbPessoaJuridica.isSelected()) {
            jlCPF.setVisible(true);
            jlCPF.setEnabled(true);
            jftCPF.setVisible(true);
            jftCPF.setEnabled(true);
            jlCPF.setText("CNPJ");
            mascaraCPF_CNPJ(false);
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            List<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();
            pessoasJuridicas = pessoaJuridicaDAO.getAll();
            jTable1.setModel(new PessoaJuridicaTableModel(pessoasJuridicas));
        } else {
            jlCPF.setVisible(false);
            jlCPF.setEnabled(false);
            jftCPF.setVisible(false);
            jftCPF.setEnabled(false);
            jTable1.setModel(new PessoaTableModel());
        }

    }

    public void popularTabelaQuery() {
        if (!jtNome.getText().isEmpty()) {
            PessoaDAO pessoaDAO = new PessoaDAO();
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            pessoas = pessoaDAO.getQuery("WHERE nomePessoa LIKE '%" + jtNome.getText() + "%'");
            jTable1.setModel(new PessoaTableModel(pessoas));
        } else if (!jftTelefone.getText().isEmpty() && jftTelefone.getText().trim().length() == 13) {
            PessoaDAO pessoaDAO = new PessoaDAO();
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            pessoas = pessoaDAO.getPorTelefone(jftTelefone.getText());
            jTable1.setModel(new PessoaTableModel(pessoas));
        } else if (jcbPessoaJuridica.isSelected() && jftCPF.getText().trim().length() == 18) {
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            List<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();
            pessoasJuridicas = pessoaJuridicaDAO.getPorCNPJ(jftCPF.getText());
            jTable1.setModel(new PessoaJuridicaTableModel(pessoasJuridicas));

        } else if (jcbPessoaFisica.isSelected() && jftCPF.getText().trim().length() == 14) {
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            List<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
            pessoasFisicas = pessoaFisicaDAO.getPorCPF(jftCPF.getText());
            jTable1.setModel(new PessoaFisicaTableModel(pessoasFisicas));
        }
    }

    public void mascaraTelefone() {
        try {
            jftTelefone.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    private void jbVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVisualizarMouseClicked
        int linhaSelecionada = jTable1.getSelectedRow();
        if (linhaSelecionada == -1) {
            return; //Nada selecionado
        }
        if (jcbPessoaFisica.isSelected() && jcbPessoaJuridica.isSelected()) {
            PessoaTableModel pessoaModel = (PessoaTableModel) jTable1.getModel();
            Pessoa pessoaSelecionada = pessoaModel.get(linhaSelecionada);
            if (pessoaSelecionada.isTipoPessoa()) {
                PessoaFisicaTableModel pessoaFisicaModel = (PessoaFisicaTableModel) jTable1.getModel();
                PessoaFisica pessoaFisicaSelecionada = pessoaFisicaModel.get(linhaSelecionada);
                cadastroCliente cadastroPessoaFisica = new cadastroCliente(pessoaFisicaSelecionada);
                cadastroPessoaFisica.setVisible(true);
                cadastroPessoaFisica.setLocationRelativeTo(this);
            } else {
                PessoaJuridicaTableModel pessoaJuridicaModel = (PessoaJuridicaTableModel) jTable1.getModel();
                PessoaJuridica pessoaJuridicaSelecionada = pessoaJuridicaModel.get(linhaSelecionada);
                cadastroCliente cadastroPessoaJuridica = new cadastroCliente(pessoaJuridicaSelecionada);
                cadastroPessoaJuridica.setVisible(true);
                cadastroPessoaJuridica.setLocationRelativeTo(this);
            }

            System.out.println(pessoaSelecionada.getNomePessoa());

        } else if (jcbPessoaFisica.isSelected()) {
            PessoaFisicaTableModel pessoaFisicaModel = (PessoaFisicaTableModel) jTable1.getModel();
            PessoaFisica pessoaFisicaSelecionada = pessoaFisicaModel.get(linhaSelecionada);
            cadastroCliente cadastroPessoaFisica = new cadastroCliente(pessoaFisicaSelecionada);
            cadastroPessoaFisica.setVisible(true);
            cadastroPessoaFisica.setLocationRelativeTo(this);

        } else if (jcbPessoaJuridica.isSelected()) {
            PessoaJuridicaTableModel pessoaJuridicaModel = (PessoaJuridicaTableModel) jTable1.getModel();
            PessoaJuridica pessoaJuridicaSelecionada = pessoaJuridicaModel.get(linhaSelecionada);
            cadastroCliente cadastroPessoaJuridica = new cadastroCliente(pessoaJuridicaSelecionada);
            cadastroPessoaJuridica.setVisible(true);
            cadastroPessoaJuridica.setLocationRelativeTo(this);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum campo foi selecionado!");
        }


    }//GEN-LAST:event_jbVisualizarMouseClicked

    private void jbRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRemoverMouseClicked
        if (jbRemover.isEnabled()) {
            int linhaSelecionada = jTable1.getSelectedRow();
            if (linhaSelecionada == -1) {
                return; //Nada selecionado
            }
            if (jcbPessoaFisica.isSelected() && jcbPessoaJuridica.isSelected()) {
                PessoaTableModel pessoaModel = (PessoaTableModel) jTable1.getModel();
                Pessoa pessoaSelecionada = pessoaModel.get(linhaSelecionada);
                PessoaDAO pessoaDAO = new PessoaDAO();
                pessoaDAO.removeById(pessoaSelecionada.getIdPessoa());
                pessoaModel.removeRow(linhaSelecionada);

            } else if (jcbPessoaFisica.isSelected()) {
                PessoaFisicaTableModel pessoaFisicaModel = (PessoaFisicaTableModel) jTable1.getModel();
                PessoaFisica pessoaFisicaSelecionada = pessoaFisicaModel.get(linhaSelecionada);
                PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
                pessoaFisicaDAO.removeById(pessoaFisicaSelecionada.getIdPessoa());
                pessoaFisicaModel.removeRow(linhaSelecionada);

            } else if (jcbPessoaJuridica.isSelected()) {
                PessoaJuridicaTableModel pessoaJuridicaModel = (PessoaJuridicaTableModel) jTable1.getModel();
                PessoaJuridica pessoaJuridicaSelecionada = pessoaJuridicaModel.get(linhaSelecionada);
                PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
                pessoaJuridicaDAO.removeById(pessoaJuridicaSelecionada.getIdPessoa());
                pessoaJuridicaModel.removeRow(linhaSelecionada);
                System.out.println(pessoaJuridicaSelecionada.getCnpj());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum campo foi selecionado!");
            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_jbRemoverMouseClicked

    private void jcbPessoaFisicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbPessoaFisicaMouseClicked
        popularTabela();
    }//GEN-LAST:event_jcbPessoaFisicaMouseClicked

    private void jcbPessoaJuridicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbPessoaJuridicaMouseClicked
        popularTabela();
    }//GEN-LAST:event_jcbPessoaJuridicaMouseClicked

    private void jftTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftTelefoneKeyPressed

        jlCPF.setVisible(false);
        jlCPF.setEnabled(false);
        jftCPF.setVisible(false);
        jftCPF.setEnabled(false);
    }//GEN-LAST:event_jftTelefoneKeyPressed

    private void jtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNomeKeyReleased
        if (jtNome.getText().length() == 0) {
            jlCPF.setVisible(true);
            jlCPF.setEnabled(true);
            jftCPF.setVisible(true);
            jftCPF.setEnabled(true);
        } else {
            jlCPF.setVisible(false);
            jlCPF.setEnabled(false);
            jftCPF.setVisible(false);
            jftCPF.setEnabled(false);
        }
    }//GEN-LAST:event_jtNomeKeyReleased

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
            java.util.logging.Logger.getLogger(cadastroClienteHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroClienteHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroClienteHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroClienteHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroClienteHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbRemover;
    private javax.swing.JButton jbVisualizar;
    private javax.swing.JCheckBox jcbPessoaFisica;
    private javax.swing.JCheckBox jcbPessoaJuridica;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JFormattedTextField jftTelefone;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JTextField jtNome;
    // End of variables declaration//GEN-END:variables
}
