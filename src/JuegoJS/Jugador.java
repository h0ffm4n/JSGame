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
    static int MAZOUSA, CUARTELUSA=0;
    static int MAZOINSURGENT, CUARTELINSURGENT=1;
    
    Mazo mazo;//Mazo de Juego Inicial
    
    
    Cuartel cuartel;//Cuartel
    ArrayList<Carta> cartasEnJuego=new ArrayList<>();
    ArrayList<Carta> cartasEnMano=new ArrayList<>();
    
    Jugador(int i) 
    {
        switch (i)
        {
            case 0:// Jugador USA
                cuartel=new Cuartel(CUARTELUSA);
                mazo=new Mazo(MAZOUSA);
                mazo.barajar();
                break;
            case 1://Jugador Insurgente
                cuartel=new Cuartel(CUARTELINSURGENT);
                mazo=new Mazo(MAZOINSURGENT);
                mazo.barajar();
                break;
        }
    }

    Cuartel getCuartel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Casilla[] getBonificador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ArrayList<Carta> getCartasMazo() {
       return(mazo.getCartas());
    }
    
    public Carta jugadorRobarCarta()
    {
        Carta carta=mazo.mazoRobarCarta(mazo);//Roba una carta de este mazo
        return carta;
    }
}
