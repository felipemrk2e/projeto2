package global.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idEndereco;

    @Column
    private String nomeEndereco;
    
    @Column
    private String bairro;

    @Column
    private int numero;

    @Column
    private String zona;

    @Column
    private String referencia;

    @Column
    private String complemento;

    @Column
    private String nomeCondominio;
    
    @Column
    private String cep;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCidade", nullable = false)
    private Cidade cidade;

    public Endereco(String nomeEndereco, String bairro, int numero, String zona, String referencia, String complemento, String nomeCondominio,
            String cep, Cidade cidade) {
        this.nomeEndereco = nomeEndereco;
        this.numero = numero;
        this.zona = zona;
        this.referencia = referencia;
        this.complemento = complemento;
        this.nomeCondominio = nomeCondominio;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Endereco() {

    }

    public long getIdEndereco() {
        return this.idEndereco;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }
    
    public String getBairro(){
        return this.bairro;
    }
    
    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNomeCondominio() {
        return nomeCondominio;
    }

    public void setNomeCondominio(String nomeCondominio) {
        this.nomeCondominio = nomeCondominio;
    }
    
    public void setCep(String cep){
        this.cep = cep;
    }
    
    public String getCep(){
        return this.cep;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        cidade.addEndereco(this);
        this.cidade = cidade;
    }
}
