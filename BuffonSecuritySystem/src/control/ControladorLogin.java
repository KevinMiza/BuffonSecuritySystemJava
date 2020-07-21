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
import vista.menuLogin;

/**
 *
 * @author kamiz
 */
public class ControladorLogin implements ActionListener{

     menuLogin lg = new menuLogin();
     UsuarioVO uvo = new UsuarioVO();
     UsuarioDAO udao = new UsuarioDAO();
            
    public ControladorLogin(menuLogin lg, UsuarioVO uvo, UsuarioDAO udao){
        this.lg = lg;
        this.uvo=uvo;
        this.udao=udao;
        this.lg.jbtnLogin.addActionListener(this);
    }
    
    
    
    private void validarAcceso(){
        int vista =0;
        int estado = 2;
        this.uvo.setUsuario(this.lg.jtxtUsername.getText());
        this.uvo.setPassw(this.lg.jtxtPassword.getText());
        estado = this.udao.validarEstado(uvo);
        
        if(this.udao.validarExiste(uvo)){
            if(estado==1){
                System.out.println("Bienvenido, su usuario esta activo");
            }else{
                System.out.println("Su usuario no  esta activo");
            }
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==lg.jbtnLogin){
           this.validarAcceso();
       }
    }
    
}
