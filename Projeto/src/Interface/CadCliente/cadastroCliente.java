/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CadCliente;

import Interface.TelaPrincipal.Sessao;
import Interface.TelaPrincipal.TelaPrincipal;
import dao.CidadeDAO;
import dao.EstadoCivilDAO;
import dao.EstadoDAO;
import dao.PessoaDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import dao.TipoContratoDAO;
import global.model.Cidade;
import global.model.Endereco;
import global.model.Estado;
import imovel.model.TipoContrato;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.pessoa.EstadoCivil;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import model.pessoa.PessoaJuridica;
import model.pessoa.Telefone;
import validacao.*;

/**
 *
 * @author Sala
 */
public class cadastroCliente extends javax.swing.JFrame {

    private static cadastroCliente instancia;

    public static PessoaFisica pessoaFisica;
    public static PessoaJuridica pessoaJuridica;
    public static PessoaFisica fiadorGlobal = null;
    private List<Cidade> listaCidadesGlobal;
    private int indexCidade;

    /**
     * Creates new form cadastroCliente
     */
    public cadastroCliente() {
        this.setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        this.setTitle("Cadastro de Clientes");
        ativaPessoa(true);
        mascaraCPF_CNPJ(true);
        jrbPessoaFisica.setSelected(true);
        configuraMascaras();
        carregaEstados();
        carregaCidades();
        carregaEstadosCivis();
        carregaFiadores();
        acesso(Sessao.getInstance().getUsuario().getNivelAcesso());
//        populaPessoaFisica();

    }

    public static cadastroCliente getInstancia() {
        if (instancia == null) {
            instancia = new cadastroCliente();
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
                DisableEnable(true);
                break;
            case 3:
                DisableEnable(false);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Acesso negado!\nNível de Acesso Inválido");
        }
    }

    public void DisableEnable(Boolean b) {

        //cad
        jbConfirmar.setEnabled(b);
        jbEditar.setEnabled(false);
        jtfNome.setEnabled(b);
        jftCPF.setEnabled(b);
        jtfRG.setEnabled(b);
        jftDataNascimento.setEnabled(b);
        jtfNovoFiador.setEnabled(b);
        jtfNomeFantasia.setEnabled(b);
        jtfNomeResponsavel.setEnabled(b);
        jftCPFResponsavel.setEnabled(b);
        jtfEndereco.setEnabled(b);
        jtfNumero.setEnabled(b);
        jtfBairro.setEnabled(b);
        jftCEP.setEnabled(b);
        jcbCidade.setEnabled(b);
        jtfComplemento.setEnabled(b);
        jftTelefone.setEnabled(b);
        jftCelular.setEnabled(b);
        jftComercial.setEnabled(b);
        jtfEmail.setEnabled(b);
        jtaObs.setEnabled(b);

        //cad Fim 
        // JRB
        jrbPessoaFisica.setEnabled(b);
        jrbPessoaJuridica.setEnabled(b);
        jrbMasculino.setEnabled(b);
        jrbFeminino.setEnabled(b);

        // jrb fim
        // jcb     
        jcbAtivo.setEnabled(b);
        jcbCompra.setEnabled(b);
        jcbTroca.setEnabled(b);
        jcbLocacao.setEnabled(b);
        jcbEstadoCivil.setEnabled(b);
        jcbEstado.setEnabled(b);
        jcbFiador.setEnabled(b);
    }

    public void ZerarCampos() {
        jtfCodigoInterno.setText("");
        //cad
        jtfNome.setText("");
        jftCPF.setText("");
        jtfRG.setText("");
        jftDataNascimento.setText("");
//        jtfNovoFiador.setText("");
        jtfNomeFantasia.setText("");
        jtfNomeResponsavel.setText("");
        jtfEndereco.setText("");
        jtfNumero.setText("");
        jtfBairro.setText("");
        jftCEP.setText("");
        jtfComplemento.setText("");
        jftTelefone.setText("");
        jftCelular.setText("");
        jftComercial.setText("");
        jtfEmail.setText("");
        jtaObs.setText("");
        jftCPFResponsavel.setText("");

        //cad Fim 
        // JRB
        jrbPessoaFisica.setSelected(false);
        jrbPessoaJuridica.setSelected(false);
        jrbMasculino.setSelected(false);
        jrbFeminino.setSelected(false);

        // jrb fim
        // jcb     
        jcbAtivo.setSelected(false);
        jcbCompra.setSelected(false);
        jcbTroca.setSelected(false);
        jcbLocacao.setSelected(false);
        jcbEstadoCivil.setSelectedIndex(-1);
        jcbCidade.setSelectedIndex(-1);
        jcbEstado.setSelectedIndex(-1);
        jcbFiador.setSelectedIndex(-1);

        // jcb fim
        //Tirando os alertas
        jtfNome.setBackground(Color.white);
        jftCPF.setBackground(Color.white);
        jtfEndereco.setBackground(Color.white);
        jtfBairro.setBackground(Color.white);
        jcbCidade.setBackground(Color.white);
        jftDataNascimento.setBackground(Color.white);
        jtfNumero.setBackground(Color.white);
        jcbEstado.setBackground(Color.white);
        jftTelefone.setBackground(Color.white);
        jftCelular.setBackground(Color.white);
        jftComercial.setBackground(Color.white);
        jcbEstadoCivil.setBackground(Color.white);
        jtfNovoFiador.setBackground(Color.white);
        jtfNomeResponsavel.setBackground(Color.white);
        jtfNomeFantasia.setBackground(Color.white);
        jftCPFResponsavel.setBackground(Color.white);
        jtfComplemento.setBackground(Color.white);
        jtfEmail.setBackground(Color.white);
        // Fim
    }

