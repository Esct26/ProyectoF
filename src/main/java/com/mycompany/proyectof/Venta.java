/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectof;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author esct
 */
public class Venta implements Serializable{
    private String nit;
    private String nombre;
    private String direccion;
    private String vendedor;
    private double total;
    private double totalSinIva;
    private String fecha;
    private ArrayList<LibroV> librosV = new ArrayList<>();

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the totalSinIva
     */
    public double getTotalSinIva() {
        return totalSinIva;
    }

    /**
     * @param totalSinIva the totalSinIva to set
     */
    public void setTotalSinIva(double totalSinIva) {
        this.totalSinIva = totalSinIva;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the librosV
     */
    public ArrayList<LibroV> getLibrosV() {
        return librosV;
    }

    /**
     * @param librosV the librosV to set
     */
    public void setLibrosV(ArrayList<LibroV> librosV) {
        this.librosV = librosV;
    }
}
