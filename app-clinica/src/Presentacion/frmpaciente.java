/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Date;
import Datos.vpaciente;
import Logica.conexion;
import Logica.fpaciente;
import Logica.validarBDD;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javafx.scene.chart.PieChart;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import rpimprimir.impHistoriaClinica;

public class frmpaciente extends javax.swing.JInternalFrame {

    int idhistoriaClinica_modelviewclick;

    public frmpaciente() {
        initComponents();
        mostrar("");
        inhabilitar();
        JOptionPane.showMessageDialog(rootPane, "INGRESE EL N° DNI DEL PACIENTE PARA CREAR UNA NUEVA HISTORIA");
        itemTipoDoc();

        Date hoy = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(hoy);

        txtfecha_nacimiento.setText(fecha);

    }

    private String accion = "guardar";
    private String acceso = frmusuariologin.tablalistado.getValueAt(0, 2).toString();
    private String accionDNI = "validardni";
    private String accionTipoDoc = "";

    void itemTipoDoc() {
        cbotipo_documento.addItem("DNI");
        cbotipo_documento.addItem("PASAPORTE");
        cbotipo_documento.addItem("RECIEN NACIDO");
    }

    void fecha_actual() {

        LocalDate fechaactual = LocalDate.now();

        lblfecha_registro.setText(DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(fechaactual));

    }

