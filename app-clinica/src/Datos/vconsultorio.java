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
public class vconsultorio {
    
    private int idconsultorio;
    private int idasistencial;
    private String nombre_consultorio;
    private String numero_consultorio;
    private String piso_consultorio;
    private String fecha_registro;

    public vconsultorio() {
    }

    public vconsultorio(int idconsultorio, int idasistencial, String nombre_consultorio, String numero_consultorio, String piso_consultorio, String fecha_registro) {
        this.idconsultorio = idconsultorio;
        this.idasistencial = idasistencial;
        this.nombre_consultorio = nombre_consultorio;
        this.numero_consultorio = numero_consultorio;
        this.piso_consultorio = piso_consultorio;
        this.fecha_registro = fecha_registro;
    }

    public int getIdconsultorio() {
        return idconsultorio;
    }

    public void setIdconsultorio(int idconsultorio) {
        this.idconsultorio = idconsultorio;
    }

    public int getIdasistencial() {
        return idasistencial;
    }

    public void setIdasistencial(int idasistencial) {
        this.idasistencial = idasistencial;
    }

    public String getNombre_consultorio() {
        return nombre_consultorio;
    }

    public void setNombre_consultorio(String nombre_consultorio) {
        this.nombre_consultorio = nombre_consultorio;
    }

    public String getNumero_consultorio() {
        return numero_consultorio;
    }

    public void setNumero_consultorio(String numero_consultorio) {
        this.numero_consultorio = numero_consultorio;
    }

    public String getPiso_consultorio() {
        return piso_consultorio;
    }

    public void setPiso_consultorio(String piso_consultorio) {
        this.piso_consultorio = piso_consultorio;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
            
            
    
}
