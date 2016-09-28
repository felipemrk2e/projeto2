package dao;

import global.model.Cidade;

public class CidadeDAO extends DAO<Cidade> {

	@Override
	public Cidade getById(Long id) {
		Cidade cidade = null;
		try{
			cidade = entityManager.find(Cidade.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta do TipoImovel: "+e);
		}
		return cidade;
	}

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
