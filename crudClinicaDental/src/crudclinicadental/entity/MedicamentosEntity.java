/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.entity;

/**
 *
 * @author Wstov
 */
public class MedicamentosEntity {
    private int idMedicamentos;
    private String nombre;
    private String tipo;
    private String dosis;
    private String descripcion;
    private int idproveedor;

    public MedicamentosEntity() {
    }

    public MedicamentosEntity(int idMedicamentos, String nombre, String tipo, String dosis, String descripcion, int idproveedor) {
        this.idMedicamentos = idMedicamentos;
        this.nombre = nombre;
        this.tipo = tipo;
        this.dosis = dosis;
        this.descripcion = descripcion;
        this.idproveedor = idproveedor;
    }

    public int getIdMedicamentos() {
        return idMedicamentos;
    }

    public void setIdMedicamentos(int idMedicamentos) {
        this.idMedicamentos = idMedicamentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    @Override
    public String toString() {
        return "MedicamentosEntity{" + "idMedicamentos=" + idMedicamentos + ", nombre=" + nombre + ", tipo=" + tipo + ", dosis=" + dosis + ", descripcion=" + descripcion + ", idproveedor=" + idproveedor + '}';
    }
    
    
}
