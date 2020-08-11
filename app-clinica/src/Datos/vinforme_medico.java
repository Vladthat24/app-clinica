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
public class vinforme_medico {
    private int idinforme_medico;
    private int idiasistenciales;
    private String correlativo_informemedico;
    private String nombre_paciente;
    private String apellidos_paciente;
    private String historia_clinica;
    private String direccion;
    private String sexo;
    private String edad;
    private String tipo_documento;
    private String num_documento;
    private String fecha_registro;
    private String diagnostico;

    public vinforme_medico() {
    }

    public vinforme_medico(int idinforme_medico, int idiasistenciales, String correlativo_informemedico, String nombre_paciente, String apellidos_paciente, String historia_clinica, String direccion, String sexo, String edad, String tipo_documento, String num_documento, String fecha_registro, String diagnostico) {
        this.idinforme_medico = idinforme_medico;
        this.idiasistenciales = idiasistenciales;
        this.correlativo_informemedico = correlativo_informemedico;
        this.nombre_paciente = nombre_paciente;
        this.apellidos_paciente = apellidos_paciente;
        this.historia_clinica = historia_clinica;
        this.direccion = direccion;
        this.sexo = sexo;
        this.edad = edad;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.fecha_registro = fecha_registro;
        this.diagnostico = diagnostico;
    }

    public int getIdinforme_medico() {
        return idinforme_medico;
    }

    public void setIdinforme_medico(int idinforme_medico) {
        this.idinforme_medico = idinforme_medico;
    }

    public int getIdiasistenciales() {
        return idiasistenciales;
    }

    public void setIdiasistenciales(int idiasistenciales) {
        this.idiasistenciales = idiasistenciales;
    }

    public String getCorrelativo_informemedico() {
        return correlativo_informemedico;
    }

    public void setCorrelativo_informemedico(String correlativo_informemedico) {
        this.correlativo_informemedico = correlativo_informemedico;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellidos_paciente() {
        return apellidos_paciente;
    }

    public void setApellidos_paciente(String apellidos_paciente) {
        this.apellidos_paciente = apellidos_paciente;
    }

    public String getHistoria_clinica() {
        return historia_clinica;
    }

    public void setHistoria_clinica(String historia_clinica) {
        this.historia_clinica = historia_clinica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

   
}
