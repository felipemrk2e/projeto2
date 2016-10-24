/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.pessoa.Interesse;

/**
 *
 * @author Rafael Brock
 */
public class InteresseDAO extends DAO<Interesse> {

    @Override
    public Interesse getById(Long id) {
        Interesse interesse = null;
		try{
			interesse = entityManager.find(Interesse.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta de Interesse: "+e);
		}
		return interesse;  
    }

    @Override
    public boolean removeById(Long id) {
       Interesse interesse = null;
                try{
                    interesse = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(interesse);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão de Interesse: "+e);
                }
		return false;
    }

    @Override
    public List<Interesse> getAll() {
        return entityManager.createQuery("FROM Interesse").getResultList();
    }
}
