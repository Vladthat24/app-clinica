/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpimprimir;

import reports.*;
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


public class imprimir_descanso_medico {
    public Connection connection= new conexion().conectar();
    public void reporteImprimirDescMedico(int idinforme_medico){
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;
        try {

            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/rpimprimir/imprimir_descanso_medico.jrxml");
            p.put("idinforme_medico", idinforme_medico);
           
            print= JasperFillManager.fillReport(report, p,connection);
            JasperViewer view= new JasperViewer(print,false);
            view.setTitle("Centro Medico - Maria Santisima");
            view.setVisible(true);
            
        } catch (Exception e) {
            System.out.println("error "+e);
        }

    }

 
    
}
