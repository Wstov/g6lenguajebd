/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Wstov
 */
public class CitasEntity {
    private int idCita;
    private LocalDateTime hora;
    private LocalDate fecha;
    private String consultorio;
    private int idpaciente;
    private int idMedico;

    public CitasEntity() {
    }

    public CitasEntity(int idCita, LocalDateTime hora, LocalDate fecha, String consultorio, int idpaciente, int idMedico) {
        this.idCita = idCita;
        this.hora = hora;
        this.fecha = fecha;
        this.consultorio = consultorio;
        this.idpaciente = idpaciente;
        this.idMedico = idMedico;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    @Override
    public String toString() {
        return "CitasEntity{" + "idCita=" + idCita + ", hora=" + hora + ", fecha=" + fecha + ", consultorio=" + consultorio + ", idpaciente=" + idpaciente + ", idMedico=" + idMedico + '}';
    }
    
    
    
}
