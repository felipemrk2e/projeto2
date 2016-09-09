package Interface.dao;

import Interface.Database.Database;
import java.util.List;

public abstract class DAO<E> {
    
    protected Database database;
    
    public DAO(Database database){
        this.database = database;
    }
    
    public abstract boolean insert(E object);
    
    public abstract boolean update(E object);
    
    public abstract boolean delete(E object);
    
    public abstract List<E> listAll();
}
