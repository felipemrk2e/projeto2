package dao;

import imovel.model.TipoImovel;
import java.util.List;

public class TipoImovelDAO extends DAO<TipoImovel> {
	
    @Override
    public TipoImovel getById(Long id) {
        TipoImovel tipoImovel = null;
        try {
            tipoImovel = entityManager.find(TipoImovel.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta do TipoImovel: " + e);
        } finally {
            entityManager.close();
        }
        return tipoImovel;
    }

    @Override
    public boolean removeById(Long id) {
        TipoImovel tipoImovel = null;
        boolean flag = true;
        try {
            tipoImovel = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(tipoImovel);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão do TipoImovel: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<TipoImovel> getAll() {
        List<TipoImovel> tiposImovel = entityManager.createQuery("FROM TipoImovel").getResultList();
        entityManager.close();
        return tiposImovel;
    }

}
