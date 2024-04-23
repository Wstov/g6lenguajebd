/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.entity;

import java.util.Date;

/**
 *
 * @author Wstov
 */
public class ComentariosEntity {
    private int idComentario;
    private int idCita;
    private int idPaciente;
    private Date fecha;
    private String comentario;

    public ComentariosEntity() {
    }

    public ComentariosEntity(int idComentario, int idCita, int idPaciente, Date fecha, String comentario) {
        this.idComentario = idComentario;
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "ComentariosEntity{" + "idComentario=" + idComentario + ", idCita=" + idCita + ", idPaciente=" + idPaciente + ", fecha=" + fecha + ", comentario=" + comentario + '}';
    }
    
    
}
