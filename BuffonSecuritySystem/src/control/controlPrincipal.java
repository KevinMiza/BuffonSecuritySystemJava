/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.VisitaDAO;
import modelo.VisitaVO;
import vista.menuPrincipal;

/**
 *
 * @author kamiz
 */
public class controlPrincipal implements ActionListener{

    

    menuPrincipal mp = new menuPrincipal();
    VisitaDAO vd = new VisitaDAO();
    VisitaVO vv = new VisitaVO();
   
    public controlPrincipal(menuPrincipal mp, VisitaDAO vd, VisitaVO vv) {
        this.mp=mp;
        this.vd=vd;
        this.vv=vv;
        this.mp.jbtnIngresarDatos.addActionListener(this);
    }
    
    private void getNameandDPI(){
      
        this.vv.setToken(this.mp.jtxtCodigoUnico.getText());
        String nombre1 = this.vd.getName(vv);
        long DPI = this.vd.getDPI(vv);
        String nombre= String.valueOf(vv.getNombre());
        String apellido=String.valueOf(vv.getApellido());
        String dpi = String.valueOf(vv.getDPI());
        mp.jtxtNombre.setText(nombre);
        mp.jtxtApellido.setText(apellido);
        mp.jtxtDPI.setText(dpi);
        System.out.println(DPI);
        System.out.println(apellido);
        
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mp.jbtnIngresarDatos){
            this.getNameandDPI();
        }
    }
        
    }



