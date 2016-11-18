/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadImovel;

import Interface.TelaPrincipal.Sessao;
import global.model.Estado;
import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.ImovelDAO;
import dao.StatusDAO;
import dao.TipoContratoDAO;
import dao.TipoImovelDAO;
import global.model.Cidade;
import global.model.Endereco;
import global.model.Status;
import imovel.model.Documentacao;
import imovel.model.Imovel;
import imovel.model.Imovel_has_TipoContrato;
import imovel.model.Terreno;
import imovel.model.TipoContrato;
import imovel.model.TipoImovel;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import validacao.validacao;

public class cadastroImovel extends javax.swing.JFrame {

    private static cadastroImovel instancia;
    int user;
    Imovel imovelTemp;
    ImovelDAO imovelDao = new ImovelDAO();
    List<Cidade> cidadeGlobal;
    List<Estado> estadoGlobal;

    // Imovel imovel = new Imovel();
    /**
     * Creates new form cadastroImovel2
     */
    public cadastroImovel() {
        //   this.setUndecorated(true);
        initComponents();
        fecharCadastro();
        //Alterado system.exit(), para dispose()

        removerTitleBar();
        ComboBox();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
      
//
//        Imovel imovel = imovelDao.getById(Long.parseLong("7"));
//        popular(imovel);
    }

