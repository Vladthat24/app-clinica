/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author VladHat
 */
public class vpaciente {
    
  private int idpaciente;
  private String hitoria_clinica;
  private String tipo_documento;
  private String numero_documento;
  private String nombres;
  private String apellido_paterno;
  private String apellido_materno;
  private String tipo_seguro;
  private String direccion;
  private String celular;
  private String email;
  private String fecha_nacimiento;
  private String lugar_nac;
  private String lugar_proc;
  private String sexo;
  private String edad;
  private String estado_civil;
  private String fa_nombres;
  private String fa_apellidos;
  private String fa_edad;
  private String fa_direccion;
  private String digitador;
  private String fecha_registro;

    public vpaciente() {
    }

    public vpaciente(int idpaciente, String hitoria_clinica, String tipo_documento, String numero_documento, String nombres, String apellido_paterno, String apellido_materno, String tipo_seguro, String direccion, String celular, String email, String fecha_nacimiento, String lugar_nac, String lugar_proc, String sexo, String edad, String estado_civil, String fa_nombres, String fa_apellidos, String fa_edad, String fa_direccion, String digitador, String fecha_registro) {
        this.idpaciente = idpaciente;
        this.hitoria_clinica = hitoria_clinica;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.tipo_seguro = tipo_seguro;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nac = lugar_nac;
        this.lugar_proc = lugar_proc;
        this.sexo = sexo;
        this.edad = edad;
        this.estado_civil = estado_civil;
        this.fa_nombres = fa_nombres;
        this.fa_apellidos = fa_apellidos;
        this.fa_edad = fa_edad;
        this.fa_direccion = fa_direccion;
        this.digitador = digitador;
        this.fecha_registro = fecha_registro;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getHitoria_clinica() {
        return hitoria_clinica;
    }

    public void setHitoria_clinica(String hitoria_clinica) {
        this.hitoria_clinica = hitoria_clinica;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getTipo_seguro() {
        return tipo_seguro;
    }

    public void setTipo_seguro(String tipo_seguro) {
        this.tipo_seguro = tipo_seguro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nac() {
        return lugar_nac;
    }

    public void setLugar_nac(String lugar_nac) {
        this.lugar_nac = lugar_nac;
    }

    public String getLugar_proc() {
        return lugar_proc;
    }

    public void setLugar_proc(String lugar_proc) {
        this.lugar_proc = lugar_proc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getFa_nombres() {
        return fa_nombres;
    }

    public void setFa_nombres(String fa_nombres) {
        this.fa_nombres = fa_nombres;
    }

    public String getFa_apellidos() {
        return fa_apellidos;
    }

    public void setFa_apellidos(String fa_apellidos) {
        this.fa_apellidos = fa_apellidos;
    }

    public String getFa_edad() {
        return fa_edad;
    }

    public void setFa_edad(String fa_edad) {
        this.fa_edad = fa_edad;
    }

    public String getFa_direccion() {
        return fa_direccion;
    }

    public void setFa_direccion(String fa_direccion) {
        this.fa_direccion = fa_direccion;
    }

    public String getDigitador() {
        return digitador;
    }

    public void setDigitador(String digitador) {
        this.digitador = digitador;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }



 
}

