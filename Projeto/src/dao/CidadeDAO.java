package dao;

import global.model.Cidade;
import java.util.List;

public class CidadeDAO extends DAO<Cidade> {

    @Override
    public Cidade getById(Long id) {
        Cidade cidade = null;
        try {
            cidade = entityManager.find(Cidade.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta da Cidade: " + e);
        } finally {
            entityManager.close();
        }
        return cidade;
    }

    @Override
    public boolean removeById(Long id) {
        Cidade cidade = null;
        boolean flag = true;
        try {
            cidade = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(cidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão do Cidade: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<Cidade> getAll() {
        List<Cidade> cidades = entityManager.createQuery("FROM Cidade").getResultList();
        entityManager.close();
        return cidades;
    }

}
