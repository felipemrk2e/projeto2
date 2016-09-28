package imovel.model;

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

@Entity
public class TipoContrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idTipoContrato;
	
	@Column
	private String tipoContrato;
	
	@Column
	private String descricao;
	
	@OneToMany(
			mappedBy = "tipoContrato", 
			targetEntity = Imovel_has_TipoContrato.class, 
			fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST)
	private List<Imovel_has_TipoContrato> imoveis =  new ArrayList<>();


	public TipoContrato(String tipoContrato, String descricao) {
		this.tipoContrato = tipoContrato;
		this.descricao = descricao;
	}
	
	public TipoContrato(){
		
	}
	

	public long getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(long idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Imovel_has_TipoContrato> getTiposContratos(){
		return this.imoveis;
	}
	
	public void addImovel(Imovel imovel, double valor) {
		Imovel_has_TipoContrato imovelTipoContrato = new Imovel_has_TipoContrato(imovel, this, valor);
        imoveis.add(imovelTipoContrato);
        imovel.getTiposContratos().add(imovelTipoContrato);
    }

    public void removeImovel(Imovel imovel, double valor) {
    	Imovel_has_TipoContrato imovelTipoContrato = new Imovel_has_TipoContrato(imovel, this, valor);
    	imovel.getTiposContratos().remove(imovelTipoContrato);
        imoveis.remove(imovelTipoContrato);
        imovelTipoContrato.setImovel(null);
        imovelTipoContrato.setTipoContrato(null);
        imovelTipoContrato.setValor(0);
    }
}
