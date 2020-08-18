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

        String[] titulos = {"ID", "IdAsistencial", "Nombre y Apellidos", "Colegiatura", "N° Colegiatura", "IdPaciente", "Historia Clinica", "Tipo Doc", "N° Doc", "Nombre", "Apellidos", "Edad", "Direccion", "Serelogia", "Examen Rx", "Fecha Registro"};

        String[] registro = new String[16];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select c.idcertificado_salud,c.idasistenciales,a.nombre,a.apellidos,a.colegiatura,a.num_colegiatura,c.idpaciente,p.historia_clinica,p.tipo_documento,"
                + "p.numero_documento,p.nombres,p.apellido_paterno,p.apellido_materno,p.edad,p.direccion,c.serelogia,examen_rx,c.fecha_registro "
                + "from tap_certificadosalud c inner join tap_asistenciales a on c.idasistenciales=a.idasistenciales inner join tap_paciente p on c.idpaciente=p.idpaciente where p.numero_documento like '%" + buscar + "%' order by c.idcertificado_salud desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("c.idcertificado_salud");
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
                registro[13] = rs.getString("c.serelogia");
                registro[14] = rs.getString("c.examen_rx");
                registro[15] = rs.getString("c.fecha_registro");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT");
            return null;
        }

    }

    public boolean insertar(vcertificado_salud dts) {
        sql = "insert into tap_certificadosalud (idasistenciales,idpaciente,"
                + "serelogia,examen_rx,fecha_registro)"
                + "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdasistenciales());
            pst.setInt(2, dts.getIdpaciente());
            pst.setString(3, dts.getSerelogia());
            pst.setString(4, dts.getExamen_rx());
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

    public boolean editar(vcertificado_salud dts) {
        sql = "update tap_certificadosalud set idasistenciales=?,idpaciente=?,serelogia=?,examen_rx=?,fecha_registro=? "
                + "where idcertificado_salud=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdasistenciales());
            pst.setInt(2, dts.getIdpaciente());
            pst.setString(3, dts.getSerelogia());
            pst.setString(4, dts.getExamen_rx());
            pst.setString(5, dts.getFecha_registro());

            pst.setInt(6, dts.getIdcertificado_salud());

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

    public boolean eliminar(vcertificado_salud dts) {
        sql = "delete from tap_certificadosalud where idcertificado_salud=?";
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
            JOptionPane.showConfirmDialog(null, e + "ERROR DELETE");
            return false;
        }
    }

}
