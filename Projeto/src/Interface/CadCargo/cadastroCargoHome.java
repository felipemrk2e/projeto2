/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadCargo;

import Interface.TelaPrincipal.Sessao;
import dao.CargoDAO;
import dao.DepartamentoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.TableModel.CargoTableModel;
import model.TableModel.DepartamentoTableModel;
import model.pessoa.Cargo;
import model.pessoa.Departamento;

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
      //  this.setUndecorated(true);
        initComponents();
      //  setAlwaysOnTop(true);
        this.setTitle("Consulta de Departamento");
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
        popularTabela();
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

    public void DisableEnable(boolean b) {
        jtfCodigoCargo.setEnabled(b);
        jtfCodigoDepartamento.setEnabled(b);
        jbVisualizarCargo.setEnabled(b);
        jbRemoverCargo.setEnabled(b);
        jbPesquisarCargo.setEnabled(b);
        jbVisualizarDepartamento.setEnabled(b);
        jbRemoverDepartamento.setEnabled(b);
        jbPesquisarDepartamento.setEnabled(b);
        jtfNomeCargo.setEnabled(b);
        jtfNomeDepartamento.setEnabled(b);
        jtDepartamento.setEnabled(b);
        jtCargo.setEnabled(b);
    }

    public void popularTabela() {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> listaDepartamento = departamentoDAO.getAll();
        jtDepartamento.setModel(new DepartamentoTableModel(listaDepartamento));

        CargoDAO cargoDAO = new CargoDAO();
        List<Cargo> listaCargos = cargoDAO.getAll();
        jtCargo.setModel(new CargoTableModel(listaCargos));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlCodigoCargo = new javax.swing.JLabel();
        jtfCodigoCargo = new javax.swing.JTextField();
        jlCodigoDepartamento = new javax.swing.JLabel();
        jtfCodigoDepartamento = new javax.swing.JTextField();
        jbVisualizarCargo = new javax.swing.JButton();
        jbRemoverCargo = new javax.swing.JButton();
        jbPesquisarCargo = new javax.swing.JButton();
        jbVisualizarDepartamento = new javax.swing.JButton();
        jbRemoverDepartamento = new javax.swing.JButton();
        jbPesquisarDepartamento = new javax.swing.JButton();
        jtfNomeCargo = new javax.swing.JTextField();
        jtfNomeDepartamento = new javax.swing.JTextField();
        jlNomeCargo = new javax.swing.JLabel();
        jlNomeDepartamento = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtDepartamento = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCargo = new javax.swing.JTable();
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
        jlCodigoDepartamento.setBounds(60, 300, 140, 30);
        getContentPane().add(jtfCodigoDepartamento);
        jtfCodigoDepartamento.setBounds(60, 330, 140, 30);

        jbVisualizarCargo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbVisualizarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.png"))); // NOI18N
        jbVisualizarCargo.setText("<html><center>Visualizar<br>Cargo</center></html>");
        jbVisualizarCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbVisualizarCargoMousePressed(evt);
            }
        });
        getContentPane().add(jbVisualizarCargo);
        jbVisualizarCargo.setBounds(790, 50, 140, 70);

        jbRemoverCargo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbRemoverCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove2.png"))); // NOI18N
        jbRemoverCargo.setText("<html><center>Remover<br>Cargo</center></html>");
        jbRemoverCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbRemoverCargoMousePressed(evt);
            }
        });
        getContentPane().add(jbRemoverCargo);
        jbRemoverCargo.setBounds(790, 130, 140, 70);

        jbPesquisarCargo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbPesquisarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisarCargo.setText("<html><center>Pesquisar<br>Cargo</center></html>");
        jbPesquisarCargo.setToolTipText("");
        getContentPane().add(jbPesquisarCargo);
        jbPesquisarCargo.setBounds(790, 210, 140, 70);

        jbVisualizarDepartamento.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbVisualizarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.png"))); // NOI18N
        jbVisualizarDepartamento.setText("<html><center>Visualizar<br>Departamento</center></html>");
        jbVisualizarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbVisualizarDepartamentoMousePressed(evt);
            }
        });
        getContentPane().add(jbVisualizarDepartamento);
        jbVisualizarDepartamento.setBounds(790, 330, 140, 70);

        jbRemoverDepartamento.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbRemoverDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove2.png"))); // NOI18N
        jbRemoverDepartamento.setText("<html><center>Remover<br>Departamento</center></html>");
        jbRemoverDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbRemoverDepartamentoMousePressed(evt);
            }
        });
        getContentPane().add(jbRemoverDepartamento);
        jbRemoverDepartamento.setBounds(790, 410, 140, 70);

        jbPesquisarDepartamento.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbPesquisarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/review.png"))); // NOI18N
        jbPesquisarDepartamento.setText("<html><center>Pesquisar<br>Departamento</center></html>");
        getContentPane().add(jbPesquisarDepartamento);
        jbPesquisarDepartamento.setBounds(790, 490, 140, 70);
        getContentPane().add(jtfNomeCargo);
        jtfNomeCargo.setBounds(330, 240, 430, 30);
        getContentPane().add(jtfNomeDepartamento);
        jtfNomeDepartamento.setBounds(380, 520, 380, 30);

        jlNomeCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeCargo.setText("Nome Cargo");
        getContentPane().add(jlNomeCargo);
        jlNomeCargo.setBounds(240, 240, 90, 30);

        jlNomeDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeDepartamento.setText("Nome Departamento");
        getContentPane().add(jlNomeDepartamento);
        jlNomeDepartamento.setBounds(240, 520, 130, 30);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCancelarMousePressed(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(790, 570, 140, 70);

        jtDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jtDepartamento);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(230, 330, 530, 150);

        jtCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtCargo);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(230, 50, 530, 150);

        jSeparator2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de Cargo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(210, 20, 740, 270);

        jSeparator3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de Departamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(210, 300, 740, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoCargoActionPerformed

    private void jbCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMousePressed
        if (jbCancelar.isEnabled()) {
            String ObjButtons[] = {"Sim", "Não"};
            int PromptResult = JOptionPane.showOptionDialog(this, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
            if (PromptResult == JOptionPane.YES_OPTION) {
                dispose();
                encerrarInstancia();
            }
        }
    }//GEN-LAST:event_jbCancelarMousePressed

    private void jbVisualizarCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVisualizarCargoMousePressed
        if (jbVisualizarCargo.isEnabled()) {
             cadastroCargo.getInstancia().encerrarInstancia();
            int linhaSelecionada = jtCargo.getSelectedRow();
            if (linhaSelecionada == -1) {
                return; //Nada selecionado
            }
            CargoTableModel cargoModel = (CargoTableModel) jtCargo.getModel();
            Cargo cargoSelecionado = cargoModel.get(linhaSelecionada);
            cadastroCargo.getInstancia().cargo = cargoSelecionado;
            cadastroCargo.getInstancia().departamento = cargoSelecionado.getDepartamento();
            setLocationRelativeTo(this);
            cadastroCargo.getInstancia().atualizarDepartamento(cargoSelecionado.getDepartamento());
            cadastroCargo.getInstancia().atualizaCargo(cargoSelecionado);
            cadastroCargo.getInstancia().setVisible(true);
            cadastroCargo.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            //cadastroCargo.getInstancia().DisableEnable(false);
            cadastroCargo.getInstancia().jbEditar.setEnabled(false);
            cadastroCargo.getInstancia().setLocationRelativeTo(this);
            cadastroCargo.getInstancia().setAlwaysOnTop(true);
        }
    }//GEN-LAST:event_jbVisualizarCargoMousePressed

    private void jbVisualizarDepartamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVisualizarDepartamentoMousePressed
        if (jbVisualizarDepartamento.isEnabled()) {
            cadastroCargo.getInstancia().encerrarInstancia();
            int linhaSelecionada = jtDepartamento.getSelectedRow();
            if (linhaSelecionada == -1) {
                return; //Nada selecionado
            }
            DepartamentoTableModel departamentoModel = (DepartamentoTableModel) jtDepartamento.getModel();
            Departamento departamentoSelecionado = departamentoModel.get(linhaSelecionada);
            cadastroCargo.getInstancia().departamento = departamentoSelecionado;
            setLocationRelativeTo(this);
            cadastroCargo.getInstancia().atualizarDepartamento(departamentoSelecionado);
            cadastroCargo.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            cadastroCargo.getInstancia().setVisible(true);
           // cadastroCargo.getInstancia().DisableEnable(false);
            cadastroCargo.getInstancia().jbEditar.setEnabled(false);
            cadastroCargo.getInstancia().setLocationRelativeTo(this);
            cadastroCargo.getInstancia().setAlwaysOnTop(true);
        }
    }//GEN-LAST:event_jbVisualizarDepartamentoMousePressed

    private void jbRemoverCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRemoverCargoMousePressed
        if (jbRemoverCargo.isEnabled()) {
            int linhaSelecionada = jtCargo.getSelectedRow();
            if (linhaSelecionada == -1) {
                return; //Nada selecionado
            }
            CargoTableModel cargoModel = (CargoTableModel) jtCargo.getModel();
            Cargo cargoSelecionado = cargoModel.get(linhaSelecionada);
            CargoDAO cargoDAO = new CargoDAO();
            cargoDAO.removeById(cargoSelecionado.getIdCargo());
            cargoModel.removeRow(linhaSelecionada);
        } 
    }//GEN-LAST:event_jbRemoverCargoMousePressed

    private void jbRemoverDepartamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRemoverDepartamentoMousePressed
        if (jbRemoverDepartamento.isEnabled()) {
            int linhaSelecionada = jtDepartamento.getSelectedRow();
            if (linhaSelecionada == -1) {
                return; //Nada selecionado
            }
            DepartamentoTableModel departamentoModel = (DepartamentoTableModel) jtDepartamento.getModel();
            Departamento departamentoSelecionado = departamentoModel.get(linhaSelecionada);
            DepartamentoDAO departamentoDAO = new DepartamentoDAO();
            departamentoDAO.removeById(departamentoSelecionado.getIdDepartamento());
            departamentoModel.removeRow(linhaSelecionada);
        } 
    }//GEN-LAST:event_jbRemoverDepartamentoMousePressed

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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbPesquisarCargo;
    private javax.swing.JButton jbPesquisarDepartamento;
    private javax.swing.JButton jbRemoverCargo;
    private javax.swing.JButton jbRemoverDepartamento;
    private javax.swing.JButton jbVisualizarCargo;
    private javax.swing.JButton jbVisualizarDepartamento;
    private javax.swing.JLabel jlCodigoCargo;
    private javax.swing.JLabel jlCodigoDepartamento;
    private javax.swing.JLabel jlNomeCargo;
    private javax.swing.JLabel jlNomeDepartamento;
    private javax.swing.JTable jtCargo;
    private javax.swing.JTable jtDepartamento;
    private javax.swing.JTextField jtfCodigoCargo;
    private javax.swing.JTextField jtfCodigoDepartamento;
    private javax.swing.JTextField jtfNomeCargo;
    private javax.swing.JTextField jtfNomeDepartamento;
    // End of variables declaration//GEN-END:variables
}
