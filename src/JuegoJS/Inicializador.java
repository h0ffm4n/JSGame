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
    static boolean test=true;
    static int USA=0;
    static int INSURGENT=1;
    static Jugador jugadorA,jugadorB;
    public static Partida enJuego;
   
    public static void main(String[] argumentos)
    {   
        if(test)
        {
            System.out.println("Jugadores creandose....");
        }
        jugadorA=new Jugador(USA,"USA");
        if(test)
        {
            System.out.println("Jugadores USA creado");
        }
        jugadorB=new Jugador(INSURGENT,"INSURGENTE");
        if(test)
        {
            System.out.println("Jugadores creados");
        }
        enJuego=new Partida(jugadorA, jugadorB);
        if(test)
        {
            System.out.println("Partida creada");
        }
        empezarPartida(enJuego);
    }

    private static void empezarPartida(Partida enJuego) 
    {   
        
        
        
        Turno.registrarJugador(jugadorA);
        
        
        Turno.registrarJugador(jugadorB);
        
        int random = (int)(Math.random()*2);// Devuelve un numero entre 0 y 1 se usara para el numero de jugador
        //(Inicializador.getJugadores().get(random)).cambiarTurno();
        switch(random)
        {
            case 0:jugadorA.cambiarTurno();
                break;
            case 1:jugadorB.cambiarTurno();
                break;
        }
        
        //Esto es lo que inicia en si la interaccion de los jugadores
        jugadorA.start();
        jugadorB.start();
        
    }
   
}
