/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectof;

import java.util.ArrayList;

/**
 *
 * @author esct
 */
public class Venta {
    public String nit;
    public String nombre;
    public String direccion;
    public String vendedor;
    public double total;
    public double totalSinIva;
    public String fecha;
    public ArrayList<LibroV> librosV = new ArrayList<>();
}
