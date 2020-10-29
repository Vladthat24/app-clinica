/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import javax.swing.ImageIcon;
import Datos.vcaja;
import Datos.vcertificado_salud;
import Datos.vconsultorio;
import Datos.vfarmacia;
import Datos.vpago;
import Logica.fcaja;
import Logica.fcertificado_salud;
import Logica.fconsultorio;
import Logica.fconsumo;
import Logica.ffarmacia;
import Logica.fpago;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import reports.reporte_certificado_salud;
import rpimprimir.impPago;
import rpimprimir.imprimir_certificado_salud;

/**
 *
 * @author root
 */
public class frmpago extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmreg_asistenciales
     */
    String fecha_inicial;
    String fecha_final;
    int num_doc;
    int idpago_modelviewclick;

    public frmpago() {
        JOptionPane.showMessageDialog(rootPane, "Verificar bien los datos ingresados,no hay opcion a eliminar el pago una vez efectuado");
        initComponents();
        mostrar(idcaja);
        inhabilitar();
        txtidcaja.setText(idcaja);
        lblpaciente.setText(paciente);
        txtidconsultorio.setText(idconsultorio);
        lblconsultorio.setText(consultorio);
        lbltrabajador.setText(acceso);

        //costo de la consulta
        double igv_consulta = totalcaja * 0.18;
        double totalconsulta = totalcaja + igv_consulta;
        lblcosto_consulta.setText(Double.toString(totalconsulta));

        fconsumo func = new fconsumo();
        func.mostrar(idcaja);

        //SUB TOTAL DEL CONSUMIDO 
        //sin autmentarle el igv en consulta y medicamentos
        lbloperacion_gravada.setText(Double.toString(totalcaja + func.totalconsumo));

    }

    public String accion = "guardar";
    private String acceso = frmusuariologin.tablalistado.getValueAt(0, 3).toString();
    public static String idcaja;
    public static String paciente;
    public static String idconsultorio;
    public static String consultorio;
    public static Double totalcaja;

    void fecha_actual() {

        LocalDate fechaactual = LocalDate.now();

        lblfecha_registro.setText(DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(fechaactual));
        LocalDateTime locaDate = LocalDateTime.now();

        lblhora.setText(DateTimeFormatter.ofPattern("hh: mm: ss a", Locale.ENGLISH).format(locaDate));

    }

    void guardar() {

        if (txtefectivo_recibido.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el efectivo");
            txtefectivo_recibido.requestFocus();
            return;
        }
        if (txtefectivo_recibido.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el efectivo");
            txtefectivo_recibido.requestFocus();
            return;
        }

        vpago dts = new vpago();
        fpago func = new fpago();

        dts.setIdcaja(Integer.parseInt(txtidcaja.getText()));
        int selecc = cbotipocomprobante.getSelectedIndex();
        selecc = cbotipocomprobante.getSelectedIndex();
        dts.setTipo_comprobante((String) cbotipocomprobante.getItemAt(selecc));
        dts.setNum_comprobante(lblnumero_comprobante.getText());
        dts.setIgv(Double.parseDouble(lbligv.getText()));
        dts.setCantidad_pago(Double.parseDouble(txtefectivo_recibido.getText()));
        dts.setSubtotal(Double.parseDouble(lblsub_total.getText()));
        dts.setTotal(Double.parseDouble(lbltotal.getText()));
        dts.setVuelto(Double.parseDouble(lblvuelto.getText()));
        dts.setFecha_registro(lblfecha_registro.getText());
        dts.setHora(lblhora.getText());
        dts.setTrabajador(lbltrabajador.getText());

        if (accion.equals("guardar")) {

            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue ingresado exitosamente");
                mostrar(idcaja);
                inhabilitar();

            }
        } else if (accion.equals("editar")) {
            dts.setIdcaja(Integer.parseInt(txtidcaja.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue editado exitosamente");
                mostrar(idcaja);
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

        tablalistado.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(6).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);

    }

    void ocultar_columnas_consumo() {

        tablalistadoconsumo_pago.getColumnModel().getColumn(0).setMaxWidth(35);
        tablalistadoconsumo_pago.getColumnModel().getColumn(0).setMinWidth(35);
//        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(35);

        tablalistadoconsumo_pago.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoconsumo_pago.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoconsumo_pago.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistadoconsumo_pago.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistadoconsumo_pago.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadoconsumo_pago.getColumnModel().getColumn(2).setPreferredWidth(0);

    }

    void inhabilitar() {
        txtidpago.setVisible(false);
        txtidcaja.setVisible(false);
        txtidconsultorio.setVisible(false);

        lblpaciente.setEnabled(true);
        lblconsultorio.setEnabled(true);
        cbotipocomprobante.setEnabled(false);
        lblnumero_comprobante.setEnabled(false);
        lblcosto_consulta.setEnabled(true);
        txtefectivo_recibido.setEnabled(true);
        lbligv.setEnabled(true);
        lblsub_total.setEnabled(true);
        lbltotal.setEnabled(true);
        lblvuelto.setEnabled(true);
        lbltrabajador.setEnabled(true);
        lblfecha_registro.setEnabled(false);
        lblhora.setEnabled(false);
        lbltotalregistros.setEnabled(false);
        lblconsumo.setEnabled(false);

        btnguardar.setEnabled(false);
        btnimpresora.setEnabled(false);

        lblcosto_consulta.setText("");
        txtefectivo_recibido.setText("");
        lbligv.setText("");
        lblsub_total.setText("");
        lbltotal.setText("");
        lblvuelto.setText("");

    }

    void habilitar() {
        txtidpago.setVisible(false);
        txtidcaja.setVisible(false);
        txtidconsultorio.setVisible(false);

        lblpaciente.setEnabled(true);
        lblconsultorio.setEnabled(true);
        cbotipocomprobante.setEnabled(true);
        lblnumero_comprobante.setEnabled(true);
        lblcosto_consulta.setEnabled(true);
        txtefectivo_recibido.setEnabled(true);
        lbligv.setEnabled(true);
        lblsub_total.setEnabled(true);
        lbltotal.setEnabled(true);
        lblvuelto.setEnabled(true);
        lbltrabajador.setEnabled(true);
        lblfecha_registro.setEnabled(true);
        lblhora.setEnabled(true);
        lbltotalregistros.setEnabled(true);
        lblconsumo.setEnabled(true);

        btnguardar.setEnabled(true);
        btnimpresora.setEnabled(true);

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fpago func = new fpago();
            modelo = func.mostrar(buscar);

//            Generar el N° de Comprobante autogenerado
            DefaultTableModel modelo2;
            fpago func4 = new fpago();
            modelo2 = func4.mostrarTotal("");
            int n_comprobante = func4.totalregistros_total + 1;

            lblnumero_comprobante.setText(String.format("%05d", n_comprobante));

            tablalistado.setModel(modelo);
            ocultar_columnas();

            lbltotalregistros.setText("Total Pagos " + Integer.toString(func.totalregistros));

            //Mostrar los datos de los consumos
            fconsumo func2 = new fconsumo();
            modelo = func2.mostrar(buscar);
            tablalistadoconsumo_pago.setModel(modelo);
            ocultar_columnas_consumo();

            lbltotalregistros.setText("Total Consumos " + func2.totalregistros);

            //COSTO DEL CONSUMO DE LOS MEDICAMENTOS:
            double igv_consumo = func2.totalconsumo * 0.18;
            double consumototal_con_igv = func2.totalconsumo + igv_consumo;
            lblconsumo.setText("Consumo de Medicamentos : S/." + consumototal_con_igv);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
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
        jPanel2 = new javax.swing.JPanel();
        lblnumero_comprobante = new javax.swing.JLabel();
        lblpaciente = new javax.swing.JLabel();
        lblconsultorio = new javax.swing.JLabel();
        txtefectivo_recibido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbligv = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblsub_total = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblvuelto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblcosto_consulta = new javax.swing.JLabel();
        cbotipocomprobante = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtidpago = new javax.swing.JTextField();
        txtidconsultorio = new javax.swing.JTextField();
        txtidcaja = new javax.swing.JTextField();
        lbloperacion_gravada = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbltrabajador = new javax.swing.JLabel();
        lblfecha_registro = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        lbltotalregistros = new javax.swing.JLabel();
        lblconsumo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btnimpresora = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistadoconsumo_pago = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("CENTRO MEDICO MARIA SANTISIMA");

        jPanel1.setBackground(new java.awt.Color(78, 150, 203));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(78, 150, 203));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle del Pago:"));

        lblnumero_comprobante.setBackground(new java.awt.Color(78, 150, 203));
        lblnumero_comprobante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnumero_comprobante.setBorder(javax.swing.BorderFactory.createTitledBorder("N° de Comprobante:"));

        lblpaciente.setBackground(new java.awt.Color(78, 150, 203));
        lblpaciente.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre del Paciente:"));

        lblconsultorio.setBackground(new java.awt.Color(78, 150, 203));
        lblconsultorio.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultorio:"));

        txtefectivo_recibido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtefectivo_recibido.setText("0.00");
        txtefectivo_recibido.setBorder(new javax.swing.border.MatteBorder(null));
        txtefectivo_recibido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtefectivo_recibidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtefectivo_recibidoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("IGV:");

        lbligv.setBackground(new java.awt.Color(255, 255, 255));
        lbligv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbligv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setText("Efectivo Recibido:");

        lblsub_total.setBackground(new java.awt.Color(255, 255, 255));
        lblsub_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblsub_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setText("Operacion Gravada: ");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setText("Total:");

        lbltotal.setBackground(new java.awt.Color(255, 255, 255));
        lbltotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setText("Vuelto:");

        lblvuelto.setBackground(new java.awt.Color(255, 255, 255));
        lblvuelto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblvuelto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setText("Costo de Consulta:");

        lblcosto_consulta.setBackground(new java.awt.Color(255, 255, 255));
        lblcosto_consulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcosto_consulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbotipocomprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura" }));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Tipo de Comprobante:");

        txtidpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpagoActionPerformed(evt);
            }
        });

        txtidcaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidcajaActionPerformed(evt);
            }
        });

        lbloperacion_gravada.setBackground(new java.awt.Color(255, 255, 255));
        lbloperacion_gravada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbloperacion_gravada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setText("Sub Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbloperacion_gravada, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblconsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addGap(53, 53, 53)
                                                        .addComponent(lblcosto_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLabel5)
                                                            .addComponent(jLabel1)
                                                            .addComponent(jLabel2))
                                                        .addGap(53, 53, 53)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(lbligv, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtefectivo_recibido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblsub_total, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(lblvuelto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGap(1, 1, 1))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbotipocomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblnumero_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtidconsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtidcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidconsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidcaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblconsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbotipocomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblnumero_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblcosto_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtefectivo_recibido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbligv, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblsub_total, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbloperacion_gravada, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblvuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/diskette.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/document_add.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnnuevo))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(171, 219, 154));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel6.setBackground(new java.awt.Color(78, 150, 203));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles:"));

        lbltrabajador.setBackground(new java.awt.Color(78, 150, 203));
        lbltrabajador.setBorder(javax.swing.BorderFactory.createTitledBorder("Operador"));

        lblfecha_registro.setBackground(new java.awt.Color(78, 150, 203));
        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Registro:"));

        lblhora.setBackground(new java.awt.Color(78, 150, 203));
        lblhora.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora:"));

        lbltotalregistros.setBackground(new java.awt.Color(93, 173, 170));
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        lblconsumo.setBackground(new java.awt.Color(93, 173, 170));
        lblconsumo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Costo Total:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblhora, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbltrabajador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(lblconsumo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltotalregistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblhora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jScrollPane2.setViewportView(tablalistado);

        btnimpresora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/impresora.png"))); // NOI18N
        btnimpresora.setText("Imprimir");
        btnimpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimpresoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnimpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnimpresora)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(171, 219, 154));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de Consumos:"));

        tablalistadoconsumo_pago.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablalistadoconsumo_pago.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistadoconsumo_pago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoconsumo_pagoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistadoconsumo_pago);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
    void actualizarStock() {

        int id, cant;
        int valorTabla = tablalistadoconsumo_pago.getRowCount();

        if (valorTabla == 0) {
            guardar();
        } else {
            for (int i = 0; i < tablalistadoconsumo_pago.getRowCount(); i++) {
                ffarmacia f = new ffarmacia();
                vfarmacia v = new vfarmacia();
                id = Integer.parseInt(tablalistadoconsumo_pago.getValueAt(i, 2).toString());
                cant = Integer.parseInt(tablalistadoconsumo_pago.getValueAt(i, 4).toString());
//            System.out.println("ID del Medicamento:" + id);
//            System.out.println("Cantidad del Consumo:" + cant);
//            System.out.println("ITEM :" + i);
//            System.out.println("ITEM :" + tablalistadoconsumo_pago.getRowCount());

                DefaultTableModel modelo;
                modelo = f.mostrarID(id);
                int stock_actual = Integer.parseInt(modelo.getValueAt(0, 4).toString());
                String nombre_medicamento = modelo.getValueAt(0, 2).toString();

                if (stock_actual == 0) {
                    JOptionPane.showMessageDialog(rootPane, "No cuenta Stock");
                    return;
                }
                if (stock_actual < cant) {
                    JOptionPane.showMessageDialog(rootPane, "Se cuenta con " + stock_actual + " " + nombre_medicamento + " en Almacen");
                    return;
                }

                int sa = stock_actual - cant;
                f.actualizarStock(sa, id);

            }
            guardar();
        }
    }
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        actualizarStock();


    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoconsumo_pagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoconsumo_pagoMouseClicked
        // TODO add your handling code here:
