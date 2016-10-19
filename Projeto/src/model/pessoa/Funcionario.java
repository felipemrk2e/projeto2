/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pessoa;

import global.model.Endereco;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Rafael Brock
 */
@Entity
public class Funcionario extends PessoaFisica {
    
    @Column 
    private double salario;
    
    @Column 
    private String banco;
    
    @Column 
    private String tipoConta;
    
    @Column 
    private String conta;
    
    @Column 
    private String agencia;
        
    @Column 
    private String ctps;
    
    @Column 
    private String serieCtps;
    
    @Column 
    private int PIS;
    
    @Column 
    private Date dataAdmissao;
    
    @Column 
    private String cargaHoraria;
    
    @Column 
    private String escolaridade;
    
    @Column 
    private int dependentes;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idPessoa", nullable = false)
        private PessoaFisica pessoaFisica;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="idCargo", nullable = false)
        private Cargo cargo;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idLogin", nullable = true)
    private Login login;

    public Funcionario(double salario, String banco, String tipoConta, String conta, String agencia, String ctps, String serieCtps, int PIS, Date dataAdmissao, String cargaHoraria, String escolaridade, int dependentes, Cargo cargo, Login login, String nomePessoa, String email, String observacoes, Date dataNascimento, Endereco endereco) {
        super(nomePessoa, email, observacoes, dataNascimento, endereco);
        this.salario = salario;
        this.banco = banco;
        this.tipoConta = tipoConta;
        this.conta = conta;
        this.agencia = agencia;
        this.ctps = ctps;
        this.serieCtps = serieCtps;
        this.PIS = PIS;
        this.dataAdmissao = dataAdmissao;
        this.cargaHoraria = cargaHoraria;
        this.escolaridade = escolaridade;
        this.dependentes = dependentes;
        this.cargo = cargo;
        this.login = login;
    }

    

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getSerieCtps() {
        return serieCtps;
    }

    public void setSerieCtps(String serieCtps) {
        this.serieCtps = serieCtps;
    }

    public int getPIS() {
        return PIS;
    }

    public void setPIS(int PIS) {
        this.PIS = PIS;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
    
}
