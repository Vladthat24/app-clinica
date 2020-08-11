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
    private int idcerasistenciales;
    private String nombre;
    private String apellidos;
    private String edad;
    private String tipo_doc;
    private String num_doc;
    private String direccion;
    private String serelogia;
    private String examen_rx;
    private String fecha_registro;

    public vcertificado_salud() {
    }

    public vcertificado_salud(int idcertificado_salud, int idcerasistenciales, String nombre, String apellidos, String edad, String tipo_doc, String num_doc, String direccion, String serelogia, String examen_rx, String fecha_registro) {
        this.idcertificado_salud = idcertificado_salud;
        this.idcerasistenciales = idcerasistenciales;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.tipo_doc = tipo_doc;
        this.num_doc = num_doc;
        this.direccion = direccion;
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

    public int getIdcerasistenciales() {
        return idcerasistenciales;
    }

    public void setIdcerasistenciales(int idcerasistenciales) {
        this.idcerasistenciales = idcerasistenciales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
