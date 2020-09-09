/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vpago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS
 */
public class fpago {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Integer totalregistros_total;

    public DefaultTableModel mostrarTotal(String buscar) {
        DefaultTableModel modelo2;

        String[] titulos = {"ID", "IdCaja", "Comprobante", "Número", "Igv", "Cantidad de Pago", "Sub Total", "Total", "Vuelto", "Fecha Registro", "Hora", "Digitador"};

        String[] registro = new String[12];

        totalregistros_total = 0;
        modelo2 = new DefaultTableModel(null, titulos);

        sSQL = "select * from tap_pago order by idpago desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpago");
                registro[1] = rs.getString("idcaja");
                registro[2] = rs.getString("tipo_comprobante");
                registro[3] = rs.getString("num_comprobante");
                registro[4] = rs.getString("igv");
                registro[5] = rs.getString("cantidad_pago");
                registro[6] = rs.getString("subtotal");
                registro[7] = rs.getString("total");
                registro[8] = rs.getString("vuelto");
                registro[9] = rs.getString("fecha_registro");
                registro[10] = rs.getString("hora");
                registro[11] = rs.getString("trabajador");

                totalregistros_total = totalregistros_total + 1;
                modelo2.addRow(registro);

            }
            return modelo2;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT FPAGO");
            return null;
        }

    }

    public DefaultTableModel mostrarReporte(int idpago) {
        DefaultTableModel modelo2;

        String[] titulos = {"ID", "Nombre", "Apellidos",
            "Colegiatura", "N° colegiatura", "Profesion",
            "Tipo Documento", "N° Documento", "Nombre Consultorio",
            "N° consultorio", "Piso consultorio", "Idpaciente",
            "Historia Clinica", "Tipo Documento", "N° documento", "Nombres", "Apellido Materno",
            "Apellido Materno", "Costo Consulta", "Tipo Comprobante", "N° Comprobante", "IGV", "Cantidad Pago",
            "Subtotal", "total", "vuelto", "Fecha Registro", "Hora", "Trabajador"};

        String[] registro = new String[12];

        totalregistros_total = 0;
        modelo2 = new DefaultTableModel(null, titulos);

        sSQL = "select p.idpago,a.nombre,a.apellidos,a.colegiatura,"
                + "a.num_colegiatura,a.profesion,a.tipo_documento,a.num_documento,con.nombre_consultorio,"
                + "con.numero_consultorio,con.piso_consultorio,c.idpaciente,paciente.historia_clinica,"
                + "paciente.tipo_documento,paciente.numero_documento,paciente.nombres,"
                + "paciente.apellido_paterno,paciente.apellido_materno,c.costo_consulta,"
                + "p.tipo_comprobante,p.num_comprobante,p.igv,p.cantidad_pago,"
                + "p.subtotal,p.total,p.vuelto,p.fecha_registro,p.hora,p.trabajador "
                + "from tap_pago p "
                + "left join tap_caja c "
                + "on p.idcaja=c.idcaja "
                + "left join tap_consultorio con "
                + "on c.idconsultorio=con.idconsultorio "
                + "left join tap_asistenciales a "
                + "on con.idasistencial=a.idasistenciales "
                + "left join tap_paciente paciente "
                + "on c.idpaciente=paciente.idpaciente from tap_pago where idpago= " + idpago + " order by idpago desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("p.idpago");
                registro[1] = rs.getString("a.nombre");
                registro[2] = rs.getString("a.apellidos");
                registro[3] = rs.getString("a.colegiatura");
                registro[4] = rs.getString("a.num_colegiatura");
                registro[5] = rs.getString("a.profesion");
                registro[6] = rs.getString("a.tipo_documento");
                registro[7] = rs.getString("a.num_documento");
                registro[8] = rs.getString("con.nombre_consultorio");
                registro[9] = rs.getString("con.numero_consultorio");
                registro[10] = rs.getString("con.piso_consultorio");

                registro[11] = rs.getString("c.idpaciente");
                registro[12] = rs.getString("paciente.historia_clinica");
                registro[13] = rs.getString("paciente.tipo_documento");
                registro[14] = rs.getString("paciente.numero_documento");
                registro[15] = rs.getString("paciente.nombres");
                registro[16] = rs.getString("paciente.apellido_paterno");

                registro[17] = rs.getString("paciente.apellido_materno");
                registro[18] = rs.getString("c.costo_consulta");
                registro[19] = rs.getString("p.tipo_comprobante");
                registro[20] = rs.getString("p.num_comprobante");
                registro[21] = rs.getString("p.igv");
                registro[22] = rs.getString("p.cantidad_pago");

                registro[23] = rs.getString("p.subtotal");
                registro[24] = rs.getString("p.total");
                registro[25] = rs.getString("p.vuelto");

                registro[26] = rs.getString("p.fecha_registro");
                registro[27] = rs.getString("p.hora");
                registro[28] = rs.getString("p.trabajador");

                totalregistros_total = totalregistros_total + 1;
                modelo2.addRow(registro);

            }
            return modelo2;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT FPAGO");
            return null;
        }

    }

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IdCaja", "Comprobante", "Número", "Igv", "Cantidad de Pago", "Sub Total", "Total", "Vuelto", "Fecha Registro", "Hora", "Digitador"};

        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from tap_pago where idcaja = " + buscar + " order by idpago desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpago");
                registro[1] = rs.getString("idcaja");
                registro[2] = rs.getString("tipo_comprobante");
                registro[3] = rs.getString("num_comprobante");
                registro[4] = rs.getString("igv");
                registro[5] = rs.getString("cantidad_pago");
                registro[6] = rs.getString("subtotal");
                registro[7] = rs.getString("total");
                registro[8] = rs.getString("vuelto");
                registro[9] = rs.getString("fecha_registro");
                registro[10] = rs.getString("hora");
                registro[11] = rs.getString("trabajador");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT FPAGO");
            return null;
        }

    }

    public boolean insertar(vpago dts) {
        sSQL = "insert into tap_pago (idcaja,tipo_comprobante,num_comprobante,igv,cantidad_pago,subtotal,total,vuelto,fecha_registro,hora,trabajador)"
                + "values (?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcaja());
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getCantidad_pago());
            pst.setDouble(6, dts.getSubtotal());
            pst.setDouble(7, dts.getTotal());
            pst.setDouble(8, dts.getVuelto());
            pst.setString(9, dts.getFecha_registro());
            pst.setString(10, dts.getHora());
            pst.setString(11, dts.getTrabajador());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR INSERT FPAGO");
            return false;
        }
    }

    public boolean editar(vpago dts) {
        sSQL = "update tap_pago set idcaja=?,tipo_comprobante=?,"
                + "num_comprobante=?,igv=?,cantidad_pago=?,"
                + ",subtotal=?,total=?,vuelto=?"
                + " where idpago=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcaja());
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getCantidad_pago());
            pst.setDouble(6, dts.getSubtotal());
            pst.setDouble(7, dts.getTotal());
            pst.setDouble(8, dts.getVuelto());

            pst.setInt(9, dts.getIdpago());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vpago dts) {
        sSQL = "delete from tap_pago where idpago=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdpago());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
