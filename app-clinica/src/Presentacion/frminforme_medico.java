/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vasistenciales;
import Datos.vinforme_medico;
import Logica.fasistenciales;
import Logica.finforme_medico;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rpimprimir.imprimir_informe_medico;
import reports.reporte_informe_medico;

/**
 *
 * @author root
 */
public class frminforme_medico extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmreg_asistenciales
     */
    String fecha_inicial;
    String fecha_final;
    int num_doc;

    public frminforme_medico() {
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
        if (txtnum_doc.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el numero de documento");
            txtnum_doc.requestFocus();
            return;
        }
        if (txtedad.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la edad");
            txtedad.requestFocus();
            return;
        }
        if (txtnum_historia.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el N° Historia");
            txtnum_historia.requestFocus();
        }
        if (txtdiagnostico.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el diagnostico");
            txtdiagnostico.requestFocus();
        }
        if (txtdireccion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la direccion");
            txtdireccion.requestFocus();
        }

        vinforme_medico dts = new vinforme_medico();
        finforme_medico func = new finforme_medico();

        dts.setIdiasistenciales(Integer.parseInt(txtidasistenciales.getText()));
        dts.setCorrelativo_informemedico(txtcorrelativo.getText());
        dts.setNombre_paciente(txtnombre.getText());
        dts.setApellidos_paciente(txtapellidos.getText());
        dts.setHistoria_clinica(txtnum_historia.getText());
        dts.setDireccion(txtdireccion.getText());
        int seleccionado = cbosexo.getSelectedIndex();
        dts.setSexo((String) cbosexo.getItemAt(seleccionado));
        dts.setEdad(txtedad.getText());
        seleccionado = cbotipo_doc.getSelectedIndex();
        dts.setTipo_documento((String) cbotipo_doc.getItemAt(seleccionado));
        dts.setNum_documento(txtnum_doc.getText());
        dts.setFecha_registro(lblfecha_registro.getText());
        dts.setDiagnostico(txtdiagnostico.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue ingresado exitosamente");
                mostrar("");
                inhabilitar();

            }
        } else if (accion.equals("editar")) {
            dts.setIdinforme_medico(Integer.parseInt(txtidinforme_medico.getText()));
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

        tablalistado.getColumnModel().getColumn(14).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(14).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(14).setPreferredWidth(0);

    }

    void inhabilitar() {
        txtidinforme_medico.setVisible(false);
        txtidasistenciales.setVisible(false);

        txtcorrelativo.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellidos.setEnabled(false);
        lblnombre_apellidos_asisten.setEnabled(false);
        lblcolegiatura.setEnabled(false);
        cbosexo.setEnabled(false);
        cbotipo_doc.setEnabled(false);
        txtnum_doc.setEnabled(false);
        txtedad.setEnabled(false);
        txtnum_historia.setEnabled(false);
        txtdiagnostico.setEnabled(false);
        lblfecha_registro.setEnabled(false);
        txtdireccion.setEnabled(false);

        btnguardar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnasistencial.setEnabled(false);
        btnimpresora.setEnabled(false);
        btnreporte.setEnabled(false);
        lbltotalregistros.setEnabled(false);

        txtcorrelativo.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura.setText("");
        txtnum_doc.setText("");
        txtedad.setText("");
        txtnum_historia.setText("");
        txtdiagnostico.setText("");
        lblfecha_registro.setText("");
        txtdireccion.setText("");

    }

    void habilitar() {
        txtidinforme_medico.setVisible(false);
        txtidasistenciales.setVisible(false);

        txtcorrelativo.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapellidos.setEnabled(true);
        lblnombre_apellidos_asisten.setEnabled(true);
        lblcolegiatura.setEnabled(true);
        cbosexo.setEnabled(true);
        cbotipo_doc.setEnabled(true);
        txtnum_doc.setEnabled(true);
        txtedad.setEnabled(true);
        txtnum_historia.setEnabled(true);
        txtdiagnostico.setEnabled(true);
        lblfecha_registro.setEnabled(true);
        txtdireccion.setEnabled(true);

        btnguardar.setEnabled(true);
        btnbuscar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnasistencial.setEnabled(true);
        btnimpresora.setEnabled(true);
        btnreporte.setEnabled(true);
        lbltotalregistros.setEnabled(true);

        txtcorrelativo.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        lblnombre_apellidos_asisten.setText("");
        lblcolegiatura.setText("");
        txtnum_doc.setText("");
        txtedad.setText("");
        txtnum_historia.setText("");
        txtdiagnostico.setText("");
        lblfecha_registro.setText("");
        txtdireccion.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            finforme_medico func = new finforme_medico();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error frmasistencial01");
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
        jPanel3 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        cbotipo_doc = new javax.swing.JComboBox<String>();
        txtnum_doc = new javax.swing.JTextField();
        cbosexo = new javax.swing.JComboBox<String>();
        txtedad = new javax.swing.JTextField();
        txtnum_historia = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblnombre_apellidos_asisten = new javax.swing.JLabel();
        btnasistencial = new javax.swing.JButton();
        lblcolegiatura = new javax.swing.JLabel();
        txtdiagnostico = new javax.swing.JTextField();
        lblfecha_registro = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        txtcorrelativo = new javax.swing.JTextField();
        txtidinforme_medico = new javax.swing.JTextField();
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
        setTitle("C.M.I. Daniel Alcides Carrion - Sistema Automatico de Documentación");

        lbltitulo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbltitulo.setText(".:: INFORME MEDICO ::.");

        jPanel1.setBackground(new java.awt.Color(158, 179, 193));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBackground(new java.awt.Color(158, 179, 193));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente:"));

        txtnombre.setBackground(new java.awt.Color(158, 179, 193));
        txtnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtapellidos.setBackground(new java.awt.Color(158, 179, 193));
        txtapellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });

        cbotipo_doc.setBackground(new java.awt.Color(158, 179, 193));
        cbotipo_doc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "PASAPORTE", " " }));
        cbotipo_doc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtnum_doc.setBackground(new java.awt.Color(158, 179, 193));
        txtnum_doc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numero de Doc.:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
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
        cbosexo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        cbosexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtedad.setBackground(new java.awt.Color(158, 179, 193));
        txtedad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edad:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedadKeyTyped(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtapellidos)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbotipo_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtnum_doc))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtedad))
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtnum_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(txtnum_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnum_doc)
                    .addComponent(cbotipo_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtdireccion.setBackground(new java.awt.Color(158, 179, 193));
        txtdireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(158, 179, 193));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Asistencial:"));

        lblnombre_apellidos_asisten.setBackground(new java.awt.Color(158, 179, 193));
        lblnombre_apellidos_asisten.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre y Apellidos del Asistencial:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        btnasistencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/asistencial.png"))); // NOI18N
        btnasistencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnasistencialActionPerformed(evt);
            }
        });

        lblcolegiatura.setBackground(new java.awt.Color(158, 179, 193));
        lblcolegiatura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Colegiatura:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtdiagnostico.setBackground(new java.awt.Color(158, 179, 193));
        txtdiagnostico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diagnostico:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtdiagnostico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdiagnosticoKeyTyped(evt);
            }
        });

        lblfecha_registro.setBackground(new java.awt.Color(158, 179, 193));
        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

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

        txtcorrelativo.setBackground(new java.awt.Color(158, 179, 193));
        txtcorrelativo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N° Correlativo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtcorrelativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorrelativoKeyTyped(evt);
            }
        });

        txtidinforme_medico.setText("jTextField1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblcolegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtdiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblnombre_apellidos_asisten, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnasistencial, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnnuevo)
                        .addGap(34, 34, 34)
                        .addComponent(btnguardar))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtcorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidinforme_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidasistenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtidinforme_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtidasistenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcorrelativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnombre_apellidos_asisten, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnasistencial, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblcolegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar)
                    .addComponent(btnnuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtdireccion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro de Informes", jPanel1);

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

        btnimpresora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/impresora.png"))); // NOI18N
        btnimpresora.setBorder(new javax.swing.border.MatteBorder(null));
        btnimpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimpresoraActionPerformed(evt);
            }
        });

        btnreporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reporte_2.png"))); // NOI18N
        btnreporte.setBorder(new javax.swing.border.MatteBorder(null));
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnimpresora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(569, Short.MAX_VALUE)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnimpresora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreporte))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listado de Informes", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbltitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
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
        fecha_actual();
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

        txtidinforme_medico.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidasistenciales.setText(tablalistado.getValueAt(fila, 1).toString());
        lblnombre_apellidos_asisten.setText(tablalistado.getValueAt(fila, 2).toString());
        lblcolegiatura.setText(tablalistado.getValueAt(fila, 3).toString());
        txtcorrelativo.setText(tablalistado.getValueAt(fila, 4).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 5).toString());
        txtapellidos.setText(tablalistado.getValueAt(fila, 6).toString());
        txtnum_historia.setText(tablalistado.getValueAt(fila, 7).toString());
        txtdireccion.setText(tablalistado.getValueAt(fila, 8).toString());
        cbosexo.setSelectedItem(tablalistado.getValueAt(fila, 9).toString());
        txtedad.setText(tablalistado.getValueAt(fila, 10).toString());
        cbotipo_doc.setSelectedItem(tablalistado.getValueAt(fila, 11).toString());
        txtnum_doc.setText(tablalistado.getValueAt(fila, 12).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 13).toString());
        txtdiagnostico.setText(tablalistado.getValueAt(fila, 14).toString());
        fecha_inicial = lblfecha_registro.getText();
        fecha_final = lblfecha_registro.getText();
        num_doc = Integer.parseInt(txtnum_doc.getText());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String dni;
        dni = JOptionPane.showInputDialog("Ingrese el nombre, apellido,cargo,dni");
        mostrar(dni);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidinforme_medico.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminarlo");
            if (confirmacion == 0) {
                finforme_medico func = new finforme_medico();
                vinforme_medico dts = new vinforme_medico();

                dts.setIdinforme_medico(Integer.parseInt(txtidinforme_medico.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtnum_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnum_docActionPerformed

    private void txtnum_historiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_historiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnum_historiaActionPerformed

    private void btnasistencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnasistencialActionPerformed
        // TODO add your handling code here:
        frmvista_asisten_inf_medico form = new frmvista_asisten_inf_medico();
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_btnasistencialActionPerformed

    private void btnimpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimpresoraActionPerformed
        // TODO add your handling code here:
        imprimir_informe_medico gw = new imprimir_informe_medico();
        gw.reportePacientes(num_doc);


    }//GEN-LAST:event_btnimpresoraActionPerformed

    private void btnreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteActionPerformed
        fecha_inicial = JOptionPane.showInputDialog("Ingresa la fecha inicial dia/mes/año");
        fecha_final = JOptionPane.showInputDialog("Ingresa la fecha final dia/mes/año");
        reporte_informe_medico g = new reporte_informe_medico();
        g.reportePacientes(fecha_inicial, fecha_final);
    }//GEN-LAST:event_btnreporteActionPerformed

    private void txtcorrelativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorrelativoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 15;
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
        int limite = 20;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnombre.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

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

    private void txtedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 3;
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (txtedad.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtedadKeyTyped

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

    private void txtdiagnosticoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiagnosticoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 30;

        if (txtcorrelativo.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdiagnosticoKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 300;

        if (txtcorrelativo.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 45;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtapellidos.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosKeyTyped

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
            java.util.logging.Logger.getLogger(frminforme_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frminforme_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frminforme_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frminforme_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frminforme_medico().setVisible(true);
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
    private javax.swing.JComboBox<String> cbosexo;
    private javax.swing.JComboBox<String> cbotipo_doc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblcolegiatura;
    private javax.swing.JLabel lblfecha_registro;
    public static javax.swing.JLabel lblnombre_apellidos_asisten;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcorrelativo;
    private javax.swing.JTextField txtdiagnostico;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtedad;
    public static javax.swing.JTextField txtidasistenciales;
    private javax.swing.JTextField txtidinforme_medico;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnum_doc;
    private javax.swing.JTextField txtnum_historia;
    // End of variables declaration//GEN-END:variables
}
