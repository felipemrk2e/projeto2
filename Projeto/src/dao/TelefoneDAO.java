/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.pessoa.Telefone;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class TelefoneDAO extends DAO<Telefone>{

    @Override
    public Telefone getById(Long id) {
        Telefone telefone = null;
        try {
            telefone = entityManager.find(Telefone.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta de Telefone: " + e);
        } finally {
            entityManager.close();
        }
        return telefone;
    }

    @Override
    public boolean removeById(Long id) {
        Telefone telefone = null;
        boolean flag = true;
        try {
            telefone = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(telefone);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão de Telefone: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<Telefone> getAll() {
        List<Telefone> telefones = entityManager.createQuery("FROM Telefone").getResultList();
        entityManager.close();
        return telefones;
    }
    
}
