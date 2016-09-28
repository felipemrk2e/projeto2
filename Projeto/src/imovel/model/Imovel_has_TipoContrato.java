package imovel.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Imovel_has_TipoContrato {
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name="idImovel", nullable = false)
    private Imovel imovel;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name="idTipoContrato", nullable = false)
    private TipoContrato tipoContrato;
	
	@Column
	private double valor;

	public Imovel_has_TipoContrato(Imovel imovel, TipoContrato tipoContrato, double valor) {
		this.imovel = imovel;
		this.tipoContrato = tipoContrato;
		this.valor = valor;
	}
	
	public Imovel_has_TipoContrato(){
		
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
