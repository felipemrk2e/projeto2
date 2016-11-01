package dao;

import imovel.model.TipoImovel;
import java.util.List;

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
		TipoImovel tipoImovel = null;
                try{
                    tipoImovel = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(tipoImovel);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão do TipoImovel: "+e);
                }
		return false;
	}

    @Override
    public List<TipoImovel> getAll() {
        return entityManager.createQuery("FROM TipoImovel").getResultList();
    }   

}
