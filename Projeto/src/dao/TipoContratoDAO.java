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
        try {
            tipoContrato = entityManager.find(TipoContrato.class, id);
        } catch (Exception e) {
            System.out.println("Erro na consulta do tipoContrato: " + e);
        } finally {
            entityManager.close();
        }
        return tipoContrato;
    }

    @Override
    public boolean removeById(Long id) {
        TipoContrato tipoContrato = null;
        boolean flag = true;
        try {
            tipoContrato = this.getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(tipoContrato);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            flag = false;
            System.out.println("Erro na exclusão do TipoContrato: " + e);
        } finally {
            entityManager.close();
        }
        return flag;
    }

    @Override
    public List<TipoContrato> getAll() {
        List<TipoContrato> tiposContratos = entityManager.createQuery("FROM TipoContrato").getResultList();
        entityManager.close();
        return tiposContratos;
    }
    
}
