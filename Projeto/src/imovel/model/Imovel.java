package imovel.model;

import java.sql.Date;
import java.util.ArrayList;
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

import global.model.Endereco;

@Entity
public class Imovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idImovel;
        
        @Column
        private boolean ativo;
	
	@Column
	private int qtdQuartos;
	
	@Column
	private int qtdSuites;
	
	@Column
	private int qtdSalas;
	
	@Column
	private int qtdBanheiros;
	
	@Column
	private int qtdPisos;
	
	@Column
	private int lavanderia;
	
	@Column
	private int vagasGaragem;
	
	@Column
	private int areaServico;
	
	@Column
	private int piscina;
	
	@Column
	private int lavabos;
	
	@Column
	private int depEmpregados;
	
	@Column
	private String areaExterna;
	
	@Column
	private int anoConstrucao;
	
	@Column
	private String acabamento;
	
	@Column
	private String outrosItens;
	
	@Column
	private String descImovel;
	
	@Column
	private String observacoes;
	
	@Column
	private String chaves;
	
	@Column
	private int tipoMobilia;
	
	@Column
	private String descMobilia;
	
	@Column
	private double valorIptu;
	
	@Column
	private double valorCondominio;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="idTipoImovel", nullable = false)
        private TipoImovel tipoImovel;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idDocumentacao", nullable = true)
	private Documentacao documentacao;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idTerreno", nullable = true)
	private Terreno terreno;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idEndereco", nullable = true)
	private Endereco endereco;
	
	//+addTipo
	@OneToMany(
			mappedBy = "imovel", 
			targetEntity = Imovel_has_TipoContrato.class, 
			fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST)
	private List<Imovel_has_TipoContrato> tiposContratos =  new ArrayList<>();

	public Imovel(boolean ativo, int qtdQuartos, int qtdSuites, int qtdSalas, int qtdBanheiros, int qtdPisos,
			int lavanderia, int vagasGaragem, int areaServico, int piscina, int lavabos, int depEmpregados,
			String areaExterna, int anoConstrucao, String acabamento, String outrosItens, String descImovel,
			String observacoes, String chaves, int tipoMobilia, String descMobilia, double valorIptu,
			double valorCondominio, imovel.model.TipoImovel tipoImovel, imovel.model.Documentacao documentacao,
			imovel.model.Terreno terreno, global.model.Endereco endereco) {
                this.ativo = ativo;
		this.qtdQuartos = qtdQuartos;
		this.qtdSuites = qtdSuites;
		this.qtdSalas = qtdSalas;
		this.qtdBanheiros = qtdBanheiros;
		this.qtdPisos = qtdPisos;
		this.lavanderia = lavanderia;
		this.vagasGaragem = vagasGaragem;
		this.areaServico = areaServico;
		this.piscina = piscina;
		this.lavabos = lavabos;
		this.depEmpregados = depEmpregados;
		this.areaExterna = areaExterna;
		this.anoConstrucao = anoConstrucao;
		this.acabamento = acabamento;
		this.outrosItens = outrosItens;
		this.descImovel = descImovel;
		this.observacoes = observacoes;
		this.chaves = chaves;
		this.tipoMobilia = tipoMobilia;
		this.descMobilia = descMobilia;
		this.valorIptu = valorIptu;
		this.valorCondominio = valorCondominio;
		this.tipoImovel = tipoImovel;
		this.documentacao = documentacao;
		this.terreno = terreno;
		this.endereco = endereco;
	}
        
        public Imovel(int qtdQuartos, int qtdSuites, int qtdSalas, int qtdBanheiros, int qtdPisos,
			int lavanderia, int vagasGaragem, int areaServico, int piscina, int lavabos, int depEmpregados,
			String areaExterna, int anoConstrucao, String acabamento, String outrosItens, String descImovel,
			String observacoes, String chaves, int tipoMobilia, String descMobilia, double valorIptu,
			double valorCondominio, imovel.model.TipoImovel tipoImovel, imovel.model.Documentacao documentacao,
			imovel.model.Terreno terreno, global.model.Endereco endereco) {
		this.qtdQuartos = qtdQuartos;
		this.qtdSuites = qtdSuites;
		this.qtdSalas = qtdSalas;
		this.qtdBanheiros = qtdBanheiros;
		this.qtdPisos = qtdPisos;
		this.lavanderia = lavanderia;
		this.vagasGaragem = vagasGaragem;
		this.areaServico = areaServico;
		this.piscina = piscina;
		this.lavabos = lavabos;
		this.depEmpregados = depEmpregados;
		this.areaExterna = areaExterna;
		this.anoConstrucao = anoConstrucao;
		this.acabamento = acabamento;
		this.outrosItens = outrosItens;
		this.descImovel = descImovel;
		this.observacoes = observacoes;
		this.chaves = chaves;
		this.tipoMobilia = tipoMobilia;
		this.descMobilia = descMobilia;
		this.valorIptu = valorIptu;
		this.valorCondominio = valorCondominio;
		this.tipoImovel = tipoImovel;
		this.documentacao = documentacao;
		this.terreno = terreno;
		this.endereco = endereco;
	}

	public Imovel(){
		
	}

	public long getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(long idImovel) {
		this.idImovel = idImovel;
	}
        
        public boolean getAtivo(){
            return this.ativo;
        }
        
        public void setAtivo(boolean ativo){
            this.ativo = ativo;
        }

	public int getQtdQuartos() {
		return qtdQuartos;
	}

	public void setQtdQuartos(int qtdQuartos) {
		this.qtdQuartos = qtdQuartos;
	}

	public int getQtdSuites() {
		return qtdSuites;
	}

	public void setQtdSuites(int qtdSuites) {
		this.qtdSuites = qtdSuites;
	}

	public int getQtdSalas() {
		return qtdSalas;
	}

	public void setQtdSalas(int qtdSalas) {
		this.qtdSalas = qtdSalas;
	}

	public int getQtdBanheiros() {
		return qtdBanheiros;
	}

	public void setQtdBanheiros(int qtdBanheiros) {
		this.qtdBanheiros = qtdBanheiros;
	}

	public int getQtdPisos() {
		return qtdPisos;
	}

	public void setQtdPisos(int qtdPisos) {
		this.qtdPisos = qtdPisos;
	}

	public int getLavanderia() {
		return lavanderia;
	}

	public void setLavanderia(int lavanderia) {
		this.lavanderia = lavanderia;
	}

	public int getVagasGaragem() {
		return vagasGaragem;
	}

	public void setVagasGaragem(int vagasGaragem) {
		this.vagasGaragem = vagasGaragem;
	}

	public int getAreaServico() {
		return areaServico;
	}

	public void setAreaServico(int areaServico) {
		this.areaServico = areaServico;
	}

	public int getPiscina() {
		return piscina;
	}

	public void setPiscina(int piscina) {
		this.piscina = piscina;
	}

	public int getLavabos() {
		return lavabos;
	}

	public void setLavabos(int lavabos) {
		this.lavabos = lavabos;
	}

	public int getDepEmpregados() {
		return depEmpregados;
	}

	public void setDepEmpregados(int depEmpregados) {
		this.depEmpregados = depEmpregados;
	}

	public String getAreaExterna() {
		return areaExterna;
	}

	public void setAreaExterna(String areaExterna) {
		this.areaExterna = areaExterna;
	}

	public int getAnoConstrucao() {
		return anoConstrucao;
	}

	public void setAnoConstrucao(int anoConstrucao) {
		this.anoConstrucao = anoConstrucao;
	}

	public String getAcabamento() {
		return acabamento;
	}

	public void setAcabamento(String acabamento) {
		this.acabamento = acabamento;
	}

	public String getOutrosItens() {
		return outrosItens;
	}

	public void setOutrosItens(String outrosItens) {
		this.outrosItens = outrosItens;
	}

	public String getDescImovel() {
		return descImovel;
	}

	public void setDescImovel(String descImovel) {
		this.descImovel = descImovel;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getChaves() {
		return chaves;
	}

	public void setChaves(String chaves) {
		this.chaves = chaves;
	}

	public int getTipoMobilia() {
		return tipoMobilia;
	}

	public void setTipoMobilia(int tipoMobilia) {
		this.tipoMobilia = tipoMobilia;
	}

	public String getDescMobilia() {
		return descMobilia;
	}

	public void setDescMobilia(String descMobilia) {
		this.descMobilia = descMobilia;
	}

	public double getValorIptu() {
		return valorIptu;
	}

	public void setValorIptu(double valorIptu) {
		this.valorIptu = valorIptu;
	}

	public double getValorCondominio() {
		return valorCondominio;
	}

	public void setValorCondominio(double valorCondominio) {
		this.valorCondominio = valorCondominio;
	}

	public TipoImovel getTipoImovel() {
		return this.tipoImovel;
	}

	public void setTipoImovel(TipoImovel tipoImovel) {
		tipoImovel.addImovel(this);
		this.tipoImovel = tipoImovel;
	}
	
	public Documentacao getDocumentacao() {
		return this.documentacao;
	}

	public void setDocumentacao(Documentacao documentacao) {
		this.documentacao = documentacao;
	}
	
	public Terreno getTerreno() {
		return this.terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Imovel_has_TipoContrato> getTiposContratos(){
		return this.tiposContratos;
	}
	
	public void addTipoContrato(TipoContrato tipoContrato, double valor) {
		Imovel_has_TipoContrato imovelTipoContrato = new Imovel_has_TipoContrato(this, tipoContrato, valor);
        tiposContratos.add(imovelTipoContrato);
        tipoContrato.getTiposContratos().add(imovelTipoContrato);
    }

    public void removetipoContrato(TipoContrato tipoContrato) {
    	Imovel_has_TipoContrato imovelTipoContrato = new Imovel_has_TipoContrato(this, tipoContrato, 0);
    	tipoContrato.getTiposContratos().remove(imovelTipoContrato);
    	tiposContratos.remove(imovelTipoContrato);
        imovelTipoContrato.setImovel(null);
        imovelTipoContrato.setTipoContrato(null);
        imovelTipoContrato.setValor(0);
    }
    
    public boolean mudaAtivo(){
        if(this.ativo==true)
            this.ativo = false;
        else
            this.ativo = true;
        
        return true;
    }
}
