/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

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
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idTelefone;
    
    @Column
    private String numeroTelefone;
    
    @Column
    private String operadora;    
        
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idPessoa", nullable = false)
        private Pessoa pessoa;
}