    public void cadastrarPessoaFisica() throws ParseException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setTipoPessoa(true);
        pessoaFisica.setAtivo(true);
        pessoaFisica.setNomePessoa(jtfNome.getText());
        pessoaFisica.setCPF(jftCPF.getText());
        pessoaFisica.setRG(jtfRG.getText());
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataNascimento.getText());
        pessoaFisica.setDataNascimento(dataNascimento);
        pessoaFisica.setObservacoes(jtaObs.getText());

        Cidade cidade = (Cidade) jcbCidade.getSelectedItem();

        Endereco endereco = new Endereco();
        endereco.setBairro(jtfBairro.getText());
        endereco.setNomeEndereco(jtfEndereco.getText());
        endereco.setNumero(Integer.parseInt(jtfNumero.getText()));
        endereco.setCep(jftCEP.getText());
        endereco.setComplemento(jtfComplemento.getText());
        endereco.setCidade(cidade);
        pessoaFisica.setEndereco(endereco);

        List<Telefone> telefones = new ArrayList<Telefone>();
        Telefone telefone = new Telefone();
        Telefone celular = new Telefone();
        Telefone comercial = new Telefone();

        telefone.setNumero(jftTelefone.getText());
        telefone.setPessoa(pessoaFisica);
        telefone.setOperadora("");
        celular.setNumero(jftCelular.getText());
        celular.setPessoa(pessoaFisica);
        celular.setOperadora("");
        comercial.setNumero(jftComercial.getText());
        comercial.setPessoa(pessoaFisica);
        comercial.setOperadora("");

        telefones.add(telefone);
        telefones.add(celular);
        telefones.add(comercial);
        pessoaFisica.setTelefone(telefones);

        pessoaFisica.setEmail(jtfEmail.getText());

        if (jrbMasculino.isSelected()) {
            pessoaFisica.setSexo('M');
        } else if (jrbFeminino.isSelected()) {
            pessoaFisica.setSexo('F');
        }

        EstadoCivil estadoCivil = (EstadoCivil) jcbEstadoCivil.getSelectedItem();
        pessoaFisica.setEstadoCivil(estadoCivil);

        if (jcbFiador.getSelectedIndex() >= 0) {
            PessoaFisica fiador = (PessoaFisica) jcbFiador.getSelectedItem();
            pessoaFisica.setListaFiadores(pessoaFisicaDAO.getFiadores(fiador.getIdPessoa()));
            jtfNovoFiador.setText("");
        }

        if (!jtfNovoFiador.getText().isEmpty() && jcbFiador.getSelectedIndex() < 0) {
            pessoaFisica.setListaFiadores(pessoaFisicaDAO.getFiadores(fiadorGlobal.getIdPessoa()));
            jcbFiador.setSelectedItem(fiadorGlobal);

        }

        pessoaFisica.setEstadoCivil(estadoCivil);

        TipoContratoDAO tipoContratoDAO = new TipoContratoDAO();
        TipoContrato tipoContrato = new TipoContrato();
        List<TipoContrato> tiposContrato = new ArrayList<TipoContrato>();
        tiposContrato = tipoContratoDAO.getAll();
        List<TipoContrato> interesses = new ArrayList<TipoContrato>();

        if (jcbLocacao.isSelected()) {
            interesses.add(tiposContrato.get(0));
        }
        if (jcbCompra.isSelected()) {
            interesses.add(tiposContrato.get(1));
        }
        if (jcbTroca.isSelected()) {
            interesses.add(tiposContrato.get(2));
        }
        pessoaFisica.setInteresses(interesses);
        pessoaFisicaDAO.persist(pessoaFisica);

    }

    public void cadastrarPessoaFisica(PessoaFisica pessoaFisica) throws ParseException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisica.setTipoPessoa(true);
        pessoaFisica.setNomePessoa(jtfNome.getText());
        pessoaFisica.setCPF(jftCPF.getText());
        pessoaFisica.setRG(jtfRG.getText());
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataNascimento.getText());
        pessoaFisica.setDataNascimento(dataNascimento);
        pessoaFisica.setObservacoes(jtaObs.getText());

        Cidade cidade = (Cidade) jcbCidade.getSelectedItem();

        Endereco endereco = new Endereco();
        endereco.setBairro(jtfBairro.getText());
        endereco.setNomeEndereco(jtfEndereco.getText());
        endereco.setNumero(Integer.parseInt(jtfNumero.getText()));
        endereco.setCep(jftCEP.getText());
        endereco.setComplemento(jtfComplemento.getText());
        endereco.setCidade(cidade);
        pessoaFisica.setEndereco(endereco);

        List<Telefone> telefones = new ArrayList<Telefone>();
        Telefone telefone = new Telefone();
        Telefone celular = new Telefone();
        Telefone comercial = new Telefone();

        telefone.setNumero(jftTelefone.getText());
        telefone.setPessoa(pessoaFisica);
        telefone.setOperadora("");
        celular.setNumero(jftCelular.getText());
        celular.setPessoa(pessoaFisica);
        celular.setOperadora("");
        comercial.setNumero(jftComercial.getText());
        comercial.setPessoa(pessoaFisica);
        comercial.setOperadora("");

        telefones.add(telefone);
        telefones.add(celular);
        telefones.add(comercial);
        pessoaFisica.setTelefone(telefones);

        pessoaFisica.setEmail(jtfEmail.getText());

        if (jrbMasculino.isSelected()) {
            pessoaFisica.setSexo('M');
        } else if (jrbFeminino.isSelected()) {
            pessoaFisica.setSexo('F');
        }

        EstadoCivil estadoCivil = (EstadoCivil) jcbEstadoCivil.getSelectedItem();
        pessoaFisica.setEstadoCivil(estadoCivil);

        pessoaFisica.setListaFiadores(pessoaFisicaDAO.getFiadores((long) jcbFiador.getSelectedIndex() + 1));
        pessoaFisica.setEstadoCivil(estadoCivil);

        TipoContratoDAO tipoContratoDAO = new TipoContratoDAO();
        TipoContrato tipoContrato = new TipoContrato();
        List<TipoContrato> tiposContrato = new ArrayList<TipoContrato>();
        tiposContrato = tipoContratoDAO.getAll();
        List<TipoContrato> interesses = new ArrayList<TipoContrato>();

        if (jcbLocacao.isSelected()) {
            interesses.add(tiposContrato.get(0));
        }
        if (jcbCompra.isSelected()) {
            interesses.add(tiposContrato.get(1));
        }
        if (jcbTroca.isSelected()) {
            interesses.add(tiposContrato.get(2));
        }
        pessoaFisica.setInteresses(interesses);
        pessoaFisicaDAO.merge(pessoaFisica);
    }

    public void cadastrarPessoaJuridica() throws ParseException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setTipoPessoa(false);
        pessoaJuridica.setAtivo(true);
        pessoaJuridica.setNomePessoa(jtfNome.getText());
        pessoaJuridica.setCnpj(jftCPF.getText());
        pessoaJuridica.setInscricaoEstadual(jtfRG.getText());
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataNascimento.getText());
        pessoaJuridica.setDataNascimento(dataNascimento);
        pessoaJuridica.setObservacoes(jtaObs.getText());

        Cidade cidade = (Cidade) jcbCidade.getSelectedItem();

        Endereco endereco = new Endereco();
        endereco.setNomeEndereco(jtfEndereco.getText());
        endereco.setNumero(Integer.parseInt(jtfNumero.getText()));
        endereco.setCep(jftCEP.getText());
        endereco.setComplemento(jtfComplemento.getText());
        endereco.setBairro(jtfBairro.getText());
        endereco.setCidade(cidade);
        pessoaJuridica.setEndereco(endereco);

        List<Telefone> telefones = new ArrayList<Telefone>();
        Telefone telefone = new Telefone();
        Telefone celular = new Telefone();
        Telefone comercial = new Telefone();

        telefone.setNumero(jftTelefone.getText());
        telefone.setPessoa(pessoaJuridica);
        telefone.setOperadora("");
        celular.setNumero(jftCelular.getText());
        celular.setPessoa(pessoaJuridica);
        celular.setOperadora("");
        comercial.setNumero(jftComercial.getText());
        comercial.setPessoa(pessoaJuridica);
        comercial.setOperadora("");

        telefones.add(telefone);
        telefones.add(celular);
        telefones.add(comercial);
        pessoaJuridica.setTelefone(telefones);

        pessoaJuridica.setEmail(jtfEmail.getText());

        pessoaJuridica.setCpfResponsavel(jftCPFResponsavel.getText());
        pessoaJuridica.setNomeFantasia(jtfNomeFantasia.getText());
        pessoaJuridica.setNomeResponsavel(jtfNomeResponsavel.getText());
        pessoaJuridica.setCadastroAtivo(jcbAtivo.isSelected());

        TipoContratoDAO tipoContratoDAO = new TipoContratoDAO();
        TipoContrato tipoContrato = new TipoContrato();
        List<TipoContrato> tiposContrato = new ArrayList<TipoContrato>();
        tiposContrato = tipoContratoDAO.getAll();
        List<TipoContrato> interesses = new ArrayList<TipoContrato>();

        if (jcbLocacao.isSelected()) {
            interesses.add(tiposContrato.get(0));
        }
        if (jcbCompra.isSelected()) {
            interesses.add(tiposContrato.get(1));
        }
        if (jcbTroca.isSelected()) {
            interesses.add(tiposContrato.get(2));
        }
        pessoaJuridica.setInteresses(interesses);

        pessoaJuridicaDAO.persist(pessoaJuridica);
    }

    public void cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica) throws ParseException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridica.setTipoPessoa(false);
        pessoaJuridica.setNomePessoa(jtfNome.getText());
        pessoaJuridica.setCnpj(jftCPF.getText());
        pessoaJuridica.setInscricaoEstadual(jtfRG.getText());
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(jftDataNascimento.getText());
        pessoaJuridica.setDataNascimento(dataNascimento);
        pessoaJuridica.setObservacoes(jtaObs.getText());

        Cidade cidade = (Cidade) jcbCidade.getSelectedItem();

        Endereco endereco = new Endereco();
        endereco.setNomeEndereco(jtfEndereco.getText());
        endereco.setNumero(Integer.parseInt(jtfNumero.getText()));
        endereco.setCep(jftCEP.getText());
        endereco.setComplemento(jtfComplemento.getText());
        endereco.setBairro(jtfBairro.getText());
        endereco.setCidade(cidade);
        pessoaJuridica.setEndereco(endereco);

        List<Telefone> telefones = new ArrayList<Telefone>();
        Telefone telefone = new Telefone();
        Telefone celular = new Telefone();
        Telefone comercial = new Telefone();

        telefone.setNumero(jftTelefone.getText());
        telefone.setPessoa(pessoaJuridica);
        telefone.setOperadora("");
        celular.setNumero(jftCelular.getText());
        celular.setPessoa(pessoaJuridica);
        celular.setOperadora("");
        comercial.setNumero(jftComercial.getText());
        comercial.setPessoa(pessoaJuridica);
        comercial.setOperadora("");

        telefones.add(telefone);
        telefones.add(celular);
        telefones.add(comercial);
        pessoaJuridica.setTelefone(telefones);

        pessoaJuridica.setEmail(jtfEmail.getText());

        pessoaJuridica.setCpfResponsavel(jftCPFResponsavel.getText());
        pessoaJuridica.setNomeFantasia(jtfNomeFantasia.getText());
        pessoaJuridica.setNomeResponsavel(jtfNomeResponsavel.getText());
        pessoaJuridica.setCadastroAtivo(jcbAtivo.isSelected());

        TipoContratoDAO tipoContratoDAO = new TipoContratoDAO();
        TipoContrato tipoContrato = new TipoContrato();
        List<TipoContrato> tiposContrato = new ArrayList<TipoContrato>();
        tiposContrato = tipoContratoDAO.getAll();
        List<TipoContrato> interesses = new ArrayList<TipoContrato>();

        if (jcbLocacao.isSelected()) {
            interesses.add(tiposContrato.get(0));
        }
        if (jcbCompra.isSelected()) {
            interesses.add(tiposContrato.get(1));
        }
        if (jcbTroca.isSelected()) {
            interesses.add(tiposContrato.get(2));
        }
        pessoaJuridica.setInteresses(interesses);

        pessoaJuridicaDAO.merge(pessoaJuridica);
    }

    public void atualizarPessoaFisica(PessoaFisica pessoaFisica) {
         System.out.println("====================================Entrou no atualiza fisica");
        jtfCodigoInterno.setText("" + pessoaFisica.getIdPessoa());
        jtfNome.setText(pessoaFisica.getNomePessoa());
        jftCPF.setText(pessoaFisica.getCPF());
        jtfRG.setText(pessoaFisica.getRG());
        String dataString = new SimpleDateFormat("dd/MM/yyyy").format(pessoaFisica.getDataNascimento());
        System.out.println(dataString);
        jftDataNascimento.setText(dataString);
        jtaObs.setText(pessoaFisica.getObservacoes());

        jcbEstado.setSelectedIndex((int) pessoaFisica.getEndereco().getCidade().getEstado().getId() - 1);

        for (int i = 0; i < listaCidadesGlobal.size(); i++) {
            if (listaCidadesGlobal.get(i).getIdCidade() == pessoaFisica.getEndereco().getCidade().getIdCidade()) {
                indexCidade = i;
            }
        }
        jcbCidade.setSelectedIndex(indexCidade);

        jtfBairro.setText(pessoaFisica.getEndereco().getBairro());

        jtfEndereco.setText(pessoaFisica.getEndereco().getNomeEndereco());
        jtfNumero.setText("" + pessoaFisica.getEndereco().getNumero());
        jftCEP.setText(pessoaFisica.getEndereco().getCep());
        jtfComplemento.setText(pessoaFisica.getEndereco().getComplemento());

        for (int i = 0; i < pessoaFisica.getTelefone().size(); i++) {
            if (i == 0) {
                jftTelefone.setText(pessoaFisica.getTelefone().get(i).getNumero());
            } else if (i == 1) {
                jftCelular.setText(pessoaFisica.getTelefone().get(i).getNumero());
            } else if (i == 2) {
                jftComercial.setText(pessoaFisica.getTelefone().get(i).getNumero());
            }
        }

        jtfEmail.setText(pessoaFisica.getEmail());

        if (pessoaFisica.getSexo() == 'M') {
            jrbMasculino.setSelected(true);
        }
        if (pessoaFisica.getSexo() == 'F') {
            jrbFeminino.setSelected(true);
        }

        jcbEstadoCivil.setSelectedIndex((int) pessoaFisica.getEstadoCivil().getIdEstadoCivil() - 1);

        TipoContratoDAO tipoContratoDAO = new TipoContratoDAO();
        TipoContrato tipoContrato = new TipoContrato();
        List<TipoContrato> tiposContrato = new ArrayList<TipoContrato>();
        tiposContrato = tipoContratoDAO.getAll();
        List<TipoContrato> interesses = new ArrayList<TipoContrato>();

        if (pessoaFisica.getListaFiadores().size() > 0) {
            jcbFiador.getModel().setSelectedItem(pessoaFisica.getListaFiadores().get(0));
        } else {
            jcbFiador.setSelectedIndex(-1);
        }

        for (int i = 0; i < pessoaFisica.getInteresses().size(); i++) {
            if (i == 0) {
                if (pessoaFisica.getInteresses().get(i) != null) {
                    jcbLocacao.setSelected(true);
                } else {
                    jcbLocacao.setSelected(false);
                }
            } else if (i == 1) {
                if (pessoaFisica.getInteresses().get(i) != null) {
                    jcbTroca.setSelected(true);
                } else {
                    jcbTroca.setSelected(false);
                }
            } else if (i == 2) {
                if (pessoaFisica.getInteresses().get(i) != null) {
                    jcbCompra.setSelected(true);
                } else {
                    jcbCompra.setSelected(false);
                }
            }
        }

    }

    public void atualizarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        
        System.out.println("====================================Entrou no atualiza juridica");
        jtfCodigoInterno.setText("" + pessoaJuridica.getIdPessoa());
        jtfNome.setText(pessoaJuridica.getNomePessoa());
        jftCPF.setText(pessoaJuridica.getCnpj());
        jtfRG.setText(pessoaJuridica.getInscricaoEstadual());
        String dataString = new SimpleDateFormat("dd/MM/yyyy").format(pessoaJuridica.getDataNascimento());
        System.out.println(dataString);
        jftDataNascimento.setText(dataString);
        jtaObs.setText(pessoaJuridica.getObservacoes());

        jcbEstado.setSelectedIndex((int) pessoaJuridica.getEndereco().getCidade().getEstado().getId() - 1);

        for (int i = 0; i < listaCidadesGlobal.size(); i++) {
            if (listaCidadesGlobal.get(i).getIdCidade() == pessoaJuridica.getEndereco().getCidade().getIdCidade()) {
                indexCidade = i;
            }
        }
        jcbCidade.setSelectedIndex(indexCidade);

        jtfBairro.setText(pessoaJuridica.getEndereco().getBairro());

        jtfEndereco.setText(pessoaJuridica.getEndereco().getNomeEndereco());
        jtfNumero.setText("" + pessoaJuridica.getEndereco().getNumero());
        jftCEP.setText(pessoaJuridica.getEndereco().getCep());
        jtfComplemento.setText(pessoaJuridica.getEndereco().getComplemento());

        for (int i = 0; i < pessoaJuridica.getTelefone().size(); i++) {
            if (i == 0) {
                jftTelefone.setText(pessoaJuridica.getTelefone().get(i).getNumero());
            } else if (i == 1) {
                jftCelular.setText(pessoaJuridica.getTelefone().get(i).getNumero());
            } else if (i == 2) {
                jftComercial.setText(pessoaJuridica.getTelefone().get(i).getNumero());
            }
        }
