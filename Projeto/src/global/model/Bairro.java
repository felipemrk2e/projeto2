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
public class Bairro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idBairro;
	
	@Column
	private String nomeBairro;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name="idCidade", nullable = false)
	private Cidade cidade;
	
	@OneToMany(
			mappedBy = "bairro", 
			targetEntity = Endereco.class, 
			fetch = FetchType.LAZY)
	private final List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public Bairro(String nomeBairro, Cidade cidade) {
		this.nomeBairro = nomeBairro;
		this.cidade = cidade;
	}
	
	public Bairro(){
		
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		cidade.addBairro(this);
		this.cidade = cidade;
	}
	
	public void addEndereco(Endereco endereco){
		this.enderecos.add(endereco);
	}
	
}
