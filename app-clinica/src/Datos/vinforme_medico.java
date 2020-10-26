/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Desarrollo
 */
public class vinforme_medico {

    private int idinforme_medico;
    private int idasistenciales;
    private int idpaciente;
    private String diagnostico;
    private String dias_descanso;
    private String fecha_registro;
    private String fecha_system;

    public vinforme_medico() {
    }

    public vinforme_medico(int idinforme_medico, int idasistenciales, int idpaciente, String diagnostico, String dias_descanso, String fecha_registro, String fecha_system) {
        this.idinforme_medico = idinforme_medico;
        this.idasistenciales = idasistenciales;
        this.idpaciente = idpaciente;
        this.diagnostico = diagnostico;
        this.dias_descanso = dias_descanso;
        this.fecha_registro = fecha_registro;
        this.fecha_system = fecha_system;
    }

    public int getIdinforme_medico() {
        return idinforme_medico;
    }

    public void setIdinforme_medico(int idinforme_medico) {
        this.idinforme_medico = idinforme_medico;
    }

    public int getIdasistenciales() {
        return idasistenciales;
    }

    public void setIdasistenciales(int idasistenciales) {
        this.idasistenciales = idasistenciales;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDias_descanso() {
        return dias_descanso;
    }

    public void setDias_descanso(String dias_descanso) {
        this.dias_descanso = dias_descanso;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_system() {
        return fecha_system;
    }

    public void setFecha_system(String fecha_system) {
        this.fecha_system = fecha_system;
    }

     
    
}
