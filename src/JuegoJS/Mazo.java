/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sergi
 */
class Mazo {
ArrayList<Carta> mazo=new ArrayList<>();
    Mazo(int i) {
    
        switch(i)
        {
            case 0://Mazo USA
                for(int k=0;i<3;k++)
                {
                    mazo.add(new Carta(k));
                }
                break;
            case 1://Mazo INSURGENT
                for(int k=3;k<6;k++)
                {
                    mazo.add(new Carta(k));
                }
                break;
        }
    
    }
public void barajar()
{
    Collections.shuffle(mazo);
}
public ArrayList<Carta> getCartas()
{
    return mazo;
}

    Carta mazoRobarCarta(Mazo mazo) 
    {   
       Carta carta=this.mazo.get(0);
       this.mazo.remove(carta);
       return carta;
    }
    
}
