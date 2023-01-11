/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5E;

import java.text.DecimalFormat;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class Caja {
    //Atributos
    private int codigoIdentificador;//Id del producto
    private Cinta cinta; //Llamo a la cinta, que se tiene que crear previamente a la Caja

    private static int id = 0;//Contador de la caja 
    //En el constructor le creo la cinta, ademas de pones el objetocinta como atributo
    public Caja(Cinta cinta) {
        this.codigoIdentificador = id++;
        this.cinta = cinta;
    }

    public int getIdentificador() {
        return codigoIdentificador;
    }

    public void setIdentificador(int identificador) {
        this.codigoIdentificador = identificador;
    }

    public Cinta getCinta() {
        return cinta;
    }

    public void setCinta(Cinta cinta) {
        this.cinta = cinta;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Caja.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.codigoIdentificador;
        hash = 79 * hash + Objects.hashCode(this.cinta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Caja other = (Caja) obj;
        if (this.codigoIdentificador != other.codigoIdentificador) {
            return false;
        }
        return Objects.equals(this.cinta, other.cinta);
    }

    @Override
    public String toString() {
        return "Caja{" + "identificador=" + codigoIdentificador + ", cinta=" + cinta + '}';
    }

    //Metodo que crea ticket con los productos que contiene la cinta de la caja
    //Se necesita la clase Ticket, creado previamente
    public Ticket generarTicket() {

        Ticket t = new Ticket(this.cinta);

        return t;
    }

    //Metodo para pasar un Producto o Volver atras
    public void pasarUnProducto() {
        int opcion;//Creo una opcion que sea el JOption pane
        
        opcion = JOptionPane.showOptionDialog(null, "           Nuevo Producto",
                "Selector de la  cinta", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Introducir datos", "Volver"}, 0);
        if (opcion == 0) {
            cinta.anadirProducto(crearUnProducto());//Con el array generado arriba,
            //Si introducir datos es el indice 0. le metemos el metodo de la cinta de añadir un producto
        } else {
            opcion = JOptionPane.CANCEL_OPTION;//No selecciono la otra opcion, se cancela la opcion
        }

    }

    //Metodo que nos permite crear un producto desde cero para poder añadirlo a la cinta
    //Usa la clade Productos
    public Productos crearUnProducto() {
        
        String nombre;//Nombre del producto
        int cantidad;//cantidad que vamos a meter
        double precio;// precio, en decimales
        Iva iva;//El iva que se le llama a la clase que hemos creado

        int opcion;
        //Bucle con condicion que introduce cada parte del producto
        do {
            nombre = UtilidadesMetodos.pedirString("Introduzca el nombre del producto");
            if (nombre == null || nombre.equalsIgnoreCase("")) {
                nombre = "";
                //Si le meto un producto sin ningun nombre, no la a dejar pasar
                JOptionPane.showMessageDialog(null, "No se puede crear un producto sin nombre");
            }

        } while ("".equals(nombre));//metemos las comillas que simbolizan que he introducido nigun valor y se volvera a repetir el bucle

        do {
            precio = UtilidadesMetodos.filtrarNumeroDecimalJOptionPane("Introduzca el precio del producto");
            if (precio == 0) {
                JOptionPane.showMessageDialog(null, "El precio no puede ser 0, vuelva a intentarlo");
            }
        } while (precio == 0);//Se va a repetir si le meto valor 0

        do {
            cantidad = UtilidadesMetodos.filtrarNumeroEnteroJOptionPane("¿Cuantas unidades hay en total?");
            if (cantidad == 0) {
                JOptionPane.showMessageDialog(null, "La cantidad no puede ser 0, vuelva a intentarlo");
            }
        } while (cantidad == 0); //Se repetira si el valor es 0
        opcion = JOptionPane.showOptionDialog(null, "Seleccione tipo de Iva",
                "Selector de IVA", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,//Null para que salga un boton predeterminado
                new Object[]{"4%", "10%", "21%"}, 0);//Vuelvo a hacer otra ventana con los 3 ivas seleccionados
         //Si la opcion es el indice 0, el iva sera 4, porque llamo al la clase Iva
         //Y asi sucesivamente si es la opcion
        if (opcion == 0) {
            iva = Iva.CUATRO;
        } else if (opcion == 1) {
            iva = Iva.DIEZ;
        } else {
            iva = Iva.VEINTIUNO;
        }
        // se devuelve de la clase productos con el parametro con sus atributos
        return new Productos(nombre, precio, cantidad, iva.getIva());
    }

    //Metodo que elimina el producto introduciendo su nombre que este en la cinta
    public void eliminarUnProducto() {
        String nombre = "";
        //Primera condicion que metemos es si la cinta esta vacia, sale un mensaje
        //Si no , entramos en un bucle con condicion de que si le metemos un 
        //nombre que no existe de los productos hechos, volvera a pedirlo
        if (cinta.esVacia()) {
            JOptionPane.showMessageDialog(null, "La cinta esta vacia"
                    + " no se puede quitar ningun producto de ella");
        } else {
            do {

                nombre = JOptionPane.showInputDialog("Escribe el nombre del producto "
                        + " para quitarlo de la cinta\n\n" + listaProductos());//Sale los productos que hemos creado
                //El metodo esta  mas abajo
                if (nombre == null) {
                    nombre = "";
                }

            } while (!comprobarUnNombre(nombre) || nombre.equals(""));
            
        }
    }

    //Comprobamos que si el nombre que ponemos en eliminarProducto esta en nuestra cinta, osea que existe,
    // eliminamos el producto que sea igual con el nombre pasado por parametro
    public boolean comprobarUnNombre(String n) {

        boolean existe = false;
        for (Productos p : cinta.getCinta()) {
            if (n.equalsIgnoreCase(p.nombre())) {
                existe = true;
                cinta.eliminarProducto(p);
                break;
            }

        }
        if (existe == false) {
            JOptionPane.showMessageDialog(null, "No existe ese producto en la cinta"
                    + " vuelva a repetir");
        }

        return existe;
    }

    //Devuelve la lista de productos en cinta
    public String listaProductos() {
       
        String texto = "";
        //Si la cinta esta vacia
        if (cinta.esVacia()) {
            texto = "No hay productos en la cinta";
        } else {
            //For each, el cual se le pasan los productos a la cinta
            for (Productos p : cinta.getCinta()) {
                texto += p.toString() + "\n";//To string que con el for, pne cada producto
            }
        }
        return texto;

    }

    //Mostramos por ventana la lista de productos que tiene la cinta actualmente
    public void mostrarProductos() {
     //Una vez creado el metodo de listaProductos, lo introduzco en el mensaje del JOPTION pane para que se muestte
     //Con un boton solo de volver
        int opcion;
        opcion = JOptionPane.showOptionDialog(null, listaProductos(),
                "Productos en cinta\n", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Volver"}, 0);

    }
}
