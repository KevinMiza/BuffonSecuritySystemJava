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
public class VisitaDAO implements ConsultasUsuarioDAO{


    @Override
    public String getName(VisitaVO v) {
        BaseDeDatos c = new BaseDeDatos();
        String nombre =  "";
        String apellido = "";
        
        String nombreCompleto ="";
        
        VisitaVO nVo = new VisitaVO();
        
        try{
            c.conectar();
            
            ResultSet rs = c.consulta_obtener("SELECT nombre_visitante, apellido_visitante "
                    + "FROM tbltoken WHERE id_tbltoken='"+v.getToken()+"';");
            
            while(rs.next()){
                nVo.setNombre(rs.getString(1));
                nVo.setApellido(rs.getString(2));
                v.setApellido(rs.getString(2));
                v.setNombre(rs.getString(1));
            }
            nombre = nVo.getNombre();
            apellido = nVo.getApellido();
            v.setApellido(apellido);
            v.setNombre(nombre);
            nombreCompleto = nombre+apellido;
            return nombreCompleto;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return nombreCompleto;
    }

    @Override
    public long getDPI(VisitaVO v) {
        BaseDeDatos c = new BaseDeDatos();
        VisitaVO nVO = new VisitaVO();
        long dpi = 0;
        
        try {
            c.conectar();
            ResultSet rs = c.consulta_obtener("SELECT dpi "
                    + "FROM tbltoken WHERE id_tbltoken='"+v.getToken()+"';");
            while(rs.next()){
                nVO.setDPI(rs.getLong(1));
                v.setDPI(rs.getLong(1));
            }
            dpi = nVO.getDPI();
            v.setDPI(dpi);
            return dpi;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return dpi;
    }
    
    
}
