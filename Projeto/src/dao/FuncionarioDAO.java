/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.Pessoa.Funcionario;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class FuncionarioDAO extends DAO<Funcionario> {

    @Override
    public Funcionario getById(Long id) {
        Funcionario funcionario = null;
		try{
			funcionario = entityManager.find(Funcionario.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta de Funcionario: "+e);
		}
		return funcionario;       
    }

    @Override
    public boolean removeById(Long id) {
        Funcionario funcionario = null;
                try{
                    funcionario = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(funcionario);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão de Funcionario: "+e);
                }
		return false;
    }

    @Override
    public List<Funcionario> getAll() {
        return entityManager.createQuery("FROM Funcionario").getResultList();
    }
    
}
