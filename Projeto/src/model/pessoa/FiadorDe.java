/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pessoa;

import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Rafael Brock
 */
@Entity
public class FiadorDe{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idFiador;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "fiadorDe", joinColumns = {
//        @JoinColumn(name = "idPessoa")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "idFiador")})
//    @Fetch(FetchMode.SUBSELECT)
//    private Collection<PessoaFisica> fiadores;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "idPessoa", insertable = true, updatable = true, nullable = true)
//    private PessoaFisica pessoaFisica;
    
//    @OneToMany(mappedBy = "FiadorDe", fetch = FetchType.LAZY)
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<PessoaFisica> fiadores;   
//    
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "idPessoa", insertable = true, updatable = true)
//    @Fetch(FetchMode.JOIN)
//    @Cascade(CascadeType.SAVE_UPDATE)
//    private PessoaFisica pessoas;   
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "idPessoa", referencedColumnName = "idFiador", updatable = false, insertable = false)
//    private PessoaFisica pessoaFisica;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoaFisica")
//    private List<PessoaFisica> fiadores;
    

    public FiadorDe() {

    }

    public long getIdFiador() {
        return idFiador;
    }

    public void setIdFiador(long idFiador) {
        this.idFiador = idFiador;
    }
    
    
}
