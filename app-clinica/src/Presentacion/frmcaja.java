/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vcaja;
import Datos.vcertificado_salud;
import Datos.vconsultorio;
import Logica.fcaja;
import Logica.fcertificado_salud;
import Logica.fconsultorio;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class frmcaja extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmreg_asistenciales
     */
    String fecha_inicial;
    String fecha_final;
    int num_doc;

    public frmcaja() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    public String accion = "guardar";
    private String acceso = frmusuariologin.tablalistado.getValueAt(0, 2).toString();

    void fecha_actual() {

        LocalDate fechaactual = LocalDate.now();

        lblfecha_registro.setText(DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(fechaactual));
        LocalDateTime locaDate = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh: mm: ss a", Locale.ENGLISH).format(locaDate));

    }

    void guardar() {

        if (txtcosto_consulta.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el costo de la consulta");
            txtcosto_consulta.requestFocus();
        }
        if (txtidpaciente.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el paciente");
            txtidpaciente.requestFocus();
        }

        vcaja dts = new vcaja();
        fcaja func = new fcaja();

        dts.setIdconsultorio(Integer.parseInt(txtidconsultorio.getText()));
        dts.setIdpaciente(Integer.parseInt(txtidpaciente.getText()));
        dts.setTrabajador(lbltrabajador.getText());
        dts.setCosto_consulta(Double.parseDouble(txtcosto_consulta.getText()));
        dts.setFecha_registro(lblfecha_registro.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue ingresado exitosamente");
                mostrar("");
                inhabilitar();

            }
        } else if (accion.equals("editar")) {
            dts.setIdcaja(Integer.parseInt(txtidcaja.getText()));
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

        tablalistado.getColumnModel().getColumn(12).setMaxWidth(35);
        tablalistado.getColumnModel().getColumn(12).setMinWidth(35);

        tablalistado.getColumnModel().getColumn(14).setMaxWidth(45);
        tablalistado.getColumnModel().getColumn(14).setMinWidth(45);

        tablalistado.getColumnModel().getColumn(8).setMaxWidth(45);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(45);

        tablalistado.getColumnModel().getColumn(6).setMaxWidth(190);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(190);

        tablalistado.getColumnModel().getColumn(7).setMaxWidth(190);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(190);

        tablalistado.getColumnModel().getColumn(3).setMaxWidth(80);
        tablalistado.getColumnModel().getColumn(3).setMinWidth(80);

        tablalistado.getColumnModel().getColumn(4).setMaxWidth(80);
        tablalistado.getColumnModel().getColumn(4).setMinWidth(80);

        tablalistado.getColumnModel().getColumn(5).setMaxWidth(80);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(80);
        
        tablalistado.getColumnModel().getColumn(9).setMaxWidth(50);
        tablalistado.getColumnModel().getColumn(9).setMinWidth(50);
    }

    void inhabilitar() {
        txtidcaja.setVisible(false);
        txtidconsultorio.setVisible(false);
        txtidpaciente.setVisible(false);

        lblhistoriaclinica.setEnabled(false);
        lbltipodoc.setEnabled(false);
        lblnumero_documento.setEnabled(false);
        lblnombreapellidos.setEnabled(false);

        txtbuscarnombre.setEnabled(false);
        lblnombre_apellidos_asisten.setEnabled(false);
        lblcolegiatura.setEnabled(false);
        lblnum_colegiatura.setEnabled(false);
        lblnombre_consultorio.setEnabled(false);
        lblpiso_consultorio.setEnabled(false);
        lblnumero_consultorio.setEnabled(false);
        lbltrabajador.setEnabled(false);
        txtcosto_consulta.setEnabled(false);
        lblfecha_registro.setEnabled(false);

        btnPaciente.setEnabled(false);
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnasistencial.setEnabled(false);
        btnimpresora.setEnabled(false);
        btnreporte.setEnabled(false);
        btnConsumo.setEnabled(false);
        btnPago.setEnabled(false);

        lbltotalregistros.setEnabled(false);

        txtbuscarnombre.setText("");
        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura.setText("");
        lblnum_colegiatura.setText("");
        lblnombre_consultorio.setText("");
        lblpiso_consultorio.setText("");
        lblnumero_consultorio.setText("");
        lbltrabajador.setText("");
        txtcosto_consulta.setText("");
        lblfecha_registro.setText("");

    }

    void habilitar() {
        txtidcaja.setVisible(false);
        txtidconsultorio.setVisible(false);
        txtidpaciente.setVisible(false);

        lblhistoriaclinica.setEnabled(true);
        lbltipodoc.setEnabled(true);
        lblnumero_documento.setEnabled(true);
        lblnombreapellidos.setEnabled(true);

        txtbuscarnombre.setEnabled(true);
        lblnombre_apellidos_asisten.setEnabled(true);
        lblcolegiatura.setEnabled(true);
        lblnum_colegiatura.setEnabled(true);
        lblnombre_consultorio.setEnabled(true);
        lblpiso_consultorio.setEnabled(true);
        lblnumero_consultorio.setEnabled(true);
        lbltrabajador.setEnabled(true);
        txtcosto_consulta.setEnabled(true);
        lblfecha_registro.setEnabled(true);

        btnPaciente.setEnabled(true);
        btnguardar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnasistencial.setEnabled(true);
        btnimpresora.setEnabled(true);
        btnreporte.setEnabled(true);
        btnConsumo.setEnabled(true);
        btnPago.setEnabled(true);

        lbltotalregistros.setEnabled(true);

        txtbuscarnombre.setText("");
        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura.setText("");
        lblnum_colegiatura.setText("");
        lblnombre_consultorio.setText("");
        lblpiso_consultorio.setText("");
        lblnumero_consultorio.setText("");
        lbltrabajador.setText(acceso);
        txtcosto_consulta.setText("");
        lblfecha_registro.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fcaja func = new fcaja();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnasistencial = new javax.swing.JButton();
        lblnombre_apellidos_asisten = new javax.swing.JLabel();
        lblnum_colegiatura = new javax.swing.JLabel();
        lblcolegiatura = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblnombre_consultorio = new javax.swing.JLabel();
        lblpiso_consultorio = new javax.swing.JLabel();
        lbltrabajador = new javax.swing.JLabel();
        lblnumero_consultorio = new javax.swing.JLabel();
        txtcosto_consulta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblnumero_documento = new javax.swing.JLabel();
        lblhistoriaclinica = new javax.swing.JLabel();
        lbltipodoc = new javax.swing.JLabel();
        btnPaciente = new javax.swing.JButton();
        lblnombreapellidos = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        txtidcaja = new javax.swing.JTextField();
        txtidconsultorio = new javax.swing.JTextField();
        btnConsumo = new javax.swing.JButton();
        btnPago = new javax.swing.JButton();
        txtidpaciente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        btnimpresora = new javax.swing.JButton();
        btnreporte = new javax.swing.JButton();
        txtbuscarnombre = new javax.swing.JTextField();
        lblfecha_registro = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("SISTEMA DE GESTION DE PROCESOS");

        jPanel1.setBackground(new java.awt.Color(78, 150, 203));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBackground(new java.awt.Color(78, 150, 203));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Asistencial:"));

        btnasistencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/consultorio.png"))); // NOI18N
        btnasistencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnasistencialActionPerformed(evt);
            }
        });

        lblnombre_apellidos_asisten.setBackground(new java.awt.Color(78, 150, 203));
        lblnombre_apellidos_asisten.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombres y Apelldios del Asistencial:"));

        lblnum_colegiatura.setBackground(new java.awt.Color(78, 150, 203));
        lblnum_colegiatura.setBorder(javax.swing.BorderFactory.createTitledBorder("N° Colegiatura"));

        lblcolegiatura.setBackground(new java.awt.Color(78, 150, 203));
        lblcolegiatura.setBorder(javax.swing.BorderFactory.createTitledBorder("Colegiatura"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblnombre_apellidos_asisten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblcolegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblnum_colegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnasistencial))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblnombre_apellidos_asisten, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblnum_colegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnasistencial, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcolegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel5.setBackground(new java.awt.Color(78, 150, 203));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Consultorio:"));

        lblnombre_consultorio.setBackground(new java.awt.Color(78, 150, 203));
        lblnombre_consultorio.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre del Consultorio"));

        lblpiso_consultorio.setBackground(new java.awt.Color(78, 150, 203));
        lblpiso_consultorio.setBorder(javax.swing.BorderFactory.createTitledBorder("Piso"));

        lbltrabajador.setBackground(new java.awt.Color(78, 150, 203));
        lbltrabajador.setBorder(javax.swing.BorderFactory.createTitledBorder("Operador"));

        lblnumero_consultorio.setBackground(new java.awt.Color(78, 150, 203));
        lblnumero_consultorio.setBorder(javax.swing.BorderFactory.createTitledBorder("N° del Consultorio"));

        txtcosto_consulta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtcosto_consulta.setText("0.00");
        txtcosto_consulta.setBorder(javax.swing.BorderFactory.createTitledBorder("Costo de la Consulta"));
        txtcosto_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcosto_consultaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblnumero_consultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtcosto_consulta))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblpiso_consultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbltrabajador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                        .addComponent(lblnombre_consultorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblnombre_consultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnumero_consultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpiso_consultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcosto_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(78, 150, 203));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente:"));

        lblnumero_documento.setBackground(new java.awt.Color(78, 150, 203));
        lblnumero_documento.setBorder(javax.swing.BorderFactory.createTitledBorder("N° de Documento:"));

        lblhistoriaclinica.setBackground(new java.awt.Color(78, 150, 203));
        lblhistoriaclinica.setBorder(javax.swing.BorderFactory.createTitledBorder("Historia Clinica:"));

        lbltipodoc.setBackground(new java.awt.Color(78, 150, 203));
        lbltipodoc.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Doc.:"));

        btnPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/memo.png"))); // NOI18N
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });

        lblnombreapellidos.setBackground(new java.awt.Color(78, 150, 203));
        lblnombreapellidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre y Apellido del Paciente:"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblhistoriaclinica, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltipodoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblnumero_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblnombreapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPaciente)
                        .addGap(33, 33, 33))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblhistoriaclinica, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbltipodoc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblnumero_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnombreapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPaciente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(78, 150, 203));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones:"));

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

        txtidcaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidcajaActionPerformed(evt);
            }
        });

        btnConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/consumo.png"))); // NOI18N
        btnConsumo.setText("Consumo");
        btnConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsumoActionPerformed(evt);
            }
        });

        btnPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/pagar.png"))); // NOI18N
        btnPago.setText("Pagos");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnConsumo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(txtidconsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtidcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtidconsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnnuevo)
                        .addComponent(btnConsumo)
                        .addComponent(btnPago)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        txtidpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txtidpaciente)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

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

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnimpresora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/impresora.png"))); // NOI18N
        btnimpresora.setText("Imprimir");
        btnimpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimpresoraActionPerformed(evt);
            }
        });

        btnreporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reporte_2.png"))); // NOI18N
        btnreporte.setText("Reporte");
        btnreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteActionPerformed(evt);
            }
        });

        txtbuscarnombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por Consultorio:"));
        txtbuscarnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarnombreKeyReleased(evt);
            }
        });

        lblfecha_registro.setBackground(new java.awt.Color(158, 179, 193));
        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txtbuscarnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnimpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btneliminar)
                        .addComponent(btnimpresora)
                        .addComponent(btnreporte))
                    .addComponent(txtbuscarnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidcaja.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidconsultorio.setText(tablalistado.getValueAt(fila, 1).toString());
        txtidpaciente.setText(tablalistado.getValueAt(fila, 2).toString());
        lblhistoriaclinica.setText(tablalistado.getValueAt(fila, 3).toString());
        lbltipodoc.setText(tablalistado.getValueAt(fila, 4).toString());
        lblnumero_documento.setText(tablalistado.getValueAt(fila, 5).toString());
        lblnombreapellidos.setText(tablalistado.getValueAt(fila, 6).toString());
        lblnombre_apellidos_asisten.setText(tablalistado.getValueAt(fila, 7).toString());
        lblcolegiatura.setText(tablalistado.getValueAt(fila, 8).toString());
        lblnum_colegiatura.setText(tablalistado.getValueAt(fila, 9).toString());
        lblnombre_consultorio.setText(tablalistado.getValueAt(fila, 10).toString());
        lblnumero_consultorio.setText(tablalistado.getValueAt(fila, 11).toString());
        lblpiso_consultorio.setText(tablalistado.getValueAt(fila, 12).toString());
        lbltrabajador.setText(tablalistado.getValueAt(fila, 13).toString());
        txtcosto_consulta.setText(tablalistado.getValueAt(fila, 14).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 15).toString());

