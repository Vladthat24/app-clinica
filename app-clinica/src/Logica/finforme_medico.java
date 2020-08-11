/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vasistenciales;
import Datos.vinforme_medico;
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
public class finforme_medico {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "idiasistenciales", "nombre y apelldios", "Colegiatura", "N° Correlativo", "Nombre Paciente", "Apellidos Paciente", "N° Historia", "direccion", "sexo", "edad", "Tipo Doc", "N° Doc", "fecha_registro", "diagnostico"};
        String[] registro = new String[15];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idinforme_medico,idiasistenciales, (select nombre from asistenciales where idasistenciales=idiasistenciales)as nombre_asisten,"
                + "(select apellidos from asistenciales where idasistenciales=idiasistenciales)as apellidos_asisten,"
                + "(select colegiatura from asistenciales where idasistenciales=idiasistenciales)as colegiatura_asisten,"
                + "(select num_colegiatura from asistenciales where idasistenciales=idiasistenciales)as num_colegiatura_asisten,"
                + "correlativo_informemedico,nombre_paciente,apellidos_paciente,historia_clinica,direccion,sexo,edad,tipo_documento,num_documento,fecha_registro,diagnostico"
                + " from informe_medico where num_documento like '%" + buscar + "%' order by idinforme_medico desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idinforme_medico");
                registro[1] = rs.getString("idiasistenciales");
                registro[2] = rs.getString("nombre_asisten") + " " + rs.getString("apellidos_asisten");
                registro[3] = rs.getString("colegiatura_asisten") + "" + rs.getString("num_colegiatura_asisten");
                registro[4] = rs.getString("correlativo_informemedico");
                registro[5] = rs.getString("nombre_paciente");
                registro[6] = rs.getString("apellidos_paciente");
                registro[7] = rs.getString("historia_clinica");
                registro[8] = rs.getString("direccion");
                registro[9] = rs.getString("sexo");
                registro[10] = rs.getString("edad");
                registro[11] = rs.getString("tipo_documento");
                registro[12] = rs.getString("num_documento");
                registro[13] = rs.getString("fecha_registro");
                registro[14] = rs.getString("diagnostico");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error finforme_medico 01");
            return null;
        }

    }

    public boolean insertar(vinforme_medico dts) {
        sql = "insert into informe_medico (idiasistenciales,correlativo_informemedico,nombre_paciente,apellidos_paciente,historia_clinica,"
                + "direccion,sexo,edad,tipo_documento,num_documento,fecha_registro,diagnostico)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdiasistenciales());
            pst.setString(2, dts.getCorrelativo_informemedico());
            pst.setString(3, dts.getNombre_paciente());
            pst.setString(4, dts.getApellidos_paciente());
            pst.setString(5, dts.getHistoria_clinica());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getSexo());
            pst.setString(8, dts.getEdad());
            pst.setString(9, dts.getTipo_documento());
            pst.setString(10, dts.getNum_documento());
            pst.setString(11, dts.getFecha_registro());
            pst.setString(12, dts.getDiagnostico());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error finforme_medico 02");
            return false;
        }
    }

    public boolean editar(vinforme_medico dts) {
        sql = "update informe_medico set idiasistenciales=?,correlativo_informemedico=?,nombre_paciente=?,apellidos_paciente=?,"
                + "historia_clinica=?,direccion=?,sexo=?,edad=?,tipo_documento=?,num_documento=?,fecha_registro=?,diagnostico=? where idinforme_medico=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdiasistenciales());
            pst.setString(2, dts.getCorrelativo_informemedico());
            pst.setString(3, dts.getNombre_paciente());
            pst.setString(4, dts.getApellidos_paciente());
            pst.setString(5, dts.getHistoria_clinica());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getSexo());
            pst.setString(8, dts.getEdad());
            pst.setString(9, dts.getTipo_documento());
            pst.setString(10, dts.getNum_documento());
            pst.setString(11, dts.getFecha_registro());
            pst.setString(12, dts.getDiagnostico());

            pst.setInt(13, dts.getIdinforme_medico());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error finforme_medico 03");
            return false;
        }
    }

    public boolean eliminar(vinforme_medico dts) {
        sql = "delete from informe_medico where idinforme_medico=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dts.getIdinforme_medico());
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error finforme_medico 04");
            return false;
        }
    }

}
