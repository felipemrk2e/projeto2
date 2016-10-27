/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Locacao;

import java.awt.Color;
import validacao.validacao;

/**
 *
 * @author user
 */
public class CadLocacao extends javax.swing.JFrame {

    int user;

    /**
     * Creates new form CadLocacao
     */
    public CadLocacao() {
        initComponents();
    }

    public CadLocacao(int user) {
                 this.user = user;

        initComponents();
    }

    public CadLocacao(int user, String idlocacao) {
                 this.user = user;

        initComponents();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbPesquisarImovel = new javax.swing.JButton();
        jtImovelSelecionado = new javax.swing.JTextField();
        jtClienteSelecionado = new javax.swing.JTextField();
        jbSelecionarImovel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtIdCliente = new javax.swing.JTextField();
        jtNomeCliente = new javax.swing.JTextField();
        jbPesquisarCliente = new javax.swing.JButton();
        jbSelecionarCliente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtDataInicio = new javax.swing.JTextField();
        jtDataFim = new javax.swing.JTextField();
        jtIdImovel = new javax.swing.JTextField();
        jtNomeProprietario = new javax.swing.JTextField();
        jtRua = new javax.swing.JTextField();
        jtBairro = new javax.swing.JTextField();
        jcbEstado = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jtCidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jbEfetuarLocacao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setResizable(false);
        getContentPane().setLayout(null);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(32, 80, 810, 110);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 360, 810, 110);

        jLabel1.setText("Cliente");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(400, 60, 39, 16);

        jLabel2.setText("Imovel");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(390, 340, 38, 16);

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(860, 260, 140, 40);

        jbPesquisarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisarImovel.setText("Pesquisar");
        jbPesquisarImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPesquisarImovelMouseClicked(evt);
            }
        });
        getContentPane().add(jbPesquisarImovel);
        jbPesquisarImovel.setBounds(860, 530, 140, 40);

        jtImovelSelecionado.setText("Id Imovel , Endereço e Nome  Proprietario");
        getContentPane().add(jtImovelSelecionado);
        jtImovelSelecionado.setBounds(50, 280, 450, 30);

        jtClienteSelecionado.setText("Id Cliente, Nome ");
        getContentPane().add(jtClienteSelecionado);
        jtClienteSelecionado.setBounds(50, 220, 450, 30);

        jbSelecionarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imovel.png"))); // NOI18N
        jbSelecionarImovel.setText("Selecionar Imovel");
        jbSelecionarImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSelecionarImovelMouseClicked(evt);
            }
        });
        getContentPane().add(jbSelecionarImovel);
        jbSelecionarImovel.setBounds(860, 390, 140, 40);

        jLabel3.setText("Id cliente");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 10, 90, 20);

        jLabel4.setText("Nome Cliente");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 10, 80, 20);
        getContentPane().add(jtIdCliente);
        jtIdCliente.setBounds(70, 30, 100, 22);
        getContentPane().add(jtNomeCliente);
        jtNomeCliente.setBounds(190, 30, 310, 22);

        jbPesquisarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisarCliente.setText("Pesquisar");
        jbPesquisarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPesquisarClienteMouseClicked(evt);
            }
        });
        jbPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jbPesquisarCliente);
        jbPesquisarCliente.setBounds(860, 10, 140, 40);

        jbSelecionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clientes.png"))); // NOI18N
        jbSelecionarCliente.setText("Selecionar Cliente");
        jbSelecionarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSelecionarClienteMouseClicked(evt);
            }
        });
        getContentPane().add(jbSelecionarCliente);
        jbSelecionarCliente.setBounds(860, 100, 140, 40);

        jLabel12.setText("IdImovel");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(70, 470, 70, 30);

        jLabel13.setText("Nome Proprietario");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(190, 480, 110, 16);

        jLabel14.setText("Rua");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(70, 520, 22, 20);

        jLabel15.setText("Bairro");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(390, 520, 34, 16);

        jLabel16.setText("Estado");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(730, 520, 38, 16);

        jLabel5.setText("Inicio do Contrato");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(560, 270, 140, 20);

        jLabel6.setText("Fim do Contrato");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(680, 270, 150, 20);

        jLabel7.setText("Cliente selecionado");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 200, 110, 16);

        jLabel8.setText("Imovel Selecionado");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 260, 100, 16);
        getContentPane().add(jtDataInicio);
        jtDataInicio.setBounds(560, 290, 80, 20);
        getContentPane().add(jtDataFim);
        jtDataFim.setBounds(680, 290, 80, 20);
        getContentPane().add(jtIdImovel);
        jtIdImovel.setBounds(70, 500, 80, 22);
        getContentPane().add(jtNomeProprietario);
        jtNomeProprietario.setBounds(190, 500, 300, 22);
        getContentPane().add(jtRua);
        jtRua.setBounds(70, 540, 280, 22);
        getContentPane().add(jtBairro);
        jtBairro.setBounds(390, 540, 120, 22);

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstado);
        jcbEstado.setBounds(730, 540, 66, 23);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(0, 320, 1030, 10);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(0, 190, 1030, 10);

        jtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jtCidade);
        jtCidade.setBounds(550, 540, 140, 22);
        jtCidade.getAccessibleContext().setAccessibleName("");

        jLabel9.setText("Cidade");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(550, 520, 39, 16);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(0, 470, 1030, 10);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(0, 60, 1030, 10);

        jbEfetuarLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Partnership-icon.png"))); // NOI18N
        jbEfetuarLocacao.setText("Efetuar Locação");
        jbEfetuarLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEfetuarLocacaoMouseClicked(evt);
            }
        });
        getContentPane().add(jbEfetuarLocacao);
        jbEfetuarLocacao.setBounds(860, 210, 140, 40);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked

        
        new CadLocacaoHome(user).setVisible(true);
        dispose();
 
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jbPesquisarImovelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPesquisarImovelMouseClicked
        boolean control = true;

        if (jtIdImovel.getText().equals("")) {
            jtIdImovel.setForeground(Color.white);

        } else if (!jtIdImovel.getText().equals("") && validacao.validaNumeros(jtIdImovel.getText())) {
            jtIdImovel.setForeground(Color.white);
        } else {
            jtIdImovel.setForeground(Color.red);
            control = false;
        }

        if (jtIdImovel.getText().equals("")) {
            jtIdImovel.setForeground(Color.white);

        } else if (!jtIdImovel.getText().equals("") && validacao.validaLetras(jtIdImovel.getText())) {
            jtIdImovel.setForeground(Color.white);
        } else {
            jtIdImovel.setForeground(Color.red);
            control = false;
        }

        if (jtNomeProprietario.getText().equals("")) {
            jtNomeProprietario.setForeground(Color.white);

        } else if (!jtNomeProprietario.getText().equals("") && validacao.validaLetras(jtNomeProprietario.getText())) {
            jtIdImovel.setForeground(Color.white);
        } else {
            jtNomeProprietario.setForeground(Color.red);
            control = false;
        }

        if (jtNomeProprietario.getText().equals("")) {
            jtNomeProprietario.setForeground(Color.white);

        } else if (!jtNomeProprietario.getText().equals("") && validacao.validaLetras(jtNomeProprietario.getText())) {
            jtNomeProprietario.setForeground(Color.white);
        } else {
            jtNomeProprietario.setForeground(Color.red);
            control = false;
        }

        if (jtRua.getText().equals("")) {
            jtRua.setForeground(Color.white);

        } else if (!jtRua.getText().equals("") && validacao.validaLetras(jtRua.getText())) {
            jtRua.setForeground(Color.white);
        } else {
            jtRua.setForeground(Color.red);
            control = false;
        }

        if (jtBairro.getText().equals("")) {
            jtBairro.setForeground(Color.white);

        } else if (!jtBairro.getText().equals("") && validacao.validaLetras(jtBairro.getText())) {
            jtBairro.setForeground(Color.white);
        } else {
            jtBairro.setForeground(Color.red);
            control = false;
        }
        if (jtCidade.getText().equals("")) {
            jtCidade.setForeground(Color.white);

        } else if (!jtCidade.getText().equals("") && validacao.validaLetras(jtCidade.getText())) {
            jtCidade.setForeground(Color.white);
        } else {
            jtCidade.setForeground(Color.red);
            control = false;
        }
