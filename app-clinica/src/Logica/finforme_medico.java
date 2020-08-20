/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
public class finforme_medico {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IdAsistencial", "Asistencial", "Colegiatura", "N° Colegiatura", "IdPaciente", "Historia Clinica", "Tipo Doc", "N° Doc", "Nombre", "Apellidos", "Edad", "Direccion", "Diagnostico", "Fecha Registro"};
        String[] registro = new String[15];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select c.idinforme_medico,c.idasistenciales,a.nombre,a.apellidos,a.colegiatura,a.num_colegiatura,c.idpaciente,p.historia_clinica,p.tipo_documento,"
                + "p.numero_documento,p.nombres,p.apellido_paterno,p.apellido_materno,p.edad,p.direccion,c.diagnostico,c.fecha_registro "
                + "from tap_informemedico c inner join tap_asistenciales a on c.idasistenciales=a.idasistenciales inner join tap_paciente p on c.idpaciente=p.idpaciente where p.numero_documento like '%" + buscar + "%' order by c.idinforme_medico desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                
                registro[0] = rs.getString("c.idinforme_medico");
                registro[1] = rs.getString("c.idasistenciales");
                registro[2] = rs.getString("a.nombre") + " " + rs.getString("a.apellidos");
                registro[3] = rs.getString("a.colegiatura");
                registro[4] = rs.getString("a.num_colegiatura");
                registro[5] = rs.getString("c.idpaciente");
                registro[6] = rs.getString("p.historia_clinica");
                registro[7] = rs.getString("p.tipo_documento");
                registro[8] = rs.getString("p.numero_documento");
                registro[9] = rs.getString("p.nombres");
                registro[10] = rs.getString("p.apellido_paterno") + " " + rs.getString("p.apellido_materno");
                registro[11] = rs.getString("p.edad");
                registro[12] = rs.getString("p.direccion");
                registro[13] = rs.getString("c.diagnostico");
                registro[14] = rs.getString("c.fecha_registro");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT");
            return null;
        }

    }

    public boolean insertar(vinforme_medico dts) {
        sql = "insert into tap_informemedico (idasistenciales,idpaciente,diagnostico,fecha_registro)"
                + "values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdasistenciales());
            pst.setInt(2, dts.getIdpaciente());
            pst.setString(3, dts.getDiagnostico());
            pst.setString(4, dts.getFecha_registro());

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

    public boolean editar(vinforme_medico dts) {

        sql = "update tap_informemedico set idasistenciales=?,idpaciente=?,diagnostico=?,fecha_registro=? where idinforme_medico=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdasistenciales());
            pst.setInt(2, dts.getIdpaciente());
            pst.setString(3, dts.getDiagnostico());
            pst.setString(4, dts.getFecha_registro());

            pst.setInt(5, dts.getIdinforme_medico());

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
        sql = "delete from tap_informemedico where idinforme_medico=?";
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
