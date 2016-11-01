/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.TelaPrincipal;

import Interface.CadCliente.cadastroCliente;
import Interface.CadCliente.cadastroClienteHome;
import Interface.CadFuncionario.CadFuncionarioHome;
import Interface.CadFuncionario.ControleFuncionario;
import Interface.CadFuncionario.cadastroFuncionario;
import Interface.CadImovel.cadastroImovel;
import Interface.CadImovel.cadastroImovelHome;
import Interface.Locacao.CadLocacao;
import Interface.Locacao.CadLocacaoHome;
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
        jbCadastrarCliente.setEnabled(ativo);
        jbCadastrarImovel.setEnabled(ativo);
        jbControleCliente.setEnabled(ativo);
        jbControleImovel.setEnabled(ativo);
        jbControleFuncionario.setEnabled(ativo);
        jbCadastrarLocacao.setEnabled(ativo);
        jbControleLocacao.setEnabled(ativo);
        jbConsultarLocacao.setEnabled(ativo);
        jbFuncionario.setEnabled(ativo);
        jbConsultarFuncionario.setEnabled(ativo);

        jmCadastrar.setEnabled(ativo);
        jmiCadastrarCliente.setEnabled(ativo);
        jmiCadastrarImovel.setEnabled(ativo);

        jmConsultar.setEnabled(ativo);
        jmiConsultarCliente.setEnabled(ativo);
        jmiConsultarImovel.setEnabled(ativo);

        jmLocacao.setEnabled(ativo);
        jmiCadastrarLocacao.setEnabled(ativo);
        jmiConsultarLocacao.setEnabled(ativo);
        jmiControleLocacao.setEnabled(ativo);

        jmFuncionario.setEnabled(ativo);
        jmiCadastrarFuncionario.setEnabled(ativo);
        jmiConsultarFuncionario.setEnabled(ativo);
        jmiControleFuncionario.setEnabled(ativo);

        jmSessao.setEnabled(ativo);
        jmiTrocarUsuario.setEnabled(ativo);
        jmiLogoff.setEnabled(ativo);

        jlTroca.setEnabled(ativo);
        jlLogoff.setEnabled(ativo);
    }

    public void acesso() {
        ocultaFuncoes(false);
        int nivelAcesso = Sessao.getInstance().getUsuario().getNivelAcesso();
        if (nivelAcesso == 1) {
            System.out.println("Total");
            ocultaFuncoes(true);
        } else if (nivelAcesso == 2) {
            System.out.println("Parcial");
            ocultaFuncoes(false);
            jbCadastrarCliente.setEnabled(true);
            jbCadastrarImovel.setEnabled(true);
            jbControleCliente.setEnabled(true);
            jbControleImovel.setEnabled(true);
            jbCadastrarLocacao.setEnabled(true);
            jbControleLocacao.setEnabled(true);
            jbConsultarLocacao.setEnabled(true);

            jmCadastrar.setEnabled(true);
            jmiCadastrarCliente.setEnabled(true);
            jmiCadastrarImovel.setEnabled(true);

            jmConsultar.setEnabled(true);
            jmiConsultarCliente.setEnabled(true);
            jmiConsultarImovel.setEnabled(true);

            jmLocacao.setEnabled(true);
            jmiCadastrarLocacao.setEnabled(true);
            jmiConsultarLocacao.setEnabled(true);
            jmiControleLocacao.setEnabled(true);

            jmSessao.setEnabled(true);
            jmiTrocarUsuario.setEnabled(true);
            jmiLogoff.setEnabled(true);

            jlTroca.setEnabled(true);
            jlLogoff.setEnabled(true);
        } else if (nivelAcesso == 3) {
            ocultaFuncoes(false);
            System.out.println("Reduzido");
            jbControleCliente.setEnabled(true);
            jbControleImovel.setEnabled(true);
            jbConsultarLocacao.setEnabled(true);

            jmConsultar.setEnabled(true);
            jmiConsultarCliente.setEnabled(true);
            jmiConsultarImovel.setEnabled(true);

            jmLocacao.setEnabled(true);
            jmiConsultarLocacao.setEnabled(true);

            jmSessao.setEnabled(true);
            jmiTrocarUsuario.setEnabled(true);
            jmiLogoff.setEnabled(true);

            jlTroca.setEnabled(true);
            jlLogoff.setEnabled(true);
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

    public void trocarUsuario() {
        TelaLogin telaLogin = new TelaLogin(new javax.swing.JFrame(), true);
        telaLogin.setLocationRelativeTo(this);
        telaLogin.setAlwaysOnTop(true);
        telaLogin.setVisible(true);
        if (telaLogin.verificaLogin()) {
            JOptionPane.showMessageDialog(telaLogin, "Login efetuado com sucesso!");
            setLogado(true);
            acesso();
            finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        } else {
            JOptionPane.showMessageDialog(telaLogin, "Acesso negado!\nUsuário ou Senha Incorretos");
            telaLogin.limpaCampos();
            while (!telaLogin.verificaLogin() && tentativas < 2) {
                telaLogin.setVisible(true);
                tentativas++;

                if (!telaLogin.verificaLogin() && tentativas < 2) {
                    telaLogin.limpaCampos();
                    JOptionPane.showMessageDialog(telaLogin, "Acesso negado!\nUsuário ou Senha Incorretos");
                    JOptionPane.showMessageDialog(telaLogin, "Você possui mais " + (5 - tentativas) + " tentativas!");
                }
                if (tentativas == 2) {
                    telaLogin.limpaCampos();
                    JOptionPane.showMessageDialog(telaLogin, "Sistema Bloquado!");
                }
            }
        }
    }

    public void finalizaInstanciasNivel(int nivel) {
        switch (nivel) {
            case 1:
                break;
            case 2:
                if (cadastroFuncionario.getInstancia() != null) {
                    cadastroFuncionario.getInstancia().setAlwaysOnTop(false);
                    cadastroFuncionario.getInstancia().encerrarInstancia();
                }
                if (ControleFuncionario.getInstancia() != null) {
                    ControleFuncionario.getInstancia().setAlwaysOnTop(false);
                    ControleFuncionario.getInstancia().encerrarInstancia();
                }
                break;
            case 3:
                if (cadastroCliente.getInstancia() != null) {
                    System.out.println("Encerrou Instancia Cliente por Nível ===================================");
                    cadastroCliente.getInstancia().setVisible(false);
                    cadastroCliente.getInstancia().setAlwaysOnTop(false);
                    cadastroCliente.getInstancia().encerrarInstancia();
                }
//        if (cadastroImovel.getInstancia() != null) {
//            cadastroImovel.getInstancia().setAlwaysOnTop(false);
//            cadastroImovel.getInstancia().encerrarInstancia();
//        }
                if (CadLocacao.getInstancia() != null) {
                    CadLocacao.getInstancia().setAlwaysOnTop(false);
                    CadLocacao.getInstancia().encerrarInstancia();
                }
                if (ControleLocacao.getInstancia() != null) {
                    ControleLocacao.getInstancia().setAlwaysOnTop(false);
                    ControleLocacao.getInstancia().encerrarInstancia();
                }

                break;
            default:
                JOptionPane.showMessageDialog(null, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void finalizarInstancias() {
        if (cadastroCliente.getInstancia() != null) {
            cadastroCliente.getInstancia().setVisible(false);
            cadastroCliente.getInstancia().setAlwaysOnTop(false);
            cadastroCliente.getInstancia().encerrarInstancia();
        }
//        if (cadastroImovel.getInstancia() != null) {
//            cadastroImovel.getInstancia().setAlwaysOnTop(false);
//            cadastroImovel.getInstancia().encerrarInstancia();
//        }
        if (cadastroImovelHome.getInstancia() != null) {
            cadastroImovelHome.getInstancia().setAlwaysOnTop(false);
            cadastroImovelHome.getInstancia().encerrarInstancia();
        }
        if (CadLocacao.getInstancia() != null) {
            CadLocacao.getInstancia().setAlwaysOnTop(false);
            CadLocacao.getInstancia().encerrarInstancia();
        }
        if (ControleLocacao.getInstancia() != null) {
            ControleLocacao.getInstancia().setAlwaysOnTop(false);
            ControleLocacao.getInstancia().encerrarInstancia();
        }
        if (cadastroFuncionario.getInstancia() != null) {
            cadastroFuncionario.getInstancia().setAlwaysOnTop(false);
            cadastroFuncionario.getInstancia().encerrarInstancia();
        }
        if (ControleFuncionario.getInstancia() != null) {
            ControleFuncionario.getInstancia().setAlwaysOnTop(false);
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
        jbCadastrarCliente = new javax.swing.JButton();
        jbCadastrarImovel = new javax.swing.JButton();
        jbControleCliente = new javax.swing.JButton();
        jbControleImovel = new javax.swing.JButton();
        jbControleFuncionario = new javax.swing.JButton();
        jbCadastrarLocacao = new javax.swing.JButton();
        jbControleLocacao = new javax.swing.JButton();
        jbConsultarLocacao = new javax.swing.JButton();
        jbFuncionario = new javax.swing.JButton();
        jbConsultarFuncionario = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jmBarraMenu = new javax.swing.JMenuBar();
        jmCadastrar = new javax.swing.JMenu();
        jmiCadastrarCliente = new javax.swing.JMenuItem();
        jmiCadastrarImovel = new javax.swing.JMenuItem();
        jmConsultar = new javax.swing.JMenu();
        jmiConsultarCliente = new javax.swing.JMenuItem();
        jmiConsultarImovel = new javax.swing.JMenuItem();
        jmLocacao = new javax.swing.JMenu();
        jmiCadastrarLocacao = new javax.swing.JMenuItem();
        jmiConsultarLocacao = new javax.swing.JMenuItem();
        jmiControleLocacao = new javax.swing.JMenuItem();
        jmFuncionario = new javax.swing.JMenu();
        jmiCadastrarFuncionario = new javax.swing.JMenuItem();
        jmiConsultarFuncionario = new javax.swing.JMenuItem();
        jmiControleFuncionario = new javax.swing.JMenuItem();
        jmSessao = new javax.swing.JMenu();
        jmiTrocarUsuario = new javax.swing.JMenuItem();
        jmiLogoff = new javax.swing.JMenuItem();

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

        jbCadastrarCliente.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/usuarioadd.png"))); // NOI18N
        jbCadastrarCliente.setText("<html><center>Cadastrar<br/>Cliente</html>");
        jbCadastrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCadastrarClienteMousePressed(evt);
            }
        });

        jbCadastrarImovel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbCadastrarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imovel.png"))); // NOI18N
        jbCadastrarImovel.setText("<html><center>Cadastrar<br/>Imovel</html>");
        jbCadastrarImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCadastrarImovelMousePressed(evt);
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

        jbCadastrarLocacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbCadastrarLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Partnership-icon.png"))); // NOI18N
        jbCadastrarLocacao.setText("<html><center>Cadastrar<br/>Locação</html>");
        jbCadastrarLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCadastrarLocacaoMousePressed(evt);
            }
        });

        jbControleLocacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbControleLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/immobili_ico.png"))); // NOI18N
        jbControleLocacao.setText("<html><center>Controle<br/>Locação</html>");
        jbControleLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbControleLocacaoMousePressed(evt);
            }
        });

        jbConsultarLocacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbConsultarLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House-Rent.png"))); // NOI18N
        jbConsultarLocacao.setText("<html><center>Consultar<br/>Locação</html>");
        jbConsultarLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbConsultarLocacaoMousePressed(evt);
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

        jbConsultarFuncionario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbConsultarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/funcionarios.png"))); // NOI18N
        jbConsultarFuncionario.setText("<html><center>Consultar<br/>Funcionario</html>");
        jbConsultarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbConsultarFuncionarioMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbControleLocacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbConsultarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbControleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbControleImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCadastrarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCadastrarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbControleFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbConsultarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jbControleCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCadastrarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbControleImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCadastrarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbConsultarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbControleLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbConsultarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbControleFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
        jmiCadastrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiCadastrarClienteMousePressed(evt);
            }
        });
        jmCadastrar.add(jmiCadastrarCliente);

        jmiCadastrarImovel.setText("Imóvel");
        jmiCadastrarImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiCadastrarImovelMousePressed(evt);
            }
        });
        jmCadastrar.add(jmiCadastrarImovel);

        jmBarraMenu.add(jmCadastrar);

        jmConsultar.setText("Consultar");

        jmiConsultarCliente.setText("Cliente");
        jmiConsultarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiConsultarClienteMousePressed(evt);
            }
        });
        jmConsultar.add(jmiConsultarCliente);

        jmiConsultarImovel.setText("Imóvel");
        jmiConsultarImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiConsultarImovelMousePressed(evt);
            }
        });
        jmConsultar.add(jmiConsultarImovel);

        jmBarraMenu.add(jmConsultar);

        jmLocacao.setText("Locação");

        jmiCadastrarLocacao.setText("Cadastrar Locação");
        jmiCadastrarLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiCadastrarLocacaoMousePressed(evt);
            }
        });
        jmLocacao.add(jmiCadastrarLocacao);

        jmiConsultarLocacao.setText("Consultar Locação");
        jmiConsultarLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiConsultarLocacaoMousePressed(evt);
            }
        });
        jmLocacao.add(jmiConsultarLocacao);

        jmiControleLocacao.setText("Controle Locação");
        jmiControleLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiControleLocacaoMousePressed(evt);
            }
        });
        jmLocacao.add(jmiControleLocacao);

        jmBarraMenu.add(jmLocacao);

        jmFuncionario.setText("Funcionário");

        jmiCadastrarFuncionario.setText("Cadastrar Funcionário");
        jmiCadastrarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiCadastrarFuncionarioMousePressed(evt);
            }
        });
        jmFuncionario.add(jmiCadastrarFuncionario);

        jmiConsultarFuncionario.setText("Consultar Funcionário");
        jmiConsultarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiConsultarFuncionarioMousePressed(evt);
            }
        });
        jmFuncionario.add(jmiConsultarFuncionario);

        jmiControleFuncionario.setText("Controle Funcionário");
        jmiControleFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiControleFuncionarioMousePressed(evt);
            }
        });
        jmFuncionario.add(jmiControleFuncionario);

        jmBarraMenu.add(jmFuncionario);

        jmSessao.setText("Sessão");

        jmiTrocarUsuario.setText("Trocar Usuário");
        jmiTrocarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiTrocarUsuarioMousePressed(evt);
            }
        });
        jmSessao.add(jmiTrocarUsuario);

        jmiLogoff.setText("Logoff");
        jmSessao.add(jmiLogoff);

        jmBarraMenu.add(jmSessao);

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

    private void jbCadastrarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarClienteMousePressed
        if (jbCadastrarCliente.isEnabled()) {
            finalizarInstancias();
            cadastroCliente cliente = cadastroCliente.getInstancia();
            cliente.setLocationRelativeTo(jSeparator2);
            cliente.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            cliente.setVisible(true);
        }
    }//GEN-LAST:event_jbCadastrarClienteMousePressed

    private void jbCadastrarImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarImovelMousePressed
        if (jbCadastrarImovel.isEnabled()) {
            finalizarInstancias();
            cadastroImovel imovel = cadastroImovel.getInstancia();
            imovel.setLocationRelativeTo(jSeparator2);
            imovel.setVisible(true);
        }
    }//GEN-LAST:event_jbCadastrarImovelMousePressed

    private void jbControleClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleClienteMousePressed
        if (jbControleCliente.isEnabled()) {
            finalizarInstancias();
            cadastroClienteHome clienteHome = cadastroClienteHome.getInstancia();
            clienteHome.setLocationRelativeTo(jSeparator2);
            clienteHome.setVisible(true);
        }
    }//GEN-LAST:event_jbControleClienteMousePressed

    private void jbControleImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleImovelMousePressed
        if (jbControleImovel.isEnabled()) {
            finalizarInstancias();
            cadastroImovelHome imovelHome = cadastroImovelHome.getInstancia();
            imovelHome.setLocationRelativeTo(jSeparator2);
            imovelHome.setVisible(true);
        }
    }//GEN-LAST:event_jbControleImovelMousePressed

    private void jbCadastrarLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarLocacaoMousePressed
        if (jbCadastrarLocacao.isEnabled()) {
            finalizarInstancias();
            CadLocacao locacao = CadLocacao.getInstancia();
            locacao.setLocationRelativeTo(jSeparator2);
            locacao.setVisible(true);
        }
    }//GEN-LAST:event_jbCadastrarLocacaoMousePressed

    private void jbControleLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleLocacaoMousePressed
        if (jbControleLocacao.isEnabled()) {
            finalizarInstancias();
            ControleLocacao controleLocacao = ControleLocacao.getInstancia();
            controleLocacao.setLocationRelativeTo(jSeparator2);
            controleLocacao.setVisible(true);
        }
    }//GEN-LAST:event_jbControleLocacaoMousePressed

    private void jbFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbFuncionarioMousePressed
        if (jbFuncionario.isEnabled()) {
            finalizarInstancias();
            cadastroFuncionario funcionario = cadastroFuncionario.getInstancia();
            funcionario.setLocationRelativeTo(jSeparator2);
            funcionario.setVisible(true);
        }
    }//GEN-LAST:event_jbFuncionarioMousePressed

    private void jbControleFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleFuncionarioMousePressed
        if (jbControleFuncionario.isEnabled()) {
            finalizarInstancias();
            ControleFuncionario controleFuncionario = ControleFuncionario.getInstancia();
            controleFuncionario.setLocationRelativeTo(jSeparator2);
            controleFuncionario.setVisible(true);
        }
    }//GEN-LAST:event_jbControleFuncionarioMousePressed

    private void jbConsultarLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConsultarLocacaoMousePressed
        if (jbConsultarLocacao.isEnabled()) {
            finalizarInstancias();
            CadLocacaoHome cadLocacaoHome = CadLocacaoHome.getInstancia();
            cadLocacaoHome.setLocationRelativeTo(jSeparator2);
            cadLocacaoHome.setVisible(true);
        }

    }//GEN-LAST:event_jbConsultarLocacaoMousePressed

    private void jlTrocaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlTrocaMousePressed
        trocarUsuario();
    }//GEN-LAST:event_jlTrocaMousePressed

    private void jmiCadastrarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCadastrarClienteMousePressed
        finalizarInstancias();
        cadastroCliente cliente = cadastroCliente.getInstancia();
        cliente.setLocationRelativeTo(jSeparator2);
        cliente.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarClienteMousePressed

    private void jmiCadastrarImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCadastrarImovelMousePressed
        finalizarInstancias();
        cadastroImovel imovel = cadastroImovel.getInstancia();
        imovel.setLocationRelativeTo(jSeparator2);
        imovel.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarImovelMousePressed

    private void jmiCadastrarFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCadastrarFuncionarioMousePressed
        finalizarInstancias();
        cadastroFuncionario funcionario = cadastroFuncionario.getInstancia();
        funcionario.setLocationRelativeTo(jSeparator2);
        funcionario.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarFuncionarioMousePressed

    private void jmiConsultarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiConsultarClienteMousePressed
        finalizarInstancias();
        cadastroClienteHome clienteHome = cadastroClienteHome.getInstancia();
        clienteHome.setLocationRelativeTo(jSeparator2);
        clienteHome.setVisible(true);
    }//GEN-LAST:event_jmiConsultarClienteMousePressed

    private void jmiConsultarImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiConsultarImovelMousePressed
        finalizarInstancias();
        cadastroImovelHome imovelHome = cadastroImovelHome.getInstancia();
        imovelHome.setLocationRelativeTo(jSeparator2);
        imovelHome.setVisible(true);
    }//GEN-LAST:event_jmiConsultarImovelMousePressed

    private void jmiConsultarFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiConsultarFuncionarioMousePressed
        finalizarInstancias();
        CadFuncionarioHome cadFuncionarioHome = CadFuncionarioHome.getInstancia();
        cadFuncionarioHome.setLocationRelativeTo(jSeparator2);
        cadFuncionarioHome.setVisible(true);
    }//GEN-LAST:event_jmiConsultarFuncionarioMousePressed

    private void jmiControleFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiControleFuncionarioMousePressed
        finalizarInstancias();
        ControleFuncionario controleFuncionario = ControleFuncionario.getInstancia();
        controleFuncionario.setLocationRelativeTo(jSeparator2);
        controleFuncionario.setVisible(true);
    }//GEN-LAST:event_jmiControleFuncionarioMousePressed

    private void jmiCadastrarLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCadastrarLocacaoMousePressed
        finalizarInstancias();
        CadLocacao locacao = CadLocacao.getInstancia();
        locacao.setLocationRelativeTo(jSeparator2);
        locacao.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarLocacaoMousePressed

    private void jmiConsultarLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiConsultarLocacaoMousePressed
        finalizarInstancias();
        CadLocacaoHome cadLocacaoHome = CadLocacaoHome.getInstancia();
        cadLocacaoHome.setLocationRelativeTo(jSeparator2);
        cadLocacaoHome.setVisible(true);
    }//GEN-LAST:event_jmiConsultarLocacaoMousePressed

    private void jmiControleLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiControleLocacaoMousePressed
        finalizarInstancias();
        ControleLocacao controleLocacao = ControleLocacao.getInstancia();
        controleLocacao.setLocationRelativeTo(jSeparator2);
        controleLocacao.setVisible(true);
    }//GEN-LAST:event_jmiControleLocacaoMousePressed

    private void jbConsultarFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConsultarFuncionarioMousePressed
        if (jbConsultarFuncionario.isEnabled()) {
        finalizarInstancias();
        CadFuncionarioHome cadFuncionarioHome = CadFuncionarioHome.getInstancia();
        cadFuncionarioHome.setLocationRelativeTo(jSeparator2);
        cadFuncionarioHome.setVisible(true);
        }
    }//GEN-LAST:event_jbConsultarFuncionarioMousePressed

    private void jmiTrocarUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiTrocarUsuarioMousePressed
        trocarUsuario();

    }//GEN-LAST:event_jmiTrocarUsuarioMousePressed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jbCadastrarCliente;
    private javax.swing.JButton jbCadastrarImovel;
    private javax.swing.JButton jbCadastrarLocacao;
    private javax.swing.JButton jbConsultarFuncionario;
    private javax.swing.JButton jbConsultarLocacao;
    private javax.swing.JButton jbControleCliente;
    private javax.swing.JButton jbControleFuncionario;
    private javax.swing.JButton jbControleImovel;
    private javax.swing.JButton jbControleLocacao;
    private javax.swing.JButton jbFuncionario;
    private javax.swing.JLabel jlLogoff;
    private javax.swing.JLabel jlSair;
    private javax.swing.JLabel jlTroca;
    private javax.swing.JMenuBar jmBarraMenu;
    private javax.swing.JMenu jmCadastrar;
    private javax.swing.JMenu jmConsultar;
    private javax.swing.JMenu jmFuncionario;
    private javax.swing.JMenu jmLocacao;
    private javax.swing.JMenu jmSessao;
    private javax.swing.JMenuItem jmiCadastrarCliente;
    private javax.swing.JMenuItem jmiCadastrarFuncionario;
    private javax.swing.JMenuItem jmiCadastrarImovel;
    private javax.swing.JMenuItem jmiCadastrarLocacao;
    private javax.swing.JMenuItem jmiConsultarCliente;
    private javax.swing.JMenuItem jmiConsultarFuncionario;
    private javax.swing.JMenuItem jmiConsultarImovel;
    private javax.swing.JMenuItem jmiConsultarLocacao;
    private javax.swing.JMenuItem jmiControleFuncionario;
    private javax.swing.JMenuItem jmiControleLocacao;
    private javax.swing.JMenuItem jmiLogoff;
    private javax.swing.JMenuItem jmiTrocarUsuario;
    // End of variables declaration//GEN-END:variables
}
