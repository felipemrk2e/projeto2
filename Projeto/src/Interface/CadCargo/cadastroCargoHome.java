/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadCargo;

import Interface.TelaPrincipal.Sessao;
import javax.swing.JOptionPane;

/**
 *
 * @author a1502735
 */
public class cadastroCargoHome extends javax.swing.JFrame {

    
    private static cadastroCargoHome instancia;
    
     
    
    
    /**
     * Creates new form cadastroCargoHome
     */
    public cadastroCargoHome() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        this.setTitle("Consulta de Departamento");
         acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
    }
    
    
    public static cadastroCargoHome getInstancia() {
        if (instancia == null) {
            instancia = new cadastroCargoHome();
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
     
    public void DisableEnable(boolean b){ 
        
    }
    
    public void popularTabela(){
        
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlCodigoCargo = new javax.swing.JLabel();
        jtfCodigoCargo = new javax.swing.JTextField();
        jlCodigoDepartamento = new javax.swing.JLabel();
        jtfCodigoDepartamento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 640));
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setPreferredSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(null);

        jlCodigoCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCodigoCargo.setText("Código do Cargo");
        getContentPane().add(jlCodigoCargo);
        jlCodigoCargo.setBounds(70, 20, 130, 30);

        jtfCodigoCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoCargoActionPerformed(evt);
            }
        });
        getContentPane().add(jtfCodigoCargo);
        jtfCodigoCargo.setBounds(70, 50, 130, 30);

        jlCodigoDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCodigoDepartamento.setText("Código Departamento");
        getContentPane().add(jlCodigoDepartamento);
        jlCodigoDepartamento.setBounds(60, 310, 140, 30);
        getContentPane().add(jtfCodigoDepartamento);
        jtfCodigoDepartamento.setBounds(60, 340, 140, 30);
        getContentPane().add(jButton1);
        jButton1.setBounds(790, 50, 140, 70);
        getContentPane().add(jButton2);
        jButton2.setBounds(790, 130, 140, 70);
        getContentPane().add(jButton3);
        jButton3.setBounds(790, 340, 140, 70);
        getContentPane().add(jButton4);
        jButton4.setBounds(790, 500, 140, 70);
        getContentPane().add(jButton5);
        jButton5.setBounds(790, 210, 140, 70);
        getContentPane().add(jButton6);
        jButton6.setBounds(790, 420, 140, 70);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(230, 340, 530, 150);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(230, 50, 530, 150);

        jSeparator2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de Cargo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(210, 20, 740, 270);

        jSeparator3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de Departamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(210, 310, 740, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoCargoActionPerformed

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
            java.util.logging.Logger.getLogger(cadastroCargoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroCargoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroCargoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroCargoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroCargoHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel jlCodigoCargo;
    private javax.swing.JLabel jlCodigoDepartamento;
    private javax.swing.JTextField jtfCodigoCargo;
    private javax.swing.JTextField jtfCodigoDepartamento;
    // End of variables declaration//GEN-END:variables
}
