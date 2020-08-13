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
public class vcaja {
    
    private int idcaja;
    private int idconsultorio;
    private int idtrabajador;
    private double costo_consulta;
    private String fecha_registro;

    public vcaja() {
    }

    public vcaja(int idcaja, int idconsultorio, int idtrabajador, double costo_consulta, String fecha_registro) {
        this.idcaja = idcaja;
        this.idconsultorio = idconsultorio;
        this.idtrabajador = idtrabajador;
        this.costo_consulta = costo_consulta;
        this.fecha_registro = fecha_registro;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }

    public int getIdconsultorio() {
        return idconsultorio;
    }

    public void setIdconsultorio(int idconsultorio) {
        this.idconsultorio = idconsultorio;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public double getCosto_consulta() {
        return costo_consulta;
    }

    public void setCosto_consulta(double costo_consulta) {
        this.costo_consulta = costo_consulta;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
    
}
