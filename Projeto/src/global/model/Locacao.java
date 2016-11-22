/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.model;

import imovel.model.Imovel;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import model.pessoa.Pessoa;

/**
 *
 * @author 19847
 */

@Entity
public class Locacao implements Serializable{
    
    @Id
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idImovel", nullable = false) 
    private Imovel imovel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idPessoa", nullable = false)
    private Pessoa pessoa;
    
    @Column
    private String dataInicio;
    
    @Column
    private String dataFim;

    public Locacao(Imovel imovel, Pessoa pessoa, String dataInicio, String dataFim) {
        this.imovel = imovel;
        this.pessoa = pessoa;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
    public Locacao(){
        
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    
}
