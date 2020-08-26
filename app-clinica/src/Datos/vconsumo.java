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
public class vconsumo {
    
    private int idconsumo;
    private int idcaja;
    private int idfarmacia;
    private int cantidad;
    private Double precio_venta;
    private String estado;
    private String fecha_registro;

    public vconsumo() {
    }

    public vconsumo(int idconsumo, int idcaja, int idfarmacia, int cantidad, Double precio_venta, String estado, String fecha_registro) {
        this.idconsumo = idconsumo;
        this.idcaja = idcaja;
        this.idfarmacia = idfarmacia;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
    }

    public int getIdconsumo() {
        return idconsumo;
    }

    public void setIdconsumo(int idconsumo) {
        this.idconsumo = idconsumo;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }

    public int getIdfarmacia() {
        return idfarmacia;
    }

    public void setIdfarmacia(int idfarmacia) {
        this.idfarmacia = idfarmacia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    
    
    
}
