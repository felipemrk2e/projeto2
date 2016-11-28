/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.TelaPrincipal;

import Interface.CadCargo.cadastroCargo;
import Interface.CadCargo.cadastroCargoHome;
import Interface.CadCliente.cadastroCliente;
import Interface.CadCliente.cadastroClienteHome;
import Interface.CadCliente.cadastroFiador;
import Interface.CadFuncionario.CadFuncionarioHome;
import Interface.CadFuncionario.ControleFuncionario;
import Interface.CadFuncionario.cadastroFuncionario;
import Interface.CadImovel.cadastroImovel;
import Interface.CadImovel.cadastroImovelHome;
import Interface.Locacao.CadLocacao;
import Interface.Locacao.CadLocacaoHome;
import Interface.Locacao.ControleLocacao;
import Interface.Relatorio.RelatorioHome;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

/**
 *
 * @author Sala
 */
//Cursor WAIT
//Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
//        this.setCursor(cursor);    
//		//CÓDIGO
//cursor = Cursor.getDefaultCursor();
//        this.setCursor(cursor);
public class TelaPrincipal extends javax.swing.JFrame {

    private static TelaPrincipal instancia;
    private int tentativas = 0;
    private boolean logado = false;
    private int instanciaAberta;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() throws Exception {
        initComponents();
        carregarPrincipal();

    }

