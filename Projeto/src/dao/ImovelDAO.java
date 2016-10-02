package dao;

import imovel.model.Imovel;
import java.util.List;

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
		Imovel imovel = null;
                try{
                    imovel = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(imovel);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão do Imovel: "+e);
                }
		return false;
	}

//    @Override
//    public List<Imovel> getAll() {
//        
//    }

}
