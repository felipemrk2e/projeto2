/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadCargo;

import Interface.TelaPrincipal.Sessao;
import dao.CargoDAO;
import dao.DepartamentoDAO;
import java.awt.Color;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.pessoa.Cargo;
import model.pessoa.Departamento;
import model.pessoa.EstadoCivil;

/**
 *
 * @author a1502735
 */
public class cadastroCargo extends javax.swing.JFrame {

    private static cadastroCargo instancia;
    public static Departamento departamento = null;
    public static Cargo cargo = null;
    DefaultListModel listModel = new DefaultListModel();

    /**
     * Creates new form cadastrarCargo
     */
    public cadastroCargo() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        this.setTitle("Cadastro de Departamento");
        mascaraTelefone();
        carregaDepartamentos();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());

    }

    public static cadastroCargo getInstancia() {
        if (instancia == null) {
            instancia = new cadastroCargo();
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

    public void DisableEnable(Boolean b) {
        jtfCodigoDepartamento.setEnabled(false);
        jtfNomeDepartamento.setEnabled(b);
        jftTelefone.setEnabled(b);
        jtfRamal.setEnabled(b);
        jtfCodigoCargo.setEnabled(b);
        jtNomeCargo.setEnabled(b);
        jtaDescricaoCargo.setEnabled(b);
        jlCargosList.setEnabled(b);
        jbCadastrarDepartamento.setEnabled(b);
        jbCadastrarCargo.setEnabled(b);
        jbEditar.setEnabled(b);
    }

    public boolean validaCargo(boolean valida) {
        if (!jtNomeCargo.getText().isEmpty()) {
            jtNomeCargo.setBackground(Color.white);
        } else {
            jtNomeCargo.setBackground(Color.red);
            valida = false;
        }
        if (!jtaDescricaoCargo.getText().isEmpty()) {
            jtaDescricaoCargo.setBackground(Color.white);
        } else {
            jtaDescricaoCargo.setBackground(Color.red);
            valida = false;
        }

        return valida;
    }

    public boolean validaDepartamento(boolean valida) {
        if (!jtfNomeDepartamento.getText().isEmpty()) {
            jtfNomeDepartamento.setBackground(Color.white);
        } else {
            jtfNomeDepartamento.setBackground(Color.red);
            valida = false;
        }
        if (!jftTelefone.getText().isEmpty()) {
            jftTelefone.setBackground(Color.white);
        } else {
            jftTelefone.setBackground(Color.red);
            valida = false;
        }

        return valida;
    }

    public void ZerarCampos() {
        jtfCodigoDepartamento.setText("");
        jtfNomeDepartamento.setText("");
        jftTelefone.setText("");
        jtfRamal.setText("");
        jtfCodigoCargo.setText("");
        jtNomeCargo.setText("");
        jtaDescricaoCargo.setText("");
        jlCargosList.setSelectedIndex(-1);
    }

    public void cadastrarCargo(Departamento departamento) {
        Cargo cargo = new Cargo();
        CargoDAO cargoDAO = new CargoDAO();
        cargo.setNomeCargo(jtNomeCargo.getText());
        cargo.setDescricaoCargo(jtaDescricaoCargo.getText());
        cargo.setDepartamento(departamento);
        cargoDAO.persist(cargo);
        listModel.addElement(cargo);
        jlCargosList.setModel(listModel);

    }

    public void cadastrarCargo(Cargo cargo, Departamento departamento) {
        CargoDAO cargoDAO = new CargoDAO();
        cargo.setNomeCargo(jtNomeCargo.getText());
        cargo.setDescricaoCargo(jtaDescricaoCargo.getText());
        cargo.setDepartamento(departamento);
        cargoDAO.merge(cargo);
    }

    public void cadastrarDepartamento() {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        Departamento departamento = new Departamento();
        departamento.setNomeDepartamento(jtfNomeDepartamento.getText());
        departamento.setRamal(jtfRamal.getText());
        departamento.setTelefoneDepartamento(jftTelefone.getText());
        departamentoDAO.persist(departamento);
        this.departamento = departamento;
    }

    public void cadastrarDepartamento(Departamento departamento) {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        departamento.setNomeDepartamento(jtfNomeDepartamento.getText());
        departamento.setRamal(jtfRamal.getText());
        departamento.setTelefoneDepartamento(jftTelefone.getText());
        departamento.setCargo((List<Cargo>) jlCargosList.getModel());
        departamentoDAO.merge(departamento);
    }

    public void atualizarDepartamento(Departamento departamento) {
        jtfCodigoDepartamento.setText("" + departamento.getIdDepartamento());
        jtfNomeDepartamento.setText(departamento.getNomeDepartamento());
        jtfRamal.setText(departamento.getRamal());
        jftTelefone.setText(departamento.getTelefoneDepartamento());
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < departamento.getCargo().size(); i++) {
            listModel.addElement(departamento.getCargo().get(i));
        }
        jlCargosList.setModel(listModel);
    }

    public void atualizaCargo(Cargo cargo) {
        jtfCodigoCargo.setText("" + cargo.getIdCargo());
        jtNomeCargo.setText(cargo.getNomeCargo());
        jtaDescricaoCargo.setText(cargo.getDescricaoCargo());
    }

    public void carregaListaCargos() {
        for (int i = 0; i < departamento.getCargo().size(); i++) {
            listModel.addElement(departamento.getCargo().get(i));
        }
        jlCargosList.setModel(listModel);
    }

    public void carregaDepartamentos() {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> listaDepartamentos = departamentoDAO.getAll();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaDepartamentos.toArray());
        jcbDepartamentos.setModel(defaultComboBox);
    }

    public void mascaraTelefone() {
        try {
            jftTelefone.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            e.printStackTrace();
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

        jtfCodigoCargo = new javax.swing.JTextField();
        jlDescricaoCargo = new javax.swing.JLabel();
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
        jbEditar = new javax.swing.JButton();
        jbCadastrarDepartamento = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricaoCargo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlCargosList = new javax.swing.JList<>();
        jbCadastrarCargo = new javax.swing.JButton();
        jlCargosDepartamento = new javax.swing.JLabel();
        jbCancelarDepartamento = new javax.swing.JButton();
        jlDepartamento = new javax.swing.JLabel();
        jcbDepartamentos = new javax.swing.JComboBox<>();
        jsCadastrarCargo = new javax.swing.JSeparator();
        jsCadastrarDepartamento = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(747, 640));
        getContentPane().setLayout(null);
        getContentPane().add(jtfCodigoCargo);
        jtfCodigoCargo.setBounds(160, 280, 80, 30);

        jlDescricaoCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDescricaoCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDescricaoCargo.setText("Descrição do Cargo");
        getContentPane().add(jlDescricaoCargo);
        jlDescricaoCargo.setBounds(230, 360, 330, 30);

        jlNomeCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeCargo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNomeCargo.setText("Nome do Cargo:");
        getContentPane().add(jlNomeCargo);
        jlNomeCargo.setBounds(230, 330, 120, 30);

        jlCodigoCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoCargo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCodigoCargo.setText("Código do Cargo:");
        getContentPane().add(jlCodigoCargo);
        jlCodigoCargo.setBounds(30, 280, 120, 30);

        jlCodigoDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCodigoDepartamento.setText("Código do Departamento:");
        getContentPane().add(jlCodigoDepartamento);
        jlCodigoDepartamento.setBounds(30, 10, 170, 30);
        getContentPane().add(jtfCodigoDepartamento);
        jtfCodigoDepartamento.setBounds(210, 10, 80, 30);

        jlNomeDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNomeDepartamento.setText("Nome do Departamento:");
        getContentPane().add(jlNomeDepartamento);
        jlNomeDepartamento.setBounds(210, 80, 160, 30);
        getContentPane().add(jtfNomeDepartamento);
        jtfNomeDepartamento.setBounds(380, 80, 180, 30);

        jlTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTelefone.setText("Telefone:");
        getContentPane().add(jlTelefone);
        jlTelefone.setBounds(210, 120, 160, 30);
        getContentPane().add(jftTelefone);
        jftTelefone.setBounds(380, 120, 180, 30);

        jlRamal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRamal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlRamal.setText("Ramal:");
        getContentPane().add(jlRamal);
        jlRamal.setBounds(210, 160, 160, 30);
        getContentPane().add(jtfRamal);
        jtfRamal.setBounds(380, 160, 180, 30);
        getContentPane().add(jtNomeCargo);
        jtNomeCargo.setBounds(360, 330, 200, 30);

        jbEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbEditar.setText("<html><center>Editar<br/>Cargo</html>");
        jbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbEditarMousePressed(evt);
            }
        });
        getContentPane().add(jbEditar);
        jbEditar.setBounds(570, 420, 140, 70);

        jbCadastrarDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbCadastrarDepartamento.setText("<html><center>Cadastrar<br/>Departamento</html>");
        jbCadastrarDepartamento.setIconTextGap(0);
        jbCadastrarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCadastrarDepartamentoMousePressed(evt);
            }
        });
        getContentPane().add(jbCadastrarDepartamento);
        jbCadastrarDepartamento.setBounds(570, 80, 140, 70);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("<html><center>Cancelar<br/></html>");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCancelarMousePressed(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(570, 500, 140, 70);

        jtaDescricaoCargo.setColumns(20);
        jtaDescricaoCargo.setRows(5);
        jScrollPane1.setViewportView(jtaDescricaoCargo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(230, 390, 330, 160);

        jlCargosList.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jlCargosList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 90, 180, 150);

        jbCadastrarCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbCadastrarCargo.setText("<html><center>Cadastrar<br/>Cargo</html>");
        jbCadastrarCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCadastrarCargoMousePressed(evt);
            }
        });
        getContentPane().add(jbCadastrarCargo);
        jbCadastrarCargo.setBounds(570, 290, 140, 70);

        jlCargosDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCargosDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCargosDepartamento.setText("Cargos");
        getContentPane().add(jlCargosDepartamento);
        jlCargosDepartamento.setBounds(20, 60, 180, 30);

        jbCancelarDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelarDepartamento.setText("<html><center>Cancelar<br/></html>");
        jbCancelarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCancelarDepartamentoMousePressed(evt);
            }
        });
        getContentPane().add(jbCancelarDepartamento);
        jbCancelarDepartamento.setBounds(570, 160, 140, 70);

        jlDepartamento.setText("Departamento");
        getContentPane().add(jlDepartamento);
        jlDepartamento.setBounds(40, 390, 110, 14);

        jcbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbDepartamentos);
        jcbDepartamentos.setBounds(40, 410, 170, 20);

        jsCadastrarCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Cargo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jsCadastrarCargo);
        jsCadastrarCargo.setBounds(10, 260, 720, 330);

        jsCadastrarDepartamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Departamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jsCadastrarDepartamento);
        jsCadastrarDepartamento.setBounds(10, 50, 720, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarDepartamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarDepartamentoMousePressed
        if (jbCadastrarDepartamento.isEnabled()) {

            if (validaDepartamento(true)) {
                try {
                    if (departamento == null) {
                        cadastrarDepartamento();
                        JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
//                        ZerarCampos();
//                        encerrarInstancia();
//                        cadastroCargoHome.getInstancia().setVisible(true);
//                        cadastroCargoHome.getInstancia().setLocationRelativeTo(this);
//                        cadastroCargoHome.getInstancia().popularTabela();
//                        dispose();
                    } else {
                        cadastrarDepartamento(departamento);
                        JOptionPane.showMessageDialog(this, "Atualização efetuada com sucesso!");
                        ZerarCampos();
                        departamento = null;
                        encerrarInstancia();
                        dispose();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(cadastroCargo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Verifique os campos obrigatórios!");
            }
        }
    }//GEN-LAST:event_jbCadastrarDepartamentoMousePressed

    private void jbCadastrarCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarCargoMousePressed
        if (jbCadastrarCargo.isEnabled()) {

            if (validaCargo(true)) {
                try {
                    if (cargo == null) {
                        cadastrarCargo(departamento);
                        JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
                        ZerarCampos();
                    } else {
                        cadastrarCargo(departamento);
                        JOptionPane.showMessageDialog(this, "Atualização efetuada com sucesso!");
                        ZerarCampos();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(cadastroCargo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Verifique os campos obrigatórios!");
            }

        }
    }//GEN-LAST:event_jbCadastrarCargoMousePressed

    private void jbEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMousePressed
        if (jbEditar.isEnabled()) {
            cadastroCargoHome.getInstancia().DisableEnable(true);
            JOptionPane.showMessageDialog(this, "Campos abertos para edição!");
        }
    }//GEN-LAST:event_jbEditarMousePressed

    private void jbCancelarDepartamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarDepartamentoMousePressed
        if (jbCancelarDepartamento.isEnabled()) {//                   
            String ObjButtons[] = {"Sim", "Não"};
            int PromptResult = JOptionPane.showOptionDialog(this, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
            if (PromptResult == JOptionPane.YES_OPTION) {
                cadastroCargoHome.getInstancia().setVisible(true);
                cadastroCargoHome.getInstancia().setLocationRelativeTo(this);
                cadastroCargoHome.getInstancia().popularTabela();
                dispose();
                encerrarInstancia();
            }
        }
    }//GEN-LAST:event_jbCancelarDepartamentoMousePressed

    private void jbCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMousePressed
        if (jbCancelar.isEnabled()) {
            String ObjButtons[] = {"Sim", "Não"};
            int PromptResult = JOptionPane.showOptionDialog(this, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
            if (PromptResult == JOptionPane.YES_OPTION) {
                cadastroCargoHome.getInstancia().setVisible(true);
                cadastroCargoHome.getInstancia().setLocationRelativeTo(this);
                cadastroCargoHome.getInstancia().popularTabela();
                dispose();
                encerrarInstancia();
            }
        }
    }//GEN-LAST:event_jbCancelarMousePressed

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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCadastrarCargo;
    private javax.swing.JButton jbCadastrarDepartamento;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCancelarDepartamento;
    private javax.swing.JButton jbEditar;
    private javax.swing.JComboBox<String> jcbDepartamentos;
    private javax.swing.JFormattedTextField jftTelefone;
    private javax.swing.JLabel jlCargosDepartamento;
    private javax.swing.JList<String> jlCargosList;
    private javax.swing.JLabel jlCodigoCargo;
    private javax.swing.JLabel jlCodigoDepartamento;
    private javax.swing.JLabel jlDepartamento;
    private javax.swing.JLabel jlDescricaoCargo;
    private javax.swing.JLabel jlNomeCargo;
    private javax.swing.JLabel jlNomeDepartamento;
    private javax.swing.JLabel jlRamal;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JSeparator jsCadastrarCargo;
    private javax.swing.JSeparator jsCadastrarDepartamento;
    private javax.swing.JTextField jtNomeCargo;
    private javax.swing.JTextArea jtaDescricaoCargo;
    private javax.swing.JTextField jtfCodigoCargo;
    private javax.swing.JTextField jtfCodigoDepartamento;
    private javax.swing.JTextField jtfNomeDepartamento;
    private javax.swing.JTextField jtfRamal;
    // End of variables declaration//GEN-END:variables
}
