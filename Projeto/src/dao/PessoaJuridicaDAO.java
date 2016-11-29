/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import model.pessoa.PessoaJuridica;
import java.util.List;
import model.pessoa.PessoaFisica;

/**
 *
 * @author a1502735
 */
public class PessoaJuridicaDAO extends DAO<PessoaJuridica>{
    
    private static PessoaJuridicaDAO instancia;

    public static PessoaJuridicaDAO getInstancia() {
        if (instancia == null) {
            instancia = new PessoaJuridicaDAO();
        }
        return instancia;
    }

    public static void encerrarInstancia() {
        instancia = null;
    }
    
    
    @Override
    public PessoaJuridica getById(Long id) {
        PessoaJuridica pessoaJuridica = null;
		try{
			pessoaJuridica = entityManager.find(PessoaJuridica.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta de Pessoa Juridica: "+e);
		}
		return pessoaJuridica; 
    }

    @Override
    public boolean removeById(Long id) {
        PessoaJuridica pessoaJuridica = null;
                try{
                    pessoaJuridica = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(pessoaJuridica);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão de Pessoa Juridica: "+e);
                }
		return false;
    }

    @Override
    public List<PessoaJuridica> getAll() {
        return entityManager.createQuery("FROM PessoaJuridica").getResultList();
    }
    
    public  List<PessoaJuridica> getPorCNPJ(String cnpj){
         return entityManager.createQuery("FROM Pessoa WHERE cnpj = '"+cnpj+"'").getResultList();
    }
    
    public List<PessoaJuridica> getAtivos(){
        return entityManager.createQuery("FROM PessoaJuridica p WHERE p.ativo = 1").getResultList();
    }
}
