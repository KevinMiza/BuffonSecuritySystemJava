/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.MenuAdmin;

/**
 *
 * @author kamiz
 */
public class ControladorAdmin implements ActionListener{
    UsuarioDAO ud = new UsuarioDAO();
    MenuAdmin ma = new MenuAdmin();
    UsuarioVO uv = new UsuarioVO();

    public ControladorAdmin(UsuarioDAO ud, MenuAdmin ma, UsuarioVO uv) {
        this.ud = ud;
        this.ma = ma;
        this.uv = uv;
        
        this.ma.jbtnGuardar.addActionListener(this);
        this.ma.jbtnEditar.addActionListener(this);
        this.ma.jbtnBuscar.addActionListener(this);
        this.ma.jbtnBorrar.addActionListener(this);
    }
    
    private void insertar(){
        uv.setNombre(ma.jtxtNombre.getText());
        uv.setApellido(ma.jtxtApellido.getText());
        uv.setUsuario(ma.jtxtUsuario.getText());
        uv.setPassw(ma.jtxtPassw.getText());
        uv.setEstado(ma.jcmboEstadoUsuario.getSelectedIndex());
        uv.setAcceso(ma.jcmboAcceso.getSelectedIndex()+1);
        ud.insertarUsuario(uv);
        
        System.out.println("El estado es: "+uv.getEstado());
        System.out.println("El acceso es : "+uv.getAcceso());
    }
    
    private void cargarUsuario(){
        String name;
        uv.setId(Integer.parseInt(ma.jtxtID.getText()));
        name = ud.obtenerNombre(uv);
        String nombre = uv.getNombre();
        String apellido = uv.getApellido();
        String usuario = uv.getUsuario();
        String passw = uv.getPassw();
        int acceso = uv.getAcceso();
        int estado = uv.getEstado();
        
        ma.jtxtNombre.setText(nombre);
        ma.jtxtApellido.setText(apellido);
        ma.jtxtPassw.setText(passw);
        ma.jtxtUsuario.setText(usuario);
        ma.jcmboAcceso.setSelectedIndex(acceso-1);
        ma.jcmboEstadoUsuario.setSelectedIndex(estado);
    }
    
    private void actualizarUsuario(){
        uv.setId(Integer.parseInt(ma.jtxtID.getText()));
        uv.setNombre(ma.jtxtNombre.getText());
        uv.setApellido(ma.jtxtApellido.getText());
        uv.setUsuario(ma.jtxtUsuario.getText());
        uv.setPassw(ma.jtxtPassw.getText());
        uv.setAcceso(ma.jcmboAcceso.getSelectedIndex()+1);
        uv.setEstado(ma.jcmboEstadoUsuario.getSelectedIndex());
        ud.modificar(uv);
        
        System.out.println(uv.getId());
        System.out.println(uv.getNombre());
        System.out.println(uv.getApellido());
        System.out.println(uv.getUsuario());
        System.out.println(uv.getPassw());
        System.out.println(uv.getEstado());
        System.out.println(uv.getAcceso());
    }
    
    private void eliminarPorID(){
        uv.setId(Integer.parseInt(ma.jtxtID.getText()));
        ud.Eliminar(uv);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ma.jbtnGuardar){
            this.insertar();
        }if(e.getSource() == ma.jbtnBuscar){
            cargarUsuario();
        }if(e.getSource()== ma.jbtnBorrar){
            this.eliminarPorID();
        }if(e.getSource()== ma.jbtnEditar){
            this.actualizarUsuario();
        }
    }
    
}
