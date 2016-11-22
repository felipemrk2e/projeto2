/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.pessoa.Pessoa;

/**
 *
 * @author jeanbrock
 */
public class ConexaoManual {

    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/projetodois";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Conectar ao banco
    public Connection abrir() throws Exception {
        try {
            Class.forName(DRIVER).newInstance();
            Connection conn = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
            return conn;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        } catch (Exception e) {
            System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
            return null;
        }
    }

    public List<Object> consultaQuery(String query) throws SQLException, Exception {

        Connection con = new ConexaoManual().abrir();
        Statement stm = con.createStatement();
        ResultSet resultado = stm.executeQuery(query);
        ResultSetMetaData md = resultado.getMetaData();
        List<Object> listbject = new ArrayList<Object>();

        int columns = md.getColumnCount();
        while (resultado.next()) {
            Object[] row = new Object[columns];
            for (int i = 0; i < columns; i++) {
            }
            listbject.add(row);
        }
        resultado.close();
        con.close();
        stm.close();

        return listbject;
    }

    public List<Map<String, Object>> resultSetToList(String query) throws SQLException, Exception {
        Connection con = new ConexaoManual().abrir();
        Statement stm = con.createStatement();
        ResultSet resultado = stm.executeQuery(query);
        ResultSetMetaData md = resultado.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (resultado.next()) {
            Map<String, Object> row = new HashMap<String, Object>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), resultado.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }

    public <E> E consultaGenerica(Class<E> e, String query) throws Exception {
        Connection con = new ConexaoManual().abrir();
        Statement stm = con.createStatement();
        ResultSet resultado = stm.executeQuery(query);
        List<E> listbject = new ArrayList<E>();

        while (resultado.next()) {
            for (int i = 0; i < resultado.getRow(); i++) {
                listbject.add((E) resultado.getObject(i));
            }

        }

        return e.cast(listbject);
    }

    public List<Pessoa> consultarPessoa(String query) throws Exception {
        Connection con = new ConexaoManual().abrir();
        Statement stm = con.createStatement();
        ResultSet resultado = stm.executeQuery(query);
        List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
         while (resultado.next()) {           
                Pessoa p = new Pessoa();
                p.setNomePessoa(resultado.getString("idPessoa"));
                listaPessoa.add(p);

        }
        
        return listaPessoa;
    }
}
