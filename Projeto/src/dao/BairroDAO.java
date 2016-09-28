package dao;

import global.model.Bairro;

public class BairroDAO extends DAO<Bairro> {

	@Override
	public Bairro getById(Long id) {
		Bairro bairro = null;
		try{
			bairro = entityManager.find(Bairro.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta do TipoImovel: "+e);
		}
		return bairro;
	}

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
