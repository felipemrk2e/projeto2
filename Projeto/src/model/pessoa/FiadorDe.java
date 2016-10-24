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

    public FiadorDe() {

    }

    public long getIdFiador() {
        return idFiador;
    }

    public void setIdFiador(long idFiador) {
        this.idFiador = idFiador;
    }
    
    
}
