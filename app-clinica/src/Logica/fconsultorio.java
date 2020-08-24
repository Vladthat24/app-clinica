/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.vconsultorio;
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
public class fconsultorio {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IdAsistencial", "Nombre y Apellidos", "Colegiatura", "N° Colegiatura", "Nombre del Consultorio","N° del Consultorio", "Piso", "Fecha Registro"};

        String[] registro = new String[9];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select c.idconsultorio,c.idasistencial,a.nombre,a.apellidos,a.colegiatura,a.num_colegiatura,"
                + "c.nombre_consultorio,c.numero_consultorio,c.piso_consultorio,c.fecha_registro from tap_consultorio c inner join tap_asistenciales a on c.idasistencial=a.idasistenciales where c.nombre_consultorio like '%" + buscar + "%' order by c.idconsultorio desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("c.idconsultorio");
                registro[1] = rs.getString("c.idasistencial");
                registro[2] = rs.getString("a.nombre") + " " + rs.getString("a.apellidos");
                registro[3] = rs.getString("a.colegiatura");
                registro[4] = rs.getString("a.num_colegiatura");
                registro[5] = rs.getString("c.nombre_consultorio");
                registro[6] = rs.getString("c.numero_consultorio");
                registro[7] = rs.getString("c.piso_consultorio");
                registro[8] = rs.getString("c.fecha_registro");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT");
            return null;
        }

    }

    public boolean insertar(vconsultorio dts) {
        sql = "insert into tap_consultorio (idasistencial,nombre_consultorio,"
                + "numero_consultorio,piso_consultorio,fecha_registro)"
                + "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdasistencial());
            pst.setString(2, dts.getNombre_consultorio());
            pst.setString(3, dts.getNumero_consultorio());
            pst.setString(4, dts.getPiso_consultorio());
            pst.setString(5, dts.getFecha_registro());

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

    public boolean editar(vconsultorio dts) {
        sql = "update tap_consultorio set idasistencial=?,nombre_consultorio=?,numero_consultorio=?,piso_consultorio=?,fecha_registro=? "
                + "where idconsultorio=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdasistencial());
            pst.setString(2, dts.getNombre_consultorio());
            pst.setString(3, dts.getNumero_consultorio());
            pst.setString(4, dts.getPiso_consultorio());
            pst.setString(5, dts.getFecha_registro());

            pst.setInt(6, dts.getIdconsultorio());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR EDIT");
            return false;
        }
    }

    public boolean eliminar(vconsultorio dts) {
        sql = "delete from tap_consultorio where idconsultorio=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dts.getIdconsultorio());
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