//        fecha_inicial = lblfecha_registro.getText();
//        fecha_final = lblfecha_registro.getText();
//        num_doc = Integer.parseInt(lblnum_documento.getText());
    }//GEN-LAST:event_tablalistadoconsumo_pagoMouseClicked

    private void txtidcajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcajaActionPerformed

    private void txtefectivo_recibidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtefectivo_recibidoKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtefectivo_recibidoKeyTyped

    private void txtidpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpagoActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("editar");
        habilitar();
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidpago.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidcaja.setText(tablalistado.getValueAt(fila, 1).toString());
        cbotipocomprobante.setSelectedItem(tablalistado.getValueAt(fila, 2).toString());
        lblnumero_comprobante.setText(tablalistado.getValueAt(fila, 3).toString());
        lbligv.setText(tablalistado.getValueAt(fila, 4).toString());
        txtefectivo_recibido.setText(tablalistado.getValueAt(fila, 5).toString());
        lblsub_total.setText(tablalistado.getValueAt(fila, 6).toString());
        lbltotal.setText(tablalistado.getValueAt(fila, 7).toString());
        lblvuelto.setText(tablalistado.getValueAt(fila, 8).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 9).toString());
        lblhora.setText(tablalistado.getValueAt(fila, 10).toString());
        lbltrabajador.setText(tablalistado.getValueAt(fila, 11).toString());

        idpago_modelviewclick = Integer.parseInt(txtidpago.getText());
        System.out.println("ID PAGO " + idpago_modelviewclick);
    }//GEN-LAST:event_tablalistadoMouseClicked
    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double middleHeight = 8.0;
        double headerHeight = 2.0;
        double footerHeight = 2.0;
        double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
        double height = convert_CM_To_PPI(headerHeight + middleHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(
                0,
                10,
                width,
                height - convert_CM_To_PPI(1)
        );   //define boarder size    after that print area width is about 180 points

        pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
        pf.setPaper(paper);

        return pf;
    }

    protected static double convert_CM_To_PPI(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }

    public class BillPrintable implements Printable {

        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                throws PrinterException {

            ImageIcon icon = new ImageIcon("C:\\Users\\Desarrollo\\Documents\\GitHub\\app-clinica\\app-clinica\\src\\Files\\icono-soloII.png");

            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {

                Graphics2D g2d = (Graphics2D) graphics;

                double width = pageFormat.getImageableWidth();

                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

                ////////// code by alqama//////////////
                FontMetrics metrics = g2d.getFontMetrics(new Font("Arial", Font.BOLD, 4));
                //    int idLength=metrics.stringWidth("000000");
                //int idLength=metrics.stringWidth("00");
                int idLength = metrics.stringWidth("000");
                int amtLength = metrics.stringWidth("000000");
                int qtyLength = metrics.stringWidth("00000");
                int priceLength = metrics.stringWidth("000000");
                int prodLength = (int) width - idLength - amtLength - qtyLength - priceLength - 17;

                //    int idPosition=0;
                //    int productPosition=idPosition + idLength + 2;
                //    int pricePosition=productPosition + prodLength +10;
                //    int qtyPosition=pricePosition + priceLength + 2;
                //    int amtPosition=qtyPosition + qtyLength + 2;
                int productPosition = 0;
                int discountPosition = prodLength + 5;
                int pricePosition = discountPosition + idLength + 10;
                int qtyPosition = pricePosition + priceLength + 4;
                int amtPosition = qtyPosition + qtyLength;

                try {
                    /*Draw Header*/
                    int y = 10;//20
                    int yShift = 5;//10
                    int headerRectHeight = 7;//15
                    int headerRectHeighta = 20;//40

                    ///////////////// PRODUCT NAMES GET FROM THE TABLE PAGO ID///////////
                    fpago f = new fpago();
                    vpago v = new vpago();

                    DefaultTableModel modelo;
                    modelo = f.mostrarReporte(idpago_modelviewclick);
                    String idpago, nombre, apellidos, colegiatura, num_colegiatura,
                            profesion, tipo_documento, num_documento, nombre_consultorio,
                            numero_consultorio, piso_consultorio, idpaciente,
                            historia_clinica, tipo_doc, numero_doc,
                            nombres, apellidosp, apellidosm, costo_consulta,
                            tipo_comprobante, num_comprobante, igv, cantidad_pago,
                            subtotal, total, vuelto, hora, fecha_registro, trabajador;

                    idpago = (String) modelo.getValueAt(0, 0);
                    nombre = (String) modelo.getValueAt(0, 1);
                    apellidos = (String) modelo.getValueAt(0, 2);
                    colegiatura = (String) modelo.getValueAt(0, 3);
                    num_colegiatura = (String) modelo.getValueAt(0, 4);
                    profesion = (String) modelo.getValueAt(0, 5);
                    tipo_documento = (String) modelo.getValueAt(0, 6);
                    num_documento = (String) modelo.getValueAt(0, 7);
                    nombre_consultorio = (String) modelo.getValueAt(0, 8);
                    numero_consultorio = (String) modelo.getValueAt(0, 9);
                    piso_consultorio = (String) modelo.getValueAt(0, 10);

                    idpaciente = (String) modelo.getValueAt(0, 11);
                    historia_clinica = (String) modelo.getValueAt(0, 12);
                    tipo_doc = (String) modelo.getValueAt(0, 13);
                    numero_doc = (String) modelo.getValueAt(0, 14);
                    nombres = (String) modelo.getValueAt(0, 15);
                    apellidosp = (String) modelo.getValueAt(0, 16);
                    apellidosm = (String) modelo.getValueAt(0, 17);

                    costo_consulta = (String) modelo.getValueAt(0, 18);
                    tipo_comprobante = (String) modelo.getValueAt(0, 19);
                    num_comprobante = (String) modelo.getValueAt(0, 20);
                    igv = (String) modelo.getValueAt(0, 21);
                    cantidad_pago = (String) modelo.getValueAt(0, 22);
                    subtotal = (String) modelo.getValueAt(0, 23);
                    total = (String) modelo.getValueAt(0, 24);
                    vuelto = (String) modelo.getValueAt(0, 25);

                    fecha_registro = (String) modelo.getValueAt(0, 26);
                    hora = (String) modelo.getValueAt(0, 27);
                    trabajador = (String) modelo.getValueAt(0, 28);

//                    String pn1a = pn1.getText();
//                    String pn2a = pn2.getText();
//                    String pn3a = pn3.getText();
//                    String pn4a = pn4.getText();
                    ///////////////// Product names Get ///////////
                    ///////////////// Product price Get ///////////
//                    int pp1a = Integer.valueOf(pp1.getText());
//                    int pp2a = Integer.valueOf(pp2.getText());
//                    int pp3a = Integer.valueOf(pp3.getText());
//                    int pp4a = Integer.valueOf(pp4.getText());
//                    int sum = pp1a + pp2a + pp3a + pp4a;
                    ///////////////// Product price Get ///////////
                    g2d.setFont(new Font("Monospaced", Font.PLAIN, 5));
                    g2d.drawImage(icon.getImage(), 20, 1, 20, 20, rootPane);
                    y += yShift;
                    g2d.drawString("------------------------", 5, y);
                    y += yShift;
                    g2d.drawString("   CENTRO MEDICO      ", 5, y);
                    y += yShift;
                    g2d.drawString("   SANTA SANTISIMA    ", 5, y);
                    y += yShift;
                    g2d.drawString("------------------------", 5, y);
                    y += headerRectHeight;
                    g2d.drawString("Tipo Comprb.: " + tipo_comprobante + "", 5, y);
                    y += yShift;
                    g2d.drawString("N° Comprb.: " + num_comprobante + "", 5, y);
                    y += yShift;
                    g2d.drawString("------------------------", 5, y);
                    y += yShift;
                    g2d.drawString("Datos del Paciente:                  ", 5, y);
                    y += yShift;
                    g2d.drawString("H.C.: N° " + historia_clinica + " ", 5, y);
                    y += yShift;
                    g2d.drawString("Nombre: " + nombres + "              ", 5, y);
                    y += yShift;
                    g2d.drawString("Apell.:" + apellidosp + " " + apellidosm + "", 5, y);
                    y += yShift;
                    g2d.drawString("Tipo Doc: " + tipo_doc + "   ", 5, y);
                    y += yShift;
                    g2d.drawString("N° Doc: " + numero_doc + "    ", 5, y);
                    y += yShift;
                    g2d.drawString("------------------------", 5, y);
                    y += yShift;
                    g2d.drawString("Datos del Consumo: ", 5, y);
                    y += yShift;
                    g2d.drawString("Consulta:" + costo_consulta + " ", 5, y);
                    y += yShift;
                    g2d.drawString("Igv:" + igv + "     ", 5, y);
                    y += yShift;
                    g2d.drawString("Efec.Recib.:" + cantidad_pago + "", 5, y);
                    y += yShift;
                    g2d.drawString("Subtotal:" + subtotal + "   ", 5, y);
                    y += yShift;
                    g2d.drawString("Total:" + total + "          ", 5, y);
                    y += yShift;
                    g2d.drawString("Vuelto:" + vuelto + "        ", 5, y);
                    y += yShift;
                    g2d.drawString("------------------------", 5, y);
                    y += yShift;
                    g2d.drawString("Fecha:" + fecha_registro + " ", 5, y);
                    y += yShift;
                    g2d.drawString("Hora:" + hora + "            ", 5, y);
                    y += yShift;
                    g2d.drawString("Operador:" + trabajador + "  ", 5, y);
                    y += yShift;
                    g2d.drawString("*********************", 5, y);
                    y += yShift;
                    g2d.drawString("GRACIAS POR SU VISITA", 5, y);
                    y += yShift;
                    g2d.drawString("*********************", 5, y);
                    y += yShift;

//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
                } catch (Exception r) {
                    r.printStackTrace();
                }

                result = PAGE_EXISTS;
            }
            return result;
        }
    }

    private void btnimpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimpresoraActionPerformed
        //RTTODO add your handling code here:
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(), getPageFormat(pj));
        try {
            pj.print();

        } catch (PrinterException ex) {
            ex.printStackTrace();
        }

