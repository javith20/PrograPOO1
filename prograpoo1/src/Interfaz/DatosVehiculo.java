/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Archivos.AdministradorArchivos;
import Archivos.LectorXML;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.xml.sax.SAXException;
import prograpoo1.Vehiculo;

/**
 *
 * @author Javith
 */
public final class DatosVehiculo extends javax.swing.JFrame {
    
    /**
     * Creates new form Interfaz
     */
    public DatosVehiculo(Vehiculo vehiculo) {
        initComponents();
        
        this.labeltTtulo.setText("Vehiculo: ");
        this.labelrespuesta0.setText(vehiculo.getPlaca());
        this.labelatrib1.setText("Color: ");
        this.labelrespuesta1.setText(vehiculo.getColor());
        this.labelatrib2.setText("Marca: ");
        this.labelrespuesta2.setText(vehiculo.getMarca());
        this.labelatrib3.setText("Año: ");
        this.labelrespuesta3.setText(String.valueOf(vehiculo.getAgnoFabricacion()));
       //this.labelatrib4.setText("Capacidad");
        //this.labelrespuesta4.setText(String.valueOf(vehiculo.getCapacidad()));
        
    }
    
    private void CargarComponentes(){
        
    
    }
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labeltTtulo = new javax.swing.JLabel();
        labelrespuesta0 = new javax.swing.JLabel();
        labelatrib1 = new javax.swing.JLabel();
        labelrespuesta1 = new javax.swing.JLabel();
        labeltTtulo1 = new javax.swing.JLabel();
        labelrespuesta3 = new javax.swing.JLabel();
        labelatrib3 = new javax.swing.JLabel();
        labelatrib2 = new javax.swing.JLabel();
        labelrespuesta2 = new javax.swing.JLabel();
        labelatrib6 = new javax.swing.JLabel();
        labelrespuesta7 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        subMenuArchivo = new javax.swing.JMenu();
        itemUsuario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        mINuevoChofer = new javax.swing.JMenuItem();
        mINuevoEmpresa = new javax.swing.JMenuItem();
        mINuevoPasajero = new javax.swing.JMenuItem();
        mINuevoVehiculo = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        subMenuEditar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));

        jPanel1.setBackground(new java.awt.Color(50, 129, 255));

        labeltTtulo.setBackground(new java.awt.Color(204, 0, 0));
        labeltTtulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labeltTtulo.setText("1");

        labelrespuesta0.setBackground(new java.awt.Color(204, 0, 0));
        labelrespuesta0.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelrespuesta0.setText("11");

        labelatrib1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelatrib1.setText("1");

        labelrespuesta1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelrespuesta1.setText("1");

        labeltTtulo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        labelrespuesta3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        labelatrib3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        labelatrib2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelatrib2.setText("1");

        labelrespuesta2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelrespuesta2.setText("1");

        labelatrib6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelatrib6.setText("1");

        labelrespuesta7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelrespuesta7.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labeltTtulo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelrespuesta0, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelatrib1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelrespuesta1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelatrib2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelrespuesta2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelatrib3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelatrib6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelrespuesta7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labeltTtulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(labelrespuesta3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltTtulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelrespuesta0))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(labelatrib3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelatrib1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelrespuesta1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelatrib2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelrespuesta2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelatrib6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelrespuesta7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(303, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labeltTtulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelrespuesta3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(388, Short.MAX_VALUE)))
        );

        subMenuArchivo.setText("Archivo");

        itemUsuario.setText("Usuario");
        subMenuArchivo.add(itemUsuario);
        subMenuArchivo.add(jSeparator1);

        jMenu1.setText("Nuevo");

        mINuevoChofer.setText("Chofer");
        jMenu1.add(mINuevoChofer);

        mINuevoEmpresa.setText("Empresa");
        jMenu1.add(mINuevoEmpresa);

        mINuevoPasajero.setText("Pasajero");
        mINuevoPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mINuevoPasajeroActionPerformed(evt);
            }
        });
        jMenu1.add(mINuevoPasajero);

        mINuevoVehiculo.setText("Vehiculo");
        mINuevoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mINuevoVehiculoActionPerformed(evt);
            }
        });
        jMenu1.add(mINuevoVehiculo);

        subMenuArchivo.add(jMenu1);

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        subMenuArchivo.add(itemSalir);

        barraMenu.add(subMenuArchivo);

        subMenuEditar.setText("Editar");
        barraMenu.add(subMenuEditar);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
     
    }//GEN-LAST:event_itemSalirActionPerformed

    private void mINuevoPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mINuevoPasajeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mINuevoPasajeroActionPerformed

    private void mINuevoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mINuevoVehiculoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear().setVisible(true);
            }
        });
    }//GEN-LAST:event_mINuevoVehiculoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel labelatrib1;
    private javax.swing.JLabel labelatrib2;
    private javax.swing.JLabel labelatrib3;
    private javax.swing.JLabel labelatrib6;
    private javax.swing.JLabel labelrespuesta0;
    private javax.swing.JLabel labelrespuesta1;
    private javax.swing.JLabel labelrespuesta2;
    private javax.swing.JLabel labelrespuesta3;
    private javax.swing.JLabel labelrespuesta7;
    private javax.swing.JLabel labeltTtulo;
    private javax.swing.JLabel labeltTtulo1;
    private javax.swing.JMenuItem mINuevoChofer;
    private javax.swing.JMenuItem mINuevoEmpresa;
    private javax.swing.JMenuItem mINuevoPasajero;
    private javax.swing.JMenuItem mINuevoVehiculo;
    private javax.swing.JMenu subMenuArchivo;
    private javax.swing.JMenu subMenuEditar;
    // End of variables declaration//GEN-END:variables
}