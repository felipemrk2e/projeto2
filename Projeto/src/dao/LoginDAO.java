/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.pessoa.Login;
import java.util.List;

/**
 *
 * @author Sala
 */
public class LoginDAO extends DAO<Login> {

    @Override
    public Login getById(Long id) {
        Login login = null;
		try{
			login = entityManager.find(Login.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta de Login: "+e);
		}
		return login;  
    }

    @Override
    public boolean removeById(Long id) {
       Login login = null;
                try{
                    login = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(login);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão de Login: "+e);
                }
		return false;
    }

    @Override
    public List<Login> getAll() {
        return entityManager.createQuery("FROM Login").getResultList();
    }
    
    public List<Login> getAcesso(String nomeUsuario) {
        return entityManager.createQuery("FROM Login WHERE nomeUsuario ='"+nomeUsuario+"'").getResultList();
    }
    
}
