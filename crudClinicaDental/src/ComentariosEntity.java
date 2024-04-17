
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Wstov
 */
public class ComentariosEntity {
    private int idComentario;
    private int idCita;
    private int idPaciente;
    private LocalDate fecha;
    private String comenterio;

    public ComentariosEntity() {
    }

    public ComentariosEntity(int idComentario, int idCita, int idPaciente, LocalDate fecha, String comenterio) {
        this.idComentario = idComentario;
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.comenterio = comenterio;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getComenterio() {
        return comenterio;
    }

    public void setComenterio(String comenterio) {
        this.comenterio = comenterio;
    }

    @Override
    public String toString() {
        return "ComentariosEntity{" + "idComentario=" + idComentario + ", idCita=" + idCita + ", idPaciente=" + idPaciente + ", fecha=" + fecha + ", comenterio=" + comenterio + '}';
    }
    
    
    
}
