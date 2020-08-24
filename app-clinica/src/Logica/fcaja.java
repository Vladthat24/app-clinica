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

        String[] titulos = {"ID", "IdConsultorio","Encargado", "Colegiatura", "N° Colegiatura","Consultorio","N° de Consultorio","Piso","Operador","Costo","Fecha Registro"};
        

        String[] registro = new String[11];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select ca.idcaja,ca.idconsultorio,a.nombre,a.apellidos,a.colegiatura,a.num_colegiatura,c.nombre_consultorio,c.numero_consultorio,c.piso_consultorio,ca.trabajador,ca.costo_consulta,ca.fecha_registro " +
               "from tap_caja ca left join tap_consultorio c on ca.idconsultorio=c.idconsultorio left join tap_asistenciales a on c.idasistencial=a.idasistenciales where c.nombre_consultorio like '%" + buscar + "%' order by ca.idcaja desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("ca.idcaja");
                registro[1] = rs.getString("ca.idconsultorio");
                registro[2] = rs.getString("a.nombre") + " " + rs.getString("a.apellidos");
                registro[3] = rs.getString("a.colegiatura");
                registro[4] = rs.getString("a.num_colegiatura");
                registro[5] = rs.getString("c.nombre_consultorio");
                registro[6] = rs.getString("c.numero_consultorio");
                registro[7] = rs.getString("c.piso_consultorio");
                registro[8] = rs.getString("ca.trabajador");
                registro[9] = rs.getString("ca.costo_consulta");
                registro[10] = rs.getString("ca.fecha_registro");
                
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
        sql = "insert into tap_caja (idconsultorio,trabajador,"
                + "costo_consulta,fecha_registro)"
                + "values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdconsultorio());
            pst.setString(2, dts.getTrabajador());
            pst.setDouble(3, dts.getCosto_consulta());          
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

    public boolean editar(vcaja dts) {
        sql = "update tap_caja set idconsultorio=?,trabajador=?,costo_consulta=?,fecha_registro=? where idcaja=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdconsultorio());
            pst.setString(2, dts.getTrabajador());
            pst.setDouble(3, dts.getCosto_consulta());          
            pst.setString(4, dts.getFecha_registro());
            pst.setInt(5, dts.getIdcaja());

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
