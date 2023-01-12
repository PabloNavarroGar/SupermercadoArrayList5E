/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5E;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

/**
 *
 * @author pablo
 */
public class Ticket {
    //Para generar el ticket, necesito la Cinta.
   
    private LocalDateTime fecha;
    private Cinta cinta;
    //Contrusctor que metemos el objeto cinta en el parametro
    public Ticket(Cinta cinta) {
        this.fecha = LocalDateTime.now();
        this.cinta = cinta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Cinta getCinta() {
        return cinta;
    }

    
    //toString modificado para que nos salga el ticket como queremos
    //Como pide el enunciado, aqui sale el modelo del ticket que quiere se se muestre cuando se imprime en la compra
    @Override
    public String toString() {
        return "####################################################################################################\n"+
               "                                    Supermercado Pabloski Hacendaño Diass                                           \n"+
               "####################################################################################################\n"+
               "Fecha: "+fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear()+""
                + "              Hora: "+fecha.getHour()+":"+fecha.getMinute()+"\n"+
               "####################################################################################################\n"+
                "Producto           Precio            Cantidad            IVA           Precio sin IVA\n"+
               "####################################################################################################\n"+
                cinta.generarListaDeProductosDelTicket()+//Lo genera la Cinta, genera la lista de los productos que han pasado 
               "####################################################################################################\n"+
                cinta.generarStringTotal();//Genera el resto del string que tiene todo los contadores, precios con iva sin iva y suma total
              
    }
    
}
