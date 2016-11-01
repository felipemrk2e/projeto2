package dao;

import imovel.model.Imovel;
import java.util.List;

public class ImovelDAO extends DAO<Imovel>{

    @Override
    public Imovel getById(Long id) {
        Imovel imovel = null;
        try {
            imovel = entityManager.find(Imovel.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta do Imovel: " + e);
        } finally {
            entityManager.close();
        }
        return imovel;
    }

    @Override
    public boolean removeById(Long id) {
        Imovel imovel = null;
        boolean flag = true;
        try {
            imovel = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(imovel);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão do Imovel: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<Imovel> getAll() {
        List<Imovel> imoveis = entityManager.createQuery("FROM Imovel").getResultList();
        entityManager.close();
        return imoveis;
    }

}
