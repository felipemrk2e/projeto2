package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<E> {
	
	protected static EntityManager entityManager = DAO.getEntityManager();
	

	public DAO() {
            //entityManager = getEntityManager(); 
	}

	private static EntityManager getEntityManager () {
		
            EntityManager entityManager = DAO.getEntityManager();
		
            if (entityManager == null){
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoPU");   
		entityManager = factory.createEntityManager();
            }
		
            return entityManager;
			
	}
	
	public boolean persist (E object) {
            boolean result = true;
	
            try {
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
            } catch (Exception e) {
		e.printStackTrace();
		entityManager.getTransaction().rollback();
		result = false;
            }finally {
                entityManager.close();
            }
		
            return result;
	}
	
	public boolean merge(E object) {
    	
            boolean result = true;

            try {
                entityManager.getTransaction().begin();
                entityManager.merge(object);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                entityManager.getTransaction().rollback();
                result = false;
            }finally {
                entityManager.close();
            }

            return result;
        }
 
    public boolean remove(E object) {
    	
    	boolean result = true;
    	
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(object);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            result = false;
        }finally {
            entityManager.close();
        }
        
        return result;
    }
    
    /**
    *  Verifica se a sessão está fechada.
    *  @return boolean
    */
    public boolean isClosed(){
        if(this.entityManager.isOpen())
            return false;
        return true;
    }
    
    public abstract E getById(final Long id);
    
    public abstract boolean removeById(final Long id);
    
    public abstract List<E> getAll();

}
