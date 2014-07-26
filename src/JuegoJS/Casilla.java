/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

/**
 *
 * @author sergi
 */
class Casilla {
    private tipoCasilla tipoCasilla;
    enum tipoCasilla{carta,hueco,trampa,bonificador};
    
    Casilla()
    {
        this.tipoCasilla=tipoCasilla.hueco;
    }
    tipoCasilla getTipoCasilla()
    {
        return this.tipoCasilla;
    }
}
