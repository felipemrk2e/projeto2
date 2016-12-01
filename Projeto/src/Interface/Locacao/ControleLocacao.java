/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Locacao;

import Interface.TelaPrincipal.Sessao;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleLocacao extends javax.swing.JFrame {

    private static ControleLocacao instancia;
    int user;

    /**
     * Creates new form ControleLocacao
     */
    public ControleLocacao() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
    }

    public ControleLocacao(int user, String IdLoccao) {
        this.setUndecorated(true);
        this.user = user;
        initComponents();
        setAlwaysOnTop(true);
        popular();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
    }

    public static ControleLocacao getInstancia() {
        if (instancia == null) {
            instancia = new ControleLocacao();
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
                DisableEnable(false);

                break;
            default:
                JOptionPane.showMessageDialog(null, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void DisableEnable(boolean b) {
        jtNomeLocatario.setEnabled(b);
        jtNomeProprietario.setEnabled(b);
        jtValor.setEnabled(b);
        jtInicioContrato.setEnabled(b);
        jtFimContrato.setEnabled(b);
        jtNomeFiador.setEnabled(b);
        jtIdImovel.setEnabled(b);
        jbConfirmar.setEnabled(b);
        jbCancelar.setEnabled(b);
        jbEditar.setEnabled(b);
        jbFinalizarContrato.setEnabled(b);
    }

    public void verificaNivel() {
        if (user <= 2) {

            jbEditar.setEnabled(true);
            jbConfirmar.setEnabled(false);

        } else {
            jbEditar.setEnabled(false);
            jbConfirmar.setEnabled(false);

        }
    }

    public void popular() {

        jtIdImovel.setText("");
        jtNomeProprietario.setText("");
        jtNomeLocatario.setText("");
        jtNomeFiador.setText("");
        jtValor.setText("");
        jtInicioContrato.setText("");
        jtFimContrato.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtNomeLocatario = new javax.swing.JTextField();
        jtNomeProprietario = new javax.swing.JTextField();
        jtValor = new javax.swing.JTextField();
        jtInicioContrato = new javax.swing.JTextField();
        jtFimContrato = new javax.swing.JTextField();
        jtNomeFiador = new javax.swing.JTextField();
        jtIdImovel = new javax.swing.JTextField();
        jlNomeLocatario = new javax.swing.JLabel();
        jlNomeProprietario = new javax.swing.JLabel();
        jlValor = new javax.swing.JLabel();
        jlInicioContrato = new javax.swing.JLabel();
        jlFimContrato = new javax.swing.JLabel();
        jlNomeFiador = new javax.swing.JLabel();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbFinalizarContrato = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setEnabled(false);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(null);

        jtNomeLocatario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtNomeLocatario.setEnabled(false);
        getContentPane().add(jtNomeLocatario);
        jtNomeLocatario.setBounds(210, 90, 510, 30);

        jtNomeProprietario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtNomeProprietario.setEnabled(false);
        jtNomeProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNomeProprietarioActionPerformed(evt);
            }
        });
        getContentPane().add(jtNomeProprietario);
        jtNomeProprietario.setBounds(210, 130, 510, 30);

        jtValor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtValor.setEnabled(false);
        getContentPane().add(jtValor);
        jtValor.setBounds(370, 50, 350, 30);

        jtInicioContrato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtInicioContrato.setEnabled(false);
        jtInicioContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtInicioContratoActionPerformed(evt);
            }
        });
        getContentPane().add(jtInicioContrato);
        jtInicioContrato.setBounds(210, 210, 200, 30);

        jtFimContrato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtFimContrato.setEnabled(false);
        getContentPane().add(jtFimContrato);
        jtFimContrato.setBounds(540, 210, 180, 30);

        jtNomeFiador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtNomeFiador.setEnabled(false);
        getContentPane().add(jtNomeFiador);
        jtNomeFiador.setBounds(210, 170, 510, 30);

        jtIdImovel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtIdImovel.setEnabled(false);
        getContentPane().add(jtIdImovel);
        jtIdImovel.setBounds(210, 50, 100, 30);

        jlNomeLocatario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeLocatario.setText("Nome do Locatário:");
        getContentPane().add(jlNomeLocatario);
        jlNomeLocatario.setBounds(80, 90, 130, 30);

        jlNomeProprietario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeProprietario.setText("Nome do Proprietário:");
        getContentPane().add(jlNomeProprietario);
        jlNomeProprietario.setBounds(60, 130, 150, 30);

        jlValor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlValor.setText("Valor:");
        getContentPane().add(jlValor);
        jlValor.setBounds(320, 50, 50, 30);

        jlInicioContrato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlInicioContrato.setText("Início do Contrato:");
        getContentPane().add(jlInicioContrato);
        jlInicioContrato.setBounds(90, 210, 120, 30);

        jlFimContrato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlFimContrato.setText("Fim do Contrato:");
        getContentPane().add(jlFimContrato);
        jlFimContrato.setBounds(420, 210, 110, 30);

        jlNomeFiador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeFiador.setText("Nome do Fiador:");
        getContentPane().add(jlNomeFiador);
        jlNomeFiador.setBounds(100, 170, 110, 30);

        jbConfirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbConfirmar.setText("Confirmar");
        jbConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConfirmarMouseClicked(evt);
            }
        });
        getContentPane().add(jbConfirmar);
        jbConfirmar.setBounds(560, 280, 140, 70);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(260, 280, 140, 70);

        jbEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar2.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEditarMouseClicked(evt);
            }
        });
        getContentPane().add(jbEditar);
        jbEditar.setBounds(410, 280, 140, 70);

        jbFinalizarContrato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbFinalizarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/contrato.png"))); // NOI18N
        jbFinalizarContrato.setText("<html><center>Finalizar <br/> Contrato</center></html>");
        jbFinalizarContrato.setEnabled(false);
        jbFinalizarContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbFinalizarContratoMouseClicked(evt);
            }
        });
        getContentPane().add(jbFinalizarContrato);
        jbFinalizarContrato.setBounds(740, 170, 140, 70);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("ID Imóvel:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(140, 50, 70, 30);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contrato", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(30, 20, 930, 240);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtInicioContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtInicioContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtInicioContratoActionPerformed

    private void jtNomeProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNomeProprietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNomeProprietarioActionPerformed

    private void jbEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMouseClicked
        if (jbEditar.isEnabled()) {
            jbFinalizarContrato.setEnabled(true);
            jtFimContrato.setEnabled(true);
            jbConfirmar.setEnabled(true);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jbEditarMouseClicked

    private void jbFinalizarContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbFinalizarContratoMouseClicked
        if (jbFinalizarContrato.isEnabled()) {
            // Finaliza...
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jbFinalizarContratoMouseClicked

    private void jbConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMouseClicked
        if (jbConfirmar.isEnabled()) {

            //Pegao IdLocacao e faz com isso
            jtFimContrato.getText();

            // Depois volta para a home..
            new CadLocacaoHome(user).setVisible(true);
            dispose();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jbConfirmarMouseClicked

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        String ObjButtons[] = {"Sim", "Não"};
        int PromptResult = JOptionPane.showOptionDialog(this, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
        if (PromptResult == JOptionPane.YES_OPTION) {
            Sessao.getInstance().setInstanciaAberta(8);
            CadLocacaoHome.getInstancia().setVisible(true);
            CadLocacaoHome.getInstancia().setLocationRelativeTo(this);
            dispose();
            encerrarInstancia();
        }
    }//GEN-LAST:event_jbCancelarMouseClicked

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
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleLocacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbFinalizarContrato;
    private javax.swing.JLabel jlFimContrato;
    private javax.swing.JLabel jlInicioContrato;
    private javax.swing.JLabel jlNomeFiador;
    private javax.swing.JLabel jlNomeLocatario;
    private javax.swing.JLabel jlNomeProprietario;
    private javax.swing.JLabel jlValor;
    private javax.swing.JTextField jtFimContrato;
    private javax.swing.JTextField jtIdImovel;
    private javax.swing.JTextField jtInicioContrato;
    private javax.swing.JTextField jtNomeFiador;
    private javax.swing.JTextField jtNomeLocatario;
    private javax.swing.JTextField jtNomeProprietario;
    private javax.swing.JTextField jtValor;
    // End of variables declaration//GEN-END:variables
}
