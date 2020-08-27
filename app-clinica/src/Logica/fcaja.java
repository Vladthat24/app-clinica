/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vcaja;
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
public class fcaja {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IdConsultorio", "IdPaciente", "Historia Clinica", "Tipo Doc.", "N° Doc.", "Nombre y Apellido del Paciente", "Encargado del Consultorio", "Colegiatura", "N° Colegiatura", "Consultorio", "N° de Consultorio", "Piso", "Operador", "Costo", "Fecha Registro"};

        String[] registro = new String[16];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select ca.idcaja,ca.idconsultorio,ca.idpaciente,p.historia_clinica,p.tipo_documento,"
                + "p.numero_documento,p.nombres,p.apellido_paterno,p.apellido_materno,"
                + "a.nombre,a.apellidos,a.colegiatura,a.num_colegiatura,"
                + "c.nombre_consultorio,c.numero_consultorio,"
                + "c.piso_consultorio,ca.trabajador,"
                + "ca.costo_consulta,ca.fecha_registro "
                + "from tap_caja ca "
                + "left join tap_consultorio c on ca.idconsultorio=c.idconsultorio "
                + "left join tap_asistenciales a on c.idasistencial=a.idasistenciales "
                + "left join tap_paciente p on ca.idpaciente=p.idpaciente where c.nombre_consultorio like '%" + buscar + "%' order by ca.idcaja desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("ca.idcaja");
                registro[1] = rs.getString("ca.idconsultorio");
                registro[2] = rs.getString("ca.idpaciente");
                registro[3] = rs.getString("p.historia_clinica");
                registro[4] = rs.getString("p.tipo_documento");
                registro[5] = rs.getString("p.numero_documento");
                registro[6]= rs.getString("p.nombres")+" "+rs.getString("p.apellido_paterno")+" "+rs.getString("apellido_materno");
                registro[7] = rs.getString("a.nombre") + " " + rs.getString("a.apellidos");
                registro[8] = rs.getString("a.colegiatura");
                registro[9] = rs.getString("a.num_colegiatura");
                registro[10] = rs.getString("c.nombre_consultorio");
                registro[11] = rs.getString("c.numero_consultorio");
                registro[12] = rs.getString("c.piso_consultorio");
                registro[13] = rs.getString("ca.trabajador");
                registro[14] = rs.getString("ca.costo_consulta");
                registro[15] = rs.getString("ca.fecha_registro");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR SELECT");
            return null;
        }

    }

    public boolean insertar(vcaja dts) {
        sql = "insert into tap_caja (idconsultorio,idpaciente,trabajador,"
                + "costo_consulta,fecha_registro)"
                + "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
         
            pst.setInt(1, dts.getIdconsultorio());
            pst.setInt(2, dts.getIdpaciente());
            pst.setString(3, dts.getTrabajador());
            pst.setDouble(4, dts.getCosto_consulta());
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

    public boolean editar(vcaja dts) {
        sql = "update tap_caja set idconsultorio=?,idpaciente=?,trabajador=?,costo_consulta=?,fecha_registro=? where idcaja=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdconsultorio());
            pst.setInt(2, dts.getIdpaciente());
            pst.setString(3, dts.getTrabajador());
            pst.setDouble(4, dts.getCosto_consulta());
            pst.setString(5, dts.getFecha_registro());
            pst.setInt(6, dts.getIdcaja());

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

    public boolean eliminar(vcaja dts) {
        sql = "delete from tap_caja where idcaja=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dts.getIdcaja());
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
