/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

import global.model.Endereco;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sala
 */
@Entity
public class PessoaJuridica extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idPessoaJuridica;

    @Column
    private String CNPJ;

    @Column
    private int inscricaoEstadual;

    @Column
    private boolean cadastroAtivo;

    @Column
    private String nomeFantasia;

    @Column
    private String nomeResponsavel;

    @Column
    private String CPFResponsavel;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String CNPJ, int inscricaoEstadual, boolean cadastroAtivo, String nomeFantasia, String nomeResponsavel, String CPFResponsavel, String nomePessoa, String email, String observacoes, Date dataNascimento, Endereco endereco, PessoaJuridica pessoaJuridica, Telefone telefone, Interesse interesse) {
        super(nomePessoa, email, observacoes, dataNascimento, endereco, pessoaJuridica, telefone, interesse);
        this.CNPJ = CNPJ;
        this.inscricaoEstadual = inscricaoEstadual;
        this.cadastroAtivo = cadastroAtivo;
        this.nomeFantasia = nomeFantasia;
        this.nomeResponsavel = nomeResponsavel;
        this.CPFResponsavel = CPFResponsavel;
    }

    

    public long getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(long idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
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

    public String getCPFResponsavel() {
        return CPFResponsavel;
    }

    public void setCPFResponsavel(String CPFResponsavel) {
        this.CPFResponsavel = CPFResponsavel;
    }

    public boolean isCadastroAtivo() {
        return cadastroAtivo;
    }

    public void setCadastroAtivo(boolean cadastroAtivo) {
        this.cadastroAtivo = cadastroAtivo;
    }

}
