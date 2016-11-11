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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Rafael Brock
 */
@Entity
public class Cargo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column
    private long idCargo;
    
    @Column
    private String nomeCargo;
    
    @Column
    private String descricaoCargo;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idDepartamento", nullable = false)
        private Departamento departamento;
    
    @OneToMany(
            mappedBy = "cargo",
            targetEntity = Funcionario.class,
            fetch = FetchType.LAZY)
    private List<Funcionario> funcionario = new ArrayList<>();

    public long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(long idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }
    
    public void addFuncionario(Funcionario funcionario) {
	this.funcionario.add(funcionario);
    }

    @Override
    public String toString() {
        return nomeCargo;
    }
    
    
    
    
    
}
