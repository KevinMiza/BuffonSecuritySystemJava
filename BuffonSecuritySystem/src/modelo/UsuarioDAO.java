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
    
    
}