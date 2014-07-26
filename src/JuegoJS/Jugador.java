/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Scanner;

/**
 *
 * @author sergi
 */
class Jugador extends Thread{
    static int MAZOUSA, CUARTELUSA=0;
    static int MAZOINSURGENT, CUARTELINSURGENT=1;
    
    Mazo mazo;//Mazo de Juego Inicial
    
    
    Cuartel cuartel;//Cuartel
    ArrayList<Carta> cartasEnJuego=new ArrayList<>();
    ArrayList<Carta> cartasEnMano=new ArrayList<>();
    private ArrayList<CartaBonificadores> bonificadores=new ArrayList<>();
    private boolean endturn;
    private String nombreJugador;
    
    Jugador(int i,String nombreJugador) 
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
        this.nombreJugador=nombreJugador;
    }

    Cuartel getCuartel() {return this.cuartel;}

    ArrayList<CartaBonificadores> getBonificadores() 
    {
        return bonificadores;
    }

    ArrayList<Carta> getCartasMazo() {
       return(mazo.getCartas());
    }
    
    public Carta jugadorRobarCarta(Mazo mazo)
    {
        Carta carta=mazo.mazoRobarCarta();//Roba una carta de este mazo
        return carta;
    }
    @Override
    public void run()
    {   //Implementacion en consola
        System.out.println("turno de jugador"+this.nombreJugador);
        while(true)
        {
            System.out.println("Introduzca accion:");
            Scanner myScanner=new Scanner(System.in);
            String comando=myScanner.next();
            if(comando.equals("*"))
            {
                System.out.println("Fin de Turno");
            }
            else
            {
                System.out.println("Accion: "+comando);
            }
        }
    }
}
