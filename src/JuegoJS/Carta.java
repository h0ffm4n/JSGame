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
    int DmgAire,DmgLight,DmgBlindado;
    int Def;
    int vida;
     
   Carta(int i){
      switch(i)
      {
          case 0:
              this.id=0;
              this.Descripcion="soldado usa";
              this.DmgAire=1;
              this.DmgLight=5;
              this.DmgBlindado=2;
              this.vida=10;
              
          case 1: 
              this.id=1;
              this.Descripcion="mortero M224 60mm";
              this.DmgAire=0;
              this.DmgLight=8;
              this.DmgBlindado=3;
              this.vida=6;
              break;
              
          case 2:
              this.id=2;
              this.tipo
              this.Descripcion="M1 Abrams";
              this.DmgAire=0;
              this.DmgLight=8;
              this.DmgBlindado=3;
              this.vida=12
              break;
      }
      
     
    
   
   
    
}
