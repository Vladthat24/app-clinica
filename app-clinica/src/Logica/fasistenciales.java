/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vasistenciales;
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
public class fasistenciales {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostart(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apellidos",
            "Cargo","Profesion",
            "Tip. Doc", "Num Doc", "Celular",
            "Fecha Registro"};
        String[] registro = new String[9];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idasistenciales,nombre,apellidos,"
                + "cargo_institucion,"
                + "profesion,tipo_documento,"
                + "num_documento,celular,"
                + "fecha_registro "
                + "from tap_asistenciales where nombre like '%" + buscar + "%'"
                + "order by idasistenciales desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idasistenciales");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("cargo_institucion");
                registro[4] = rs.getString("profesion");
                registro[5] = rs.getString("tipo_documento");
                registro[6] = rs.getString("num_documento");
                registro[7] = rs.getString("celular");
                registro[8] = rs.getString("fecha_registro");


                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT");
            return null;
        }

    }

    public boolean insertar(vasistenciales dts) {
        sql = "insert into asistenciales (nombre,apellidos,cargo_institucion,modalidad_contrato,colegiatura,"
                +"num_colegiatura,profesion,tipo_documento,num_documento,celular,fecha_registro,email)"
                +"values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

     
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getCargo_institucion());
            pst.setString(4, dts.getModalidad_contrato());
            pst.setString(5, dts.getColegiatura());
            pst.setString(6, dts.getNum_colegiatura());
            pst.setString(7, dts.getProfesion());
            pst.setString(8, dts.getTipo_documento());
            pst.setString(9, dts.getNum_documento());
            pst.setString(10, dts.getCelular());
            pst.setString(11, dts.getFecha_registro());
            pst.setString(12, dts.getEmail());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fasistenciales 02");
            return false;
        }
    }

    public boolean editar(vasistenciales dts) {
        sql = "update asistenciales set nombre=?,apellidos=?,cargo_institucion=?,modalidad_contrato=?,colegiatura=?,"
                + "num_colegiatura=?,profesion=?,tipo_documento=?,num_documento=?,celular=?,fecha_registro=?,email=? where idasistenciales=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getCargo_institucion());
            pst.setString(4, dts.getModalidad_contrato());
            pst.setString(5, dts.getColegiatura());
            pst.setString(6, dts.getNum_colegiatura());
            pst.setString(7, dts.getProfesion());
            pst.setString(8, dts.getTipo_documento());
            pst.setString(9, dts.getNum_documento());
            pst.setString(10, dts.getCelular());
            pst.setString(11, dts.getFecha_registro());
            pst.setString(12, dts.getEmail());
            pst.setInt(13, dts.getIdasistenciales());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fasistenciales 03");
            return false;
        }
    }

    public boolean eliminar(vasistenciales dts) {
        sql = "delete from asistenciales where idasistenciales=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dts.getIdasistenciales());
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fasistenciales 04");
            return false;
        }
    }

}
