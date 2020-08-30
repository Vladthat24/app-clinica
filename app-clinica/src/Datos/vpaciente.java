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
    private String direccion;
    private String celular;
    private String fecha_nacimiento;
    private String lugar_proc;
    private String sexo;
    private String edad;
    private String estado_civil;
    private String ocupacion;
    private String antecedente_enfermedad;
    private String antec_operacion;
    private String reacc_medicamento;
    private String digitador;
    private String fecha_registro;

    public vpaciente() {
    }

    public vpaciente(int idpaciente, String hitoria_clinica, String tipo_documento, String numero_documento, String nombres, String apellido_paterno, String apellido_materno, String direccion, String celular, String fecha_nacimiento, String lugar_proc, String sexo, String edad, String estado_civil, String ocupacion, String antecedente_enfermedad, String antec_operacion, String reacc_medicamento, String digitador, String fecha_registro) {
        this.idpaciente = idpaciente;
        this.hitoria_clinica = hitoria_clinica;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.direccion = direccion;
        this.celular = celular;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_proc = lugar_proc;
        this.sexo = sexo;
        this.edad = edad;
        this.estado_civil = estado_civil;
        this.ocupacion = ocupacion;
        this.antecedente_enfermedad = antecedente_enfermedad;
        this.antec_operacion = antec_operacion;
        this.reacc_medicamento = reacc_medicamento;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getAntecedente_enfermedad() {
        return antecedente_enfermedad;
    }

    public void setAntecedente_enfermedad(String antecedente_enfermedad) {
        this.antecedente_enfermedad = antecedente_enfermedad;
    }

    public String getAntec_operacion() {
        return antec_operacion;
    }

    public void setAntec_operacion(String antec_operacion) {
        this.antec_operacion = antec_operacion;
    }

    public String getReacc_medicamento() {
        return reacc_medicamento;
    }

    public void setReacc_medicamento(String reacc_medicamento) {
        this.reacc_medicamento = reacc_medicamento;
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
