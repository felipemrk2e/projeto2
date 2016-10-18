/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadFuncionario;

/**
 *
 * @author user
 */
public class ControleFuncionario extends javax.swing.JFrame {

    int user;

    /**
     * Creates new form ControleFuncionario
     */
    public ControleFuncionario() {
        initComponents();
    }

    public ControleFuncionario(int user, Long idFuncionario) {
        initComponents();
        verificaNivel();
        popular();

    }
    
    public void popular(){
        //Falta Cargo e departamento..
        
        jtfNome.setText("");
        jtfCodigoInterno.setText("");  
        jftCPF.setText("");
        jtfRG.setText("");
    }
    
    public void DisableEnable(boolean b){
        
        //falta nivel de acesso;
        jtUser.setEnabled(b);
        jtNovaSenha1.setEnabled(b);
        jtNovaSenha2.setEnabled(b);
    }

    public void verificaNivel() {
        if (user <= 2) {
             DisableEnable(false);
            jbEditar.setEnabled(true);
            jbConfirmar.setEnabled(false);

        } else {
            DisableEnable(false);
            jbConfirmar.setEnabled(false);

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

        jlCodigoInterno = new javax.swing.JLabel();
        jtfCodigoInterno = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jlCPF = new javax.swing.JLabel();
        jftCPF = new javax.swing.JFormattedTextField();
        jlRG = new javax.swing.JLabel();
        jtfRG = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtNivelAcesso = new javax.swing.JTextField();
        jtUser = new javax.swing.JTextField();
        jtNovaSenha2 = new javax.swing.JTextField();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jtCargo = new javax.swing.JTextField();
        jtDepartamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbEditar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jtNovaSenha1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        getContentPane().setLayout(null);

        jlCodigoInterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoInterno.setText("Código Interno");
        getContentPane().add(jlCodigoInterno);
        jlCodigoInterno.setBounds(20, 10, 101, 17);

        jtfCodigoInterno.setEnabled(false);
        getContentPane().add(jtfCodigoInterno);
        jtfCodigoInterno.setBounds(20, 30, 100, 20);

        jlNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNome.setText("Nome");
        getContentPane().add(jlNome);
        jlNome.setBounds(150, 20, 36, 17);

        jtfNome.setEnabled(false);
        getContentPane().add(jtfNome);
        jtfNome.setBounds(150, 40, 400, 20);

        jlCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF.setText("CPF");
        getContentPane().add(jlCPF);
        jlCPF.setBounds(150, 70, 28, 17);

        jftCPF.setEnabled(false);
        getContentPane().add(jftCPF);
        jftCPF.setBounds(150, 90, 150, 20);

        jlRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRG.setText("RG");
        getContentPane().add(jlRG);
        jlRG.setBounds(320, 70, 21, 17);

        jtfRG.setEnabled(false);
        getContentPane().add(jtfRG);
        jtfRG.setBounds(320, 90, 150, 20);

        jLabel1.setText("Nova Senha");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 260, 90, 14);

        jLabel2.setText("Repetir Nova Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(340, 310, 110, 14);

        jLabel3.setText("Nivel de acesso");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 210, 90, 14);
        getContentPane().add(jtNivelAcesso);
        jtNivelAcesso.setBounds(180, 230, 60, 20);
        getContentPane().add(jtUser);
        jtUser.setBounds(340, 230, 120, 20);
        getContentPane().add(jtNovaSenha2);
        jtNovaSenha2.setBounds(340, 330, 120, 20);

        jbConfirmar.setText("Confirmar");
        getContentPane().add(jbConfirmar);
        jbConfirmar.setBounds(180, 470, 195, 88);

        jbCancelar.setText("Cancelar");
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(420, 470, 195, 88);
        getContentPane().add(jtCargo);
        jtCargo.setBounds(520, 90, 60, 20);
        getContentPane().add(jtDepartamento);
        jtDepartamento.setBounds(650, 90, 60, 20);

        jLabel4.setText("Cargo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(520, 70, 29, 14);

        jLabel5.setText("Departamento");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(650, 70, 120, 14);

        jbEditar.setText("Editar");
        getContentPane().add(jbEditar);
        jbEditar.setBounds(650, 470, 195, 88);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(0, 450, 1030, 10);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(0, 190, 1030, 10);
        getContentPane().add(jtNovaSenha1);
        jtNovaSenha1.setBounds(340, 280, 120, 20);

        jLabel6.setText("Nome de Usuario");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(340, 210, 110, 14);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCodigoInterno;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlRG;
    private javax.swing.JTextField jtCargo;
    private javax.swing.JTextField jtDepartamento;
    private javax.swing.JTextField jtNivelAcesso;
    private javax.swing.JTextField jtNovaSenha1;
    private javax.swing.JTextField jtNovaSenha2;
    private javax.swing.JTextField jtUser;
    private javax.swing.JTextField jtfCodigoInterno;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfRG;
    // End of variables declaration//GEN-END:variables
}
