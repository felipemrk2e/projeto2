/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadFuncionario;

import Interface.TelaPrincipal.Sessao;
import dao.FuncionarioDAO;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.pessoa.Funcionario;
import model.pessoa.Login;

/**
 *
 * @author user
 */
public class ControleFuncionario extends javax.swing.JFrame {

    private static ControleFuncionario instancia;

    public static Funcionario funcionario = null;

    /**
     * Creates new form ControleFuncionario
     */
    public ControleFuncionario() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        this.setTitle("Controle de Funcionários");
        mascaraCPF();
        carregaNiveis();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
    }

    public static ControleFuncionario getInstancia() {
        if (instancia == null) {
            instancia = new ControleFuncionario();
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
                jbEditar.setEnabled(true);
                break;
            case 2:
                DisableEnable(true);
                break;
            case 3:
                DisableEnable(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void DisableEnable(boolean b) {
        jcbNivelAcesso.setEnabled(b);
        jtUser.setEnabled(b);
        jpfNovaSenha1.setEnabled(b);
        jpfNovaSenha2.setEnabled(b);
    }

    public void cadastrarSenha(Funcionario funcionario) {

        Login login = new Login();
        login.setNivelAcesso(jcbNivelAcesso.getSelectedIndex() + 1);
        login.setNomeUsuario(jtUser.getText());

        char[] chars = jpfNovaSenha1.getPassword();        
        String password = String.valueOf(chars);
        login.setSenhaUsuario(password);
        funcionario.setLogin(login);

        FuncionarioDAO.getInstancia().merge(funcionario);
    }

    public void atualizarSenha(Funcionario funcionario) {
        jtfCodigoInterno.setText("" + funcionario.getIdPessoa());
        jtfNome.setText(funcionario.getNomePessoa());
        jftCPF.setText(funcionario.getCPF());
        jtfRG.setText(funcionario.getRG());
        jtCargo.setText(funcionario.getCargo().getNomeCargo());
        jtDepartamento.setText(funcionario.getCargo().getDepartamento().getNomeDepartamento());
        jcbNivelAcesso.setSelectedIndex(funcionario.getLogin().getNivelAcesso() - 1);
        jtUser.setText(funcionario.getLogin().getNomeUsuario());
    }

    public boolean validaCampos(boolean valida) {
        if (!jtUser.getText().isEmpty()) {
            jtUser.setBackground(Color.white);
        } else {
            jtUser.setBackground(Color.red);
            valida = false;
        }
        if (!jpfNovaSenha1.getText().isEmpty()) {
            jpfNovaSenha1.setBackground(Color.white);
        } else {
            jpfNovaSenha1.setBackground(Color.red);
            valida = false;
        }
        if (!jpfNovaSenha2.getText().isEmpty()) {
            jpfNovaSenha2.setBackground(Color.white);
        } else {
            jpfNovaSenha2.setBackground(Color.red);
            valida = false;
        }
        if (jcbNivelAcesso.getSelectedItem() != null) {
            jcbNivelAcesso.setBackground(Color.white);
        } else {
            jcbNivelAcesso.setBackground(Color.red);
            valida = false;
        }

        if (!Arrays.equals(jpfNovaSenha2.getPassword(), jpfNovaSenha1.getPassword())) {
            valida = false;
            JOptionPane.showMessageDialog(this, "Senhas não coincidem!");
            jpfNovaSenha1.setText("");
            jpfNovaSenha2.setText("");
        }

        return valida;
    }

    public void ZerarCampos() {
        jtfCodigoInterno.setText("");
        jtfNome.setText("");
        jftCPF.setText("");
        jtfRG.setText("");
        jtCargo.setText("");
        jtDepartamento.setText("");
        jcbNivelAcesso.setSelectedIndex(-1);
        jtUser.setText("");
        jpfNovaSenha1.setText("");
        jpfNovaSenha2.setText("");
    }

    public void mascaraCPF() {
        try {
            jftCPF.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("###.###.###-##")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void carregaNiveis() {
        List niveis = new ArrayList();
        niveis.add("1");
        niveis.add("2");
        niveis.add("3");
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(niveis.toArray());
        jcbNivelAcesso.setModel(defaultComboBox);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlCodigoInterno = new javax.swing.JLabel();
        jtfCodigoInterno = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jlCPF = new javax.swing.JLabel();
        jftCPF = new javax.swing.JFormattedTextField();
        jlRG = new javax.swing.JLabel();
        jtfRG = new javax.swing.JTextField();
        jlNovaSenha = new javax.swing.JLabel();
        jlRepetirNovaSenha = new javax.swing.JLabel();
        jlNivelAcesso = new javax.swing.JLabel();
        jtNivelAcesso = new javax.swing.JTextField();
        jtUser = new javax.swing.JTextField();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jtCargo = new javax.swing.JTextField();
        jtDepartamento = new javax.swing.JTextField();
        jlCargo = new javax.swing.JLabel();
        jlDepartamento = new javax.swing.JLabel();
        jbEditar = new javax.swing.JButton();
        jpfNovaSenha1 = new javax.swing.JPasswordField();
        jpfNovaSenha2 = new javax.swing.JPasswordField();
        jlNomeUsuario = new javax.swing.JLabel();
        jcbNivelAcesso = new javax.swing.JComboBox<String>();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(null);

        jlCodigoInterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoInterno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCodigoInterno.setText("Código Interno:");
        getContentPane().add(jlCodigoInterno);
        jlCodigoInterno.setBounds(20, 20, 101, 30);

        jtfCodigoInterno.setEnabled(false);
        getContentPane().add(jtfCodigoInterno);
        jtfCodigoInterno.setBounds(130, 20, 70, 30);

        jlNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNome.setText("Nome:");
        getContentPane().add(jlNome);
        jlNome.setBounds(310, 40, 50, 30);

        jtfNome.setEnabled(false);
        getContentPane().add(jtfNome);
        jtfNome.setBounds(370, 40, 580, 30);

        jlCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCPF.setText("CPF:");
        getContentPane().add(jlCPF);
        jlCPF.setBounds(310, 80, 50, 30);

        jftCPF.setEnabled(false);
        getContentPane().add(jftCPF);
        jftCPF.setBounds(370, 80, 150, 30);

        jlRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRG.setText("RG:");
        getContentPane().add(jlRG);
        jlRG.setBounds(530, 80, 30, 30);

        jtfRG.setEnabled(false);
        getContentPane().add(jtfRG);
        jtfRG.setBounds(570, 80, 150, 30);

        jlNovaSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNovaSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNovaSenha.setText("Nova Senha:");
        getContentPane().add(jlNovaSenha);
        jlNovaSenha.setBounds(270, 240, 90, 30);

        jlRepetirNovaSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRepetirNovaSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlRepetirNovaSenha.setText("Repetir Nova Senha:");
        getContentPane().add(jlRepetirNovaSenha);
        jlRepetirNovaSenha.setBounds(220, 280, 140, 30);

        jlNivelAcesso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNivelAcesso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNivelAcesso.setText("Nivel de Acesso:");
        getContentPane().add(jlNivelAcesso);
        jlNivelAcesso.setBounds(250, 160, 110, 30);
        getContentPane().add(jtNivelAcesso);
        jtNivelAcesso.setBounds(440, 160, 60, 30);
        getContentPane().add(jtUser);
        jtUser.setBounds(370, 200, 580, 30);

        jbConfirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbConfirmar.setText("Confirmar");
        jbConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbConfirmarMousePressed(evt);
            }
        });
        getContentPane().add(jbConfirmar);
        jbConfirmar.setBounds(810, 320, 140, 70);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCancelarMousePressed(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(510, 320, 140, 70);

        jtCargo.setEditable(false);
        getContentPane().add(jtCargo);
        jtCargo.setBounds(790, 80, 160, 30);

        jtDepartamento.setEditable(false);
        getContentPane().add(jtDepartamento);
        jtDepartamento.setBounds(370, 120, 150, 30);

        jlCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargo.setText("Cargo:");
        getContentPane().add(jlCargo);
        jlCargo.setBounds(730, 80, 50, 30);

        jlDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlDepartamento.setText("Departamento:");
        getContentPane().add(jlDepartamento);
        jlDepartamento.setBounds(260, 120, 100, 30);

        jbEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar2.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbEditarMousePressed(evt);
            }
        });
        getContentPane().add(jbEditar);
        jbEditar.setBounds(660, 320, 140, 70);

        jpfNovaSenha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfNovaSenha1ActionPerformed(evt);
            }
        });
        getContentPane().add(jpfNovaSenha1);
        jpfNovaSenha1.setBounds(370, 240, 580, 30);
        getContentPane().add(jpfNovaSenha2);
        jpfNovaSenha2.setBounds(370, 280, 580, 30);

        jlNomeUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNomeUsuario.setText("Nome de Usuario:");
        getContentPane().add(jlNomeUsuario);
        jlNomeUsuario.setBounds(240, 200, 120, 30);

        jcbNivelAcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbNivelAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNivelAcessoActionPerformed(evt);
            }
        });
        getContentPane().add(jcbNivelAcesso);
        jcbNivelAcesso.setBounds(370, 160, 64, 30);

        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle de Funcionário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(210, 10, 760, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbNivelAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNivelAcessoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNivelAcessoActionPerformed

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

    private void jpfNovaSenha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfNovaSenha1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfNovaSenha1ActionPerformed

    private void jbConfirmarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMousePressed
        if (jbConfirmar.isEnabled()) {
            if (validaCampos(true)) {
                try {
                    cadastrarSenha(funcionario);
                    JOptionPane.showMessageDialog(this, "Atualização efetuada com sucesso!");
                    ZerarCampos();
                    funcionario = null;
                    encerrarInstancia();
                    dispose();

                } catch (Exception ex) {
                    Logger.getLogger(ControleFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Verifique os campos obrigatórios!");
            }

        }
    }//GEN-LAST:event_jbConfirmarMousePressed

    private void jbEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMousePressed
        if (jbEditar.isEnabled()) {
            ControleFuncionario.getInstancia().DisableEnable(true);
            JOptionPane.showMessageDialog(this, "Campos abertos para edição!");
        }
    }//GEN-LAST:event_jbEditarMousePressed

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
            java.util.logging.Logger.getLogger(ControleFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JComboBox<String> jcbNivelAcesso;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlCodigoInterno;
    private javax.swing.JLabel jlDepartamento;
    private javax.swing.JLabel jlNivelAcesso;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNomeUsuario;
    private javax.swing.JLabel jlNovaSenha;
    private javax.swing.JLabel jlRG;
    private javax.swing.JLabel jlRepetirNovaSenha;
    private javax.swing.JPasswordField jpfNovaSenha1;
    private javax.swing.JPasswordField jpfNovaSenha2;
    private javax.swing.JTextField jtCargo;
    private javax.swing.JTextField jtDepartamento;
    private javax.swing.JTextField jtNivelAcesso;
    private javax.swing.JTextField jtUser;
    private javax.swing.JTextField jtfCodigoInterno;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfRG;
    // End of variables declaration//GEN-END:variables
}
