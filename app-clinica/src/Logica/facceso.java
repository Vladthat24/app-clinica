/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vacceso;
import Datos.vtrabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vladhat
 */
public class facceso {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "idTrabajador", "trabajador","Acceso", "login", "Password", "Estado"};

        String[] registro = new String[7];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
//        sSQL = "select idacceso,acceso,idtrabajador,login,password,estado from acceso where idtrabajador IN (select nombre from persona_trabajador where idtrabajador=idtrabajador)";

        sSQL = "select idacceso,idtrabajador,"
                + "(select nombre from persona_trabajador where idptrabajador=idtrabajador) as trabajadornombre,"
                + "(select apaterno from persona_trabajador where idptrabajador=idtrabajador) as trabajadorapellidop,"
                + "acceso,login,password,estado from acceso where login like '%" + buscar + "%' order by idacceso desc";

//SELECT nombrepla FROM plataformas WHERE idpla IN (SELECT idpla FROM notpla WHERE id_not='6')
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idacceso");
                registro[1] = rs.getString("idtrabajador");
                registro[2] = rs.getString("trabajadornombre") + "  " + rs.getString("trabajadorapellidop");
                registro[3] = rs.getString("acceso");
                registro[4] = rs.getString("login");
                registro[5] = rs.getString("password");
                registro[6] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error 01 facceso");
            return null;
        }

    }

    public boolean insertar(vacceso dts) {
        sSQL = "insert into acceso (idtrabajador,acceso,login,password,estado)"
                + "values (?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            
            pst.setInt(1, dts.getIdtrabajador());
            pst.setString(2, dts.getAcceso());
            pst.setString(3, dts.getLogin());
            pst.setString(4, dts.getPassword());
            pst.setString(5, dts.getEstado());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error 02 facceso");
            return false;
        }
    }

    public boolean editar(vacceso dts) {
        sSQL = "update acceso set idtrabajador=?,acceso=?,login=?,password=?,estado=?"
                + "where idacceso=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            
            pst.setInt(1, dts.getIdtrabajador());
             pst.setString(2, dts.getAcceso());
            pst.setString(3, dts.getLogin());
            pst.setString(4, dts.getPassword());
            pst.setString(5, dts.getEstado());
            
            pst.setInt(6, dts.getIdacceso());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error 03 facceso");
            return false;
        }
    }

    public boolean eliminar(vacceso dts) {
        sSQL = "delete from acceso where idacceso=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdacceso());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error 04 facceso");
            return false;
        }
    }

    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;
        String[] titulos = {"ID","Trabajador", "Acceso", "Login", "Password", "Estado"};
        String[] registros = new String[6];

        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select idacceso,idtrabajador,acceso,login,password,estado from acceso where login='"
                + login + "'and password='" + password + "' and estado='A'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registros[0] = rs.getString("idacceso");
                registros[1] = rs.getString("idtrabajador");
                registros[2] = rs.getString("acceso");
                registros[3] = rs.getString("login");
                registros[4] = rs.getString("password");
                registros[5] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error login facceso");
            return null;
        }
    }
}
