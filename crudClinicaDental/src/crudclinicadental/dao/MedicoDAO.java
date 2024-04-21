/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.db.Conexion;
import crudclinicadental.entity.MedicoEntity;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Wstov
 */
public class MedicoDAO {
    
    private String mensaje="";
    
    public String agregarMedico(Connection con, MedicoEntity med){
        PreparedStatement pst = null;
        String sql = "{ call Insertar_Medico(?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, med.getIdMedico());
            pst.setString(2, med.getNombre());
            pst.setString(3, med.getApellido());
            pst.setInt(4, med.getCedula());
            pst.setInt(5, med.getTelefono());
            pst.setString(6, med.getTurno());
            pst.setString(7, med.getEspecialidad());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
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
        } catch (SQLException  e) {
            mensaje = "NO SE ELIMINO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public void listarMedico(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","NOMBRE","APELLIDO","CEDULA","TELEFONO","TURNO","ESPECIALIDAD"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM MEDICOS ORDER BY ID_MEDICO";
        
        String [] filas = new String[7];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA");
        }
    }
    
    public int getMaxID(Connection con) {
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(ID_MEDICO)+1 as id FROM MEDICOS";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar id " + e.getMessage());
        }
        return id;
    }



}
