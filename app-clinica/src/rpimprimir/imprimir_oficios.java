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


public class imprimir_oficios {
    public Connection connection= new conexion().conectar();
    public void reportePacientes(int num_correlativo){
        Map p = new HashedMap();
        JasperReport report;
        JasperPrint print;
        try {

            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/rpimprimir/imprimir_oficio.jrxml");
            p.put("num_correlativo", num_correlativo);
           
            print= JasperFillManager.fillReport(report, p,connection);
            JasperViewer view= new JasperViewer(print,false);
            view.setTitle("C.M.I. Daniel Alcides Carrion");
            view.setVisible(true);
            
        } catch (Exception e) {
            System.out.println("error "+e);
        }

    }

 
    
}
