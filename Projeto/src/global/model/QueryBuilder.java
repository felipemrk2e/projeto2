package global.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QueryBuilder {
	
	protected EntityManager entityManager;
	

	public QueryBuilder() {
		entityManager = getEntityManager(); 
	}

	private EntityManager getEntityManager () {
		
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoPU");
		
            if (entityManager == null)
		entityManager = factory.createEntityManager();
		
            return entityManager;
			
	}
        
        /**
        * Retorna uma lista de Objetos como resultado.
        * A String tableName deve conter unicamente o nome da tabela a consultar
        * @param  tableName o nome da tabela do banco de dados
        * @return      lista de objetos
        */
        public List<Object> getAllFrom(String tableName){
            return entityManager.createQuery("FROM "+tableName).getResultList();
        }
        
        /**
        * Retorna uma lista de Objetos com uma ou mais condições.
        * A String tableName deve conter unicamente o nome da tabela a consultar
        * Enquanto que a String condition deve conter a condicao de pesquisa
        * @param  tableName o nome da tabela do banco de dados
        * @param  condition a condicao de pesquisa (Sem a cláusula WHERE!)
        * @return      lista de objetos
        */
        public List<Object> getFromWhere(String tableName, String condition){
            return entityManager.createQuery("FROM "+tableName+" WHERE "+condition).getResultList();
        }
        
    //Metodo para encerrar 
    public boolean close(){
        boolean close = true;
        try{
            entityManager.close();
        }catch(Exception ex){
            close = false;
        }
        
        return close;
    }

}
