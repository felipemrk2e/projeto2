/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.pessoa.Cargo;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class CargoDAO extends DAO<Cargo>{

    @Override
    public Cargo getById(Long id) {
        Cargo cargo = null;
		try{
			cargo = entityManager.find(Cargo.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta de Cargo: "+e);
		}
		return cargo;      
    }

    @Override
    public boolean removeById(Long id) {
        Cargo cargo = null;
                try{
                    cargo = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(cargo);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão de Cargo: "+e);
                }
		return false;
    }

    @Override
    public List<Cargo> getAll() {
         return entityManager.createQuery("FROM Cargo").getResultList();
    }
    
}
