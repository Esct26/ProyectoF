/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectof;

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
        
        Usuario admin = new Usuario();
        admin.setNombre("admin");
        admin.setPassword("admin");
        admin.setRol("A");
        admin.setUsuario("admin");
        usuarios.add(admin);
        
        Usuario un = new Usuario();
        un.setNombre("u");
        un.setPassword("admin");
        un.setRol("v");
        un.setUsuario("u");
        usuarios.add(un);
        
        Libro uno = new Libro();
        uno.setTitulo("Uno");
        uno.setAutor("UNO");
        uno.setGenero("Tres");
        uno.setPrecio(10.0);
        uno.setStock(10);
        libros.add(uno);
        
        Libro dos = new Libro();
        dos.setTitulo("Dos");
        dos.setAutor("DOS");
        dos.setGenero("Tres");
        dos.setPrecio(5.5);
        dos.setStock(10);
        libros.add(dos);
        
        Login log = new Login();
        log.setVisible(true);
        
        ArrayList<Usuario> usuario = new ArrayList<>();
        for(Usuario u : ProyectoF.usuarios){
            Usuario us = new Usuario();
            us.setNombre(u.getNombre());
            us.setPassword(u.getPassword());
            us.setRol(u.getRol());
            us.setUsuario(u.getUsuario());
            us.setTelefonos(u.getTelefonos());
            usuario.add(u);
        }
        
        ArrayList<Libro> libro = new ArrayList<>();
        for(Libro l : ProyectoF.libros){
            Libro li = new Libro();
            li.setTitulo(l.getTitulo());
            li.setAutor(l.getAutor());
            li.setGenero(l.getGenero());
            li.setPrecio(l.getPrecio());
            li.setStock(l.getStock());
            libro.add(l);
        }
        
        ArrayList<Cupon> cupon = new ArrayList<>();
        for(Cupon c : ProyectoF.cupones){
            Cupon cu = new Cupon();
            cu.setCodigo(c.getCodigo());
            cu.setValor(c.getValor());
            cu.setVencimineto(c.getVencimineto());
            cu.setTipo(c.getTipo());
            cu.setDisponible(c.getDisponible());
        }
        
        ArrayList<Venta> venta = new ArrayList<>();
        for(Venta v : ProyectoF.ventas){
            Venta ve = new Venta();
            ve.setNit(v.getNit());
            ve.setNombre(v.getNombre());
            ve.setDireccion(v.getDireccion());
            ve.setVendedor(v.getVendedor());
            ve.setTotal(v.getTotal());
            ve.setTotalSinIva(v.getTotalSinIva());
            ve.setFecha(v.getFecha());
            ve.setLibrosV(v.getLibrosV());
        }
        
        ArrayList<Proveedor> proveedor = new ArrayList<>();
        for(Proveedor p : ProyectoF.proveedores){
            Proveedor pr = new Proveedor();
            pr.setNit(p.getNit());
            pr.setNombre(p.getNombre());
            pr.setTelefono(p.getTelefono());
            pr.setDireccion(p.getDireccion());
        }
        
        ArrayList<LibroV> librov = new ArrayList<>();
        for(LibroV lv : ProyectoF.librosvs){
            LibroV liv = new LibroV();
            liv.setTitulo(lv.getTitulo());
            liv.setCantidad(lv.getCantidad());
            liv.setSubtotal(lv.getSubtotal());
            liv.setFecha(lv.getFecha());
        }
        
        Programa prog = new Programa();
        prog.setUsuar(usuario);
        prog.setLibr(libro);
        prog.setCupo(cupon);
        prog.setVent(venta);
        prog.setProvee(proveedor);
        prog.setLibrv(librov);
        
        escribirArchivoBinario(prog, "Info.progra");
        
        Programa leeido = (Programa) leerArchivoBinario("Info.progra");
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
