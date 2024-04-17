/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;


import crudclinicadental.entity.PacienteEntiy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class PacientesDAO {
        private String mensaje="";
    
    public String agregarPaciente(Connection con, PacienteEntiy pacienteEntity){
        PreparedStatement pst = null;
        String sql = "INSERT INTO PACIENTE (ID_PACIENTE, NUM_CEDULA, NOM_PACIENTE, APELLIDOS_PACIENTE, DIRECCION, TELEFONO_P, ALERGIAS, ENFERM_CRONICAS) "
                + "VALUES(SECUENCIAPACIENTES.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pacienteEntity.getCedula());
            pst.setString(2, pacienteEntity.getNombre());
            pst.setString(3, pacienteEntity.getApellidos());
            pst.setString(4, pacienteEntity.getDireccion());
            pst.setInt(5, pacienteEntity.getTelefono());
            pst.setString(6, pacienteEntity.getAlegias());
            pst.setString(7, pacienteEntity.getEnfermedad());
            mensaje = "PACIENTE GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "EL PACIENTE NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarPaciente(Connection con, PacienteEntiy pacienteEntity) {
        PreparedStatement pst = null;
        String sql = "UPDATE PACIENTE SET NUM_CEDULA = ?, NOM_PACIENTE = ?, APELLIDOS_PACIENTE = ?, DIERECCION = ?,TELEFONO_P = ?, ALERGIAS = ?, ENFERM_CRONICAS = ?"
                + "WHERE ID_PACIENTE = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pacienteEntity.getCedula());
            pst.setString(2, pacienteEntity.getNombre());
            pst.setString(3, pacienteEntity.getApellidos());
            pst.setString(4, pacienteEntity.getDireccion());
            pst.setInt(5, pacienteEntity.getTelefono());
            pst.setString(6, pacienteEntity.getAlegias());
            pst.setString(7, pacienteEntity.getEnfermedad());
            mensaje = "PACIENTE GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "EL PACIENTE NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPaciente(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM PACIENTE WHERE ID_PACEINTE = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            mensaje = "EL PACIENTE SE HA ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "EL PACIENTE NO SE ELIMINO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public void listarPaciente(Connection Con, JTable tabla) {
    }
}
