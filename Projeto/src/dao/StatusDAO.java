/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import global.model.Status;
import java.util.List;

/**
 *
 * @author a1502719
 */
public class StatusDAO extends DAO<Status>{

    @Override
    public Status getById(Long id) {
        Status status = null;
        try {
            status = entityManager.find(Status.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta do Status: " + e);
        } finally {
            entityManager.close();
        }
        return status;
    }

    @Override
    public boolean removeById(Long id) {
        Status status = null;
        boolean flag = true;
        try {
            status = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(status);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão do Status: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<Status> getAll() {
        List<Status> status = entityManager.createQuery("FROM Status").getResultList();
        entityManager.close();
        return status;
    }
    
}
