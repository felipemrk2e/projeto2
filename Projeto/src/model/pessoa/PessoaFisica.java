/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pessoa;

import global.model.Endereco;
import imovel.model.TipoContrato;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Rafael Brock
 */
@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class PessoaFisica extends Pessoa {

    @Column
    private String CPF;

    @Column
    private String RG;

    @Column
    private char sexo;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoa", nullable = true)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idEstadoCivil", nullable = false)
    private EstadoCivil estadoCivil;

//    Outro exemplo autorelacionamento
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name = "fiadorDe",
//            joinColumns = {
//                @JoinColumn(name = "idPessoa")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "idFiador")})
//    private List<PessoaFisica> pessoas;
//    @ManyToMany(mappedBy = "pessoas")
//    private List<PessoaFisica> fiadores;
    @OneToMany
    @JoinTable(name = "fiadorDe", joinColumns = @JoinColumn(name = "idPessoa"), inverseJoinColumns = @JoinColumn(name = "idFiador"))
    private List<PessoaFisica> listaFiadores;

    public PessoaFisica() {

    }

    public PessoaFisica(String CPF, String RG, char sexo, Funcionario funcionario, EstadoCivil estadoCivil, String nomePessoa, String email, String observacoes, Date dataNascimento, Endereco endereco) {
        super(nomePessoa, email, observacoes, dataNascimento, endereco);
        this.CPF = CPF;
        this.RG = RG;
        this.sexo = sexo;
        this.funcionario = funcionario;
        this.estadoCivil = estadoCivil;
    }

    public PessoaFisica(String CPF, String RG, char sexo, Funcionario funcionario, EstadoCivil estadoCivil, String nomePessoa, String email, String observacoes, Date dataNascimento, Endereco endereco, List<TipoContrato> interesses) {
        super(nomePessoa, email, observacoes, dataNascimento, endereco, interesses);
        this.CPF = CPF;
        this.RG = RG;
        this.sexo = sexo;
        this.funcionario = funcionario;
        this.estadoCivil = estadoCivil;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        estadoCivil.addEstadoCivil(this);
        this.estadoCivil = estadoCivil;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<PessoaFisica> getListaFiadores() {
        return listaFiadores;
    }

    public void setListaFiadores(List<PessoaFisica> listaFiadores) {
        this.listaFiadores = listaFiadores;
    }

    @Override
    public String toString() {
        return getNomePessoa();
    }
}
