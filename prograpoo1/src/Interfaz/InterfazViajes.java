/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Archivos.AdministradorArchivos;
import Archivos.LectorXML;
import LogicaNegocios.Viaje;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.xml.sax.SAXException;

import LogicaNegocios.Vehiculo;

/**
 *
 * @author Javith
 */
public final class InterfazViajes extends javax.swing.JFrame {

    public  static AdministradorArchivos administradorArchivos = new AdministradorArchivos();
    private ArrayList<Viaje> ListaVehiculos =  administradorArchivos.getViajes());
    private DefaultTableModel modelo;

    /**
     * Creates new form Interfaz
     */
    public InterfazViajes() {
        initComponents();
        try {
            CargarComponentes();
        } catch (Exception e) {

        }
    }
    private void CargarComponentes() {
        this.comboFiltrado.removeAllItems();
        this.comboFiltrado.addItem("ID");
        this.comboFiltrado.addItem("Fecha Solicitud");
        this.comboFiltrado.addItem("Fecha Inicio");
        this.comboFiltrado.addItem("Placa Vehiculo");
        this.comboFiltrado.addItem("Chofer");
        this.comboFiltrado.addItem("Estado");
        insertarEnlista(this.ListaVehiculos);
    }

    private void insertarEnlista(ArrayList<Viaje> lista) {
        Clear();
        modelo = (DefaultTableModel) TableVehiculos.getModel();

        Object[] fila = new Object[5];

        for (int indice = 0; lista.size() > indice; indice++) {

            fila[0] = lista.get(indice).getID();
            fila[1] = lista.get(indice).getChofer().getNombre();
            fila[2] = lista.get(indice).getVehiculo().getPlaca();
            fila[3] = lista.get(indice).getEstado();
            fila[4] = lista.get(indice).getSolicitud();
            fila[5] = lista.get(indice).getInicioDate();
            fila[6] = lista.get(indice).getFinDate();
            modelo.addRow(fila);
        }

    }

    private void Clear() {
        for (int i = 0; i < TableVehiculos.getRowCount(); i++) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TableVehiculos = new javax.swing.JTable();
        txtBuscado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboFiltrado = new javax.swing.JComboBox<>();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setForeground(new java.awt.Color(255, 0, 0));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        TableVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Chofer", "Vehiculo", "Estado", "Fecha Solicitud", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableVehiculos);

        txtBuscado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadoActionPerformed(evt);
            }
        });
        txtBuscado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Vehiculos");

        comboFiltrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboFiltrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltradoActionPerformed(evt);
            }
        });

        subMenuArchivo.setText("Archivo");

        itemUsuario.setText("Usuario");
        itemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuarioActionPerformed(evt);
            }
        });
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboFiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed

    }//GEN-LAST:event_itemSalirActionPerformed

    private void mINuevoPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mINuevoPasajeroActionPerformed
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPasajero().setVisible(true);
            }
        }); 
        // TODO add your handling code here:
    }//GEN-LAST:event_mINuevoPasajeroActionPerformed

    private void txtBuscadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadoActionPerformed

    private void comboFiltradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFiltradoActionPerformed

    private void mINuevoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mINuevoVehiculoActionPerformed

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear().setVisible(true);
            }
        });
        
    }//GEN-LAST:event_mINuevoVehiculoActionPerformed

    private void itemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuarioActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_itemUsuarioActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void TableVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableVehiculosMouseClicked

        Viaje capturado = ListaVehiculos.get(this.TableVehiculos.getSelectedRow());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarDatos(capturado).setVisible(true);
            }
        });
        
    }//GEN-LAST:event_TableVehiculosMouseClicked

    private void txtBuscadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadoKeyTyped
        if(this.txtBuscado.getText().length()==0)
            insertarEnlista(ListaVehiculos);
        else
            insertarEnlista(administradorArchivos.filtradoVehiculos(this.comboFiltrado.getSelectedIndex(),this.txtBuscado.getText()));

    }//GEN-LAST:event_txtBuscadoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new InterfazViajes().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableVehiculos;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JComboBox<String> comboFiltrado;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mINuevoChofer;
    private javax.swing.JMenuItem mINuevoEmpresa;
    private javax.swing.JMenuItem mINuevoPasajero;
    private javax.swing.JMenuItem mINuevoVehiculo;
    private javax.swing.JMenu subMenuArchivo;
    private javax.swing.JMenu subMenuEditar;
    private javax.swing.JTextField txtBuscado;
    // End of variables declaration//GEN-END:variables
}
