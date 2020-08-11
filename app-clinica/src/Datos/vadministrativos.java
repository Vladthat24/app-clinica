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
public class vadministrativos {
    private int idadministrativos;
    private String nombre;
    private String apellidos;
    private String cargo_institucion;
    private String modalidad_contrato;
    private String profesion;
    private String tipo_documento;
    private String num_documento;
    private String celular;
    private String fecha_registro;
    private String email;

    public vadministrativos() {
    }

    public vadministrativos(int idadministrativos, String nombre, String apellidos, String cargo_institucion, String modalidad_contrato, String profesion, String tipo_documento, String num_documento, String celular, String fecha_registro, String email) {
        this.idadministrativos = idadministrativos;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo_institucion = cargo_institucion;
        this.modalidad_contrato = modalidad_contrato;
        this.profesion = profesion;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.celular = celular;
        this.fecha_registro = fecha_registro;
        this.email = email;
    }

    public int getIdadministrativos() {
        return idadministrativos;
    }

    public void setIdadministrativos(int idadministrativos) {
        this.idadministrativos = idadministrativos;
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

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
