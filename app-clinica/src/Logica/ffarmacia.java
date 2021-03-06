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
    public DefaultTableModel mostrarID(int idfarmacia) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Categoria", "Nombre", "Precio Venta", "Stock", "Laboratorio", "Presentacion", "Feche de Registro", "Fecha de Vencimiento"};
        String[] registro = new String[9];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idfarmacia,categoria,"
                + "nombre,precio_venta,stock,"
                + "laboratorio,presentacion,"
                + "DATE_FORMAT(STR_TO_DATE(REPLACE(fecha_registro,'-','.'),GET_FORMAT(date,'EUR')),\"%d-%m-%Y\") as fecha_registro,"
                + "DATE_FORMAT(fecha_vencimiento, \"%d-%m-%Y\") as fecha_vencimiento FROM tap_farmacia where idfarmacia = " + idfarmacia + " order by idfarmacia desc";

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

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Categoria", "Nombre", "Precio Venta", "Stock", "Laboratorio", "Presentacion", "Feche de Registro", "Fecha de Vencimiento"};
        String[] registro = new String[9];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idfarmacia,categoria,"
                + "nombre,precio_venta,stock,"
                + "laboratorio,presentacion,"
                + "DATE_FORMAT(STR_TO_DATE(REPLACE(fecha_registro,'-','.'),GET_FORMAT(date,'EUR')),\"%d-%m-%Y\") as fecha_registro,"
                + "DATE_FORMAT(fecha_vencimiento, \"%d-%m-%Y\") as fecha_vencimiento FROM tap_farmacia where nombre like '%" + buscar + "%' order by idfarmacia desc";

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
            pst.setString(8, dts.getFecha_vencimiento());

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

        sql = "update tap_farmacia set categoria=?,nombre=?,precio_venta=?,stock=?,laboratorio=?,presentacion=?,fecha_registro=?,fecha_vencimiento=? where idfarmacia=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, dts.getCategoria());
            pst.setString(2, dts.getNombre());
            pst.setDouble(3, dts.getPrecio_venta());
            pst.setInt(4, dts.getStock());
            pst.setString(5, dts.getLaboratorio());
            pst.setString(6, dts.getPresentacion());
            pst.setString(7, dts.getFecha_registro());
            pst.setString(8, dts.getFecha_vencimiento());

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

    public vfarmacia listarID(int id) {
        vfarmacia f = new vfarmacia();
        String sql = "select * from tap_farmacia where idfarmacia=?";
        
        try {
            
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                f.setIdfarmacia(rs.getInt(1));
                f.setCategoria(rs.getString(2));
                f.setNombre(rs.getString(3));
                f.setPrecio_venta(rs.getDouble(4));
                f.setStock(rs.getInt(5));
                f.setLaboratorio(rs.getString(6));
                f.setPresentacion(rs.getString(7));
                f.setFecha_registro(rs.getString(8));
                f.setFecha_vencimiento(rs.getString(9));

            }

        } catch (Exception e) {
        }
        return f;
    }

    public int actualizarStock(int cant, int idproducto) {
        int r = 0;

        String sql = "Update tap_farmacia set stock=? where idfarmacia=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, cant);
            pst.setInt(2, idproducto);
            pst.executeUpdate();
            
        } catch (Exception e) {

        }
        return r;

    }

}
