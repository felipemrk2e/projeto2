/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadFuncionario;

import Interface.TelaPrincipal.Sessao;
import Interface.TelaPrincipal.TelaPrincipal;
import dao.FuncionarioDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import model.TableModel.FuncionarioTableModel;
import model.pessoa.Funcionario;
import validacao.validacao;

/**
 *
 * @author user
 */
public class CadFuncionarioHome extends javax.swing.JFrame {

    private static CadFuncionarioHome instancia;
    int user = Sessao.getInstance().getUsuario().getNivelAcesso();

    /**
     * Creates new form CadFuncionarioHome
     */
    public CadFuncionarioHome() {
        this.setUndecorated(true);
        initComponents();
        this.setTitle("Cadastro de Funcionários");
        popularTabela();
    }
    
    public static CadFuncionarioHome getInstancia() {
        if (instancia == null) {
            instancia = new CadFuncionarioHome();
        }
        return instancia;
    }
    
    public static void encerrarInstancia(){
        instancia = null;
    }

    public void popularTabela() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios = funcionarioDAO.getAll();
        jTable1.setModel(new FuncionarioTableModel(funcionarios));
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
        jbExcluir = new javax.swing.JButton();
        jbNivel = new javax.swing.JButton();
        jbPesquisar = new javax.swing.JButton();
        jlNomeFuncionario = new javax.swing.JLabel();
        jtNomeFuncionario = new javax.swing.JTextField();
        jlCPF = new javax.swing.JLabel();
        jtCpf = new javax.swing.JTextField();
        jtCargo = new javax.swing.JTextField();
        jtDepartamento = new javax.swing.JTextField();
        jlCargo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 30, 880, 239);

        jbCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCadastrarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCadastrar);
        jbCadastrar.setBounds(810, 290, 140, 70);

        jbVisualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.png"))); // NOI18N
        jbVisualizar.setText("Visualizar");
        jbVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVisualizarMouseClicked(evt);
            }
        });
        getContentPane().add(jbVisualizar);
        jbVisualizar.setBounds(590, 290, 140, 70);

        jbExcluir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove2.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbExcluirMouseClicked(evt);
            }
        });
        getContentPane().add(jbExcluir);
        jbExcluir.setBounds(150, 290, 140, 70);

        jbNivel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/acesso.png"))); // NOI18N
        jbNivel.setText("<html><center>Nível <br> de <br> Acesso</center></html>");
        jbNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbNivelMouseClicked(evt);
            }
        });
        getContentPane().add(jbNivel);
        jbNivel.setBounds(370, 290, 140, 70);

        jbPesquisar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPesquisarMouseClicked(evt);
            }
        });
        getContentPane().add(jbPesquisar);
        jbPesquisar.setBounds(810, 420, 140, 70);

        jlNomeFuncionario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeFuncionario.setText("Nome do Funcionário:");
        getContentPane().add(jlNomeFuncionario);
        jlNomeFuncionario.setBounds(80, 420, 150, 30);
        getContentPane().add(jtNomeFuncionario);
        jtNomeFuncionario.setBounds(230, 420, 280, 30);

        jlCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF.setText("CPF:");
        getContentPane().add(jlCPF);
        jlCPF.setBounds(590, 420, 40, 30);
        getContentPane().add(jtCpf);
        jtCpf.setBounds(630, 420, 160, 30);
        getContentPane().add(jtCargo);
        jtCargo.setBounds(230, 460, 280, 30);
        getContentPane().add(jtDepartamento);
        jtDepartamento.setBounds(630, 460, 160, 30);

        jlCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargo.setText("Cargo:");
        getContentPane().add(jlCargo);
        jlCargo.setBounds(170, 460, 60, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Departamento:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(530, 460, 100, 30);

        jSeparator3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de Funcionário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 390, 940, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPesquisarMouseClicked
        //Verificar Pesquisar //Falta tudo
        boolean control = true;

        if (jtNomeFuncionario.equals("")) {

        } else if (!jtNomeFuncionario.equals("") && validacao.validaLetras(jtNomeFuncionario.getText())) {

        } else {
            jtNomeFuncionario.setBackground(Color.red);
            control = false;
        }

        if (true) {

        } else if (true) {

        } else {
            jtCpf.setBackground(Color.red);
            control = false;
        }

        if (true) {

        } else if (true) {

        } else {
            jtCargo.setBackground(Color.red);
            control = false;
        }
        if (true) {

        } else if (true) {

        } else {
            jtDepartamento.setBackground(Color.red);
            control = false;
        }
// Query

        if (control) {

        } else {

            control = true;

        }

        //Fim Pesquisar Verificar 
        // TODO add your handling code here:
    }//GEN-LAST:event_jbPesquisarMouseClicked

    private void jbExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbExcluirMouseClicked
        if (jbExcluir.isEnabled()) {
        } // TODO add your handling code here:
    }//GEN-LAST:event_jbExcluirMouseClicked

    private void jbNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNivelMouseClicked
//        if (jbNivel.isEnabled()) {
//            String idFuncionario = "vazio no momento";
//            new ControleFuncionario(user, idFuncionario).setVisible(true);
//            dispose();
//
//        }
// TODO add your handling code here:
    }//GEN-LAST:event_jbNivelMouseClicked

    private void jbVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVisualizarMouseClicked
        String idFuncionario = "vazio no momento";
        new cadastroFuncionario(user, idFuncionario).setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jbVisualizarMouseClicked

    private void jbCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarMouseClicked

        if (jbCadastrar.isEnabled()) {
            new cadastroFuncionario(user).setVisible(true);
            dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarMouseClicked

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
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNivel;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbVisualizar;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlNomeFuncionario;
    private javax.swing.JTextField jtCargo;
    private javax.swing.JTextField jtCpf;
    private javax.swing.JTextField jtDepartamento;
    private javax.swing.JTextField jtNomeFuncionario;
    // End of variables declaration//GEN-END:variables
}
