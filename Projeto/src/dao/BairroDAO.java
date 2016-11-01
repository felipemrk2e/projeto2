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
        }finally {
            entityManager.close();
        }
        return bairro;
    }

    @Override
    public boolean removeById(Long id) {
        Bairro bairro = null;
        boolean flag = true;
        try {
            bairro = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão do Bairro: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<Bairro> getAll() {
        List<Bairro> bairros = entityManager.createQuery("FROM Bairro").getResultList();
        entityManager.close();
        return bairros;
    }

}
