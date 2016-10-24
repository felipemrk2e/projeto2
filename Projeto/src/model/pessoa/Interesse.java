/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pessoa;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Rafael Brock
 */
@Entity
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idInteresse;

    @Column
    private String nomeInteresse;

    @ManyToMany(mappedBy = "interesses", fetch = FetchType.EAGER)
    private List<Pessoa> pessoas;

    public Interesse() {
        
    }
    
    
    public Interesse(long idInteresse, String nomeInteresse, List<Pessoa> pessoas) {
        this.idInteresse = idInteresse;
        this.nomeInteresse = nomeInteresse;
        this.pessoas = pessoas;
    }

    public long getIdInteresse() {
        return idInteresse;
    }

    public void setIdInteresse(long idInteresse) {
        this.idInteresse = idInteresse;
    }

    public String getNomeInteresse() {
        return nomeInteresse;
    }

    public void setNomeInteresse(String nomeInteresse) {
        this.nomeInteresse = nomeInteresse;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
        
    public void addPessoa(Pessoa pessoa){        
        this.pessoas.add(pessoa);
    }
    
    
}
