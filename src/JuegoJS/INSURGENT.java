/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
class INSURGENT extends Thread{
    static int MAZOUSA, CUARTELUSA=0;
    static int MAZOINSURGENT, CUARTELINSURGENT=1;
    static boolean test=true;
   
    
    Mazo mazo;//Mazo de Juego Inicial
    
    
    Cuartel cuartel;//Cuartel
    ArrayList<Carta> cartasEnJuego=new ArrayList<>();
    ArrayList<Carta> cartasEnMano=new ArrayList<>();
    private ArrayList<CartaBonificadores> bonificadores=new ArrayList<>();
    private boolean endturn;
    private String nombreJugador;
    private boolean stopCondition;
    
    INSURGENT(int i,String nombreJugador) 
    {
        switch (i)
        {
            case 0:// Jugador USA
                 if(test)
            {
                System.out.println("Cuartel creandose....");
            }
                cuartel=new Cuartel(CUARTELUSA);
                 if(test)
            {
                System.out.println("Cuartel creado");
            }
            
                        if(test)
            {
                System.out.println("Mazo creandose....");
            }
                mazo=new Mazo(MAZOUSA);
                mazo.barajar();
            {
                System.out.println("Mazo creado");
            }
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
        
     while(true)//evita que muera el thread
     {
         synchronized(this) 
                            {
            while(GlobalClass.turnoUSA)
            {   try {
                this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(INSURGENT.class.getName()).log(Level.SEVERE, null, ex);
                }
}
                            }
         while(true)
         {
             System.out.println("Turno jugador"+this.nombreJugador);
            System.out.println("Introduzca accion");
            Scanner myScanner=new Scanner(System.in);
            String comando=myScanner.next();
            if(comando.equals("*")){
                break;
            }
            System.out.println("Accion");
            System.out.println(comando);
         }
            
            
            
            
            GlobalClass.cambiarturnoUSA(true);
            Inicializador.u.despertar();
            
            
         
    }
    }
    public void esperar() throws InterruptedException
    {
        while(stopCondition)
        {
            wait();
        }
    }
    public void despertar()
    {   
        synchronized (this)
        {
            notifyAll();
        }
    }
}
