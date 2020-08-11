/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Desarrollo
 */
public class vconstancia_nacimiento {
    
    private int idconstancia_nacimiento;
    private int idcasistenciales;
    private String correlativo_constancia;
    private String nombre;
    private String apellidos;
    private String tipo_doc;
    private String num_doc;
    private String direccion;
    private String historia_clinica;
    private String sexo;
    private String peso;
    private String talla;
    private Date fecha_nacimiento;
    private String hora_nacimiento;
    private String num_doc_nacido;
    private String fecha_nacimiento_letra;
    private String fecha_registro;
    private String iniciales;
    
    
    public vconstancia_nacimiento() {
    }

    public vconstancia_nacimiento(int idconstancia_nacimiento, int idcasistenciales, String correlativo_constancia, String nombre, String apellidos, String tipo_doc, String num_doc, String direccion, String historia_clinica, String sexo, String peso, String talla, Date fecha_nacimiento, String hora_nacimiento, String num_doc_nacido, String fecha_nacimiento_letra, String fecha_registro, String iniciales) {
        this.idconstancia_nacimiento = idconstancia_nacimiento;
        this.idcasistenciales = idcasistenciales;
        this.correlativo_constancia = correlativo_constancia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipo_doc = tipo_doc;
        this.num_doc = num_doc;
        this.direccion = direccion;
        this.historia_clinica = historia_clinica;
        this.sexo = sexo;
        this.peso = peso;
        this.talla = talla;
        this.fecha_nacimiento = fecha_nacimiento;
        this.hora_nacimiento = hora_nacimiento;
        this.num_doc_nacido = num_doc_nacido;
        this.fecha_nacimiento_letra = fecha_nacimiento_letra;
        this.fecha_registro = fecha_registro;
        this.iniciales = iniciales;
    }

    public int getIdconstancia_nacimiento() {
        return idconstancia_nacimiento;
    }

    public void setIdconstancia_nacimiento(int idconstancia_nacimiento) {
        this.idconstancia_nacimiento = idconstancia_nacimiento;
    }

    public int getIdcasistenciales() {
        return idcasistenciales;
    }

    public void setIdcasistenciales(int idcasistenciales) {
        this.idcasistenciales = idcasistenciales;
    }

    public String getCorrelativo_constancia() {
        return correlativo_constancia;
    }

    public void setCorrelativo_constancia(String correlativo_constancia) {
        this.correlativo_constancia = correlativo_constancia;
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

    public String getHistoria_clinica() {
        return historia_clinica;
    }

    public void setHistoria_clinica(String historia_clinica) {
        this.historia_clinica = historia_clinica;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getHora_nacimiento() {
        return hora_nacimiento;
    }

    public void setHora_nacimiento(String hora_nacimiento) {
        this.hora_nacimiento = hora_nacimiento;
    }

    public String getNum_doc_nacido() {
        return num_doc_nacido;
    }

    public void setNum_doc_nacido(String num_doc_nacido) {
        this.num_doc_nacido = num_doc_nacido;
    }

    public String getFecha_nacimiento_letra() {
        return fecha_nacimiento_letra;
    }

    public void setFecha_nacimiento_letra(String fecha_nacimiento_letra) {
        this.fecha_nacimiento_letra = fecha_nacimiento_letra;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

   
  
}
