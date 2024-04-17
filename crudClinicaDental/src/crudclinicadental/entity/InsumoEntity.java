/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.entity;

import java.time.LocalDate;

/**
 *
 * @author Wstov
 */
public class InsumoEntity {
    private int idInsumo;
    private String nombreInsumo;
    private int costo;
    private String ubicacion;
    private LocalDate fechaVencimiento;

    public InsumoEntity() {
    }

    public InsumoEntity(int idInsumo, String nombreInsumo, int costo, String ubicacion, LocalDate fechaVencimiento) {
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
        this.costo = costo;
        this.ubicacion = ubicacion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "InsumoEntity{" + "idInsumo=" + idInsumo + ", nombreInsumo=" + nombreInsumo + ", costo=" + costo + ", ubicacion=" + ubicacion + ", fechaVencimiento=" + fechaVencimiento + '}';
    }
    
    
    
}