//        fpago f = new fpago();
//        vpago v = new vpago();
//
//        DefaultTableModel modelo;
//        modelo = f.mostrarReporte(idpago_modelviewclick);
//        String idpago, nombre, apellidos, colegiatura, num_colegiatura,
//                profesion, tipo_documento, num_documento, nombre_consultorio,
//                numero_consultorio, piso_consultorio, idpaciente,
//                historia_clinica, tipo_doc, numero_doc,
//                nombres, apellidosp, apellidosm, costo_consulta,
//                tipo_comprobante, num_comprobante, igv, cantidad_pago,
//                subtotal, total, vuelto, hora, fecha_registro, trabajador;
//
//        idpago = (String) modelo.getValueAt(0, 0);
//        nombre = (String) modelo.getValueAt(0, 1);
//        apellidos = (String) modelo.getValueAt(0, 2);
//        colegiatura = (String) modelo.getValueAt(0, 3);
//        num_colegiatura = (String) modelo.getValueAt(0, 4);
//        profesion = (String) modelo.getValueAt(0, 5);
//        tipo_documento = (String) modelo.getValueAt(0, 6);
//        num_documento = (String) modelo.getValueAt(0, 7);
//        nombre_consultorio = (String) modelo.getValueAt(0, 8);
//        numero_consultorio = (String) modelo.getValueAt(0, 9);
//        piso_consultorio = (String) modelo.getValueAt(0, 10);
//
//        idpaciente = (String) modelo.getValueAt(0, 11);
//        historia_clinica = (String) modelo.getValueAt(0, 12);
//        tipo_doc = (String) modelo.getValueAt(0, 13);
//        numero_doc = (String) modelo.getValueAt(0, 14);
//        nombres = (String) modelo.getValueAt(0, 15);
//        apellidosp = (String) modelo.getValueAt(0, 16);
//
//        apellidosm = (String) modelo.getValueAt(0, 17);
//        costo_consulta = (String) modelo.getValueAt(0, 18);
//        tipo_comprobante = (String) modelo.getValueAt(0, 19);
//        num_comprobante = (String) modelo.getValueAt(0, 20);
//        igv = (String) modelo.getValueAt(0, 21);
//        cantidad_pago = (String) modelo.getValueAt(0, 22);
//
//        subtotal = (String) modelo.getValueAt(0, 23);
//        total = (String) modelo.getValueAt(0, 24);
//        vuelto = (String) modelo.getValueAt(0, 25);
//
//        fecha_registro = (String) modelo.getValueAt(0, 26);
//        hora = (String) modelo.getValueAt(0, 27);
//        trabajador = (String) modelo.getValueAt(0, 28);
//
//        System.out.println("Id pago" + idpago);
//        System.out.println("Id pago" + nombre);
//        System.out.println("Id pago" + apellidos);
//        System.out.println("Id pago" + colegiatura);
//        System.out.println("Id pago" + num_colegiatura);
//        System.out.println("Id pago" + profesion);
//        System.out.println("Id pago" + tipo_documento);
//        System.out.println("Id pago" + num_documento);
//        System.out.println("Id pago" + nombre_consultorio);
//        System.out.println("Id pago" + numero_consultorio);
//        System.out.println("Id pago" + piso_consultorio);
//        System.out.println("Id pago" + idpaciente);
//        System.out.println("Id pago" + historia_clinica);
//        System.out.println("Id pago" + tipo_doc);
//        System.out.println("Id pago" + numero_doc);
//        System.out.println("Id pago" + nombres);
//        System.out.println("Id pago" + apellidosp);
//        System.out.println("Id pago" + apellidosm);
//        System.out.println("Id pago" + costo_consulta);
//        System.out.println("Id pago" + tipo_comprobante);
//        System.out.println("Id pago" + num_comprobante);
//        System.out.println("Id pago" + igv);
//        System.out.println("Id pago" + cantidad_pago);
//        System.out.println("Id pago" + subtotal);
//        System.out.println("Id pago" + total);
//        System.out.println("Id pago" + vuelto);
//        System.out.println("Id pago" + fecha_registro);
//        System.out.println("Id pago" + hora);
//        System.out.println("Id pago" + trabajador);

    }//GEN-LAST:event_btnimpresoraActionPerformed

    private void txtefectivo_recibidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtefectivo_recibidoKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            //SACAR EL IGV DE UN MONTO = TOTAL/1.18;

            double subtotal = 0, efectivo_recibido = 0, igv = 0, total = 0, vuelto = 0;

            subtotal = Double.parseDouble(lbloperacion_gravada.getText());
            efectivo_recibido = Double.parseDouble(txtefectivo_recibido.getText());

            igv = Math.round((subtotal * 0.18) * 100) / 100d;

            total = Math.round((subtotal + igv) * 100) / 100d;

            if (efectivo_recibido < total) {
                JOptionPane.showMessageDialog(rootPane, "El Monto Ingresado es Menor al Costo Total");
                return;
            } else {

                vuelto = Math.round((efectivo_recibido - total) * 100) / 100d;
            }

            lbligv.setText(String.valueOf(igv));
            lbloperacion_gravada.setText(String.valueOf(subtotal));
            lblsub_total.setText(String.valueOf(total));
            lbltotal.setText(String.valueOf(total));
            lblvuelto.setText(String.valueOf(vuelto));

        }        // TODO add your handling code here:


    }//GEN-LAST:event_txtefectivo_recibidoKeyPressed

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
            java.util.logging.Logger.getLogger(frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimpresora;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cbotipocomprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lblconsultorio;
    private javax.swing.JLabel lblconsumo;
    public static javax.swing.JLabel lblcosto_consulta;
    public static javax.swing.JLabel lblfecha_registro;
    public static javax.swing.JLabel lblhora;
    public static javax.swing.JLabel lbligv;
    public static javax.swing.JLabel lblnumero_comprobante;
    public static javax.swing.JLabel lbloperacion_gravada;
    public static javax.swing.JLabel lblpaciente;
    public static javax.swing.JLabel lblsub_total;
    public static javax.swing.JLabel lbltotal;
    private javax.swing.JLabel lbltotalregistros;
    public static javax.swing.JLabel lbltrabajador;
    public static javax.swing.JLabel lblvuelto;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTable tablalistadoconsumo_pago;
    private javax.swing.JTextField txtefectivo_recibido;
    private javax.swing.JTextField txtidcaja;
    public static javax.swing.JTextField txtidconsultorio;
    public static javax.swing.JTextField txtidpago;
    // End of variables declaration//GEN-END:variables
}
