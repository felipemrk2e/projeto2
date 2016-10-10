package dao;

import global.model.Cidade;
import java.util.List;

public class CidadeDAO extends DAO<Cidade> {

	@Override
	public Cidade getById(Long id) {
		Cidade cidade = null;
		try{
			cidade = entityManager.find(Cidade.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta da Cidade: "+e);
		}
		return cidade;
	}

	@Override
	public boolean removeById(Long id) {
		Cidade cidade = null;
                try{
                    cidade = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(cidade);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão do Cidade: "+e);
                }
		return false;
	}

    @Override
    public List<Cidade> getAll() {
        return entityManager.createQuery("FROM Cidade").getResultList();
    }

}
