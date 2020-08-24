/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vcertificado_salud;
import Datos.vconsultorio;
import Logica.fcertificado_salud;
import Logica.fconsultorio;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import reports.reporte_certificado_salud;
import rpimprimir.imprimir_certificado_salud;

/**
 *
 * @author root
 */
public class frmconsultorio extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmreg_asistenciales
     */
    String fecha_inicial;
    String fecha_final;
    int num_doc;

    public frmconsultorio() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    public String accion = "guardar";

    void fecha_actual() {

        LocalDate fechaactual = LocalDate.now();

        lblfecha_registro.setText(DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(fechaactual));

    }

    void guardar() {

        if (txtnombreconsultorio.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el nombre del consultorio");
            txtnombreconsultorio.requestFocus();
        }

        if (txtnumeroconsultorio.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el N° del consultorio");
            txtnumeroconsultorio.requestFocus();
            return;
        }

        vconsultorio dts = new vconsultorio();
        fconsultorio func = new fconsultorio();

        dts.setIdasistencial(Integer.parseInt(txtidasistencial.getText()));
        dts.setNombre_consultorio(txtnombreconsultorio.getText());
        dts.setNumero_consultorio(txtnumeroconsultorio.getText());
        int selecc = cbopiso.getSelectedIndex();
        dts.setPiso_consultorio((String) cbopiso.getItemAt(selecc));
        dts.setFecha_registro(lblfecha_registro.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue ingresado exitosamente");
                mostrar("");
                inhabilitar();

            }
        } else if (accion.equals("editar")) {
            dts.setIdconsultorio(Integer.parseInt(txtidconsultorio.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue editado exitosamente");
                mostrar("");
                inhabilitar();

            }
        }

    }

    void ocultar_columnas() {

        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
//

        tablalistado.getColumnModel().getColumn(2).setMaxWidth(90);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(90);

    }

    void inhabilitar() {
        txtidconsultorio.setVisible(false);
        txtidasistencial.setVisible(false);

        txtnombreconsultorio.setEnabled(false);
        txtnumeroconsultorio.setEnabled(false);
        cbopiso.setEnabled(false);
        lblfecha_registro.setEnabled(false);

        lblnombre_apellidos_asisten.setEnabled(false);
        lblcolegiatura.setEnabled(false);
        lblnum_colegiatura.setEnabled(false);

        btnguardar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnasistencial.setEnabled(false);
        btnimpresora.setEnabled(false);
        btnreporte.setEnabled(false);
        lbltotalregistros.setEnabled(false);

        txtnombreconsultorio.setText("");
        txtnumeroconsultorio.setText("");
        lblfecha_registro.setText("");

        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura.setText("");
        lblnum_colegiatura.setText("");
    }

    void habilitar() {
        txtidconsultorio.setVisible(false);
        txtidasistencial.setVisible(false);

        txtnombreconsultorio.setEnabled(true);
        txtnumeroconsultorio.setEnabled(true);
        cbopiso.setEnabled(true);
        lblfecha_registro.setEnabled(true);

        lblnombre_apellidos_asisten.setEnabled(true);
        lblcolegiatura.setEnabled(true);
        lblnum_colegiatura.setEnabled(true);

        btnguardar.setEnabled(true);
        btnbuscar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnasistencial.setEnabled(true);
        btnimpresora.setEnabled(true);
        btnreporte.setEnabled(true);
        lbltotalregistros.setEnabled(true);

        txtnombreconsultorio.setText("");
        txtnumeroconsultorio.setText("");
        lblfecha_registro.setText("");

        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura.setText("");
        lblnum_colegiatura.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fconsultorio func = new fconsultorio();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR MOSTRAR");
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

        registro = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnasistencial = new javax.swing.JButton();
        lblnombre_apellidos_asisten = new javax.swing.JLabel();
        lblnum_colegiatura = new javax.swing.JLabel();
        lblcolegiatura = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtnombreconsultorio = new javax.swing.JTextField();
        txtnumeroconsultorio = new javax.swing.JTextField();
        lblfecha_registro = new javax.swing.JLabel();
        cbopiso = new javax.swing.JComboBox<>();
        txtidconsultorio = new javax.swing.JTextField();
        txtidasistencial = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnimpresora = new javax.swing.JButton();
        btnreporte = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("SISTEMA DE GESTION DE PROCESOS");

        jPanel1.setBackground(new java.awt.Color(158, 179, 193));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/document_add.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/diskette.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(158, 179, 193));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Asistencial:"));

        btnasistencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/asistencial.png"))); // NOI18N
        btnasistencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnasistencialActionPerformed(evt);
            }
        });

        lblnombre_apellidos_asisten.setBackground(new java.awt.Color(158, 179, 193));
        lblnombre_apellidos_asisten.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombres y Apelldios del Asistencial:"));

        lblnum_colegiatura.setBackground(new java.awt.Color(158, 179, 193));
        lblnum_colegiatura.setBorder(javax.swing.BorderFactory.createTitledBorder("N° Colegiatura"));

        lblcolegiatura.setBackground(new java.awt.Color(158, 179, 193));
        lblcolegiatura.setBorder(javax.swing.BorderFactory.createTitledBorder("Colegiatura"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblnombre_apellidos_asisten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblcolegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(lblnum_colegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnasistencial)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblnombre_apellidos_asisten, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblnum_colegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnasistencial, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcolegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(158, 179, 193));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Pacientes:"));

        txtnombreconsultorio.setBackground(new java.awt.Color(158, 179, 193));
        txtnombreconsultorio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del Consultorio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtnombreconsultorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreconsultorioKeyTyped(evt);
            }
        });

        txtnumeroconsultorio.setBackground(new java.awt.Color(158, 179, 193));
        txtnumeroconsultorio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N° de Consultorio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtnumeroconsultorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumeroconsultorioKeyTyped(evt);
            }
        });

        lblfecha_registro.setBackground(new java.awt.Color(158, 179, 193));
        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        cbopiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        cbopiso.setBorder(javax.swing.BorderFactory.createTitledBorder("Piso:"));
        cbopiso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnombreconsultorio, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtnumeroconsultorio)
                        .addGap(18, 18, 18)
                        .addComponent(cbopiso, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(txtnombreconsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbopiso, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(txtnumeroconsultorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtidconsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidconsultorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtidconsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtidasistencial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(btnnuevo)
                        .addGap(65, 65, 65)
                        .addComponent(btnguardar)
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnnuevo)
                                    .addComponent(btnguardar)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtidconsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtidasistencial, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        registro.addTab("Registro de Consultorio", jPanel1);

        jPanel4.setBackground(new java.awt.Color(88, 170, 168));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
        jScrollPane1.setViewportView(tablalistado);

        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/search.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnimpresora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/impresora.png"))); // NOI18N
        btnimpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimpresoraActionPerformed(evt);
            }
        });

        btnreporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reporte_2.png"))); // NOI18N
        btnreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnimpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnimpresora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreporte))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        registro.addTab("Listado de Consultorios", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registro)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        guardar();

    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("editar");
        habilitar();
        btneliminar.setEnabled(true);
        registro.setSelectedIndex(0);
        accion = "editar";
        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidasistencial.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidasistencial.setText(tablalistado.getValueAt(fila, 1).toString());
        lblnombre_apellidos_asisten.setText(tablalistado.getValueAt(fila, 2).toString());
        lblcolegiatura.setText(tablalistado.getValueAt(fila, 3).toString());
        lblnum_colegiatura.setText(tablalistado.getValueAt(fila, 4).toString());
        txtnombreconsultorio.setText(tablalistado.getValueAt(fila, 5).toString());
        txtnumeroconsultorio.setText(tablalistado.getValueAt(fila, 6).toString());
        cbopiso.setSelectedItem(tablalistado.getValueAt(fila, 7).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 8).toString());
        
