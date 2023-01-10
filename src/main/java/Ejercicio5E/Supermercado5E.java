/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Ejercicio5E;

import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class Supermercado5E {

    public static void main(String[] args) {
        Caja caja = new Caja(new Cinta());
        int opcion;
        String menu = "SUPERMERCADOS PABLOSKI(Caja numero 1)";

        do {
            opcion = JOptionPane.showOptionDialog(null, "",
                    menu, JOptionPane.YES_NO_CANCEL_OPTION,//Botones en los menus
                    -1, null,// null para icono por defecto.
                    new Object[]{"Pasar producto", "Quitar producto", "Productos en cinta", "Generar ticket de compra", "Salir"}, 0);

            switch (opcion) {
                case 0 -> {
                    caja.pasarProducto();
                }
                case 1 -> {
                    caja.eliminarProducto();
                }
                case 2 -> {
                    caja.mostrarProductos();
                }
                case 3 -> {
                    if (caja.getCinta().esVacia()) {
                        JOptionPane.showMessageDialog(null, "No se puede crear un ticket"
                                + " si la cinta esta vacia");
                        opcion = 5;
                    } else {
                        JOptionPane.showMessageDialog(null, generarTicket(caja));
                    }
                }

            }

        } while (opcion != 3 && opcion != 4);

    }

    //Generamos un ticket con una caja en concreto
    public static Ticket generarTicket(Caja c) {

        return c.generarTicket();

    }
}

