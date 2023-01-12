/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio5E;

/**
 *
 * @author pablo
 */
public class SupermercadoConComandos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Caja caja1 = new Caja(new Cinta());
        
        Cinta cinta1= new Cinta();
        
         //Metodo Manual
        //Creacion de productos directamente sin JOption
        Productos fanta = new Productos("fanta", 1.5, 1, 21);
        Productos cola = new Productos("cola", 1.80, 1, 21);
        Productos patatas = new Productos("patatas", 5, 1, 21);
        Productos pescado = new Productos("Pez espada", 4.50, 1, 10);
        //Introduccion de datos 
        cinta1.anadirProducto(fanta);
        
        cinta1.anadirProducto(fanta);
        
        caja1.generarTicket();
        
        System.out.println(caja1.generarTicket());
        
    }
    
}
