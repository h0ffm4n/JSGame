/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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
    DataInputStream entradaDatos = null;
    PrintStream salidaDatos = null;
   
    
    Mazo mazo;//Mazo de Juego Inicial
    
    
    Cuartel cuartel;//Cuartel
    ArrayList<Carta> cartasEnJuego=new ArrayList<>();
    ArrayList<Carta> cartasEnMano=new ArrayList<>();
    private ArrayList<CartaBonificadores> bonificadores=new ArrayList<>();
    private int indexJugador;
    private String nombreJugador;
    public String mensajePendiente="";
  
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
                
                salidaDatos.println("turno jugador: "+Turno.obtenerJugadorEnTurno());
            }
                synchronized(this) 
                                   
                {
                       while(turno)
                       {    
                           try 
                           {   
                               if (entradaDatos.available()>0) 
                                {
                                     // Esta asignacion temporal vacia el buffer de entrada, debera comprobar acciones validas
                                     // fuera de turno
                                     String lectura = entradaDatos.readLine();
                                     salidaDatos.println("No es su turno aun");
                                     
                                }
                               if (this.mensajePendiente.length()>0)
                               {    
                                   
                                   salidaDatos.println(mensajePendiente);
                                   this.mensajePendiente="";
                                   
                               }
                              
                               } catch (IOException ex) {
                               Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                           }
                           
                               //El siguiente segmento era el encargado de dormir el Thread, ahora lo que hacemos es contestar
                               /*try
                               {
                               esperar();
                               }
                               catch (InterruptedException ex)
                               {
                               Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                               }*/
                           
                       }

                }     
                
                                   while(true)
                                   {    
                                        
                                        if (mensajePendiente.length()>0)
                                        {    

                                            salidaDatos.println(mensajePendiente);
                                            this.mensajePendiente="";
                                        }
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
                      
                    //Este metodo dormía el Thread, esto ya no sera necesario               
                    /*
                     *Turno.despertarOtroThread(this);
                     */
                    
                    synchronized (this)
                            {
                                //No estory especialmente seguro de que esto evite un RC debido al otro thread
                                (Inicializador.enJuego.obtenerOtroJugador(this)).notificacionAsincrona("Fin de Turno Jugador "+this.indexJugador);
                            }
                    
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

    void cambiarTurno() 
    {
        if(turno)
        {
            turno=false;
        }
        else
        {
            turno=true;
        }
    }

    private void limpiarTerminalANSII(PrintStream salidaDatos) {
    salidaDatos.println("\033[2J"+"\033[2A");
    }
    
    public void notificacionAsincrona(String cadena)
    {
        //recupera el texto del buffer
        this.mensajePendiente=cadena;
        
        
    }
}
