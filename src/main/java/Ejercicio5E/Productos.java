/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package Ejercicio5E;

/**
 *
 * @author samue
 */
public record Productos(String nombre,double precio,int cantidad,double iva) {
    //Con el Java record, se crea automaticamente los get setter y todo lo relacionado con las clases automaticamente
}
