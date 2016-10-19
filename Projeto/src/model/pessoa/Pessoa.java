/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pessoa;

import global.model.Endereco;
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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Rafael Brock
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idPessoa;

    @Column
    private String nomePessoa;

    @Column
    private String email;

    @Column
    private String observacoes;

    @Column
    private Date dataNascimento;
    
    public Pessoa() {
        
    }

    public Pessoa(String nomePessoa, String email, String observacoes, Date dataNascimento, Endereco endereco) {
        this.nomePessoa = nomePessoa;
        this.email = email;
        this.observacoes = observacoes;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    } 
    

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", nullable = true)
    private Endereco endereco;
    
    @OneToMany(
            mappedBy = "pessoa",
            targetEntity = Telefone.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Telefone> telefone = new ArrayList<Telefone>();
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoa", nullable = true)
    private PessoaJuridica pessoaJuridica;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoa", nullable = true)
    private PessoaFisica pessoaFisica;

    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }
    
    public void addTelefone(Telefone telefone) {
        this.telefone.add(telefone);
    }    
    
    
    

    

}
