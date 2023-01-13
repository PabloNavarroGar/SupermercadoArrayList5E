/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio5E;

/**
 *
 * @author pablo
 */
public class SupermercadoConMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Caja caja1 = new Caja(new Cinta());//Creacion de la caja con la cinta incluida

        //Metodo Manual
        //Creacion de productos directamente sin JOption
        Productos fanta = new Productos("Fanta", 1.5, 1, 21);
        Productos cola = new Productos("Cola", 1.80, 1, 21);
        Productos patatas = new Productos("Patatas", 5, 1, 4);
        Productos pescado = new Productos("Pescado", 4.50, 1, 4);
        //Introduccion de productos a la cajas, a traves de la cinta
        caja1.meterProductoEnLaCintaEnCaja(cola);
        caja1.meterProductoEnLaCintaEnCaja(fanta);
        caja1.meterProductoEnLaCintaEnCaja(patatas);
        caja1.meterProductoEnLaCintaEnCaja(pescado);

        System.out.println("Lista de productos llamando al metodo");
        System.out.println(caja1.listaProductos());
        System.out.println("--------------------------------------\n");
        //IMprimimos el Ticket 
        System.out.println(caja1.generarTicket());

        //Probamos el metodo de Eliminar un producto de la cinta
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Comprobamos el metodo Eliminar un producto de la cinta....");
        caja1.ElimiarProductoEnLaCintaEnCaja(cola);

        System.out.println(caja1.generarTicket());
    }

    public static Ticket generarUnTicket(Caja c) {

        return c.generarTicket();

    }
}