//        fecha_inicial = lblfecha_registro.getText();
//        fecha_final = lblfecha_registro.getText();
//        num_doc = Integer.parseInt(lblnum_documento.getText());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String dni;
        dni = JOptionPane.showInputDialog("Ingrese el Nombre del Consultorio");
        mostrar(dni);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidconsultorio.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminarlo");
            if (confirmacion == 0) {
                fconsultorio func = new fconsultorio();
                vconsultorio dts = new vconsultorio();

                dts.setIdconsultorio(Integer.parseInt(txtidconsultorio.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnasistencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnasistencialActionPerformed
        // TODO add your handling code here:
        frmvista_asisten_consultorio from = new frmvista_asisten_consultorio();
        from.toFront();
        from.setVisible(true);
    }//GEN-LAST:event_btnasistencialActionPerformed

    private void btnimpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimpresoraActionPerformed
        // TODO add your handling code here:
        imprimir_certificado_salud gw = new imprimir_certificado_salud();
        gw.reportePacientes(num_doc);

    }//GEN-LAST:event_btnimpresoraActionPerformed

    private void btnreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteActionPerformed
        // TODO add your handling code here:

        fecha_inicial = JOptionPane.showInputDialog("Ingresa la fecha inicial dia/mes/año");
        fecha_final = JOptionPane.showInputDialog("Ingresa la fecha final dia/mes/año");
        reporte_certificado_salud g = new reporte_certificado_salud();
        g.reportePacientes(fecha_inicial, fecha_final);
    }//GEN-LAST:event_btnreporteActionPerformed

    private void txtnumeroconsultorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroconsultorioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 30;
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnumeroconsultorio.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnumeroconsultorioKeyTyped

    private void txtnombreconsultorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreconsultorioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 70;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnombreconsultorio.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreconsultorioKeyTyped

    private void txtidconsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidconsultorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidconsultorioActionPerformed

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
            java.util.logging.Logger.getLogger(frmconsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmconsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmconsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmconsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmconsultorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnasistencial;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimpresora;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnreporte;
    private javax.swing.JComboBox<String> cbopiso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblcolegiatura;
    public static javax.swing.JLabel lblfecha_registro;
    public static javax.swing.JLabel lblnombre_apellidos_asisten;
    public static javax.swing.JLabel lblnum_colegiatura;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTabbedPane registro;
    private javax.swing.JTable tablalistado;
    public static javax.swing.JTextField txtidasistencial;
    private javax.swing.JTextField txtidconsultorio;
    public static javax.swing.JTextField txtnombreconsultorio;
    public static javax.swing.JTextField txtnumeroconsultorio;
    // End of variables declaration//GEN-END:variables
}
