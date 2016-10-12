/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

import imovel.model.Imovel_has_TipoContrato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Sala
 */
@Entity
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idInteresse;

    @Column
    private String nomeInteresse;

    @OneToMany(
            mappedBy = "interesse",
            targetEntity = Pessoa_has_Interesse.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<Pessoa_has_Interesse> pessoas = new ArrayList<>();
    
    public void addPessoa(Pessoa pessoa) {
		Pessoa_has_Interesse pessoaInteresse = new Pessoa_has_Interesse(pessoa, this);
        pessoas.add(pessoaInteresse);
        pessoa.getInteresses().add(pessoaInteresse);
    }
    
    public void removePessoa(Pessoa pessoa) {
    	Pessoa_has_Interesse pessoaInteresse = new Pessoa_has_Interesse(pessoa, this);
    	pessoa.getInteresses().remove(pessoaInteresse);
        pessoas.remove(pessoaInteresse);
        pessoaInteresse.setPessoa(null);
        pessoaInteresse.setInteresse(null);
    }

}
