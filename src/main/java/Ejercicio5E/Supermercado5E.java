/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Ejercicio5E;

import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class Supermercado5E {

    public static void main(String[] args) {
        Caja caja = new Caja(new Cinta());//Creo una caja y adentro de ella se crea la Cinta, ya que su constructor tiene una cinta
        int opcion;
        String menu = "SUPERMERCADOS PABLOSKI(Caja numero 1)";//Este mensaje se pone en la parte de arriba del JOption Pane

        do {
            opcion = JOptionPane.showOptionDialog(null, 
                    "Viene un cliente con una serie de Productos...",
                    menu,
                    JOptionPane.YES_NO_CANCEL_OPTION,//Botones en los menus
                    1,
                    null,// null para icono por defecto.
                    new Object[]{"Pasar producto", "Mostrar Productos", "Eliminar Producto", "Generar ticket", "Salir del programa"}, 0);
            //Se crea un array con una serie de mensakes, los cuales son 5
            //Creo un Switch que seran las opciones, las cuales son pasar el producto, eliminar un producto, mostar todos los productos
            //y un caso que genera un ticket con la condicion de que si la caja esta vacia salga un mensaje de que no se peude genear un ticket
            //Si no esta vacia, sale un JOption con llamando al ticket de tiene la clase caja
            switch (opcion) {
                case 0 -> {
                    caja.pasarUnProducto();//Llamo al metodo en la clase Caja
                }
                case 1 -> {
                    caja.mostrarProductos();
                }
                case 2 -> {
                    
                    caja.eliminarUnProducto();
                }
                case 3 -> {
                    if (caja.getCinta().estaVacia()) {
                        JOptionPane.showMessageDialog(null, " No puedes crear un ticket"
                                + "con la cinta vacia");
                        opcion = 5;//Meto esta opcion para que se reinicie el bucle, ya que si no lo pongo saldria aunque no generase un ticket
                    } else {
                        JOptionPane.showMessageDialog(null, generarUnTicket(caja));
                    }
                }

            }

        } while (opcion != 3 && opcion != 4);
        //mientras sea la opcion 3 y 4 , se acaba el bucle, en caso de que hayamos pasado productos por la cinta, como hemos puesto arriba
        
        
   
        
        
        
    }

    //Generarar un ticket, llamo al metodo que tiene la caja,
    public static Ticket generarUnTicket(Caja c) {

        return c.generarTicket();

    }
}
