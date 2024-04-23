/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.entity;



import java.util.Date;
import java.time.LocalDateTime;

/**
 *
 * @author Wstov
 */
public class PagoEntity {
    private int idPago;
    private Date fecha;
    private Date hora;
    private int idPaciente;
    private int idMedico;
    private int idCita;
    private int idInsumo;
    private double pago;

    public PagoEntity() {
    }

    public PagoEntity(int idPago, Date fecha, Date hora, int idPaciente, int idMedico, int idCita, int idInsumo, double pago) {
        this.idPago = idPago;
        this.fecha = fecha;
        this.hora = hora;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idCita = idCita;
        this.idInsumo = idInsumo;
        this.pago = pago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "PagoEntity{" + "idPago=" + idPago + ", fecha=" + fecha + ", hora=" + hora + ", idPaciente=" + idPaciente + ", idMedico=" + idMedico + ", idCita=" + idCita + ", idInsumo=" + idInsumo + ", pago=" + pago + '}';
    }
    
    
    
            
            
}
