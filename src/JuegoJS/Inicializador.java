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
public class Inicializador {
    static int USA=0;
    static int INSURGENT=1;
    static Jugador jugadorA,jugadorB;
    static Partida enJuego;
    public static void main(String[] argumentos)
    {
        jugadorA=new Jugador(USA,"USA");
        jugadorB=new Jugador(INSURGENT,"INSURGENTE");
        enJuego=new Partida(jugadorA, jugadorB);
        empezarPartida(enJuego);
    }

    private static void empezarPartida(Partida enJuego) 
    {   
        int random = (int)(Math.random()*2+1);
        Turno t=new Turno(random);
    }
    public static ArrayList<Jugador> getJugadores()
    {
        ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
        jugadores.add(jugadorA);
        jugadores.add(jugadorB);
        return jugadores;
    }
}
