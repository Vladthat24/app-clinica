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
