/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kamiz
 */
public class VisitaVO {
    
    private String nombre;
    private String apellido;
    private String token;
    private long DPI; 
    private int entradasalida;

    public int getEntradasalida() {
        return entradasalida;
    }

    public void setEntradasalida(int entradasalida) {
        this.entradasalida = entradasalida;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDPI() {
        return DPI;
    }

    public void setDPI(long DPI) {
        this.DPI = DPI;
    }

    public VisitaVO() {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DPI = DPI;
    }
    
}
