/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import global.model.Estado;
import java.util.List;

/**
 *
 * @author a1502719
 */
public class EstadoDAO extends DAO<Estado>{

    @Override
    public Estado getById(Long id) {
        Estado estado = null;
	try{
            estado = entityManager.find(Estado.class, id);
	}catch(Exception e){
		System.out.println("Erro na consulta do Estado: "+e);
	} finally {
            entityManager.close();
        }
	return estado;
    }

    @Override
    public boolean removeById(Long id) {
        return false;
    }

    @Override
    public List<Estado> getAll() {
        List<Estado> estados = entityManager.createQuery("FROM Estado").getResultList();
        entityManager.close();
        return estados;
    }
    
}
