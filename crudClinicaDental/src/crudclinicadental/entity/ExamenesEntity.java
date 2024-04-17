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
public class ExamenesEntity {
    private int idExamenes;
    private String tipoExamen;
    private String resultado;
    private LocalDate fecha;
    private int idPaciente;

    public ExamenesEntity() {
    }

    public ExamenesEntity(int idExamenes, String tipoExamen, String resultado, LocalDate fecha, int idPaciente) {
        this.idExamenes = idExamenes;
        this.tipoExamen = tipoExamen;
        this.resultado = resultado;
        this.fecha = fecha;
        this.idPaciente = idPaciente;
    }

    public int getIdExamenes() {
        return idExamenes;
    }

    public void setIdExamenes(int idExamenes) {
        this.idExamenes = idExamenes;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return "ExamenesEntity{" + "idExamenes=" + idExamenes + ", tipoExamen=" + tipoExamen + ", resultado=" + resultado + ", fecha=" + fecha + ", idPaciente=" + idPaciente + '}';
    }
    
    
}
