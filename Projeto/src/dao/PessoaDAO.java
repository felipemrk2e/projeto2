/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.pessoa.Pessoa;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class PessoaDAO extends DAO<Pessoa> {

    @Override
    public Pessoa getById(Long id) {
        Pessoa pessoa = null;
        try {
            pessoa = entityManager.find(Pessoa.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta de Pessoa: " + e);
        }
        return pessoa;
    }

    @Override
    public boolean removeById(Long id) {
        Pessoa pessoa = null;
        try {
            pessoa = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Erro na exclusão de Pessoa: " + e);
        }
        return false;
    }

    @Override
    public List<Pessoa> getAll() {
        return entityManager.createQuery("FROM Pessoa").getResultList();
    }

    public List<Pessoa> getQuery(String query) {
        return entityManager.createQuery("FROM Pessoa " + query).getResultList();
    }
    
    public List<Pessoa> getPorTelefone(String tel){
         return entityManager.createQuery("FROM Pessoa p JOIN FETCH p.telefone tel WHERE tel.numero = '"+tel+"'").getResultList();
    }
    
    public List<Pessoa> getCliente(){
         return entityManager.createQuery("FROM Pessoa AS p INNER JOIN p.PessoaFisica").getResultList();
    }
    
    

}