    public cadastroImovel(int user) {
        this.setUndecorated(true);
        this.user = user;
        initComponents();
        setAlwaysOnTop(true);
        fecharCadastro();
        removerTitleBar();
        verificaNivel0();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());

    }

    public cadastroImovel(String idImovel) {
        //this.setUndecorated(true);
        this.user = user;

        initComponents();
        // setAlwaysOnTop(true);
        ComboBox();
        fecharCadastro();
        removerTitleBar();
        Imovel imovel = imovelDao.getById(Long.valueOf(idImovel));
        popular(imovel);
        //    verificaNivel();
          acesso(Sessao.getInstance().getUsuario().getNivelAcesso());

    }

    public static cadastroImovel getInstancia() {
        if (instancia == null) {
            instancia = new cadastroImovel();
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
                if (imovelTemp == null) {
                    DisableEnable(true);
                    jbConfirmar.setEnabled(true);
                    jbEditar.setEnabled(false);
                } else {
                    DisableEnable(false);
                    jbConfirmar.setEnabled(false);
                    jbEditar.setEnabled(true);
                }

                break;
            case 2:

                if (imovelTemp == null) {
                    DisableEnable(true);
                    jbConfirmar.setEnabled(true);
                    jbEditar.setEnabled(false);
                } else {
                    DisableEnable(false);
                    jbConfirmar.setEnabled(false);
                    jbEditar.setEnabled(true);
                }
                break;
            case 3:
                DisableEnable(false);
                jbConfirmar.setEnabled(false);
                jbEditar.setEnabled(false);

                break;
            default:
                JOptionPane.showMessageDialog(null, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void ComboBox() {

        EstadoDAO estadoDao = new EstadoDAO();
        List<Estado> estadoTemp = new ArrayList<>();
        List<String> listaSigla = new ArrayList<String>();
        estadoTemp = estadoDao.getAll();
        for (int i = 0; i < estadoTemp.size(); i++) {
            listaSigla.add(estadoTemp.get(i).getSigla());
        }
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaSigla.toArray());
        jcbEstado.setModel(defaultComboBox);
        StatusDAO statusDao = new StatusDAO();
        List<Status> status = new ArrayList<>();
        status = statusDao.getAll();
        List<String> StatusList = new ArrayList<String>();
        for (int i = 0; i < status.size(); i++) {
            StatusList.add(status.get(i).getStatus());
        }
        DefaultComboBoxModel defaultComboBox2 = new DefaultComboBoxModel(StatusList.toArray());
        jcbStatus.setModel(defaultComboBox2);
        jcbStatus.setSelectedIndex(0);

        CidadeDAO cidadeDao = new CidadeDAO();

        List<Cidade> cidadeTemp = new ArrayList<>();
        cidadeTemp = cidadeDao.getWhereIdEstado((long) (jcbEstado.getSelectedIndex() + 1));

        List<String> listaCidade = new ArrayList<String>();
        for (int i = 0; i < cidadeTemp.size(); i++) {
            listaCidade.add(cidadeTemp.get(i).getNomeCidade());
        }
        DefaultComboBoxModel defaultComboBox3 = new DefaultComboBoxModel(listaCidade.toArray());
        jcbCidade.setModel(defaultComboBox3);
        estadoGlobal = estadoTemp;
        cidadeGlobal = cidadeTemp;
    }

    public void verificaNivel0() {
        if (user <= 2) {
            DisableEnable(true);
            jbEditar.setEnabled(false);
            jbConfirmar.setEnabled(true);

        } else {
            DisableEnable(false);
            jbConfirmar.setEnabled(false);
            jbEditar.setEnabled(false);

        }
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

    public void setImovel(Imovel imovel) {
        imovelTemp = imovel;
    }

    public Imovel getImovel() {

        return imovelTemp;
    }

    public void DisableEnable(Boolean b) {

        jrbCasa.setEnabled(b);
        jrbApartamento.setEnabled(b);
        jrbSalao.setEnabled(b);
        jrbComercio.setEnabled(b);
        jrbCondominio.setEnabled(b);

        jrbMobiliada.setEnabled(b);
        jrbSemMobilia.setEnabled(b);
        jrbSemiMobiliada.setEnabled(b);

        jcbLocacao.setEnabled(b);
        jcbTemporada.setEnabled(b);
        jcbVenda.setEnabled(b);
        jcbFesta.setEnabled(b);

        if (imovelTemp != null) {
            if (b && imovelTemp.getStatus().getIdStatus() != 4) {
                jcbStatus.setEnabled(true);
            } else if (b && imovelTemp.getStatus().getIdStatus() == 4) {
                jcbStatus.setEnabled(false);
            } else {
                jcbStatus.setEnabled(false);
            };

        }

        //Endereço
        jtfLogradouro.setEnabled(b);
        jtfNumero.setEnabled(b);
        jtfComplemento.setEnabled(b);
        jtfBairro.setEnabled(b);
        jtCep.setEnabled(b);
        jtfReferencia.setEnabled(b);
        jtfZona.setEnabled(b);
        jtfCondominio.setEnabled(b);
        jcbCidade.setEnabled(b);
        jcbEstado.setEnabled(b);
        jcbStatus.setEnabled(b);

        //valores
        jtValorLocacaoMes.setEnabled(b);
        jtValorVenda.setEnabled(b);
        jtValorTemporada.setEnabled(b);
        jtValorIptu.setEnabled(b);
        jtValorCondominio.setEnabled(b);
        jtValorDiaria.setEnabled(b);

        //Outros 
        jtMatriculo.setEnabled(b);
        jtContaAgua.setEnabled(b);
        jtContaLuz.setEnabled(b);
        jtIptu.setEnabled(b);
        jtContrato.setEnabled(b);
        jtCartorio.setEnabled(b);
        jtSituacaoEscritura.setEnabled(b);

        jtLargura.setEnabled(b);
        jtComprimento.setEnabled(b);
        jtAreaConstruida.setEnabled(b);

        jtMobilia.setEnabled(b);
        jtChaves.setEnabled(b);
        jtObservacao.setEnabled(b);

        //Descrição  
        jtQuartos.setEnabled(b);
        jtSuites.setEnabled(b);
        jtSalas.setEnabled(b);
        jtBanheiros.setEnabled(b);
        jtLavados.setEnabled(b);
        jtAreaServico.setEnabled(b);
        jtLavanderia.setEnabled(b);
        jtPisos.setEnabled(b);
        jtIdadeImovel.setEnabled(b);
        jtPscina.setEnabled(b);
        jtVagasGaragem.setEnabled(b);
        jtDepEmpregada.setEnabled(b);
        jtTipoImovel.setEnabled(b);
        jtAreaExterna.setEnabled(b);
        jtAcabamento.setEnabled(b);
        jtOutros.setEnabled(b);

    }

    public void popular(Imovel imovel) {
        imovelTemp = imovel;
        // falta mudar o true para o objeto importado
        if (imovel.getTipoImovel().getIdTipoImovel() == 1) {

            jrbCasa.setSelected(true);
        } else if (imovel.getTipoImovel().getIdTipoImovel() == 2) {
            jrbApartamento.setSelected(true);
        } else if (imovel.getTipoImovel().getIdTipoImovel() == 3) {
            jrbSalao.setSelected(true);

        } else if (imovel.getTipoImovel().getIdTipoImovel() == 4) {

            jrbComercio.setSelected(true);

        } else if (imovel.getTipoImovel().getIdTipoImovel() == 5) {
            jrbCondominio.setSelected(true);
        }

        StatusDAO statusDao = new StatusDAO();
        List<Status> status = new ArrayList<>();
        status = statusDao.getAll();
        List<String> StatusList = new ArrayList<String>();
        int statusTemp = (int) imovel.getStatus().getIdStatus();
        if (statusTemp > 3) {
            for (int i = 0; i < status.size(); i++) {
                StatusList.add(status.get(i).getStatus());
            }
        } else {
            for (int i = 0; i < status.size() - 2; i++) {
                StatusList.add(status.get(i).getStatus());
            }
        }
        DefaultComboBoxModel defaultComboBox2 = new DefaultComboBoxModel(StatusList.toArray());
        jcbStatus.setModel(defaultComboBox2);

        jcbStatus.setSelectedIndex(statusTemp - 1);

        jcbStatus.setEnabled(false);

        for (int i = 0; i < imovel.getTiposContratos().size(); i++) {

            Imovel_has_TipoContrato Imovel_tipoContrato = imovel.getTiposContratos().get(i);
            TipoContrato tipoContrato = Imovel_tipoContrato.getTipoContrato();

            if (tipoContrato.getIdTipoContrato() == 1 && Imovel_tipoContrato.getValor() != 0) {
                jcbLocacao.setSelected(true);
                jtValorLocacaoMes.setEnabled(true);
                jtValorLocacaoMes.setText(String.valueOf(Imovel_tipoContrato.getValor()));
                jtValorLocacaoMes.setEditable(true);

            } else if (tipoContrato.getIdTipoContrato() == 2 && Imovel_tipoContrato.getValor() != 0) {
                jcbVenda.setSelected(true);
                jtValorVenda.setEnabled(true);
                jtValorVenda.setText(String.valueOf(Imovel_tipoContrato.getValor()));
                jtValorVenda.setEditable(true);
            } else if (tipoContrato.getIdTipoContrato() == 3 && Imovel_tipoContrato.getValor() != 0) {
                jcbTemporada.setSelected(true);
                jtValorTemporada.setEnabled(true);
                jtValorTemporada.setText(String.valueOf(Imovel_tipoContrato.getValor()));
                jtValorTemporada.setEditable(true);
            } else if (tipoContrato.getIdTipoContrato() == 4 && Imovel_tipoContrato.getValor() != 0) {
                jcbFesta.setSelected(true);
                jtValorDiaria.setEnabled(true);
                jtValorDiaria.setText(String.valueOf(Imovel_tipoContrato.getValor()));
                jtValorDiaria.setEditable(true);
            }

        }

        //----------------  // atributo da classe imovel 
        if (imovel.getTipoMobilia() == 1) {
            jrbMobiliada.setSelected(true);
        } else if (imovel.getTipoMobilia() == 3) {
            jrbSemMobilia.setSelected(true);
        } else if (imovel.getTipoMobilia() == 2) {
            jrbSemiMobiliada.setSelected(true);
        }
//////////////////

        jtCodigo.setText(String.valueOf(imovel.getIdImovel()));

        // falta o atributo no sql status     
        //Endereço parte obrigatoria
        jtfLogradouro.setText(imovel.getEndereco().getNomeEndereco());
        jtfNumero.setText(String.valueOf(imovel.getEndereco().getNumero()));
        jtfBairro.setText(imovel.getEndereco().getBairro());
        jcbEstado.setSelectedIndex((int) imovel.getEndereco().getCidade().getEstado().getId() - 1);

        CidadeDAO cidadeDao = new CidadeDAO();

        List<Cidade> cidadeTemp = new ArrayList<>();
        cidadeTemp = cidadeDao.getWhereIdEstado((long) (jcbEstado.getSelectedIndex() + 1));
        int index = 0;
        List<String> listaCidade = new ArrayList<String>();
        for (int i = 0; i < cidadeTemp.size(); i++) {
            listaCidade.add(cidadeTemp.get(i).getNomeCidade());
            if (cidadeTemp.get(i).getIdCidade() == imovelTemp.getEndereco().getCidade().getIdCidade()) {
                index = i;
            }
        }
        DefaultComboBoxModel defaultComboBox3 = new DefaultComboBoxModel(listaCidade.toArray());
        jcbCidade.setModel(defaultComboBox3);
        jcbCidade.setSelectedIndex(index);
        //endereço não obrigatorio
        if (imovel.getEndereco().getCep().equals(" ")) {
            jtCep.setText("");
        } else {
            jtCep.setText(imovel.getEndereco().getCep());
        }

        if (imovel.getEndereco().getComplemento().equals(" ")) {

            jtfComplemento.setText("");
        } else {
            jtfComplemento.setText(imovel.getEndereco().getComplemento());
        }

        if (imovel.getEndereco().getReferencia().equals(" ")) {
            jtfReferencia.setText("");
        } else {
            jtfReferencia.setText(imovel.getEndereco().getReferencia());
        }

        if (imovel.getEndereco().getZona().equals(" ")) {
            jtfZona.setText("");
        } else {
            jtfZona.setText(imovel.getEndereco().getZona());
        }
        if (imovel.getEndereco().getNomeCondominio().equals(" ")) {
            jtfCondominio.setText("");
        } else {
            jtfCondominio.setText(imovel.getEndereco().getNomeCondominio());
        }
// fim endereços

        //valores 
        jtValorIptu.setText(String.valueOf(imovel.getValorIptu()));
        jtValorCondominio.setText(String.valueOf(imovel.getValorCondominio()));

        //Outros 
        if (imovel.getDocumentacao().getNumMatricula().equals(" ")) {
            jtMatriculo.setText("");
        } else {
            jtMatriculo.setText(imovel.getDocumentacao().getNumMatricula());

        }
        if (imovel.getDocumentacao().getNumContaAgua().equals(" ")) {
            jtContaAgua.setText("");
        } else {

            jtContaAgua.setText(imovel.getDocumentacao().getNumContaAgua());
        }

        if (imovel.getDocumentacao().getNumContaLuz().equals(" ")) {
            jtContaLuz.setText("");
        } else {
            jtContaLuz.setText(imovel.getDocumentacao().getNumContaLuz());
        }

        if (imovel.getDocumentacao().getNumIptu().equals(" ")) {

            jtIptu.setText("");
        } else {
            jtIptu.setText(String.valueOf(imovel.getDocumentacao().getNumIptu()));
        }

        if (imovel.getDocumentacao().getNumContrato().equals(" ")) {
            jtContrato.setText("");

        } else {
            jtContrato.setText(imovel.getDocumentacao().getNumContrato());
        }

        if (imovel.getDocumentacao().getCartorio().equals(" ")) {
            jtCartorio.setText("");
        } else {
            jtCartorio.setText(imovel.getDocumentacao().getCartorio());
        }
        if (imovel.getTerreno().getSituacaoEscritura().equals(" ")) {
            jtSituacaoEscritura.setText("");
        } else {
            jtSituacaoEscritura.setText(imovel.getTerreno().getSituacaoEscritura());
        }
        if (imovel.getTerreno().getLargura() == 0) {
            jtLargura.setText("");
        } else {

            jtLargura.setText(String.valueOf(imovel.getTerreno().getLargura()));
        }
        if (imovel.getTerreno().getComprimento() == 0) {
            jtComprimento.setText("");
        } else {
            jtComprimento.setText(String.valueOf(imovel.getTerreno().getComprimento()));
        }
        if (imovel.getTerreno().getAreaConstruida() == 0) {
            jtAreaConstruida.setText("");
        } else {
            jtAreaConstruida.setText(String.valueOf(imovel.getTerreno().getAreaConstruida()));
        }

        if (!jtLargura.getText().equals(null) && !jtLargura.getText().equals(0) && !jtComprimento.getText().equals(null) && !jtComprimento.getText().equals(0)) {
            double x = imovel.getTerreno().getAreaConstruida();
            double y = imovel.getTerreno().getComprimento();
            x = x * y;
            jtTamanhoTerreno.setText(String.valueOf(x));

        } else {

            jtTamanhoTerreno.setText("");
        }

        if (imovel.getDescMobilia().equals(" ")) {
            jtMobilia.setText("");
        } else {
            jtMobilia.setText(imovel.getDescMobilia());
        }
        if (imovel.getChaves().equals(" ")) {
            jtChaves.setText("");
        } else {
            jtChaves.setText(imovel.getChaves());
        }
        if (imovel.getObservacoes().equals(" ")) {
            jtObservacao.setText("");
        } else {
            jtObservacao.setText(imovel.getObservacoes());
        }

        //Descrição  
        if (imovel.getQtdQuartos() == 0) {
            jtQuartos.setText("");
        } else {
            jtQuartos.setText(String.valueOf(imovel.getQtdQuartos()));
        }
        if (imovel.getQtdSuites() == 0) {
            jtSuites.setText("");
        } else {
            jtSuites.setText(String.valueOf(imovel.getQtdSuites()));
        }
        if (imovel.getQtdSalas() == 0) {
            jtSalas.setText("");
        } else {
            jtSalas.setText(String.valueOf(imovel.getQtdSalas()));
        }
        if (imovel.getQtdBanheiros() == 0) {
            jtBanheiros.setText("");
        } else {
            jtBanheiros.setText(String.valueOf(imovel.getQtdBanheiros()));
        }
        if (imovel.getLavabos() == 0) {
            jtLavados.setText("");
        } else {
            jtLavados.setText(String.valueOf(imovel.getLavabos()));
        }

        if (imovel.getAreaServico() == 0) {
            jtAreaServico.setText("");
        } else {
            jtAreaServico.setText(String.valueOf(imovel.getAreaServico()));
        }

        if (imovel.getLavanderia() == 0) {
            jtLavanderia.setText("");
        } else {
            jtLavanderia.setText(String.valueOf(imovel.getLavanderia()));
        }

        if (imovel.getQtdPisos() == 0) {
            jtPisos.setText("");
        } else {
            jtPisos.setText(String.valueOf(imovel.getQtdPisos()));
        }

        if (imovel.getAnoConstrucao() == 0) {
            jtIdadeImovel.setText("");
        } else {
            jtIdadeImovel.setText(String.valueOf(imovel.getAnoConstrucao()));
        }

        if (imovel.getPiscina() == 0) {
            jtPscina.setText("");
        } else {
            jtPscina.setText(String.valueOf(imovel.getPiscina()));
        }
        if (imovel.getVagasGaragem() == 0) {
            jtVagasGaragem.setText("");
        } else {
            jtVagasGaragem.setText(String.valueOf(imovel.getVagasGaragem()));
        }
        if (imovel.getDepEmpregados() == 0) {
            jtDepEmpregada.setText("");
        } else {
            jtDepEmpregada.setText(String.valueOf(imovel.getDepEmpregados()));
        }

        if (imovel.getDescImovel().equals(" ")) {
            jtTipoImovel.setText("");
        } else {
            jtTipoImovel.setText(imovel.getDescImovel());
        }
        if (imovel.getAreaExterna().equals(" ")) {
            jtAreaExterna.setText("");
        } else {
            jtAreaExterna.setText(imovel.getAreaExterna());
        }
        if (imovel.getAcabamento().equals(" ")) {
            jtAcabamento.setText("");
        } else {
            jtAcabamento.setText(imovel.getAcabamento());
        }
        if (imovel.getOutrosItens().equals(" ")) {
            jtOutros.setText("");
        } else {
            jtOutros.setText(imovel.getOutrosItens());
        }

    }

    public void removerTitleBar() {

        ((javax.swing.plaf.basic.BasicInternalFrameUI) jifEndereco.getUI()).setNorthPane(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) jifOutros.getUI()).setNorthPane(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) jifDescricao.getUI()).setNorthPane(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) jifValores.getUI()).setNorthPane(null);

    }

    public void fecharCadastro() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {

//                if (COLOCAR VERIFICACAO) {
//                    int resposta = JOptionPane.showConfirmDialog(null,
//                            "Cadastro não salvo, Deseja salvar antes de sair?",
//                            "Segurança",
//                            JOptionPane.YES_NO_OPTION);
//                    if (resposta == 1) {
//
//                        System.exit(0);
//
//                    } else {
//
//                    }
//
//                } else {
                String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    dispose();
                }
