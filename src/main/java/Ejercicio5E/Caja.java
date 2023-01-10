/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5E;

import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class Caja {
    //Atributos
    private int codigoIdentificador;
    private Cinta cinta;

    private static int id = 0;

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
    //Se necesita la clase Ticket
    public Ticket generarTicket() {

        Ticket t = new Ticket(this.cinta);

        return t;
    }

    //Metodo para pasar un Producto o Volver atras
    public void pasarProducto() {
        int opcion;

        opcion = JOptionPane.showOptionDialog(null, "           Nuevo Producto",
                "Selector cinta", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Introdicir datos", "Atrás"}, 0);
        if (opcion == 0) {
            cinta.anadirProducto(crearProducto());
        } else {
            opcion = JOptionPane.CANCEL_OPTION;
        }

    }

    //Metodo que nos permite crea un producto desde cero para poder añadirlo a la cinta
    //Usa la clade Productos
    public Productos crearProducto() {
        
        String nombre;
        int cantidad;
        double precio;
        Iva iva;

        int opcion;
        //Bucle con condicion que introduce cada parte del producto
        do {
            nombre = UtilidadesMetodos.pedirString("Introduzca el nombre del producto");
            if (nombre == null || nombre.equalsIgnoreCase("")) {
                nombre = "";
                JOptionPane.showMessageDialog(null, "No se puede crear un producto sin nombre");
            }

        } while ("".equals(nombre));

        do {
            precio = UtilidadesMetodos.filtrarNumeroDecimalJOptionPane("Introduzca el precio del producto");
            if (precio == 0) {
                JOptionPane.showMessageDialog(null, "El precio no puede ser 0, vuelva a intentarlo");
            }
        } while (precio == 0);

        do {
            cantidad = UtilidadesMetodos.filtrarNumeroEnteroJOptionPane("¿Cuantas unidades hay en total?");
            if (cantidad == 0) {
                JOptionPane.showMessageDialog(null, "La cantidad no puede ser 0, vuelva a intentarlo");
            }
        } while (cantidad == 0);
        opcion = JOptionPane.showOptionDialog(null, "Seleccione tipo de Iva",
                "Selector de IVA", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,//Null para que salga un boton predeterminado
                new Object[]{"4%", "10%", "21%"}, 0);
                
        if (opcion == 0) {
            iva = Iva.CUATRO;
        } else if (opcion == 1) {
            iva = Iva.DIEZ;
        } else {
            iva = Iva.VEINTIUNO;
        }

        return new Productos(nombre, precio, cantidad, iva.getIva());
    }

    //Metodo que elimina el producto introduciendo su nombre que este en la cinta
    public void eliminarProducto() {
        String nombre = "";

        if (cinta.esVacia()) {
            JOptionPane.showMessageDialog(null, "La cinta esta vacia"
                    + " no se puede quitar ningun producto de ella");
        } else {
            do {

                nombre = JOptionPane.showInputDialog("Escribe el nombre del producto "
                        + " para quitarlo de la cinta\n\n" + listaProductos());
                if (nombre == null) {
                    nombre = "";
                }

            } while (!comprobarNombre(nombre) || nombre.equals(""));
            
        }
    }

    //Comprobamos que si el nombre que ponemos en eliminarProducto esta en nuestra cinta, osea que existe,
    // eliminamos el producto que sea igual con el nombre pasado por parametro
    public boolean comprobarNombre(String n) {

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
        String mensaje = "";
        if (cinta.esVacia()) {
            mensaje = "No hay productos en la cinta";
        } else {
            for (Productos p : cinta.getCinta()) {
                mensaje += p.toString() + "\n";
            }
        }
        return mensaje;

    }

    //Mostramos por ventana la lista de productos que tiene la cinta actualmente
    public void mostrarProductos() {

        int opcion;
        opcion = JOptionPane.showOptionDialog(null, listaProductos(),
                "Productos en cinta\n", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Volver"}, 0);

    }
}
