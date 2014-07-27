package JuegoJS;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergi
 */
public class Turno {


public  static boolean turnoUSA = true ;
public static ArrayList<Jugador> jugadores=new ArrayList<>();
  

    static void registrarJugador(Jugador jugador) {
    jugadores.add(jugador);
    }

    public static synchronized void cambiarTurno() {
    for(int i=0;i<jugadores.size();i++)
    {
        Jugador jugador=jugadores.get(i);
        jugador.cambiarTurno();
    }
    }

    static void despertarOtroThread(Jugador j) {
        for(int i=0;i<jugadores.size();i++)
        {
            Jugador jugador=jugadores.get(i);
            if(j.equals(jugador))
            {
                //Do nothing
            }
            else
            {
                jugador.despertar();
            }
        }
    }

    

   

}