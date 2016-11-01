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
public class CadLocacaoHome extends javax.swing.JFrame {

    private static CadLocacaoHome instancia;
    int user;

    /**
     * Creates new form CadLocacaoHome
     */
    public CadLocacaoHome() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
    }

    public CadLocacaoHome(int user) {
        this.setUndecorated(true);
        this.user = user;

        initComponents();
        setAlwaysOnTop(true);

        verificaNivel();
    }

    public static CadLocacaoHome getInstancia() {
        if (instancia == null) {
            instancia = new CadLocacaoHome();
        }
        return instancia;
    }
    
    public static void encerrarInstancia(){
        instancia = null;
    }

    public void verificaNivel() {
        if (user <= 2) {

            jbCadastrar.setEnabled(true);
            jbControle.setEnabled(true);

        } else {
            jbCadastrar.setEnabled(false);
            jbControle.setEnabled(false);

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

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbVisualizar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbPesquisar = new javax.swing.JButton();
        jlIdImovel = new javax.swing.JLabel();
        jlNomeProprietario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtNomeInquilino = new javax.swing.JTextField();
        jtNomeProprietario = new javax.swing.JTextField();
        jtIdImovel = new javax.swing.JTextField();
        jtRua = new javax.swing.JTextField();
        jlRua = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jtBairro = new javax.swing.JTextField();
        jlEstado = new javax.swing.JLabel();
        jtCep = new javax.swing.JTextField();
        jlCep = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox();
        jbControle = new javax.swing.JButton();
        jtCidade = new javax.swing.JTextField();
        jlCidade = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 40, 910, 210);

        jbVisualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.png"))); // NOI18N
        jbVisualizar.setText("Visualizar");
        jbVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVisualizarMouseClicked(evt);
            }
        });
        getContentPane().add(jbVisualizar);
        jbVisualizar.setBounds(670, 260, 140, 70);

        jbCadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbCadastrar.setText("<html><center>Cadastro <br /> de <br /> Locação </center></html>");
        jbCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCadastrarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCadastrar);
        jbCadastrar.setBounds(820, 260, 140, 70);

        jbPesquisar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPesquisarMouseClicked(evt);
            }
        });
        getContentPane().add(jbPesquisar);
        jbPesquisar.setBounds(820, 480, 140, 70);

        jlIdImovel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlIdImovel.setText("Nome do Inquilino:");
        getContentPane().add(jlIdImovel);
        jlIdImovel.setBounds(50, 520, 120, 30);

        jlNomeProprietario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeProprietario.setText("Nome do Proprietário:");
        getContentPane().add(jlNomeProprietario);
        jlNomeProprietario.setBounds(50, 480, 140, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("ID Imóvel:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 400, 70, 30);
        getContentPane().add(jtNomeInquilino);
        jtNomeInquilino.setBounds(170, 520, 600, 30);
        getContentPane().add(jtNomeProprietario);
        jtNomeProprietario.setBounds(200, 480, 570, 30);
        getContentPane().add(jtIdImovel);
        jtIdImovel.setBounds(120, 400, 90, 30);
        getContentPane().add(jtRua);
        jtRua.setBounds(460, 400, 310, 30);

        jlRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRua.setText("Rua:");
        getContentPane().add(jlRua);
        jlRua.setBounds(420, 400, 34, 30);

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setText("Bairro:");
        getContentPane().add(jlBairro);
        jlBairro.setBounds(50, 440, 50, 30);
        getContentPane().add(jtBairro);
        jtBairro.setBounds(100, 440, 250, 30);

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("Estado:");
        getContentPane().add(jlEstado);
        jlEstado.setBounds(650, 440, 50, 30);
        getContentPane().add(jtCep);
        jtCep.setBounds(320, 400, 90, 30);

        jlCep.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCep.setText("CEP do Imóvel:");
        getContentPane().add(jlCep);
        jlCep.setBounds(220, 400, 100, 30);

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstado);
        jcbEstado.setBounds(700, 440, 66, 30);

        jbControle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbControle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/controle.png"))); // NOI18N
        jbControle.setText("<html><center>Controle <br/> de </br> Locação<center></html>");
        jbControle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbControleMouseClicked(evt);
            }
        });
        getContentPane().add(jbControle);
        jbControle.setBounds(520, 260, 140, 70);
        getContentPane().add(jtCidade);
        jtCidade.setBounds(410, 440, 230, 30);

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setText("Cidade:");
        jlCidade.setAutoscrolls(true);
        getContentPane().add(jlCidade);
        jlCidade.setBounds(360, 440, 50, 30);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Locação Home", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 10, 970, 340);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Locação", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(20, 360, 970, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPesquisarMouseClicked
        boolean control = true;
        // falta o cep;
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

        if (jtNomeInquilino.getText().equals("")) {
            jtNomeInquilino.setForeground(Color.white);

        } else if (!jtNomeInquilino.getText().equals("") && validacao.validaLetras(jtNomeInquilino.getText())) {
            jtNomeInquilino.setForeground(Color.white);
        } else {
            jtNomeInquilino.setForeground(Color.red);
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

        if (control) {
// faz algo..
        } else {
            control = true;
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jbPesquisarMouseClicked

    private void jbVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVisualizarMouseClicked
        String idLocacao = "vazio no momento";

        new CadLocacao(user, idLocacao).setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jbVisualizarMouseClicked

    private void jbCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarMouseClicked
        if (jbCadastrar.isEnabled()) {

            new CadLocacao(user).setVisible(true);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarMouseClicked

    private void jbControleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleMouseClicked
        if (jbControle.isEnabled()) {
            String idLocacao = "vazio no momento";
            new ControleLocacao(user, idLocacao).setVisible(true);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbControleMouseClicked

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
            java.util.logging.Logger.getLogger(CadLocacaoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadLocacaoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadLocacaoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadLocacaoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadLocacaoHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbControle;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbVisualizar;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCep;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlIdImovel;
    private javax.swing.JLabel jlNomeProprietario;
    private javax.swing.JLabel jlRua;
    private javax.swing.JTextField jtBairro;
    private javax.swing.JTextField jtCep;
    private javax.swing.JTextField jtCidade;
    private javax.swing.JTextField jtIdImovel;
    private javax.swing.JTextField jtNomeInquilino;
    private javax.swing.JTextField jtNomeProprietario;
    private javax.swing.JTextField jtRua;
    // End of variables declaration//GEN-END:variables
}
