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
import vista.menuLogin;
import vista.menuPrincipal;

/**
 *
 * @author kamiz
 */
public class ControladorLogin implements ActionListener{

     menuLogin lg = new menuLogin();
     UsuarioVO uvo = new UsuarioVO();
     UsuarioDAO udao = new UsuarioDAO();
     MenuAdmin ma = new MenuAdmin();
     menuPrincipal mp = new menuPrincipal();
     
            
    public ControladorLogin(menuLogin lg, UsuarioVO uvo, UsuarioDAO udao, MenuAdmin ma, menuPrincipal mp){
        this.ma=ma;
        this.mp=mp;
        this.lg = lg;
        this.uvo=uvo;
        this.udao=udao;
        this.lg.jbtnLogin.addActionListener(this);
    }
    
    
    
    private void validarAcceso(){
        int vista =0;
        int estado = 3;
        this.uvo.setUsuario(this.lg.jtxtUsername.getText());
        this.uvo.setPassw(this.lg.jPassw.getText());
        estado = this.udao.validarEstado(uvo);
        vista= this.udao.validarAcceso(uvo);
        
        
        if(this.udao.validarExiste(uvo)){
            if(estado==1){
                lg.jpaneAcceso.showMessageDialog(null, "Bienvenido");
            if(vista==1){
                this.ma.setVisible(true);
            }if(vista == 2){
                this.mp.setVisible(true);
            }
                
            
            }else{
                lg.jpaneAcceso.showMessageDialog(null,"Usuario o contraseña incorrecta");
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
