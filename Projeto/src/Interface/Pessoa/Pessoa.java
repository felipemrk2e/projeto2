/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

import global.model.Bairro;
import global.model.Cidade;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sala
 */
@Entity
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
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", nullable = true)
    private Endereco endereco;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idBairro", nullable = true)
    private Bairro bairro;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCidade", nullable = true)
    private Cidade cidade;
    

    @OneToMany(
            mappedBy = "telefone",
            targetEntity = Telefone.class,
            fetch = FetchType.LAZY)
    private List<Telefone> telefone = new ArrayList<Telefone>();    

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoaFisica", nullable = true)
    private PessoaFisica pessoaFisica;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoaJuridica", nullable = true)
    private PessoaJuridica pessoaJuridica;

   
    public Pessoa() {

    }

    public Pessoa(int idPessoa, String nomePessoa, String email, List<Telefone> telefone, String observacoes, Date dataNascimento, Endereco endereco) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.email = email;
        this.telefone = telefone;
        this.observacoes = observacoes;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;       
    }

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

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
    
    public void addTelefone(Telefone telefone){
        this.telefone.add(telefone);
    }
    
    

  
}