    void guardar() {

        if (txthistoria_clinica.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA HISTORIA CLINICA");
            txthistoria_clinica.requestFocus();
            return;
        }

        if (txtnombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA NOMBRE");
            txtnombre.requestFocus();
            return;
        }
        if (txtapellidopaterno.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA APELLIDO PATERNO");
            txtapellidopaterno.requestFocus();
            return;
        }
        if (txtapellidomaterno.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA APELLIDO MATERNO");
            txtapellidomaterno.requestFocus();
            return;
        }

        if (txtdireccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE DIRECCION");
            txtdireccion.requestFocus();
            return;
        }
        if (txtcelular.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE CELULAR");
            txtcelular.requestFocus();
            return;
        }

        if (txtfecha_nacimiento.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE FECHA DE NACIMIENTO");
            txtfecha_nacimiento.requestFocus();
            return;
        }
        if (txtocupacion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE OCUPACION");
            txtocupacion.requestFocus();
            return;
        }
        if (txtlugar_proc.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE LUGAR DE PROCEDENCIA");
            txtlugar_proc.requestFocus();
            return;
        }

        if (lbledad.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE EDAD");
            lbledad.requestFocus();
            return;
        }

        if (lblfecha_registro.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE FECHA DE REGISTRO");
            txtdireccion.requestFocus();
            return;
        }

        vpaciente dts = new vpaciente();
        fpaciente func = new fpaciente();

        dts.setHitoria_clinica(txthistoria_clinica.getText());
        int selecc = cbotipo_documento.getSelectedIndex();
        dts.setTipo_documento((String) cbotipo_documento.getItemAt(selecc));
        dts.setNumero_documento(txtnum_doc.getText());
        dts.setNombres(txtnombre.getText());
        dts.setApellido_paterno(txtapellidopaterno.getText());
        dts.setApellido_materno(txtapellidomaterno.getText());
        
        dts.setDireccion(txtdireccion.getText());
        dts.setCelular(txtcelular.getText());

        dts.setFecha_nacimiento(txtfecha_nacimiento.getText());

        dts.setLugar_proc(txtlugar_proc.getText());
        selecc = cbosexo.getSelectedIndex();
        dts.setSexo((String) cbosexo.getItemAt(selecc));
        dts.setEdad(lbledad.getText());
        selecc = cboestado_civil.getSelectedIndex();
        
        dts.setEstado_civil((String) cboestado_civil.getItemAt(selecc));
        
        dts.setOcupacion(txtocupacion.getText());
        
        dts.setAntecedente_enfermedad(txtantcec_enfermedad.getText());
        
        dts.setAntec_operacion(txtantec_operaciones.getText());
        
        dts.setReacc_medicamento(txtreacc_medicamentos.getText());
        
        dts.setDigitador(lblusuario_acceso.getText());
        
        dts.setFecha_registro(lblfecha_registro.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "HISTORIA CLINICA GUARDADA");
                mostrar("");
                inhabilitarNuevo_Existe();
                //para imprimir con el idhistoriaclinca en el formulario

            }

        } else if (accion.equals("editar")) {
            dts.setIdpaciente(Integer.parseInt(txtidpaciente.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "HISTORIA CLINICA EDITADO");
                mostrar("");
                inhabilitar();

            }
        }
    }

    void ocultar_columnas() {
        //idpaciente
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(9).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(9).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(9).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(10).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(11).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(11).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(11).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(12).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(12).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(12).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(13).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(13).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(13).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(14).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(14).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(14).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(15).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(15).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(15).setPreferredWidth(0);

        //ocupacion
        tablalistado.getColumnModel().getColumn(16).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(16).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(16).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(17).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(17).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(17).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(18).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(18).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(18).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(19).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(19).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(19).setPreferredWidth(0);

    }

    void inhabilitar() {
        txtidpaciente.setVisible(false);

        lblusuario_acceso.setEnabled(false);
        txthistoria_clinica.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellidopaterno.setEnabled(false);
        txtapellidomaterno.setEnabled(false);

        txtantcec_enfermedad.setEnabled(false);
        txtantec_operaciones.setEnabled(false);
        txtreacc_medicamentos.setEnabled(false);
        txtocupacion.setEnabled(false);

        txtdireccion.setEnabled(false);
        txtcelular.setEnabled(false);

        txtfecha_nacimiento.setEnabled(false);
        txtocupacion.setEnabled(false);
        txtlugar_proc.setEnabled(false);
        cbosexo.setEnabled(false);
        lbledad.setEnabled(false);
        lblfecha_registro.setEnabled(false);
        cboestado_civil.setEnabled(false);

        //para validar en la base de datos
        cbotipo_documento.setEnabled(true);
        txtnum_doc.setEnabled(true);

        btnimprimir.setEnabled(false);
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnnuevo.setEnabled(false);

        lblusuario_acceso.setText(acceso);
        txthistoria_clinica.setText("");
        txtnombre.setText("");
        txtapellidopaterno.setText("");
        txtapellidomaterno.setText("");
        txtdireccion.setText("");

        txtfecha_nacimiento.setText("");
        txtocupacion.setText("");
        txtlugar_proc.setText("");
        lbledad.setText("");
        lblfecha_registro.setText("");
        txtnum_doc.setText("");

        txtantcec_enfermedad.setText("");
        txtantec_operaciones.setText("");
        txtreacc_medicamentos.setText("");
        txtocupacion.setText("");

    }

    void inhabilitarNuevo_Existe() {
        txtidpaciente.setVisible(false);

        lblusuario_acceso.setEnabled(true);
        txthistoria_clinica.setEnabled(true);
        txtnombre.setEnabled(false);
        txtapellidopaterno.setEnabled(false);
        txtapellidomaterno.setEnabled(false);

        txtdireccion.setEnabled(false);
        txtcelular.setEnabled(false);

        txtantcec_enfermedad.setEnabled(false);
        txtantec_operaciones.setEnabled(false);
        txtreacc_medicamentos.setEnabled(false);
        txtocupacion.setEnabled(false);

        txtfecha_nacimiento.setEnabled(false);
        txtocupacion.setEnabled(false);
        txtlugar_proc.setEnabled(false);
        cbosexo.setEnabled(false);
        lbledad.setEnabled(false);
        lblfecha_registro.setEnabled(false);
        cboestado_civil.setEnabled(false);
        //para validar en la base de datos
        cbotipo_documento.setEnabled(true);
        txtnum_doc.setEnabled(true);

        btnimprimir.setEnabled(false);
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnnuevo.setEnabled(false);
        lblusuario_acceso.setText(acceso);
    }

    void habilitarCajasTexto() {
        txtidpaciente.setVisible(false);

        lblusuario_acceso.setEnabled(true);
        txthistoria_clinica.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapellidopaterno.setEnabled(true);
        txtapellidomaterno.setEnabled(true);

        txtantcec_enfermedad.setEnabled(true);
        txtantec_operaciones.setEnabled(true);
        txtreacc_medicamentos.setEnabled(true);
        txtocupacion.setEnabled(true);

        txtdireccion.setEnabled(true);
        txtcelular.setEnabled(true);

        txtfecha_nacimiento.setEnabled(true);
        txtocupacion.setEnabled(true);
        txtlugar_proc.setEnabled(true);
        cbosexo.setEnabled(true);
        lbledad.setEnabled(true);
        lblfecha_registro.setEnabled(true);
        cboestado_civil.setEnabled(true);
        cbotipo_documento.setEnabled(true);
        txtnum_doc.setEnabled(true);

        btnimprimir.setEnabled(true);
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(true);
        btnnuevo.setEnabled(true);
        lblusuario_acceso.setText(acceso);
    }

    void habilitar() {

        txtidpaciente.setVisible(false);

        lblusuario_acceso.setEnabled(true);
        txthistoria_clinica.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapellidopaterno.setEnabled(true);
        txtapellidomaterno.setEnabled(true);
        txtdireccion.setEnabled(true);
        txtcelular.setEnabled(true);
        txtfecha_nacimiento.setEnabled(true);
        txtlugar_proc.setEnabled(true);
        cbosexo.setEnabled(true);
        lbledad.setEnabled(true);
        lblfecha_registro.setEnabled(true);
        cboestado_civil.setEnabled(true);
        cbotipo_documento.setEnabled(true);
        txtnum_doc.setEnabled(true);
        
        
        txtantcec_enfermedad.setEnabled(true);
        txtantec_operaciones.setEnabled(true);
        txtreacc_medicamentos.setEnabled(true);
        txtocupacion.setEnabled(true);
        

        btnimprimir.setEnabled(true);
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(true);
        btnnuevo.setEnabled(true);

        lblusuario_acceso.setText(acceso);
        txthistoria_clinica.setText("");
        txtnombre.setText("");
        txtapellidopaterno.setText("");
        txtapellidomaterno.setText("");
        txtdireccion.setText("");
        txtcelular.setText("");

        txtfecha_nacimiento.setText("DD/MM/AAAA");
        txtocupacion.setText("");
        txtlugar_proc.setText("");
        lbledad.setText("");
        lblfecha_registro.setText("");

        txtantcec_enfermedad.setText("");
        txtantec_operaciones.setText("");
        txtreacc_medicamentos.setText("");
        txtocupacion.setText("");

    }

