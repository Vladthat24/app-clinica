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
public class vfarmacia {
    
    private int idfarmacia;
    private String categoria;
    private String nombre;
    private double precio_venta;
    private int stock;
    private String laboratorio;
    private String presentacion;
    private String fecha_registro;
    private String fecha_vencimiento;

    public vfarmacia() {
    }

    public vfarmacia(int idfarmacia, String categoria, String nombre, double precio_venta, int stock, String laboratorio, String presentacion, String fecha_registro, String fecha_vencimiento) {
        this.idfarmacia = idfarmacia;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio_venta = precio_venta;
        this.stock = stock;
        this.laboratorio = laboratorio;
        this.presentacion = presentacion;
        this.fecha_registro = fecha_registro;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getIdfarmacia() {
        return idfarmacia;
    }

    public void setIdfarmacia(int idfarmacia) {
        this.idfarmacia = idfarmacia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    
    
    
    
}
