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
import javax.persistence.OneToMany;

/**
 *
 * @author Rafael Brock
 */
@Entity
public class Departamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idDepartamento;
    
    @Column
    private String nomeDepartamento;
    
    @Column
    private String telefoneDepartamento;
    
    @Column
    private String ramal;
    
    @OneToMany(
            mappedBy = "departamento",
            targetEntity = Cargo.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<Cargo> cargo = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String nomeDepartamento, String telefoneDepartamento, String ramal) {
        this.nomeDepartamento = nomeDepartamento;
        this.telefoneDepartamento = telefoneDepartamento;
        this.ramal = ramal;
    }
    
    

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public String getTelefoneDepartamento() {
        return telefoneDepartamento;
    }

    public void setTelefoneDepartamento(String telefoneDepartamento) {
        this.telefoneDepartamento = telefoneDepartamento;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }
    
    public void addCargo(Cargo cargo) {
	this.cargo.add(cargo);
    }
    
    
    
}
