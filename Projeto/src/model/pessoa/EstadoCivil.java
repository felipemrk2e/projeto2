/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pessoa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Rafael Brock
 */
@Entity
public class EstadoCivil {

    @Id    
    @Column
    private long idEstadoCivil;
    
    @Column
    private String nomeEstadoCivil;

    @OneToMany(
            mappedBy = "estadoCivil",
            targetEntity = PessoaFisica.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();

    public long getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(long idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getNomeEstadoCivil() {
        return nomeEstadoCivil;
    }

    public void setNomeEstadoCivil(String nomeEstadoCivil) {
        this.nomeEstadoCivil = nomeEstadoCivil;
    }

    public List<PessoaFisica> getPessoasFisicas() {
        return pessoasFisicas;
    }

    public void setPessoasFisicas(List<PessoaFisica> pessoasFisicas) {
        this.pessoasFisicas = pessoasFisicas;
    }
    
    public void addEstadoCivil(PessoaFisica pessoaFisica) {
	this.pessoasFisicas.add(pessoaFisica);
    }
    
    
}
