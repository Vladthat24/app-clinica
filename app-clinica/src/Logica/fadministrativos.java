/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vadministrativos;
import Datos.vasistenciales;
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
public class fadministrativos {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostart(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apellidos", "Cargo", "M. Contrato","Prefesion", "Tip. Doc", "Num Doc", "Celular", "Fecha Registro", "Email"};
        String[] registro = new String[11];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idadministrativos,nombre,apellidos,cargo_institucion,modalidad_contrato,"
                + "profesion,tipo_documento,num_documento,celular,"
                + "fecha_registro,email from administrativos where nombre like '%" + buscar + "%'"
                + "or apellidos like '%" + buscar + "%' or cargo_institucion like '%" + buscar + "%'"
                + "or num_documento like '%" + buscar + "%' order by idadministrativos desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idadministrativos");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("cargo_institucion");
                registro[4] = rs.getString("modalidad_contrato");
                registro[5] = rs.getString("profesion");
                registro[6] = rs.getString("tipo_documento");
                registro[7] = rs.getString("num_documento");
                registro[8] = rs.getString("celular");
                registro[9] = rs.getString("fecha_registro");
                registro[10] = rs.getString("email");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error faadministrativos 01");
            return null;
        }

    }

    public boolean insertar(vadministrativos dts) {
        sql = "insert into administrativos (nombre,apellidos,cargo_institucion,modalidad_contrato,"
                +"profesion,tipo_documento,num_documento,celular,fecha_registro,email)"
                +"values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);


            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getCargo_institucion());
            pst.setString(4, dts.getModalidad_contrato());
            pst.setString(5, dts.getProfesion());
            pst.setString(6, dts.getTipo_documento());
            pst.setString(7, dts.getNum_documento());
            pst.setString(8, dts.getCelular());
            pst.setString(9, dts.getFecha_registro());
            pst.setString(10, dts.getEmail());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fadministrativos 02");
            return false;
        }
    }

    public boolean editar(vadministrativos dts) {
        sql = "update administrativos set nombre=?,apellidos=?,cargo_institucion=?,modalidad_contrato=?,"
                + "profesion=?,tipo_documento=?,num_documento=?,celular=?,fecha_registro=?,email=? where idadministrativos=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getCargo_institucion());
            pst.setString(4, dts.getModalidad_contrato());
            pst.setString(5, dts.getProfesion());
            pst.setString(6, dts.getTipo_documento());
            pst.setString(7, dts.getNum_documento());
            pst.setString(8, dts.getCelular());
            pst.setString(9, dts.getFecha_registro());
            pst.setString(10, dts.getEmail());
            pst.setInt(11, dts.getIdadministrativos());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fadminsitrativos 03");
            return false;
        }
    }

    public boolean eliminar(vadministrativos dts) {
        sql = "delete from administrativos where idadministrativos=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dts.getIdadministrativos());
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fadministrativos 04");
            return false;
        }
    }

}
