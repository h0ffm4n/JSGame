/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
class Jugador extends Thread{
    static int MAZOUSA, CUARTELUSA=0;
    static int MAZOINSURGENT, CUARTELINSURGENT=1;
    boolean test=true;
    boolean turno=false;
    
   
    
    Mazo mazo;//Mazo de Juego Inicial
    
    
    Cuartel cuartel;//Cuartel
    ArrayList<Carta> cartasEnJuego=new ArrayList<>();
    ArrayList<Carta> cartasEnMano=new ArrayList<>();
    private ArrayList<CartaBonificadores> bonificadores=new ArrayList<>();
    private int indexJugador;
    private String nombreJugador;
  
    Jugador(int i,String nombreJugador) 
    {
        switch (i)// por ahora los dos jugadores se crean en base a un indice, posteriormente sera un login
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
                mazo=new Mazo(MAZOUSA);//inicializa su mazo, aqui debe ir un link al parser de XML
                                       //es interesante observar que un jugador podría tener varios mazos
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
        this.indexJugador=i;
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
    {   
        int puerto=5555+indexJugador;
        DataInputStream entradaDatos = null;
        PrintStream salidaDatos = null;
        
        ServerSocket socket=null;
        //Esperamos a que se conecte un cliente
        try {
        socket = new ServerSocket (puerto);
        Socket cliente = socket.accept();
        
        //Inicializamos flujos de lectura y escritura
        InputStream entrada = cliente.getInputStream();
        OutputStream salida = cliente.getOutputStream();
        
        
        //El tipo de datos a aceptar son enteros, o String, o etc,etc
        entradaDatos = new DataInputStream (entrada);
        salidaDatos = new PrintStream (salida);
        
        //Say helo to player
        salidaDatos.println("Hola jugador: "+indexJugador+"\n\r");
        
        } catch (IOException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true)//evita que muera el thread
        {   
            if(salidaDatos!=null)
            {
                
                salidaDatos.println("turno jugador: "+indexJugador);
            }
                synchronized(this) 
                                   
                {
                       while(turno)
                       {
                           try 
                           {
                               esperar();
                           } 
                           catch (InterruptedException ex) 
                           {
                               Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       }

                }     
                
                                   while(true)
                                   {    salidaDatos.println("\033[2J"+"\033[2A");
                                       salidaDatos.println("Es tu turno: \r");
                                        System.out.println("Turno jugador: "+this.nombreJugador);
                                        System.out.println("Introduzca accion: ");
                                        try 
                                        {
                                            String lectura = entradaDatos.readLine();
                                            if(lectura.equals("*"))
                                            {
                                                break;
                                            }
                                            System.out.println("Accion: "+lectura);
                                            
                                        } 
                                            catch (IOException ex) 
                                        {
                                            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        
                                       

                                        
                           
                                   }
                    Turno.despertarOtroThread(this);
                    Turno.cambiarTurno();
                 
    }
    }
   public void esperar() throws InterruptedException
    {
        
                this.wait();
                
    }
    public void despertar()
    {   
        synchronized (this)
        {
            notifyAll();
        }
    }

    void cambiarTurno() {
    if(turno)
    {
        turno=false;
    }
    else
    {
        turno=true;
    }
    }
}
