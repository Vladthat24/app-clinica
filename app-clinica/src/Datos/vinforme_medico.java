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
    private String fecha_registro;

    public vinforme_medico() {
    }

    public vinforme_medico(int idinforme_medico, int idasistenciales, int idpaciente, String diagnostico, String fecha_registro) {
        this.idinforme_medico = idinforme_medico;
        this.idasistenciales = idasistenciales;
        this.idpaciente = idpaciente;
        this.diagnostico = diagnostico;
        this.fecha_registro = fecha_registro;
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

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }


}
