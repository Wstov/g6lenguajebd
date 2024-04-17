/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.entity;

/**
 *
 * @author Wstov
 */
public class TratamientoEntity {
    private int idTratamiento;
    private String nombre;
    private String descripcion;
    private double costo;
    private int idInsumo;

    public TratamientoEntity() {
    }

    public TratamientoEntity(int idTratamiento, String nombre, String descripcion, double costo, int idInsumo) {
        this.idTratamiento = idTratamiento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.idInsumo = idInsumo;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    @Override
    public String toString() {
        return "TratamientoEntity{" + "idTratamiento=" + idTratamiento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", costo=" + costo + ", idInsumo=" + idInsumo + '}';
    }
    
    
}
