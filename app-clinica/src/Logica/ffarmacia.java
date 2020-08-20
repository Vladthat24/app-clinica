/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vfarmacia;
import Datos.vinforme_medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class ffarmacia {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Categoria", "Nombre", "Precio Venta", "Stock", "Laboratorio", "Presentacion", "Feche de Registro", "Fecha de Vencimiento"};
        String[] registro = new String[9];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM tap_farmacia where nombre like '%" + buscar + "%' order by idfarmacia desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                registro[0] = rs.getString("idfarmacia");
                registro[1] = rs.getString("categoria");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("precio_venta");
                registro[4] = rs.getString("stock");
                registro[5] = rs.getString("laboratorio");
                registro[6] = rs.getString("presentacion");
                registro[7] = rs.getString("fecha_registro");
                registro[8] = rs.getString("fecha_vencimiento");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT");
            return null;
        }

    }

    public boolean insertar(vfarmacia dts) {
        sql = "insert into tap_farmacia (categoria,nombre,precio_venta,stock,laboratorio,presentacion,fecha_registro,fecha_vencimiento)"
                + "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, dts.getCategoria());
            pst.setString(2, dts.getNombre());
            pst.setDouble(3, dts.getPrecio_venta());
            pst.setInt(4, dts.getStock());
            pst.setString(5, dts.getLaboratorio());
            pst.setString(6, dts.getPresentacion());
            pst.setString(7, dts.getFecha_registro());
            pst.setDate(8, dts.getFecha_vencimiento());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR INSERT");
            return false;
        }
    }

    public boolean editar(vfarmacia dts) {

        sql = "update tap_informemedico set idasistenciales=?,idpaciente=?,diagnostico=?,fecha_registro=? where idinforme_medico=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, dts.getCategoria());
            pst.setString(2, dts.getNombre());
            pst.setDouble(3, dts.getPrecio_venta());
            pst.setInt(4, dts.getStock());
            pst.setString(5, dts.getLaboratorio());
            pst.setString(6, dts.getPresentacion());
            pst.setString(7, dts.getFecha_registro());
            pst.setDate(8, dts.getFecha_vencimiento());

            pst.setInt(9, dts.getIdfarmacia());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {

                return false;

            }

        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e + "ERROR UPDATE");

            return false;
        }
    }

    public boolean eliminar(vfarmacia dts) {
        sql = "delete from tap_farmacia where idfarmacia=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdfarmacia());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {

                return false;

            }
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e + "ERROR DELETE");

            return false;
        }
    }

}
