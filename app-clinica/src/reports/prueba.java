/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import Logica.conexion;
import java.sql.Connection;
import rpimprimir.imprimir_descanso_medico;

/**
 *
 * @author root
 */
public class prueba {

    public static Connection conecction;

    public static void main(String[] args) {
        try {
            Connection Connection = new conexion().conectar();
            System.out.println("Conectado");

            imprimir_descanso_medico g = new imprimir_descanso_medico();
            g.reporteImprimirDescMedico(1);

        } catch (Exception e) {
            System.out.println("error de prueba" + e);
        }

    }

}
