/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package con.registro.entity;

/**
 *
 * @author Wstov
 */
public class RegistroMedicoEntity {
    private int idMedico;
    private String nombre;
    private String Apellido;
    private int cedula;
    private int telefono;
    private String turno;
    private String especialidad;

    public RegistroMedicoEntity() {
    }

    public RegistroMedicoEntity(int idMedico, String nombre, String Apellido, int cedula, int telefono, String turno, String especialidad) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.turno = turno;
        this.especialidad = especialidad;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "RegistroMedicoEntity{" + "idMedico=" + idMedico + ", nombre=" + nombre + ", Apellido=" + Apellido + ", cedula=" + cedula + ", telefono=" + telefono + ", turno=" + turno + ", especialidad=" + especialidad + '}';
    }
    
    
         
}
