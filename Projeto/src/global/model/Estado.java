package global.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estado {

    @Id
    @Column
    private long id;

    @Column
    private String nome;

    @Column
    private String sigla;

    @OneToMany(
            mappedBy = "estado",
            targetEntity = Cidade.class,
            fetch = FetchType.LAZY)
    private final List<Cidade> cidades = new ArrayList<Cidade>();

    public Estado() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void addCidade(Cidade cidade) {
        this.cidades.add(cidade);
    }

    @Override
    public String toString() {
        return sigla;
    }
}
