/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
class Turno extends Thread{
    Jugador jugadorEnTurno;
    int turnoInicial;
    private boolean finDePartida;
    Turno(int turnoInicial)
    {
        switch(turnoInicial)
        {
            case 0:
                this.jugadorEnTurno=Inicializador.getJugadores().get(turnoInicial);//Jugador A es el primero en jugar
                break;
            case 1:
                this.jugadorEnTurno=Inicializador.getJugadores().get(turnoInicial);//Jugador B es el primero en jugar
               break;
        }
        this.turnoInicial=turnoInicial;
        this.finDePartida=false;
        this.start();
    }
    @Override
    public void run()
    {
        while(!finDePartida)
        {
        jugadorEnTurno.start();
        try {
            jugadorEnTurno.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Turno.class.getName()).log(Level.SEVERE, null, ex);
        }
        jugadorEnTurno=Inicializador.getJugadores().get(turnoInicial^turnoInicial);
    
        }
    }
    
}
