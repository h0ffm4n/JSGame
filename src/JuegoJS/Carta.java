/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

/**
 *
 * @author sergi
 */
class Carta {
   
    int id;
    String Descripcion;
    int Dmg;
    int Def;
     
   Carta(int i){
      switch(i)
      {
          case 0:
              this.id=0;
              this.Descripcion="soldado usa";
              break;
              
          case 1: 
              this.id=1;
              this.Descripcion=""
      }
       
   }
    
    
   
   
    
}
