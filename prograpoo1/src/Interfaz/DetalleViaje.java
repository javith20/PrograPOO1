/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Archivos.GuardarXML;
import Archivos.main;
import Conexiones.Correo;
import LogicaNegocios.Chofer;
import LogicaNegocios.Pasajero;
import LogicaNegocios.Vehiculo;
import LogicaNegocios.Viaje;
import Roles.InicioSecion;
import Roles.Usuario;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javith
 */
public class DetalleViaje extends javax.swing.JFrame {

    private ArrayList<Chofer> listaChoferes = main.admin.getChoferes();
    private ArrayList<Vehiculo> listaVehiculos = main.admin.getVehiculos();
    private ArrayList<Pasajero> listaPasajerosSeleccionados;
    private DefaultTableModel modelo;
    private SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
    private Viaje viaje;
    private Usuario usuario = InicioSecion.usuario;

    /**
     * Creates new form SolicitarViajes
     *
     * @param viaje
     */
    public DetalleViaje(Viaje viaje) {
        this.viaje = viaje;
        initComponents();
        listaPasajerosSeleccionados = viaje.getListaPasajeros();
        CargarComponentes();
    }

    private void CargarComponentes() {
        txtDescripcion.setText(viaje.getDescripcionString());
        txtFechaSolicitud.setText(formatoString.format(viaje.getSolicitud()));
        txtFechaSolicitud.setEditable(false);
        txtFechaInicio.setText(formatoString.format(viaje.getInicioDate()));
        txtFechaInicio.setEditable(false);
        txtFechafin.setText(formatoString.format(viaje.getFinDate()));
        txtFechafin.setEditable(false);
        labelEstado.setText(viaje.getEstado());
        comboChoferes.removeAllItems();
        comboVehiculos.removeAllItems();
        this.insertarEnlista(listaPasajerosSeleccionados);

        for (int j = 0; listaChoferes.size() > j; j++) {
            this.comboChoferes.addItem(listaChoferes.get(j).getNombre());
        }
        for (int j = 0; listaVehiculos.size() > j; j++) {
            this.comboVehiculos.addItem(listaVehiculos.get(j).getPlaca());
        }
        if (viaje.getEstado().equals("Cancelado") || !this.usuario.getTipo().equals("Administrador")) {
            comboChoferes.setEnabled(false);
            comboVehiculos.setEnabled(false);
            btnAprobarViaje.setEnabled(false);
            btnCancelarViaje.setEnabled(false);
        }
        if (viaje.getEstado().equals("Aprobado") || !this.usuario.getTipo().equals("Administrador")) {
            comboChoferes.setEnabled(false);
            comboVehiculos.setEnabled(false);
            btnAprobarViaje.setEnabled(false);
            
        }
    }

    private void insertarEnlista(ArrayList<Pasajero> lista) {
        main.Actualizar();
        Clear();
        modelo = (DefaultTableModel) tablePasajeros.getModel();

        Object[] fila = new Object[2];

        for (int indice = 0; lista.size() > indice; indice++) {

            fila[0] = lista.get(indice).getCedula();
            fila[1] = lista.get(indice).getNombre();

            modelo.addRow(fila);
        }

    }

