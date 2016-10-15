/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

import java.util.ArrayList;
import java.util.Date;
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
public class Funcionario extends PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idFuncionario;

    @Column 
    private double salario;
    
    @Column 
    private String banco;
    
    @Column 
    private String tipoConta;
    
    @Column 
    private String conta;
    
    @Column 
    private String agencia;
        
    @Column 
    private String ctps;
    
    @Column 
    private String serieCtps;
    
    @Column 
    private int PIS;
    
    @Column 
    private Date dataAdmissao;
    
    @Column 
    private String cargaHoraria;
    
    @Column 
    private String escolaridade;
    
    @Column 
    private int dependentes;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="idCargo", nullable = false)
        private Cargo cargo;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idLogin", nullable = true)
    private Login login;

    
    
   
    
}
