/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.pessoa.EstadoCivil;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class EstadoCivilDAO extends DAO<EstadoCivil> {

    @Override
    public EstadoCivil getById(Long id) {
        EstadoCivil estadoCivil = null;
        try {
            estadoCivil = entityManager.find(EstadoCivil.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta de Estado Civil: " + e);
        } finally {
            entityManager.close();
        }
        return estadoCivil;
    }

    @Override
    public boolean removeById(Long id) {
        EstadoCivil estadoCivil = null;
        boolean flag = true;
        try {
            estadoCivil = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(estadoCivil);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão de Estado Civil: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<EstadoCivil> getAll() {
        List<EstadoCivil> estadoscivis = entityManager.createQuery("FROM EstadoCivil").getResultList();
        entityManager.close();
        return estadoscivis;
    }
    
}
