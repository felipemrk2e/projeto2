package imovel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Documentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idDocumentacao;

    @Column
    private String numMatricula;

    @Column
    private String numContaAgua;

    @Column
    private String numContaLuz;
    @Column
    private String numIptu;

    @Column
    private String numContrato;

    @Column
    private String cartorio;

    public Documentacao(String numMatricula, String numContaAgua, String numContaLuz, String numIptu, String numContrato, String cartorio) {
        this.numMatricula = numMatricula;
        this.numContaAgua = numContaAgua;
        this.numContaLuz = numContaLuz;
        this.numIptu = numIptu;
        this.numContrato = numContrato;
        this.cartorio = cartorio;
    }

    public Documentacao() {

    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNumContaAgua() {
        return numContaAgua;
    }

    public void setNumContaAgua(String numContaAgua) {
        this.numContaAgua = numContaAgua;
    }

    public String getNumContaLuz() {
        return numContaLuz;
    }

    public void setNumContaLuz(String numContaLuz) {
        this.numContaLuz = numContaLuz;
    }

    public String getNumIptu() {
        return numIptu;
    }

    public void setNumIptu(String numIptu) {
        this.numIptu = numIptu;
    }

    public String getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(String numContrato) {
        this.numContrato = numContrato;
    }

    public String getCartorio() {
        return cartorio;
    }

    public void setCartorio(String cartorio) {
        this.cartorio = cartorio;
    }

}
