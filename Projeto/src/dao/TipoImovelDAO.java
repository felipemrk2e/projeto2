package dao;

import imovel.model.TipoImovel;

public class TipoImovelDAO extends DAO<TipoImovel> {
	
	@Override
	public TipoImovel getById(Long id) {
		TipoImovel tipoImovel = null;
		try{
			tipoImovel = entityManager.find(TipoImovel.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta do TipoImovel: "+e);
		}
		return tipoImovel;	
	}

	@Override
	public boolean removeById(Long id) {
		return false;
	}

}
