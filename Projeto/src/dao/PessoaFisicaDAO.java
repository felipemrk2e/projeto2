/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.pessoa.PessoaFisica;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class PessoaFisicaDAO extends DAO<PessoaFisica>{

    @Override
    public PessoaFisica getById(Long id) {
        PessoaFisica pessoaFisica = null;
		try{
			pessoaFisica = entityManager.find(PessoaFisica.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta de Pessoa Física: "+e);
		}
		return pessoaFisica; 
    }

    @Override
    public boolean removeById(Long id) {
        PessoaFisica pessoaFisica = null;
                try{
                    pessoaFisica = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(pessoaFisica);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão de Pessoa Física: "+e);
                }
		return false;
    }

    @Override
    public List<PessoaFisica> getAll() {
        return entityManager.createQuery("FROM PessoaFisica").getResultList();
    }
    
}
