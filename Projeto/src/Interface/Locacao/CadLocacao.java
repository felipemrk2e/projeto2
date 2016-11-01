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
    private static CadLocacao instancia;
    int user;

    /**
     * Creates new form CadLocacao
     */
    public CadLocacao() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
    }

    public CadLocacao(int user) {
        this.setUndecorated(true);
                 this.user = user;

        initComponents();
        setAlwaysOnTop(true);
    }

    public CadLocacao(int user, String idlocacao) {
        this.setUndecorated(true);
                 this.user = user;
                 

        initComponents();
        setAlwaysOnTop(true);
    }
    
    public static CadLocacao getInstancia() {
        if (instancia == null) {
            instancia = new CadLocacao();
        }
        return instancia;
    }
    
    public static void encerrarInstancia(){
        instancia = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspTabelaCliente = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jspTabelaImovel = new javax.swing.JScrollPane();
        jtImovel = new javax.swing.JTable();
        jbCancelar = new javax.swing.JButton();
        jbPesquisarImovel = new javax.swing.JButton();
        jlIdCliente = new javax.swing.JLabel();
        jtImovelSelecionado = new javax.swing.JTextField();
        jtClienteSelecionado = new javax.swing.JTextField();
        jbSelecionarImovel = new javax.swing.JButton();
        jlNomeCliente = new javax.swing.JLabel();
        jtIdCliente = new javax.swing.JTextField();
        jtNomeCliente = new javax.swing.JTextField();
        jbPesquisarCliente = new javax.swing.JButton();
        jbSelecionarCliente = new javax.swing.JButton();
        jlIdImovel = new javax.swing.JLabel();
        jlNomeProprietario = new javax.swing.JLabel();
        jlRua = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jlEstado = new javax.swing.JLabel();
        jlInicioContrato = new javax.swing.JLabel();
        jlFimContrato = new javax.swing.JLabel();
        jlClienteSelecionado = new javax.swing.JLabel();
        jlImovelSelecionado = new javax.swing.JLabel();
        jtDataInicio = new javax.swing.JTextField();
        jtDataFim = new javax.swing.JTextField();
        jtIdImovel = new javax.swing.JTextField();
        jtNomeProprietario = new javax.swing.JTextField();
        jtRua = new javax.swing.JTextField();
        jtBairro = new javax.swing.JTextField();
        jcbEstado = new javax.swing.JComboBox();
        jtCidade = new javax.swing.JTextField();
        jlCidade = new javax.swing.JLabel();
        jbEfetuarLocacao = new javax.swing.JButton();
        jsImovel = new javax.swing.JSeparator();
        jsCliente = new javax.swing.JSeparator();
        jsLocacao = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jspTabelaCliente.setViewportView(jtCliente);

        getContentPane().add(jspTabelaCliente);
        jspTabelaCliente.setBounds(30, 20, 810, 110);

        jtImovel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jspTabelaImovel.setViewportView(jtImovel);

        getContentPane().add(jspTabelaImovel);
        jspTabelaImovel.setBounds(20, 210, 820, 110);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(850, 560, 140, 40);

        jbPesquisarImovel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbPesquisarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisarImovel.setText("Pesquisar");
        jbPesquisarImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPesquisarImovelMouseClicked(evt);
            }
        });
        getContentPane().add(jbPesquisarImovel);
        jbPesquisarImovel.setBounds(850, 370, 140, 40);

        jlIdCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlIdCliente.setText("ID Cliente:");
        getContentPane().add(jlIdCliente);
        jlIdCliente.setBounds(250, 140, 70, 40);

        jtImovelSelecionado.setToolTipText("");
        getContentPane().add(jtImovelSelecionado);
        jtImovelSelecionado.setBounds(150, 490, 690, 30);

        jtClienteSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtClienteSelecionadoActionPerformed(evt);
            }
        });
        getContentPane().add(jtClienteSelecionado);
        jtClienteSelecionado.setBounds(150, 450, 690, 30);

        jbSelecionarImovel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbSelecionarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imovel.png"))); // NOI18N
        jbSelecionarImovel.setText("<html><center>Selecionar <br/> Imovel </center></html>");
        jbSelecionarImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSelecionarImovelMouseClicked(evt);
            }
        });
        getContentPane().add(jbSelecionarImovel);
        jbSelecionarImovel.setBounds(850, 210, 140, 70);

        jlNomeCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeCliente.setText("Nome Cliente:");
        getContentPane().add(jlNomeCliente);
        jlNomeCliente.setBounds(430, 140, 90, 40);
        getContentPane().add(jtIdCliente);
        jtIdCliente.setBounds(320, 140, 100, 40);
        getContentPane().add(jtNomeCliente);
        jtNomeCliente.setBounds(520, 140, 320, 40);

        jbPesquisarCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        jbPesquisarCliente.setBounds(850, 140, 140, 40);

        jbSelecionarCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbSelecionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clientes.png"))); // NOI18N
        jbSelecionarCliente.setText("<html><center>Selecionar <br/> Cliente</center></html>");
        jbSelecionarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSelecionarClienteMouseClicked(evt);
            }
        });
        getContentPane().add(jbSelecionarCliente);
        jbSelecionarCliente.setBounds(850, 20, 140, 70);

        jlIdImovel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlIdImovel.setText("ID Imovel:");
        getContentPane().add(jlIdImovel);
        jlIdImovel.setBounds(20, 330, 70, 40);

        jlNomeProprietario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeProprietario.setText("Nome Proprietario:");
        getContentPane().add(jlNomeProprietario);
        jlNomeProprietario.setBounds(180, 330, 120, 40);

        jlRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRua.setText("Rua:");
        getContentPane().add(jlRua);
        jlRua.setBounds(20, 380, 30, 30);

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setText("Bairro:");
        getContentPane().add(jlBairro);
        jlBairro.setBounds(365, 380, 50, 30);

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("Estado:");
        getContentPane().add(jlEstado);
        jlEstado.setBounds(720, 380, 50, 30);

        jlInicioContrato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlInicioContrato.setText("Inicio do Contrato:");
        getContentPane().add(jlInicioContrato);
        jlInicioContrato.setBounds(30, 530, 120, 30);

        jlFimContrato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlFimContrato.setText("Fim do Contrato:");
        getContentPane().add(jlFimContrato);
        jlFimContrato.setBounds(40, 570, 110, 30);

        jlClienteSelecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlClienteSelecionado.setText("Cliente selecionado:");
        getContentPane().add(jlClienteSelecionado);
        jlClienteSelecionado.setBounds(20, 450, 130, 30);

        jlImovelSelecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlImovelSelecionado.setText("Imovel Selecionado:");
        getContentPane().add(jlImovelSelecionado);
        jlImovelSelecionado.setBounds(20, 490, 130, 30);
        getContentPane().add(jtDataInicio);
        jtDataInicio.setBounds(150, 530, 690, 30);
        getContentPane().add(jtDataFim);
        jtDataFim.setBounds(150, 570, 690, 30);

        jtIdImovel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jtIdImovel);
        jtIdImovel.setBounds(90, 330, 80, 40);
        getContentPane().add(jtNomeProprietario);
        jtNomeProprietario.setBounds(300, 330, 540, 40);
        getContentPane().add(jtRua);
        jtRua.setBounds(60, 380, 300, 30);
        getContentPane().add(jtBairro);
        jtBairro.setBounds(410, 380, 100, 30);

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstado);
        jcbEstado.setBounds(770, 380, 66, 30);

        jtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jtCidade);
        jtCidade.setBounds(570, 380, 140, 30);
        jtCidade.getAccessibleContext().setAccessibleName("");

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setText("Cidade:");
        getContentPane().add(jlCidade);
        jlCidade.setBounds(520, 380, 50, 30);

        jbEfetuarLocacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEfetuarLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Partnership-icon.png"))); // NOI18N
        jbEfetuarLocacao.setText("<html><center>Efetuar <br/> Locação</center></html>");
        jbEfetuarLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEfetuarLocacaoMouseClicked(evt);
            }
        });
        getContentPane().add(jbEfetuarLocacao);
        jbEfetuarLocacao.setBounds(850, 450, 140, 70);

        jsImovel.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jsImovel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Imóvel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jsImovel);
        jsImovel.setBounds(10, 190, 1000, 230);

        jsCliente.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jsCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jsCliente);
        jsCliente.setBounds(10, 0, 1000, 190);

        jsLocacao.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jsLocacao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Locação", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jsLocacao);
        jsLocacao.setBounds(10, 420, 1000, 190);

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

    private void jtClienteSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtClienteSelecionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtClienteSelecionadoActionPerformed

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
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEfetuarLocacao;
    private javax.swing.JButton jbPesquisarCliente;
    private javax.swing.JButton jbPesquisarImovel;
    private javax.swing.JButton jbSelecionarCliente;
    private javax.swing.JButton jbSelecionarImovel;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlClienteSelecionado;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlFimContrato;
    private javax.swing.JLabel jlIdCliente;
    private javax.swing.JLabel jlIdImovel;
    private javax.swing.JLabel jlImovelSelecionado;
    private javax.swing.JLabel jlInicioContrato;
    private javax.swing.JLabel jlNomeCliente;
    private javax.swing.JLabel jlNomeProprietario;
    private javax.swing.JLabel jlRua;
    private javax.swing.JSeparator jsCliente;
    private javax.swing.JSeparator jsImovel;
    private javax.swing.JSeparator jsLocacao;
    private javax.swing.JScrollPane jspTabelaCliente;
    private javax.swing.JScrollPane jspTabelaImovel;
    private javax.swing.JTextField jtBairro;
    private javax.swing.JTextField jtCidade;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTextField jtClienteSelecionado;
    private javax.swing.JTextField jtDataFim;
    private javax.swing.JTextField jtDataInicio;
    private javax.swing.JTextField jtIdCliente;
    private javax.swing.JTextField jtIdImovel;
    private javax.swing.JTable jtImovel;
    private javax.swing.JTextField jtImovelSelecionado;
    private javax.swing.JTextField jtNomeCliente;
    private javax.swing.JTextField jtNomeProprietario;
    private javax.swing.JTextField jtRua;
    // End of variables declaration//GEN-END:variables
}
