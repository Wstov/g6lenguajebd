/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.entity;

/**
 *
 * @author Wstov
 */
public class ProveedoresEntity {
    private int idProveedor;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;

    public ProveedoresEntity() {
    }

    public ProveedoresEntity(int idProveedor, String nombre, String telefono, String direccion, String email) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ProveedoresEntity{" + "idProveedor=" + idProveedor + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + '}';
    }
    
    
}
