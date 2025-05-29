/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectof;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esct
 */
public class ProyectoF {
    
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Libro> libros = new ArrayList<>();
    public static ArrayList<Cupon> cupones = new ArrayList<>();
    public static ArrayList<Venta> ventas = new ArrayList<>();
    public static ArrayList<Proveedor> proveedores = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Usuario admin = new Usuario();
        admin.nombre = "admin";
        admin.password = "admin";
        admin.rol = "A";
        admin.usuario = "admin";
        usuarios.add(admin);
        
        Usuario u = new Usuario();
        u.nombre = "u";
        u.password = "admin";
        u.rol = "v";
        u.usuario = "u";
        usuarios.add(u);
        
        Libro uno = new Libro();
        uno.titulo = "Uno";
        uno.autor = "UNO";
        uno.genero = "Tres";
        uno.precio = 10.0;
        uno.stock = 10;
        libros.add(uno);
        
        Libro dos = new Libro();
        dos.titulo = "Dos";
        dos.autor = "DOS";
        dos.genero = "Tres";
        dos.precio = 5.5;
        dos.stock = 10;
        libros.add(dos);
        
        escribir("Cupones.csv",
                """
                1234-A|10.0|2025-08-21|Porcentage|Disponible
                """);
        
        Login l = new Login();
        l.setVisible(true);
        
    }
    
    public static void escribir(String ruta, String contenido){
        try {
            FileWriter archivo = new FileWriter(ruta/*, true*/);
            PrintWriter escribir = new PrintWriter(archivo);
            File f = new File("Cupones.csv");
            
            escribir.write(contenido);
            
            escribir.close();
            archivo.close();
        } catch (IOException ex) {
            Logger.getLogger(Cupon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
