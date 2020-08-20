/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vfarmacia;
import Datos.vtrabajador;
import Logica.ffarmacia;

import Logica.ftrabajador;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reports.reporte_regadministrativo;

/**
 *
 * @author vladhat
 */
public class frmfarmacia extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmcliente
     */
    String fecha_inicial;
    String fecha_final;

    public frmfarmacia() {
        initComponents();
        mostrar("");
        inhabilitar();

    }
    private String accion = "guardar";

    void fecha_actual() {
        Calendar today = Calendar.getInstance();
        int fhoy_dia = today.get(Calendar.DAY_OF_MONTH);
        int fhoy_mes = today.get(Calendar.MONTH) + 1;
        int fhoy_year = today.get(Calendar.YEAR) - 1900;

        lblfecharegistro.setText(fhoy_dia + "/" + fhoy_mes + "/" + fhoy_year);

    }

    void ocultar_columnas() {
    }

    void inhabilitar() {
        txtidfarmacia.setVisible(false);

        txtcategoria.setEnabled(false);
        txtnombre.setEnabled(false);
        txtprecioventa.setEnabled(false);
        spStock.setEnabled(false);
        txtlaboratorio.setEnabled(false);
        txtpresentacion.setEnabled(false);
        lblfecharegistro.setEnabled(false);

        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btnreportes.setEnabled(false);

        txtidfarmacia.setText("");
        txtcategoria.setText("");
        txtnombre.setText("");
        txtprecioventa.setText("");
        spStock.setValue(0);
        txtlaboratorio.setText("");
        txtpresentacion.setText("");
        lblfecharegistro.setText("");

    }

    void habilitar() {
        txtidfarmacia.setVisible(false);

        txtcategoria.setEnabled(true);
        txtnombre.setEnabled(true);
        txtprecioventa.setEnabled(true);
        spStock.setEnabled(true);
        txtlaboratorio.setEnabled(true);
        txtpresentacion.setEnabled(true);
        lblfecharegistro.setEnabled(true);

        btnguardar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnbuscar.setEnabled(true);
        btnreportes.setEnabled(true);

        txtidfarmacia.setText("");
        txtcategoria.setText("");
        txtnombre.setText("");
        txtprecioventa.setText("");
        spStock.setValue(0);
        txtlaboratorio.setText("");
        txtpresentacion.setText("");
        lblfecharegistro.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            ffarmacia func = new ffarmacia();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtidfarmacia = new javax.swing.JTextField();
        txtcategoria = new javax.swing.JTextField();
        txtlaboratorio = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtprecioventa = new javax.swing.JTextField();
        txtpresentacion = new javax.swing.JTextField();
        spStock = new javax.swing.JSpinner();
        dcfechavencimiento = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnreportes = new javax.swing.JButton();
        lblfecharegistro = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(158, 179, 193));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Trabajador"));

        txtcategoria.setBackground(new java.awt.Color(158, 179, 193));
        txtcategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategoriaActionPerformed(evt);
            }
        });
        txtcategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcategoriaKeyTyped(evt);
            }
        });

        txtlaboratorio.setBackground(new java.awt.Color(158, 179, 193));
        txtlaboratorio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laboratorio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtlaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlaboratorioKeyTyped(evt);
            }
        });

        txtnombre.setBackground(new java.awt.Color(158, 179, 193));
        txtnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtprecioventa.setBackground(new java.awt.Color(158, 179, 193));
        txtprecioventa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtprecioventa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtprecioventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioventaActionPerformed(evt);
            }
        });
        txtprecioventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioventaKeyTyped(evt);
            }
        });

        txtpresentacion.setBackground(new java.awt.Color(158, 179, 193));
        txtpresentacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Presentacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtpresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpresentacionActionPerformed(evt);
            }
        });
        txtpresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpresentacionKeyTyped(evt);
            }
        });

        spStock.setBorder(javax.swing.BorderFactory.createTitledBorder("Stok"));

        dcfechavencimiento.setBackground(new java.awt.Color(158, 179, 193));
        dcfechavencimiento.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Vencimiento"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidfarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtlaboratorio)
                                .addGap(12, 12, 12)
                                .addComponent(dcfechavencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtidfarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcfechavencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtlaboratorio)
                        .addComponent(txtpresentacion)))
                .addGap(9, 9, 9))
        );

        jPanel2.setBackground(new java.awt.Color(93, 173, 170));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Trabajador"));

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

        btnbuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/search.png"))); // NOI18N
        btnbuscar.setMnemonic('B');
        btnbuscar.setBorder(new javax.swing.border.MatteBorder(null));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(255, 255, 255));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.setMnemonic('E');
        btneliminar.setBorder(new javax.swing.border.MatteBorder(null));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        lbltotalregistros.setBackground(new java.awt.Color(93, 173, 170));
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btnreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reporte_2.png"))); // NOI18N
        btnreportes.setBorder(new javax.swing.border.MatteBorder(null));
        btnreportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportesActionPerformed(evt);
            }
        });

        lblfecharegistro.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Registro"));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar)
                        .addGap(92, 92, 92)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblfecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btneliminar)
                        .addComponent(btnreportes))
                    .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnuevo)
                            .addComponent(btnguardar))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (spStock.getValue().equals(0)) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un stock");
            txtcategoria.requestFocus();
            return;
        }
        if (txtlaboratorio.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un laboratorio");
            txtlaboratorio.requestFocus();
            return;
        }
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un nombre");
            txtnombre.requestFocus();
            return;
        }
        if (txtpresentacion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar una presentacion del producto");
            txtpresentacion.requestFocus();
            return;
        }

        if (txtprecioventa.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el precio");
            txtprecioventa.requestFocus();
            return;
        }

        vfarmacia dts = new vfarmacia();
        ffarmacia func = new ffarmacia();

        dts.setCategoria(txtcategoria.getText());
        dts.setNombre(txtnombre.getText());
        dts.setPrecio_venta(Double.parseDouble(txtprecioventa.getText()));
        dts.setStock(Integer.parseInt(spStock.getValue().toString()));
        dts.setLaboratorio(txtlaboratorio.getText());
        dts.setPresentacion(txtpresentacion.getText());
        dts.setFecha_registro(lblfecharegistro.getText());
        
        Calendar cal;
        int d,m,a;
        cal = dcfechavencimiento.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_vencimiento(new Date(d, m, a));
        
        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El medicamento fue agregado exitosamente");
                mostrar("");
                inhabilitar();

            }

        } else if (accion.equals("editar")) {
            dts.setIdfarmacia(Integer.parseInt(txtidfarmacia.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El medicamento fue agregado exitosamente");
                mostrar("");
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

        txtidfarmacia.setText(tablalistado.getValueAt(fila, 0).toString());
        txtcategoria.setText(tablalistado.getValueAt(fila, 1).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 2).toString());
        txtprecioventa.setText(tablalistado.getValueAt(fila, 3).toString());
        spStock.setValue(Integer.parseInt(tablalistado.getValueAt(fila, 4).toString()));
        txtlaboratorio.setText(tablalistado.getValueAt(fila, 5).toString());
        txtpresentacion.setText(tablalistado.getValueAt(fila, 6).toString());
        lblfecharegistro.setText(tablalistado.getValueAt(fila, 7).toString());
        dcfechavencimiento.setDate(Date.valueOf(tablalistado.getValueAt(fila, 8).toString()));
//        fecha_inicial = lblfecha_registro.getText();
//        fecha_final = lblfecha_registro.getText();

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showInputDialog(Integer.parseInt(mostrar(txtbuscar.getText())));
        String nombre;
        nombre = JOptionPane.showInputDialog("Ingrese el Nombre del medicamento");
        mostrar(nombre);


    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidfarmacia.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de eliminar al trabajador?", "Confirmar", 2);

            if (confirmacion == 0) {
                ftrabajador func = new ftrabajador();
                vtrabajador dts = new vtrabajador();

                dts.setIdtrabajador(Integer.parseInt(txtidfarmacia.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnreportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportesActionPerformed
        // TODO add your handling code here:
        fecha_inicial = JOptionPane.showInputDialog("Ingresa la fecha inicial dia/mes/año");
        fecha_final = JOptionPane.showInputDialog("Ingresa la fecha final dia/mes/año");
        reporte_regadministrativo g = new reporte_regadministrativo();
        g.reportePacientes(fecha_inicial, fecha_final);

    }//GEN-LAST:event_btnreportesActionPerformed

    private void txtpresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpresentacionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 30;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtpresentacion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtpresentacionKeyTyped

    private void txtpresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpresentacionActionPerformed
        // TODO add your handling code here:
        txtpresentacion.transferFocus();
    }//GEN-LAST:event_txtpresentacionActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here
        char c = evt.getKeyChar();
        int limite = 30;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnombre.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
        txtnombre.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtprecioventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioventaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtprecioventaKeyTyped

    private void txtprecioventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioventaActionPerformed
        // TODO add your handling code here:
        txtprecioventa.transferFocus();
    }//GEN-LAST:event_txtprecioventaActionPerformed

    private void txtlaboratorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlaboratorioKeyTyped
        char c = evt.getKeyChar();
        int limite = 34;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtlaboratorio.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtlaboratorioKeyTyped

    private void txtcategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcategoriaKeyTyped
        char c = evt.getKeyChar();
        int limite = 34;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtcategoria.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcategoriaKeyTyped

    private void txtcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategoriaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmfarmacia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnreportes;
    private com.toedter.calendar.JDateChooser dcfechavencimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblfecharegistro;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JSpinner spStock;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtcategoria;
    private javax.swing.JTextField txtidfarmacia;
    private javax.swing.JTextField txtlaboratorio;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecioventa;
    private javax.swing.JTextField txtpresentacion;
    // End of variables declaration//GEN-END:variables
}
