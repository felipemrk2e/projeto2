package dao;

import imovel.model.Imovel;

public class ImovelDAO extends DAO<Imovel>{

	@Override
	public Imovel getById(Long id) {
		Imovel imovel = null;
		try{
			imovel = entityManager.find(Imovel.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta do Imovel: "+e);
		}
		return imovel;
	}

	@Override
	public boolean removeById(Long id) {
		
		return false;
	}

}
