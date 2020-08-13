/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

public class vtrabajador{
    private int idtrabajador;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String profesion;
    private String cargo_institucion;
    private String modalidad_contrato;
    private String tipo_documento;
    private String num_documento;
    private String celular;
    private String email;
    private String fecha_registro;

    public vtrabajador() {
    }

    public vtrabajador(int idtrabajador, String nombre, String apaterno, String amaterno, String profesion, String cargo_institucion, String modalidad_contrato, String tipo_documento, String num_documento, String celular, String email, String fecha_registro) {
        this.idtrabajador = idtrabajador;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.profesion = profesion;
        this.cargo_institucion = cargo_institucion;
        this.modalidad_contrato = modalidad_contrato;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.celular = celular;
        this.email = email;
        this.fecha_registro = fecha_registro;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
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