//                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgMobilia = new javax.swing.ButtonGroup();
        bgTipo = new javax.swing.ButtonGroup();
        jtpCadastro = new javax.swing.JTabbedPane();
        jifEndereco = new javax.swing.JInternalFrame();
        jlComplemento = new javax.swing.JLabel();
        jlZona = new javax.swing.JLabel();
        jlReferencia = new javax.swing.JLabel();
        jlCondominio = new javax.swing.JLabel();
        jlNumero = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jlLogradouro = new javax.swing.JLabel();
        jtfBairro = new javax.swing.JTextField();
        jtfLogradouro = new javax.swing.JTextField();
        jtfNumero = new javax.swing.JTextField();
        jtfCondominio = new javax.swing.JTextField();
        jtfZona = new javax.swing.JTextField();
        jtfComplemento = new javax.swing.JTextField();
        jtfReferencia = new javax.swing.JTextField();
        jcbEstado = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jtCep = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbCidade = new javax.swing.JComboBox<>();
        jifValores = new javax.swing.JInternalFrame();
        jlValorLocacao = new javax.swing.JLabel();
        jlValorIPTU = new javax.swing.JLabel();
        jlValorCondominio = new javax.swing.JLabel();
        jlValorVenda = new javax.swing.JLabel();
        jlValorTemporada = new javax.swing.JLabel();
        jlValorFesta = new javax.swing.JLabel();
        jtValorLocacaoMes = new javax.swing.JTextField();
        jtValorVenda = new javax.swing.JTextField();
        jtValorCondominio = new javax.swing.JTextField();
        jtValorTemporada = new javax.swing.JTextField();
        jtValorIptu = new javax.swing.JTextField();
        jtValorDiaria = new javax.swing.JTextField();
        jifOutros = new javax.swing.JInternalFrame();
        jLabel34 = new javax.swing.JLabel();
        jtAreaConstruida = new javax.swing.JTextField();
        jlTamanhoTotal = new javax.swing.JLabel();
        jtSituacaoEscritura = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jtTamanhoTerreno = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtChaves = new javax.swing.JTextArea();
        jLabel40 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtMobilia = new javax.swing.JTextArea();
        jtMatriculo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtContrato = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtContaAgua = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtIptu = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtContaLuz = new javax.swing.JTextField();
        jtCartorio = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtObservacao = new javax.swing.JTextArea();
        jrbMobiliada = new javax.swing.JRadioButton();
        jrbSemiMobiliada = new javax.swing.JRadioButton();
        jrbSemMobilia = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jtComprimento = new javax.swing.JTextField();
        jtLargura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jifDescricao = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jtSalas = new javax.swing.JTextField();
        jtBanheiros = new javax.swing.JTextField();
        jtLavanderia = new javax.swing.JTextField();
        jtSuites = new javax.swing.JTextField();
        jtQuartos = new javax.swing.JTextField();
        jtLavados = new javax.swing.JTextField();
        jtAreaServico = new javax.swing.JTextField();
        jtPscina = new javax.swing.JTextField();
        jtDepEmpregada = new javax.swing.JTextField();
        jtPisos = new javax.swing.JTextField();
        jtVagasGaragem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTipoImovel = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAreaExterna = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtAcabamento = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtOutros = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtIdadeImovel = new javax.swing.JTextField();
        jlCodigo = new javax.swing.JLabel();
        jcbLocacao = new javax.swing.JCheckBox();
        jtCodigo = new javax.swing.JTextField();
        jcbVenda = new javax.swing.JCheckBox();
        jcbTemporada = new javax.swing.JCheckBox();
        jcbFesta = new javax.swing.JCheckBox();
        jlTipo = new javax.swing.JLabel();
        jrbCasa = new javax.swing.JRadioButton();
        jrbApartamento = new javax.swing.JRadioButton();
        jrbSalao = new javax.swing.JRadioButton();
        jrbComercio = new javax.swing.JRadioButton();
        jrbCondominio = new javax.swing.JRadioButton();
        jlStatus = new javax.swing.JLabel();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jcbStatus = new javax.swing.JComboBox<>();
        jsInteresse = new javax.swing.JSeparator();
        jsTipo = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        jtpCadastro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jifEndereco.setVisible(true);
        jifEndereco.getContentPane().setLayout(null);

        jlComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComplemento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlComplemento.setText("Complemento:");
        jifEndereco.getContentPane().add(jlComplemento);
        jlComplemento.setBounds(380, 140, 100, 30);

        jlZona.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlZona.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlZona.setText("Zona:");
        jifEndereco.getContentPane().add(jlZona);
        jlZona.setBounds(20, 140, 120, 30);

        jlReferencia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlReferencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlReferencia.setText("Referência:");
        jifEndereco.getContentPane().add(jlReferencia);
        jlReferencia.setBounds(20, 180, 120, 30);

        jlCondominio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCondominio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCondominio.setText("Condomínio:");
        jifEndereco.getContentPane().add(jlCondominio);
        jlCondominio.setBounds(20, 220, 120, 30);

        jlNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNumero.setText("Número:");
        jifEndereco.getContentPane().add(jlNumero);
        jlNumero.setBounds(260, 60, 60, 30);

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlBairro.setText("Bairro:");
        jifEndereco.getContentPane().add(jlBairro);
        jlBairro.setBounds(380, 60, 60, 30);

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCidade.setText("Cidade:");
        jifEndereco.getContentPane().add(jlCidade);
        jlCidade.setBounds(20, 100, 120, 30);

        jlLogradouro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlLogradouro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlLogradouro.setText("Logradouro:");
        jifEndereco.getContentPane().add(jlLogradouro);
        jlLogradouro.setBounds(24, 20, 120, 30);

        jtfBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifEndereco.getContentPane().add(jtfBairro);
        jtfBairro.setBounds(450, 60, 310, 30);

        jtfLogradouro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifEndereco.getContentPane().add(jtfLogradouro);
        jtfLogradouro.setBounds(150, 20, 610, 30);

        jtfNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNumeroActionPerformed(evt);
            }
        });
        jifEndereco.getContentPane().add(jtfNumero);
        jtfNumero.setBounds(330, 60, 40, 30);

        jtfCondominio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifEndereco.getContentPane().add(jtfCondominio);
        jtfCondominio.setBounds(150, 220, 610, 30);

        jtfZona.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifEndereco.getContentPane().add(jtfZona);
        jtfZona.setBounds(150, 140, 90, 30);

        jtfComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifEndereco.getContentPane().add(jtfComplemento);
        jtfComplemento.setBounds(490, 140, 270, 30);

        jtfReferencia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifEndereco.getContentPane().add(jtfReferencia);
        jtfReferencia.setBounds(150, 180, 610, 30);

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });
        jifEndereco.getContentPane().add(jcbEstado);
        jcbEstado.setBounds(450, 100, 310, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Estado:");
        jifEndereco.getContentPane().add(jLabel7);
        jLabel7.setBounds(380, 100, 60, 30);

        jtCep.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifEndereco.getContentPane().add(jtCep);
        jtCep.setBounds(150, 60, 100, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("CEP:");
        jifEndereco.getContentPane().add(jLabel8);
        jLabel8.setBounds(90, 60, 50, 30);

        jcbCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jifEndereco.getContentPane().add(jcbCidade);
        jcbCidade.setBounds(150, 100, 220, 30);

        jtpCadastro.addTab("Endereço", jifEndereco);

        jifValores.setVisible(true);
        jifValores.getContentPane().setLayout(null);

        jlValorLocacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlValorLocacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlValorLocacao.setText("Valor de Locação Mensal:");
        jifValores.getContentPane().add(jlValorLocacao);
        jlValorLocacao.setBounds(10, 20, 240, 30);

        jlValorIPTU.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlValorIPTU.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlValorIPTU.setText("Valor do IPTU:");
        jifValores.getContentPane().add(jlValorIPTU);
        jlValorIPTU.setBounds(380, 20, 110, 30);

        jlValorCondominio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlValorCondominio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlValorCondominio.setText("Valor do Condomínio:");
        jifValores.getContentPane().add(jlValorCondominio);
        jlValorCondominio.setBounds(80, 140, 170, 30);

        jlValorVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlValorVenda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlValorVenda.setText("Valor para Venda do Imóvel:");
        jifValores.getContentPane().add(jlValorVenda);
        jlValorVenda.setBounds(10, 60, 240, 30);

        jlValorTemporada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlValorTemporada.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlValorTemporada.setText("Valor para Aluguel em Temporada:");
        jifValores.getContentPane().add(jlValorTemporada);
        jlValorTemporada.setBounds(10, 100, 240, 30);

        jlValorFesta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlValorFesta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlValorFesta.setText("Valor do Aluguel para Festas:");
        jifValores.getContentPane().add(jlValorFesta);
        jlValorFesta.setBounds(20, 180, 230, 30);

        jtValorLocacaoMes.setEditable(false);
        jtValorLocacaoMes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtValorLocacaoMes.setEnabled(false);
        jifValores.getContentPane().add(jtValorLocacaoMes);
        jtValorLocacaoMes.setBounds(260, 20, 100, 30);

        jtValorVenda.setEditable(false);
        jtValorVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtValorVenda.setEnabled(false);
        jifValores.getContentPane().add(jtValorVenda);
        jtValorVenda.setBounds(260, 60, 100, 30);

        jtValorCondominio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifValores.getContentPane().add(jtValorCondominio);
        jtValorCondominio.setBounds(260, 140, 100, 30);

        jtValorTemporada.setEditable(false);
        jtValorTemporada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtValorTemporada.setEnabled(false);
        jifValores.getContentPane().add(jtValorTemporada);
        jtValorTemporada.setBounds(260, 100, 100, 30);

        jtValorIptu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifValores.getContentPane().add(jtValorIptu);
        jtValorIptu.setBounds(500, 20, 100, 30);

        jtValorDiaria.setEditable(false);
        jtValorDiaria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtValorDiaria.setEnabled(false);
        jifValores.getContentPane().add(jtValorDiaria);
        jtValorDiaria.setBounds(260, 180, 100, 30);

        jtpCadastro.addTab("Valores", jifValores);

        jifOutros.setVisible(true);
        jifOutros.getContentPane().setLayout(null);

        jLabel34.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Área Construida:");
        jifOutros.getContentPane().add(jLabel34);
        jLabel34.setBounds(350, 100, 110, 30);

        jtAreaConstruida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifOutros.getContentPane().add(jtAreaConstruida);
        jtAreaConstruida.setBounds(470, 100, 50, 30);

        jlTamanhoTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTamanhoTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTamanhoTotal.setText("Total:");
        jifOutros.getContentPane().add(jlTamanhoTotal);
        jlTamanhoTotal.setBounds(350, 140, 110, 30);

        jtSituacaoEscritura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifOutros.getContentPane().add(jtSituacaoEscritura);
        jtSituacaoEscritura.setBounds(200, 260, 110, 30);
        jtSituacaoEscritura.getAccessibleContext().setAccessibleName("");

        jLabel37.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Situação Escritura:");
        jifOutros.getContentPane().add(jLabel37);
        jLabel37.setBounds(10, 260, 180, 30);
        jLabel37.getAccessibleContext().setAccessibleName("");

        jtTamanhoTerreno.setEditable(false);
        jtTamanhoTerreno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtTamanhoTerreno.setEnabled(false);
        jifOutros.getContentPane().add(jtTamanhoTerreno);
        jtTamanhoTerreno.setBounds(470, 140, 50, 30);

        jtChaves.setColumns(20);
        jtChaves.setRows(5);
        jScrollPane6.setViewportView(jtChaves);

        jifOutros.getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(570, 50, 190, 60);

        jLabel40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Chaves");
        jifOutros.getContentPane().add(jLabel40);
        jLabel40.setBounds(570, 20, 190, 30);

        jLabel46.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Observaçoes Gerais");
        jifOutros.getContentPane().add(jLabel46);
        jLabel46.setBounds(570, 110, 190, 30);

        jtMobilia.setColumns(20);
        jtMobilia.setRows(5);
        jScrollPane5.setViewportView(jtMobilia);

        jifOutros.getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(570, 230, 190, 60);

        jtMatriculo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifOutros.getContentPane().add(jtMatriculo);
        jtMatriculo.setBounds(200, 20, 110, 30);
        jtMatriculo.getAccessibleContext().setAccessibleName("");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Número de Matricula:");
        jifOutros.getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 20, 180, 30);
        jLabel15.getAccessibleContext().setAccessibleName("");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Número da Conta de Agua:");
        jifOutros.getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 60, 180, 30);
        jLabel16.getAccessibleContext().setAccessibleName("");

        jtContrato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifOutros.getContentPane().add(jtContrato);
        jtContrato.setBounds(200, 180, 110, 30);
        jtContrato.getAccessibleContext().setAccessibleName("");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Número de Conta de luz:");
        jifOutros.getContentPane().add(jLabel17);
        jLabel17.setBounds(10, 100, 180, 30);
        jLabel17.getAccessibleContext().setAccessibleName("");

        jtContaAgua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifOutros.getContentPane().add(jtContaAgua);
        jtContaAgua.setBounds(200, 60, 110, 30);
        jtContaAgua.getAccessibleContext().setAccessibleName("");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Número do IPTU:");
        jifOutros.getContentPane().add(jLabel18);
        jLabel18.setBounds(10, 140, 180, 30);
        jLabel18.getAccessibleContext().setAccessibleName("");

        jtIptu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifOutros.getContentPane().add(jtIptu);
        jtIptu.setBounds(200, 140, 110, 30);
        jtIptu.getAccessibleContext().setAccessibleName("");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Cartorio:");
        jifOutros.getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 220, 180, 30);
        jLabel19.getAccessibleContext().setAccessibleName("");

        jtContaLuz.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtContaLuz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtContaLuzActionPerformed(evt);
            }
        });
        jifOutros.getContentPane().add(jtContaLuz);
        jtContaLuz.setBounds(200, 100, 110, 30);
        jtContaLuz.getAccessibleContext().setAccessibleName("");

        jtCartorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifOutros.getContentPane().add(jtCartorio);
        jtCartorio.setBounds(200, 220, 110, 30);
        jtCartorio.getAccessibleContext().setAccessibleName("");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Número do Contrato:");
        jifOutros.getContentPane().add(jLabel20);
        jLabel20.setBounds(10, 180, 180, 30);
        jLabel20.getAccessibleContext().setAccessibleName("");

        jtObservacao.setColumns(20);
        jtObservacao.setRows(5);
        jScrollPane8.setViewportView(jtObservacao);

        jifOutros.getContentPane().add(jScrollPane8);
        jScrollPane8.setBounds(570, 140, 190, 60);

        bgMobilia.add(jrbMobiliada);
        jrbMobiliada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbMobiliada.setText("Mobiliada");
        jrbMobiliada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jifOutros.getContentPane().add(jrbMobiliada);
        jrbMobiliada.setBounds(360, 180, 180, 30);

        bgMobilia.add(jrbSemiMobiliada);
        jrbSemiMobiliada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbSemiMobiliada.setText("Semi Mobiliada");
        jrbSemiMobiliada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jifOutros.getContentPane().add(jrbSemiMobiliada);
        jrbSemiMobiliada.setBounds(360, 220, 180, 30);

        bgMobilia.add(jrbSemMobilia);
        jrbSemMobilia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbSemMobilia.setText("Sem Mobilia");
        jrbSemMobilia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jifOutros.getContentPane().add(jrbSemMobilia);
        jrbSemMobilia.setBounds(360, 260, 180, 30);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setAlignmentX(2.0F);
        jSeparator1.setAlignmentY(2.0F);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jifOutros.getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 10, 320, 300);

        jtComprimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifOutros.getContentPane().add(jtComprimento);
        jtComprimento.setBounds(470, 60, 50, 30);

        jtLargura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifOutros.getContentPane().add(jtLargura);
        jtLargura.setBounds(470, 20, 50, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Comprimento:");
        jifOutros.getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 60, 110, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Largura:");
        jifOutros.getContentPane().add(jLabel6);
        jLabel6.setBounds(350, 20, 110, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("M");
        jifOutros.getContentPane().add(jLabel9);
        jLabel9.setBounds(530, 20, 20, 30);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("M²");
        jifOutros.getContentPane().add(jLabel10);
        jLabel10.setBounds(530, 140, 20, 30);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("M²");
        jifOutros.getContentPane().add(jLabel11);
        jLabel11.setBounds(530, 100, 20, 30);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("M");
        jifOutros.getContentPane().add(jLabel12);
        jLabel12.setBounds(530, 60, 20, 30);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Descrição da Mobília");
        jifOutros.getContentPane().add(jLabel13);
        jLabel13.setBounds(570, 200, 190, 30);

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jifOutros.getContentPane().add(jSeparator2);
        jSeparator2.setBounds(340, 10, 430, 300);

        jtpCadastro.addTab("Outros", jifOutros);

        jifDescricao.setVisible(true);
        jifDescricao.getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Quartos:");
        jifDescricao.getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 110, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Suites:");
        jifDescricao.getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 50, 110, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Salas:");
        jifDescricao.getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 90, 110, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Lavanderia:");
        jifDescricao.getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 210, 110, 30);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Vagas Garagem:");
        jifDescricao.getContentPane().add(jLabel23);
        jLabel23.setBounds(200, 50, 130, 30);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Area de serviço:");
        jifDescricao.getContentPane().add(jLabel24);
        jLabel24.setBounds(10, 250, 110, 30);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Piscina:");
        jifDescricao.getContentPane().add(jLabel25);
        jLabel25.setBounds(200, 10, 130, 30);

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Lavabos:");
        jifDescricao.getContentPane().add(jLabel26);
        jLabel26.setBounds(10, 170, 110, 30);

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Banheiros:");
        jifDescricao.getContentPane().add(jLabel27);
        jLabel27.setBounds(10, 130, 110, 30);

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Dep. Empregada:");
        jifDescricao.getContentPane().add(jLabel28);
        jLabel28.setBounds(200, 90, 130, 30);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Pisos (Andares):");
        jifDescricao.getContentPane().add(jLabel29);
        jLabel29.setBounds(200, 130, 130, 30);

        jtSalas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtSalas);
        jtSalas.setBounds(130, 90, 60, 30);

        jtBanheiros.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtBanheiros);
        jtBanheiros.setBounds(130, 130, 60, 30);

        jtLavanderia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtLavanderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtLavanderiaActionPerformed(evt);
            }
        });
        jifDescricao.getContentPane().add(jtLavanderia);
        jtLavanderia.setBounds(130, 210, 60, 30);

        jtSuites.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtSuites);
        jtSuites.setBounds(130, 50, 60, 30);

        jtQuartos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtQuartos);
        jtQuartos.setBounds(130, 10, 60, 30);

        jtLavados.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtLavados);
        jtLavados.setBounds(130, 170, 60, 30);

        jtAreaServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtAreaServico);
        jtAreaServico.setBounds(130, 250, 60, 30);

        jtPscina.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtPscina);
        jtPscina.setBounds(340, 10, 60, 30);

        jtDepEmpregada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtDepEmpregada);
        jtDepEmpregada.setBounds(340, 90, 60, 30);

        jtPisos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtPisos);
        jtPisos.setBounds(340, 130, 60, 30);

        jtVagasGaragem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtVagasGaragem);
        jtVagasGaragem.setBounds(340, 50, 60, 30);

        jtTipoImovel.setColumns(20);
        jtTipoImovel.setRows(5);
        jScrollPane1.setViewportView(jtTipoImovel);

        jifDescricao.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(550, 10, 200, 70);

        jtAreaExterna.setColumns(20);
        jtAreaExterna.setRows(5);
        jScrollPane2.setViewportView(jtAreaExterna);

        jifDescricao.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(550, 90, 200, 60);

        jtAcabamento.setColumns(20);
        jtAcabamento.setRows(5);
        jScrollPane3.setViewportView(jtAcabamento);

        jifDescricao.getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(550, 160, 200, 60);

        jLabel30.setText("Descrição Imovel");
        jifDescricao.getContentPane().add(jLabel30);
        jLabel30.setBounds(430, 20, 110, 14);

        jLabel31.setText("Area Externa");
        jifDescricao.getContentPane().add(jLabel31);
        jLabel31.setBounds(460, 90, 80, 14);

        jtOutros.setColumns(20);
        jtOutros.setRows(5);
        jScrollPane4.setViewportView(jtOutros);

        jifDescricao.getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(550, 230, 200, 60);

        jLabel33.setText("Acabamento");
        jifDescricao.getContentPane().add(jLabel33);
        jLabel33.setBounds(460, 160, 80, 14);

        jLabel32.setText("Outros");
        jifDescricao.getContentPane().add(jLabel32);
        jLabel32.setBounds(490, 230, 50, 14);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Ano da Construção :");
        jifDescricao.getContentPane().add(jLabel14);
        jLabel14.setBounds(200, 170, 130, 30);

        jtIdadeImovel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jifDescricao.getContentPane().add(jtIdadeImovel);
        jtIdadeImovel.setBounds(340, 170, 60, 30);

        jtpCadastro.addTab("Descrição", jifDescricao);

        getContentPane().add(jtpCadastro);
        jtpCadastro.setBounds(160, 80, 820, 380);

        jlCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigo.setText("Código Interno:");
        getContentPane().add(jlCodigo);
        jlCodigo.setBounds(40, 20, 100, 30);

        jcbLocacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbLocacao.setText("Locação");
        jcbLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbLocacaoMouseClicked(evt);
            }
        });
        getContentPane().add(jcbLocacao);
        jcbLocacao.setBounds(40, 130, 100, 30);

        jtCodigo.setEditable(false);
        getContentPane().add(jtCodigo);
        jtCodigo.setBounds(150, 20, 80, 30);

        jcbVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbVenda.setText("Venda");
        jcbVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbVendaMouseClicked(evt);
            }
        });
        getContentPane().add(jcbVenda);
        jcbVenda.setBounds(40, 170, 100, 30);

        jcbTemporada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbTemporada.setText("Temporada");
        jcbTemporada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbTemporadaMouseClicked(evt);
            }
        });
        getContentPane().add(jcbTemporada);
        jcbTemporada.setBounds(40, 210, 100, 30);

        jcbFesta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbFesta.setText("Festa");
        jcbFesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbFestaMouseClicked(evt);
            }
        });
        jcbFesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFestaActionPerformed(evt);
            }
        });
        getContentPane().add(jcbFesta);
        jcbFesta.setBounds(40, 250, 100, 30);

        jlTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTipo.setText("Tipo:");
        getContentPane().add(jlTipo);
        jlTipo.setBounds(250, 20, 40, 30);

        bgTipo.add(jrbCasa);
        jrbCasa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbCasa.setText("Casa");
        getContentPane().add(jrbCasa);
        jrbCasa.setBounds(290, 20, 59, 30);

        bgTipo.add(jrbApartamento);
        jrbApartamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbApartamento.setText("Apartamento");
        getContentPane().add(jrbApartamento);
        jrbApartamento.setBounds(360, 20, 107, 30);

        bgTipo.add(jrbSalao);
        jrbSalao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbSalao.setText("Salão");
        getContentPane().add(jrbSalao);
        jrbSalao.setBounds(470, 20, 61, 30);

        bgTipo.add(jrbComercio);
        jrbComercio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbComercio.setText("Comércio");
        jrbComercio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbComercioActionPerformed(evt);
            }
        });
        getContentPane().add(jrbComercio);
        jrbComercio.setBounds(540, 20, 85, 30);

        bgTipo.add(jrbCondominio);
        jrbCondominio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbCondominio.setText("Temporario");
        getContentPane().add(jrbCondominio);
        jrbCondominio.setBounds(630, 20, 99, 30);

        jlStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlStatus.setText("Status:");
        getContentPane().add(jlStatus);
        jlStatus.setBounds(740, 20, 50, 30);

        jbConfirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbConfirmar.setText("Confirmar");
        jbConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConfirmarMouseClicked(evt);
            }
        });
        getContentPane().add(jbConfirmar);
        jbConfirmar.setBounds(540, 470, 140, 70);

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar);
        jbCancelar.setBounds(840, 470, 140, 70);

        jbEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar2.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEditarMouseClicked(evt);
            }
        });
        getContentPane().add(jbEditar);
        jbEditar.setBounds(690, 470, 140, 70);

        jcbStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbStatusActionPerformed(evt);
            }
        });
        getContentPane().add(jcbStatus);
        jcbStatus.setBounds(800, 20, 170, 30);

        jsInteresse.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jsInteresse);
        jsInteresse.setBounds(30, 120, 120, 170);

        jsTipo.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jsTipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jsTipo);
        jsTipo.setBounds(30, 10, 950, 50);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbFestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFestaActionPerformed

    private void jtfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNumeroActionPerformed

    private void jrbComercioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbComercioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbComercioActionPerformed

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        new cadastroImovelHome().setVisible(true);
        dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jcbFestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbFestaMouseClicked

        if (jcbFesta.isSelected()) {
            jtValorDiaria.setEditable(true);
            jtValorDiaria.setEnabled(true);

        } else {
            jtValorDiaria.setEditable(false);
            jtValorDiaria.setEnabled(false);
            jtValorDiaria.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jcbFestaMouseClicked

    private void jcbTemporadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbTemporadaMouseClicked

        if (jcbTemporada.isSelected()) {
            jtValorTemporada.setEditable(true);
            jtValorTemporada.setEnabled(true);

        } else {
            jtValorTemporada.setEditable(false);
            jtValorTemporada.setEnabled(false);
            jtValorTemporada.setText("");
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jcbTemporadaMouseClicked

    private void jcbVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbVendaMouseClicked

        if (jcbVenda.isSelected()) {
            jtValorVenda.setEditable(true);
            jtValorVenda.setEnabled(true);

        } else {
            jtValorVenda.setEditable(false);
            jtValorVenda.setEnabled(false);
            jtValorVenda.setText("");
        } // TODO add your handling code here:
    }//GEN-LAST:event_jcbVendaMouseClicked

    private void jcbLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbLocacaoMouseClicked
        if (jcbLocacao.isSelected()) {
            jtValorLocacaoMes.setEditable(true);
            jtValorLocacaoMes.setEnabled(true);

        } else {
            jtValorLocacaoMes.setEditable(false);
            jtValorLocacaoMes.setEnabled(false);
            jtValorLocacaoMes.setText("");
        } // TODO add your handling code here:
    }//GEN-LAST:event_jcbLocacaoMouseClicked

    private void jbConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMouseClicked

        if (jbConfirmar.isEnabled()) {
            int control = 0;
            boolean control2 = true;

            Imovel imovel;
            Status status;
            Endereco endereco;
            Cidade cidade;
            Estado uf;
            Documentacao documentacao;
            Terreno terreno;

            TipoImovelDAO tipoImovelDao = new TipoImovelDAO();

            TipoImovel tipoImovel = new TipoImovel();
            List<TipoImovel> tipoImovelTemp = new ArrayList<>();
            tipoImovelTemp = tipoImovelDao.getAll();

            TipoContratoDAO tipoContratoDao = new TipoContratoDAO();;

            if (this.getImovel() == null) {
                imovel = new Imovel();
                status = new Status();
                endereco = new Endereco();
                cidade = new Cidade();
                uf = new Estado();
                documentacao = new Documentacao();
                terreno = new Terreno();

                // arrumar valores no merge
                List<TipoContrato> tipoContrato = new ArrayList<>();
                tipoContrato = tipoContratoDao.getAll();

                // Fora das tabs..
                if (jcbLocacao.isSelected()) {
                    if (jtValorLocacaoMes.getText().equals("")) {
                        jtValorLocacaoMes.setBackground(Color.white);
                    } else if (!jtValorLocacaoMes.getText().equals("") && validacao.validaNumeros(jtValorLocacaoMes.getText())) {
                        imovel.addTipoContrato(tipoContrato.get(0), Double.valueOf(jtValorLocacaoMes.getText()));

                        jtValorLocacaoMes.setBackground(Color.white);
                    } else {
                        control2 = false;
                        jtValorLocacaoMes.setBackground(Color.red);

                    }
                } else {

                }
                if (jcbVenda.isSelected()) {
                    if (jtValorVenda.getText().equals("")) {
                        jtValorVenda.setBackground(Color.white);
                    } else if (!jtValorVenda.getText().equals("") && validacao.validaNumeros(jtValorVenda.getText())) {

                        imovel.addTipoContrato(tipoContrato.get(1), Double.valueOf(jtValorVenda.getText()));

                        jtValorVenda.setBackground(Color.white);
                    } else {
                        control2 = false;
                        jtValorVenda.setBackground(Color.red);

                    }
                } else {

                }

                if (jcbTemporada.isSelected()) {
                    if (jtValorTemporada.getText().equals("")) {
                        jtValorTemporada.setBackground(Color.white);
                    } else if (!jtValorTemporada.getText().equals("") && validacao.validaNumeros(jtValorTemporada.getText())) {
                        imovel.addTipoContrato(tipoContrato.get(2), Double.valueOf(jtValorTemporada.getText()));

                        jtValorTemporada.setBackground(Color.white);
                    } else {
                        control2 = false;
                        jtValorTemporada.setBackground(Color.red);

                    }
                } else {

                }

                if (jcbFesta.isSelected()) {
                    if (jtValorDiaria.getText().equals("")) {

                        jtValorDiaria.setBackground(Color.white);

                    } else if (!jtValorDiaria.getText().equals("") && validacao.validaNumeros(jtValorDiaria.getText())) {
                        imovel.addTipoContrato(tipoContrato.get(3), Double.valueOf(jtValorDiaria.getText()));

                        jtValorDiaria.setBackground(Color.white);
                    } else {
                        control2 = false;
                        jtValorDiaria.setBackground(Color.red);

                    }
                } else {

                }

            } else {
                imovel = imovelTemp;
                status = imovel.getStatus();
                endereco = imovel.getEndereco();
                cidade = new Cidade();

                documentacao = imovel.getDocumentacao();
                terreno = imovel.getTerreno();
                List<Imovel_has_TipoContrato> tipoContrato = imovel.getTiposContratos();

                List<TipoContrato> tipoContrato2 = new ArrayList<>();
                tipoContrato2 = tipoContratoDao.getAll();

                boolean locacao = false;
                boolean venda = false;
                boolean temporada = false;
                boolean festa = false;
                int locacao1 = 0;
                int venda1 = 0;
                int temporada1 = 0;
                int festa1 = 0;

                for (int i = 0; i < tipoContrato.size(); i++) {
                    if (tipoContrato.get(i).getTipoContrato().getIdTipoContrato() == 1) {
                        locacao = true;
                        locacao1 = i;

                    } else if (tipoContrato.get(i).getTipoContrato().getIdTipoContrato() == 2) {
                        venda = true;
                        venda1 = i;

                    } else if (tipoContrato.get(i).getTipoContrato().getIdTipoContrato() == 3) {
                        temporada = true;
                        temporada1 = i;
                    } else if (tipoContrato.get(i).getTipoContrato().getIdTipoContrato() == 4) {
                        festa = true;
                        festa1 = i;
                    }

                }

                //  Fora das tabs..
                if (jcbLocacao.isSelected()) {
                    if (jtValorLocacaoMes.getText().equals("")) {
                        jtValorLocacaoMes.setBackground(Color.white);
                    } else if (!jtValorLocacaoMes.getText().equals("") && validacao.validaNumeros(jtValorLocacaoMes.getText())) {

                        if (locacao) {
                            tipoContrato.get(locacao1).setValor(Double.valueOf(jtValorLocacaoMes.getText()));

                        } else {
                            imovel.addTipoContrato(tipoContrato2.get(0), Double.valueOf(jtValorLocacaoMes.getText()));

                        }

                        jtValorLocacaoMes.setBackground(Color.white);
                    } else {
                        control2 = false;
                        jtValorLocacaoMes.setBackground(Color.red);

                    }
                } else if (locacao) {
                    tipoContrato.get(locacao1).setValor(0);

                }
                if (jcbVenda.isSelected()) {
                    if (jtValorVenda.getText().equals("")) {
                        jtValorVenda.setBackground(Color.white);
                    } else if (!jtValorVenda.getText().equals("") && validacao.validaNumeros(jtValorVenda.getText())) {

                        if (venda) {
                            tipoContrato.get(venda1).setValor(Double.valueOf(jtValorVenda.getText()));

                        } else {
                            imovel.addTipoContrato(tipoContrato2.get(1), Double.valueOf(jtValorVenda.getText()));

                        }

                        jtValorVenda.setBackground(Color.white);
                    } else {
                        control2 = false;
                        jtValorVenda.setBackground(Color.red);

                    }
                } else if (venda) {
                    tipoContrato.get(venda1).setValor(0);
                }

                if (jcbTemporada.isSelected()) {
                    if (jtValorTemporada.getText().equals("")) {
                        jtValorTemporada.setBackground(Color.white);
                    } else if (!jtValorTemporada.getText().equals("") && validacao.validaNumeros(jtValorTemporada.getText())) {

                        if (temporada) {
                            tipoContrato.get(temporada1).setValor(Double.valueOf(jtValorTemporada.getText()));

                        } else {
                            imovel.addTipoContrato(tipoContrato2.get(2), Double.valueOf(jtValorTemporada.getText()));

                        }

                        jtValorTemporada.setBackground(Color.white);
                    } else {
                        control2 = false;
                        jtValorTemporada.setBackground(Color.red);

                    }
                } else if (temporada) {
                    tipoContrato.get(temporada1).setValor(0);

                }

                if (jcbFesta.isSelected()) {
                    if (jtValorDiaria.getText().equals("")) {

                        jtValorDiaria.setBackground(Color.white);

                    } else if (!jtValorDiaria.getText().equals("") && validacao.validaNumeros(jtValorDiaria.getText())) {
                        if (festa) {
                            tipoContrato.get(festa1).setValor(Double.valueOf(jtValorDiaria.getText()));

                        } else {
                            imovel.addTipoContrato(tipoContrato2.get(3), Double.valueOf(jtValorDiaria.getText()));

                        }

                        jtValorDiaria.setBackground(Color.white);
                    } else {
                        control2 = false;
                        jtValorDiaria.setBackground(Color.red);

                    }
                } else if (festa) {
                    tipoContrato.get(festa1).setValor(0);
                }

            }

            //Endereço
            //Principal        
            if (jrbCasa.isSelected()) {
                tipoImovel = tipoImovelTemp.get(0);
                control++;
                jlTipo.setForeground(Color.black);

            }
            if (jrbApartamento.isSelected()) {
                tipoImovel = tipoImovelTemp.get(1);

                control++;
                jlTipo.setForeground(Color.black);

            }

            if (jrbSalao.isSelected()) {
                tipoImovel = tipoImovelTemp.get(2);
                control++;
                jlTipo.setForeground(Color.black);

            }
            if (jrbComercio.isSelected()) {
                tipoImovel = tipoImovelTemp.get(3);
                control++;
                jlTipo.setForeground(Color.black);

            }
            if (jrbCondominio.isSelected()) {
                tipoImovel = tipoImovelTemp.get(4);
                control++;
                jlTipo.setForeground(Color.black);

            }

            if (!jtfLogradouro.getText().equals("") && validacao.validaLetras(jtfLogradouro.getText())) {
                endereco.setNomeEndereco(jtfLogradouro.getText());
                jtfLogradouro.setBackground(Color.white);
                control++;
            } else {

                jtfLogradouro.setBackground(Color.red);

            }
            if (!jtfNumero.getText().equals("") && validacao.validaNumeros(jtfNumero.getText())) {

                endereco.setNumero(Integer.valueOf(jtfNumero.getText()));

                jtfNumero.setBackground(Color.white);
                control++;
            } else {
                jtfNumero.setBackground(Color.red);

            }

            cidade.setIdCidade(cidadeGlobal.get(jcbCidade.getSelectedIndex()).getIdCidade());

            control++;
            control++;

            if (!jtfBairro.getText().equals("") && validacao.validaLetras(jtfBairro.getText())) {
                endereco.setBairro(jtfBairro.getText());
                jtfBairro.setBackground(Color.white);
                control++;
            } else {
                jtfBairro.setBackground(Color.red);

            }

// Pricipal End
            if (jtCep.getText().equals("")) {
                endereco.setCep(" ");
                jtCep.setBackground(Color.white);

            } else if (!jtCep.getText().equals("")) {
                endereco.setCep(jtCep.getText());
                jtCep.setBackground(Color.white);

            }

            if (jtfComplemento.getText().equals("")) {
                endereco.setComplemento(" ");
            } else if (!jtfComplemento.getText().equals("")) {
                endereco.setComplemento(jtfComplemento.getText());
            }

            if (jtfReferencia.getText().equals("")) {

                endereco.setReferencia(" ");
            } else if (!jtfReferencia.getText().equals("")) {

                endereco.setReferencia(jtfReferencia.getText());
            }

            if (jtfCondominio.getText().equals("")) {
                endereco.setNomeCondominio(" ");

            } else if (!jtfCondominio.getText().equals("")) {
                endereco.setNomeCondominio(jtfCondominio.getText());

            }

            if (jtfZona.getText().equals("")) {
                endereco.setZona(" ");
                jtfZona.setBackground(Color.white);
            } else if (!jtfZona.getText().equals("") && validacao.validaLetras(jtfZona.getText())) {
                endereco.setZona(jtfZona.getText());
                jtfZona.setBackground(Color.white);
            } else {
                control2 = false;
                jtfZona.setBackground(Color.red);

            }
            //Fim Endereço

            //Valores 
            //////////////////////
            if (jtValorIptu.getText().equals("")) {
                imovel.setValorIptu(0);

                jtValorIptu.setBackground(Color.white);
            } else if (!jtValorIptu.getText().equals("") && validacao.validaNumeros(jtValorIptu.getText())) {
                imovel.setValorIptu(Double.valueOf(jtValorIptu.getText()));
                jtValorIptu.setBackground(Color.white);
            } else {
                control2 = false;
                jtValorIptu.setBackground(Color.red);

            }

            if (jtValorCondominio.getText().equals("")) {
                imovel.setValorCondominio(0);
                jtValorCondominio.setBackground(Color.white);
            } else if (!jtValorCondominio.getText().equals("") && validacao.validaNumeros(jtValorCondominio.getText())) {
                imovel.setValorCondominio(Double.valueOf(jtValorCondominio.getText()));
                jtValorCondominio.setBackground(Color.white);
            } else {
                control2 = false;
                jtValorCondominio.setBackground(Color.red);

            }

            //Valores End
            //Outros  
            if (jrbMobiliada.isSelected()) {
                imovel.setTipoMobilia(1);
            }

            if (jrbSemiMobiliada.isSelected()) {
                imovel.setTipoMobilia(2);
            }

            if (jrbSemMobilia.isSelected()) {
                imovel.setTipoMobilia(3);
            }

            if (jtMatriculo.getText().equals("")) {
                documentacao.setNumMatricula(" ");
                jtMatriculo.setBackground(Color.white);
            } else if (!jtMatriculo.getText().equals("") && validacao.validaNumeros(jtMatriculo.getText())) {
                documentacao.setNumMatricula(jtMatriculo.getText());
                jtMatriculo.setBackground(Color.white);
            } else {
                control2 = false;
                jtMatriculo.setBackground(Color.red);

            }
            if (jtContaAgua.getText().equals("")) {
                documentacao.setNumContaAgua(" ");
                jtContaAgua.setBackground(Color.white);
            } else if (!jtContaAgua.getText().equals("") && validacao.validaNumeros(jtContaAgua.getText())) {
                documentacao.setNumContaAgua(jtContaAgua.getText());
                jtContaAgua.setBackground(Color.white);
            } else {
                control2 = false;
                jtContaAgua.setBackground(Color.red);

            }
            if (jtContaLuz.getText().equals("")) {
                documentacao.setNumContaLuz(" ");
                jtContaLuz.setBackground(Color.white);
            } else if (!jtContaLuz.getText().equals("") && validacao.validaNumeros(jtContaLuz.getText())) {
                documentacao.setNumContaLuz(jtContaLuz.getText());
                jtContaLuz.setBackground(Color.white);
            } else {
                control2 = false;
                jtContaLuz.setBackground(Color.red);

            }
            if (jtIptu.getText().equals("")) {
                documentacao.setNumIptu(" ");
                jtIptu.setBackground(Color.white);
            } else if (!jtIptu.getText().equals("") && validacao.validaNumeros(jtIptu.getText())) {
                documentacao.setNumIptu(jtIptu.getText());
                jtIptu.setBackground(Color.white);
            } else {
                control2 = false;
                jtIptu.setBackground(Color.red);

            }

            if (jtContrato.getText().equals("")) {
                documentacao.setNumContrato(" ");
                jtContrato.setBackground(Color.white);
            } else if (!jtContrato.getText().equals("") && validacao.validaNumeros(jtContrato.getText())) {
                documentacao.setNumContrato(jtContrato.getText());
                jtContrato.setBackground(Color.white);
            } else {
                control2 = false;
                jtContrato.setBackground(Color.red);

            }

            if (jtCartorio.getText().equals("")) {
                documentacao.setCartorio(" ");
            } else if (!jtCartorio.getText().equals("")) {
                documentacao.setCartorio(jtCartorio.getText());
            }

            if (jtSituacaoEscritura.getText().equals("")) {
                terreno.setSituacaoEscritura(" ");
                jtSituacaoEscritura.setBackground(Color.white);
            } else if (!jtSituacaoEscritura.getText().equals("") && validacao.validaLetras(jtSituacaoEscritura.getText())) {
                terreno.setSituacaoEscritura(jtSituacaoEscritura.getText());
                jtSituacaoEscritura.setBackground(Color.white);
            } else {
                control2 = false;
                jtSituacaoEscritura.setBackground(Color.red);

            }

            if (jtLargura.getText().equals("")) {
                terreno.setLargura(0);
                jtLargura.setBackground(Color.white);
            } else if (!jtLargura.getText().equals("") && validacao.validaNumeros(jtLargura.getText())) {
                terreno.setLargura(Double.valueOf(jtLargura.getText()));
                jtLargura.setBackground(Color.white);
            } else {
                control2 = false;
                jtLargura.setBackground(Color.red);

            }

            if (jtComprimento.getText().equals("")) {
                terreno.setComprimento(0);
                jtComprimento.setBackground(Color.white);
            } else if (!jtComprimento.getText().equals("") && validacao.validaNumeros(jtComprimento.getText())) {
                terreno.setComprimento(Double.valueOf(jtComprimento.getText()));
                jtComprimento.setBackground(Color.white);
            } else {
                control2 = false;
                jtComprimento.setBackground(Color.red);

            }

            if (jtAreaConstruida.getText().equals("")) {
                terreno.setAreaConstruida(0);
                jtAreaConstruida.setBackground(Color.white);
            } else if (!jtAreaConstruida.getText().equals("") && validacao.validaNumeros(jtAreaConstruida.getText())) {
                terreno.setAreaConstruida(Double.valueOf(jtAreaConstruida.getText()));
                jtAreaConstruida.setBackground(Color.white);
            } else {
                control2 = false;
                jtAreaConstruida.setBackground(Color.red);

            }

            if (jtMobilia.getText().equals("")) {
                imovel.setDescMobilia(" ");

            } else if (!jtMobilia.getText().equals("")) {
                imovel.setDescMobilia(jtMobilia.getText());
            }

            if (jtChaves.getText().equals("")) {
                imovel.setChaves(" ");
            } else if (!jtChaves.getText().equals("")) {
                imovel.setChaves(jtChaves.getText());
            }

            if (jtObservacao.getText().equals("")) {
                imovel.setObservacoes(" ");
            } else if (!jtObservacao.getText().equals("")) {
                imovel.setObservacoes(jtObservacao.getText());
            }
            //Outros End
            //Descrição

            if (jtQuartos.getText().equals("")) {
                imovel.setQtdQuartos(0);
                jtQuartos.setBackground(Color.white);
            } else if (!jtQuartos.getText().equals("") && validacao.validaNumeros(jtQuartos.getText())) {
                imovel.setQtdQuartos(Integer.valueOf(jtQuartos.getText()));
                jtQuartos.setBackground(Color.white);
            } else {
                control2 = false;
                jtQuartos.setBackground(Color.red);

            }

            if (jtSuites.getText().equals("")) {
                imovel.setQtdSuites(0);
                jtSuites.setBackground(Color.white);
            } else if (!jtSuites.getText().equals("") && validacao.validaNumeros(jtSuites.getText())) {
                imovel.setQtdSuites(Integer.valueOf(jtSuites.getText()));
                jtSuites.setBackground(Color.white);
            } else {
                control2 = false;
                jtSuites.setBackground(Color.red);

            }

            if (jtSalas.getText().equals("")) {
                imovel.setQtdSalas(0);
                jtSalas.setBackground(Color.white);
            } else if (!jtSalas.getText().equals("") && validacao.validaNumeros(jtSalas.getText())) {
                imovel.setQtdSalas(Integer.valueOf(jtSalas.getText()));
                jtSalas.setBackground(Color.white);
            } else {
                control2 = false;
                jtSalas.setBackground(Color.red);

            }

            if (jtBanheiros.getText().equals("")) {
                imovel.setQtdBanheiros(0);
                jtBanheiros.setBackground(Color.white);
            } else if (!jtBanheiros.getText().equals("") && validacao.validaNumeros(jtBanheiros.getText())) {
                imovel.setQtdBanheiros(Integer.valueOf(jtBanheiros.getText()));
                jtBanheiros.setBackground(Color.white);
            } else {
                control2 = false;
                jtBanheiros.setBackground(Color.red);

            }

            if (jtLavados.getText().equals("")) {
                imovel.setLavabos(0);
                jtLavados.setBackground(Color.white);
            } else if (!jtLavados.getText().equals("") && validacao.validaNumeros(jtLavados.getText())) {
                imovel.setLavabos(Integer.valueOf(jtLavados.getText()));
                jtLavados.setBackground(Color.white);
            } else {
                control2 = false;
                jtLavados.setBackground(Color.red);

            }

            if (jtAreaServico.getText().equals("")) {
                imovel.setAreaServico(0);
                jtAreaServico.setBackground(Color.white);
            } else if (!jtAreaServico.getText().equals("") && validacao.validaNumeros(jtAreaServico.getText())) {
                imovel.setAreaServico(Integer.valueOf(jtAreaServico.getText()));
                jtAreaServico.setBackground(Color.white);
            } else {
                control2 = false;
                jtAreaServico.setBackground(Color.red);

            }

            if (jtLavanderia.getText().equals("")) {
                imovel.setLavanderia(0);
                jtLavanderia.setBackground(Color.white);
            } else if (!jtLavanderia.getText().equals("") && validacao.validaNumeros(jtLavanderia.getText())) {
                imovel.setLavanderia(Integer.valueOf(jtLavanderia.getText()));
                jtLavanderia.setBackground(Color.white);
            } else {
                control2 = false;
                jtLavanderia.setBackground(Color.red);

            }

            if (jtPisos.getText().equals("")) {
                imovel.setQtdPisos(0);
                jtPisos.setBackground(Color.white);
            } else if (!jtPisos.getText().equals("") && validacao.validaNumeros(jtPisos.getText())) {
                imovel.setQtdPisos(Integer.valueOf(jtPisos.getText()));
                jtPisos.setBackground(Color.white);
            } else {
                control2 = false;
                jtPisos.setBackground(Color.red);

            }

            if (jtIdadeImovel.getText().equals("")) {
                imovel.setAnoConstrucao(0);
                jtIdadeImovel.setBackground(Color.white);
            } else if (!jtIdadeImovel.getText().equals("") && validacao.validaNumeros(jtIdadeImovel.getText())) {
                imovel.setAnoConstrucao(Integer.valueOf(jtIdadeImovel.getText()));

                jtIdadeImovel.setBackground(Color.white);
            } else {
                control2 = false;
                jtIdadeImovel.setBackground(Color.red);

            }

            if (jtPscina.getText().equals("")) {
                imovel.setPiscina(0);
                jtPscina.setBackground(Color.white);
            } else if (!jtPscina.getText().equals("") && validacao.validaNumeros(jtPscina.getText())) {
                imovel.setPiscina(Integer.valueOf(jtPscina.getText()));
                jtPscina.setBackground(Color.white);
            } else {
                control2 = false;
                jtPscina.setBackground(Color.red);

            }
            if (jtVagasGaragem.getText().equals("")) {
                imovel.setVagasGaragem(0);
                jtVagasGaragem.setBackground(Color.white);
            } else if (!jtVagasGaragem.getText().equals("") && validacao.validaNumeros(jtVagasGaragem.getText())) {
                imovel.setVagasGaragem(Integer.valueOf(jtVagasGaragem.getText()));
                jtVagasGaragem.setBackground(Color.white);
            } else {
                control2 = false;
                jtVagasGaragem.setBackground(Color.red);

            }
            if (jtDepEmpregada.getText().equals("")) {
                imovel.setDepEmpregados(0);
                jtDepEmpregada.setBackground(Color.white);
            } else if (!jtDepEmpregada.getText().equals("") && validacao.validaNumeros(jtDepEmpregada.getText())) {
                imovel.setDepEmpregados(Integer.valueOf(jtDepEmpregada.getText()));
                jtDepEmpregada.setBackground(Color.white);
            } else {
                control2 = false;
                jtDepEmpregada.setBackground(Color.red);

            }

            if (jtTipoImovel.getText().equals("")) {
                imovel.setDescImovel(" ");
            } else if (!jtTipoImovel.getText().equals("")) {
                imovel.setDescImovel(jtTipoImovel.getText());
            }

            if (jtAreaExterna.getText().equals("")) {
                imovel.setAreaExterna(" ");
            } else if (!jtAreaExterna.getText().equals("")) {
                imovel.setAreaExterna(jtAreaExterna.getText());
            }

            if (jtAcabamento.getText().equals("")) {
                imovel.setAcabamento(" ");
            } else if (!jtAcabamento.getText().equals("")) {
                imovel.setAcabamento(jtAcabamento.getText());
            }

            if (jtOutros.getText().equals("")) {
                imovel.setOutrosItens(" ");
            } else if (!jtOutros.getText().equals("")) {
                imovel.setOutrosItens(jtOutros.getText());
            }

            imovel.setAtivo(true);
            //Descrição End
            if ((control == 6) && control2 == true && (!jtCodigo.getText().equals(""))) {
                status.setIdStatus(Long.valueOf(jcbStatus.getSelectedIndex() + 1));
                imovel.setStatus(status);
                endereco.setCidade(cidade);
                endereco.setBairro(jtfBairro.getText());
                imovel.setEndereco(endereco);
                imovel.setDocumentacao(documentacao);
                imovel.setTerreno(terreno);
                imovel.setTipoImovel(tipoImovel);

                //        conexao banco;  
                if (imovelDao.persist(imovel)) {
                    JOptionPane.showMessageDialog(null, "Atualização Efetuado com Sucesso !");

                    new cadastroImovelHome().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro durante a Atualização !");

                }

            } else if ((control == 6) && control2 == true) {

                status.setIdStatus(Long.valueOf(jcbStatus.getSelectedIndex() + 1));
                imovel.setStatus(status);
                endereco.setCidade(cidade);
                endereco.setBairro(jtfBairro.getText());
                imovel.setEndereco(endereco);
                imovel.setDocumentacao(documentacao);
                imovel.setTerreno(terreno);
                imovel.setTipoImovel(tipoImovel);

                //        conexao banco;  
                imovelDao.persist(imovel);

                JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso !");
                System.out.println("Cadastro Efetuado");

                new cadastroImovelHome().setVisible(true);
                dispose();
            } else {

                if (jrbCasa.isSelected() || jrbSalao.isSelected() || jrbComercio.isSelected() || jrbCondominio.isSelected() || jrbApartamento.isSelected()) {

                } else {

                    jlTipo.setForeground(Color.red);
                }

                control = 0;
                control2 = true;
                JOptionPane.showMessageDialog(null, "Erro Verifique os campos !");
                System.out.println("Erro Verifique os campos");
            }

        }
    }//GEN-LAST:event_jbConfirmarMouseClicked

    public void zerarCampos() {
        imovelTemp = null;
        jlTipo.setForeground(Color.black);
        bgTipo.clearSelection();
        bgMobilia.clearSelection();

        jcbLocacao.setSelected(false);

        jcbTemporada.setSelected(false);

        jcbVenda.setSelected(false);

        jcbFesta.setSelected(false);

        jtCodigo.setText("");

        //Endereço
        jtfLogradouro.setText("");
        jtfNumero.setText("");
        jtfComplemento.setText("");

        jtfBairro.setText("");
        jcbEstado.setSelectedIndex(1);

        jtCep.setText("");
        jtfReferencia.setText("");
        jtfZona.setText("");
        jtfCondominio.setText("");

        jtfLogradouro.setBackground(Color.white);
        jtfNumero.setBackground(Color.white);
        jtfComplemento.setBackground(Color.white);

        jtfBairro.setBackground(Color.white);

        jtCep.setBackground(Color.white);
        jtfReferencia.setBackground(Color.white);
        jtfZona.setBackground(Color.white);
        jtfCondominio.setBackground(Color.white);

        //valores
        jtValorLocacaoMes.setText("");
        jtValorVenda.setText("");
        jtValorTemporada.setText("");
        jtValorIptu.setText("");
        jtValorCondominio.setText("");
        jtValorDiaria.setText("");

        jtValorLocacaoMes.setBackground(Color.white);
        jtValorVenda.setBackground(Color.white);
        jtValorTemporada.setBackground(Color.white);
        jtValorIptu.setBackground(Color.white);
        jtValorCondominio.setBackground(Color.white);
        jtValorDiaria.setBackground(Color.white);

        //Outros 
        jtMatriculo.setText("");
        jtContaAgua.setText("");
        jtContaLuz.setText("");
        jtIptu.setText("");
        jtContrato.setText("");
        jtCartorio.setText("");
        jtSituacaoEscritura.setText("");

        jtLargura.setText("");
        jtComprimento.setText("");
        jtTamanhoTerreno.setText("");
        jtAreaConstruida.setText("");

        jtMobilia.setText("");
        jtChaves.setText("");
        jtObservacao.setText("");

        jtMatriculo.setBackground(Color.white);
        jtContaAgua.setBackground(Color.white);
        jtContaLuz.setBackground(Color.white);
        jtIptu.setBackground(Color.white);
        jtContrato.setBackground(Color.white);
        jtCartorio.setBackground(Color.white);
        jtSituacaoEscritura.setBackground(Color.white);

        jtLargura.setBackground(Color.white);
        jtComprimento.setBackground(Color.white);
        jtAreaConstruida.setBackground(Color.white);
        //não esquecer
        jtMobilia.setBackground(Color.white);
        jtChaves.setBackground(Color.white);
        jtObservacao.setBackground(Color.white);

        //Descrição  
        jtQuartos.setText("");
        jtSuites.setText("");
        jtSalas.setText("");
        jtBanheiros.setText("");
        jtLavados.setText("");
        jtAreaServico.setText("");
        jtLavanderia.setText("");
        jtPisos.setText("");
        jtIdadeImovel.setText("");
        jtPscina.setText("");
        jtVagasGaragem.setText("");
        jtDepEmpregada.setText("");
        jtTipoImovel.setText("");
        jtAreaExterna.setText("");
        jtAcabamento.setText("");
        jtOutros.setText("");

        jtQuartos.setBackground(Color.white);
        jtSuites.setBackground(Color.white);
        jtSalas.setBackground(Color.white);
        jtBanheiros.setBackground(Color.white);
        jtLavados.setBackground(Color.white);
        jtAreaServico.setBackground(Color.white);
        jtLavanderia.setBackground(Color.white);
        jtPisos.setBackground(Color.white);
        jtIdadeImovel.setBackground(Color.white);
        jtPscina.setBackground(Color.white);
        jtVagasGaragem.setBackground(Color.white);
        jtDepEmpregada.setBackground(Color.white);
        jtTipoImovel.setBackground(Color.white);
        jtAreaExterna.setBackground(Color.white);
        jtAcabamento.setBackground(Color.white);
        jtOutros.setBackground(Color.white);

    }


    private void jtContaLuzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtContaLuzActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtContaLuzActionPerformed

    private void jbEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMouseClicked
        if (jbEditar.isEnabled()) {
            DisableEnable(true);
            jbConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jbEditarMouseClicked

    private void jcbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbStatusActionPerformed

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        CidadeDAO cidadeDao = new CidadeDAO();

        List<Cidade> cidadeTemp = new ArrayList<>();
        cidadeTemp = cidadeDao.getWhereIdEstado((long) (jcbEstado.getSelectedIndex() + 1));

        List<String> listaCidade = new ArrayList<String>();
        for (int i = 0; i < cidadeTemp.size(); i++) {
            listaCidade.add(cidadeTemp.get(i).getNomeCidade());
        }
        DefaultComboBoxModel defaultComboBox3 = new DefaultComboBoxModel(listaCidade.toArray());
        jcbCidade.setModel(defaultComboBox3);

        cidadeGlobal = cidadeTemp;
// TODO add your handling code here:
    }//GEN-LAST:event_jcbEstadoActionPerformed

    private void jtLavanderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtLavanderiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtLavanderiaActionPerformed

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
            java.util.logging.Logger.getLogger(cadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroImovel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgMobilia;
    private javax.swing.ButtonGroup bgTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JCheckBox jcbFesta;
    private javax.swing.JCheckBox jcbLocacao;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JCheckBox jcbTemporada;
    private javax.swing.JCheckBox jcbVenda;
    private javax.swing.JInternalFrame jifDescricao;
    private javax.swing.JInternalFrame jifEndereco;
    private javax.swing.JInternalFrame jifOutros;
    private javax.swing.JInternalFrame jifValores;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlComplemento;
    private javax.swing.JLabel jlCondominio;
    private javax.swing.JLabel jlLogradouro;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlReferencia;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JLabel jlTamanhoTotal;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JLabel jlValorCondominio;
    private javax.swing.JLabel jlValorFesta;
    private javax.swing.JLabel jlValorIPTU;
    private javax.swing.JLabel jlValorLocacao;
    private javax.swing.JLabel jlValorTemporada;
    private javax.swing.JLabel jlValorVenda;
    private javax.swing.JLabel jlZona;
    private javax.swing.JRadioButton jrbApartamento;
    private javax.swing.JRadioButton jrbCasa;
    private javax.swing.JRadioButton jrbComercio;
    private javax.swing.JRadioButton jrbCondominio;
    private javax.swing.JRadioButton jrbMobiliada;
    private javax.swing.JRadioButton jrbSalao;
    private javax.swing.JRadioButton jrbSemMobilia;
    private javax.swing.JRadioButton jrbSemiMobiliada;
    private javax.swing.JSeparator jsInteresse;
    private javax.swing.JSeparator jsTipo;
    private javax.swing.JTextArea jtAcabamento;
    private javax.swing.JTextField jtAreaConstruida;
    private javax.swing.JTextArea jtAreaExterna;
    private javax.swing.JTextField jtAreaServico;
    private javax.swing.JTextField jtBanheiros;
    private javax.swing.JTextField jtCartorio;
    private javax.swing.JTextField jtCep;
    private javax.swing.JTextArea jtChaves;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTextField jtComprimento;
    private javax.swing.JTextField jtContaAgua;
    private javax.swing.JTextField jtContaLuz;
    private javax.swing.JTextField jtContrato;
    private javax.swing.JTextField jtDepEmpregada;
    private javax.swing.JTextField jtIdadeImovel;
    private javax.swing.JTextField jtIptu;
    private javax.swing.JTextField jtLargura;
    private javax.swing.JTextField jtLavados;
    private javax.swing.JTextField jtLavanderia;
    private javax.swing.JTextField jtMatriculo;
    private javax.swing.JTextArea jtMobilia;
    private javax.swing.JTextArea jtObservacao;
    private javax.swing.JTextArea jtOutros;
    private javax.swing.JTextField jtPisos;
    private javax.swing.JTextField jtPscina;
    private javax.swing.JTextField jtQuartos;
    private javax.swing.JTextField jtSalas;
    private javax.swing.JTextField jtSituacaoEscritura;
    private javax.swing.JTextField jtSuites;
    private javax.swing.JTextField jtTamanhoTerreno;
    private javax.swing.JTextArea jtTipoImovel;
    private javax.swing.JTextField jtVagasGaragem;
    private javax.swing.JTextField jtValorCondominio;
    private javax.swing.JTextField jtValorDiaria;
    private javax.swing.JTextField jtValorIptu;
    private javax.swing.JTextField jtValorLocacaoMes;
    private javax.swing.JTextField jtValorTemporada;
    private javax.swing.JTextField jtValorVenda;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfCondominio;
    private javax.swing.JTextField jtfLogradouro;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfReferencia;
    private javax.swing.JTextField jtfZona;
    private javax.swing.JTabbedPane jtpCadastro;
    // End of variables declaration//GEN-END:variables
}
