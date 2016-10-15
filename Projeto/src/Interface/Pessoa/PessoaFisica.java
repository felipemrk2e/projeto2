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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Sala
 */
@Entity
public class PessoaFisica extends Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idPessoaFisica;
    
    @Column
    private String CPF;
    
    @Column
    private String RG;
    
    @Column
    private char sexo;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFuncionario", nullable = true)
    private Funcionario funcionario;
          
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="idEstadoCivil", nullable = false)
        private EstadoCivil estadoCivil;

    public PessoaFisica() {
    }

    public PessoaFisica(String CPF, String RG, char sexo, EstadoCivil estadoCivil, String nomePessoa, String email, String observacoes, Date dataNascimento, Endereco endereco, PessoaFisica pessoaFisica, Telefone telefone, Interesse interesse) {
        super(nomePessoa, email, observacoes, dataNascimento, endereco, pessoaFisica, telefone, interesse);
        this.CPF = CPF;
        this.RG = RG;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }    
    
    public long getIdPessoaFisica() {
        return idPessoaFisica;
    }

    public void setIdPessoaFisica(long idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
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
//        funcionario.
        this.funcionario = funcionario;
    }
    
    
}
