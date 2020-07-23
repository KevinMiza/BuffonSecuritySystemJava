/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.BaseDeDatos;
import java.sql.ResultSet;

/**
 *
 * @author kamiz
 */
public class UsuarioDAO implements ConsultasDAO{

    
    
    @Override
    public boolean validarExiste(UsuarioVO u) {
        BaseDeDatos c = new BaseDeDatos();
        
        boolean existe= false;
        
        try{
            c.conectar();
            ResultSet rs = c.consulta_obtener("SELECT * FROM tblempleado WHERE "
                    + "usuario='"+u.getUsuario()+"' and contrasena='"+u.getPassw()
                            +"';");
            if(rs.next()){
                existe=true;
                return existe;
            }else{
                return existe;
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return existe;
    }

    @Override
    public int validarEstado(UsuarioVO u) {
        int activo = 2;
        
        BaseDeDatos c = new BaseDeDatos();
        
        UsuarioVO eVO = new UsuarioVO();
        try{
            c.conectar();
            
            ResultSet rs = c.consulta_obtener("SELECT usuario_activo FROM tblempleado "
                            + "WHERE usuario='"+u.getUsuario()+"' "
                            + "and contrasena='"+u.getPassw()+"';");
            
            while(rs.next()){
                eVO.setAcceso(rs.getInt(1));
            }
            activo = eVO.getAcceso();
            if(activo ==1){
                return activo;
            }else{
                
            }
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return activo;
    }
    
    public void insertarUsuario(UsuarioVO u){
        BaseDeDatos c = new BaseDeDatos();
        
        try {
            c.conectar();
            c.consulta_multi("INSERT INTO tblempleado (nombre, apellido,usuario, contrasena, usuario_activo,"
                    + "fk_acceso) VALUES ('"+u.getNombre()+"','"+u.getApellido()+"','"
                            + u.getUsuario()+"','"+u.getPassw()+"',"+u.getEstado()+","
                                    +u.getAcceso()+ ");");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        c.desconectar(); 
    }

    @Override
    public String obtenerNombre(UsuarioVO u) {
        BaseDeDatos c = new BaseDeDatos();
        String nombre= "";
        String apellido = "";
        String usuario = "";
        String passw = "";
        int acceso =0;
        int activo = 0;
        
        try {
            c.conectar();
            
            ResultSet rs = c.consulta_obtener("SELECT nombre, apellido"
                    + ", usuario, contrasena, usuario_activo, fk_acceso from tblempleado where id_tblempleado="+u.getId());
            
            while(rs.next()){
                u.setNombre(rs.getString(1));
                u.setApellido(rs.getString(2));
                u.setUsuario(rs.getString(3));
                u.setPassw(rs.getString(4));
                u.setEstado(rs.getInt(5));
                u.setAcceso(rs.getInt(6));
            }
            
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return nombre;
    }

    @Override
    public void Eliminar(UsuarioVO v) {
       BaseDeDatos c = new BaseDeDatos();
       
        try {
            c.conectar();
            
            c.consulta_multi("DELETE FROM tblempleado where id_tblempleado="+v.getId());
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public void modificar() {
        
    }

    

}
