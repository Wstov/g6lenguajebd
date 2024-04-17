/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.MedicoEntity;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JTable;
/**
 *
 * @author Wstov
 */
public class MedicoDAO {
    
    private String mensaje="";
    
    public String agregarMedico(Connection con, MedicoEntity med){
        PreparedStatement pst = null;
        String sql = "INSERT INTO MEDICOS (ID_MEDICO, NOM_MEDICO, APELLIDOS_MEDICO, CED_MEDICO, TELEFONO_M,TURNO,ESPECIALIDAD) "
                + "VALUES(MEDICOS_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, med.getNombre());
            pst.setString(2, med.getApellido());
            pst.setInt(3, med.getCedula());
            pst.setInt(4, med.getTelefono());
            pst.setString(5, med.getTurno());
            pst.setString(6, med.getEspecialidad());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarMedico(Connection con, MedicoEntity med) {
        PreparedStatement pst = null;
        String sql = "UPDATE MEDICOS SET NOM_MEDICO = ?, APELLIDOS_MEDICO = ?, CED_MEDICO = ?, TELEFONO_M = ?,TURNO = ?,ESPECIALIDAD = ?"
                + "WHERE ID_MEDICO = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, med.getNombre());
            pst.setString(2, med.getApellido());
            pst.setInt(3, med.getCedula());
            pst.setInt(4, med.getTelefono());
            pst.setString(5, med.getTurno());
            pst.setString(6, med.getEspecialidad());
            pst.setInt(7, med.getIdMedico());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarMedico(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM MEDICOS WHERE ID_MEDICO = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ELIMINO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public void listarMedico(Connection CON, JTable tabla) {
    }
}
