/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vasistenciales;
import Datos.vconstancia_nacimiento;
import Logica.fasistenciales;
import Logica.fconstancia_nacimiento;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reports.reporte_constancia_nacimiento;
import rpimprimir.imprimir_constancia_nacimiento;

/**
 *
 * @author root
 */
public class frmconstancia_nacimiento extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmreg_asistenciales
     */
    String fecha_inicial;
    String fecha_final;
    int num_doc;

    public frmconstancia_nacimiento() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    public String accion = "guardar";

    void fecha_actual_imprimir() {
        int agosto = 8;
        int septiembre = 9;
        int noviembre=11;
        int diciembre=12;
        int enero=01,febrero=02,marzo=03,abril=04,mayo=05,junio=06,julio=07,octubre=10;
        Calendar today = Calendar.getInstance();
        int fhoy_dia = today.get(Calendar.DAY_OF_MONTH);
        int fhoy_mes = today.get(Calendar.MONTH) + 1;
        String mes = null;
        if (fhoy_mes == enero) {
            mes = "Enero";
        } else if (fhoy_mes == febrero) {
            mes = "Febrero";
        } else if (fhoy_mes == marzo) {
            mes = "Marzo";
        } else if (fhoy_mes == abril) {
            mes = "Abril";
        } else if (fhoy_mes == mayo) {
            mes = "Mayo";
        } else if (fhoy_mes == junio) {
            mes = "Junio";
        } else if (fhoy_mes == julio) {
            mes = "Julio";
        } else if (fhoy_mes == agosto) {
            mes = "Agosto";
        } else if (fhoy_mes == septiembre) {
            mes = "Septiembre";
        } else if (fhoy_mes == octubre) {
            mes = "Octubre";
        } else if (fhoy_mes == noviembre) {
            mes = "Noviembre";
        } else if (fhoy_mes == diciembre) {
            mes = "Diciembre";
        }
        int fhoy_year = today.get(Calendar.YEAR);

        lblfecha_registro.setText(fhoy_dia + " de " + mes + " del " + fhoy_year);
    }
     

    void guardar() {
        if (txtcorrelativo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el correlativo");
            txtcorrelativo.requestFocus();
            return;
        }
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el nombre");
            txtnombre.requestFocus();
        }
        if (txtapellidos.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los apellidos");
            txtapellidos.requestFocus();
            return;
        }
        if (txthora_nacimiento.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la hora de nacimiento");
            txthora_nacimiento.requestFocus();
            return;
        }
        if (txtnum_doc.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el numero de documento");
            txtnum_doc.requestFocus();
            return;
        }
        if (txtnum_doc_nacido.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el numero de documento del nacido");
            txtnum_doc_nacido.requestFocus();
            return;
        }
        if (txtpeso.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el peso");
            txtpeso.requestFocus();
        }
        if (txttalla.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la talla");
            txttalla.requestFocus();
        }
        if (txtnum_historia.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el N° de historia");
            txtnum_historia.requestFocus();
        }
        if (txtdireccion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la direccion");
            txtdireccion.requestFocus();
        }
        if (txtiniciales.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar las iniciales del trabajador que realizo el documento");
            txtiniciales.requestFocus();
        }

        vconstancia_nacimiento dts = new vconstancia_nacimiento();
        fconstancia_nacimiento func = new fconstancia_nacimiento();

        dts.setIdcasistenciales(Integer.parseInt(txtidasistenciales.getText()));
        dts.setCorrelativo_constancia(txtcorrelativo.getText());
        dts.setNombre(txtnombre.getText());
        dts.setApellidos(txtapellidos.getText());
        int seleccionado = cbotipo_doc.getSelectedIndex();
        dts.setTipo_doc((String) cbotipo_doc.getItemAt(seleccionado));
        dts.setNum_doc(txtnum_doc.getText());
        dts.setDireccion(txtdireccion.getText());
        dts.setHistoria_clinica(txtnum_historia.getText());
        seleccionado = cbosexo.getSelectedIndex();
        dts.setSexo((String) cbosexo.getItemAt(seleccionado));
        dts.setPeso(txtpeso.getText());
        dts.setTalla(txttalla.getText());

        Calendar cal;
        int d, m, a;
        cal = dcofecha_nacimiento.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_nacimiento(new Date(d, m, a));
        dts.setHora_nacimiento(txthora_nacimiento.getText());
        dts.setNum_doc_nacido(txtnum_doc_nacido.getText());
        dts.setFecha_nacimiento_letra(lblfecha_nacimiento_doc.getText());
        dts.setFecha_registro(lblfecha_registro.getText());
        dts.setIniciales(txtiniciales.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue ingresado exitosamente");
                mostrar("");
                inhabilitar();

            }
        } else if (accion.equals("editar")) {
            dts.setIdconstancia_nacimiento(Integer.parseInt(txtidconstancia_nacimiento.getText()));
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

        tablalistado.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(10).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(12).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(12).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(12).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(13).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(13).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(13).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(14).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(14).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(14).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(17).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(17).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(17).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(18).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(18).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(18).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(19).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(19).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(19).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(20).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(20).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(20).setPreferredWidth(0);

    }

    void inhabilitar() {
        txtidconstancia_nacimiento.setVisible(false);
        txtidasistenciales.setVisible(false);
        lblfecha_nacimiento_doc.setVisible(false);

        txtcorrelativo.setEnabled(false);
        lblnombre_apellidos_asisten.setEnabled(false);
        lblcolegiatura_asisten.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellidos.setEnabled(false);
        dcofecha_nacimiento.setEnabled(false);
        txthora_nacimiento.setEnabled(false);
        cbosexo.setEnabled(false);
        cbotipo_doc.setEnabled(false);
        txtnum_doc.setEnabled(false);
        txtnum_doc_nacido.setEnabled(false);
        txtpeso.setEnabled(false);
        txttalla.setEnabled(false);
        txtnum_historia.setEnabled(false);
        txtdireccion.setEnabled(false);
        lblfecha_registro.setEnabled(false);
        txtiniciales.setEnabled(false);

        btnguardar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnasistencial.setEnabled(false);
        btnimprimir.setEnabled(false);
        btnreportes.setEnabled(false);
        lbltotalregistros.setEnabled(false);

        txtcorrelativo.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        txthora_nacimiento.setText("");
        txtnum_doc.setText("");
        txtnum_doc_nacido.setText("");
        txtpeso.setText("");
        txttalla.setText("");
        txtnum_historia.setText("");
        txtdireccion.setText("");
        lblfecha_registro.setText("");
        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura_asisten.setText("");
        lblfecha_nacimiento_doc.setText("");

    }

    void habilitar() {
        txtidconstancia_nacimiento.setVisible(false);
        txtidasistenciales.setVisible(false);
        lblfecha_nacimiento_doc.setVisible(false);

        lblnombre_apellidos_asisten.setEnabled(true);
        lblcolegiatura_asisten.setEnabled(true);
        txtcorrelativo.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapellidos.setEnabled(true);
        dcofecha_nacimiento.setEnabled(true);
        txthora_nacimiento.setEnabled(true);
        cbosexo.setEnabled(true);
        cbotipo_doc.setEnabled(true);
        txtnum_doc.setEnabled(true);
        txtnum_doc_nacido.setEnabled(true);
        txtpeso.setEnabled(true);
        txttalla.setEnabled(true);
        txtnum_historia.setEnabled(true);
        txtdireccion.setEnabled(true);
        lblfecha_registro.setEnabled(true);
        txtiniciales.setEnabled(true);

        btnguardar.setEnabled(true);
        btnbuscar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnasistencial.setEnabled(true);
        btnimprimir.setEnabled(true);
        btnreportes.setEnabled(true);

        lbltotalregistros.setEnabled(true);

        txtcorrelativo.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        txthora_nacimiento.setText("");
        txtnum_doc.setText("");
        txtnum_doc_nacido.setText("");
        txtpeso.setText("");
        txttalla.setText("");
        txtnum_historia.setText("");
        txtdireccion.setText("");
        txtcorrelativo.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        txthora_nacimiento.setText("");
        txtnum_doc.setText("");
        txtnum_doc_nacido.setText("");
        txtpeso.setText("");
        txttalla.setText("");
        txtnum_historia.setText("");
        txtdireccion.setText("");
        lblfecha_registro.setText("");
        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura_asisten.setText("");
        lblfecha_nacimiento_doc.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fconstancia_nacimiento func = new fconstancia_nacimiento();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error frm_constancia_nacimeinto 01");
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtidasistenciales = new javax.swing.JTextField();
        txtcorrelativo = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cbotipo_doc = new javax.swing.JComboBox<String>();
        txtnum_doc = new javax.swing.JTextField();
        cbosexo = new javax.swing.JComboBox<String>();
        txtpeso = new javax.swing.JTextField();
        txttalla = new javax.swing.JTextField();
        dcofecha_nacimiento = new com.toedter.calendar.JDateChooser();
        txthora_nacimiento = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        lblfecha_nacimiento_doc = new javax.swing.JLabel();
        lblnombre_apellidos_asisten = new javax.swing.JLabel();
        lblcolegiatura_asisten = new javax.swing.JLabel();
        btnasistencial = new javax.swing.JButton();
        txtidconstancia_nacimiento = new javax.swing.JTextField();
        txtnum_doc_nacido = new javax.swing.JTextField();
        lblfecha_registro = new javax.swing.JLabel();
        txtiniciales = new javax.swing.JTextField();
        txtnum_historia = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnreportes = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("C.M.I. Daniel Alcides Carrion - Sistema Automatico de Documentación");

        lbltitulo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbltitulo.setText(".:: CONSTANCIA DE NACIMIENTO ::.");

        jPanel1.setBackground(new java.awt.Color(158, 179, 193));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtcorrelativo.setBackground(new java.awt.Color(158, 179, 193));
        txtcorrelativo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N° Correlativo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtcorrelativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorrelativoKeyTyped(evt);
            }
        });

        txtapellidos.setBackground(new java.awt.Color(158, 179, 193));
        txtapellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos de la Madre:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(158, 179, 193));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbotipo_doc.setBackground(new java.awt.Color(158, 179, 193));
        cbotipo_doc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "PASAPORTE", " " }));
        cbotipo_doc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo Doc.:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtnum_doc.setBackground(new java.awt.Color(158, 179, 193));
        txtnum_doc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N° de Doc.de la Madre:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtnum_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_docActionPerformed(evt);
            }
        });
        txtnum_doc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnum_docKeyTyped(evt);
            }
        });

        cbosexo.setBackground(new java.awt.Color(158, 179, 193));
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino", " " }));
        cbosexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo del Niño:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtpeso.setBackground(new java.awt.Color(158, 179, 193));
        txtpeso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Peso:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtpeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesoActionPerformed(evt);
            }
        });
        txtpeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpesoKeyTyped(evt);
            }
        });

        txttalla.setBackground(new java.awt.Color(158, 179, 193));
        txttalla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Talla:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txttalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttallaActionPerformed(evt);
            }
        });
        txttalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttallaKeyTyped(evt);
            }
        });

        dcofecha_nacimiento.setBackground(new java.awt.Color(158, 179, 193));
        dcofecha_nacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Nac. del Niño:"));
        dcofecha_nacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcofecha_nacimientoPropertyChange(evt);
            }
        });

        txthora_nacimiento.setBackground(new java.awt.Color(158, 179, 193));
        txthora_nacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora Nac del Niño:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txthora_nacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthora_nacimientoKeyTyped(evt);
            }
        });

        txtdireccion.setBackground(new java.awt.Color(158, 179, 193));
        txtdireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion de la Paciente :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dcofecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthora_nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbotipo_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttalla, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(btnguardar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtdireccion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcofecha_nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txthora_nacimiento)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbotipo_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttalla, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnnuevo))
                .addContainerGap())
        );

        txtnombre.setBackground(new java.awt.Color(158, 179, 193));
        txtnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres de la Madre:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        lblfecha_nacimiento_doc.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblnombre_apellidos_asisten.setBackground(new java.awt.Color(158, 179, 193));
        lblnombre_apellidos_asisten.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Obstetra:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        lblcolegiatura_asisten.setBackground(new java.awt.Color(158, 179, 193));
        lblcolegiatura_asisten.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Colegiatura y N°", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        btnasistencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/asistencial.png"))); // NOI18N
        btnasistencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnasistencialActionPerformed(evt);
            }
        });

        txtidconstancia_nacimiento.setText("jTextField1");

        txtnum_doc_nacido.setBackground(new java.awt.Color(158, 179, 193));
        txtnum_doc_nacido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N° Doc del Doctor:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtnum_doc_nacido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_doc_nacidoActionPerformed(evt);
            }
        });
        txtnum_doc_nacido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnum_doc_nacidoKeyTyped(evt);
            }
        });

        lblfecha_registro.setBackground(new java.awt.Color(158, 179, 193));
        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtiniciales.setBackground(new java.awt.Color(158, 179, 193));
        txtiniciales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Iniciales Trabj.:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtiniciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtinicialesActionPerformed(evt);
            }
        });
        txtiniciales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtinicialesKeyTyped(evt);
            }
        });

        txtnum_historia.setBackground(new java.awt.Color(158, 179, 193));
        txtnum_historia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N° Historia:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtnum_historia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_historiaActionPerformed(evt);
            }
        });
        txtnum_historia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnum_historiaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnasistencial, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblnombre_apellidos_asisten, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblcolegiatura_asisten, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtiniciales, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnum_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblfecha_nacimiento_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidasistenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidconstancia_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnum_doc_nacido, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcolegiatura_asisten, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnasistencial))
                            .addComponent(lblnombre_apellidos_asisten, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblfecha_nacimiento_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtidasistenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtidconstancia_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtiniciales, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnum_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnum_doc_nacido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro Constancias", jPanel1);

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablalistadoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/search.png"))); // NOI18N
        btnbuscar.setBorder(new javax.swing.border.MatteBorder(null));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.setBorder(new javax.swing.border.MatteBorder(null));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reporte_2.png"))); // NOI18N
        btnreportes.setBorder(new javax.swing.border.MatteBorder(null));
        btnreportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportesActionPerformed(evt);
            }
        });

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/impresora.png"))); // NOI18N
        btnimprimir.setBorder(new javax.swing.border.MatteBorder(null));
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltotalregistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnimprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnimprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreportes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Listado de Constancias", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltitulo)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1032, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbltitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        fecha_actual_imprimir();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        guardar();

    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        jTabbedPane1.setSelectedIndex(0);
        accion = "editar";
        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidconstancia_nacimiento.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidasistenciales.setText(tablalistado.getValueAt(fila, 1).toString());
        lblnombre_apellidos_asisten.setText(tablalistado.getValueAt(fila, 2).toString());
        lblcolegiatura_asisten.setText(tablalistado.getValueAt(fila, 3).toString());
        txtcorrelativo.setText(tablalistado.getValueAt(fila, 4).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 5).toString());
        txtapellidos.setText(tablalistado.getValueAt(fila, 6).toString());
        cbotipo_doc.setSelectedItem(tablalistado.getValueAt(fila, 7).toString());
        txtnum_doc.setText(tablalistado.getValueAt(fila, 8).toString());
        txtdireccion.setText(tablalistado.getValueAt(fila, 9).toString());
        txtnum_historia.setText(tablalistado.getValueAt(fila, 10).toString());
        cbosexo.setSelectedItem(tablalistado.getValueAt(fila, 11).toString());
        txtpeso.setText(tablalistado.getValueAt(fila, 12).toString());
        txttalla.setText(tablalistado.getValueAt(fila, 13).toString());
        dcofecha_nacimiento.setDate(Date.valueOf(tablalistado.getValueAt(fila, 14).toString()));
        txthora_nacimiento.setText(tablalistado.getValueAt(fila, 15).toString());
        txtnum_doc_nacido.setText(tablalistado.getValueAt(fila, 16).toString());
        lblfecha_nacimiento_doc.setText(tablalistado.getValueAt(fila, 17).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 18).toString());
        txtiniciales.setText(tablalistado.getValueAt(fila, 19).toString());

        num_doc = Integer.parseInt(txtnum_doc.getText());
        fecha_inicial = lblfecha_registro.getText();
        fecha_final = lblfecha_registro.getText();

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String dni;
        dni = JOptionPane.showInputDialog("Ingrese el NºConstancia o Apellidos ");
        mostrar(dni);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidconstancia_nacimiento.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminarlo");
            if (confirmacion == 0) {
                fconstancia_nacimiento func = new fconstancia_nacimiento();
                vconstancia_nacimiento dts = new vconstancia_nacimiento();

                dts.setIdconstancia_nacimiento(Integer.parseInt(txtidconstancia_nacimiento.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtnum_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnum_docActionPerformed

    private void txtpesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesoActionPerformed

    private void txtnum_historiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_historiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnum_historiaActionPerformed

    private void txttallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttallaActionPerformed

    private void dcofecha_nacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcofecha_nacimientoPropertyChange
        // TODO add your handling code here:
        try {
            int fnac_dia = dcofecha_nacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
            int fnac_mes = dcofecha_nacimiento.getCalendar().get(Calendar.MONTH) + 1;
            String mes = null;
            if (fnac_mes == 01) {
                mes = "Enero";
            } else if (fnac_mes == 02) {
                mes = "Febreso";
            } else if (fnac_mes == 03) {
                mes = "Marzo";
            } else if (fnac_mes == 04) {
                mes = "Abril";
            } else if (fnac_mes == 05) {
                mes = "Mayo";
            } else if (fnac_mes == 06) {
                mes = "Junio";
            } else if (fnac_mes == 07) {
                mes = "Julio";
            } else if (fnac_mes == 10) {
                mes = "Octubre";
            } else if (fnac_mes == 11) {
                mes = "Noviembre";
            } else if (fnac_mes == 12) {
                mes = "Diciembre";
            }
            int fnac_year = dcofecha_nacimiento.getCalendar().get(Calendar.YEAR);

            lblfecha_nacimiento_doc.setText(fnac_dia + " de " + mes + " del " + fnac_year);
        } catch (Exception e) {
        }


    }//GEN-LAST:event_dcofecha_nacimientoPropertyChange

    private void btnasistencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnasistencialActionPerformed
        // TODO add your handling code here:
        frmvista_asisten_const_nac from = new frmvista_asisten_const_nac();
        from.toFront();
        from.setVisible(true);
    }//GEN-LAST:event_btnasistencialActionPerformed

    private void btnreportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportesActionPerformed
        // TODO add your handling code here:
        fecha_inicial = JOptionPane.showInputDialog("Ingresa la fecha inicial dia/mes/año");
        fecha_final = JOptionPane.showInputDialog("Ingresa la fecha final dia/mes/año");
        reporte_constancia_nacimiento g = new reporte_constancia_nacimiento();
        g.reportePacientes(fecha_inicial, fecha_final);
    }//GEN-LAST:event_btnreportesActionPerformed

    private void txtinicialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtinicialesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtinicialesActionPerformed

    private void txtcorrelativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorrelativoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 4;
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (txtcorrelativo.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcorrelativoKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 30;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnombre.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 50;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtapellidos.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void txthora_nacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthora_nacimientoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 6;
        if (txthora_nacimiento.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txthora_nacimientoKeyTyped

    private void txtnum_docKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_docKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 8;
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnum_doc.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnum_docKeyTyped

    private void txtnum_doc_nacidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_doc_nacidoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 8;
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnum_doc_nacido.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnum_doc_nacidoKeyTyped

    private void txtpesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 20;

        if (txtpeso.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtpesoKeyTyped

    private void txttallaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttallaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 20;

        if (txttalla.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txttallaKeyTyped

    private void txtnum_historiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_historiaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 10;
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnum_historia.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnum_historiaKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 300;

        if (txtdireccion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtinicialesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtinicialesKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 45;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtiniciales.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtinicialesKeyTyped

    private void tablalistadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoMouseEntered

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        imprimir_constancia_nacimiento gw = new imprimir_constancia_nacimiento();
        gw.imprimir_constancia_nacimiento(num_doc);
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtnum_doc_nacidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_doc_nacidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnum_doc_nacidoActionPerformed

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
            java.util.logging.Logger.getLogger(frmconstancia_nacimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmconstancia_nacimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmconstancia_nacimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmconstancia_nacimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmconstancia_nacimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnasistencial;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnreportes;
    private javax.swing.JComboBox<String> cbosexo;
    private javax.swing.JComboBox<String> cbotipo_doc;
    private com.toedter.calendar.JDateChooser dcofecha_nacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblcolegiatura_asisten;
    private javax.swing.JLabel lblfecha_nacimiento_doc;
    private javax.swing.JLabel lblfecha_registro;
    public static javax.swing.JLabel lblnombre_apellidos_asisten;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcorrelativo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txthora_nacimiento;
    public static javax.swing.JTextField txtidasistenciales;
    private javax.swing.JTextField txtidconstancia_nacimiento;
    private javax.swing.JTextField txtiniciales;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnum_doc;
    private javax.swing.JTextField txtnum_doc_nacido;
    private javax.swing.JTextField txtnum_historia;
    private javax.swing.JTextField txtpeso;
    private javax.swing.JTextField txttalla;
    // End of variables declaration//GEN-END:variables
}
