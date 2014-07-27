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
    static USA jugadorA,jugadorB;
    static Partida enJuego;
    public static USA u;
    public static INSURGENT i;
    public static void main(String[] argumentos)
    {   
        if(test)
        {
            System.out.println("Jugadores creandose....");
        }
        jugadorA=new USA(USA,"USA");
        if(test)
        {
            System.out.println("Jugadores USA creado");
        }
        jugadorB=new USA(INSURGENT,"INSURGENTE");
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
        int random = (int)(Math.random()*2);// Devuelve un numero entre 0 y 1 se usara para el numero de jugador
        
        
        USA u = new USA(0,"USA");
        INSURGENT i = new INSURGENT(1,"INSURGENT");
        Inicializador.u=u;
        Inicializador.i=i;
        u.start();
        i.start();
        
    }
    public static ArrayList<USA> getJugadores()
    {
        ArrayList<USA> jugadores= new ArrayList<USA>();
        jugadores.add(jugadorA);
        jugadores.add(jugadorB);
        return jugadores;
    }
}
