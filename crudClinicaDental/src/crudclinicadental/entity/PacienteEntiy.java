/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.entity;

/**
 *
 * @author Wstov
 */
public class PacienteEntiy {
    private int idPaciente;
    private int cedula;
    private String nombre;
    private String apellidos;
    private String direccion;
    private int telefono;
    private String alegias;
    private String enfermedad;

    public PacienteEntiy() {
    }

    public PacienteEntiy(int idPaciente, int cedula, String nombre, String apellidos, String direccion, int telefono, String alegias, String enfermedad) {
        this.idPaciente = idPaciente;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.alegias = alegias;
        this.enfermedad = enfermedad;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getAlegias() {
        return alegias;
    }

    public void setAlegias(String alegias) {
        this.alegias = alegias;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    @Override
    public String toString() {
        return "PacienteEntiy{" + "idPaciente=" + idPaciente + ", cedula=" + cedula + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", alegias=" + alegias + ", enfermedad=" + enfermedad + '}';
    }
    
    
    
}
