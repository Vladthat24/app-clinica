/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import Logica.conexion;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;

/**
 *
 * @author Desarrollo
 */
public class reporte_caja {

    public Connection connection = new conexion().conectar();

    public void reportePacientes(String fecha_hoy) {
        Map p = new HashedMap();

        JasperReport report;
        JasperPrint print;
        try {

            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/reports/reporte_caja.jrxml");
            p.put("fecha_hoy", fecha_hoy);

            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Centro Medico - Maria Santisima");
            view.setVisible(true);

        } catch (Exception e) {
            System.out.println("error " + e);
        }

    }
    
        public void reporteCajaPorFechas(String fecha_incial, String fecha_final) {
        Map p = new HashedMap();

        JasperReport report;
        JasperPrint print;
        try {

            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/reports/reporte_caja_rangosfecha.jrxml");
            p.put("fecha_inicial", fecha_incial);
            p.put("fecha_final", fecha_final);
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Centro Medico - Maria Santisima");
            view.setVisible(true);

        } catch (Exception e) {
            System.out.println("error " + e);
        }

    }

}
