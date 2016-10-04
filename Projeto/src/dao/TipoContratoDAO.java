/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import imovel.model.TipoContrato;
import java.util.List;

/**
 *
 * @author urielcaire
 */
public class TipoContratoDAO extends DAO<TipoContrato>{

    @Override
    public TipoContrato getById(Long id) {
        TipoContrato tipoContrato = null;
	try{
            tipoContrato = entityManager.find(TipoContrato.class, id);
	}catch(Exception e){
            System.out.println("Erro na consulta do tipoContrato: "+e);
        }
	return tipoContrato;
    }

    @Override
    public boolean removeById(Long id) {
        TipoContrato tipoContrato = null;
        try{
            tipoContrato = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(tipoContrato);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            System.out.println("Erro na exclusão do TipoContrato: "+e);
        }
	return false;
    }

    @Override
    public List<TipoContrato> getAll() {
       return entityManager.createQuery("FROM TipoContrato").getResultList();
    }
    
}
