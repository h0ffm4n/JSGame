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
    enum tipoVehiculo{blindado,ligero,aire};
    tipoVehiculo esteVehiculo=tipoVehiculo.ligero;
    public void ejemplo()
    {
    System.out.println(esteVehiculo.name());
            }
}