// pega o estado tbm..
        if (control) {
// faz algo..
        } else {
            control = true;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jbPesquisarImovelMouseClicked

    private void jbSelecionarImovelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSelecionarImovelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSelecionarImovelMouseClicked

    private void jbPesquisarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPesquisarClienteMouseClicked

        boolean control = true;

        if(jtIdCliente.getText().equals("")){
            
        } else if (!jtIdCliente.getText().equals("") && validacao.validaNumeros(jtIdCliente.getText())) {
           jtIdCliente.setBackground(Color.white);
        } else {
           jtIdCliente.setBackground(Color.red);
            control = false;
        }
        
        
        if (jtNomeCliente.getText().equals("")) {
            jtNomeCliente.setBackground(Color.white);
        } else if (!jtNomeCliente.getText().equals("") && validacao.validaLetras(jtNomeCliente.getText())) {
            jtNomeCliente.setBackground(Color.white);
        } else {
            jtNomeCliente.setBackground(Color.red);
            control = false;
        }
        
        

        if (control) {

        } else {
            control = true;
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jbPesquisarClienteMouseClicked

    private void jbSelecionarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSelecionarClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSelecionarClienteMouseClicked

    private void jbPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbPesquisarClienteActionPerformed

    private void jtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCidadeActionPerformed

    private void jbEfetuarLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEfetuarLocacaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEfetuarLocacaoMouseClicked

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
            java.util.logging.Logger.getLogger(CadLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadLocacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEfetuarLocacao;
    private javax.swing.JButton jbPesquisarCliente;
    private javax.swing.JButton jbPesquisarImovel;
    private javax.swing.JButton jbSelecionarCliente;
    private javax.swing.JButton jbSelecionarImovel;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JTextField jtBairro;
    private javax.swing.JTextField jtCidade;
    private javax.swing.JTextField jtClienteSelecionado;
    private javax.swing.JTextField jtDataFim;
    private javax.swing.JTextField jtDataInicio;
    private javax.swing.JTextField jtIdCliente;
    private javax.swing.JTextField jtIdImovel;
    private javax.swing.JTextField jtImovelSelecionado;
    private javax.swing.JTextField jtNomeCliente;
    private javax.swing.JTextField jtNomeProprietario;
    private javax.swing.JTextField jtRua;
    // End of variables declaration//GEN-END:variables
}
