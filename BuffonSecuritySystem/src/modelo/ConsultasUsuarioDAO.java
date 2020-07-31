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
public interface ConsultasUsuarioDAO {
    public String getName(VisitaVO v);
    public long getDPI(VisitaVO v);
    public void validarVisita(VisitaVO v, UsuarioVO u);
}
