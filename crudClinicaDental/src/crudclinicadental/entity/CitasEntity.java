/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Wstov
 */
public class CitasEntity {
    private int idCita;
    private Date hora;
    private Date fecha;
    private String consultorio;
    private int idpaciente;
    private int idMedico;

    public CitasEntity() {
    }

    public CitasEntity(int idCita, Date hora, Date fecha, String consultorio, int idpaciente, int idMedico) {
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

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
