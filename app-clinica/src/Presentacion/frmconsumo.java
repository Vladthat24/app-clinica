/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vconsumo;
import Datos.vfarmacia;
import Datos.vtrabajador;
import Logica.fconsumo;
import Logica.ffarmacia;

import Logica.ftrabajador;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reports.reporte_regadministrativo;

/**
 *
 * @author vladhat
 */
public class frmconsumo extends javax.swing.JInternalFrame {

    public static String idCaja;
    public static String cliente;
    /**
     * Creates new form frmcliente
     */
    String fecha_inicial;
    String fecha_final;

    public frmconsumo() {
        initComponents();
        mostrar(idCaja);
        inhabilitar();
        lblcliente.setText(cliente);
        txtidcaja.setText(idCaja);

    }

    private String accion = "guardar";

    void fecha_actual() {

        LocalDate fechaactual = LocalDate.now();

        lblfecharegistro.setText(DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(fechaactual));

    }

    void ocultar_columnas() {

        tablalistado.getColumnModel().getColumn(0).setMaxWidth(35);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(35);
//        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(35);

        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(0);

    }

    void inhabilitar() {
        txtidconsumo.setVisible(false);
        txtidcaja.setVisible(false);
        txtidfarmacia.setVisible(false);
        cboestadoconsumo.setVisible(false);

        lblcliente.setEnabled(false);
        lblproducto.setEnabled(false);
        lblprecio_venta.setEnabled(false);
        txtcantidad.setEnabled(false);
        cboestadoconsumo.setEnabled(false);
        lblfecharegistro.setEnabled(false);

        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnproducto.setEnabled(false);

        lblproducto.setText("");
        lblprecio_venta.setText("");
        txtcantidad.setText("");
        lblfecharegistro.setText("");

    }

    void habilitar() {
        txtidconsumo.setVisible(false);
        txtidcaja.setVisible(false);
        txtidfarmacia.setVisible(false);
        cboestadoconsumo.setVisible(false);
        lblcliente.setEnabled(true);
        lblproducto.setEnabled(true);
        lblprecio_venta.setEnabled(true);
        txtcantidad.setEnabled(true);
        cboestadoconsumo.setEnabled(true);
        lblfecharegistro.setEnabled(true);

        btnguardar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnproducto.setEnabled(true);

        lblproducto.setText("");
        lblprecio_venta.setText("");
        txtcantidad.setText("");
        lblfecharegistro.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fconsumo func = new fconsumo();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Cantidad de Producto " + Integer.toString(func.totalregistros));
            lblconsumo.setText("Consumo Total s/. " + func.totalconsumo);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtidfarmacia = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        txtidcaja = new javax.swing.JTextField();
        lblcliente = new javax.swing.JLabel();
        txtidconsumo = new javax.swing.JTextField();
        lblprecio_venta = new javax.swing.JLabel();
        btnproducto = new javax.swing.JButton();
        lblproducto = new javax.swing.JLabel();
        cboestadoconsumo = new javax.swing.JComboBox<>();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblfecharegistro = new javax.swing.JLabel();
        lbltotalregistros = new javax.swing.JLabel();
        lblconsumo = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(78, 150, 203));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Consumo del Paciente:"));

        txtcantidad.setBackground(new java.awt.Color(78, 150, 203));
        txtcantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtcantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cantidad:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        lblcliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente:"));

        lblprecio_venta.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio Venta:"));

        btnproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/farmaco.png"))); // NOI18N
        btnproducto.setText("Medicamentos");
        btnproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductoActionPerformed(evt);
            }
        });

        lblproducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto:"));

        cboestadoconsumo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aceptado", "Cancelado" }));
        cboestadoconsumo.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado del Consumo:"));

        btnnuevo.setBackground(new java.awt.Color(51, 51, 51));
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/document_add.png"))); // NOI18N
        btnnuevo.setMnemonic('N');
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(51, 51, 51));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/diskette.png"))); // NOI18N
        btnguardar.setMnemonic('G');
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtidfarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtidcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtidconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblcliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboestadoconsumo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprecio_venta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnguardar)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidfarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnproducto)
                .addGap(4, 4, 4)
                .addComponent(lblproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboestadoconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblprecio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(171, 219, 154));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado del Consumo:"));

        tablalistado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistado);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(171, 219, 154));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Consumo:"));

        lblfecharegistro.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Registro"));

        lbltotalregistros.setBackground(new java.awt.Color(93, 173, 170));
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        lblconsumo.setBackground(new java.awt.Color(93, 173, 170));
        lblconsumo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Costo Total:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btneliminar.setBackground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.setMnemonic('E');
        btneliminar.setText("Eliminar");
        btneliminar.setBorder(new javax.swing.border.MatteBorder(null));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblconsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltotalregistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblfecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblfecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        fecha_actual();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        
        if (txtcantidad.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar la cantidad");
            txtcantidad.requestFocus();
            return;
        }
        if (txtcantidad.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar la cantidad");
            txtcantidad.requestFocus();
            return;
        }
        if (txtidfarmacia.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Medicamento");
            txtidfarmacia.requestFocus();
            return;
        }

        vconsumo dts = new vconsumo();
        fconsumo func = new fconsumo();

        dts.setIdcaja(Integer.parseInt(txtidcaja.getText()));
        dts.setIdfarmacia(Integer.parseInt(txtidfarmacia.getText()));
        dts.setCantidad(Integer.parseInt(txtcantidad.getText()));
        dts.setPrecio_venta(Double.parseDouble(lblprecio_venta.getText()));
        int selecc = cboestadoconsumo.getSelectedIndex();
        selecc = cboestadoconsumo.getSelectedIndex();
        dts.setEstado((String) cboestadoconsumo.getItemAt(selecc));
        dts.setFecha_registro(lblfecharegistro.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "el consumo " + lblproducto.getText() + " del cliente "
                        + lblcliente.getText() + " Ha sido registrado correctamente");
                mostrar(idCaja);
                inhabilitar();

            }

        } else if (accion.equals("editar")) {
            dts.setIdconsumo(Integer.parseInt(txtidconsumo.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El consumo del cliente "
                        + lblcliente.getText() + " ha sido modificado correctamente ");
                mostrar(idCaja);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidconsumo.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidcaja.setText(tablalistado.getValueAt(fila, 1).toString());
        txtidfarmacia.setText(tablalistado.getValueAt(fila, 2).toString());
        lblproducto.setText(tablalistado.getValueAt(fila, 3).toString());
        txtcantidad.setText(tablalistado.getValueAt(fila, 4).toString());

        lblprecio_venta.setText(tablalistado.getValueAt(fila, 5).toString());
        cboestadoconsumo.setSelectedItem(tablalistado.getValueAt(fila, 6).toString());
        lblfecharegistro.setText(tablalistado.getValueAt(fila, 7).toString());

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidconsumo.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Estás seguro de eliminar el consumo?", "Confirmar", 2);

            if (confirmacion == 0) {
                fconsumo func = new fconsumo();
                vconsumo dts = new vconsumo();

                dts.setIdconsumo(Integer.parseInt(txtidconsumo.getText()));
                func.eliminar(dts);
                mostrar(idCaja);
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
        txtcantidad.transferFocus();
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void btnproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductoActionPerformed
        // TODO add your handling code here:
        frmvista_consumo_farmacia form = new frmvista_consumo_farmacia();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnproductoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmconsumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnproducto;
    private javax.swing.JComboBox<String> cboestadoconsumo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lblcliente;
    private javax.swing.JLabel lblconsumo;
    private javax.swing.JLabel lblfecharegistro;
    public static javax.swing.JLabel lblprecio_venta;
    public static javax.swing.JLabel lblproducto;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtidcaja;
    private javax.swing.JTextField txtidconsumo;
    public static javax.swing.JTextField txtidfarmacia;
    // End of variables declaration//GEN-END:variables
}
