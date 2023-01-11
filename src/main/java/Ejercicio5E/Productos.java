/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package Ejercicio5E;

/**
 *
 * @author pablo
 */
public record Productos(String nombre,double precio,int cantidad,double iva) {
    //Con el Java record, se crea automaticamente los get setter y todo lo relacionado con las clases automaticamente
    //Como dice el enunciado del ejercicio, los datos que se va a contener el Producto, lo metemos en el parametro
}
