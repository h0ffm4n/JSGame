/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

import java.util.ArrayList;

/**
 *
 * @author sergi
 */
class Jugador {
    static int MAZOUSA=0;
    static int MAZOINSURGENT=1;
    
    Mazo mazo;//Mazo de Juego
    
    Jugador(int i) 
    {
        switch (i)
        {
            case 0:// Jugador USA
                mazo=new Mazo(MAZOUSA);
                break;
            case 1://Jugador Insurgente
                mazo=new Mazo(MAZOINSURGENT);
                break;
        }
    }

    Cuartel getCuartel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Huecos[] getBonificador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ArrayList<Carta> getCartasMazo() {
       return(mazo.getCartas());
    }
    
}
