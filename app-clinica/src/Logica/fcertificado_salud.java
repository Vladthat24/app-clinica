/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vasistenciales;
import Datos.vcertificado_salud;
import Datos.vrecepcion;
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
public class fcertificado_salud {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "idasistenciales", "Dotor", "Nombres", "Apellidos", "Edad", "Tipo Doc", "N°Doc Pac.", "direccion", "serelogia", "examen_rx", "fecha_registro"};
        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idcertificado_salud, idcerasistenciales, (select nombre from asistenciales where idasistenciales=idcerasistenciales)as nombre_asisten,"
                + "(select apellidos from asistenciales where idasistenciales=idcerasistenciales)as apellidos_asisten,"
                + "nombre,apellidos,edad,tipo_doc,num_doc,direccion,serelogia,examen_rx,fecha_registro from certificado_salud where num_doc like '%" + buscar + "%' order by idcertificado_salud desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idcertificado_salud");
                registro[1] = rs.getString("idcerasistenciales");
                registro[2] = rs.getString("nombre_asisten") + " " + rs.getString("apellidos_asisten");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("apellidos");
                registro[5] = rs.getString("edad");
                registro[6] = rs.getString("tipo_doc");
                registro[7] = rs.getString("num_doc");
                registro[8] = rs.getString("direccion");
                registro[9] = rs.getString("serelogia");
                registro[10] = rs.getString("examen_rx");
                registro[11] = rs.getString("fecha_registro");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fcertificado_salud 01");
            return null;
        }

    }

    public boolean insertar(vcertificado_salud dts) {
        sql = "insert into certificado_salud (idcerasistenciales,nombre,apellidos,edad,tipo_doc,num_doc,"
                + "direccion,serelogia,examen_rx,fecha_registro)"
                + "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

           
            pst.setInt(1, dts.getIdcerasistenciales());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApellidos());
            pst.setString(4, dts.getEdad());
            pst.setString(5, dts.getTipo_doc());
            pst.setString(6, dts.getNum_doc());
            pst.setString(7, dts.getDireccion());
            pst.setString(8, dts.getSerelogia());
            pst.setString(9, dts.getExamen_rx());
            pst.setString(10, dts.getFecha_registro());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fcertificado_salud 02");
            return false;
        }
    }

    public boolean editar(vcertificado_salud dts) {
        sql = "update certificado_salud set idcerasistenciales=?,nombre=?,apellidos=?,edad=?,tipo_doc=?,num_doc=?,direccion=?,serelogia=?,examen_rx=?,fecha_registro=? "
                + "where idcertificado_salud=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            
            pst.setInt (1, dts.getIdcerasistenciales());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApellidos());
            pst.setString(4, dts.getEdad());
            pst.setString(5, dts.getTipo_doc());
            pst.setString(6, dts.getNum_doc());
            pst.setString(7, dts.getDireccion());
            pst.setString(8, dts.getSerelogia());
            pst.setString(9, dts.getExamen_rx());
            pst.setString(10, dts.getFecha_registro());
            
             pst.setInt (11, dts.getIdcertificado_salud());
           

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fcertificados_salud 03");
            return false;
        }
    }

    public boolean eliminar(vcertificado_salud dts) {
        sql = "delete from certificado_salud where idcertificado_salud=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dts.getIdcertificado_salud());
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fcertificado_salud 04");
            return false;
        }
    }

}
