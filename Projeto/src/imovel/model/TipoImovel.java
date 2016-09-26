package imovel.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoImovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idTipoImovel;
	
	@Column
	private String tipo;
	
	@Column 
	private String descricao;
	
	//+addImovel
	@OneToMany(
			mappedBy = "tipoImovel", 
			targetEntity = Imovel.class, 
			fetch = FetchType.LAZY)
	private final List<Imovel> imoveis = new ArrayList<Imovel>();
	
	public TipoImovel(String tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	public TipoImovel(){
		
	}

	public long getIdTipoImovel() {
		return idTipoImovel;
	}

	public void setIdTipoImovel(long idTipoImovel) {
		this.idTipoImovel = idTipoImovel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void addImovel(Imovel imovel){
		this.imoveis.add(imovel);
	}
	
}
