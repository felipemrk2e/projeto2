/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.pessoa.FiadorDe;

/**
 *
 * @author Rafael Brock
 */
public class FiadorDeDAO extends DAO<FiadorDe>{

    @Override
    public FiadorDe getById(Long id) {
        FiadorDe fiador = null;
        try {
            fiador = entityManager.find(FiadorDe.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta de Fiador: " + e);
        } finally {
            entityManager.close();
        }
        return fiador;
    }

    @Override
    public boolean removeById(Long id) {
        FiadorDe fiador = null;
        boolean flag = true;
        try {
            fiador = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(fiador);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão de Fiador: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<FiadorDe> getAll() {
        List<FiadorDe> fiadores = entityManager.createQuery("FROM FiadorDe").getResultList();
        entityManager.close();
        return fiadores;
    }
}
