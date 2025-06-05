/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectof;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Date;

/**
 *
 * @author esct
 */
public class V_Ventas extends javax.swing.JFrame {

    public Usuario usuarioActual;
    public Venta ventaActual = new Venta();
    public Cupon cuponActual = new Cupon();

    /**
     * Creates new form Ventas
     *
     * @param usuario
     */
    public V_Ventas(Usuario usuario) {
        initComponents();
        usuarioActual = usuario;
        Items();
        Cupones();
        pTabla();
        Añadir.setVisible(false);
    }

    private boolean vencimiento(String fecha1) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fv = formato.parse(fecha1);
            Date fa = new Date();
            if (fa.after(fv)) {
                return true;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void pTabla() {
        String encabezado[] = {"Titulo", "Cantidad", "Subtotal"};
        DefaultTableModel t = new DefaultTableModel(encabezado, ventaActual.getLibrosV().size());
        jTable1.setModel(t);
        TableModel tabla = jTable1.getModel();

        for (int i = 0; i < ventaActual.getLibrosV().size(); i++) {
            LibroV lv = ventaActual.getLibrosV().get(i);
            tabla.setValueAt(lv.getTitulo(), i, 0);
            tabla.setValueAt(lv.getCantidad(), i, 1);
            tabla.setValueAt(lv.getSubtotal(), i, 2);
        }
    }

    private void Items() {
        jComboBox1.removeAllItems();
        for (int i = 0; i < ProyectoF.libros.size(); i++) {
            Libro l = ProyectoF.libros.get(i);
            jComboBox1.addItem(l.getTitulo());
        }
    }

    private void Cupones() {
        jComboBox2.removeAllItems();
        jComboBox2.addItem("");
        for (int i = 0; i < ProyectoF.cupones.size(); i++) {
            Cupon c = ProyectoF.cupones.get(i);
            jComboBox2.addItem(c.getCodigo());
        }
    }

    private void Precios() {
        String cod = jComboBox2.getSelectedItem().toString();
        String lib = jComboBox1.getSelectedItem().toString();
        int cant = Integer.parseInt(TxTF_Cantidad.getText());
        int stock = 0;
        int d = 0;
        for (int i = 0; i < ProyectoF.libros.size(); i++) {
            Libro l = ProyectoF.libros.get(i);
            if (l.getTitulo().equals(lib) && l.getStock() >= cant) {
                stock = 1;
                if (cod != ("")) {
                    if (JOptionPane.showConfirmDialog(this, "¿Desea aplicar el Cupon?") == 0) {
                        for (Cupon c : ProyectoF.cupones) {
                            vencimiento(c.getVencimineto());
                            if (c.getCodigo().equals(cod) && c.getDisponible().equals("Usado") == false && d == 0 && vencimiento(c.getVencimineto()) != true) {
                                JOptionPane.showMessageDialog(this, "Cupon aplicado");
                                PrecioU.setText(String.valueOf(l.getPrecio()));
                                if (c.getTipo().equals("Porcentage") && d == 0) {
                                    Double descuento = (l.getPrecio() * (c.getValor() / 100));
                                    PrecioT.setText(String.valueOf((l.getPrecio() * cant) - descuento));
                                    c.setDisponible("Usados");
                                    l.setStock(l.getStock() - cant);
                                } else if (c.getTipo().equals("Monto F") && d == 0) {
                                    PrecioT.setText(String.valueOf((l.getPrecio() * cant) - c.getValor()));
                                    c.setDisponible("Usado");
                                    l.setStock(l.getStock() - cant);
                                }
                                d = 1;
                            } else if (d == 0 && vencimiento(c.getVencimineto()) == true) {
                                d = 1;
                                JOptionPane.showMessageDialog(this, "Cupon no disponible");
                                c.setDisponible("Usado");
                                PrecioU.setText(String.valueOf(l.getPrecio()));
                                PrecioT.setText(String.valueOf(l.getPrecio() * cant));
                                l.setStock(l.getStock() - cant);
                            }
                        }
                    }

                } else {
                    PrecioU.setText(String.valueOf(l.getPrecio()));
                    PrecioT.setText(String.valueOf(l.getPrecio() * cant));
                    l.setStock(l.getStock() - cant);
                }

            } else if (l.getTitulo().equals(lib) && stock == 0 && l.getStock() < cant) {
                stock = 1;
                PrecioU.setText("---");
                PrecioT.setText("---");
                JOptionPane.showMessageDialog(this, "Stock Insuficiente");
            }
        }
    }

    private double ObtenerT() {
        double t = 0;
        for (int i = 0; i < ventaActual.getLibrosV().size(); i++) {
            double p = Double.parseDouble(jTable1.getModel().getValueAt(i, 2).toString());
            t += p;
        }
        jLabel10.setText("" + t);
        return t;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Calcular = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxTF_Cantidad = new javax.swing.JTextField();
        Confirmar = new javax.swing.JButton();
        PrecioU = new javax.swing.JLabel();
        PrecioT = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        Añadir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Libro:");

        jLabel2.setText("Precio U:");

        jLabel3.setText("Precio T:");

        Calcular.setText("Calcular");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("URW Gothic", 1, 24)); // NOI18N
        jLabel6.setText("Venta");

        jLabel4.setText("Cantidad:");

        Confirmar.setText("Confirmar");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });

        PrecioU.setText("----");

        PrecioT.setText("----");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("NIT:");

        jLabel7.setText("Nombre:");

        jLabel8.setText("Direccion:");

        Añadir.setText("Añadir");
        Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirActionPerformed(evt);
            }
        });

        jLabel9.setText("El Total es: ");

        jLabel10.setText("----");

        jLabel11.setText("Cupon:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Calcular)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(TxTF_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Añadir)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(PrecioT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(PrecioU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Confirmar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(PrecioT, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(PrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxTF_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Calcular)
                    .addComponent(Añadir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(22, 22, 22)
                .addComponent(Confirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
        // TODO add your handling code here:
        ventaActual.setNit(jTextField2.getText());
        ventaActual.setNombre(jTextField3.getText());
        ventaActual.setDireccion(jTextField4.getText());
        ventaActual.setVendedor(usuarioActual.getNombre());
        ventaActual.setTotal(ObtenerT());
        ventaActual.setTotalSinIva(ObtenerT() / 1.12);

        Calendar fechaHoraActual = Calendar.getInstance();
        ventaActual.setFecha(fechaHoraActual.getTime().toString());

        if (JOptionPane.showConfirmDialog(this, "Finalizar la compra") == 0) {
            ProyectoF.ventas.add(ventaActual);
            
            for (int i = 0; i < ventaActual.getLibrosV().size(); i++) {
                LibroV lv = new LibroV();
                lv.setTitulo((jTable1.getModel().getValueAt(i, 0).toString()));
                String cantidad = ((jTable1.getModel().getValueAt(i, 1).toString()));
                lv.setCantidad(Integer.parseInt(cantidad));
                String subtotal = ((jTable1.getModel().getValueAt(i, 2).toString()));
                lv.setSubtotal(Double.parseDouble(subtotal));
                lv.setFecha(fechaHoraActual.getTime().toString());
                ProyectoF.librosvs.add(lv);
            }
            
            JOptionPane.showMessageDialog(this, "Venta realizada con exito");
            
        }else{
            JOptionPane.showMessageDialog(this, "Venta cancelada");
        }
    }//GEN-LAST:event_ConfirmarActionPerformed

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
        // TODO add your handling code here:
        try {
            LibroV lv = new LibroV();
            lv.setTitulo(jComboBox1.getSelectedItem().toString());
            lv.setCantidad(Integer.parseInt(TxTF_Cantidad.getText()));
            lv.setSubtotal(Double.parseDouble(PrecioT.getText()));
            ventaActual.getLibrosV().add(lv);
            pTabla();
            ObtenerT();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Llene los espacios en blanco con la informacion correcta");
        } finally{
            Añadir.setVisible(false);
        }
    }//GEN-LAST:event_AñadirActionPerformed

    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed
        // TODO add your handling code here:
        try {
            Precios();
        } catch (Exception e) {
            Añadir.setVisible(false);
            JOptionPane.showMessageDialog(this, "Llene los espacios en blanco con la informacion correcta");
        } finally{
            Añadir.setVisible(true);
        }
    }//GEN-LAST:event_CalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Añadir;
    private javax.swing.JButton Calcular;
    private javax.swing.JButton Confirmar;
    private javax.swing.JLabel PrecioT;
    private javax.swing.JLabel PrecioU;
    private javax.swing.JTextField TxTF_Cantidad;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