    public static TelaPrincipal getInstancia() throws Exception {
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

    public void carregarPrincipal() throws Exception {
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

//        jSeparator1.setSize(180, ySize);
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
        jbCadastrarDepartamento.setEnabled(ativo);
        jbConsultarDepartamento.setEnabled(ativo);

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

        jmDepartamento.setEnabled(ativo);
        jmiCadastrarDepartamento.setEnabled(ativo);
        jmiConsultarDepartamento.setEnabled(ativo);

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

    public void acessoInstancias() {
        switch (instanciaAberta) {
            case 1:
                cadastroCliente.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 2:
                cadastroFiador.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 3:
                cadastroClienteHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 4:
                cadastroImovel.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 5:
                cadastroImovelHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 6:
                CadLocacao.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 7:
                ControleLocacao.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 8:
                CadLocacaoHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 9:
                cadastroFuncionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 10:
                ControleFuncionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 11:
                CadFuncionarioHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 12:
                cadastroCargo.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 13:
                cadastroCargoHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            case 14:
                RelatorioHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                break;
            default:
                System.out.println("=====================================================Não existem instancias abertas!!!");
        }
//        if (cadastroCargo.getInstancia() != null) {
//            cadastroCargo.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (cadastroCargoHome.getInstancia() != null) {
//            cadastroCargoHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (cadastroCliente.getInstancia() != null) {
//            cadastroCliente.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (cadastroClienteHome.getInstancia() != null) {
//            cadastroClienteHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (cadastroFiador.getInstancia() != null) {
//            cadastroFiador.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (CadFuncionarioHome.getInstancia() != null) {
//            CadFuncionarioHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (ControleFuncionario.getInstancia() != null) {
//            ControleFuncionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (cadastroImovel.getInstancia() != null) {
//            cadastroImovel.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (cadastroImovelHome.getInstancia() != null) {
//            cadastroImovelHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (CadLocacao.getInstancia() != null) {
//            CadLocacao.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (CadLocacaoHome.getInstancia() != null) {
//            CadLocacaoHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (ControleLocacao.getInstancia() != null) {
//            ControleLocacao.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
//        if (cadastroFuncionario.getInstancia() != null) {
//            cadastroFuncionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        }
    }

    public void Login() throws Exception {
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
                    if (telaLogin.verificaLogin()) {
                        JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                        setLogado(true);
                        jlLogoff.setEnabled(true);
                        jlTroca.setEnabled(true);
                        acesso();
                    }
                }
            }
        }
    }

    public void trocarUsuario() throws Exception {
        TelaLogin telaLogin = new TelaLogin(new javax.swing.JFrame(), true);
        telaLogin.setLocationRelativeTo(this);
        telaLogin.setAlwaysOnTop(true);
        telaLogin.setVisible(true);
        if (telaLogin.verificaLogin()) {
            JOptionPane.showMessageDialog(telaLogin, "Login efetuado com sucesso!");
            setLogado(true);
            acesso();
            finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
            acessoInstancias();
        } else {
            JOptionPane.showMessageDialog(telaLogin, "Acesso negado!\nUsuário ou Senha Incorretos");
            telaLogin.limpaCampos();
            while (!telaLogin.verificaLogin() && tentativas < 5) {
                telaLogin.setVisible(true);
                tentativas++;
                if (!telaLogin.verificaLogin() && tentativas < 5) {
                    telaLogin.limpaCampos();
                    JOptionPane.showMessageDialog(telaLogin, "Acesso negado!\nUsuário ou Senha Incorretos");
                    JOptionPane.showMessageDialog(telaLogin, "Você possui mais " + (5 - tentativas) + " tentativas!");
                }
                if (tentativas == 5) {
                    telaLogin.limpaCampos();
                    JOptionPane.showMessageDialog(telaLogin, "Sistema Bloquado!");
                    ocultaFuncoes(false);
                }
            }
        }
    }

    public void finalizaInstanciasNivel(int nivel) {
        switch (nivel) {
            case 1:
                break;
            case 2:
                switch (instanciaAberta) {
                    case 9:
                        cadastroFuncionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 10:
                        ControleFuncionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 11:
                        CadFuncionarioHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 12:
                        cadastroCargo.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 13:
                        cadastroCargoHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    default:
                        System.out.println("=====================================================Não existem instancias abertas!!!");
                }

//                if (cadastroFuncionario.getInstancia() != null) {
//                    cadastroFuncionario.getInstancia().setVisible(false);
//                    cadastroFuncionario.getInstancia().setAlwaysOnTop(false);
//                    cadastroFuncionario.getInstancia().encerrarInstancia();
//                }
//                if (ControleFuncionario.getInstancia() != null) {
//                    ControleFuncionario.getInstancia().setVisible(false);
//                    ControleFuncionario.getInstancia().setAlwaysOnTop(false);
//                    ControleFuncionario.getInstancia().encerrarInstancia();
//                }
//                if (CadFuncionarioHome.getInstancia() != null) {
//                    CadFuncionarioHome.getInstancia().setVisible(false);
//                    CadFuncionarioHome.getInstancia().setAlwaysOnTop(false);
//                    CadFuncionarioHome.getInstancia().encerrarInstancia();
//                }
//                if (cadastroCargo.getInstancia() != null) {
//                    cadastroCargo.getInstancia().setVisible(false);
//                    cadastroCargo.getInstancia().setAlwaysOnTop(false);
//                    cadastroCargo.getInstancia().encerrarInstancia();
//                }
//                if (cadastroCargoHome.getInstancia() != null) {
//                    cadastroCargoHome.getInstancia().setVisible(false);
//                    cadastroCargoHome.getInstancia().setAlwaysOnTop(false);
//                    cadastroCargoHome.getInstancia().encerrarInstancia();
//                }
                break;
            case 3:
                switch (instanciaAberta) {
                    case 1:
                        cadastroCliente.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 2:
                        cadastroFiador.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 4:
                        cadastroImovel.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 6:
                        CadLocacao.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 7:
                        ControleLocacao.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 8:
                        CadLocacaoHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 9:
                        cadastroFuncionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 10:
                        ControleFuncionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 11:
                        CadFuncionarioHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 12:
                        cadastroCargo.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 13:
                        cadastroCargoHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    case 14:
                        RelatorioHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
                        break;
                    default:
                        System.out.println("=====================================================Não existem instancias abertas!!!");
                }
                break;

//                
//                if (cadastroCliente.getInstancia() != null) {
//                    cadastroCliente.getInstancia().setVisible(false);
//                    cadastroCliente.getInstancia().setAlwaysOnTop(false);
//                    cadastroCliente.getInstancia().encerrarInstancia();
//                }
//                if (cadastroFiador.getInstancia() != null) {
//                    cadastroFiador.getInstancia().setVisible(false);
//                    cadastroFiador.getInstancia().setAlwaysOnTop(false);
//                    cadastroFiador.getInstancia().encerrarInstancia();
//                }
//                if (cadastroImovel.getInstancia() != null) {
//                    cadastroImovel.getInstancia().setVisible(false);
//                    cadastroImovel.getInstancia().setAlwaysOnTop(false);
//                    cadastroImovel.getInstancia().encerrarInstancia();
//                }
//                if (CadLocacao.getInstancia() != null) {
//                    CadLocacao.getInstancia().setVisible(false);
//                    CadLocacao.getInstancia().setAlwaysOnTop(false);
//                    CadLocacao.getInstancia().encerrarInstancia();
//                }
//                if (ControleLocacao.getInstancia() != null) {
//                    ControleLocacao.getInstancia().setVisible(false);
//                    ControleLocacao.getInstancia().setAlwaysOnTop(false);
//                    ControleLocacao.getInstancia().encerrarInstancia();
//                }
//                if (cadastroFuncionario.getInstancia() != null) {
//                    cadastroFuncionario.getInstancia().setVisible(false);
//                    cadastroFuncionario.getInstancia().setAlwaysOnTop(false);
//                    cadastroFuncionario.getInstancia().encerrarInstancia();
//                }
//                if (ControleFuncionario.getInstancia() != null) {
//                    ControleFuncionario.getInstancia().setVisible(false);
//                    ControleFuncionario.getInstancia().setAlwaysOnTop(false);
//                    ControleFuncionario.getInstancia().encerrarInstancia();
//                }
//                if (CadFuncionarioHome.getInstancia() != null) {
//                    CadFuncionarioHome.getInstancia().setVisible(false);
//                    CadFuncionarioHome.getInstancia().setAlwaysOnTop(false);
//                    CadFuncionarioHome.getInstancia().encerrarInstancia();
//                }
//                if (cadastroCargo.getInstancia() != null) {
//                    cadastroCargo.getInstancia().setVisible(false);
//                    cadastroCargo.getInstancia().setAlwaysOnTop(false);
//                    cadastroCargo.getInstancia().encerrarInstancia();
//                }
//                if (cadastroCargoHome.getInstancia() != null) {
//                    cadastroCargoHome.getInstancia().setVisible(false);
//                    cadastroCargoHome.getInstancia().setAlwaysOnTop(false);
//                    cadastroCargoHome.getInstancia().encerrarInstancia();
//                }
//                break;
            default:
                JOptionPane.showMessageDialog(null, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void finalizarInstancias() {
        switch (instanciaAberta) {
            case 1:
                cadastroCliente.getInstancia().setVisible(false);
                cadastroCliente.getInstancia().setAlwaysOnTop(false);
                cadastroCliente.getInstancia().encerrarInstancia();
                cadastroCliente.getInstancia().dispose();
                break;
            case 2:
                cadastroFiador.getInstancia().setVisible(false);
                cadastroFiador.getInstancia().setAlwaysOnTop(false);
                cadastroFiador.getInstancia().encerrarInstancia();
                cadastroFiador.getInstancia().dispose();
                break;
            case 3:
                cadastroClienteHome.getInstancia().setVisible(false);
                cadastroClienteHome.getInstancia().setAlwaysOnTop(false);
                cadastroClienteHome.getInstancia().encerrarInstancia();
                cadastroClienteHome.getInstancia().dispose();
                break;
            case 4:
                cadastroImovel.getInstancia().setVisible(false);
                cadastroImovel.getInstancia().setAlwaysOnTop(false);
                cadastroImovel.getInstancia().encerrarInstancia();
                cadastroImovel.getInstancia().dispose();
                break;
            case 5:
                cadastroImovelHome.getInstancia().setVisible(false);
                cadastroImovelHome.getInstancia().setAlwaysOnTop(false);
                cadastroImovelHome.getInstancia().encerrarInstancia();
                cadastroImovelHome.getInstancia().dispose();
                break;
            case 6:
                CadLocacao.getInstancia().setVisible(false);
                CadLocacao.getInstancia().setAlwaysOnTop(false);
                CadLocacao.getInstancia().encerrarInstancia();
                CadLocacao.getInstancia().dispose();
                break;
            case 7:
                ControleLocacao.getInstancia().setVisible(false);
                ControleLocacao.getInstancia().setAlwaysOnTop(false);
                ControleLocacao.getInstancia().encerrarInstancia();
                ControleLocacao.getInstancia().dispose();
                break;
            case 8:
                CadLocacaoHome.getInstancia().setVisible(false);
                CadLocacaoHome.getInstancia().setAlwaysOnTop(false);
                CadLocacaoHome.getInstancia().encerrarInstancia();
                CadLocacaoHome.getInstancia().dispose();
                break;
            case 9:
                cadastroFuncionario.getInstancia().setVisible(false);
                cadastroFuncionario.getInstancia().setAlwaysOnTop(false);
                cadastroFuncionario.getInstancia().encerrarInstancia();
                cadastroFuncionario.getInstancia().dispose();
                break;
            case 10:
                ControleFuncionario.getInstancia().setVisible(false);
                ControleFuncionario.getInstancia().setAlwaysOnTop(false);
                ControleFuncionario.getInstancia().encerrarInstancia();
                ControleFuncionario.getInstancia().dispose();
                break;
            case 11:
                CadFuncionarioHome.getInstancia().setVisible(false);
                CadFuncionarioHome.getInstancia().setAlwaysOnTop(false);
                CadFuncionarioHome.getInstancia().encerrarInstancia();
                CadFuncionarioHome.getInstancia().dispose();
                break;
            case 12:
                cadastroCargo.getInstancia().setVisible(false);
                cadastroCargo.getInstancia().setAlwaysOnTop(false);
                cadastroCargo.getInstancia().encerrarInstancia();
                cadastroCargo.getInstancia().dispose();
                break;
            case 13:
                cadastroCargoHome.getInstancia().setVisible(false);
                cadastroCargoHome.getInstancia().setAlwaysOnTop(false);
                cadastroCargoHome.getInstancia().encerrarInstancia();
                cadastroCargoHome.getInstancia().dispose();
                break;
            default:
                System.out.println("=====================================================Não existem instancias abertas!!!");
        }

//                if (cadastroCliente.getInstancia() != null) {
//                    cadastroCliente.getInstancia().setVisible(false);
//                    cadastroCliente.getInstancia().setAlwaysOnTop(false);
//                    cadastroCliente.getInstancia().encerrarInstancia();
//                }
//                if (cadastroFiador.getInstancia() != null) {
//                    cadastroFiador.getInstancia().setVisible(false);
//                    cadastroFiador.getInstancia().setAlwaysOnTop(false);
//                    cadastroFiador.getInstancia().encerrarInstancia();
//                }
//                if (cadastroClienteHome.getInstancia() != null) {
//                    cadastroClienteHome.getInstancia().setVisible(false);
//                    cadastroClienteHome.getInstancia().setAlwaysOnTop(false);
//                    cadastroClienteHome.getInstancia().encerrarInstancia();
//                }
//                if (cadastroImovel.getInstancia() != null) {
//                    cadastroImovel.getInstancia().setVisible(false);
//                    cadastroImovel.getInstancia().setAlwaysOnTop(false);
//                    cadastroImovel.getInstancia().encerrarInstancia();
//                }
//                if (cadastroImovelHome.getInstancia() != null) {
//                    cadastroImovelHome.getInstancia().setVisible(false);
//                    cadastroImovelHome.getInstancia().setAlwaysOnTop(false);
//                    cadastroImovelHome.getInstancia().encerrarInstancia();
//                }
//                if (CadLocacao.getInstancia() != null) {
//                    CadLocacao.getInstancia().setVisible(false);
//                    CadLocacao.getInstancia().setAlwaysOnTop(false);
//                    CadLocacao.getInstancia().encerrarInstancia();
//                }
//                if (ControleLocacao.getInstancia() != null) {
//                    ControleLocacao.getInstancia().setVisible(false);
//                    ControleLocacao.getInstancia().setAlwaysOnTop(false);
//                    ControleLocacao.getInstancia().encerrarInstancia();
//                }
//                if (CadLocacaoHome.getInstancia() != null) {
//                    CadLocacaoHome.getInstancia().setVisible(false);
//                    CadLocacaoHome.getInstancia().setAlwaysOnTop(false);
//                    CadLocacaoHome.getInstancia().encerrarInstancia();
//                }
//                if (cadastroFuncionario.getInstancia() != null) {
//                    cadastroFuncionario.getInstancia().setVisible(false);
//                    cadastroFuncionario.getInstancia().setAlwaysOnTop(false);
//                    cadastroFuncionario.getInstancia().encerrarInstancia();
//                }
//                if (ControleFuncionario.getInstancia() != null) {
//                    ControleFuncionario.getInstancia().setVisible(false);
//                    ControleFuncionario.getInstancia().setAlwaysOnTop(false);
//                    ControleFuncionario.getInstancia().encerrarInstancia();
//                }
//                if (CadFuncionarioHome.getInstancia() != null) {
//                    CadFuncionarioHome.getInstancia().setVisible(false);
//                    CadFuncionarioHome.getInstancia().setAlwaysOnTop(false);
//                    CadFuncionarioHome.getInstancia().encerrarInstancia();
//                }
//                if (cadastroCargo.getInstancia() != null) {
//                    cadastroCargo.getInstancia().setVisible(false);
//                    cadastroCargo.getInstancia().setAlwaysOnTop(false);
//                    cadastroCargo.getInstancia().encerrarInstancia();
//                }
//                if (cadastroCargoHome.getInstancia() != null) {
//                    cadastroCargoHome.getInstancia().setVisible(false);
//                    cadastroCargoHome.getInstancia().setAlwaysOnTop(false);
//                    cadastroCargoHome.getInstancia().encerrarInstancia();
//                }
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
        jbCadastrarDepartamento = new javax.swing.JButton();
        jbConsultarDepartamento = new javax.swing.JButton();
        jbRelatorios = new javax.swing.JButton();
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
        jmDepartamento = new javax.swing.JMenu();
        jmiCadastrarDepartamento = new javax.swing.JMenuItem();
        jmiConsultarDepartamento = new javax.swing.JMenuItem();
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

        jbCadastrarDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCadastrarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chart_organisation_add.png"))); // NOI18N
        jbCadastrarDepartamento.setText("<html><center>Cadastrar<br/>Departamento</html>");
        jbCadastrarDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbCadastrarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbCadastrarDepartamentoMousePressed(evt);
            }
        });

        jbConsultarDepartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbConsultarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Farm-Fresh_smartart_organization_chart_rh.png"))); // NOI18N
        jbConsultarDepartamento.setText("<html><center>Consultar<br/>Departamento</html>");
        jbConsultarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbConsultarDepartamentoMousePressed(evt);
            }
        });

        jbRelatorios.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jbRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/relatórios.png"))); // NOI18N
        jbRelatorios.setText("<html><center>Emitir<br/>Relatórios</html>");
        jbRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRelatoriosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbConsultarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbCadastrarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addGap(28, 28, 28))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jbCadastrarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbConsultarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jbCadastrarDepartamento.getAccessibleContext().setAccessibleName("jbCadastrarCargo");

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 180, 620);

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

        jmDepartamento.setText("Departamento");

        jmiCadastrarDepartamento.setText("Cadastrar Departamento");
        jmiCadastrarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiCadastrarDepartamentoMousePressed(evt);
            }
        });
        jmDepartamento.add(jmiCadastrarDepartamento);

        jmiConsultarDepartamento.setText("Consultar Departamento");
        jmiConsultarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiConsultarDepartamentoMousePressed(evt);
            }
        });
        jmDepartamento.add(jmiConsultarDepartamento);

        jmBarraMenu.add(jmDepartamento);

        jmSessao.setText("Sessão");

        jmiTrocarUsuario.setText("Trocar Usuário");
        jmiTrocarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiTrocarUsuarioMousePressed(evt);
            }
        });
        jmSessao.add(jmiTrocarUsuario);

        jmiLogoff.setText("Logoff");
        jmiLogoff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmiLogoffMousePressed(evt);
            }
        });
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
            try {
                Login();
            } catch (Exception ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jlLogoffMousePressed

    private void jbCadastrarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarClienteMousePressed
        if (jbCadastrarCliente.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 1;
            cadastroCliente cliente = cadastroCliente.getInstancia();
            cliente.setLocationRelativeTo(jSeparator2);
            cliente.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            cliente.setVisible(true);
        }
    }//GEN-LAST:event_jbCadastrarClienteMousePressed

    private void jbCadastrarImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarImovelMousePressed
        if (jbCadastrarImovel.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 4;
            cadastroImovel imovel = cadastroImovel.getInstancia();
            imovel.setLocationRelativeTo(jSeparator2);
            imovel.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            imovel.setVisible(true);
        }
    }//GEN-LAST:event_jbCadastrarImovelMousePressed

    private void jbControleClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleClienteMousePressed
        if (jbControleCliente.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 3;
            cadastroClienteHome clienteHome = cadastroClienteHome.getInstancia();
            clienteHome.setLocationRelativeTo(jSeparator2);
            clienteHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            clienteHome.setVisible(true);
        }
    }//GEN-LAST:event_jbControleClienteMousePressed

    private void jbControleImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleImovelMousePressed
        if (jbControleImovel.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 5;
            cadastroImovelHome imovelHome = cadastroImovelHome.getInstancia();
            imovelHome.setLocationRelativeTo(jSeparator2);
            imovelHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            imovelHome.setVisible(true);
        }
    }//GEN-LAST:event_jbControleImovelMousePressed

    private void jbCadastrarLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarLocacaoMousePressed
        if (jbCadastrarLocacao.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 6;
            CadLocacao locacao = CadLocacao.getInstancia();
            locacao.setLocationRelativeTo(jSeparator2);
            locacao.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            locacao.setVisible(true);
        }
    }//GEN-LAST:event_jbCadastrarLocacaoMousePressed

    private void jbControleLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleLocacaoMousePressed
        if (jbControleLocacao.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 7;
            ControleLocacao controleLocacao = ControleLocacao.getInstancia();
            controleLocacao.setLocationRelativeTo(jSeparator2);
            controleLocacao.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            controleLocacao.setVisible(true);
        }
    }//GEN-LAST:event_jbControleLocacaoMousePressed

    private void jbFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbFuncionarioMousePressed
        if (jbFuncionario.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 9;
            cadastroFuncionario funcionario = cadastroFuncionario.getInstancia();
            funcionario.setLocationRelativeTo(jSeparator2);
            funcionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            funcionario.setVisible(true);
        }
    }//GEN-LAST:event_jbFuncionarioMousePressed

    private void jbControleFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbControleFuncionarioMousePressed
        if (jbControleFuncionario.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 10;
            ControleFuncionario controleFuncionario = ControleFuncionario.getInstancia();
            controleFuncionario.setLocationRelativeTo(jSeparator2);
            controleFuncionario.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            controleFuncionario.setVisible(true);
        }
    }//GEN-LAST:event_jbControleFuncionarioMousePressed

    private void jbConsultarLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConsultarLocacaoMousePressed
        if (jbConsultarLocacao.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 8;
            CadLocacaoHome cadLocacaoHome = CadLocacaoHome.getInstancia();
            cadLocacaoHome.setLocationRelativeTo(jSeparator2);
            cadLocacaoHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            cadLocacaoHome.setVisible(true);
        }

    }//GEN-LAST:event_jbConsultarLocacaoMousePressed

    private void jlTrocaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlTrocaMousePressed
        try {
            trocarUsuario();
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jlTrocaMousePressed

    private void jmiCadastrarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCadastrarClienteMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        cadastroCliente cliente = cadastroCliente.getInstancia();
        cliente.setLocationRelativeTo(jSeparator2);
        cliente.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarClienteMousePressed

    private void jmiCadastrarImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCadastrarImovelMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        cadastroImovel imovel = cadastroImovel.getInstancia();
        imovel.setLocationRelativeTo(jSeparator2);
        imovel.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarImovelMousePressed

    private void jmiCadastrarFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCadastrarFuncionarioMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        cadastroFuncionario funcionario = cadastroFuncionario.getInstancia();
        funcionario.setLocationRelativeTo(jSeparator2);
        funcionario.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarFuncionarioMousePressed

    private void jmiConsultarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiConsultarClienteMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        cadastroClienteHome clienteHome = cadastroClienteHome.getInstancia();
        clienteHome.setLocationRelativeTo(jSeparator2);
        clienteHome.setVisible(true);
    }//GEN-LAST:event_jmiConsultarClienteMousePressed

    private void jmiConsultarImovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiConsultarImovelMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        cadastroImovelHome imovelHome = cadastroImovelHome.getInstancia();
        imovelHome.setLocationRelativeTo(jSeparator2);
        imovelHome.setVisible(true);
    }//GEN-LAST:event_jmiConsultarImovelMousePressed

    private void jmiConsultarFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiConsultarFuncionarioMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        CadFuncionarioHome cadFuncionarioHome = CadFuncionarioHome.getInstancia();
        cadFuncionarioHome.setLocationRelativeTo(jSeparator2);
        cadFuncionarioHome.setVisible(true);
    }//GEN-LAST:event_jmiConsultarFuncionarioMousePressed

    private void jmiControleFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiControleFuncionarioMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        ControleFuncionario controleFuncionario = ControleFuncionario.getInstancia();
        controleFuncionario.setLocationRelativeTo(jSeparator2);
        controleFuncionario.setVisible(true);
    }//GEN-LAST:event_jmiControleFuncionarioMousePressed

    private void jmiCadastrarLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCadastrarLocacaoMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        CadLocacao locacao = CadLocacao.getInstancia();
        locacao.setLocationRelativeTo(jSeparator2);
        locacao.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarLocacaoMousePressed

    private void jmiConsultarLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiConsultarLocacaoMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        CadLocacaoHome cadLocacaoHome = CadLocacaoHome.getInstancia();
        cadLocacaoHome.setLocationRelativeTo(jSeparator2);
        cadLocacaoHome.setVisible(true);
    }//GEN-LAST:event_jmiConsultarLocacaoMousePressed

    private void jmiControleLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiControleLocacaoMousePressed
        finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
        ControleLocacao controleLocacao = ControleLocacao.getInstancia();
        controleLocacao.setLocationRelativeTo(jSeparator2);
        controleLocacao.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
        controleLocacao.setVisible(true);
    }//GEN-LAST:event_jmiControleLocacaoMousePressed

    private void jbConsultarFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConsultarFuncionarioMousePressed
        if (jbConsultarFuncionario.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 11;
            CadFuncionarioHome cadFuncionarioHome = CadFuncionarioHome.getInstancia();
            cadFuncionarioHome.setLocationRelativeTo(jSeparator2);
            cadFuncionarioHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            cadFuncionarioHome.setVisible(true);
        }
    }//GEN-LAST:event_jbConsultarFuncionarioMousePressed

    private void jmiTrocarUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiTrocarUsuarioMousePressed
        try {
            trocarUsuario();
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmiTrocarUsuarioMousePressed

    private void jbCadastrarDepartamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarDepartamentoMousePressed
        if (jbCadastrarDepartamento.isEnabled()) {
            cadastroCargo.getInstancia().encerrarInstancia();
            cadastroCargo.getInstancia().zeraAtributosCargoDepartamento();
            finalizarInstancias();
            instanciaAberta = 12;
            cadastroCargo cadCargo = cadastroCargo.getInstancia();
            cadCargo.setLocationRelativeTo(jSeparator2);
            cadCargo.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            cadCargo.getInstancia().DisableDep();
            cadCargo.setVisible(true);
        }
    }//GEN-LAST:event_jbCadastrarDepartamentoMousePressed

    private void jbConsultarDepartamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConsultarDepartamentoMousePressed
        if (jbConsultarDepartamento.isEnabled()) {
            cadastroCargo.getInstancia().zeraAtributosCargoDepartamento();
            cadastroCargo.getInstancia().encerrarInstancia();
            finalizarInstancias();
            instanciaAberta = 13;
            cadastroCargoHome cadCargoHome = cadastroCargoHome.getInstancia();
            cadCargoHome.setLocationRelativeTo(jSeparator2);
            cadCargoHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            cadCargoHome.setVisible(true);
        }
    }//GEN-LAST:event_jbConsultarDepartamentoMousePressed

    private void jmiCadastrarDepartamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCadastrarDepartamentoMousePressed
        if (jmiCadastrarDepartamento.isEnabled()) {
            cadastroCargo.getInstancia().zeraAtributosCargoDepartamento();
            cadastroCargo.getInstancia().encerrarInstancia();
            finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
            cadastroCargo cadCargo = cadastroCargo.getInstancia();
            cadCargo.setLocationRelativeTo(jSeparator2);
            cadCargo.getInstancia().DisableDep();
            cadCargo.setVisible(true);
        }
    }//GEN-LAST:event_jmiCadastrarDepartamentoMousePressed

    private void jmiConsultarDepartamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiConsultarDepartamentoMousePressed
        if (jmiConsultarDepartamento.isEnabled()) {
            cadastroCargo.getInstancia().zeraAtributosCargoDepartamento();
            cadastroCargo.getInstancia().encerrarInstancia();
            finalizaInstanciasNivel(Sessao.getInstance().getUsuario().getNivelAcesso());
            cadastroCargoHome cadCargoHome = cadastroCargoHome.getInstancia();
            cadCargoHome.setLocationRelativeTo(jSeparator2);
            cadCargoHome.setAlwaysOnTop(true);
            cadCargoHome.setVisible(true);
        }
    }//GEN-LAST:event_jmiConsultarDepartamentoMousePressed

    private void jmiLogoffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiLogoffMousePressed
        if (!isLogado()) {
            jlLogoff.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Logoff efetuado com sucesso!");
            ocultaFuncoes(false);
            finalizarInstancias();
            setLogado(false);
            try {
                Login();
            } catch (Exception ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jmiLogoffMousePressed

    private void jbRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRelatoriosMouseClicked
        if (jbRelatorios.isEnabled()) {
            finalizarInstancias();
            instanciaAberta = 14;
           RelatorioHome relaotioHome = RelatorioHome.getInstancia();
            relaotioHome.setLocationRelativeTo(jSeparator2);
            relaotioHome.getInstancia().acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
            relaotioHome.setVisible(true);
        }
    }//GEN-LAST:event_jbRelatoriosMouseClicked

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
                try {
                    new TelaPrincipal().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbCadastrarCliente;
    private javax.swing.JButton jbCadastrarDepartamento;
    private javax.swing.JButton jbCadastrarImovel;
    private javax.swing.JButton jbCadastrarLocacao;
    private javax.swing.JButton jbConsultarDepartamento;
    private javax.swing.JButton jbConsultarFuncionario;
    private javax.swing.JButton jbConsultarLocacao;
    private javax.swing.JButton jbControleCliente;
    private javax.swing.JButton jbControleFuncionario;
    private javax.swing.JButton jbControleImovel;
    private javax.swing.JButton jbControleLocacao;
    private javax.swing.JButton jbFuncionario;
    private javax.swing.JButton jbRelatorios;
    private javax.swing.JLabel jlLogoff;
    private javax.swing.JLabel jlSair;
    private javax.swing.JLabel jlTroca;
    private javax.swing.JMenuBar jmBarraMenu;
    private javax.swing.JMenu jmCadastrar;
    private javax.swing.JMenu jmConsultar;
    private javax.swing.JMenu jmDepartamento;
    private javax.swing.JMenu jmFuncionario;
    private javax.swing.JMenu jmLocacao;
    private javax.swing.JMenu jmSessao;
    private javax.swing.JMenuItem jmiCadastrarCliente;
    private javax.swing.JMenuItem jmiCadastrarDepartamento;
    private javax.swing.JMenuItem jmiCadastrarFuncionario;
    private javax.swing.JMenuItem jmiCadastrarImovel;
    private javax.swing.JMenuItem jmiCadastrarLocacao;
    private javax.swing.JMenuItem jmiConsultarCliente;
    private javax.swing.JMenuItem jmiConsultarDepartamento;
    private javax.swing.JMenuItem jmiConsultarFuncionario;
    private javax.swing.JMenuItem jmiConsultarImovel;
    private javax.swing.JMenuItem jmiConsultarLocacao;
    private javax.swing.JMenuItem jmiControleFuncionario;
    private javax.swing.JMenuItem jmiControleLocacao;
    private javax.swing.JMenuItem jmiLogoff;
    private javax.swing.JMenuItem jmiTrocarUsuario;
    // End of variables declaration//GEN-END:variables
}
