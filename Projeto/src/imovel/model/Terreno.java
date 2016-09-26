package imovel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Terreno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idTerreno;
	
	@Column
	private double comprimento;
	
	@Column
	private double largura;
	
	@Column
	private double areaConstruida;
	
	@Column
	private String situacaoEscritura;

	public Terreno(double comprimento, double largura, double areaConstruida, String situacaoEscritura) {
		this.comprimento = comprimento;
		this.largura = largura;
		this.areaConstruida = areaConstruida;
		this.situacaoEscritura = situacaoEscritura;
	}
	
	public Terreno(){
		
	}
	
	public long getIdTerreno(){
		return this.idTerreno;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getAreaConstruida() {
		return areaConstruida;
	}

	public void setAreaConstruida(double areaConstruida) {
		this.areaConstruida = areaConstruida;
	}

	public String getSituacaoEscritura() {
		return situacaoEscritura;
	}

	public void setSituacaoEscritura(String situacaoEscritura) {
		this.situacaoEscritura = situacaoEscritura;
	}
	
}
