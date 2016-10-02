package dao;

import global.model.Bairro;
import java.util.List;

public class BairroDAO extends DAO<Bairro> {

	@Override
	public Bairro getById(Long id) {
		Bairro bairro = null;
		try{
			bairro = entityManager.find(Bairro.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta do Bairro: "+e);
		}
		return bairro;
	}

	@Override
	public boolean removeById(Long id) {
		Bairro bairro = null;
                try{
                    bairro = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(bairro);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão do Bairro: "+e);
                }
		return false;
	}

//    @Override
//    public List<Bairro> getAll() {
//        
//    }

}
