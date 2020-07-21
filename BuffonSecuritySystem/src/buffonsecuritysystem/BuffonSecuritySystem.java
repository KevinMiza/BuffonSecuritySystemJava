/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffonsecuritysystem;

import control.ControladorLogin;
import control.controlPrincipal;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import modelo.VisitaDAO;
import modelo.VisitaVO;
import vista.menuLogin;
import vista.menuPrincipal;

/**
 *
 * @author kamiz
 */
public class BuffonSecuritySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Este es un cambio
        UsuarioVO uvo= new UsuarioVO();
        UsuarioDAO ud = new UsuarioDAO();
        menuLogin lg = new menuLogin();
        menuPrincipal mp = new menuPrincipal();
        VisitaDAO vd = new VisitaDAO();
        VisitaVO vv = new VisitaVO();
        
        ControladorLogin clgn = new ControladorLogin(lg,uvo,ud);
        controlPrincipal cpl = new controlPrincipal(mp,vd,vv);
        mp.setVisible(true);
    }
    
}