//        

        jtfEmail.setText(pessoaJuridica.getEmail());

        jtfNomeFantasia.setText(pessoaJuridica.getNomeFantasia());
        jftCPFResponsavel.setText(pessoaJuridica.getCpfResponsavel());
        jtfNomeResponsavel.setText(pessoaJuridica.getNomeResponsavel());
        jcbAtivo.setSelected(pessoaJuridica.isCadastroAtivo());

        for (int i = 0; i < pessoaJuridica.getInteresses().size(); i++) {
            if (i == 0) {
                if (pessoaJuridica.getInteresses().get(i) != null) {
                    jcbLocacao.setSelected(true);
                } else {
                    jcbLocacao.setSelected(false);
                }
            } else if (i == 1) {
                if (pessoaJuridica.getInteresses().get(i) != null) {
                    jcbTroca.setSelected(true);
                } else {
                    jcbTroca.setSelected(false);
                }
            } else if (i == 2) {
                if (pessoaJuridica.getInteresses().get(i) != null) {
                    jcbCompra.setSelected(true);
                } else {
                    jcbCompra.setSelected(false);
                }
            }
        }
    }

    public void populaPessoaFisica() {
        Pessoa pessoa = new Pessoa();
        jtfCodigoInterno.setText(pessoa.getIdPessoa() + "");
        jtfNome.setText("Jean Felipe");
        jftCPF.setText("38933784802");
        jtfRG.setText("RG");
        jftDataNascimento.setText("25/08/1991");
        jtaObs.setText("Qualquer OBS");
        jrbMasculino.setSelected(true);
        jtfNovoFiador.setText("Fiador de");
        jcbEstadoCivil.setSelectedIndex(0);
        jtfEndereco.setText("Av. Guilherme de Almeida");
        jtfNumero.setText("2025");
        jtfComplemento.setText("");
        jtfBairro.setText("Morro do Algodão");

        jftCEP.setText("11.671-000");
        jcbCidade.setSelectedIndex(189);

        jftTelefone.setText("1238875776");
        jftCelular.setText("12981097059");
        jftComercial.setText("");
        jtfEmail.setText("teste@teste");
    }

    public void populaPessoaJuridica() {
        Pessoa pessoa = new Pessoa();
        jtfCodigoInterno.setText(pessoa.getIdPessoa() + "");
        jtfNome.setText("Empresa S/A");
        jftCPF.setText("19.339.754/0001-07");
        System.out.println("Aqui CNPJ" + jftCPF.getText());
        jtfRG.setText("Inscrição Estadual");
        jftDataNascimento.setText("28/08/1991");
        jtaObs.setText("Qualquer OBS");

        jftCPFResponsavel.setText("11301353493");
        jtfNomeFantasia.setText("Empresa S/A Fantasia");
        jtfNomeResponsavel.setText("José Maria");
        jcbAtivo.setSelected(true);

        jtfEndereco.setText("Av. Guilherme de Almeida");
        jtfNumero.setText("2025");
        jtfComplemento.setText("");
        jtfBairro.setText("Morro do Algodão");

        jftCEP.setText("11.671-000");
        jcbCidade.setSelectedIndex(189);

        jftTelefone.setText("1238875776");
        jftCelular.setText("12981097059");
        jftComercial.setText("");
        jtfEmail.setText("teste@teste");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPessoa = new javax.swing.ButtonGroup();
        bgSexo = new javax.swing.ButtonGroup();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jlCodigoInterno = new javax.swing.JLabel();
        jtfCodigoInterno = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jlCPF_CNPJ = new javax.swing.JLabel();
        jlRG_Incricao = new javax.swing.JLabel();
        jlSexo = new javax.swing.JLabel();
        jtfRG = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jtfEndereco = new javax.swing.JTextField();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFeminino = new javax.swing.JRadioButton();
        jftCPF = new javax.swing.JFormattedTextField();
        jlEndereco = new javax.swing.JLabel();
        jlNumero = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jlEstado = new javax.swing.JLabel();
        jlTelefone = new javax.swing.JLabel();
        jlCelular = new javax.swing.JLabel();
        jlComercial = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jlComplemento = new javax.swing.JLabel();
        jlObs = new javax.swing.JLabel();
        jlNovoFiador = new javax.swing.JLabel();
        jtfNovoFiador = new javax.swing.JTextField();
        jlDataNascimento = new javax.swing.JLabel();
        jlEstadoCivil = new javax.swing.JLabel();
        jcbEstadoCivil = new javax.swing.JComboBox();
        jftCPFResponsavel = new javax.swing.JFormattedTextField();
        jlFiador = new javax.swing.JLabel();
        jtfNomeResponsavel = new javax.swing.JTextField();
        jftDataNascimento = new javax.swing.JFormattedTextField();
        jlNomeFantasia = new javax.swing.JLabel();
        jtfNomeFantasia = new javax.swing.JTextField();
        jlCPFResponsavel = new javax.swing.JLabel();
        jspObs = new javax.swing.JScrollPane();
        jtaObs = new javax.swing.JTextArea();
        jlInteresses = new javax.swing.JLabel();
        jcbLocacao = new javax.swing.JCheckBox();
        jcbCompra = new javax.swing.JCheckBox();
        jcbTroca = new javax.swing.JCheckBox();
        jtfNumero = new javax.swing.JTextField();
        jlCEP = new javax.swing.JLabel();
        jftCEP = new javax.swing.JFormattedTextField();
        jcbFiador = new javax.swing.JComboBox<String>();
        jcbEstado = new javax.swing.JComboBox();
        jcbCidade = new javax.swing.JComboBox<String>();
        jtfComplemento = new javax.swing.JTextField();
        jftTelefone = new javax.swing.JFormattedTextField();
        jftCelular = new javax.swing.JFormattedTextField();
        jftComercial = new javax.swing.JFormattedTextField();
        jtfEmail = new javax.swing.JTextField();
        jrbPessoaFisica = new javax.swing.JRadioButton();
        jrbPessoaJuridica = new javax.swing.JRadioButton();
        jcbAtivo = new javax.swing.JCheckBox();
        jlSituacao = new javax.swing.JLabel();
        jlAddFiador = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1024, 640));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbConfirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salvar.png"))); // NOI18N
        jbConfirmar.setText("Confirmar");
        jbConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConfirmarMouseClicked(evt);
            }
        });
        getContentPane().add(jbConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 520, 140, 70));

        jbCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 140, 70));

        jbEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar2.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEditarMouseClicked(evt);
            }
        });
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 140, 70));

        jlCodigoInterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCodigoInterno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCodigoInterno.setText("Código Interno:");
        getContentPane().add(jlCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 150, 30));

        jtfCodigoInterno.setEditable(false);
        getContentPane().add(jtfCodigoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 100, 30));

        jlNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNome.setText("Nome:");
        getContentPane().add(jlNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 150, 30));

        jlCPF_CNPJ.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPF_CNPJ.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCPF_CNPJ.setText("CPF:");
        getContentPane().add(jlCPF_CNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 150, 30));

        jlRG_Incricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlRG_Incricao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlRG_Incricao.setText("RG:");
        getContentPane().add(jlRG_Incricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 180, 30));

        jlSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSexo.setText("Sexo:");
        getContentPane().add(jlSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 40, 30));
        getContentPane().add(jtfRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 160, 30));
        getContentPane().add(jtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 350, 30));
        getContentPane().add(jtfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 170, 30));
        getContentPane().add(jtfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 350, 30));

        bgSexo.add(jrbMasculino);
        jrbMasculino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbMasculino.setText("Masculino");
        getContentPane().add(jrbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, 30));

        bgSexo.add(jrbFeminino);
        jrbFeminino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbFeminino.setText("Feminino");
        getContentPane().add(jrbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, -1, 30));
        getContentPane().add(jftCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 150, 30));

        jlEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEndereco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlEndereco.setText("Endereço:");
        getContentPane().add(jlEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 150, 30));

        jlNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNumero.setText("Número:");
        getContentPane().add(jlNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, -1, 30));

        jlBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlBairro.setText("Bairro:");
        getContentPane().add(jlBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, 30));

        jlCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCidade.setText("Cidade:");
        getContentPane().add(jlCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 50, 30));

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("Estado:");
        getContentPane().add(jlEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, -1, 30));

        jlTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTelefone.setText("Telefone:");
        getContentPane().add(jlTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 150, 30));

        jlCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCelular.setText("Celular:");
        getContentPane().add(jlCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 60, 30));

        jlComercial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComercial.setText("Alternativo:");
        getContentPane().add(jlComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, -1, 30));

        jlEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlEmail.setText("Email:");
        getContentPane().add(jlEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 150, 30));

        jlComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlComplemento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlComplemento.setText("Complemento:");
        getContentPane().add(jlComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 150, 30));

        jlObs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlObs.setText("Observações:");
        getContentPane().add(jlObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, 30));

        jlNovoFiador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNovoFiador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNovoFiador.setText("Novo Fiador:");
        getContentPane().add(jlNovoFiador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 150, 30));
        getContentPane().add(jtfNovoFiador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 350, 30));

        jlDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlDataNascimento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlDataNascimento.setText("Data de Nascimento:");
        getContentPane().add(jlDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 150, 30));

        jlEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstadoCivil.setText("Estado Civil:");
        getContentPane().add(jlEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, -1, 30));

        jcbEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 130, 30));
        getContentPane().add(jftCPFResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 150, 30));

        jlFiador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlFiador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlFiador.setText("Selecionar Fiador:");
        getContentPane().add(jlFiador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, 30));
        getContentPane().add(jtfNomeResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 350, 30));
        getContentPane().add(jftDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 120, 30));

        jlNomeFantasia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlNomeFantasia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNomeFantasia.setText("Nome Fantasia:");
        getContentPane().add(jlNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 140, 30));
        getContentPane().add(jtfNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 350, 30));

        jlCPFResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCPFResponsavel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCPFResponsavel.setText("CPF Responsavel:");
        getContentPane().add(jlCPFResponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 140, 30));

        jtaObs.setColumns(20);
        jtaObs.setRows(5);
        jspObs.setViewportView(jtaObs);

        getContentPane().add(jspObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 380, 70));

        jlInteresses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlInteresses.setText("Interesses");
        getContentPane().add(jlInteresses, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, -1, 30));

        jcbLocacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbLocacao.setText("Locação");
        getContentPane().add(jcbLocacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, 30));

        jcbCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbCompra.setText("Compra");
        getContentPane().add(jcbCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, -1, 30));

        jcbTroca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbTroca.setText("Temporada");
        getContentPane().add(jcbTroca, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 100, 30));
        getContentPane().add(jtfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 50, 30));

        jlCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCEP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlCEP.setText("CEP:");
        getContentPane().add(jlCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 150, 30));
        getContentPane().add(jftCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 110, 30));

        jcbFiador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFiador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiadorActionPerformed(evt);
            }
        });
        getContentPane().add(jcbFiador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 350, 30));

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 70, 30));

        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 230, 30));
        getContentPane().add(jtfComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 760, 30));
        getContentPane().add(jftTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 180, 30));
        getContentPane().add(jftCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 200, 30));
        getContentPane().add(jftComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 220, 30));
        getContentPane().add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 760, 30));

        bgPessoa.add(jrbPessoaFisica);
        jrbPessoaFisica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbPessoaFisica.setSelected(true);
        jrbPessoaFisica.setText("Física");
        jrbPessoaFisica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jrbPessoaFisicaMousePressed(evt);
            }
        });
        getContentPane().add(jrbPessoaFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, 30));

        bgPessoa.add(jrbPessoaJuridica);
        jrbPessoaJuridica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbPessoaJuridica.setText("Jurídica");
        jrbPessoaJuridica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jrbPessoaJuridicaMousePressed(evt);
            }
        });
        getContentPane().add(jrbPessoaJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, 30));

        jcbAtivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbAtivo.setText("Ativo");
        getContentPane().add(jcbAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, -1, -1));

        jlSituacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlSituacao.setText("Situação Cadastral:");
        getContentPane().add(jlSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, 30));

        jlAddFiador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jlAddFiador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlAddFiadorMousePressed(evt);
            }
        });
        getContentPane().add(jlAddFiador, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 170, -1, -1));

        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 970, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConfirmarMouseClicked
        if (jbConfirmar.isEnabled()) {
            if (jrbPessoaFisica.isSelected()) {
                if (validaCampos(true)) {
                    try {
                        if (pessoaFisica == null) {
                            cadastrarPessoaFisica();
                            JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
                            cadastroFiador.getInstancia().dispose();
                            ZerarCampos();
                            pessoaFisica = null;
                            encerrarInstancia();
                            cadastroClienteHome.getInstancia().setVisible(true);
                            cadastroClienteHome.getInstancia().setLocationRelativeTo(this);
                            cadastroClienteHome.getInstancia().popularTabela();
                            Sessao.getInstance().setInstanciaAberta(3);
                            dispose();
                        } else {
                            cadastrarPessoaFisica(pessoaFisica);
                            JOptionPane.showMessageDialog(this, "Atualização efetuada com sucesso!");
                            ZerarCampos();
                            pessoaFisica = null;
                            cadastroClienteHome.getInstancia().popularTabela();
                            encerrarInstancia();
                            dispose();
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(cadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Verifique os campos obrigatórios!");
                }
            } else if (jrbPessoaJuridica.isSelected()) {
                if (validaCampos(true)) {
                    try {
                        if (pessoaJuridica == null) {
                            cadastrarPessoaJuridica();
                            JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
                            ZerarCampos();
                            pessoaJuridica = null;
                            encerrarInstancia();
                            cadastroClienteHome.getInstancia().setVisible(true);
                            cadastroClienteHome.getInstancia().setLocationRelativeTo(this);
                            cadastroClienteHome.getInstancia().popularTabela();
                            Sessao.getInstance().setInstanciaAberta(3);
                            dispose();
                        } else {
                            cadastrarPessoaJuridica(pessoaJuridica);
                            JOptionPane.showMessageDialog(this, "Atualização efetuada com sucesso!");
                            ZerarCampos();
                            pessoaJuridica = null;
                            cadastroClienteHome.getInstancia().popularTabela();
                            encerrarInstancia();
                            dispose();
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(cadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Verifique os campos obrigatórios!");

                }
            }
        }
    }//GEN-LAST:event_jbConfirmarMouseClicked

    public void ativaPessoa(boolean ativo) {
        if (ativo == false) {
            jlCPF_CNPJ.setText("CNPJ");
            jlRG_Incricao.setText("Inscrição Estadual");
            jlNome.setText("Razão Social");
            jlEndereco.setText("Logradouro");
            jlDataNascimento.setText("Data Fundação");
            jlFiador.setText("Nome Responsável");
        } else {
            jlCPF_CNPJ.setText("CPF");
            jlRG_Incricao.setText("RG");
            jlNome.setText("Nome");
            jlEndereco.setText("Endereço");
            jlDataNascimento.setText("Data Nascimento");
            jlFiador.setText("Fiador");
        }
        //Passando True Ativa Pessoa Fisica, False Pessoa Juridica
        jlNovoFiador.setVisible(ativo);
        jlNovoFiador.setEnabled(ativo);
        jtfNovoFiador.setVisible(ativo);
        jtfNovoFiador.setEnabled(ativo);
        jlEstadoCivil.setVisible(ativo);
        jlEstadoCivil.setEnabled(ativo);
        jcbEstadoCivil.setVisible(ativo);
        jcbEstadoCivil.setEnabled(ativo);
        jcbFiador.setVisible(ativo);
        jcbFiador.setEnabled(ativo);
        jlSexo.setVisible(ativo);
        jlSexo.setEnabled(ativo);
        jrbFeminino.setVisible(ativo);
        jrbMasculino.setVisible(ativo);
        jrbFeminino.setEnabled(ativo);
        jrbMasculino.setEnabled(ativo);
        jlAddFiador.setEnabled(ativo);
        jlAddFiador.setVisible(ativo);

        //Passando False Pessoa Juridica
        jtfNomeResponsavel.setVisible(!ativo);
        jtfNomeResponsavel.setEnabled(!ativo);
        jlNomeFantasia.setVisible(!ativo);
        jlNomeFantasia.setEnabled(!ativo);
        jtfNomeFantasia.setEnabled(!ativo);
        jtfNomeFantasia.setVisible(!ativo);
        jlCPFResponsavel.setVisible(!ativo);
        jlCPFResponsavel.setEnabled(!ativo);
        jftCPFResponsavel.setVisible(!ativo);
        jftCPFResponsavel.setEnabled(!ativo);
        jcbAtivo.setVisible(!ativo);
        jcbAtivo.setEnabled(!ativo);
        jlSituacao.setVisible(!ativo);
        jlSituacao.setEnabled(!ativo);
    }

    public void mascaraCPF_CNPJ(boolean ativa) {
        try {
            if (ativa) {
                jftCPF.setFormatterFactory(new DefaultFormatterFactory(
                        new MaskFormatter("###.###.###-##")));
            } else {
                jftCPF.setFormatterFactory(new DefaultFormatterFactory(
                        new MaskFormatter("##.###.###/####-##")));
                jftCPFResponsavel.setFormatterFactory(new DefaultFormatterFactory(
                        new MaskFormatter("###.###.###-##")));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraData() {
        try {
            jftDataNascimento.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##/##/####")));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void mascaraCEP() {
        try {
            jftCEP.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##.###-###")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraTelefone() {
        try {
            jftTelefone.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##)####-####")));
            jftComercial.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##)####-####")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void mascaraCelular() {
        try {
            jftCelular.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##)#####-####")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void configuraMascaras() {
        mascaraCelular();
        mascaraTelefone();
        mascaraCEP();
        mascaraData();
    }

    public boolean validaCampos(boolean valida) {
        //PESSOA        
        //Email
        if (!jtfEmail.getText().equals("")) {
            jtfEmail.setBackground(Color.white);
        } else {
            jtfEmail.setBackground(Color.red);
            valida = false;
        }
        //Endereço
        if (!jtfEndereco.getText().equals("")) {
            jtfEndereco.setBackground(Color.white);
        } else {
            jtfEndereco.setBackground(Color.red);
            valida = false;
        }
        //Número
        if (!jtfNumero.getText().equals("") && validacao.validaNumeros(jtfNumero.getText())) {
            jtfNumero.setBackground(Color.white);
        } else {
            jtfNumero.setBackground(Color.red);
            valida = false;
        }
        //Bairro
        if (!jtfBairro.getText().equals("") && validacao.validaLetras(jtfBairro.getText())) {
            jtfBairro.setBackground(Color.white);
        } else {
            jtfBairro.setBackground(Color.red);
            valida = false;
        }
        //Cidade
        if (jcbCidade.getSelectedItem() != null) {
            jcbCidade.setBackground(Color.white);
        } else {
            jcbCidade.setBackground(Color.red);
            valida = false;
        }
        //Estado
        if (jcbEstado.getSelectedItem() != null) {
            jcbEstado.setBackground(Color.white);
        } else {
            jcbEstado.setBackground(Color.red);
            valida = false;
        }
        //CEP
        if (jftCEP.getText().trim().length() == 10) {
            jftCEP.setBackground(Color.white);
        } else {
            jftCEP.setBackground(Color.red);
            valida = false;
        }
        //Data Nascimento
        if (jftDataNascimento.getText().trim().length() == 10) {
            jftDataNascimento.setBackground(Color.white);
        } else {
            jftDataNascimento.setBackground(Color.red);
            valida = false;
        }
        //Telefone
        if (jftTelefone.getText().trim().length() == 13 || jftCelular.getText().trim().length() == 14 || jftComercial.getText().trim().length() == 13) {
            jftTelefone.setBackground(Color.white);
            jftCelular.setBackground(Color.white);
            jftComercial.setBackground(Color.white);
        } else {
            jftTelefone.setBackground(Color.red);
            jftCelular.setBackground(Color.red);
            jftComercial.setBackground(Color.red);
            valida = false;
        }
        //PESSOA FÍSICA
        if (jrbPessoaFisica.isSelected()) {
            //Nome
            if (!jtfNome.getText().equals("") && validacao.validaLetras(jtfNome.getText())) {
                jtfNome.setBackground(Color.white);
            } else {
                jtfNome.setBackground(Color.red);
                valida = false;
            }
            //CPF
            if (jftCPF.getText().trim().length() == 14) {
                jftCPF.setBackground(Color.white);
            } else {
                jftCPF.setBackground(Color.red);
                valida = false;
            }
            if (!jtfRG.getText().isEmpty()) {
                jtfRG.setBackground(Color.white);
            } else {
                jtfRG.setBackground(Color.red);
                valida = false;
            }
            //Sexo
            if (jrbMasculino.isSelected() || jrbFeminino.isSelected()) {
                jrbMasculino.setBackground(Color.white);
                jrbFeminino.setBackground(Color.white);
            } else {
                jrbMasculino.setBackground(Color.red);
                jrbFeminino.setBackground(Color.red);
                valida = false;
            }
            //Estado Cíveil
            if (jcbEstadoCivil.getSelectedItem() != null) {
                jcbEstadoCivil.setBackground(Color.white);
            } else {
                jcbEstadoCivil.setBackground(Color.red);
                valida = false;
            }
            if (jtfNovoFiador.getText().isEmpty() && fiadorGlobal == null) {
                jtfNovoFiador.setBackground(Color.white);
            } else {
                jtfNovoFiador.setBackground(Color.red);
                valida = false;
            }
            //PESSOA JURÍDICA
        } else if (jrbPessoaJuridica.isSelected()) {
            //Razão Social
            if (!jtfNome.getText().equals("")) {
                jtfNome.setBackground(Color.white);
            } else {
                jtfNome.setBackground(Color.red);
                valida = false;
            }
            //CNPJ
            if (jftCPF.getText().trim().length() == 18) {
                jftCPF.setBackground(Color.white);
            } else {
                jftCPF.setBackground(Color.red);
                valida = false;
            }
            if (!jtfNomeFantasia.getText().isEmpty()) {
                jtfNomeFantasia.setBackground(Color.white);
            } else {
                jtfNomeFantasia.setBackground(Color.red);
                valida = false;
            }
            if (!jtfNomeResponsavel.getText().isEmpty() && validacao.validaLetras(jtfNomeResponsavel.getText())) {
                jtfNomeResponsavel.setBackground(Color.white);
            } else {
                jtfNomeResponsavel.setBackground(Color.red);
                valida = false;
            }
            if (jftCPFResponsavel.getText().trim().length() == 14) {
                jftCPFResponsavel.setBackground(Color.white);
            } else {
                jftCPFResponsavel.setBackground(Color.red);
                valida = false;
            }
        }
        return valida;
    }

    public void limpaCampos() {
        jtfNome.setText("");
        jtfNome.setBackground(Color.white);
        jftCPF.setText("");
        jftCPF.setBackground(Color.white);
        jtfEndereco.setText("");
        jtfEndereco.setBackground(Color.white);
        jtfBairro.setText("");
        jtfBairro.setBackground(Color.white);
//        jcbCidade.setText("");
        jcbCidade.setBackground(Color.white);
        jftDataNascimento.setText("");
        jftDataNascimento.setBackground(Color.white);
        jtfNumero.setText("");
        jtfNumero.setBackground(Color.white);
        jcbEstado.setBackground(Color.white);
        jftTelefone.setText("");
        jftTelefone.setBackground(Color.white);
        jftCelular.setText("");
        jftCelular.setBackground(Color.white);
        jftComercial.setText("");
        jftComercial.setBackground(Color.white);
        jcbEstadoCivil.setBackground(Color.white);
        jtfNovoFiador.setText("");
        jtfNovoFiador.setBackground(Color.white);
        jtfNomeResponsavel.setText("");
        jtfNomeResponsavel.setBackground(Color.white);
        jtfNomeFantasia.setText("");
        jtfNomeFantasia.setBackground(Color.white);
        jftCPFResponsavel.setText("");
        jftCPFResponsavel.setBackground(Color.white);
        jtfComplemento.setText("");
        jtfComplemento.setBackground(Color.white);
        jtfEmail.setText("");
        jtfEmail.setBackground(Color.white);
    }

    public void carregaEstados() {
        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = new Estado();
        List<Estado> listaEstados = estadoDAO.getAll();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaEstados.toArray());
        jcbEstado.setModel(defaultComboBox);
    }

    public void carregaCidades() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> listaCidades = cidadeDAO.getAll();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaCidades.toArray());
        jcbCidade.setModel(defaultComboBox);
    }

    public void carregaCidadeEstados() {
        Estado estado = (Estado) jcbEstado.getSelectedItem();
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> listaCidades = cidadeDAO.getWhereIdEstado(estado.getId());
        jcbCidade.removeAllItems();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaCidades.toArray());
        jcbCidade.setModel(defaultComboBox);
        listaCidadesGlobal = listaCidades;
    }

    public void carregaEstadosCivis() {
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        List<EstadoCivil> listaEstadoCivis = estadoCivilDAO.getAll();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaEstadoCivis.toArray());
        jcbEstadoCivil.setModel(defaultComboBox);
    }

    public void carregaFiadores() {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> listaFiadores = pessoaFisicaDAO.getAll();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaFiadores.toArray());
        defaultComboBox.addElement(null);
        jcbFiador.setModel(defaultComboBox);
        jcbFiador.setSelectedIndex(-1);
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


    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        if (jbCancelar.isEnabled()) {
            if (jbCancelar.isEnabled()) {//                   
                String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(this, "Esta certo que quer Fechar ?", "Verificação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    cadastroClienteHome homeFuncionario = cadastroClienteHome.getInstancia();
                    cadastroClienteHome.getInstancia().setVisible(true);
                    cadastroClienteHome.getInstancia().setLocationRelativeTo(this);
                    cadastroClienteHome.getInstancia().popularTabela();
                    Sessao.getInstance().setInstanciaAberta(3);
                    dispose();
                    encerrarInstancia();
                }
            }
        }

    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        if (jcbEstado.getSelectedIndex() > -1) {
            carregaCidadeEstados();
        }
    }//GEN-LAST:event_jcbEstadoActionPerformed

    private void jbEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMouseClicked
        if (jbEditar.isEnabled()) {
            cadastroCliente.getInstancia().DisableEnable(true);
            JOptionPane.showMessageDialog(this, "Campos abertos para edição!");
        }
    }//GEN-LAST:event_jbEditarMouseClicked

    private void jrbPessoaJuridicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPessoaJuridicaMousePressed
        ativaPessoa(false);
        mascaraCPF_CNPJ(false);
        limpaCampos();
        carregaEstados();
        populaPessoaJuridica();
    }//GEN-LAST:event_jrbPessoaJuridicaMousePressed

    private void jrbPessoaFisicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPessoaFisicaMousePressed
        ativaPessoa(true);
        mascaraCPF_CNPJ(true);
        limpaCampos();
        carregaEstados();
        carregaEstadosCivis();
        populaPessoaFisica();
    }//GEN-LAST:event_jrbPessoaFisicaMousePressed

    private void jlAddFiadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAddFiadorMousePressed
        if (!jtfNovoFiador.getText().isEmpty() && jcbFiador.getSelectedItem() == null) {
            cadastroFiador.getInstancia().setLocationRelativeTo(this);
            cadastroFiador.getInstancia().setVisible(true);
        }
    }//GEN-LAST:event_jlAddFiadorMousePressed

    private void jcbFiadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiadorActionPerformed
        if (jcbFiador.getSelectedItem() != null) {
            jtfNovoFiador.setText("");
            fiadorGlobal = null;
        }
    }//GEN-LAST:event_jcbFiadorActionPerformed

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
            java.util.logging.Logger.getLogger(cadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPessoa;
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    public static javax.swing.JButton jbEditar;
    private javax.swing.JCheckBox jcbAtivo;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JCheckBox jcbCompra;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JComboBox jcbEstadoCivil;
    public static javax.swing.JComboBox<String> jcbFiador;
    private javax.swing.JCheckBox jcbLocacao;
    private javax.swing.JCheckBox jcbTroca;
    private javax.swing.JFormattedTextField jftCEP;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JFormattedTextField jftCPFResponsavel;
    private javax.swing.JFormattedTextField jftCelular;
    private javax.swing.JFormattedTextField jftComercial;
    private javax.swing.JFormattedTextField jftDataNascimento;
    private javax.swing.JFormattedTextField jftTelefone;
    private javax.swing.JLabel jlAddFiador;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCEP;
    private javax.swing.JLabel jlCPFResponsavel;
    private javax.swing.JLabel jlCPF_CNPJ;
    private javax.swing.JLabel jlCelular;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlCodigoInterno;
    private javax.swing.JLabel jlComercial;
    private javax.swing.JLabel jlComplemento;
    private javax.swing.JLabel jlDataNascimento;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlEstadoCivil;
    private javax.swing.JLabel jlFiador;
    private javax.swing.JLabel jlInteresses;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNomeFantasia;
    private javax.swing.JLabel jlNovoFiador;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlObs;
    private javax.swing.JLabel jlRG_Incricao;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlSituacao;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JRadioButton jrbFeminino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JRadioButton jrbPessoaFisica;
    public static javax.swing.JRadioButton jrbPessoaJuridica;
    private javax.swing.JScrollPane jspObs;
    private javax.swing.JTextArea jtaObs;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCodigoInterno;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNomeFantasia;
    private javax.swing.JTextField jtfNomeResponsavel;
    public static javax.swing.JTextField jtfNovoFiador;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRG;
    // End of variables declaration//GEN-END:variables
}
