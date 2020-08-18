/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vtrabajador;
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
public class ftrabajador {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombres", "Apellido Paterno", "Apellido Materno", "Profesion", "Cargo Intitucion", "Modalidad Contrato", "Tipo Doc", "Número Documento", "Celular", "Email", "Fecha Registro"};

        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select idptrabajador,nombre,apaterno,amaterno,profesion,cargo_institucion,modalidad_contrato,tipo_documento,"
                + "num_documento,celular,email,fecha_registro from tap_trabajador where num_documento like '%" + buscar + "%' order by idptrabajador desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idptrabajador");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("profesion");
                registro[5] = rs.getString("cargo_institucion");
                registro[6] = rs.getString("modalidad_contrato");
                registro[7] = rs.getString("tipo_documento");
                registro[8] = rs.getString("num_documento");
                registro[9] = rs.getString("celular");
                registro[10] = rs.getString("email");
                registro[11] = rs.getString("fecha_registro");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT");
            return null;
        }

    }

    public boolean insertar(vtrabajador dts) {
        sSQL = "insert into tap_trabajador (nombre,apaterno,amaterno,profesion,cargo_institucion,modalidad_contrato,tipo_documento,num_documento,celular,email,fecha_registro)"
                + "values (?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

//insertando primeros datos a la tabla trabajador
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getProfesion());
            pst.setString(5, dts.getCargo_institucion());
            pst.setString(6, dts.getModalidad_contrato());
            pst.setString(7, dts.getTipo_documento());
            pst.setString(8, dts.getNum_documento());
            pst.setString(9, dts.getCelular());
            pst.setString(10, dts.getEmail());
            pst.setString(11, dts.getFecha_registro());

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

    public boolean editar(vtrabajador dts) {
        sSQL = "update tap_trabajador set nombre=?,apaterno=?,amaterno=?,profesion=?,cargo_institucion=?,modalidad_contrato=?,"
                + "tipo_documento=?,num_documento=?,celular=?,email=?,fecha_registro=? where idptrabajador=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getProfesion());
            pst.setString(5, dts.getCargo_institucion());
            pst.setString(6, dts.getModalidad_contrato());
            pst.setString(7, dts.getTipo_documento());
            pst.setString(8, dts.getNum_documento());
            pst.setString(9, dts.getCelular());
            pst.setString(10, dts.getEmail());
            pst.setString(11, dts.getFecha_registro());
            pst.setInt(12, dts.getIdtrabajador());

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

    public boolean eliminar(vtrabajador dts) {
        sSQL = "delete from tap_trabajador where idptrabajador=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdtrabajador());

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

//    public DefaultTableModel login(String login, String password) {
//        DefaultTableModel modelo;
//
//        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Acceso", "Login", "Clave", "Estado"};
//
//        String[] registro = new String[8];
//
//        totalregistros = 0;
//        modelo = new DefaultTableModel(null, titulos);
//
//        sSQL = "select p.idpersoa,p.nombre,p.apaterno,p.amaterno,"
//                + "t.acceso,t.login,t.password,t.estado from persona p inner join Trabajador t "
//                + "on p.idpersona=t.idpersona where t.login='"
//                + login + "' and t.password='" + password + "' and t.estado='A'";
//
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
//
//            while (rs.next()) {
//                registro[0] = rs.getString("idpersona");
//                registro[1] = rs.getString("nombre");
//                registro[2] = rs.getString("apaterno");
//                registro[3] = rs.getString("amaterno");
//
//                registro[4] = rs.getString("acceso");
//                registro[5] = rs.getString("login");
//                registro[6] = rs.getString("password");
//                registro[7] = rs.getString("estado");
//
//                totalregistros = totalregistros + 1;
//                modelo.addRow(registro);
//
//            }
//            return modelo;
//
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//            return null;
//        }
//
//    }
}
