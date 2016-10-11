/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

import global.model.Endereco;
import imovel.model.Documentacao;
import imovel.model.Imovel_has_TipoContrato;
import imovel.model.Terreno;
import imovel.model.TipoContrato;
import imovel.model.TipoImovel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sala
 */
@Entity
public class Pessoa {

    
    private int numero;
    private String complemento;
    private String CEP;
    private Bairro bairro;
    private Cidade cidade;
    private Estado estado;
    private Pais pais;    
    private String email;
    private String observacoes;
    private Date dataNascimento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idPessoa;

    @Column
    private String nomePessoa;
    
    
    

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idTelefone", nullable = false)
    private Telefone telefone;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstadoCivil", nullable = true)
    private EstadoCivil estadoCivil;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idTerreno", nullable = true)
    private Terreno terreno;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", nullable = true)
    private Endereco endereco;

    //+addTipo
    @OneToMany(
            mappedBy = "imovel",
            targetEntity = Imovel_has_TipoContrato.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<Imovel_has_TipoContrato> tiposContratos = new ArrayList<>();

//    public Imovel(int qtdQuartos, int qtdSuites, int qtdSalas, int qtdBanheiros, int qtdPisos,
//            int lavanderia, int vagasGaragem, int areaServico, int piscina, int lavabos, int depEmpregados,
//            String areaExterna, int dataConstrucao, String acabamento, String outrosItens, String descImovel,
//            String observacoes, String chaves, int tipoMobilia, String descMobilia, double valorIptu,
//            double valorCondominio, imovel.model.TipoImovel tipoImovel, imovel.model.Documentacao documentacao,
//            imovel.model.Terreno terreno, global.model.Endereco endereco) {
//        this.qtdQuartos = qtdQuartos;
//        this.qtdSuites = qtdSuites;
//        this.qtdSalas = qtdSalas;
//        this.qtdBanheiros = qtdBanheiros;
//        this.qtdPisos = qtdPisos;
//        this.lavanderia = lavanderia;
//        this.vagasGaragem = vagasGaragem;
//        this.areaServico = areaServico;
//        this.piscina = piscina;
//        this.lavabos = lavabos;
//        this.depEmpregados = depEmpregados;
//        this.areaExterna = areaExterna;
//        this.dataConstrucao = dataConstrucao;
//        this.acabamento = acabamento;
//        this.outrosItens = outrosItens;
//        this.descImovel = descImovel;
//        this.observacoes = observacoes;
//        this.chaves = chaves;
//        this.tipoMobilia = tipoMobilia;
//        this.descMobilia = descMobilia;
//        this.valorIptu = valorIptu;
//        this.valorCondominio = valorCondominio;
//        this.tipoImovel = tipoImovel;
//        this.documentacao = documentacao;
//        this.terreno = terreno;
//        this.endereco = endereco;
//    }

//    public Imovel() {
//
//    }

   

    

//    public void addTipoContrato(TipoContrato tipoContrato, double valor) {
//        Imovel_has_TipoContrato imovelTipoContrato = new Imovel_has_TipoContrato(this, tipoContrato, valor);
//        tiposContratos.add(imovelTipoContrato);
//        tipoContrato.getTiposContratos().add(imovelTipoContrato);
//    }
//
//    public void removetipoContrato(TipoContrato tipoContrato) {
//        Imovel_has_TipoContrato imovelTipoContrato = new Imovel_has_TipoContrato(this, tipoContrato, 0);
//        tipoContrato.getTiposContratos().remove(imovelTipoContrato);
//        tiposContratos.remove(imovelTipoContrato);
//        imovelTipoContrato.setImovel(null);
//        imovelTipoContrato.setTipoContrato(null);
//        imovelTipoContrato.setValor(0);
//    }


}
