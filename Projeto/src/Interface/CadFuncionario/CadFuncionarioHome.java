/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadFuncionario;

import Interface.TelaPrincipal.Sessao;
import Interface.TelaPrincipal.TelaPrincipal;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.PessoaFisicaDAO;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.TableModel.FuncionarioTableModel;
import model.TableModel.PessoaFisicaTableModel;
import model.TableModel.PessoaTableModel;
import model.pessoa.Funcionario;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import validacao.validacao;

/**
 *
 * @author user
 */
public class CadFuncionarioHome extends javax.swing.JFrame {

    private static CadFuncionarioHome instancia;

    /**
     * Creates new form CadFuncionarioHome
     */
    public CadFuncionarioHome() {
        this.setUndecorated(true);
        initComponents();
        this.setTitle("Consulta de Funcionários");
        setAlwaysOnTop(true);
        popularTabela();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
        mascaraCPF();
    }

    public static CadFuncionarioHome getInstancia() {
        if (instancia == null) {
            instancia = new CadFuncionarioHome();
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
                DisableEnable(false);
                break;
            case 3:
                DisableEnable(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void popularTabela() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios = funcionarioDAO.getAtivos();

        if (funcionarios != null) {
            jtFuncionarios.setModel(new FuncionarioTableModel(funcionarios));
        }
    }

    public void popularTabelaQuery() {
        if (!jtNomeFuncionario.getText().isEmpty()) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            List<Funcionario> funcionariosAtivos = funcionarioDAO.getAtivos();
            List<Funcionario> funcionarios = new ArrayList<>();
            for (int i = 0; i < funcionariosAtivos.size(); i++) {
                if (funcionariosAtivos.get(i).getNomePessoa().toUpperCase().indexOf(jtNomeFuncionario.getText().toUpperCase()) >= 0) {
                    funcionarios.add(funcionariosAtivos.get(i));
                }
            }
            if (funcionarios != null) {
                jtFuncionarios.setModel(new FuncionarioTableModel(funcionarios));
            }
        } else if (!jtCargo.getText().isEmpty()) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            List<Funcionario> funcionariosAtivos = funcionarioDAO.getAtivos();
            List<Funcionario> funcionarios = new ArrayList<>();
            for (int i = 0; i < funcionariosAtivos.size(); i++) {
                if (funcionariosAtivos.get(i).getCargo().getNomeCargo().toUpperCase().indexOf(jtCargo.getText().toUpperCase()) >= 0) {
                    funcionarios.add(funcionariosAtivos.get(i));
                }
            }
            if (funcionarios != null) {
                jtFuncionarios.setModel(new FuncionarioTableModel(funcionarios));
            }

        } else if (jftCPF.getText().trim().length() == 14) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            List<Funcionario> funcionariosAtivos = funcionarioDAO.getAtivos();
            List<Funcionario> funcionarios = new ArrayList<>();
            for (int i = 0; i < funcionariosAtivos.size(); i++) {
                if (funcionariosAtivos.get(i).getCPF().equalsIgnoreCase(jftCPF.getText())) {
                    funcionarios.add(funcionariosAtivos.get(i));
                }
            }
            if (funcionarios != null) {
                jtFuncionarios.setModel(new FuncionarioTableModel(funcionarios));
            }
        } else if (jtDepartamento.getText().isEmpty()) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            List<Funcionario> funcionariosAtivos = funcionarioDAO.getAtivos();
            List<Funcionario> funcionarios = new ArrayList<>();
            for (int i = 0; i < funcionariosAtivos.size(); i++) {
                if (funcionariosAtivos.get(i).getCargo().getDepartamento().getNomeDepartamento().toUpperCase().indexOf(jtDepartamento.getText().toUpperCase()) >= 0) {
                    funcionarios.add(funcionariosAtivos.get(i));
                }
            }
            if (funcionarios != null) {
                jtFuncionarios.setModel(new FuncionarioTableModel(funcionarios));
            }
        }
    }

    public void DisableEnable(boolean b) {
        jbRemover.setEnabled(b);
        jbNivel.setEnabled(b);
        jbVisualizar.setEnabled(b);
        jbCadastrar.setEnabled(b);
        jbPesquisar.setEnabled(b);

        jtNomeFuncionario.setEnabled(b);
        jtCargo.setEnabled(b);
        jtDepartamento.setEnabled(b);
    }
    
    public void mascaraCPF() {
        try {      
                jftCPF.setFormatterFactory(new DefaultFormatterFactory(
                        new MaskFormatter("###.###.###-##")));          
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        jtFuncionarios = new javax.swing.JTable();
        jbCadastrar = new javax.swing.JButton();
        jbVisualizar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbNivel = new javax.swing.JButton();
        jbPesquisar = new javax.swing.JButton();
        jlNomeFuncionario = new javax.swing.JLabel();
        jtNomeFuncionario = new javax.swing.JTextField();
        jlCPF = new javax.swing.JLabel();
        jftCPF = new javax.swing.JFormattedTextField();
        jtCargo = new javax.swing.JTextField();
        jtDepartamento = new javax.swing.JTextField();
        jlCargo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(null);

        jtFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtFuncionarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 30, 880, 160);

        jbCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCadastrarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCadastrar);
        jbCadastrar.setBounds(810, 200, 140, 70);

        jbVisualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.png"))); // NOI18N
        jbVisualizar.setText("Visualizar");
        jbVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbVisualizarMousePressed(evt);
            }
        });
        getContentPane().add(jbVisualizar);
        jbVisualizar.setBounds(660, 200, 140, 70);

        jbRemover.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove2.png"))); // NOI18N
        jbRemover.setText("Remover");
        jbRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRemoverMouseClicked(evt);
            }
        });
        getContentPane().add(jbRemover);
        jbRemover.setBounds(360, 200, 140, 70);

        jbNivel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/acesso.png"))); // NOI18N
        jbNivel.setText("<html><center>Nível <br> de <br> Acesso</center></html>");
        jbNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbNivelMouseClicked(evt);
            }
        });
        getContentPane().add(jbNivel);
        jbNivel.setBounds(510, 200, 140, 70);

        jbPesquisar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPesquisarMouseClicked(evt);
            }
        });
        getContentPane().add(jbPesquisar);
        jbPesquisar.setBounds(810, 320, 140, 70);

        jlNomeFuncionario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeFuncionario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNomeFuncionario.setText("Nome do Funcionário:");
        getContentPane().add(jlNomeFuncionario);
        jlNomeFuncionario.setBounds(80, 320, 140, 30);
        getContentPane().add(jtNomeFuncionario);
        jtNomeFuncionario.setBounds(230, 320, 570, 30);

        jlCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCPF.setText("CPF:");
        getContentPane().add(jlCPF);
        jlCPF.setBounds(180, 400, 40, 30);
        getContentPane().add(jftCPF);
        jftCPF.setBounds(230, 400, 570, 30);
        getContentPane().add(jtCargo);
        jtCargo.setBounds(230, 360, 570, 30);
        getContentPane().add(jtDepartamento);
        jtDepartamento.setBounds(230, 440, 570, 30);

        jlCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCargo.setText("Cargo:");
        getContentPane().add(jlCargo);
        jlCargo.setBounds(170, 360, 50, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Departamento:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 440, 100, 30);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("<html><center>Cancelar<br/></html>");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCancelarMousePressed(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(810, 400, 140, 70);

        jSeparator3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de Funcionário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 290, 940, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPesquisarMouseClicked
        if (jbPesquisar.isEnabled()) {
            popularTabelaQuery();
            jftCPF.setText("");
        }
    }//GEN-LAST:event_jbPesquisarMouseClicked

    private void jbRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRemoverMouseClicked
        if (jbRemover.isEnabled()) {
            String ObjButtons[] = {"Sim", "Não"};
            int PromptResult = JOptionPane.showOptionDialog(this, "Tem certeza que deseja remover esse registro?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
            if (PromptResult == JOptionPane.YES_OPTION) {

                int linhaSelecionada = jtFuncionarios.getSelectedRow();
                if (linhaSelecionada == -1) {
                    return; //Nada selecionado
                }
                FuncionarioTableModel funcionarioModel = (FuncionarioTableModel) jtFuncionarios.getModel();
                Funcionario funcionarioSelecionado = funcionarioModel.get(linhaSelecionada);
                funcionarioSelecionado.setAtivo(false);
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                funcionarioDAO.merge(funcionarioSelecionado);
                funcionarioModel.removeRow(linhaSelecionada);
                JOptionPane.showMessageDialog(this, "Remoção efetuada com sucesso!");
            }
        } // TODO add your handling code here:
    }//GEN-LAST:event_jbRemoverMouseClicked

    private void jbNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNivelMouseClicked
        int linhaSelecionada = jtFuncionarios.getSelectedRow();
        if (linhaSelecionada == -1) {
            return; //Nada selecionado
        }
        FuncionarioTableModel funcionarioModel = (FuncionarioTableModel) jtFuncionarios.getModel();
        Funcionario funcionarioSelecionado = funcionarioModel.get(linhaSelecionada);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        cadastroFuncionario.getInstancia().funcionario = funcionarioSelecionado;
        setLocationRelativeTo(this);
        ControleFuncionario.getInstancia().atualizarSenha(funcionarioSelecionado);
        ControleFuncionario.getInstancia().setVisible(true);
        ControleFuncionario.getInstancia().DisableEnable(false);
        ControleFuncionario.getInstancia().setLocationRelativeTo(this);
        ControleFuncionario.getInstancia().setAlwaysOnTop(true);
        ControleFuncionario.getInstancia().jbEditar.setEnabled(true);
    }//GEN-LAST:event_jbNivelMouseClicked

    private void jbCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarMouseClicked
        if (jbCadastrar.isEnabled()) {
            cadastroFuncionario funcionario = cadastroFuncionario.getInstancia();
            funcionario.setLocationRelativeTo(this);
            funcionario.setVisible(true);
        }
    }//GEN-LAST:event_jbCadastrarMouseClicked

    private void jbCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMousePressed
        if (jbCancelar.isEnabled()) {
//            if (instancia == null) {
//                dispose();
//            } else {

            String ObjButtons[] = {"Sim", "Não"};
            int PromptResult = JOptionPane.showOptionDialog(this, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
            if (PromptResult == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }//GEN-LAST:event_jbCancelarMousePressed

    private void jbVisualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVisualizarMousePressed
        int linhaSelecionada = jtFuncionarios.getSelectedRow();
        if (linhaSelecionada == -1) {
            return; //Nada selecionado
        }
        FuncionarioTableModel funcionarioModel = (FuncionarioTableModel) jtFuncionarios.getModel();
        Funcionario funcionarioSelecionado = funcionarioModel.get(linhaSelecionada);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        cadastroFuncionario.getInstancia().funcionario = funcionarioSelecionado;
        setLocationRelativeTo(this);
        cadastroFuncionario.getInstancia().atualizarFuncionario(funcionarioSelecionado);
        cadastroFuncionario.getInstancia().setVisible(true);
        cadastroFuncionario.getInstancia().DisableEnable(false);
        cadastroFuncionario.getInstancia().setLocationRelativeTo(this);
        cadastroFuncionario.getInstancia().setAlwaysOnTop(true);
        cadastroFuncionario.getInstancia().jbEditar.setEnabled(true);
    }//GEN-LAST:event_jbVisualizarMousePressed

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
            java.util.logging.Logger.getLogger(CadFuncionarioHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadFuncionarioHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbNivel;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbRemover;
    private javax.swing.JButton jbVisualizar;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlNomeFuncionario;
    private javax.swing.JTextField jtCargo;
    private javax.swing.JTextField jtDepartamento;
    private javax.swing.JTable jtFuncionarios;
    private javax.swing.JTextField jtNomeFuncionario;
    // End of variables declaration//GEN-END:variables
}
