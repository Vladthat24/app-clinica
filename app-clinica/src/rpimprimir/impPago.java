/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpimprimir;

import Logica.conexion;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;

/**
 *
 * @author root
 */
public class impPago {

    public Connection connection = new conexion().conectar();

    public void ImpPago(int idpago) {
        Map p = new HashedMap();
        JasperReport report;
        JasperPrint print;
        try {

            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/rpimprimir/imprimir_pago.jrxml");
            p.put("idpago", idpago);
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle(".: Clinica Maria Santisima :.");
            view.setVisible(true);

        } catch (Exception e) {
            System.out.println("error " + e);
        }

    }

    public void ReporteHistoriaClinica(String fecha_inicial, String fecha_final) {
        Map p = new HashedMap();

        JasperReport report;
        JasperPrint print;
        try {

            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/reports/rpHistoriaClinica.jrxml");
            p.put("fecha_inicial", fecha_inicial);
            p.put("fecha_final", fecha_final);
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("C.M.I. Daniel Alcides Carrion");
            view.setVisible(true);

        } catch (Exception e) {
            System.out.println("error " + e);
        }

    }
}


