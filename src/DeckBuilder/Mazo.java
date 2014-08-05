/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DeckBuilder;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sergi
 */
public class Mazo {
String nombreMazo="";    
ArrayList<Carta> lasCartasDelMazo=new ArrayList<>();
    

Mazo(int i) {
    
        switch(i)
        {
            case 0://Mazo USA
                for(int k=0;k<3;k++)
                {   
                    System.out.println("Creando carta "+k);
                    lasCartasDelMazo.add(new Carta(k));
                    System.out.println("Creada carta "+k);
                }
                break;
            case 1://Mazo INSURGENT
                for(int k=3;k<6;k++)
                {
                    lasCartasDelMazo.add(new Carta(k));
                }
                break;
        }
    
    }
public void barajar()
{
    Collections.shuffle(lasCartasDelMazo);//Este método solo se llama al comienzo de la partida
}
public ArrayList<Carta> getCartas()
{
    return lasCartasDelMazo;
}

    Carta mazoRobarCarta()//Esto es interesante, ya que el jugador puede tener el mazo y que sea este el restante 
    {   
       Carta carta=this.lasCartasDelMazo.get(0);
       this.lasCartasDelMazo.remove(carta);
       return carta;
    }

    String getNombre() {
    return this.nombreMazo;
    }
    
}
