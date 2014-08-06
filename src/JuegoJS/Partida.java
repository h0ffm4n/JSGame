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
public class Partida {
    public Jugador jugadorA,jugadorB;
    Casilla[][] tableroCombate=new Casilla[5][4];
    /*
    *   [CA][CA][CA][CA]
    *   [CA][CA][CA][CA]
    *   [TN][TN][TN][TN]
    *   [CB][CB][CB][CB]
    *   [CB][CB][CB][CB]
    */
    Cuartel cuartelA, cuartelB;
    /*
    *       [HQA]
    *    ____________
    *   |            |
    *   |  Tablero   |
    *   |  Combate   |
    *   |____________|
    *   
    *       [HQB]
    */
    Casilla[] bonificadoresA=new Casilla[2];  
    Casilla[] bonificadoresB=new Casilla[2];
    /*
    *   [BA0][HQA][BA1]
    *    ____________
    *   |            |
    *   |  Tablero   |
    *   |  Combate   |
    *   |____________|
    *   
    *   [BB0][HQB][BB1]
    */
    ArrayList<Carta> mazoA=new ArrayList<>();
    ArrayList<Carta> mazoB=new ArrayList<>();
    
    Partida(Jugador jugadorA,Jugador jugadorB)
    {
        this.jugadorA=jugadorA;
        this.jugadorB=jugadorB;
        cuartelA=jugadorA.getCuartel();
        cuartelB=jugadorB.getCuartel();
        mazoA=jugadorA.getCartasMazo();
        mazoB=jugadorB.getCartasMazo();
    }
    
    public Casilla[][] getTablero()
    {
        return tableroCombate;
    }
    
    public Jugador obtenerOtroJugador(Jugador j)
    {
        if(jugadorA.equals(j))
        {
            return jugadorB;
        }
        else
        {
            return jugadorA;
        }
    }
  
}