//        fecha_inicial = lblfecha_registro.getText();
//        fecha_final = lblfecha_registro.getText();
//        num_doc = Integer.parseInt(lblnum_documento.getText());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidcaja.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminarlo");
            if (confirmacion == 0) {
                fcaja func = new fcaja();
                vcaja dts = new vcaja();

                dts.setIdcaja(Integer.parseInt(txtidcaja.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnasistencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnasistencialActionPerformed
        // TODO add your handling code here:
        frmvista_consultorio_caja from = new frmvista_consultorio_caja();
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

    private void txtidcajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcajaActionPerformed

    private void txtbuscarnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarnombreKeyReleased
        // TODO add your handling code here:
        String buscar = txtbuscarnombre.getText();
        mostrar(buscar);
    }//GEN-LAST:event_txtbuscarnombreKeyReleased

    private void txtcosto_consultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcosto_consultaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcosto_consultaKeyTyped

    private void btnConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsumoActionPerformed
        // TODO add your handling code here:
        int fila = tablalistado.getSelectedRow();
        frmconsumo.idCaja = tablalistado.getValueAt(fila, 0).toString();
        frmconsumo.cliente = tablalistado.getValueAt(fila, 6).toString();

        frmconsumo form = new frmconsumo();
        frminicio.escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnConsumoActionPerformed

    private void txtidpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpacienteActionPerformed

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        // TODO add your handling code here:

        frmvista_paciente_caja from = new frmvista_paciente_caja();
        from.toFront();
        from.setVisible(true);
    }//GEN-LAST:event_btnPacienteActionPerformed

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        // TODO add your handling code here:
        int fila = tablalistado.getSelectedRow();

        frmpago.idcaja = tablalistado.getValueAt(fila, 0).toString();
        frmpago.paciente = tablalistado.getValueAt(fila, 6).toString();
        frmpago.totalcaja = Double.parseDouble(tablalistado.getValueAt(fila, 14).toString());

        frmpago.idconsultorio = tablalistado.getValueAt(fila, 1).toString();
        frmpago.consultorio = tablalistado.getValueAt(fila, 10).toString();

        frmpago form = new frmpago();
        frminicio.escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnPagoActionPerformed

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
            java.util.logging.Logger.getLogger(frmcaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmcaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsumo;
    private javax.swing.JButton btnPaciente;
    private javax.swing.JButton btnPago;
    private javax.swing.JButton btnasistencial;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimpresora;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnreporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblcolegiatura;
    public static javax.swing.JLabel lblfecha_registro;
    public static javax.swing.JLabel lblhistoriaclinica;
    public static javax.swing.JLabel lblnombre_apellidos_asisten;
    public static javax.swing.JLabel lblnombre_consultorio;
    public static javax.swing.JLabel lblnombreapellidos;
    public static javax.swing.JLabel lblnum_colegiatura;
    public static javax.swing.JLabel lblnumero_consultorio;
    public static javax.swing.JLabel lblnumero_documento;
    public static javax.swing.JLabel lblpiso_consultorio;
    public static javax.swing.JLabel lbltipodoc;
    private javax.swing.JLabel lbltotalregistros;
    public static javax.swing.JLabel lbltrabajador;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtbuscarnombre;
    private javax.swing.JTextField txtcosto_consulta;
    private javax.swing.JTextField txtidcaja;
    public static javax.swing.JTextField txtidconsultorio;
    public static javax.swing.JTextField txtidpaciente;
    // End of variables declaration//GEN-END:variables
}
