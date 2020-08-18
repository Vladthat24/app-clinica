package Logica;

import Datos.vpaciente;

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
public class fpaciente {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID","Historio Clinica", "Tipo Documento", "N° Documento", "Nombres", "Apellido Paterno", "Apellido Materno", "Tipo Seguro", "Direccion", "Celular",
            "Email", "Fecha Nacimiento", "Lugar de Nac.", "Lugar de Proc.", "Sexo", "Edad", "Estado Civil",
            "fa_nombres", "fa_apellidos", "fa_edad", "fa_direccion",
            "Digitador", "Fecha registro"};

        String[] registro = new String[24];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

//        sSQL = "select * from paciente where num_doc like '%"+buscar+"%'"
//                + " OR apellidos like '%"+buscar+"%' order by idpaciente desc limit 50000";
        sSQL = "select * from tap_paciente where numero_documento like '%" + buscar + "%' order by idpaciente desc limit 50000";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                
                registro[0] = rs.getString("idpaciente");
                registro[1] = rs.getString("historia_clinica");
                registro[2] = rs.getString("tipo_documento");
                registro[3] = rs.getString("numero_documento");
                registro[4] = rs.getString("nombres");
                registro[5]= rs.getString("apellido_paterno");
                registro[6] = rs.getString("apellido_materno");
                registro[7] = rs.getString("tipo_seguro");
                registro[8] = rs.getString("direccion");
                registro[9] = rs.getString("celular");
                registro[10] = rs.getString("email");
                registro[11] = rs.getString("fecha_nacimiento");
                registro[12] = rs.getString("lugar_nac");
                registro[13] = rs.getString("lugar_proc");
                registro[14] = rs.getString("sexo");
                registro[15] = rs.getString("edad");
                registro[16] = rs.getString("estado_civil");
                registro[17] = rs.getString("fa_nombres");
                registro[18] = rs.getString("fa_apellidos");
                registro[19] = rs.getString("fa_edad");
                registro[20] = rs.getString("fa_direccion");
                registro[21] = rs.getString("digitador");
                registro[22] = rs.getString("fecha_registro");
                

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + " ERROR SELECT");
            return null;
        }

    }

    public boolean insertar(vpaciente dts) {

        sSQL = "insert into tap_paciente (historia_clinica,tipo_documento,"
                + "numero_documento,nombres,apellido_paterno,apellido_materno,"
                + "tipo_seguro,direccion,celular,"
                + "email,fecha_nacimiento,lugar_nac,lugar_proc,sexo,edad,estado_civil,"              
                + "fa_nombres,fa_apellidos,fa_edad,fa_direccion,digitador,fecha_registro)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

           
            pst.setString(1, dts.getHitoria_clinica());
            pst.setString(2, dts.getTipo_documento());
            pst.setString(3, dts.getNumero_documento());            
            pst.setString(4, dts.getNombres());
            pst.setString(5, dts.getApellido_paterno());
            pst.setString(6, dts.getApellido_materno());
            pst.setString(7, dts.getTipo_seguro());
            pst.setString(8, dts.getDireccion());
            pst.setString(9, dts.getCelular());
            pst.setString(10, dts.getEmail());
            pst.setString(11, dts.getFecha_nacimiento());
            pst.setString(12, dts.getLugar_nac());
            pst.setString(13, dts.getLugar_proc());
            pst.setString(14, dts.getSexo());
            pst.setString(15, dts.getEdad());
            pst.setString(16, dts.getEstado_civil());
            pst.setString(17, dts.getFa_nombres());
            pst.setString(18, dts.getFa_apellidos());
            pst.setString(19, dts.getFa_edad());
            pst.setString(20, dts.getFa_direccion());
            pst.setString(21, dts.getDigitador());
            pst.setString(22, dts.getFecha_registro());
            
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

    public boolean editar(vpaciente dts) {
        sSQL = "update tap_paciente set historia_clinica=?,"
                + "tipo_documento=?,numero_documento=?,nombres=?,apellido_paterno=?,apellido_materno=?,"
                + "tipo_seguro=?,direccion=?,celular=?,"
                + "email=?,fecha_nacimiento=?,lugar_nac=?,lugar_proc=?,"
                + "sexo=?,edad=?,estado_civil=?,"
                + "fa_nombres=?,fa_apellidos=?,fa_edad=?,fa_direccion=?"
                + " where idpaciente=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getHitoria_clinica());
            pst.setString(2, dts.getTipo_documento());
            pst.setString(3, dts.getNumero_documento());            
            pst.setString(4, dts.getNombres());
            pst.setString(5, dts.getApellido_paterno());
            pst.setString(6, dts.getApellido_materno());
            pst.setString(7, dts.getTipo_seguro());
            pst.setString(8, dts.getDireccion());
            pst.setString(9, dts.getCelular());
            pst.setString(10, dts.getEmail());
            pst.setString(11, dts.getFecha_nacimiento());
            pst.setString(12, dts.getLugar_nac());
            pst.setString(13, dts.getLugar_proc());
            pst.setString(14, dts.getSexo());
            pst.setString(15, dts.getEdad());
            pst.setString(16, dts.getEstado_civil());
            pst.setString(17, dts.getFa_nombres());
            pst.setString(18, dts.getFa_apellidos());
            pst.setString(19, dts.getFa_edad());
            pst.setString(20, dts.getFa_direccion());
            pst.setInt(21, dts.getIdpaciente());

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

    public boolean eliminar(vpaciente dts) {
        sSQL = "delete from tap_paciente where idpaciente=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdpaciente());

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
