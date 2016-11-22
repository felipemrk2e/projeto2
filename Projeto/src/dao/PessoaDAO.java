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

    private static PessoaDAO instancia;

    public static PessoaDAO getInstancia() {
        if (instancia == null) {
            instancia = new PessoaDAO();
        }
        return instancia;
    }

    public static void encerrarInstancia() {
        instancia = null;
    }

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

    public List<Pessoa> getPorTelefone(String tel) {
        return entityManager.createQuery("FROM Pessoa p JOIN FETCH p.telefone tel WHERE tel.numero = '" + tel + "'").getResultList();
    }

    public List<Pessoa> getCliente() {
        return entityManager.createQuery("FROM Pessoa AS p INNER JOIN p.PessoaFisica").getResultList();
    }
    
    public List<Pessoa> searchPessoa(String nome, String telefone, String cpf, String cnpj, int tipoPessoa){
        String query = "";
        String or = "";
        
        //fisica+juridica == 0
        if(tipoPessoa == 0){
            if(nome != ""){
                query += "pe.nomePessoa LIKE '%"+nome+"%'";
                or = " or ";
            }
            if(query != "")
                return entityManager.createQuery("select distinct pe from Pessoa pe where "+query).getResultList();
        }
        
        //pessoaFisica == 1
        if(tipoPessoa == 1){
            if(nome != ""){
                query += "pf.nomePessoa LIKE '%"+nome+"%'";
                or = " or ";
            }
            if(cpf != ""){
                query += or+"pf.pessoaFisica.CPF LIKE '%"+cpf+"%'";
                or = " or ";
            }
            
            if(query != "")
                return entityManager.createQuery("select distinct pe from Pessoa pe " +
                "join pe.pessoaFisica pf where "+query).getResultList();
            return entityManager.createQuery("select distinct pe from Pessoa pe join pe.pessoaFisica pf").getResultList();
        }
        
        //pessoaJuridica == 2
        if(tipoPessoa == 2){
            if(nome != ""){
                query += "pj.nomePessoa LIKE '%"+nome+"%'";
                or = " or ";
            }
            if(cnpj != ""){
                query += or+"pj.pessoaJuridica.cnpj LIKE '%"+cnpj+"%'";
                or = " or ";
            }
//            if(query != "")
//                return entityManager.createQuery("FROM Pessoa.pessoaJuridica pj WHERE "+query).getResultList();
            if(query != "")
                return entityManager.createQuery("select distinct pe from Pessoa pe " +
                "join pe.pessoaJuridica pj where "+query).getResultList();
            return entityManager.createQuery("select distinct pe from Pessoa pe join pe.pessoaJuridica pj").getResultList();
        }
        
        //pessoaJuridica == 3
        if(tipoPessoa == 3){
            if(nome != ""){
                query += "pff.nomePessoa LIKE '%"+nome+"%'";
                or = " or ";
            }
            if(cpf != ""){
                query += or+"pff.pessoaFisica.CPF LIKE '%"+cpf+"%'";
                or = " or ";
            }
//            if(query != "")
//                return entityManager.createQuery("FROM Pessoa.pessoaJuridica pj WHERE "+query).getResultList();
            if(query != "")
                return entityManager.createQuery("select distinct pe from Pessoa pe " +
                "join pe.pessoaFisica pf join pf.funcionario pff where "+query).getResultList();
            return entityManager.createQuery("select distinct pe from Pessoa pe join pe.pessoaFisica pf join pf.funcionario pff").getResultList();
        }
        
        return entityManager.createQuery("FROM Pessoa pe").getResultList();
    }

}
