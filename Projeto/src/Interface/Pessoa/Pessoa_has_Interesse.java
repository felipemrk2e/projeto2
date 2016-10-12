/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

import imovel.model.Imovel;
import imovel.model.TipoContrato;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sala
 */
@Entity
public class Pessoa_has_Interesse {

    @Id
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPessoa", nullable = false)
    private Pessoa pessoa;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idInteresse", nullable = false)
    private Interesse interesse;

    public Pessoa_has_Interesse(Pessoa pessoa, Interesse interesse) {
        this.pessoa = pessoa;
        this.interesse = interesse;
    }   
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Interesse getInteresse() {
        return interesse;
    }

    public void setInteresse(Interesse interesse) {
        this.interesse = interesse;
    }
    
    

}
