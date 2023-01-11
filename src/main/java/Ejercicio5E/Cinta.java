/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5E;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Cinta {
   
    private ArrayList<Productos> cinta;//Arraylist que contiene los productos de la cinta
    //Se llama al la clase de Productos

    public Cinta() {

        this.cinta = new ArrayList<>();//Constructor con la cinta con un ArrayList, que es un arrayList

    }

    //Metodo que devuelve una cinta
    public ArrayList<Productos> getCinta() {
        return cinta;
    }

    //Metodo para añadir un objeto de tipo producto y lo metemos en la list ade la cinta
    public void anadirProducto(Productos p) {
        cinta.add(p);

    }

    //Metodo Eliminar un produco de la lista
    public void eliminarProducto(Productos p) {

        cinta.remove(p);
    }

    //Metodo que Vacia la cinta si tiene 0 productos
    public boolean esVacia() {

        return cinta.isEmpty(); // Se puede poner ==0 pero segun java, podemos usar isEmpty
    }

    //Metodo que va a salir en el toString del ticket, que usara lso
    //datos que cada producto que pasemos por la cinta
    public String generarListaDeProductosTicket() {
        DecimalFormat df = new DecimalFormat("#.00");
        String lista = "";
        //Usando el decimal format para limitar los digitos
        //foreach que le pasa los productos a la cinta
        for (Productos p : cinta) {

            lista += p.nombre() + "                          "
                    + p.precio() + "                 "
                    + p.cantidad() + "           "
                    + p.iva() + "%" + "            "
                    + df.format(p.precio() * p.cantidad() ) + "\n";

        }

        return lista;
    }

    //Genera el segundo String del ticket en el que aparece el el todo lo relacionado con los precios
    // con los producto divididor por iva y el precio total al pagar
    public String generarStringTotal() {
        DecimalFormat df = new DecimalFormat("#.00");//Limitar los decimales con decimalFormat
      
        int contador4 = 0;//Contador productos de iva 4
        int contador10 = 0;//Contador productos de iva 10
        int contador21 = 0;//Contador productos de iva 21

        double precio4 = 0; //Precio de los productos iva 4 
        double precio10 = 0;//Precio de los productos iva 10
        double precio21 = 0;//Precio de los productos iva 21

        String datos4 = ""; //Datos de los productos de iva 4
        String datos10 = "";//Datos de los productos de iva 10
        String datos21 = "";//Datos de los productos de iva 21

        String precioAPagar = "  "; //Precio a pagar sin el IVA

        String total = ""; //Precio a pagar con todo el IVA

        for (Productos producto : cinta) {

            // Metemos 3 condiciones que son los 3 tipos de iva y seran contadores
            // Con sus respectivos calculos de precios
            if (producto.iva() == 4) {
                contador4 += producto.cantidad();//Contador de los productos 
                precio4 += producto.precio() * producto.cantidad();//Suma de precios
            }

            if (producto.iva() == 10) {
                contador10 += producto.cantidad();//Contador de los productos 
                precio10 += producto.precio() * producto.cantidad();//Suma de precios
            }

            if (producto.iva() == 21) {
                contador21 += producto.cantidad();//Contador de los productos 
                precio21 += producto.precio() * producto.cantidad();//Suma de precios
            }
        }
        //Se imprime la informacion, los String con los contadores y se le pone al lado el precio del procuto
        //Sin iva y luego el Producto con IVA, sigue el ejemplo del ejercicio
        
        datos4 = "Nºproducto. iva4%: " + contador4 + "             Precio sin IVA: " + df.format(precio4) + "           Precio con IVA: " + (precio4 + (precio4 * 0.04));
        datos10 = "Nºproducto. iva10%: " + contador10 + "          Precio sin IVA: " + df.format(precio10) + "          Precio con IVA: " + (precio10 + (precio10 * 0.1));
        datos21 = "Nºproducto. iva21%: " + contador21 + "          Precio sin IVA: " + df.format(precio21) + "          Precio con IVA: " + (precio21 + (precio21 * 0.21));

        precioAPagar = "##########################################################################################\n"
                + "Total a pagar: " + ((precio4 + (precio4 * 0.04)) + (precio10 + (precio10 * 0.1)) + (precio21 + (precio21 * 0.21)) + "  --  Gracias por su visita\n")
                + "###############################################################################################";
        total = datos4 + "\n" + datos10 + "\n" + datos21 + "\n" + precioAPagar;

        return total;

    }
    //ToString
    //Llamo al toString de la cinta 
    @Override
    public String toString() {
        return "Cinta{" + "cinta=" + cinta + '}';
    }
    
    
    
}
