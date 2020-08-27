package Logica;

import Datos.vconsumo;
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
public class fconsumo {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalconsumo;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IdCaja", "idFarmacia", "Producto", "Cantidad", "Precio Venta", "Estado", "Fecha Registro"};

        String[] registro = new String[8];

        totalregistros = 0;
        totalconsumo = 0.0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select c.idconsumo,c.idcaja,c.idfarmacia,f.nombre,c.cantidad,c.precio_venta"
                + ",c.estado,c.fecha_registro from tap_consumo c inner join tap_farmacia f on c.idfarmacia=f.idfarmacia "
                + "where c.idcaja =" + buscar + " order by c.idconsumo desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("c.idconsumo");
                registro[1] = rs.getString("c.idcaja");
                registro[2] = rs.getString("c.idfarmacia");
                registro[3] = rs.getString("f.nombre");
                registro[4] = rs.getString("c.cantidad");
                registro[5] = rs.getString("f.precio_venta");
                registro[6] = rs.getString("c.estado");
                registro[7] = rs.getString("c.fecha_registro");

                totalregistros = totalregistros + 1;
                totalconsumo = totalconsumo + (rs.getInt("c.cantidad") * rs.getDouble("f.precio_venta"));

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vconsumo dts) {
        sSQL = "insert into tap_consumo (idcaja,idfarmacia,cantidad,precio_venta,estado,fecha_registro)"
                + "values (?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcaja());
            pst.setInt(2, dts.getIdfarmacia());
            pst.setInt(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setString(5, dts.getEstado());
            pst.setString(6, dts.getFecha_registro());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vconsumo dts) {
        sSQL = "update tap_consumo set idcaja=?,idfarmacia=?,cantidad=?,precio_venta=?,estado=?"
                + " where idconsumo=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcaja());
            pst.setInt(2, dts.getIdfarmacia());
            pst.setInt(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setString(5, dts.getEstado());

            pst.setInt(6, dts.getIdconsumo());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vconsumo dts) {
        sSQL = "delete from tap_consumo where idconsumo=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdconsumo());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
