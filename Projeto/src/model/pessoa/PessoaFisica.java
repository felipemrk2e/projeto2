/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pessoa;


import global.model.Endereco;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Rafael Brock
 */
@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
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
	@JoinColumn(name="idEstadoCivil", nullable = false)
        private EstadoCivil estadoCivil;

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

    public PessoaFisica(String CPF, String RG, char sexo, Funcionario funcionario, EstadoCivil estadoCivil, String nomePessoa, String email, String observacoes, Date dataNascimento, Endereco endereco, List<Interesse> interesses) {
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
    
    

    
    
    
    
    
    
}
