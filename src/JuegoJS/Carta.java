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
   //instance variables
    int id;
    String Descripcion;
    int DmgAire,DmgLigero,DmgBlindado;
    int Def;
    int vida;
    enum TipoCarta{blindado,ligero,aire};
    TipoCarta estaCarta;

   //constructor
   Carta(int i){
      switch(i)
      {
          case 0:
              
              this.estaCarta=TipoCarta.ligero;
              this.id=0;
              this.Descripcion="soldado usa";
              this.DmgAire=2;
              this.DmgLigero=5;
              this.DmgBlindado=2;
              this.vida=10;
              break;
              
          case 1:
              this.estaCarta=TipoCarta.ligero;
              this.id=1;
              this.Descripcion="mortero M224 60mm";
              this.DmgAire=0;
              this.DmgLigero=8;
              this.DmgBlindado=3;
              this.vida=6;
              break;
              
          case 2:
              this.estaCarta=TipoCarta.blindado;
              this.id=2;
              this.Descripcion="M1 Abrams";
              this.DmgAire=0;
              this.DmgLigero=8;
              this.DmgBlindado=3;
              this.vida=12;
              break;
     
      
          case 3:
              this.estaCarta=TipoCarta.aire;
              this.id=3;
              this.Descripcion="UH-60 black hawk";
              this.DmgAire=2;
              this.DmgLigero=8;
              this.DmgBlindado=2;
              this.vida=5;
              break;
            
              
          case 4:
              
              this.estaCarta=TipoCarta.ligero;
              this.id=4;
              this.Descripcion="Mujahideen";
              this.DmgAire=6;
              this.DmgLigero=3;
              this.DmgBlindado=4;
              this.vida=6;
              break;
             
              
          case 5:
              
              this.estaCarta=TipoCarta.ligero;
              this.id=5;
              this.Descripcion="Mujahideen";
              this.DmgAire=6;
              this.DmgLigero=3;
              this.DmgBlindado=4;
              this.vida=6;
              break;
              
               case 6:
              
              this.estaCarta=TipoCarta.blindado;
              this.id=6;
              this.Descripcion="T9-0";
              this.DmgAire=2;
              this.DmgLigero=7;
              this.DmgBlindado=8;
              this.vida=10;
              break;
                   
                   
             case 7:
              
              this.estaCarta=TipoCarta.aire;
              this.id=7;
              this.Descripcion="Su-25";
              this.DmgAire=8;
              this.DmgLigero=5;
              this.DmgBlindado=7;
              this.vida=7;
              break;
                 
                 
             case 8:
              
              this.estaCarta=TipoCarta.ligero;
              this.id=8;
              this.Descripcion="RPG-7";
              this.DmgAire=5;
              this.DmgLigero=3;
              this.DmgBlindado=8;
              this.vida=4;
              break;
      }
      
      
      
}
   
}
