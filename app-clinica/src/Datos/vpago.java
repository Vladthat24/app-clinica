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
public class vpago {
    
    private int idpago;
    private int idcaja;
    private String tipo_comprobante;
    private String num_comprobante;
    private double igv;
    private double cantidad_pago;
    private double subtotal;
    private double total;
    private double vuelto;
    private String fecha_registro;
    private String hora;
    private String trabajador;

    public vpago() {
    }

    public vpago(int idpago, int idcaja, String tipo_comprobante, String num_comprobante, double igv, double cantidad_pago, double subtotal, double total, double vuelto, String fecha_registro, String hora, String trabajador) {
        this.idpago = idpago;
        this.idcaja = idcaja;
        this.tipo_comprobante = tipo_comprobante;
        this.num_comprobante = num_comprobante;
        this.igv = igv;
        this.cantidad_pago = cantidad_pago;
        this.subtotal = subtotal;
        this.total = total;
        this.vuelto = vuelto;
        this.fecha_registro = fecha_registro;
        this.hora = hora;
        this.trabajador = trabajador;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getNum_comprobante() {
        return num_comprobante;
    }

    public void setNum_comprobante(String num_comprobante) {
        this.num_comprobante = num_comprobante;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getCantidad_pago() {
        return cantidad_pago;
    }

    public void setCantidad_pago(double cantidad_pago) {
        this.cantidad_pago = cantidad_pago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }
 
    
    
    
}
