/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author kamiz
 */
public class BaseDeDatos { 
    
    private String driver = "com.mysql.jdbc.Driver";
    private String  servidor     = "localhost";
    private String  usuario     = "root";
    private String  password       = "";
    private String db = "bd_buffon";
    private String cadena;
    
    //Declaracion del objeto que permite conectarnos.
    Connection con;
    
    //Declaracion del objeto que permite interactuar con codigo SQL
    Statement st;
    
    public void conectar(){
        this.cadena = "jdbc:mysql://"+this.servidor+"/"+this.db;
        
        try{
            Class.forName(this.driver).newInstance();
            this.con=DriverManager.getConnection(this.cadena,this.usuario,this.password);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    
    public int consulta_multi (String consulta){
        int resultado;
        try{
            this.conectar();
            this.st = con.createStatement();
            
            resultado = this.st.executeUpdate(consulta);
        } catch(Exception e){
            System.err.println(e);
            return 0;
        }
        return resultado;
    }
    
    public ResultSet consulta_obtener (String consulta){
        try{
            this.conectar();
            ResultSet respuesta = null;
            this.st = this.con.createStatement();
            respuesta = st.executeQuery(consulta);
            return respuesta;
            
        }catch(Exception e){
            System.err.println(e);
        }
        return null;
    }
    
    public void desconectar(){
        try {
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
