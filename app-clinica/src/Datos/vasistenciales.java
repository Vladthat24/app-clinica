/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author root
 */
public class vasistenciales {
    
    private int idasistenciales;
    private String nombre;
    private String apellidos;
    private String cargo_institucion;
    private String modalidad_contrato;
    private String colegiatura;
    private String num_colegiatura;
    private String profesion;
    private String tipo_documento;
    private String num_documento;
    private String celular;
    private String email;
    private String fecha_registro;

    public vasistenciales() {
    }

    public vasistenciales(int idasistenciales, String nombre, String apellidos, String cargo_institucion, String modalidad_contrato, String colegiatura, String num_colegiatura, String profesion, String tipo_documento, String num_documento, String celular, String email, String fecha_registro) {
        this.idasistenciales = idasistenciales;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo_institucion = cargo_institucion;
        this.modalidad_contrato = modalidad_contrato;
        this.colegiatura = colegiatura;
        this.num_colegiatura = num_colegiatura;
        this.profesion = profesion;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.celular = celular;
        this.email = email;
        this.fecha_registro = fecha_registro;
    }

    public int getIdasistenciales() {
        return idasistenciales;
    }

    public void setIdasistenciales(int idasistenciales) {
        this.idasistenciales = idasistenciales;
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

    public String getCargo_institucion() {
        return cargo_institucion;
    }

    public void setCargo_institucion(String cargo_institucion) {
        this.cargo_institucion = cargo_institucion;
    }

    public String getModalidad_contrato() {
        return modalidad_contrato;
    }

    public void setModalidad_contrato(String modalidad_contrato) {
        this.modalidad_contrato = modalidad_contrato;
    }

    public String getColegiatura() {
        return colegiatura;
    }

    public void setColegiatura(String colegiatura) {
        this.colegiatura = colegiatura;
    }

    public String getNum_colegiatura() {
        return num_colegiatura;
    }

    public void setNum_colegiatura(String num_colegiatura) {
        this.num_colegiatura = num_colegiatura;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }


    
    
}