//    private void seleccionarFamiliar() {
//        if (checkselecction.isSelected()) {
//            txtfa_nombres.setEnabled(true);
//            txtfa_apellidos.setEnabled(true);
//            txtfa_edad.setEnabled(true);
//            txtfa_direccion.setEnabled(true);
//        } else if (checkselecction.isSelected() == false) {
//            txtfa_nombres.setEnabled(false);
//            txtfa_apellidos.setEnabled(false);
//            txtfa_edad.setEnabled(false);
//            txtfa_direccion.setEnabled(false);
//        }
//    }
    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fpaciente func = new fpaciente();
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

        jPanel4 = new javax.swing.JPanel();
        btneliminar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnimprimir = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        txtbuscarNombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtidpaciente = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        txtapellidopaterno = new javax.swing.JTextField();
        txtfecha_nacimiento = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        lbledad = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        lblfecha_registro = new javax.swing.JLabel();
        txthistoria_clinica = new javax.swing.JTextField();
        cbosexo = new javax.swing.JComboBox<>();
        cbotipo_documento = new javax.swing.JComboBox();
        txtnum_doc = new javax.swing.JTextField();
        lblusuario_acceso = new javax.swing.JLabel();
        txtlugar_proc = new javax.swing.JTextField();
        txtocupacion = new javax.swing.JTextField();
        cboestado_civil = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtapellidomaterno = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtantcec_enfermedad = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtantec_operaciones = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtreacc_medicamentos = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("CENTRO MEDICO MARIA SANTISIMA");

        jPanel4.setBackground(new java.awt.Color(171, 219, 154));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Pacientes"));

        btneliminar.setBackground(new java.awt.Color(51, 51, 51));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.setMnemonic('E');
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        lbltotalregistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btnimprimir.setBackground(new java.awt.Color(51, 51, 51));
        btnimprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/printer.png"))); // NOI18N
        btnimprimir.setMnemonic('I');
        btnimprimir.setToolTipText("");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        tablalistado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablalistado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
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
        tablalistado.setDragEnabled(true);
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablalistadoMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tablalistado);

        txtbuscarNombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtbuscarNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda por Apellido:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        txtbuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarNombreActionPerformed(evt);
            }
        });
        txtbuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarNombreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtbuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtbuscarNombre)
                    .addComponent(lbltotalregistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(78, 150, 203));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        txtidpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpacienteActionPerformed(evt);
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
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnguardarKeyTyped(evt);
            }
        });

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
        btnnuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnnuevoKeyPressed(evt);
            }
        });

        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        txtapellidopaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtapellidopaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidopaternoActionPerformed(evt);
            }
        });
        txtapellidopaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidopaternoKeyTyped(evt);
            }
        });

        txtfecha_nacimiento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtfecha_nacimiento.setText("00/00/0000");
        txtfecha_nacimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtfecha_nacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfecha_nacimientoActionPerformed(evt);
            }
        });
        txtfecha_nacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfecha_nacimientoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfecha_nacimientoKeyTyped(evt);
            }
        });

        txtcelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcelularActionPerformed(evt);
            }
        });
        txtcelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcelularKeyTyped(evt);
            }
        });

        lbledad.setBackground(new java.awt.Color(255, 255, 255));
        lbledad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbledad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtdireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        lblfecha_registro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txthistoria_clinica.setBackground(new java.awt.Color(149, 103, 113));
        txthistoria_clinica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txthistoria_clinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthistoria_clinicaActionPerformed(evt);
            }
        });
        txthistoria_clinica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txthistoria_clinicaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthistoria_clinicaKeyTyped(evt);
            }
        });

        cbosexo.setBackground(new java.awt.Color(158, 179, 193));
        cbosexo.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO", " " }));
        cbosexo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbotipo_documento.setBackground(new java.awt.Color(205, 201, 147));
        cbotipo_documento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbotipo_documento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbotipo_documento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbotipo_documentoItemStateChanged(evt);
            }
        });
        cbotipo_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_documentoActionPerformed(evt);
            }
        });

        txtnum_doc.setBackground(new java.awt.Color(149, 103, 113));
        txtnum_doc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnum_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_docActionPerformed(evt);
            }
        });
        txtnum_doc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnum_docKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnum_docKeyTyped(evt);
            }
        });

        lblusuario_acceso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtlugar_proc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtlugar_proc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlugar_procActionPerformed(evt);
            }
        });
        txtlugar_proc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlugar_procKeyTyped(evt);
            }
        });

        txtocupacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtocupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtocupacionActionPerformed(evt);
            }
        });
        txtocupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtocupacionKeyTyped(evt);
            }
        });

        cboestado_civil.setBackground(new java.awt.Color(158, 179, 193));
        cboestado_civil.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        cboestado_civil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLTERO", "CASADO", "VIUDO", "CONVIVIENTE" }));
        cboestado_civil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("USUARIO ACCESO:");

        jLabel5.setText("N° DOC:");

        jLabel6.setText("TIPO DOC:");

        jLabel7.setText("N° HISTORIA CLINICA:");

        jLabel8.setText("F. REGISTRO:");

        jLabel9.setText("NOMBRES:");

        jLabel10.setText("APELLIDO PATERNO:");

        jLabel11.setText("DIRECCION:");

        jLabel14.setText("ESTADO CIVIL:");

        jLabel15.setText("OCUPACION:");

        jLabel16.setText("LUGAR. NAC.");

        jLabel17.setText("CEL./TELF.:");

        jLabel21.setText("EDAD:");

        jLabel22.setText("SEXO:");

        jLabel23.setText("FEC. NACIMIENTO:");

        txtapellidomaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtapellidomaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidomaternoActionPerformed(evt);
            }
        });
        txtapellidomaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidomaternoKeyTyped(evt);
            }
        });

        jLabel27.setText("APELLIDO MATERNO:");

        jPanel2.setBackground(new java.awt.Color(78, 150, 203));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Antecedentes del Paciente:"));

        jLabel19.setText("ANTECEDENTE DE ENFERMDAD:");

        txtantcec_enfermedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtantcec_enfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtantcec_enfermedadActionPerformed(evt);
            }
        });
        txtantcec_enfermedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtantcec_enfermedadKeyTyped(evt);
            }
        });

        jLabel20.setText("ANTECEDENTE DE OPERACIONES:");

        txtantec_operaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtantec_operaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtantec_operacionesActionPerformed(evt);
            }
        });
        txtantec_operaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtantec_operacionesKeyTyped(evt);
            }
        });

        jLabel24.setText("REACCIONES AL MEDICAMENTO:");

        txtreacc_medicamentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtreacc_medicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreacc_medicamentosActionPerformed(evt);
            }
        });
        txtreacc_medicamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtreacc_medicamentosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtreacc_medicamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(txtantec_operaciones)
                    .addComponent(txtantcec_enfermedad))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtantcec_enfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtantec_operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtreacc_medicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(lbledad, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbotipo_documento, 0, 121, Short.MAX_VALUE)
                            .addComponent(lblusuario_acceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnuevo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtapellidopaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtapellidomaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthistoria_clinica, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboestado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtlugar_proc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblusuario_acceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnguardar)
                        .addComponent(txtidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnnuevo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbotipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txthistoria_clinica, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellidopaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtapellidomaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboestado_civil, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtlugar_proc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txtfecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(lbledad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Connection connection = new conexion().conectar();
    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:

        if (!txtidpaciente.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿ESTAS SEGURO?", "Confirmar", 2);

            if (confirmacion == 0) {
                fpaciente func = new fpaciente();
                vpaciente dts = new vpaciente();

                dts.setIdpaciente(Integer.parseInt(txtidpaciente.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        impHistoriaClinica imprimirHC = new impHistoriaClinica();
        imprimirHC.ImpHistoriaClinica(idhistoriaClinica_modelviewclick);
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";
        accionDNI = "validarDNI";
        btnguardar.setEnabled(true);

        int fila = tablalistado.rowAtPoint(evt.getPoint());
//        codigo_paciente_dni = Integer.parseInt(txtidpersona.getText());

        txtidpaciente.setText(tablalistado.getValueAt(fila, 0).toString());
        txthistoria_clinica.setText(tablalistado.getValueAt(fila, 1).toString());
        cbotipo_documento.setSelectedItem(tablalistado.getValueAt(fila, 2).toString());
        txtnum_doc.setText(tablalistado.getValueAt(fila, 3).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 4).toString());
        txtapellidopaterno.setText(tablalistado.getValueAt(fila, 5).toString());
        txtapellidomaterno.setText(tablalistado.getValueAt(fila, 6).toString());

        txtdireccion.setText(tablalistado.getValueAt(fila, 7).toString());
        txtcelular.setText(tablalistado.getValueAt(fila, 8).toString());

        txtfecha_nacimiento.setText(tablalistado.getValueAt(fila, 9).toString());
        txtlugar_proc.setText(tablalistado.getValueAt(fila, 10).toString());
        cbosexo.setSelectedItem(tablalistado.getValueAt(fila, 11).toString());
        lbledad.setText(tablalistado.getValueAt(fila, 12).toString());
        cboestado_civil.setSelectedItem(tablalistado.getValueAt(fila, 13).toString());
        txtocupacion.setText(tablalistado.getValueAt(fila, 14).toString());
        txtantcec_enfermedad.setText(tablalistado.getValueAt(fila, 15).toString());
        txtantec_operaciones.setText(tablalistado.getValueAt(fila, 16).toString());
        txtreacc_medicamentos.setText(tablalistado.getValueAt(fila, 17).toString());
        lblusuario_acceso.setText(tablalistado.getValueAt(fila, 18).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 19).toString());

        idhistoriaClinica_modelviewclick = Integer.parseInt(txtidpaciente.getText());


    }//GEN-LAST:event_tablalistadoMouseClicked

    private void tablalistadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoMouseEntered

    private void txtocupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtocupacionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtocupacionKeyTyped

    private void txtocupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtocupacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtocupacionActionPerformed

    private void txtlugar_procKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlugar_procKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtlugar_procKeyTyped

    private void txtlugar_procActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlugar_procActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlugar_procActionPerformed

    private void txtnum_docKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_docKeyTyped

        //codigo para validar dato numero y limitar los digitos.....
        char c = evt.getKeyChar();
        if (accionTipoDoc.equals("dni")) {
            if (!Character.isDigit(c)) {//si es diferente a letra...
                evt.consume();
            }
            if (txtnum_doc.getText().length() == 8) {
                evt.consume();
            }
        } else if (accionTipoDoc.equals("pasaporte")) {

            if (!Character.isDigit(c)) {//si es diferente a letra...
                evt.consume();
            }
            if (txtnum_doc.getText().length() == 10) {
                evt.consume();
            } else if (accionTipoDoc.equals("rec_nacido")) {

            }
        } else {
            if (!Character.isDigit(c)) {//si es diferente a letra...
                evt.consume();
            }
        }

    }//GEN-LAST:event_txtnum_docKeyTyped

    private void txtnum_docKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_docKeyPressed
        // TODO add your handling code here:
        if (accionDNI.equals("validarDNI")) {//validar el dni cuendo el tablemodel envia ValidarDNI
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (txtnum_doc.getText().length() < 8) {
                    JOptionPane.showMessageDialog(rootPane, "INGRESE LOS DIGITOS COMPLETOS DEL DOCUMENTO");
                    txtnum_doc.requestFocus();
                    return;
                }
                validarBDD validar_numero_dni = new validarBDD();
                if (validar_numero_dni.validarDni(txtnum_doc.getText())) {
                    inhabilitar();
                } else {
                    JOptionPane.showMessageDialog(null, "NO CUENTA CON HISTORIA CLINICA, PUEDE CREAR UNA NUEVA HISTORIA CLINICA", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    habilitarCajasTexto();
                }

            }

        } else if (accionDNI.equals("nuevaHistoria")) {//validar dni cuento el boton
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (txtnum_doc.getText().length() < 8) {
                    JOptionPane.showMessageDialog(rootPane, "INGRESE LOS DIGITOS COMPLETOS DEL DOCUMENTODNI");
                    txtnum_doc.requestFocus();
                    return;
                }
                validarBDD validar_numero_dni = new validarBDD();
                if (validar_numero_dni.validarDni(txtnum_doc.getText())) {

                } else {
                    JOptionPane.showMessageDialog(null, "NO CUENTA CON HISTORIA CLINICA, PUEDE CREAR UNA NUEVA HISTORIA CLINICA", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txthistoria_clinica.setEnabled(true);
                }

            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (txtnum_doc.getText().length() < 8) {
                    JOptionPane.showMessageDialog(rootPane, "INGRESE LOS DIGITOS COMPLETOS");
                    txtnum_doc.requestFocus();
                    return;
                }
                validarBDD validar_numero_dni = new validarBDD();
                if (validar_numero_dni.validarDni(txtnum_doc.getText())) {

                } else {
                    JOptionPane.showMessageDialog(null, "NO CUENTA CON HISTORIA CLINICA, PUEDE CREAR UNA NUEVA HISTORIA CLINICA", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txthistoria_clinica.setEnabled(true);
                }

            }

        }
    }//GEN-LAST:event_txtnum_docKeyPressed

    private void txtnum_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_docActionPerformed
        // TODO add your handling code here:
        txtnum_doc.transferFocus();
    }//GEN-LAST:event_txtnum_docActionPerformed

    private void cbotipo_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_documentoActionPerformed
        // TODO add your handling code here:
        cbotipo_documento.transferFocus();
    }//GEN-LAST:event_cbotipo_documentoActionPerformed

    private void txthistoria_clinicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthistoria_clinicaKeyTyped
        char c = evt.getKeyChar();

        int limite = 20;
        if (c < '0' || c > '9') {
            evt.consume();
        }
        if (txthistoria_clinica.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txthistoria_clinicaKeyTyped

    private void txthistoria_clinicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthistoria_clinicaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            validarBDD validar_historia_clinica = new validarBDD();
            if (validar_historia_clinica.validarHistoriaClinica(txthistoria_clinica.getText())) {
//                lblrestaValidarHistoriaClinica.setText(" EL N° DE HISTORIA CLINICA YA EXISTE, POR FAVOR PROBAR CON OTRO NUMERO");
                JOptionPane.showMessageDialog(rootPane, "EL N° DE HISTORIA CLINICA YA EXITE POR FAVOR PROBAR CON OTRO NUMERO", "mensaje", JOptionPane.INFORMATION_MESSAGE);
                inhabilitarNuevo_Existe();
            } else {
                JOptionPane.showMessageDialog(rootPane, " PUEDE CREAR UNA NUEVA HISTORIA CLINICA CON EL N°" + txthistoria_clinica.getText(), "mensaje", JOptionPane.INFORMATION_MESSAGE);
                habilitarCajasTexto();
                btnguardar.setEnabled(true);
                fecha_actual();

            }

        }
    }//GEN-LAST:event_txthistoria_clinicaKeyPressed

    private void txthistoria_clinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthistoria_clinicaActionPerformed

    }//GEN-LAST:event_txthistoria_clinicaActionPerformed

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
        int limite = 256;
        if (txtdireccion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
        txtdireccion.transferFocus();
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txtcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelularKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limiete = 9;
        if (!Character.isDigit(c)) {//si es diferente a letra...
            evt.consume();
        }
        if (txtcelular.getText().length() == limiete) {
            evt.consume();
        }

    }//GEN-LAST:event_txtcelularKeyTyped

    private void txtcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcelularActionPerformed
        // TODO add your handling code here:
        txtcelular.transferFocus();
    }//GEN-LAST:event_txtcelularActionPerformed

    private void txtfecha_nacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 24;
        //        if (Character.isDigit(c)) {
        //            evt.consume();
        //        }
        if (txtfecha_nacimiento.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfecha_nacimientoKeyTyped

    private void txtfecha_nacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoKeyPressed
        try { // ALGORITMO PARA SACAR LA EDAD Y LANZARLO AL LBLEDAD
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                //PARA SACAR LA EDAD A TRAVES DE LA FECHA DE NACIMIENTO           
                DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechamacimineto = LocalDate.parse(txtfecha_nacimiento.getText(), date);
                LocalDate fechaactual = LocalDate.now();

                Period periodo = Period.between(fechamacimineto, fechaactual);
                String resultado = (+periodo.getYears() + " Años " + periodo.getMonths() + " Meses" + " y " + periodo.getDays() + " Dias");

                lbledad.setText(resultado);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE CORRECTAMENTE LA FECHA", "Error de Digitacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtfecha_nacimientoKeyPressed

    private void txtfecha_nacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoActionPerformed
        // TODO add your handling code here:
        txtfecha_nacimiento.transferFocus();
    }//GEN-LAST:event_txtfecha_nacimientoActionPerformed

    private void txtapellidopaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidopaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 100;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtapellidopaterno.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidopaternoKeyTyped

    private void txtapellidopaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidopaternoActionPerformed
        // TODO add your handling code here:
        txtapellidopaterno.transferFocus();
    }//GEN-LAST:event_txtapellidopaternoActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped

        char c = evt.getKeyChar();
        int limiete = 34;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnombre.getText().length() == limiete) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnnuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnnuevoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_N) {
            habilitar();
            btnguardar.setText("Guardar");
            accion = "guardar";
//            checkselecction.setSelected(false);
//            seleccionarFamiliar();

        }
    }//GEN-LAST:event_btnnuevoKeyPressed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:

        inhabilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        accionDNI = "nuevaHistoria";
