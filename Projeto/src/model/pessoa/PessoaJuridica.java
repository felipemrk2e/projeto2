/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pessoa;


import global.model.Endereco;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Rafael Brock
 */
@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class PessoaJuridica extends Pessoa {
 
    @Column
    private String cnpj;

    @Column
    private String inscricaoEstadual;

    @Column
    private boolean cadastroAtivo;

    @Column
    private String nomeFantasia;

    @Column
    private String nomeResponsavel;

    @Column
    private String cpfResponsavel;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nomePessoa, String email, String observacoes, Date dataNascimento, Endereco endereco) {
        super(nomePessoa, email, observacoes, dataNascimento, endereco);
    }

    public PessoaJuridica(String cnpj, String inscricaoEstadual, boolean cadastroAtivo, String nomeFantasia, String nomeResponsavel, String cpfResponsavel) {
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.cadastroAtivo = cadastroAtivo;
        this.nomeFantasia = nomeFantasia;
        this.nomeResponsavel = nomeResponsavel;
        this.cpfResponsavel = cpfResponsavel;
    }

    public PessoaJuridica(String cnpj, String inscricaoEstadual, boolean cadastroAtivo, String nomeFantasia, String nomeResponsavel, String cpfResponsavel, String nomePessoa, String email, String observacoes, Date dataNascimento, Endereco endereco, List<Interesse> interesses) {
        super(nomePessoa, email, observacoes, dataNascimento, endereco, interesses);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.cadastroAtivo = cadastroAtivo;
        this.nomeFantasia = nomeFantasia;
        this.nomeResponsavel = nomeResponsavel;
        this.cpfResponsavel = cpfResponsavel;
    }
    
    
    
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public boolean isCadastroAtivo() {
        return cadastroAtivo;
    }

    public void setCadastroAtivo(boolean cadastroAtivo) {
        this.cadastroAtivo = cadastroAtivo;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }
}
