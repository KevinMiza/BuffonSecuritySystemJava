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
public interface ConsultasDAO {
    
    public boolean validarExiste(UsuarioVO u);
    public int validarEstado(UsuarioVO u);
    public void insertarUsuario(UsuarioVO u);
    
    public String obtenerNombre(UsuarioVO u);
  //  public String obtenerApellido(UsuarioVO u);
   // public String obtenerID(UsuarioVO u);
    //public String obtenerPassword(UsuarioVO u);
    //public String obtenerUsuario(UsuarioVO u);
    
    public void Eliminar(UsuarioVO v);
    public void modificar();
    
}