    private void Clear() {
        for (int i = 0; i < tablePasajeros.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePasajeros = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechafin = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comboChoferes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboVehiculos = new javax.swing.JComboBox<>();
        btnAprobarViaje = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtFechaSolicitud = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnCancelarViaje = new javax.swing.JButton();
        labelEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Solicitud de Viaje");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Fecha Inicio");

        tablePasajeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre"
            }
        ));
        tablePasajeros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePasajerosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePasajeros);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha Fin");

        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });

        txtFechafin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechafinActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Chofer");

        comboChoferes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Vehiculo");

        comboVehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAprobarViaje.setText("Aprobar viaje");
        btnAprobarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobarViajeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fecha Solicutud");

        txtFechaSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaSolicitudActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        btnCancelarViaje.setText("Cancelar viaje");
        btnCancelarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarViajeActionPerformed(evt);
            }
        });

        labelEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelEstado.setText("jLabel7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboChoferes, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnAprobarViaje))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnCancelarViaje))
                                    .addComponent(comboVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1)
                        .addGap(146, 146, 146)
                        .addComponent(labelEstado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnGuardar)
                .addGap(39, 39, 39)
                .addComponent(btnCancelar)
                .addGap(0, 641, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelEstado))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboChoferes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAprobarViaje)
                            .addComponent(btnCancelarViaje))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)))
                    .addComponent(jScrollPane2))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void txtFechafinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechafinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechafinActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        GuardarXML nueva = new GuardarXML(this.viaje);
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tablePasajerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePasajerosMouseClicked

        Pasajero capturado = listaPasajerosSeleccionados.get(this.tablePasajeros.getSelectedRow());
        java.awt.EventQueue.invokeLater(() -> {
            new MostrarDatos(capturado).setVisible(true);
        });        // TODO add your handling code here:
    }//GEN-LAST:event_tablePasajerosMouseClicked

    private void txtFechaSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaSolicitudActionPerformed

    private void btnCancelarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarViajeActionPerformed
        this.viaje.setChofer(listaChoferes.get(this.comboChoferes.getSelectedIndex()));
        this.viaje.setVehiculo(listaVehiculos.get(this.comboVehiculos.getSelectedIndex()));
        String msg = "El Viaje "+ viaje.getID()+ " Con destino a "+viaje.getDescripcionString()+"Con un inicio en la fecha "+ viaje.getInicioDate().toString();
        msg += "\n El Chofer "+viaje.getChofer().getNombre();
        for(int p =0 ; viaje.getListaPasajeros().size()>p;p++){
            msg+="\n"+viaje.getListaPasajeros().get(p).getNombre();
        }
        try {
            if (this.viaje.getEstado().equals("Aprobado")) {
                if (listaVehiculos.get(this.comboVehiculos.getSelectedIndex()).getCapacidad() >= listaPasajerosSeleccionados.size() - 1) {
                    Correo envio = new Correo();
                    envio.enviarGmail("Cancelacion de Viaje", msg, viaje.getChofer().getCorreo());
                    for (int i = 0; listaPasajerosSeleccionados.size() > i; i++) {
                        envio.enviarGmail("Cancelacion de Viaje", msg, viaje.getListaPasajeros().get(i).getCorreo());
                    }
                    this.viaje.setEstado("Cancelado");
                   
                }

            } else {
                this.viaje.setEstado("Cancelado");
            }
        } catch (MessagingException e) {
            
        }
        

        CargarComponentes();
    }//GEN-LAST:event_btnCancelarViajeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAprobarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprobarViajeActionPerformed
        this.viaje.setChofer(listaChoferes.get(this.comboChoferes.getSelectedIndex()));
        this.viaje.setVehiculo(listaVehiculos.get(this.comboVehiculos.getSelectedIndex()));
        String msg = "El Viaje "+ viaje.getID()+ " Con destino a "+viaje.getDescripcionString()+"Con un inicio en la fecha "+ viaje.getInicioDate().toString();
        msg += "\n El Chofer "+viaje.getChofer().getNombre();
        for(int p =0 ; viaje.getListaPasajeros().size()>p;p++){
            msg+="\n"+viaje.getListaPasajeros().get(p).getNombre();
        }
        try {
            if (this.viaje.getEstado().equals("En Confeccion")) {
                if (listaVehiculos.get(this.comboVehiculos.getSelectedIndex()).getCapacidad() >= listaPasajerosSeleccionados.size() - 1) {
                    Correo envio = new Correo();
                    envio.enviarGmail("Aprobacion de Viaje", msg, viaje.getChofer().getCorreo());
                    for (int i = 0; listaPasajerosSeleccionados.size() > i; i++) {
                        envio.enviarGmail("Aprobacion de Viaje", msg, viaje.getListaPasajeros().get(i).getCorreo());
                    }
                    this.viaje.setEstado("Aprobado");
                    
                }

            } else {

            }
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        GuardarXML nuevo = new GuardarXML(viaje);
        CargarComponentes();
    }//GEN-LAST:event_btnAprobarViajeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAprobarViaje;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarViaje;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboChoferes;
    private javax.swing.JComboBox<String> comboVehiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JTable tablePasajeros;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtFechaSolicitud;
    private javax.swing.JTextField txtFechafin;
    // End of variables declaration//GEN-END:variables
}
