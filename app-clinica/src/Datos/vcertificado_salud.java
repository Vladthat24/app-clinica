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
public class vcertificado_salud {
    private int idcertificado_salud;
    private int idasistenciales;
    private int idpaciente;
    private String serelogia;
    private String examen_rx;
    private String fecha_registro;

    public vcertificado_salud() {
    }

    public vcertificado_salud(int idcertificado_salud, int idasistenciales, int idpaciente, String serelogia, String examen_rx, String fecha_registro) {
        this.idcertificado_salud = idcertificado_salud;
        this.idasistenciales = idasistenciales;
        this.idpaciente = idpaciente;
        this.serelogia = serelogia;
        this.examen_rx = examen_rx;
        this.fecha_registro = fecha_registro;
    }

    public int getIdcertificado_salud() {
        return idcertificado_salud;
    }

    public void setIdcertificado_salud(int idcertificado_salud) {
        this.idcertificado_salud = idcertificado_salud;
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

    public String getSerelogia() {
        return serelogia;
    }

    public void setSerelogia(String serelogia) {
        this.serelogia = serelogia;
    }

    public String getExamen_rx() {
        return examen_rx;
    }

    public void setExamen_rx(String examen_rx) {
        this.examen_rx = examen_rx;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    

   
    
}
