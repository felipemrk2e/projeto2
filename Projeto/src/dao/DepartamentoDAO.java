/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.Pessoa.Departamento;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class DepartamentoDAO extends DAO<Departamento> {

    @Override
    public Departamento getById(Long id) {
        Departamento departamento = null;
		try{
			departamento = entityManager.find(Departamento.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta de Departamento: "+e);
		}
		return departamento;  
    }

    @Override
    public boolean removeById(Long id) {
        Departamento departamento = null;
                try{
                    departamento = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(departamento);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão de Departamento: "+e);
                }
		return false;
    }

    @Override
    public List<Departamento> getAll() {
        return entityManager.createQuery("FROM Departamento").getResultList();
    }
    
}
