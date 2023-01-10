/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5E;

import java.time.LocalDateTime;

/**
 *
 * @author samue
 */
public class Ticket {
    
    private LocalDateTime fecha;
    private Cinta cinta;

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

    
    //toString modificado para que nos salga el ticket como queramos
    //Como pide el enunciado, aqui sale el modelo del ticket que quiere que generemos
    @Override
    public String toString() {
        return "---------------------------------------------------------------------------------------------------\n"+
               "                                    SuperMercado Pabloski                                            \n"+
               "---------------------------------------------------------------------------------------------------\n"+
               "Fecha: "+fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear()+""
                + "              Hora: "+fecha.getHour()+":"+fecha.getMinute()+"\n"+
               "---------------------------------------------------------------------------------------------------\n"+
                "Producto           Precio            Cantidad            IVA           Precio sin IVA\n"+
               "---------------------------------------------------------------------------------------------------\n"+
                cinta.generarListaDeProductosTicket()+
               "---------------------------------------------------------------------------------------------------\n"+
                cinta.generarStringTotal();
              
    }
    
}
