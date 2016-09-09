package Interface.CadImovel.backEnd;

import java.util.*;

public class Imovel {
    private int idImovel;
    private int qtdQuartos;
    private int qtdSuites;
    private int qtdSalas;
    private int qtdBanheiros;
    private int qtdPisos;
    private int lavanderia;
    private int vagasGaragem;
    private int areaServico;
    private int piscina;
    private int lavabos;
    private int depEmpregados;
    private String areaExterna;
    private Date dataConstrucao;
    private String acabamento;
    private String outrosItens;
    private String descricaoImovel;
    private String observacoes;
    private String chaves;
    private float valorIptu;
    private float valorCondominio;
    
    private TipoImovel tipoImovel;
    
    private Mobilia mobilia;
    
    private Terreno terreno;
    
    private LocalImovel localImovel;

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
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

    public Date getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(Date dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
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

    public String getDescricaoImovel() {
        return descricaoImovel;
    }

    public void setDescricaoImovel(String descricaoImovel) {
        this.descricaoImovel = descricaoImovel;
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

    public float getValorIptu() {
        return valorIptu;
    }

    public void setValorIptu(float valorIptu) {
        this.valorIptu = valorIptu;
    }

    public float getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(float valorCondominio) {
        this.valorCondominio = valorCondominio;
    }
    
    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }
    
    public Mobilia getMobilia() {
        return mobilia;
    }

    public void setMobilia(Mobilia mobilia) {
        this.mobilia = mobilia;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public LocalImovel getLocalImovel() {
        return localImovel;
    }

    public void setLocalImovel(LocalImovel localImovel) {
        this.localImovel = localImovel;
    }
    
    public void addMobilia(Mobilia mobilia){
        mobilia.setImovel(this);
        this.setMobilia(mobilia);
    }
    
    public void addTerreno(Terreno terreno){
        terreno.setImovel(this);
        this.setTerreno(terreno);
    }
    
    public void addTipoImovel(TipoImovel tipoImovel){
        this.setTipoImovel(tipoImovel);
    }
    
    public void addLocalImovel(LocalImovel localImovel){
        this.setLocalImovel(localImovel);
    }


    
    
    
}
