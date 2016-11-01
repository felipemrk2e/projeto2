/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.pessoa.Funcionario;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class FuncionarioDAO extends DAO<Funcionario> {

    @Override
    public Funcionario getById(Long id) {
        Funcionario funcionario = null;
        try {
            funcionario = entityManager.find(Funcionario.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta de Funcionario: " + e);
        } finally {
            entityManager.close();
        }
        return funcionario;
    }

    @Override
    public boolean removeById(Long id) {
        Funcionario funcionario = null;
        boolean flag = true;
        try {
            funcionario = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão de Funcionario: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<Funcionario> getAll() {
        List<Funcionario> funcionarios = entityManager.createQuery("FROM Funcionario").getResultList();
        entityManager.close();
        return funcionarios;
    }
    
}
