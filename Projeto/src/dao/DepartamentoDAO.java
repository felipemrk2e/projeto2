/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.pessoa.Departamento;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class DepartamentoDAO extends DAO<Departamento> {

    @Override
    public Departamento getById(Long id) {
        Departamento departamento = null;
        try {
            departamento = entityManager.find(Departamento.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta de Departamento: " + e);
        } finally {
            entityManager.close();
        }
        return departamento;
    }

    @Override
    public boolean removeById(Long id) {
        Departamento departamento = null;
        boolean flag = true;
        try {
            departamento = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(departamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão de Departamento: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<Departamento> getAll() {
        List<Departamento> departamentos = entityManager.createQuery("FROM Departamento").getResultList();
        entityManager.close();
        return departamentos;
    }
    
}
