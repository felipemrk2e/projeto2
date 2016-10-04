/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.TelaPrincipal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sala
 */
public class TelaLogin extends javax.swing.JDialog {
    
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    
    public TelaLogin(){
        
    }

    public void limpaCampos(){
        jtfUsuario.setText("");
        jpfSenha.setText("");    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlImagem = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jlSenha = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        jbAcessar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jlTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlImagem.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jlImagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sala\\Desktop\\Nova pasta\\corretagem_imob3.png")); // NOI18N
        getContentPane().add(jlImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, 350));

        jlUsuario.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jlUsuario.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sala\\Desktop\\Nova pasta\\usuario.png")); // NOI18N
        jlUsuario.setText("Usuário:");
        getContentPane().add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jlSenha.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jlSenha.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sala\\Desktop\\Nova pasta\\password3.png")); // NOI18N
        jlSenha.setText("  Senha:");
        getContentPane().add(jlSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));
        getContentPane().add(jtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 190, -1));
        getContentPane().add(jpfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 190, -1));

        jbAcessar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbAcessar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sala\\Desktop\\Nova pasta\\Ok.png")); // NOI18N
        jbAcessar.setText("Acessar");
        jbAcessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbAcessarMousePressed(evt);
            }
        });
        getContentPane().add(jbAcessar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sala\\Desktop\\Nova pasta\\Cancel.png")); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCancelarMousePressed(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

        jlTitulo.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jlTitulo.setText("Sistema de Cadastro de Imóveis");
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMousePressed
        System.exit(0);
    }//GEN-LAST:event_jbCancelarMousePressed

    private void jbAcessarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAcessarMousePressed
        verificaLogin();
        this.dispose();
    }//GEN-LAST:event_jbAcessarMousePressed

    public boolean verificaLogin() {
        if (jtfUsuario.getText().equals("teste") && jpfSenha.getText().equals("teste")) {             
            return true;
        } 
        return false;
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaLogin telaLogin = new TelaLogin(new javax.swing.JFrame(), true);
                telaLogin.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                telaLogin.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAcessar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlImagem;
    private javax.swing.JLabel jlSenha;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}