/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Ejercicio5E;

/**
 *
 * @author samue
 */
public enum Iva {
    //Creo un enum para que tenga las caracteristicas de un objeto de por si
    
    CUATRO(4),DIEZ(10),VEINTIUNO(21);
    
    private double iva;
    
    private Iva(double iva){
        this.iva=iva;
    }//esto hace que lo que hemos hecho antes, lo reconozca como double,
    //Llamo al objetivo y en el argumente le meto la variable con el atributo
    //y lo igualo
    public double getIva(){
        
        return iva;
    }
    //Metodo sencillo para pedir el iva
}
