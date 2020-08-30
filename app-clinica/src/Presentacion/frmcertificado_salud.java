/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vcertificado_salud;
import Logica.fcertificado_salud;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import reports.reporte_certificado_salud;
import rpimprimir.imprimir_certificado_salud;

/**
 *
 * @author root
 */
public class frmcertificado_salud extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmreg_asistenciales
     */
    String fecha_inicial;
    String fecha_final;
    int num_doc;

    public frmcertificado_salud() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    public String accion = "guardar";

    void fecha_actual() {
        int agosto=8;
        int septiembre=9;
        Calendar today = Calendar.getInstance();
        int fhoy_dia = today.get(Calendar.DAY_OF_MONTH);
        int fhoy_mes = today.get(Calendar.MONTH) + 1;
        String mes = null;
        if (fhoy_mes == 01) {
            mes = "Enero";
        } else if (fhoy_mes == 02) {
            mes = "Febreso";
        } else if (fhoy_mes == 03) {
            mes = "Marzo";
        } else if (fhoy_mes == 04) {
            mes = "Abril";
        } else if (fhoy_mes == 05) {
            mes = "Mayo";
        } else if (fhoy_mes == 06) {
            mes = "Junio";
        } else if (fhoy_mes == 07) {
            mes = "Julio";
        }else if(fhoy_mes==agosto){
            mes="Agosto";
        }else if(fhoy_mes==septiembre){
            mes="Septiembre";
        }
        else if (fhoy_mes == 10) {
            mes = "Octubre";
        } else if (fhoy_mes == 11) {
            mes = "Noviembre";
        } else if (fhoy_mes == 12) {
            mes = "Diciembre";
        }
        int fhoy_year = today.get(Calendar.YEAR);

        lblfecha_registro.setText(fhoy_dia + " de " + mes + " del " + fhoy_year);
    }

    void guardar() {


        if (txtserologia.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la serologia");
            txtserologia.requestFocus();
            return;
        }
        if (txtexamenrx.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el examen rx");
            txtexamenrx.requestFocus();
        }


        vcertificado_salud dts = new vcertificado_salud();
        fcertificado_salud func = new fcertificado_salud();

        dts.setIdasistenciales(Integer.parseInt(txtidasistenciales.getText()));
        dts.setIdpaciente(Integer.parseInt(txtidpaciente.getText()));
        dts.setSerelogia(txtserologia.getText());
        dts.setExamen_rx(txtexamenrx.getText());
        dts.setFecha_registro(lblfecha_registro.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue ingresado exitosamente");
                mostrar("");
                inhabilitar();

            }
        } else if (accion.equals("editar")) {
            dts.setIdcertificado_salud(Integer.parseInt(txtidcertificado_salud.getText()));
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
        tablalistado.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(11).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(11).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(11).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(12).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(12).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(12).setPreferredWidth(0);

    }

    void inhabilitar() {
        txtidcertificado_salud.setVisible(false);
        txtidasistenciales.setVisible(false);
        txtidpaciente.setVisible(false);

       
        txtserologia.setEnabled(false);
        txtexamenrx.setEnabled(false);

        
        btnpaciente.setEnabled(false);
        btnguardar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnasistencial.setEnabled(false);
        btnimpresora.setEnabled(false);
        btnreporte.setEnabled(false);
        lbltotalregistros.setEnabled(false);

        lblnombre.setText("");
        lblhistoriaclinica.setText("");
        lblapellidos.setText("");
        lbledad.setText("");
        lbltipodoc.setText("");
        lblnum_documento.setText("");
        lbldireccion.setText("");
        
        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura.setText("");
        lblnum_colegiatura.setText("");
        txtserologia.setText("");
        txtexamenrx.setText("");
        lblfecha_registro.setText("");

    }

    void habilitar() {
        txtidcertificado_salud.setVisible(false);
        txtidasistenciales.setVisible(false);
        txtidpaciente.setVisible(false);


        txtserologia.setEnabled(true);
        txtexamenrx.setEnabled(true);


        btnpaciente.setEnabled(true);
        btnguardar.setEnabled(true);
        btnbuscar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnasistencial.setEnabled(true);
        btnimpresora.setEnabled(true);
        btnreporte.setEnabled(true);

        lbltotalregistros.setEnabled(true);

        
        lblnombre.setText("");
        lblhistoriaclinica.setText("");
        lblapellidos.setText("");
        lbledad.setText("");
        lbltipodoc.setText("");
        lblnum_documento.setText("");
        lbldireccion.setText("");
        
        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura.setText("");
        lblnum_colegiatura.setText("");
        txtserologia.setText("");
        txtexamenrx.setText("");
        lblfecha_registro.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fcertificado_salud func = new fcertificado_salud();
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

        lbltitulo = new javax.swing.JLabel();
        registro = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtserologia = new javax.swing.JTextField();
        txtexamenrx = new javax.swing.JTextField();
        lblfecha_registro = new javax.swing.JLabel();
        btnasistencial = new javax.swing.JButton();
        lblnombre_apellidos_asisten = new javax.swing.JLabel();
        lblnum_colegiatura = new javax.swing.JLabel();
        lblcolegiatura = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnpaciente = new javax.swing.JButton();
        lblnombre = new javax.swing.JLabel();
        lblapellidos = new javax.swing.JLabel();
        lbledad = new javax.swing.JLabel();
        lblhistoriaclinica = new javax.swing.JLabel();
        lbldireccion = new javax.swing.JLabel();
        lbltipodoc = new javax.swing.JLabel();
        lblnum_documento = new javax.swing.JLabel();
        txtidpaciente = new javax.swing.JTextField();
        txtidcertificado_salud = new javax.swing.JTextField();
        txtidasistenciales = new javax.swing.JTextField();
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

        lbltitulo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbltitulo.setText("CERTIFICADO DE SALUD");

        jPanel1.setBackground(new java.awt.Color(78, 150, 203));
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

        jPanel3.setBackground(new java.awt.Color(78, 150, 203));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Asistencial:"));

        txtserologia.setEditable(false);
        txtserologia.setBackground(new java.awt.Color(78, 150, 203));
        txtserologia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Serologia:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtserologia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtserologiaKeyTyped(evt);
            }
        });

        txtexamenrx.setEditable(false);
        txtexamenrx.setBackground(new java.awt.Color(78, 150, 203));
        txtexamenrx.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Examen RX:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        txtexamenrx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtexamenrxKeyTyped(evt);
            }
        });

        lblfecha_registro.setBackground(new java.awt.Color(158, 179, 193));
        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

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
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblcolegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblnum_colegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnasistencial))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtexamenrx, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtserologia, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtexamenrx, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtserologia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(78, 150, 203));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Pacientes:"));

        btnpaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/memo.png"))); // NOI18N
        btnpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpacienteActionPerformed(evt);
            }
        });

        lblnombre.setBackground(new java.awt.Color(158, 179, 193));
        lblnombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombres"));

        lblapellidos.setBackground(new java.awt.Color(158, 179, 193));
        lblapellidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellidos"));

        lbledad.setBackground(new java.awt.Color(158, 179, 193));
        lbledad.setBorder(javax.swing.BorderFactory.createTitledBorder("Edad"));

        lblhistoriaclinica.setBackground(new java.awt.Color(158, 179, 193));
        lblhistoriaclinica.setBorder(javax.swing.BorderFactory.createTitledBorder("Historia Clinica"));

        lbldireccion.setBackground(new java.awt.Color(158, 179, 193));
        lbldireccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Direccion"));

        lbltipodoc.setBackground(new java.awt.Color(158, 179, 193));
        lbltipodoc.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Documento"));

        lblnum_documento.setBackground(new java.awt.Color(158, 179, 193));
        lblnum_documento.setBorder(javax.swing.BorderFactory.createTitledBorder("N° Documento"));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblhistoriaclinica, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblapellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lbledad, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(btnpaciente))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbltipodoc, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblnum_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblhistoriaclinica, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbledad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltipodoc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnum_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(lbldireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtidcertificado_salud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidcertificado_saludActionPerformed(evt);
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidcertificado_salud, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnnuevo)
                                .addGap(108, 108, 108)
                                .addComponent(btnguardar))
                            .addComponent(txtidasistenciales, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(90, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidcertificado_salud, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnnuevo)
                                    .addComponent(btnguardar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(txtidasistenciales, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        registro.addTab("Registro de Certificados", jPanel1);

        jPanel4.setBackground(new java.awt.Color(171, 219, 154));
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnimpresora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        registro.addTab("Listado de Certificados", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registro)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltitulo)
                .addGap(345, 345, 345))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleName("");

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

        txtidcertificado_salud.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidasistenciales.setText(tablalistado.getValueAt(fila, 1).toString());
        lblnombre_apellidos_asisten.setText(tablalistado.getValueAt(fila,2).toString());
        lblcolegiatura.setText(tablalistado.getValueAt(fila, 3).toString());
        lblnum_colegiatura.setText(tablalistado.getValueAt(fila, 4).toString());
        txtidpaciente.setText(tablalistado.getValueAt(fila, 5).toString());
        lblhistoriaclinica.setText(tablalistado.getValueAt(fila,6).toString());
        lbltipodoc.setText(tablalistado.getValueAt(fila, 7).toString());
        lblnum_documento.setText(tablalistado.getValueAt(fila, 8).toString());
        lblnombre.setText(tablalistado.getValueAt(fila,9).toString());
        lblapellidos.setText(tablalistado.getValueAt(fila, 10).toString());
        lbledad.setText(tablalistado.getValueAt(fila, 11).toString());
        lbldireccion.setText(tablalistado.getValueAt(fila, 12).toString());
        txtserologia.setText(tablalistado.getValueAt(fila, 13).toString());
        txtexamenrx.setText(tablalistado.getValueAt(fila, 14).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 15).toString());
        fecha_inicial = lblfecha_registro.getText();
        fecha_final = lblfecha_registro.getText();
        num_doc = Integer.parseInt(lblnum_documento.getText());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String dni;
        dni = JOptionPane.showInputDialog("Ingrese el DNI");
        mostrar(dni);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidcertificado_salud.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminarlo");
            if (confirmacion == 0) {
                fcertificado_salud func = new fcertificado_salud();
                vcertificado_salud dts = new vcertificado_salud();

                dts.setIdcertificado_salud(Integer.parseInt(txtidcertificado_salud.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnasistencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnasistencialActionPerformed
        // TODO add your handling code here:
        frmvista_asisten_certi_salud from = new frmvista_asisten_certi_salud();
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

    private void txtserologiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtserologiaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 30;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtserologia.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtserologiaKeyTyped

    private void txtexamenrxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtexamenrxKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 50;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtexamenrx.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtexamenrxKeyTyped

    private void btnpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpacienteActionPerformed
        // TODO add your handling code here:
        
        frmvista_paciente_certi_salud from = new frmvista_paciente_certi_salud();
        from.toFront();
        from.setVisible(true);
    }//GEN-LAST:event_btnpacienteActionPerformed

    private void txtidcertificado_saludActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcertificado_saludActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcertificado_saludActionPerformed

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
            java.util.logging.Logger.getLogger(frmcertificado_salud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcertificado_salud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcertificado_salud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcertificado_salud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new frmcertificado_salud().setVisible(true);
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
    private javax.swing.JButton btnpaciente;
    private javax.swing.JButton btnreporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblapellidos;
    public static javax.swing.JLabel lblcolegiatura;
    public static javax.swing.JLabel lbldireccion;
    public static javax.swing.JLabel lbledad;
    public static javax.swing.JLabel lblfecha_registro;
    public static javax.swing.JLabel lblhistoriaclinica;
    public static javax.swing.JLabel lblnombre;
    public static javax.swing.JLabel lblnombre_apellidos_asisten;
    public static javax.swing.JLabel lblnum_colegiatura;
    public static javax.swing.JLabel lblnum_documento;
    public static javax.swing.JLabel lbltipodoc;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTabbedPane registro;
    private javax.swing.JTable tablalistado;
    public static javax.swing.JTextField txtexamenrx;
    public static javax.swing.JTextField txtidasistenciales;
    private javax.swing.JTextField txtidcertificado_salud;
    public static javax.swing.JTextField txtidpaciente;
    public static javax.swing.JTextField txtserologia;
    // End of variables declaration//GEN-END:variables
}
