/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadCargo;

/**
 *
 * @author a1502735
 */
public class cadastroCargo extends javax.swing.JFrame {

    /**
     * Creates new form cadastrarCargo
     */
    public cadastroCargo() {
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

        jtfCodigoCargo = new javax.swing.JTextField();
        jlDescricaoCargo = new javax.swing.JLabel();
        jlDepartamento = new javax.swing.JLabel();
        jcbDepartamento = new javax.swing.JComboBox<>();
        jlNomeCargo = new javax.swing.JLabel();
        jlCodigoCargo = new javax.swing.JLabel();
        jlCodigoDepartamento = new javax.swing.JLabel();
        jtfCodigoDepartamento = new javax.swing.JTextField();
        jlNomeDepartamento = new javax.swing.JLabel();
        jtfNomeDepartamento = new javax.swing.JTextField();
        jlTelefone = new javax.swing.JLabel();
        jftTelefone = new javax.swing.JFormattedTextField();
        jlRamal = new javax.swing.JLabel();
        jtfRamal = new javax.swing.JTextField();
        jtNomeCargo = new javax.swing.JTextField();
        jbCadastrarCargo = new javax.swing.JButton();
        jbCadastrarDepartamento = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricaoCargo = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(704, 460));
        setMinimumSize(new java.awt.Dimension(704, 460));
        setPreferredSize(new java.awt.Dimension(704, 460));
        getContentPane().setLayout(null);
        getContentPane().add(jtfCodigoCargo);
        jtfCodigoCargo.setBounds(10, 30, 100, 20);

        jlDescricaoCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDescricaoCargo.setText("Descrição do Cargo");
        getContentPane().add(jlDescricaoCargo);
        jlDescricaoCargo.setBounds(130, 130, 200, 17);

        jlDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDepartamento.setText("Departamento");
        getContentPane().add(jlDepartamento);
        jlDepartamento.setBounds(130, 260, 120, 17);

        jcbDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbDepartamento);
        jcbDepartamento.setBounds(230, 260, 66, 23);

        jlNomeCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeCargo.setText("Nome do Cargo");
        getContentPane().add(jlNomeCargo);
        jlNomeCargo.setBounds(130, 80, 110, 17);

        jlCodigoCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoCargo.setText("Código do Cargo");
        getContentPane().add(jlCodigoCargo);
        jlCodigoCargo.setBounds(10, 10, 150, 17);

        jlCodigoDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoDepartamento.setText("Código do Departamento");
        getContentPane().add(jlCodigoDepartamento);
        jlCodigoDepartamento.setBounds(10, 300, 159, 17);
        getContentPane().add(jtfCodigoDepartamento);
        jtfCodigoDepartamento.setBounds(10, 320, 100, 20);

        jlNomeDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeDepartamento.setText("Nome do Departamento");
        getContentPane().add(jlNomeDepartamento);
        jlNomeDepartamento.setBounds(130, 360, 160, 17);
        getContentPane().add(jtfNomeDepartamento);
        jtfNomeDepartamento.setBounds(130, 380, 250, 20);

        jlTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTelefone.setText("Telefone");
        getContentPane().add(jlTelefone);
        jlTelefone.setBounds(130, 410, 100, 17);
        getContentPane().add(jftTelefone);
        jftTelefone.setBounds(130, 430, 110, 20);

        jlRamal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRamal.setText("Ramal");
        getContentPane().add(jlRamal);
        jlRamal.setBounds(260, 410, 46, 17);
        getContentPane().add(jtfRamal);
        jtfRamal.setBounds(260, 430, 90, 20);
        getContentPane().add(jtNomeCargo);
        jtNomeCargo.setBounds(130, 100, 250, 20);

        jbCadastrarCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbCadastrarCargo.setText("<html><center>Cadastrar<br/>Cargo</html>");
        getContentPane().add(jbCadastrarCargo);
        jbCadastrarCargo.setBounds(520, 80, 140, 70);

        jbCadastrarDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbCadastrarDepartamento.setText("<html><center>Cadastrar<br/>Departamento</html>");
        jbCadastrarDepartamento.setIconTextGap(0);
        getContentPane().add(jbCadastrarDepartamento);
        jbCadastrarDepartamento.setBounds(520, 370, 140, 70);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("<html><center>Cancelar<br/></html>");
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(520, 220, 140, 70);

        jtaDescricaoCargo.setColumns(20);
        jtaDescricaoCargo.setRows(5);
        jScrollPane1.setViewportView(jtaDescricaoCargo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 150, 360, 96);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(100, 350, 390, 160);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(100, 70, 390, 160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(cadastroCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroCargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbCadastrarCargo;
    private javax.swing.JButton jbCadastrarDepartamento;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JComboBox<String> jcbDepartamento;
    private javax.swing.JFormattedTextField jftTelefone;
    private javax.swing.JLabel jlCodigoCargo;
    private javax.swing.JLabel jlCodigoDepartamento;
    private javax.swing.JLabel jlDepartamento;
    private javax.swing.JLabel jlDescricaoCargo;
    private javax.swing.JLabel jlNomeCargo;
    private javax.swing.JLabel jlNomeDepartamento;
    private javax.swing.JLabel jlRamal;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JTextField jtNomeCargo;
    private javax.swing.JTextArea jtaDescricaoCargo;
    private javax.swing.JTextField jtfCodigoCargo;
    private javax.swing.JTextField jtfCodigoDepartamento;
    private javax.swing.JTextField jtfNomeDepartamento;
    private javax.swing.JTextField jtfRamal;
    // End of variables declaration//GEN-END:variables
}
