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
public class Inicializador {
    static int USA=0;
    static int INSURGENT=1;
    
    public static void main(String[] argumentos)
    {
        Jugador jugadorA=new Jugador(USA);
        Jugador jugadorB=new Jugador(INSURGENT);
        Partida enJuego=new Partida(jugadorA, jugadorB);
    }
}
