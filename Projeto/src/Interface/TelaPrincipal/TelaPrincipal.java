/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.TelaPrincipal;

import Interface.CadCliente.cadastroCliente;
import Interface.CadCliente.cadastroClienteHome;
import Interface.CadFuncionario.ControleFuncionario;
import Interface.CadFuncionario.cadastroFuncionario;
import Interface.CadImovel.cadastroImovel;
import Interface.CadImovel.cadastroImovelHome;
import Interface.Locacao.CadLocacao;
import Interface.Locacao.ControleLocacao;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

/**
 *
 * @author Sala
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private static TelaPrincipal instancia;
    private int tentativas = 0;
    private boolean logado = false;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        carregarPrincipal();

    }

    public static TelaPrincipal getInstancia() {
        if (instancia == null) {
            instancia = new TelaPrincipal();
        }
        return instancia;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public void carregarPrincipal() {
        this.setTitle("Sistema de Cadastro de Imóveis");
        this.setExtendedState(MAXIMIZED_BOTH);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
//       
        jSeparator2.setSize(xSize - 300, ySize);
        jSeparator2.setLocation(180, 0);
        jlLogoff.setLocation(xSize - 100, 30);
        jlLogoff.repaint();

        jlTroca.setLocation(xSize - 100, 80);
        jlTroca.repaint();

        jlSair.setLocation(xSize - 100, ySize - 100);
        jlLogoff.repaint();

        jSeparator1.setSize(180, ySize);
        jScrollPane1.setSize(180, ySize - 80);

        jScrollPane1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(true);
        ocultaFuncoes(false);
        if (!isLogado()) {
            Login();
        }
    }

    public void ocultaFuncoes(boolean ativo) {
        jmBarraMenu.setEnabled(ativo);
        jmiCadastrarCliente.setEnabled(ativo);
        jmiCadastrarImovel.setEnabled(ativo);
        jmiCadastrarFuncionario.setEnabled(ativo);
        jmiConsultarCliente.setEnabled(ativo);
        jmiConsultarImovel.setEnabled(ativo);
        jmiConsultarFuncionario.setEnabled(ativo);
        jbCliente.setEnabled(ativo);
        jbImovel.setEnabled(ativo);
        jbFuncionario.setEnabled(ativo);
        jbControleCliente.setEnabled(ativo);
        jbControleImovel.setEnabled(ativo);
        jbControleFuncionario.setEnabled(ativo);
        jbControleLocacao.setEnabled(ativo);
        jbLocacao.setEnabled(ativo);
        jbControleLocacao1.setEnabled(ativo);
        jlLogoff.setEnabled(ativo);
        jlTroca.setEnabled(ativo);

    }

    public void acesso() {
        int nivelAcesso = Sessao.getInstance().getUsuario().getNivelAcesso();
        if (nivelAcesso == 1) {
            System.out.println("Total");
            ocultaFuncoes(true);
        } else if (nivelAcesso == 2) {
            System.out.println("Parcial");
            jmiCadastrarCliente.setEnabled(true);
            jmiCadastrarImovel.setEnabled(true);
            jmiConsultarCliente.setEnabled(true);
            jmiConsultarImovel.setEnabled(true);
            jbCliente.setEnabled(true);
            jbImovel.setEnabled(true);
            jbControleCliente.setEnabled(true);
            jbControleImovel.setEnabled(true);
            jbControleLocacao.setEnabled(true);
            jbLocacao.setEnabled(true);
            jbControleLocacao1.setEnabled(true);
        } else if (nivelAcesso == 3) {
            System.out.println("Reduzido");
            jbCliente.setEnabled(true);
            jbImovel.setEnabled(true);
            jbLocacao.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Nível de acesso não encontrado");
            ocultaFuncoes(false);
        }
    }

    public void Login() {
        if (!isLogado()) {            
            TelaLogin telaLogin = new TelaLogin(new javax.swing.JFrame(), true);
            telaLogin.setLocationRelativeTo(jSeparator2);
            telaLogin.setVisible(true);
            if (telaLogin.verificaLogin()) {
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                setLogado(true);
                jlLogoff.setEnabled(true);
                jlTroca.setEnabled(true);
                acesso();
            } else {
                JOptionPane.showMessageDialog(null, "Acesso negado!\nUsuário ou Senha Incorretos");
                telaLogin.limpaCampos();
                while (!telaLogin.verificaLogin() && tentativas < 5) {
                    telaLogin.setLocationRelativeTo(jSeparator2);
                    telaLogin.setVisible(true);
                    tentativas++;

                    if (!telaLogin.verificaLogin() && tentativas < 5) {
                        telaLogin.limpaCampos();
                        JOptionPane.showMessageDialog(null, "Acesso negado!\nUsuário ou Senha Incorretos");
                        JOptionPane.showMessageDialog(null, "Você possui mais " + (5 - tentativas) + " tentativas!");
                    }
                    if (tentativas == 5) {
                        telaLogin.limpaCampos();
                        JOptionPane.showMessageDialog(null, "Sistema Bloquado!");
                    }
                }
            }
        }
    }

    public void finalizarInstancias() {
        if (cadastroCliente.getInstancia() != null) {
            cadastroCliente.getInstancia().encerrarInstancia();
        }
//        if (cadastroImovel.getInstancia() != null) {
//            cadastroImovel.getInstancia().encerrarInstancia();
//        }
        if (cadastroImovelHome.getInstancia() != null) {
           cadastroImovelHome.getInstancia().encerrarInstancia();
        }
        if (CadLocacao.getInstancia() != null) {
            CadLocacao.getInstancia().encerrarInstancia();
        }
        if (ControleLocacao.getInstancia() != null) {
            ControleLocacao.getInstancia().encerrarInstancia();
        }
        if (cadastroFuncionario.getInstancia() != null) {
            cadastroFuncionario.getInstancia().encerrarInstancia();
        }
        if (ControleFuncionario.getInstancia() != null) {
            ControleFuncionario.getInstancia().encerrarInstancia();
        }

    }
    
    public Component getPosition() {
        return jSeparator2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlSair = new javax.swing.JLabel();
        jlLogoff = new javax.swing.JLabel();
        jlTroca = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jbCliente = new javax.swing.JButton();
        jbImovel = new javax.swing.JButton();
        jbControleCliente = new javax.swing.JButton();
        jbControleImovel = new javax.swing.JButton();
        jbControleFuncionario = new javax.swing.JButton();
        jbLocacao = new javax.swing.JButton();
        jbControleLocacao = new javax.swing.JButton();
        jbControleLocacao1 = new javax.swing.JButton();
        jbFuncionario = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jmBarraMenu = new javax.swing.JMenuBar();
        jmCadastrar = new javax.swing.JMenu();
        jmiCadastrarCliente = new javax.swing.JMenuItem();
        jmiCadastrarImovel = new javax.swing.JMenuItem();
        jmiCadastrarFuncionario = new javax.swing.JMenuItem();
        jmiConsultar = new javax.swing.JMenu();
        jmiConsultarCliente = new javax.swing.JMenuItem();
        jmiConsultarImovel = new javax.swing.JMenuItem();
        jmiConsultarFuncionario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        jlSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        jlSair.setText("<html><center><br/>Sair</html>");
        jlSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlSairMousePressed(evt);
            }
        });
        getContentPane().add(jlSair);
        jlSair.setBounds(930, 530, 120, 40);

        jlLogoff.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoff.png"))); // NOI18N
        jlLogoff.setText("<html><center><br/>Logout</html>");
        jlLogoff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlLogoffMousePressed(evt);
            }
        });
        getContentPane().add(jlLogoff);
        jlLogoff.setBounds(920, 0, 120, 40);

        jlTroca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTroca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kabinet.png"))); // NOI18N
        jlTroca.setText("<html><center>Trocar<br/>Usuário</html>");
        jlTroca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlTrocaMousePressed(evt);
            }
        });
        getContentPane().add(jlTroca);
        jlTroca.setBounds(920, 50, 100, 40);

        jbCliente.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/usuarioadd.png"))); // NOI18N
        jbCliente.setText("<html><center>Cadastrar<br/>Cliente</html>");
        jbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbClienteMousePressed(evt);
            }
        });

        jbImovel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imovel.png"))); // NOI18N
        jbImovel.setText("<html><center>Cadastrar<br/>Imovel</html>");
        jbImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbImovelMousePressed(evt);
            }
        });

        jbControleCliente.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbControleCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_user.png"))); // NOI18N
        jbControleCliente.setText("<html><center>Controle<br/>Cliente</html>");
        jbControleCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbControleClienteMousePressed(evt);
            }
        });

        jbControleImovel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbControleImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imovels.png"))); // NOI18N
        jbControleImovel.setText("<html><center>Controle<br/>Imovel</html>");
        jbControleImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbControleImovelMousePressed(evt);
            }
        });

        jbControleFuncionario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbControleFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login-icon2.png"))); // NOI18N
        jbControleFuncionario.setText("<html><center>Controle<br/>Funcionario</html>");
        jbControleFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbControleFuncionarioMousePressed(evt);
            }
        });

        jbLocacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Partnership-icon.png"))); // NOI18N
        jbLocacao.setText("<html><center>Cadastrar<br/>Locação</html>");
        jbLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbLocacaoMousePressed(evt);
            }
        });

        jbControleLocacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbControleLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House-Rent.png"))); // NOI18N
        jbControleLocacao.setText("<html><center>Controle<br/>Locação</html>");
        jbControleLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbControleLocacaoMousePressed(evt);
            }
        });

        jbControleLocacao1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbControleLocacao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House-Rent.png"))); // NOI18N
        jbControleLocacao1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbControleLocacao1MousePressed(evt);
            }
        });

        jbFuncionario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/funcionario2.png"))); // NOI18N
        jbFuncionario.setText("<html><center>Cadastrar<br/>Funcionario</html>");
        jbFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbFuncionarioMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbControleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbControleImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbControleLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbControleFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbControleLocacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jbControleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbControleImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbControleLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbControleFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbControleLocacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 20, 180, 550);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 0, 180, 750);

        jSeparator2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(180, 0, 840, 620);

        jmCadastrar.setText("Cadastrar");

        jmiCadastrarCliente.setText("Cliente");
        jmCadastrar.add(jmiCadastrarCliente);

        jmiCadastrarImovel.setText("Imóvel");
        jmCadastrar.add(jmiCadastrarImovel);

        jmiCadastrarFuncionario.setText("Funcionário");
        jmCadastrar.add(jmiCadastrarFuncionario);

        jmBarraMenu.add(jmCadastrar);

        jmiConsultar.setText("Consultar");

        jmiConsultarCliente.setText("Cliente");
        jmiConsultar.add(jmiConsultarCliente);

        jmiConsultarImovel.setText("Imóvel");
        jmiConsultar.add(jmiConsultarImovel);

        jmiConsultarFuncionario.setText("Funcionário");
        jmiConsultar.add(jmiConsultarFuncionario);

        jmBarraMenu.add(jmiConsultar);

        setJMenuBar(jmBarraMenu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlSairMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSairMousePressed
        System.exit(0);
    }//GEN-LAST:event_jlSairMousePressed

    private void jlLogoffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlLogoffMousePressed
        if (!isLogado()) {
            jlLogoff.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Logoff efetuado com sucesso!");
            ocultaFuncoes(false);
            finalizarInstancias();
            setLogado(false);
            Login();
        }
    }//GEN-LAST:event_jlLogoffMousePressed

    private void jbClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbClienteMousePressed
        finalizarInstancias();
        cadastroCliente cliente = cadastroCliente.getInstancia();
        cliente.setLocationRelativeTo(jSeparator2);
        cliente.setVisible(true);
    }//GEN-LAST:event_jbClienteMousePressed

    private void jbImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbImovelMousePressed
        finalizarInstancias();
        cadastroImovel imovel = cadastroImovel.getInstancia();
        imovel.setLocationRelativeTo(jSeparator2);
        imovel.setVisible(true);
    }//GEN-LAST:event_jbImovelMousePressed

    private void jbControleClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleClienteMousePressed
        finalizarInstancias();
        cadastroClienteHome clienteHome = cadastroClienteHome.getInstancia();
        clienteHome.setLocationRelativeTo(jSeparator2);
        clienteHome.setVisible(true);
    }//GEN-LAST:event_jbControleClienteMousePressed

    private void jbControleImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleImovelMousePressed
        finalizarInstancias();
        cadastroImovelHome imovelHome = cadastroImovelHome.getInstancia();
        imovelHome.setLocationRelativeTo(jSeparator2);
        imovelHome.setVisible(true);
    }//GEN-LAST:event_jbControleImovelMousePressed

    private void jbLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLocacaoMousePressed
        finalizarInstancias();
        CadLocacao locacao = CadLocacao.getInstancia();
        locacao.setLocationRelativeTo(jSeparator2);
        locacao.setVisible(true);
    }//GEN-LAST:event_jbLocacaoMousePressed

    private void jbControleLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleLocacaoMousePressed
        finalizarInstancias();
        ControleLocacao controleLocacao = ControleLocacao.getInstancia();
        controleLocacao.setLocationRelativeTo(jSeparator2);
        controleLocacao.setVisible(true);
    }//GEN-LAST:event_jbControleLocacaoMousePressed

    private void jbFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbFuncionarioMousePressed
        finalizarInstancias();
        cadastroFuncionario funcionario = cadastroFuncionario.getInstancia();
        funcionario.setLocationRelativeTo(jSeparator2);
        funcionario.setVisible(true);
    }//GEN-LAST:event_jbFuncionarioMousePressed

    private void jbControleFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleFuncionarioMousePressed
        finalizarInstancias();
        ControleFuncionario controleFuncionario = ControleFuncionario.getInstancia();
        controleFuncionario.setLocationRelativeTo(jSeparator2);
        controleFuncionario.setVisible(true);
    }//GEN-LAST:event_jbControleFuncionarioMousePressed

    private void jbControleLocacao1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleLocacao1MousePressed

    }//GEN-LAST:event_jbControleLocacao1MousePressed

    private void jlTrocaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlTrocaMousePressed
        if (!isLogado()) {
            jlTroca.setEnabled(false);
        } else {
            setLogado(false);
            Login();
        }
    }//GEN-LAST:event_jlTrocaMousePressed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbCliente;
    private javax.swing.JButton jbControleCliente;
    private javax.swing.JButton jbControleFuncionario;
    private javax.swing.JButton jbControleImovel;
    private javax.swing.JButton jbControleLocacao;
    private javax.swing.JButton jbControleLocacao1;
    private javax.swing.JButton jbFuncionario;
    private javax.swing.JButton jbImovel;
    private javax.swing.JButton jbLocacao;
    private javax.swing.JLabel jlLogoff;
    private javax.swing.JLabel jlSair;
    private javax.swing.JLabel jlTroca;
    private javax.swing.JMenuBar jmBarraMenu;
    private javax.swing.JMenu jmCadastrar;
    private javax.swing.JMenuItem jmiCadastrarCliente;
    private javax.swing.JMenuItem jmiCadastrarFuncionario;
    private javax.swing.JMenuItem jmiCadastrarImovel;
    private javax.swing.JMenu jmiConsultar;
    private javax.swing.JMenuItem jmiConsultarCliente;
    private javax.swing.JMenuItem jmiConsultarFuncionario;
    private javax.swing.JMenuItem jmiConsultarImovel;
    // End of variables declaration//GEN-END:variables
}
