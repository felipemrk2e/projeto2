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
public class PessoaFisicaDAO extends DAO<PessoaFisica> {

    private static PessoaFisicaDAO instancia;

    public static PessoaFisicaDAO getInstancia() {
        if (instancia == null) {
            instancia = new PessoaFisicaDAO();
        }
        return instancia;
    }

    public static void encerrarInstancia() {
        instancia = null;
    }

    @Override
    public PessoaFisica getById(Long id) {
        PessoaFisica pessoaFisica = null;
        try {
            pessoaFisica = entityManager.find(PessoaFisica.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta de Pessoa Física: " + e);
        }
        return pessoaFisica;
    }

    @Override
    public boolean removeById(Long id) {
        PessoaFisica pessoaFisica = null;
        try {
            pessoaFisica = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(pessoaFisica);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Erro na exclusão de Pessoa Física: " + e);
        }
        return false;
    }

    @Override
    public List<PessoaFisica> getAll() {
        return entityManager.createQuery("FROM PessoaFisica").getResultList();
    }

    public List<PessoaFisica> getFiadores(long idPessoa) {
        return entityManager.createQuery("FROM PessoaFisica WHERE idPessoa = '" + idPessoa + "'").getResultList();
    }

    public List<PessoaFisica> getPorTelefone(String tel) {
        return entityManager.createQuery("FROM PessoaFisica pf JOIN FETCH pf.telefone tel WHERE tel.numero = '" + tel + "'").getResultList();
    }

    public List<PessoaFisica> getPorCPF(String cpf) {
        return entityManager.createQuery("FROM PessoaFisica WHERE cpf = '" + cpf + "'").getResultList();
    }
    
    public List<PessoaFisica> getAtivos(){
        return entityManager.createQuery("FROM PessoaFisica p WHERE p.ativo = 1").getResultList();
    }
}
