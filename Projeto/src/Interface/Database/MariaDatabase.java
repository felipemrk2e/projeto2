package Interface.CadImovel.conexao;

import java.sql.*;

public class MariaDatabase implements Database {
    private String username;
    private String password;
    private String databaseName;
    private String host;
    private int port;
    
    private Connection connection;
    
    public MariaDatabase(String username, String password, String databaseName, String host, int port){
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        this.host = host;
        this.port = port;
    }
    
    public boolean connect(){
        boolean result = true;
        
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            
            if(connection != null)
                connection.close();
            
            this.connection = DriverManager.getConnection("jdbc:mariabd://" + this.host + ":" + port + "/" + this.databaseName, this.username, this.password);
           
        }
        catch(Exception e){
            result = false;
            e.printStackTrace();
        }
        return result;
    }
    
    public ResultSet query(String sql){
        ResultSet result = null;
        
        try{
            if(connection != null && !connection.isClosed()){
                PreparedStatement statement = this.connection.prepareStatement(sql);
                result = statement.executeQuery();
            }
            else{
                throw new Exception("Banco de dados não conectado");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean disconnect(){
        boolean result = false;
        
        try{
            if(this.connection != null && !this.connection.isClosed()){
                this.connection.close();
                result = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public boolean insert(String sql) {
        return false;
    }
    public boolean update(String sql) {
	return false;
    }
    public boolean delete(String sql) {
        return false;
    }
    
}
