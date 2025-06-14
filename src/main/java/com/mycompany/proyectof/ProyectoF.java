/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectof;

import static com.mycompany.proyectof.V_Admin.InsertarDatos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public static ArrayList<LibroV> librosvs = new ArrayList<>();
    
    public static void main(String[] args) {
        
        InsertarDatos();
        
        Login log = new Login();
        log.setVisible(true);
        
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
    
    public static void escribirArchivoBinario(Object o, String ruta){
        try{
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream escribe = new ObjectOutputStream(archivo);
            escribe.writeObject(o);
        }catch(Exception e){
            
        }
    }
    
    public static Object leerArchivoBinario(String ruta){
        try{
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream lee = new ObjectInputStream(archivo);
            lee.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