//        checkselecction.setSelected(false);
//        seleccionarFamiliar();

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyTyped

    }//GEN-LAST:event_btnguardarKeyTyped

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarKeyPressed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtbuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarNombreActionPerformed

    private void txtbuscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarNombreKeyReleased
        // TODO add your handling code here:
        String buscar = txtbuscarNombre.getText();
        mostrar(buscar);
    }//GEN-LAST:event_txtbuscarNombreKeyReleased

    private void txtbuscarNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarNombreKeyTyped

    private void cbotipo_documentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotipo_documentoItemStateChanged
        // TODO add your handling code here:
        String tipodoc = (String) cbotipo_documento.getSelectedItem();
        if (tipodoc.equals("DNI")) {
            txtnum_doc.setText("");
            accionTipoDoc = "dni";

        } else if (tipodoc.equals("PASAPORTE")) {
            txtnum_doc.setText("");
            accionTipoDoc = "pasaporte";

        } else if (tipodoc.equals("RECIEN NACIDO")) {
            txtnum_doc.setText("");
            accionTipoDoc = "rec_naciado";
            txtnum_doc.setText("COLOCAR N°DE HISTORIA");
            JOptionPane.showMessageDialog(rootPane, "REGULARIZAR CUANDO TENGA SU DOCUMENTO DE IDENTIDAD");
        }

    }//GEN-LAST:event_cbotipo_documentoItemStateChanged

    private void txtapellidomaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidomaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidomaternoActionPerformed

    private void txtapellidomaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidomaternoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidomaternoKeyTyped

    private void txtidpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpacienteActionPerformed

    private void txtantcec_enfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtantcec_enfermedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtantcec_enfermedadActionPerformed

    private void txtantcec_enfermedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtantcec_enfermedadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtantcec_enfermedadKeyTyped

    private void txtantec_operacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtantec_operacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtantec_operacionesActionPerformed

    private void txtantec_operacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtantec_operacionesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtantec_operacionesKeyTyped

    private void txtreacc_medicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreacc_medicamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreacc_medicamentosActionPerformed

    private void txtreacc_medicamentosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreacc_medicamentosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreacc_medicamentosKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cboestado_civil;
    private javax.swing.JComboBox<String> cbosexo;
    private javax.swing.JComboBox cbotipo_documento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbledad;
    private javax.swing.JLabel lblfecha_registro;
    private javax.swing.JLabel lbltotalregistros;
    public static javax.swing.JLabel lblusuario_acceso;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtantcec_enfermedad;
    private javax.swing.JTextField txtantec_operaciones;
    private javax.swing.JTextField txtapellidomaterno;
    private javax.swing.JTextField txtapellidopaterno;
    private javax.swing.JTextField txtbuscarNombre;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtfecha_nacimiento;
    private javax.swing.JTextField txthistoria_clinica;
    private javax.swing.JTextField txtidpaciente;
    private javax.swing.JTextField txtlugar_proc;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnum_doc;
    private javax.swing.JTextField txtocupacion;
    private javax.swing.JTextField txtreacc_medicamentos;
    // End of variables declaration//GEN-END:variables
}
