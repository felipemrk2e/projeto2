/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import model.pessoa.PessoaJuridica;
import java.util.List;

/**
 *
 * @author a1502735
 */
public class PessoaJuridicaDAO extends DAO<PessoaJuridica>{
    @Override
    public PessoaJuridica getById(Long id) {
        PessoaJuridica pessoaJuridica = null;
        try {
            pessoaJuridica = entityManager.find(PessoaJuridica.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta de Pessoa Juridica: " + e);
        } finally {
            entityManager.close();
        }
        return pessoaJuridica;
    }

    @Override
    public boolean removeById(Long id) {
        PessoaJuridica pessoaJuridica = null;
        boolean flag = true;
        try {
            pessoaJuridica = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(pessoaJuridica);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão de Pessoa Juridica: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<PessoaJuridica> getAll() {
        List<PessoaJuridica> pessoasj = entityManager.createQuery("FROM PessoaJuridica").getResultList();
        entityManager.close();
        return pessoasj;
    }
}
