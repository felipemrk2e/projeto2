package global.model;

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

@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idCidade;

    @Column
    private String nomeCidade;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "idEstado", nullable = false)
    private Estado estado;

    @OneToMany(
            mappedBy = "cidade",
            targetEntity = Endereco.class,
            fetch = FetchType.LAZY)
    private final List<Endereco> enderecos = new ArrayList<Endereco>();

    public Cidade(String nomeCidade, Estado estado) {
        this.nomeCidade = nomeCidade;
        this.estado = estado;
    }

    public Cidade() {

    }

    public long getIdCidade() {
        return this.idCidade;
    }

    public void setIdCidade(long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        estado.addCidade(this);
        this.estado = estado;
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

}
